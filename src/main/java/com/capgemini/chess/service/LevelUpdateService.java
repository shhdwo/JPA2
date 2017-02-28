package com.capgemini.chess.service;

import java.util.Map;

import com.capgemini.chess.enums.Level;
import com.capgemini.chess.service.to.MatchTO;

public interface LevelUpdateService {
	
	Map<String, Level> updateLevel(MatchTO to);

}
