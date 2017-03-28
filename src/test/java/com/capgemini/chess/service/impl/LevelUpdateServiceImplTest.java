package com.capgemini.chess.service.impl;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.chess.dataaccess.dao.UserDao;
import com.capgemini.chess.enums.Level;
import com.capgemini.chess.enums.MatchWinner;
import com.capgemini.chess.service.to.MatchTO;
import com.capgemini.chess.service.to.StatisticsTO;
import com.capgemini.chess.service.to.UserTO;

@RunWith(MockitoJUnitRunner.class)
public class LevelUpdateServiceImplTest {
	
	@InjectMocks
	private LevelUpdateServiceImpl service;
	
	@Mock
	private UserDao userDao;
	
	@Test
	public void shouldCalculateLevel() {
		// given
		MatchTO match = giveMatch();
		Mockito.when(userDao.findOne(13L)).thenReturn(giveUser1());
		Mockito.when(userDao.findOne(666L)).thenReturn(giveUser2());
		// when
		Map<String, Level> updatedLvls = service.updateLevel(match);
		Level expected1 = Level.WEAKLING;
		Level expected2 = Level.EXPERIENCED_MIDDLEBROW;
		//then
		Assert.assertEquals(expected1, updatedLvls.get("Player1"));
		Assert.assertEquals(expected2, updatedLvls.get("Player2"));
	}
	
	private MatchTO giveMatch() {
		MatchTO match = new MatchTO();
		UserTO player1 = new UserTO();
		player1.setId(13L);
		UserTO player2 = new UserTO();
		player2.setId(666L);
		match.setPlayer1(player1);
		match.setPlayer2(player2);
		match.setResult(MatchWinner.PLAYER1);
		match.setPoints1(1280);
		match.setPoints2(-980);
		return match;
	}
	
	private UserTO giveUser1() {
		UserTO user = new UserTO();
		StatisticsTO stats = new StatisticsTO();
		stats.setLevel(Level.NEWBIE);
		stats.setGamesWon(4);
		stats.setGamesLost(6);
		stats.setGamesDrawn(0);
		stats.setPoints(10);
		user.setStatistics(stats);
		user.setId(13L);
		return user;
	}
	
	private UserTO giveUser2() {
		UserTO user = new UserTO();
		StatisticsTO stats = new StatisticsTO();
		stats.setLevel(Level.ADVANCED);
		stats.setGamesWon(200);
		stats.setGamesLost(110);
		stats.setGamesDrawn(3);
		stats.setPoints(10580);
		user.setStatistics(stats);
		user.setId(666L);
		return user;
	}

}
