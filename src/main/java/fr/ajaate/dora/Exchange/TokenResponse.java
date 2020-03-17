package fr.ajaate.dora.Exchange;

import java.util.List;

public class TokenResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private  String name ;
	private  String familyname;
	private String email;
	private List<String> roles;

	public TokenResponse(String accessToken, Long id, String email, List<String> roles, String name, String familyname) {
		this.token = accessToken;
		this.id = id;
		this.email = email;
		this.roles = roles;
		this.name=name;
	this.familyname=familyname;}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getRoles() {
		return roles;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamilyname() {
		return familyname;
	}

	public void setFamilyname(String familyname) {
		this.familyname = familyname;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
}
