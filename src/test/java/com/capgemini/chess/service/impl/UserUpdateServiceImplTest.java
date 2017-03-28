package com.capgemini.chess.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.Assert;

import com.capgemini.chess.dataaccess.dao.UserDao;
import com.capgemini.chess.exception.UserValidationException;
import com.capgemini.chess.service.to.ProfileTO;
import com.capgemini.chess.service.to.UpdateTO;
import com.capgemini.chess.service.to.UserTO;

@RunWith(MockitoJUnitRunner.class)
public class UserUpdateServiceImplTest {
	
	@InjectMocks
	private UserUpdateServiceImpl service;
	
	@Mock
	private UserDao userDao;
	
	@Test
	public void shouldUpdateUser() throws UserValidationException {
		// given
		Mockito.when(userDao.findOne(giveUpdate().getId())).thenReturn(giveUser());
		UpdateTO updateTO = giveUpdate();
		
		// when
		UserTO updatedUser = service.update(updateTO);
		
		// then
		Assert.assertEquals(updateTO.getAboutMe(), updatedUser.getProfile().getAboutMe());
		Assert.assertEquals(updateTO.getLifeMotto(), updatedUser.getProfile().getLifeMotto());
		Assert.assertEquals(updateTO.getName(), updatedUser.getProfile().getName());
		Assert.assertEquals(updateTO.getSurname(), updatedUser.getProfile().getSurname());
		Assert.assertEquals(updateTO.getEmail(), updatedUser.getEmail());
		Assert.assertEquals(updateTO.getPassword(), updatedUser.getPassword());
	}
	
	private UserTO giveUser() {
		ProfileTO profileTo = new ProfileTO();
		profileTo.setAboutMe("I am noob at chess");
		profileTo.setId(new Long(1));
		profileTo.setName("Minor");
		profileTo.setSurname("Chessretardo");
		profileTo.setLifeMotto("In order to win, it means somebody has to lose");
		UserTO userTO = new UserTO();
		userTO.setId(new Long(1));
		userTO.setEmail("chess@retardo.pl");
		userTO.setPassword("87654321");
		userTO.setProfile(profileTo);
		return userTO;
	}
	
	private UpdateTO giveUpdate() {
		UpdateTO updateTO = new UpdateTO();
		updateTO.setId(new Long(1));
		updateTO.setAboutMe("I am master at chess");
		updateTO.setName("Major");
		updateTO.setSurname("Chessminator");
		updateTO.setLifeMotto("You have to be the best to be the best");
		updateTO.setEmail("chess@master.pl");
		updateTO.setPassword("12345678");
		return updateTO;
	}

}
