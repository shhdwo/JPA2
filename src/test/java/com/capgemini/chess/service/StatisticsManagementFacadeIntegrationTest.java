package com.capgemini.chess.service;

import javax.transaction.Transactional;

import static org.fest.assertions.api.Assertions.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.chess.ChessApplication;
import com.capgemini.chess.dataaccess.dao.MatchDao;
import com.capgemini.chess.dataaccess.dao.UserDao;
import com.capgemini.chess.enums.Level;
import com.capgemini.chess.enums.MatchWinner;
import com.capgemini.chess.service.to.MatchTO;
import com.capgemini.chess.service.to.UserTO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ChessApplication.class)
@Transactional
public class StatisticsManagementFacadeIntegrationTest {

	@Autowired
	private StatisticsUpdateService service;
	
	@Autowired
	private PointsCalculationService pointsCalcService;
	
	@Autowired
	private UserDao dao;
	
	@Autowired
	private MatchDao matchDao;
	
	@Test
	public void shouldCalculatePoints() {
		// given
		MatchTO matchTO = giveMatch();
		
		// when
		MatchTO calculatedMatch = pointsCalcService.calculatePoints(matchTO);
		
		// then
		assertThat(calculatedMatch.getPoints1()).isEqualTo(40);
		assertThat(calculatedMatch.getPoints2()).isEqualTo(-30);
	}
	
	@Test
	public void shouldUpdateLevel() {
		// given
		MatchTO matchTO = giveMatch();
		
		// when
		service.updateStatistics(matchTO);
		UserTO p1 = dao.findOne(1L);
		UserTO p2 = dao.findOne(2L);
		
		// then
		assertThat(p1.getStatistics().getLevel()).isEqualTo(Level.BEGINNER);
		assertThat(p2.getStatistics().getLevel()).isEqualTo(Level.NEWBIE);
	}
	
	@Test
	public void shouldAddMatchToHistory() {
		// given
		MatchTO matchTO = giveMatch();
		
		// when
		service.updateStatistics(matchTO);
		List<MatchTO> foundMatches = matchDao.findAll();
		List<MatchTO> p1matches = matchDao.findByUserId(1L);	
		
		// then
		assertThat(foundMatches).hasSize(3);
		assertThat(p1matches).hasSize(3);
		assertThat(p1matches.get(2).getResult()).isEqualTo(MatchWinner.PLAYER1);
	}
	
	private MatchTO giveMatch() {
		MatchTO matchTO = new MatchTO();
		matchTO.setPlayer1(dao.findOne(1L));
		matchTO.setPlayer2(dao.findOne(2L));
		matchTO.setResult(MatchWinner.PLAYER1);
		return matchTO;
	}
	
}
