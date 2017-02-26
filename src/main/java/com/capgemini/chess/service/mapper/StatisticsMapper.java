package com.capgemini.chess.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.chess.dataaccess.entities.StatisticsEntity;
import com.capgemini.chess.service.to.StatisticsTO;

public class StatisticsMapper {
	
	public static StatisticsTO map(StatisticsEntity entity) {
		if (entity != null) {
			StatisticsTO to = new StatisticsTO();
			to.setId(entity.getId());
			to.setLvl(entity.getLvl());
			to.setPoints(entity.getPoints());
			to.setGamesWon(entity.getGamesWon());
			to.setGamesLost(entity.getGamesLost());
			to.setGamesDrawn(entity.getGamesDrawn());
			to.setPosition(entity.getPosition());
			return to;
		}
		return null;
	}

	public static StatisticsEntity map(StatisticsTO to) {
		if (to != null) {
			StatisticsEntity entity = new StatisticsEntity();
			entity.setId(to.getId());
			entity.setLvl(to.getLvl());
			entity.setPoints(to.getPoints());
			entity.setGamesWon(to.getGamesWon());
			entity.setGamesLost(to.getGamesLost());
			entity.setGamesDrawn(to.getGamesDrawn());
			entity.setPosition(to.getPosition());
			return entity;
		}
		return null;
	}

	public static List<StatisticsTO> map2TOs(List<StatisticsEntity> entities) {
		return entities.stream().map(StatisticsMapper::map).collect(Collectors.toList());
	}

	public static List<StatisticsEntity> map2Entities(List<StatisticsTO> tos) {
		return tos.stream().map(StatisticsMapper::map).collect(Collectors.toList());
	}
}
