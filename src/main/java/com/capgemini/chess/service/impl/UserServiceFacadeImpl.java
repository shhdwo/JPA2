package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.exception.UserValidationException;
import com.capgemini.chess.service.UserRegistrationService;
import com.capgemini.chess.service.UserServiceFacade;
import com.capgemini.chess.service.UserUpdateService;
import com.capgemini.chess.service.to.RegistrationTO;
import com.capgemini.chess.service.to.UpdateTO;
import com.capgemini.chess.service.to.UserTO;

@Service
public class UserServiceFacadeImpl implements UserServiceFacade {

	@Autowired
	private UserRegistrationService registrationService;
	
	@Autowired
	private UserUpdateService updateService;

	@Override
	public UserTO register(RegistrationTO to) throws UserValidationException {
		return registrationService.register(to);
	}

	@Override
	public UserTO update(UpdateTO to) {
		return updateService.update(to);
	}

	@Override
	public UserTO showProfile(Long id) {
		return null;
	}

}
