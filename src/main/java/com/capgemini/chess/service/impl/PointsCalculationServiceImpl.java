package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dataaccess.dao.UserDao;
import com.capgemini.chess.enums.MatchWinner;
import com.capgemini.chess.service.PointsCalculationService;
import com.capgemini.chess.service.to.MatchTO;
import com.capgemini.chess.service.to.StatisticsTO;

@Service
public class PointsCalculationServiceImpl implements PointsCalculationService {

	@Autowired
	private UserDao userDao;

	@Override
	public MatchTO calculatePoints(MatchTO to) {
		StatisticsTO p1 = userDao.findOne(to.getPlayer1().getId()).getStatistics();
		StatisticsTO p2 = userDao.findOne(to.getPlayer2().getId()).getStatistics();
		return calculateBase(calculateLvlGap(to, p1, p2), to);
	}

	private int calculateLvlGap(MatchTO to, StatisticsTO p1, StatisticsTO p2) {
		int lvlGap = 0;
		int lvlPlayer1 = p1.getLevel().getLevel();
		int lvlPlayer2 = p2.getLevel().getLevel();
		if (to.getResult() == MatchWinner.PLAYER1)
			lvlGap = lvlPlayer2 - lvlPlayer1;
		else if (to.getResult() == MatchWinner.PLAYER2)
			lvlGap = lvlPlayer1 - lvlPlayer2;
		return lvlGap;
	}

	private MatchTO calculateBase(int lvlGap, MatchTO to) {
		MatchWinner result = to.getResult();
		if (result == MatchWinner.DRAW)
			return to;
		MatchTO calculatedTO = basePointsFromTable(lvlGap, to);
		return calculatedTO;
	}

	private MatchTO basePointsFromTable(int lvlGap, MatchTO to) {
		MatchWinner result = to.getResult();
		int winner = 0;
		int loser = 0;
		switch (lvlGap) {
		case -9: case -8: case -7: case -6: case -5:
			winner = 1;
			loser = -1;
			break;
		case -4:
			winner = 2;
			loser = -1;
			break;
		case -3:
			winner = 5;
			loser = -3;
			break;
		case -2:
			winner = 10;
			loser = -7;
			break;
		case -1:
			winner = 20;
			loser = -15;
			break;
		case 0:
			winner = 40;
			loser = -30;
			break;
		case 1:
			winner = 80;
			loser = -60;
			break;
		case 2:
			winner = 160;
			loser = -120;
			break;
		case 3:
			winner = 320;
			loser = -240;
			break;
		case 4:
			winner = 640;
			loser = -480;
			break;
		case 5:
			winner = 1280;
			loser = -960;
			break;
		case 6:
			winner = 2560;
			loser = -1920;
			break;
		case 7:
			winner = 5120;
			loser = -3840;
			break;
		case 8:
			winner = 10240;
			loser = -7680;
			break;
		case 9:
			winner = 20480;
			loser = -15360;
			break;
		}
		if (result == MatchWinner.PLAYER1) {
			to.setPoints1(winner);
			to.setPoints2(loser);
		} else if (result == MatchWinner.PLAYER2) {
			to.setPoints1(loser);
			to.setPoints2(winner);
		}
		return to;
	}

}
