package io.anirtek.api.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import io.anirtek.api.entity.User;
import io.anirtek.api.exception.BadRequstException;
import io.anirtek.api.exception.NotFoundException;
import io.anirtek.api.repository.UserRepository;
import io.anirtek.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository repository;
	
	public UserServiceImpl(UserRepository repositoryIn) {
		this.repository = repositoryIn;
	}
	
	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findOne(String id) {
		User user = repository.findOne(id);
		if(user == null) {
			throw new NotFoundException("User with id " + id + " does not exist");
		}
		return user;
	}

	@Override
	public User create(User user) {
		User existing = repository.findByEmail(user.getEmail());
		if(existing != null) {
			throw new BadRequstException("User with email " + user.getEmail() + " already exist");
		}
		return repository.create(user);
	}

	@Override
	public User update(String id, User user) {
		User existing = repository.findOne(id);
		if(existing == null) {
			throw new NotFoundException("User with id " + id + " does not exist");
		}
		return repository.update(user);
	}

	@Override
	public void delete(String id) {
		User existing = repository.findOne(id);
		if(existing == null) {
			throw new NotFoundException("User with id " + id + " does not exist");
		}
		repository.delete(existing);
	}

}
