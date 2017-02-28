package com.capgemini.chess.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.chess.dataaccess.entities.MatchEntity;
import com.capgemini.chess.service.to.MatchTO;


public class MatchMapper {
	
	public static MatchTO map(MatchEntity entity) {
		if (entity != null) {
			MatchTO to = new MatchTO();
			to.setId(entity.getId());
			to.setPlayer1(entity.getPlayer1());
			to.setPlayer2(entity.getPlayer2());
			to.setPoints1(entity.getPoints1());
			to.setPoints2(entity.getPoints2());
			to.setResult(entity.getResult());
			return to;
		}
		return null;
	}

	public static MatchEntity map(MatchTO to) {
		if (to != null) {
			MatchEntity entity = new MatchEntity();
			entity.setId(to.getId());
			entity.setPlayer1(to.getPlayer1());
			entity.setPlayer2(to.getPlayer2());
			entity.setPoints1(to.getPoints1());
			entity.setPoints2(to.getPoints2());
			entity.setResult(to.getResult());
			return entity;
		}
		return null;
	}

	public static List<MatchTO> map2TOs(List<MatchEntity> entities) {
		return entities.stream().map(MatchMapper::map).collect(Collectors.toList());
	}

	public static List<MatchEntity> map2Entities(List<MatchTO> tos) {
		return tos.stream().map(MatchMapper::map).collect(Collectors.toList());
	}

}
