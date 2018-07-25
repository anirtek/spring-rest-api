package io.anirtek.api.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import io.anirtek.api.entity.User;
import io.anirtek.api.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager em; // We do not have to initialize this instance. Spring will do it for us.

	@Override
	public List<User> findAll() {
		TypedQuery<User> query = em.createNamedQuery("Users.findAll", User.class);
		return query.getResultList();
	}

	@Override
	public User findByEmail(String id) {
		TypedQuery<User> query = em.createNamedQuery("Users.findByEmail", User.class);
		List<User> users = query.getResultList();
		if (!users.isEmpty()) {
			return users.get(0);
		} else {
			return null;
		}
	}

	@Override
	public User findOne(String id) {
		return em.find(User.class, id);
	}

	@Override
	public User create(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public User update(User user) {
		em.merge(user);
		return user;
	}

	@Override
	public void delete(User user) {
		em.remove(user);
	}

}
