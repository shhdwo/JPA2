package com.capgemini.chess.enums;

public enum Level {
	NEWBIE(1, "Newbie", 0, 0, 0F), 
	WEAKLING(2, "Weakling", 301, 5, 0.08F), 
	BEGINNER(3, "Beginner", 601, 20, 0.16F), 
	EXPERIENCED_BEGINNER(4, "Experienced Beginner", 1201, 45, 0.24F), 
	MIDDLEBROW(5, "Middlebrow", 2401, 80, 0.32F),
	EXPERIENCED_MIDDLEBROW(6, "Experienced Middlebrow", 4801, 125, 0.40F),
	ADVANCED(7, "Advanced", 9601, 180, 0.48F),
	PROFESSIONAL(8, "Professional", 19201, 245, 0.56F),
	MASTER(9, "Master", 31401, 320, 0.64F),
	CHUCK_NORRIS_OF_CHESS(10, "Chuck Norris of Chess", 76801, 405, 0.72F);
	
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
