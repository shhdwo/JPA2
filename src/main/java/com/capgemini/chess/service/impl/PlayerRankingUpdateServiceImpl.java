package com.capgemini.chess.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.comparator.PointsComparator;
import com.capgemini.chess.dataaccess.dao.UserDao;
import com.capgemini.chess.service.PlayerRankingUpdateService;
import com.capgemini.chess.service.to.UserTO;

@Service
public class PlayerRankingUpdateServiceImpl implements PlayerRankingUpdateService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public Map<Long, Integer> updateRanking() {
		Map<Long, Integer> ranking = new HashMap<Long, Integer>();
		List<UserTO> users = userDao.findAll();
		users.sort(new PointsComparator());
		Integer position = 1;
		for (UserTO u : users) {
			u.getStatistics().setPosition(position);
			userDao.update(u);
			ranking.put(u.getId(), position);
			position++;
		}
		return ranking;
	}

}
