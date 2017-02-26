package com.capgemini.chess.dataaccess.entities;

public class UserEntity {

	private Long id;
	private String email;
	private String password;
	private ProfileEntity profile;
	private StatisticsEntity statistics;

	public StatisticsEntity getStatistics() {
		return statistics;
	}

	public void setStatistics(StatisticsEntity statistics) {
		this.statistics = statistics;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ProfileEntity getProfile() {
		return profile;
	}

	public void setProfile(ProfileEntity profile) {
		this.profile = profile;
	}
}
