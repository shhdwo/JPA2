package com.capgemini.chess.dataaccess.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.chess.dataaccess.entities.MatchEntity;
import com.capgemini.chess.dataaccess.source.MapDataSource;
import com.capgemini.chess.service.to.MatchTO;

@RunWith(MockitoJUnitRunner.class)
public class MatchDaoImplTest {

	@InjectMocks
	private MatchDaoImpl dao;

	@Mock
	private MapDataSource dataSource;

	@Test
	public void shouldSetIdOfSavedMatchTo1WhenNoMatchesYet() {
		// given
		MatchTO match = new MatchTO();
		Mockito.when(dataSource.getMatches()).thenReturn(new HashMap<>());

		// when
		MatchTO savedMatch = dao.save(match);

		// then
		Assert.assertEquals(savedMatch.getId(), new Long(1));
	}

	@Test
	public void shouldGenerateAvailableIdWhenMatchesExists() {
		// given
		MatchTO match = new MatchTO();
		Mockito.when(dataSource.getMatches()).thenReturn(giveMatchesMap());

		// when
		MatchTO savedMatch = dao.save(match);

		// then
		Assert.assertEquals(savedMatch.getId(), new Long(101));
	}

	@Test
	public void shouldInsertSavedUserIntoDataSource() {
		// given
		MatchTO match = new MatchTO();
		Mockito.when(dataSource.getMatches()).thenReturn(giveMatchesMap());

		// when
		MatchTO savedMatch = dao.save(match);

		// then
		Assert.assertNotNull(dataSource.getMatches().get(savedMatch.getId()));
	}

	@Test
	public void shouldFindUserMatchesById() {
		// given
		Mockito.when(dataSource.getMatches()).thenReturn(giveMatchesMap());

		// when
		List<MatchTO> userMatches = dao.findById(666L);
		int expectedSize = 2;

		// then
		Assert.assertEquals(expectedSize, userMatches.size());
	}

	@Test
	public void shouldNotFindMatchesWhenIdDoesNotExist() {
		// given
		Mockito.when(dataSource.getMatches()).thenReturn(giveMatchesMap());

		// when
		List<MatchTO> userMatches = dao.findById(999L);
		int expectedSize = 0;

		// then
		Assert.assertEquals(expectedSize, userMatches.size());
	}

	private Map<Long, MatchEntity> giveMatchesMap() {
		HashMap<Long, MatchEntity> matches = new HashMap<Long, MatchEntity>();
		matches.put(1L, giveMatch1());
		matches.put(5L, giveMatch2());
		matches.put(100L, giveMatch3());
		return matches;
	}

	private MatchEntity giveMatch1() {
		MatchEntity match = new MatchEntity();
		match.setId(1L);
		match.setPlayer1(13L);
		match.setPlayer2(666L);
		return match;
	}

	private MatchEntity giveMatch2() {
		MatchEntity match = new MatchEntity();
		match.setId(1L);
		match.setPlayer1(13L);
		match.setPlayer2(44L);
		return match;
	}

	private MatchEntity giveMatch3() {
		MatchEntity match = new MatchEntity();
		match.setId(1L);
		match.setPlayer1(666L);
		match.setPlayer2(13L);
		return match;
	}

}
