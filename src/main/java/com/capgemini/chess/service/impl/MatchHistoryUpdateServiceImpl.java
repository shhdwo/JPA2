package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dataaccess.dao.MatchDao;
import com.capgemini.chess.service.MatchHistoryUpdateService;
import com.capgemini.chess.service.to.MatchTO;

@Service
public class MatchHistoryUpdateServiceImpl implements MatchHistoryUpdateService {
	
	@Autowired
	private MatchDao matchDao;

	@Override
	public MatchTO updateMatchHistory(MatchTO match) {
		matchDao.save(match);
		return match;
	}

}
