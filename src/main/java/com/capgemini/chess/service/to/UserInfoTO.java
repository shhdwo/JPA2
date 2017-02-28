package com.capgemini.chess.service.to;

import java.util.List;

import com.capgemini.chess.enums.Level;

public class UserInfoTO {

	private Long userId;
	private String name;
	private String surname;
	private String aboutMe;
	private String lifeMotto;
	private int points;
	private Level lvl;
	private int gamesWon;
	private int gamesLost;
	private int gamesDrawn;
	private int position;
	private List<UserTO> ranking;
	private List<MatchTO> playerHistory;

	public List<UserTO> getRanking() {
		return ranking;
	}

	public void setRanking(List<UserTO> ranking) {
		this.ranking = ranking;
	}

	public List<MatchTO> getPlayerHistory() {
		return playerHistory;
	}

	public void setPlayerHistory(List<MatchTO> playerHistory) {
		this.playerHistory = playerHistory;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public String getLifeMotto() {
		return lifeMotto;
	}

	public void setLifeMotto(String lifeMotto) {
		this.lifeMotto = lifeMotto;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Level getLvl() {
		return lvl;
	}

	public void setLvl(Level lvl) {
		this.lvl = lvl;
	}

	public int getGamesWon() {
		return gamesWon;
	}

	public void setGamesWon(int gamesWon) {
		this.gamesWon = gamesWon;
	}

	public int getGamesLost() {
		return gamesLost;
	}

	public void setGamesLost(int gamesLost) {
		this.gamesLost = gamesLost;
	}

	public int getGamesDrawn() {
		return gamesDrawn;
	}

	public void setGamesDrawn(int gamesDrawn) {
		this.gamesDrawn = gamesDrawn;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}
