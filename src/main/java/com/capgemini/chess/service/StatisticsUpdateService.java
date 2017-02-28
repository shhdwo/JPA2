package com.capgemini.chess.service;

import com.capgemini.chess.service.to.MatchTO;

public interface StatisticsUpdateService {
	
	void updateStatistics(MatchTO to);

}
