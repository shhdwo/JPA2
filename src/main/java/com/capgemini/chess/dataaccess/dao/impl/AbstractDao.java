package com.capgemini.chess.dataaccess.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.chess.dataaccess.dao.Dao;
import com.capgemini.chess.service.mapper.Mapper;


@Transactional(Transactional.TxType.SUPPORTS)
public abstract class AbstractDao<E, T, K extends Serializable> implements Dao<T, K> {

    @PersistenceContext
    protected EntityManager entityManager;

    @Autowired
    Mapper<E, T> mapper;
    
    private Class<E> domainClass;

    @Override
    public T save(T to) {
        entityManager.persist(mapper.map2Entity(to));
        return to;
    }

    @Override
    public T getOne(K id) {
        E entity = entityManager.getReference(getDomainClass(), id);
        return mapper.map2To(entity);
    }

    @Override
    public T findOne(K id) {
        E entity = entityManager.find(getDomainClass(), id);
        return mapper.map2To(entity);
    }

    @Override
    public List<T> findAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<E> criteriaQuery = builder.createQuery(getDomainClass());
        criteriaQuery.from(getDomainClass());
        TypedQuery<E> query = entityManager.createQuery(criteriaQuery);
        return mapper.map2TOs(query.getResultList());
    }

    @Override
    public T update(T to) {
        E entity = entityManager.merge(mapper.map2Entity(to));
        return mapper.map2To(entity);
    }

    @Override
    public void delete(T to) {
        entityManager.remove(mapper.map2Entity(to));
    }

    @Override
    public void delete(K id) {
        entityManager.remove(getOne(id));
    }

    @Override
    public void deleteAll() {
        entityManager.createQuery("delete " + getDomainClassName()).executeUpdate();
    }

    @Override
    public long count() {
        return (long) entityManager.createQuery("Select count(*) from " + getDomainClassName()).getSingleResult();
    }

    @Override
    public boolean exists(K id) {
        return findOne(id) != null;
    }

    @SuppressWarnings("unchecked")
    protected Class<E> getDomainClass() {
        if (domainClass == null) {
            ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
            domainClass = (Class<E>) type.getActualTypeArguments()[0];
        }
        return domainClass;
    }

    protected String getDomainClassName() {
        return getDomainClass().getName();
    }
}
