package com.capgemini.chess.service.to;

public class UserTO {

	private Long id;
	private String email;
	private String password;
	private ProfileTO profile;

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

	public ProfileTO getProfile() {
		return profile;
	}

	public void setProfile(ProfileTO profile) {
		this.profile = profile;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
}
