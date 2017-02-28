package com.capgemini.chess.dataaccess.dao;

import java.util.List;

import com.capgemini.chess.service.to.MatchTO;

public interface MatchDao {
	
	MatchTO save(MatchTO match);

	List<MatchTO> findById(Long id);
	
	List<MatchTO> findAll();

}
