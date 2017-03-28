package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dataaccess.dao.UserDao;
import com.capgemini.chess.service.UserUpdateService;
import com.capgemini.chess.service.to.UpdateTO;
import com.capgemini.chess.service.to.UserTO;

@Service
public class UserUpdateServiceImpl implements UserUpdateService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserTO update(UpdateTO to) { 
		UserTO user = userDao.findOne(to.getId());
		user.getProfile().setAboutMe(to.getAboutMe());
		user.getProfile().setLifeMotto(to.getLifeMotto());
		user.getProfile().setName(to.getName());
		user.getProfile().setSurname(to.getSurname());
		user.setEmail(to.getEmail());
		user.setPassword(to.getPassword());
		userDao.update(user);
		return user;
	}

}
