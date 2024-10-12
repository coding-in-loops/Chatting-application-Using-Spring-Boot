package com.coding_in_loops.websockets.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class ChatMessage {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotEmpty
	private String content;
	@NotEmpty
	private String sender;
	private MessageType type;
	private LocalDateTime timestamp;
	
	public enum MessageType{
		CHAT,LEAVE,JOIN
	}
	
	public ChatMessage() {}

	public ChatMessage(String content, String sender, MessageType type, LocalDateTime timestamp) {
	    this.content = content;
	    this.sender = sender;
	    this.type = type;
	    this.timestamp = timestamp;
	}
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}
	
	public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
	
}
