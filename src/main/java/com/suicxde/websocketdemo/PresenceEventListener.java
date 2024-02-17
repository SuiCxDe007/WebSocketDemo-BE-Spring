package com.suicxde.websocketdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class PresenceEventListener {

    private final AtomicInteger activeConnections = new AtomicInteger(0);
    private static final Logger logger = LoggerFactory.getLogger(PresenceEventListener.class);

    @EventListener
    private void handleSessionConnected(SessionConnectEvent event) {
        logger.info("Client Connected at:{}, client: {}",new Date(event.getTimestamp()) , event.getSource());
        activeConnections.incrementAndGet();
    }

    @EventListener
    private void handleSessionDisconnect(SessionDisconnectEvent event) {
        logger.info("Client Disconnected :{}, client: {}",new Date(event.getTimestamp()), event.getSource());
        activeConnections.decrementAndGet();
    }

    int getActiveConnections(){
        return activeConnections.get();
    }
}


