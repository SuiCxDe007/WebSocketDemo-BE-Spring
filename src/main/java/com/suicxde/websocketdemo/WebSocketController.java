package com.suicxde.websocketdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {

    @Autowired
    private PresenceEventListener eventListener;

    @GetMapping("/active-connections")
    public int getActiveConnections() {
        return eventListener.getActiveConnections();
    }
}