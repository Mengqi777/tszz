package com.heu.poet.tszz.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author MengQi
 * @create 2018-02-23 14:01
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer{

//    @Bean
//    public ServerEndpointExporter serverEndpointExporter() {
//        return new ServerEndpointExporter();
//    }
//
    @Bean
    public MyWebSocketHandler webSocketHandler(){
        return new MyWebSocketHandler();
    }


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(webSocketHandler(),"/websocket")
                .addInterceptors(new HttpSessionHandshakeInterceptor());
    }
}
