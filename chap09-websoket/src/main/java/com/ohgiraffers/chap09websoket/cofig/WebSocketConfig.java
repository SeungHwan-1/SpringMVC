package com.ohgiraffers.chap09websoket.cofig;

import com.ohgiraffers.chap09websoket.server.ChatWebSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //자동으로 어떻게 접근했을대 해주겠다. 웹소켓 핸들러를 등록하는 메소드
        registry.addHandler(new ChatWebSocketHandler(),
                "/chattingServer").setAllowedOrigins("*");
    }
}
