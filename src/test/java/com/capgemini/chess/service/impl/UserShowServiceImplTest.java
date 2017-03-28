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

import com.capgemini.chess.comparator.PointsComparator;
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
		Mockito.when(userDao.findOne(13L)).thenReturn(giveUser());
		List<UserTO> users = giveUsers();
		users.sort(new PointsComparator());
		Mockito.when(userDao.findAllAndOrderByPoints()).thenReturn(users);
		Mockito.when(matchDao.findByUserId(13L)).thenReturn(giveHistory());
		// when
		UserInfoTO userInfo = service.showUser(13L);
		// then
		Assert.assertEquals(giveUser().getProfile().getAboutMe(), userInfo.getAboutMe());
		Assert.assertEquals(giveUser().getStatistics().getGamesDrawn(), userInfo.getGamesDrawn());
		Assert.assertEquals(giveUser().getStatistics().getGamesLost(), userInfo.getGamesLost());
		Assert.assertEquals(giveUser().getStatistics().getGamesWon(), userInfo.getGamesWon());
		Assert.assertEquals(giveUser().getProfile().getLifeMotto(), userInfo.getLifeMotto());
		Assert.assertEquals(giveUser().getStatistics().getLevel(), userInfo.getLvl());
		Assert.assertEquals(giveUser().getProfile().getName(), userInfo.getName());
		Assert.assertEquals(giveUser().getStatistics().getPoints(), userInfo.getPoints());
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
		stats.setLevel(Level.MASTER);
		stats.setPoints(1234567);
		stats.setGamesDrawn(1);
		stats.setGamesLost(0);
		stats.setGamesWon(9999);
		user.setProfile(profile);
		user.setStatistics(stats);
		return user;
	}
	
	private UserTO giveUser2() {
		UserTO user = new UserTO();
		user.setId(44L);
		user.setEmail("bla@bla.pl");
		user.setPassword("12345678");
		ProfileTO profile = new ProfileTO();
		profile.setId(2L);
		profile.setName("Chuck");
		profile.setSurname("Norris");
		profile.setAboutMe("Im not playing chess. Its chess playing Chuck Norris.");
		profile.setLifeMotto("There is no opponent you cant beat with roundhouse kick.");
		StatisticsTO stats = new StatisticsTO();
		stats.setId(1L);
		stats.setLevel(Level.CHUCK_NORRIS_OF_CHESS);
		stats.setPoints(2005670);
		stats.setGamesDrawn(1);
		stats.setGamesLost(1);
		stats.setGamesWon(555);
		user.setProfile(profile);
		user.setStatistics(stats);
		return user;
	}
	
	private List<UserTO> giveUsers() {
		List<UserTO> ranking = new ArrayList<UserTO>();
		ranking.add(giveUser());
		ranking.add(giveUser2());
		return ranking;
	}
	
	private List<MatchTO> giveHistory() {
		List<MatchTO> history = new ArrayList<MatchTO>();
		history.add(giveMatch());
		history.add(giveMatch2());
		return history;
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
	
	private MatchTO giveMatch2() {
		MatchTO match = new MatchTO();
		UserTO player1 = new UserTO();
		player1.setId(13L);
		UserTO player2 = new UserTO();
		player2.setId(44L);
		match.setPlayer1(player1);
		match.setPlayer2(player2);
		match.setResult(MatchWinner.PLAYER1);
		match.setPoints1(1);
		match.setPoints2(-1);
		return match;
	}
	

}
