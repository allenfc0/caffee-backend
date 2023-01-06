package com.allenfc.rest.webservices.restfullwebservices.security;

public class BasicAuthentication {
	
	/*
	 * codes:
	 * 	100 - informational response (Auto set to constructor)
	 * 	200 - successful response
	 * 	400 - client error response/Invalid username/password
	 * 	500 - server error response
	 * 	
	 */
	private Integer status;
	private String message;
	private String token;
	
	public BasicAuthentication(Integer status) {
		this.status = status;
		this.message = "Refresh Page";
		this.token ="";
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
