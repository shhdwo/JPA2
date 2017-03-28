package com.capgemini.chess.dataaccess.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dataaccess.dao.UserDao;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.to.UserTO;

@Repository
public class UserDaoImpl extends AbstractDao<UserEntity, UserTO, Long> implements UserDao {

	@PersistenceContext
    protected EntityManager em;

	@Override
	public UserTO findByEmail(String email) {
		return mapper.map2To(
				em.createQuery("SELECT u FROM UserEntity u WHERE u.email = :email", UserEntity.class)
				.setParameter("email", email)
				.getResultList().stream().findFirst().orElse(null));
	}
	
	@Override
	public List<UserTO> findAllAndOrderByPoints() {
		return mapper.map2TOs(
				em.createNamedQuery("UserEntity.findAllAndOrderByPoints", UserEntity.class)
				.getResultList());
	}
	
	@Override
	public long countUsersWithPointsMoreThan(int points) {
		return em.createNamedQuery("UserEntity.countUsersWithPointsMoreThan", Long.class)
				.setParameter("points", points)
				.getSingleResult();
	}

}
