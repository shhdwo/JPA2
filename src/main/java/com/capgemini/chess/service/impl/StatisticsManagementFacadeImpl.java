package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.service.StatisticsManagementFacade;
import com.capgemini.chess.service.to.MatchTO;

@Service
public class StatisticsManagementFacadeImpl implements StatisticsManagementFacade {

	@Autowired
	private PointsCalculationServiceImpl pointsCalculationService;
	
	@Override
	public void updateStatistics(MatchTO to) {
		MatchTO calculatedMatchTO = pointsCalculationService.calculatePoints(to);
	}

}
