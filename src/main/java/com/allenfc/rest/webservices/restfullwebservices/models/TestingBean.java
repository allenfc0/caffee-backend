package com.allenfc.rest.webservices.restfullwebservices.models;

public class TestingBean {
	
	private String message;
	
	public TestingBean(String message) {
		this.message = message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public String toString() {
		return String.format("TestingBean [message=%s]", message);
	}
}
