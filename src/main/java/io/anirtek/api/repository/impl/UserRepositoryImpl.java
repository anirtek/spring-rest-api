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
		List<User> userList = new ArrayList<>();
		User user1 = new User();
		user1.setEmail("aptekade@gmail.com");
		User user2 = new User();
		user2.setEmail("tekade@gmail.com");
		User user3 = new User();
		user3.setEmail("apt@gmail.com");
		User user4 = new User();
		user4.setEmail("anirtek@gmail.com");
		
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		
		return userList;
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
