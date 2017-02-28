package com.capgemini.chess.service;

import java.util.Map;

import com.capgemini.chess.service.to.MatchTO;

public interface PlayerRankingUpdateService {
	
	Map<Long, Integer> updateRanking(MatchTO to);

}
