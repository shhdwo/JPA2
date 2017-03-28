package com.capgemini.chess.service;

import com.capgemini.chess.exception.UserValidationException;
import com.capgemini.chess.service.to.UpdateTO;
import com.capgemini.chess.service.to.UserTO;

public interface UserUpdateService {
	
	UserTO update(UpdateTO to) throws UserValidationException;

}
