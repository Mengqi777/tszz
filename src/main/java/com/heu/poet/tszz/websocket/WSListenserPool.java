package com.heu.poet.tszz.websocket;


import org.springframework.web.socket.WebSocketSession;

import java.util.concurrent.ConcurrentHashMap;

public enum WSListenserPool {
    INSTANCE;
    private ConcurrentHashMap<String,WebSocketSession> pool=new ConcurrentHashMap<>();
    private int onlineCount=0;


    public int getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(int onlineCount) {
        this.onlineCount = onlineCount;
    }


    public void onlineCountAdd(){
        this.onlineCount++;
    }

    public void onlineCountRemove(){
        this.onlineCount--;
    }

    public ConcurrentHashMap<String, WebSocketSession> getPool() {
        return pool;
    }

    public void setPool(ConcurrentHashMap<String, WebSocketSession> pool) {
        this.pool = pool;
    }

    public void listenserAdd(String nickName, WebSocketSession session){
        this.pool.put(nickName,session);
    }

    public void listenserRemove(String nickName,WebSocketSession session){
        this.pool.remove(nickName,session);
    }
}
