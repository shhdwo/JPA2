package com.capgemini.chess.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.chess.dataaccess.dao.UserDao;
import com.capgemini.chess.service.to.StatisticsTO;
import com.capgemini.chess.service.to.UserTO;


@RunWith(MockitoJUnitRunner.class)
public class PlayerRankingUpdateServiceImplTest {
	
	@InjectMocks
	private PlayerRankingUpdateServiceImpl service;
	
	@Mock
	private UserDao userDao;
	
	@Test
	public void shouldUpdateRanking() {
		// given
		Mockito.when(userDao.findAll()).thenReturn(giveUsers());
		// when
		Map<Long, Integer> updatedRanking = service.updateRanking();
		Integer expected1 = 3;
		Integer expected2 = 1;
		Integer expected3 = 2;
		// then
		Assert.assertEquals(expected1, updatedRanking.get(13L));
		Assert.assertEquals(expected2, updatedRanking.get(666L));
		Assert.assertEquals(expected3, updatedRanking.get(44L));
	}
	
	private List<UserTO> giveUsers() {
		List<UserTO> users = new ArrayList<UserTO>();
		users.add(giveUser1());
		users.add(giveUser2());
		users.add(giveUser3());
		return users;
	}
	
	private UserTO giveUser1() {
		UserTO user = new UserTO();
		StatisticsTO stats = new StatisticsTO();
		stats.setPoints(10);
		user.setStatistics(stats);
		user.setId(13L);
		return user;
	}
	
	private UserTO giveUser2() {
		UserTO user = new UserTO();
		StatisticsTO stats = new StatisticsTO();
		stats.setPoints(10580);
		user.setStatistics(stats);
		user.setId(666L);
		return user;
	}
	
	private UserTO giveUser3() {
		UserTO user = new UserTO();
		StatisticsTO stats = new StatisticsTO();
		stats.setPoints(555);
		user.setStatistics(stats);
		user.setId(44L);
		return user;
	}
}
