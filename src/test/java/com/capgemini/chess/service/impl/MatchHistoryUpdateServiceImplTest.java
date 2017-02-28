package com.capgemini.chess.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.chess.dataaccess.dao.MatchDao;
import com.capgemini.chess.enums.MatchWinner;
import com.capgemini.chess.service.to.MatchTO;

@RunWith(MockitoJUnitRunner.class)
public class MatchHistoryUpdateServiceImplTest {
	
	@InjectMocks
	private MatchHistoryUpdateServiceImpl service;
	
	@Mock
	private MatchDao matchDao;
	
	@Captor
	private ArgumentCaptor<MatchTO> matchCaptor;

	
	@Test
	public void shouldAddMatchToHistory() {
		// given 
		MatchTO match = new MatchTO(); 
		// when
		service.updateMatchHistory(match);
		// then
		Mockito.verify(matchDao).save(matchCaptor.capture());
	}
	
	@Test
	public void shouldAddMatchToHistoryWithSpecifiedParams() {
		// given 
		MatchTO match = giveMatch(); 
		// when
		service.updateMatchHistory(match);
		MatchWinner expectedResult = MatchWinner.PLAYER1;
		Long expectedP1 = 13L;
		Long expectedP2 = 666L;
		int expectedPoints1 = 1280;
		int expectedPoints2 = -980;
		// then
		Mockito.verify(matchDao).save(matchCaptor.capture());
		Assert.assertEquals(expectedResult, matchCaptor.getValue().getResult());
		Assert.assertEquals(expectedP1, matchCaptor.getValue().getPlayer1());
		Assert.assertEquals(expectedP2, matchCaptor.getValue().getPlayer2());
		Assert.assertEquals(expectedPoints1, matchCaptor.getValue().getPoints1());
		Assert.assertEquals(expectedPoints2, matchCaptor.getValue().getPoints2());
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
