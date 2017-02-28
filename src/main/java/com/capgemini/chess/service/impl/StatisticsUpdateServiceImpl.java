package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.chess.service.StatisticsUpdateService;
import com.capgemini.chess.service.to.MatchTO;

public class StatisticsUpdateServiceImpl implements StatisticsUpdateService {
	
	@Autowired
	private PointsCalculationServiceImpl pointsCalculationService;
	
	@Autowired
	private LevelUpdateServiceImpl levelUpdateService;
	
	@Autowired
	private PlayerRankingUpdateServiceImpl rankingUpdateService;
	
	@Autowired
	private MatchHistoryUpdateServiceImpl matchHistoryUpdateService;

	@Override
	public void updateStatistics(MatchTO to) {
		MatchTO calculatedMatchTO = pointsCalculationService.calculatePoints(to);
		levelUpdateService.updateLevel(calculatedMatchTO);
		rankingUpdateService.updateRanking();
		matchHistoryUpdateService.updateMatchHistory(calculatedMatchTO);
	}

}
