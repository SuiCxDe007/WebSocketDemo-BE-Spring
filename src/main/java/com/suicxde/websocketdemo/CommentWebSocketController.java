package com.suicxde.websocketdemo;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class CommentWebSocketController {


    private final SimpMessagingTemplate messagingTemplate;

    public CommentWebSocketController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }


    @MessageMapping("/comment")
    public void processComment(CommentDto comment) {
        messagingTemplate.convertAndSend("/topic/comments/" + comment.getAssignmentId() , comment);
    }

}
