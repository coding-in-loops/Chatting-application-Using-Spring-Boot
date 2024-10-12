package com.coding_in_loops.websockets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coding_in_loops.websockets.model.ChatMessage;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long>{

}
