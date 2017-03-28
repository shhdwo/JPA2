package com.capgemini.chess.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.chess.dataaccess.entities.StatisticsEntity;
import com.capgemini.chess.service.to.StatisticsTO;

@Service
public class StatisticsMapper implements Mapper<StatisticsEntity, StatisticsTO> {
	
	public StatisticsTO map2To(StatisticsEntity entity) {
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

	public StatisticsEntity map2Entity(StatisticsTO to) {
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

	public List<StatisticsTO> map2TOs(List<StatisticsEntity> entities) {
		List<StatisticsTO> tos = new ArrayList<StatisticsTO>();
		for (StatisticsEntity u : entities) {
			tos.add(map2To(u));
		}
		return tos;
	}

	public List<StatisticsEntity> map2Entities(List<StatisticsTO> tos) {
		List<StatisticsEntity> entities = new ArrayList<StatisticsEntity>();
		for (StatisticsTO u : tos) {
			entities.add(map2Entity(u));
		}
		return entities;
	}
}
