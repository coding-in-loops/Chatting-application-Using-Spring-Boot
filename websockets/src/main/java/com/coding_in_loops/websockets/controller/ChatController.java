package com.coding_in_loops.websockets.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.coding_in_loops.websockets.model.ChatMessage;
import com.coding_in_loops.websockets.service.ChatMessageService;

@Controller
public class ChatController {

	 @Autowired
	  private ChatMessageService chatMessageService;

	 
	@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		chatMessage.setTimestamp(LocalDateTime.now());
		return chatMessage;
	}
	
	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		chatMessage.setTimestamp(LocalDateTime.now());
		ChatMessage savedMessage = chatMessageService.saveMessage(chatMessage);
		return savedMessage;
	}
}
