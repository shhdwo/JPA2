package com.capgemini.chess.service;

import com.capgemini.chess.exception.UserValidationException;
import com.capgemini.chess.service.to.RegistrationTO;
import com.capgemini.chess.service.to.UpdateTO;

public interface UserValidationService {

	void validateRegistration(RegistrationTO to) throws UserValidationException;
	
	void validateUpdate(UpdateTO to) throws UserValidationException;

}
