package com.capgemini.chess.dataaccess.dao;

import com.capgemini.chess.service.to.UserTO;

public interface UserDao extends Dao<UserTO, Long> {
	
	UserTO findByEmail(String email);

}
