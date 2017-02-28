package com.capgemini.chess.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.chess.dataaccess.dao.MatchDao;
import com.capgemini.chess.dataaccess.dao.UserDao;
import com.capgemini.chess.enums.Level;
import com.capgemini.chess.enums.MatchWinner;
import com.capgemini.chess.service.to.MatchTO;
import com.capgemini.chess.service.to.ProfileTO;
import com.capgemini.chess.service.to.StatisticsTO;
import com.capgemini.chess.service.to.UserInfoTO;
import com.capgemini.chess.service.to.UserTO;


@RunWith(MockitoJUnitRunner.class)
public class UserShowServiceImplTest {
	
	@InjectMocks
	private UserShowServiceImpl service;
	
	@Mock
	private UserDao userDao;
	
	@Mock
	private MatchDao matchDao;
	
	@Test
	public void shouldReturnUserInfoTO() {
		// given
		Mockito.when(userDao.find(13L)).thenReturn(giveUser());
		Mockito.when(userDao.findAll()).thenReturn(giveUsers());
		Mockito.when(matchDao.findById(13L)).thenReturn(giveHistory());
		// when
		UserInfoTO userInfo = service.showUser(13L);
		// then
		Assert.assertEquals(giveUser().getProfile().getAboutMe(), userInfo.getAboutMe());
		Assert.assertEquals(giveUser().getStatistics().getGamesDrawn(), userInfo.getGamesDrawn());
		Assert.assertEquals(giveUser().getStatistics().getGamesLost(), userInfo.getGamesLost());
		Assert.assertEquals(giveUser().getStatistics().getGamesWon(), userInfo.getGamesWon());
		Assert.assertEquals(giveUser().getProfile().getLifeMotto(), userInfo.getLifeMotto());
		Assert.assertEquals(giveUser().getStatistics().getLvl(), userInfo.getLvl());
		Assert.assertEquals(giveUser().getProfile().getName(), userInfo.getName());
		Assert.assertEquals(giveUser().getStatistics().getPoints(), userInfo.getPoints());
		Assert.assertEquals(giveUser().getStatistics().getPosition(), userInfo.getPosition());
		Assert.assertEquals(giveUser().getProfile().getSurname(), userInfo.getSurname());
		Assert.assertEquals(giveUser().getId(), userInfo.getUserId());
		Assert.assertEquals(giveHistory().size(), userInfo.getPlayerHistory().size());
		Assert.assertEquals(giveUsers().size(), userInfo.getRanking().size());
	}
	
	private UserTO giveUser() {
		UserTO user = new UserTO();
		user.setId(13L);
		user.setEmail("bla@bla.pl");
		user.setPassword("12345678");
		ProfileTO profile = new ProfileTO();
		profile.setId(1L);
		profile.setName("Elvis");
		profile.setSurname("Presley");
		profile.setAboutMe("Im alive!");
		profile.setLifeMotto("I'm not trying to be sexy. It's just my way of expressing myself when I move around.");
		StatisticsTO stats = new StatisticsTO();
		stats.setId(2L);
		stats.setLvl(Level.CHUCK_NORRIS_OF_CHESS);
		stats.setPoints(1234567);
		stats.setPosition(1);
		stats.setGamesDrawn(1);
		stats.setGamesLost(0);
		stats.setGamesWon(9999);
		user.setProfile(profile);
		user.setStatistics(stats);
		return user;
	}
	
	private List<UserTO> giveUsers() {
		List<UserTO> ranking = new ArrayList<UserTO>();
		ranking.add(giveUser());
		return ranking;
	}
	
	private List<MatchTO> giveHistory() {
		List<MatchTO> history = new ArrayList<MatchTO>();
		history.add(giveMatch());
		return history;
	}
	
	private MatchTO giveMatch() {
		MatchTO match = new MatchTO();
		match.setPlayer1(13L);
		match.setPlayer2(666L);
		match.setResult(MatchWinner.PLAYER1);
		match.setPoints1(1280);
		match.setPoints2(-980);
		return match;
	}
	

}
