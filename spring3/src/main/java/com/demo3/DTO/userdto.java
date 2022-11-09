package com.demo3.DTO;

public class userdto {

	private String username;
	
	
	private String password;
	
	
	private Boolean enabled;
	
	

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

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "userdto [username=" + username + ", password=" + password + ", enabled=" + enabled + "]";
	}
	
	
	
	
	
}
