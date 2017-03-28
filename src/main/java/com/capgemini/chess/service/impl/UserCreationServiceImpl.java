package com.capgemini.chess.service.impl;

import org.springframework.stereotype.Service;

import com.capgemini.chess.enums.Level;
import com.capgemini.chess.service.UserCreationService;
import com.capgemini.chess.service.to.ProfileTO;
import com.capgemini.chess.service.to.RegistrationTO;
import com.capgemini.chess.service.to.StatisticsTO;
import com.capgemini.chess.service.to.UserTO;

@Service
public class UserCreationServiceImpl implements UserCreationService {

	@Override
	public UserTO create(RegistrationTO to) {
		UserTO user = new UserTO();
		user.setProfile(giveProfile(to));
		user.setStatistics(giveStatistics());
		user.setEmail(to.getEmail());
		user.setPassword(to.getPassword());
		return user;
	}

	private ProfileTO giveProfile(RegistrationTO to) {
		ProfileTO profile = new ProfileTO();
		profile.setName(to.getName());
		profile.setSurname(to.getSurname());
		return profile;
	}

	private StatisticsTO giveStatistics() {
		StatisticsTO statistics = new StatisticsTO();
		statistics.setLevel(Level.NEWBIE);
		statistics.setGamesDrawn(0);
		statistics.setGamesLost(0);
		statistics.setGamesLost(0);
		statistics.setPoints(0);
		return statistics;
	}

}
