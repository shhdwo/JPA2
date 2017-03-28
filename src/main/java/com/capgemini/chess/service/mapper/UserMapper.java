package com.capgemini.chess.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.to.UserTO;

@Service
public class UserMapper implements Mapper<UserEntity, UserTO> {

	@Autowired
	ProfileMapper profileMapper;
	
	@Autowired
	StatisticsMapper statisticsMapper;
	
	public UserTO map2To(UserEntity entity) {
		if (entity != null) {
			UserTO to = new UserTO();
			to.setId(entity.getId());
			to.setEmail(entity.getEmail());
			to.setPassword(entity.getPassword());
			to.setProfile(profileMapper.map2To(entity.getProfile()));
			to.setStatistics(statisticsMapper.map2To(entity.getStatistics()));
			return to;
		}
		return null;
	}

	public UserEntity map2Entity(UserTO to) {
		if (to != null) {
			UserEntity entity = new UserEntity();
			entity.setId(to.getId());
			entity.setEmail(to.getEmail());
			entity.setPassword(to.getPassword());
			entity.setProfile(profileMapper.map2Entity(to.getProfile()));
			entity.setStatistics(statisticsMapper.map2Entity(to.getStatistics()));
			return entity;
		}
		return null;
	}

	public List<UserTO> map2TOs(List<UserEntity> entities) {
		List<UserTO> tos = new ArrayList<UserTO>();
		for (UserEntity u : entities) {
			tos.add(map2To(u));
		}
		return tos;
	}

	public List<UserEntity> map2Entities(List<UserTO> tos) {
		List<UserEntity> entities = new ArrayList<UserEntity>();
		for (UserTO u : tos) {
			entities.add(map2Entity(u));
		}
		return entities;
	}
}
