package com.messenger.exception;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MyException {
	int exceptionCode;
	String message;
	String description;
	
	public MyException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyException(int exceptionCode, String message, String description) {
		super();
		this.exceptionCode = exceptionCode;
		this.message = message;
		this.description = description;
	}
	public int getExceptionCode() {
		return exceptionCode;
	}
	public void setExceptionCode(int exceptionCode) {
		this.exceptionCode = exceptionCode;
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
