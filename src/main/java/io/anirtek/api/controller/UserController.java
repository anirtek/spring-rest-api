package io.anirtek.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.anirtek.api.constants.URI;
import io.anirtek.api.entity.User;
import io.anirtek.api.service.UserService;

@RestController
@RequestMapping(value = URI.USERS)
public class UserController {

	protected UserService service;

	public UserController(UserService serviceInstanceIn) {
		this.service = serviceInstanceIn;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = URI.ID_PATH_VAR)
	public User findOne(@PathVariable("id") String userId) {
		return service.findOne(userId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public User create(@RequestBody User user) {
		return service.create(user);
	}

	@RequestMapping(method = RequestMethod.PUT, value = URI.ID_PATH_VAR)
	public User update(@PathVariable("id") String userId, @RequestBody User user) {
		return service.update(userId, user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = URI.ID_PATH_VAR)
	public void delete(@PathVariable("id") String userId) {
		service.delete(userId);
	}
}
