package com.capgemini.chess.dataaccess.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dataaccess.dao.MatchDao;
import com.capgemini.chess.dataaccess.entities.MatchEntity;
import com.capgemini.chess.service.to.MatchTO;

@Repository
public class MatchDaoImpl extends AbstractDao<MatchEntity, MatchTO, Long> implements MatchDao {
	
	@PersistenceContext
    protected EntityManager em;

	@Override
	public List<MatchTO> findByUserId(Long id) {
		return mapper.map2TOs(
				em.createNamedQuery("Match.findByUserId", MatchEntity.class)
				.setParameter("id", id)
				.getResultList());
	}
}
