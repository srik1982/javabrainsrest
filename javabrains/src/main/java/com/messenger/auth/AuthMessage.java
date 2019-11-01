package com.messenger.auth;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AuthMessage {
	private String message;
	private String description;
	
	
	
	public AuthMessage(String message, String description) {
		super();
		this.message = message;
		this.description = description;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
