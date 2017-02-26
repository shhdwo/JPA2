package com.capgemini.chess.service;

import com.capgemini.chess.service.to.MatchTO;

public interface PointsCalculationService {
	
	MatchTO calculatePoints(MatchTO to);

}
