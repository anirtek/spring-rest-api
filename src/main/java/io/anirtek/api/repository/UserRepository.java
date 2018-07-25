package io.anirtek.api.repository;

import java.util.List;

import io.anirtek.api.entity.User;

public interface UserRepository {
	public List<User> findAll();

	public User findOne(String id);
	
	public User findByEmail(String id);

	public User create(User user);

	public User update(String id, User user);

	public void delete(String id);
}
