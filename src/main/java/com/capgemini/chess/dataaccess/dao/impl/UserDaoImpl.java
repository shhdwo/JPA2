package com.capgemini.chess.dataaccess.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.chess.dataaccess.dao.UserDao;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.dataaccess.source.MapDataSource;
import com.capgemini.chess.service.mapper.UserMapper;
import com.capgemini.chess.service.to.UserTO;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private MapDataSource dataSource;

	@Override
	public UserTO save(UserTO to) {
		UserEntity entity = UserMapper.map(to);
		long id = generateNextId();
		entity.setId(id);
		dataSource.getUsers().put(id, entity);
		return UserMapper.map(entity);
	}
	
	@Override
	public UserTO update(UserTO to) {
		UserEntity entity = UserMapper.map(to);
		long id = entity.getId();
		dataSource.getUsers().put(id, entity);
		return UserMapper.map(entity);
	}

	@Override
	public UserTO findByEmail(String email) {
		UserEntity user = dataSource.getUsers().values().stream().filter(u -> u.getEmail().equals(email)).findFirst()
				.orElse(null);
		return UserMapper.map(user);
	}

	@Override
	public UserTO find(Long id) {
		return UserMapper.map(dataSource.getUsers().get(id));
	}

	@Override
	public List<UserTO> findAll() {
		Map<Long, UserEntity> entities = dataSource.getUsers();
		List<UserEntity> entitiesList = new ArrayList<UserEntity>();
		for (UserEntity ue : entities.values()) {
			entitiesList.add(ue);
		}
		return UserMapper.map2TOs(entitiesList);
	}

	private long generateNextId() {
		Optional<Long> max = dataSource.getUsers().keySet().stream().max((i1, i2) -> i1.compareTo(i2));
		return max.orElse(0L) + 1;
	}
}
