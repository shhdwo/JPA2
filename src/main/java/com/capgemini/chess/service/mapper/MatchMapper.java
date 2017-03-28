package com.capgemini.chess.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dataaccess.entities.MatchEntity;
import com.capgemini.chess.service.to.MatchTO;

@Service
public class MatchMapper implements Mapper<MatchEntity, MatchTO>{
	
	@Autowired
	UserMapper mapper;
	
	public MatchTO map2To(MatchEntity entity) {
		if (entity != null) {
			MatchTO to = new MatchTO();
			to.setPlayer1(mapper.map2To(entity.getPlayer1()));
			to.setPlayer2(mapper.map2To(entity.getPlayer2()));
			to.setPoints1(entity.getPoints1());
			to.setPoints2(entity.getPoints2());
			to.setResult(entity.getResult());
			return to;
		}
		return null;
	}

	public MatchEntity map2Entity(MatchTO to) {
		if (to != null) {
			MatchEntity entity = new MatchEntity();
			entity.setPlayer1(mapper.map2Entity(to.getPlayer1()));
			entity.setPlayer2(mapper.map2Entity(to.getPlayer2()));
			entity.setPoints1(to.getPoints1());
			entity.setPoints2(to.getPoints2());
			entity.setResult(to.getResult());
			return entity;
		}
		return null;
	}

	public List<MatchTO> map2TOs(List<MatchEntity> entities) {
		List<MatchTO> tos = new ArrayList<MatchTO>();
		for (MatchEntity u : entities) {
			tos.add(map2To(u));
		}
		return tos;
	}

	public List<MatchEntity> map2Entities(List<MatchTO> tos) {
		List<MatchEntity> entities = new ArrayList<MatchEntity>();
		for (MatchTO u : tos) {
			entities.add(map2Entity(u));
		}
		return entities;
	}

}
