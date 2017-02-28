package com.capgemini.chess.service;

import com.capgemini.chess.service.to.MatchTO;

public interface MatchHistoryUpdateService {
	
	MatchTO updateMatchHistory(MatchTO match);

}
