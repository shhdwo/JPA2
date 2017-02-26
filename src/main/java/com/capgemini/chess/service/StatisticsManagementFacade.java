package com.capgemini.chess.service;

import com.capgemini.chess.service.to.MatchTO;

public interface StatisticsManagementFacade {
	
	void updateStatistics(MatchTO to);

}
