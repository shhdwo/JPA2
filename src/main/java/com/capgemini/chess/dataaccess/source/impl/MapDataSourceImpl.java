package com.capgemini.chess.dataaccess.source.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.capgemini.chess.dataaccess.entities.MatchEntity;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.dataaccess.source.MapDataSource;

@Component
public class MapDataSourceImpl implements MapDataSource {

	private Map<Long, UserEntity> users = new HashMap<Long, UserEntity>();
	private Map<Long, MatchEntity> matches = new HashMap<Long, MatchEntity>();

	@Override
	public Map<Long, UserEntity> getUsers() {
		return users;
	}

	@Override
	public Map<Long, MatchEntity> getMatches() {
		return matches;
	}

}
