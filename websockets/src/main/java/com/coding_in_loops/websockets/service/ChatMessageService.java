package com.coding_in_loops.websockets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding_in_loops.websockets.model.ChatMessage;
import com.coding_in_loops.websockets.repository.ChatMessageRepository;

@Service
public class ChatMessageService {

	 	@Autowired
	    private ChatMessageRepository chatMessageRepository;

	    public ChatMessage saveMessage(ChatMessage chatMessage) {
	        chatMessage.setTimestamp(java.time.LocalDateTime.now()); // Set the timestamp when the message is saved
	        return chatMessageRepository.save(chatMessage);
	    }
}
