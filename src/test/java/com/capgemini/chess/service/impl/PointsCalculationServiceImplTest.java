package com.capgemini.chess.service.impl;

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
public class PointsCalculationServiceImplTest {
	
	@InjectMocks
	private PointsCalculationServiceImpl service;
	
	@Mock
	private UserDao userDao;
	
	@Test
	public void shouldCalculatePoints() {
		// given
		MatchTO match = new MatchTO();
		match.setPlayer1(13L);
		match.setPlayer2(666L);
		match.setResult(MatchWinner.PLAYER1);
		Mockito.when(userDao.find(13L)).thenReturn(giveUser1());
		Mockito.when(userDao.find(666L)).thenReturn(giveUser2());
		
		// when
		MatchTO calculatedMatchTO = service.calculatePoints(match);
		int expected1 = 1280;
		int expected2 = -960;
		
		// then
		Assert.assertEquals(expected1, calculatedMatchTO.getPoints1());
		Assert.assertEquals(expected2, calculatedMatchTO.getPoints2());
	}
	
	private UserTO giveUser1() {
		UserTO user = new UserTO();
		StatisticsTO stats = new StatisticsTO();
		stats.setLvl(Level.Weakling);
		stats.setGamesWon(4);
		stats.setGamesLost(6);
		stats.setGamesDrawn(0);
		user.setStatistics(stats);
		return user;
	}
	
	private UserTO giveUser2() {
		UserTO user = new UserTO();
		StatisticsTO stats = new StatisticsTO();
		stats.setLvl(Level.Advanced);
		stats.setGamesWon(200);
		stats.setGamesLost(110);
		stats.setGamesDrawn(3);
		user.setStatistics(stats);
		return user;
	}

}
