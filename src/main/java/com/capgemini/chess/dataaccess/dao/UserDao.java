package com.capgemini.chess.dataaccess.dao;

import java.util.List;

import com.capgemini.chess.service.to.UserTO;

public interface UserDao {

	UserTO save(UserTO user);

	UserTO update(UserTO user);
	
	UserTO findByEmail(String email);

	UserTO find(Long id);
	
	List<UserTO> findAll();

}
