package com.naren.springmvc.dao;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

	@NotNull
	@Size(min=5)
	private String username;
	@Size(min=6)
	private String password;
	private boolean enable;
	private String authorization;
	
	public User(){
		
	}
	
	public User(String username, String password, boolean enable, String authorization) {
		this.username = username;
		this.password = password;
		this.enable = enable;
		this.authorization = authorization;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public String getAuthorization() {
		return authorization;
	}
	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", enable=" + enable + ", authorization="
				+ authorization + "]";
	}
	
}
