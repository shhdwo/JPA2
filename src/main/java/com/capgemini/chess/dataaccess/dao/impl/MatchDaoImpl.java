package com.capgemini.chess.dataaccess.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.chess.dataaccess.dao.MatchDao;
import com.capgemini.chess.dataaccess.entities.MatchEntity;
import com.capgemini.chess.dataaccess.source.MapDataSource;
import com.capgemini.chess.service.mapper.MatchMapper;
import com.capgemini.chess.service.to.MatchTO;

@Repository
public class MatchDaoImpl implements MatchDao {
	
	@Autowired
	private MapDataSource dataSource;

	@Override
	public MatchTO save(MatchTO to) {
		MatchEntity entity = MatchMapper.map(to);
		long id = generateNextId();
		entity.setId(id);
		dataSource.getMatches().put(id, entity);
		return MatchMapper.map(entity);
	}

	@Override
	public List<MatchTO> findById(Long id) {
		Map<Long, MatchEntity> entities = dataSource.getMatches();
		List<MatchEntity> entitiesList = new ArrayList<MatchEntity>();
		for (MatchEntity me : entities.values()) {
			if (me.getPlayer1().equals(id) || me.getPlayer2().equals(id)) entitiesList.add(me);
		}
		return MatchMapper.map2TOs(entitiesList);
	}

	@Override
	public List<MatchTO> findAll() {
		Map<Long, MatchEntity> entities = dataSource.getMatches();
		List<MatchEntity> entitiesList = new ArrayList<MatchEntity>();
		for (MatchEntity me : entities.values()) {
			entitiesList.add(me);
		}
		return MatchMapper.map2TOs(entitiesList);
	}
	
	private long generateNextId() {
		Optional<Long> max = dataSource.getMatches().keySet().stream().max((i1, i2) -> i1.compareTo(i2));
		return max.orElse(0L) + 1;
	}

}
