package com.dequiz.DeQuiz.Websocket;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.StompSubProtocolHandler;


@Component
public class WebSocketListener {
	 @Autowired
	    private SimpMessageSendingOperations messagingTemplate;

	    @EventListener
	    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
	    }


	    @EventListener
	    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
	        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

	        Integer quizId = (Integer) headerAccessor.getSessionAttributes().get("wsQuizId");
	        if(quizId != null) {
/*	            DQChatMessage chatMessage = new DQChatMessage();
	            chatMessage.setType("Leave");
	            chatMessage.setSender(username);

	            messagingTemplate.convertAndSend("/topic/public", chatMessage);
*//*	        }
	    }
}*/
