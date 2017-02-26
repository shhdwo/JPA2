package com.capgemini.chess.enums;

public enum Level {
	Newbie(1, "Newbie", 0, 0, 0F), 
	Weakling(2, "Weakling", 301, 5, 0.08F), 
	Beginner(3, "Beginner", 601, 20, 0.16F), 
	ExperiencedBeginner(4, "Experienced Beginner", 1201, 45, 0.24F), 
	Middlebrow(5, "Middlebrow", 2401, 80, 0.32F),
	ExperiencedMiddlebrow(6, "Experienced Middlebrow", 4801, 125, 0.40F),
	Advanced(7, "Advanced", 9601, 180, 0.48F),
	Professional(8, "Professional", 19201, 245, 0.56F),
	Master(9, "Master", 31401, 320, 0.64F),
	ChuckNorrisOfChess(10, "Chuck Norris of Chess", 76801, 405, 0.72F);
	
	private final int lvl;
	private final String name;
	private final int pointsRequired;
	private final int gamesPlayedRequired;
	private final float winPercentageRequired;
	
	private Level(int lvl, String name, int pointsRequired, int gamesPlayedRequired, float winPercentageRequired) {
		this.lvl = lvl;
		this.name = name;
		this.pointsRequired = pointsRequired;
		this.gamesPlayedRequired = gamesPlayedRequired;
		this.winPercentageRequired = winPercentageRequired;
	}
	
	public String getName() {
		return name;
	}

	public float getWinPercentageRequired() {
		return winPercentageRequired;
	}

	public int getGamesPlayedRequired() {
		return gamesPlayedRequired;
	}

	public int getLvl() {
		return lvl;
	}
	
	public int getPointsRequired() {
		return pointsRequired;
	}
}
