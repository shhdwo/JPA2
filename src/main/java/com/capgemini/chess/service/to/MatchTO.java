package com.capgemini.chess.service.to;

import com.capgemini.chess.enums.MatchWinner;

public class MatchTO {
	
	private UserTO player1;
	private UserTO player2;
	private int points1;
	private int points2;
	private MatchWinner result;

	public UserTO getPlayer1() {
		return player1;
	}

	public void setPlayer1(UserTO player1) {
		this.player1 = player1;
	}

	public UserTO getPlayer2() {
		return player2;
	}

	public void setPlayer2(UserTO player2) {
		this.player2 = player2;
	}

	public int getPoints1() {
		return points1;
	}

	public void setPoints1(int points1) {
		this.points1 = points1;
	}

	public int getPoints2() {
		return points2;
	}

	public void setPoints2(int points2) {
		this.points2 = points2;
	}

	public MatchWinner getResult() {
		return result;
	}

	public void setResult(MatchWinner result) {
		this.result = result;
	}

}
