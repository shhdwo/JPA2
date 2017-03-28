package com.capgemini.chess.dataaccess.dao;

import java.util.List;

import com.capgemini.chess.service.to.UserTO;

public interface UserDao extends Dao<UserTO, Long> {
	
	UserTO findByEmail(String email);
	
	List<UserTO> findAllAndOrderByPoints();
	
	int countUsersWithPointsMoreThan(int points);

}
