package io.anirtek.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public User findOne(String id) {
		return repository.findOne(id)
				.orElseThrow(() -> new NotFoundException("User with id " + id + " does not exist"));
	}

	@Override
	@Transactional
	public User create(User user) {
		Optional<User> mayExist = repository.findByEmail(user.getEmail());
		if(mayExist.isPresent())
				throw new BadRequstException("User with email " + user.getEmail() + " already exist");

		return repository.create(user);
	}

	@Override
	@Transactional
	public User update(String id, User user) {
		repository.findOne(id).orElseThrow(() -> new NotFoundException("User with id " + id + " does not exist"));
		return repository.update(user);
	}

	@Override
	@Transactional
	public void delete(String id) {
		User existing = repository.findOne(id)
				.orElseThrow(() -> new NotFoundException("User with id " + id + " does not exist"));
		repository.delete(existing);
	}

}
