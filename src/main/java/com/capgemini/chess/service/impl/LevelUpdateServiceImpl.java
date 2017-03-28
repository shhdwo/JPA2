package com.capgemini.chess.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dataaccess.dao.UserDao;
import com.capgemini.chess.enums.Level;
import com.capgemini.chess.service.LevelUpdateService;
import com.capgemini.chess.service.to.MatchTO;
import com.capgemini.chess.service.to.StatisticsTO;
import com.capgemini.chess.service.to.UserTO;

@Service
public class LevelUpdateServiceImpl implements LevelUpdateService {

	@Autowired
	private UserDao userDao;

	@Override
	public Map<String, Level> updateLevel(MatchTO to) {
		Long p1 = to.getPlayer1().getId();
		Long p2 = to.getPlayer2().getId();
		Level levelP1 = calculateLevel(p1, to.getPoints1());
		Level levelP2 = calculateLevel(p2, to.getPoints2());
		Map<String, Level> updatedLvls = new HashMap<>();
		updatedLvls.put("Player1", levelP1);
		updatedLvls.put("Player2", levelP2);
		return updatedLvls;
	}

	private Level calculateLevel(Long p, int points) {
		UserTO user = userDao.findOne(p);
		StatisticsTO userStats = user.getStatistics();
		userStats = updateGameStats(points, userStats);
		user.setStatistics(userStats);
		userDao.update(user);
		Level updatedLevel = changeLevel(user);
		user.getStatistics().setLevel(updatedLevel);
		userDao.update(user);
		return updatedLevel;
	}

	private StatisticsTO updateGameStats(int points, StatisticsTO userStats) {
		if (points > 0) userStats.setGamesWon(userStats.getGamesWon() + 1);
		else if (points < 0) userStats.setGamesLost(userStats.getGamesLost() + 1);
		else if (points == 0) userStats.setGamesDrawn(userStats.getGamesDrawn() + 1);
		userStats.setPoints(userStats.getPoints() + points);
		return userStats;
	}

	private Level changeLevel(UserTO to) { 
		Level updatedLvl = null;
		for (Level lvl : Level.values()) {
			int gamesPlayed = to.getStatistics().getGamesDrawn() + to.getStatistics().getGamesLost()
					+ to.getStatistics().getGamesWon();
			float winPercentage = (float)to.getStatistics().getGamesWon() / gamesPlayed;
			if (lvl.getPointsRequired() <= to.getStatistics().getPoints()
					&& lvl.getGamesPlayedRequired() <= gamesPlayed 
					&& lvl.getWinPercentageRequired() <= winPercentage) {
				updatedLvl = lvl;
			}
			else break;
		}
		return updatedLvl;
	}

}
