package com.capgemini.chess.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.service.StatisticsManagementFacade;
import com.capgemini.chess.service.StatisticsUpdateService;
import com.capgemini.chess.service.to.MatchTO;

@Service
@Transactional
public class StatisticsManagementFacadeImpl implements StatisticsManagementFacade {
	
	@Autowired
	private StatisticsUpdateService service;
	
	@Override
	public void update(MatchTO to) {
		service.updateStatistics(to);
	}

}
