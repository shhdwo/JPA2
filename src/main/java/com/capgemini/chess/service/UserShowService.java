package com.capgemini.chess.service;

import com.capgemini.chess.service.to.UserInfoTO;

public interface UserShowService {
	
	UserInfoTO showUser(Long id);

}
