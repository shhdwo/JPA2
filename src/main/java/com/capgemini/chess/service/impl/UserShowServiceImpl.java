package com.capgemini.chess.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.comparator.PointsComparator;
import com.capgemini.chess.dataaccess.dao.MatchDao;
import com.capgemini.chess.dataaccess.dao.UserDao;
import com.capgemini.chess.service.UserShowService;
import com.capgemini.chess.service.to.MatchTO;
import com.capgemini.chess.service.to.UserInfoTO;
import com.capgemini.chess.service.to.UserTO;

@Service
public class UserShowServiceImpl implements UserShowService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private MatchDao matchDao;

	@Override
	public UserInfoTO showUser(Long id) {
		UserInfoTO userInfo = new UserInfoTO();
		UserTO userTO = userDao.findOne(id);
		List<UserTO> ranking = userDao.findAll();
		ranking.sort(new PointsComparator());
		List<MatchTO> history = matchDao.findByUserId(id);
		bindValues(userInfo, userTO, ranking, history);
		printOutToConsole(userInfo, ranking, history);
		return userInfo;
	}

	private void printOutToConsole(UserInfoTO userInfo, List<UserTO> ranking, List<MatchTO> history) {
		System.out.printf("User: %40s\n\n", userInfo.getName() + " " + userInfo.getSurname());
		System.out.printf("Level: %39s\n", userInfo.getLvl().getLvl() + " " + userInfo.getLvl().getName());
		System.out.printf("Position: %36s\n", userInfo.getPosition());
		System.out.printf("Points: %38s\n\n", userInfo.getPoints());
		System.out.printf("Matches played: %29s Matches drawn:%29s\n",
				userInfo.getGamesDrawn() + userInfo.getGamesWon() + userInfo.getGamesLost(), userInfo.getGamesDrawn());
		System.out.printf("Matches won: %32s Matches lost:%30s\n", userInfo.getGamesWon(), userInfo.getGamesLost());
		System.out.printf("\nLeaderboard:\n");
		for (UserTO u : ranking) {
			System.out.printf("%3s %20s %20s %30s\n", u.getStatistics().getPosition(), u.getProfile().getName(),
					u.getStatistics().getPoints(), u.getStatistics().getLvl().getName());
		}
		System.out.printf("\n\nMatch history:\n");
		int counter = 1;
		for (MatchTO m : history) {
			System.out.printf("%3s %20s %20s\n", counter,  m.getPlayer1() + "(" + m.getPoints1() + ")",
					m.getPlayer2() + "(" + m.getPoints2() + ")");
			counter++;
		}
	}

	private void bindValues(UserInfoTO userInfo, UserTO userTO, List<UserTO> ranking, List<MatchTO> history) {
		userInfo.setAboutMe(userTO.getProfile().getAboutMe());
		userInfo.setGamesDrawn(userTO.getStatistics().getGamesDrawn());
		userInfo.setGamesLost(userTO.getStatistics().getGamesLost());
		userInfo.setGamesWon(userTO.getStatistics().getGamesWon());
		userInfo.setLifeMotto(userTO.getProfile().getLifeMotto());
		userInfo.setLvl(userTO.getStatistics().getLvl());
		userInfo.setName(userTO.getProfile().getName());
		userInfo.setPlayerHistory(history);
		userInfo.setPoints(userTO.getStatistics().getPoints());
		userInfo.setPosition(userTO.getStatistics().getPosition());
		userInfo.setRanking(ranking);
		userInfo.setSurname(userTO.getProfile().getSurname());
		userInfo.setUserId(userTO.getId());
	}

}
