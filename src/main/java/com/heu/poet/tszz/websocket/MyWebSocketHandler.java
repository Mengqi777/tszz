package com.heu.poet.tszz.websocket;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author MengQi
 * @create 2018-02-23 14:02
 */

@Component
@ServerEndpoint(value = "websocket")
public class MyWebSocketHandler implements WebSocketHandler {


    private String nickName;
    private WebSocketSession session;
    private WSListenserPool listenserPool = WSListenserPool.INSTANCE;

    private String getNickName() {
        return nickName;
    }

    private void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public WebSocketSession getSession() {
        return session;
    }

    public void setSession(WebSocketSession session) {
        this.session = session;
    }


    private void refreshUsers() throws IOException {
        ConcurrentHashMap<String, WebSocketSession> pool = listenserPool.getPool();
        ServerMsgPojo serverMsgPojo = new ServerMsgPojo();
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        for (String nickName : pool.keySet()) {
            System.out.println("还剩下的有效的" + nickName);
            serverMsgPojo.setFrom("server");
            serverMsgPojo.setType("userList");
            serverMsgPojo.setData(parser.parse(pool.keySet().toString()).getAsJsonArray());
            pool.get(nickName).sendMessage(new TextMessage(gson.toJson(serverMsgPojo, ServerMsgPojo.class)));
        }
    }


    private void removeUnavailable() {
        Map<String, WebSocketSession> removeMap = new HashMap<>();
        ConcurrentHashMap<String, WebSocketSession> pool = listenserPool.getPool();
        for (String key : pool.keySet()) {
            WebSocketSession session = pool.get(key);
            if (!session.isOpen()) {
                removeMap.put(key, session);
            }
        }
        for (String key : removeMap.keySet()) {
            listenserPool.listenserRemove(key, removeMap.get(key));
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        String queryStr = webSocketSession.getUri().getQuery();
        this.setNickName(queryStr.substring(9, queryStr.length()));
        this.setSession(webSocketSession);
        System.out.println(this.getNickName() + "  " + this.getSession());
        listenserPool.listenserAdd(this.getNickName(), webSocketSession);
        try {
            refreshUsers();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        ConcurrentHashMap<String, WebSocketSession> pool = listenserPool.getPool();
        Collection<WebSocketSession> values = pool.values();
        values.forEach(value -> {
            try {
                value.sendMessage(webSocketMessage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        removeUnavailable();
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {

        removeUnavailable();
        try {
            System.out.println("closed and refreshUsers");
            refreshUsers();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
