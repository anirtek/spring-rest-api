package io.anirtek.api.repository.impl;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import io.anirtek.api.entity.User;
import io.anirtek.api.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Override
	public List<User> findAll() {
		return null;
	}

	@Override
	public User findOne(String id) {
		return null;
	}

	@Override
	public User create(User user) {
		return null;
	}

	@Override
	public User update(String id, User user) {
		return null;
	}

	@Override
	public void delete(String id) {

	}

	@Override
	public User findByEmail(String id) {
		return null;
	}

}
