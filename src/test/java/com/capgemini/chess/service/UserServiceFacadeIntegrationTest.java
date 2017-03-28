package com.capgemini.chess.service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.fest.assertions.api.Assertions.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.chess.ChessApplication;
import com.capgemini.chess.dataaccess.dao.UserDao;
import com.capgemini.chess.service.to.RegistrationTO;
import com.capgemini.chess.service.to.UpdateTO;
import com.capgemini.chess.service.to.UserTO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ChessApplication.class)
@Transactional
public class UserServiceFacadeIntegrationTest {

	@Autowired
	private UserServiceFacade service;

	@Autowired
	private UserDao dao;
	
	@Test
	public void shouldFinduser() {
		// given when
		UserTO findOne = dao.findOne(1L);
		
		// then
		assertThat(findOne.getEmail()).isEqualTo("email@example.com");
	}

	@Test
	public void shouldRegisterNewUser() throws Exception {
		// given
		RegistrationTO registration = giveRegistrationTO();

		// when
		UserTO user = service.register(registration);

		// then
		UserTO actual = dao.findOne(user.getId());
		Assert.assertEquals(registration.getEmail(), actual.getEmail());
		Assert.assertEquals(registration.getPassword(), actual.getPassword());
		Assert.assertEquals(registration.getName(), actual.getProfile().getName());
		Assert.assertEquals(registration.getSurname(), actual.getProfile().getSurname());
	}
	
	@Test
	public void shouldUpdateUser() throws Exception {
		// given
		RegistrationTO registration = giveRegistrationTO();
		UpdateTO update = giveUpdateTO();
		service.register(registration);
		
		// when
		UserTO user = service.update(update);
		
		// then
		UserTO actual = dao.findOne(user.getId());
		Assert.assertEquals(update.getAboutMe(), actual.getProfile().getAboutMe());
		Assert.assertEquals(update.getLifeMotto(), actual.getProfile().getLifeMotto());
		Assert.assertEquals(update.getName(), actual.getProfile().getName());
		Assert.assertEquals(update.getSurname(), actual.getProfile().getSurname());
		Assert.assertEquals(update.getEmail(), actual.getEmail());
		Assert.assertEquals(update.getPassword(), actual.getPassword());
	}

	private RegistrationTO giveRegistrationTO() {
		RegistrationTO to = new RegistrationTO();
		to.setEmail("a@b.pl");
		to.setPassword("12345678");
		to.setName("Name");
		to.setSurname("Surname");
		return to;
	}
	
	private UpdateTO giveUpdateTO() {
		UpdateTO to = new UpdateTO();
		to.setId(new Long(1));
		to.setAboutMe("I am master at chess");
		to.setName("Major");
		to.setSurname("Chessminator");
		to.setLifeMotto("You have to be the best to be the best");
		to.setEmail("chess@master.pl");
		to.setPassword("12345678");
		return to;
	}

}
