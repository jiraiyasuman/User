package com.springboot_restful_webservices.exception;

public class UserErrorResponse {

	private int status;
	private long timestamp;
	private String message;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public UserErrorResponse(int status, long timestamp, String message) {
		super();
		this.status = status;
		this.timestamp = timestamp;
		this.message = message;
	}
	public UserErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
