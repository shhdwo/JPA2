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
		UserTO player1 = new UserTO();
		player1.setId(13L);
		UserTO player2 = new UserTO();
		player2.setId(666L);
		match.setPlayer1(player1);
		match.setPlayer2(player2);
		match.setResult(MatchWinner.PLAYER1);
		Mockito.when(userDao.findOne(13L)).thenReturn(giveUser1());
		Mockito.when(userDao.findOne(666L)).thenReturn(giveUser2());
		
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
		stats.setLevel(Level.WEAKLING);
		stats.setGamesWon(4);
		stats.setGamesLost(6);
		stats.setGamesDrawn(0);
		user.setStatistics(stats);
		return user;
	}
	
	private UserTO giveUser2() {
		UserTO user = new UserTO();
		StatisticsTO stats = new StatisticsTO();
		stats.setLevel(Level.ADVANCED);
		stats.setGamesWon(200);
		stats.setGamesLost(110);
		stats.setGamesDrawn(3);
		user.setStatistics(stats);
		return user;
	}

}
