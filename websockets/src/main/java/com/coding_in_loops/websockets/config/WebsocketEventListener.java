package com.coding_in_loops.websockets.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.coding_in_loops.websockets.model.ChatMessage;

@Component
public class WebsocketEventListener {

	private static final Logger log = LoggerFactory.getLogger(WebsocketEventListener.class);
	
	@Autowired
	private SimpMessageSendingOperations messageTemplate;
	
	@EventListener
	public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
		StompHeaderAccessor headerAccessor=StompHeaderAccessor.wrap(event.getMessage());
		String username=(String) headerAccessor.getSessionAttributes().get("username");
		if(username!=null) {
			log.info("User disconnected: {}",username);
			ChatMessage chatMessage = new ChatMessage();
            chatMessage.setType(ChatMessage.MessageType.LEAVE);
            chatMessage.setSender(username);
			messageTemplate.convertAndSend("/topic/public",chatMessage);
		}
	}
}
