package fr.ajaate.dora.payload.request;

import javax.validation.constraints.NotBlank;

public class LogoutRequest {
	@NotBlank
	private String token;

	@NotBlank
	private  String username ;

	public String getToken() {
		return token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
