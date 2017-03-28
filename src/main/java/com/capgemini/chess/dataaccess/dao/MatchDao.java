package com.capgemini.chess.dataaccess.dao;

import java.util.List;

import com.capgemini.chess.service.to.MatchTO;

public interface MatchDao extends Dao<MatchTO, Long> {

	List<MatchTO> findByUserId(Long id);

}
