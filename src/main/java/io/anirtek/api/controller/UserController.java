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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = URI.USERS)
@Api(value = "users")
public class UserController {

	protected UserService service;

	public UserController(UserService serviceInstanceIn) {
		this.service = serviceInstanceIn;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Find All Users", notes = "Returns a list of users in the application")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public List<User> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = URI.ID_PATH_VAR)
	@ApiOperation(value = "Find User by Id", notes = "Returns a user by id if it exists in the application")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public User findOne(@PathVariable("id") String userId) {
		return service.findOne(userId);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Crate User", notes = "Creates and returns a user with the unique email in the application")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public User create(@RequestBody User user) {
		return service.create(user);
	}

	@RequestMapping(method = RequestMethod.PUT, value = URI.ID_PATH_VAR)
	@ApiOperation(value = "Update User", notes = "Updates an existing user and returns it from the application")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public User update(@PathVariable("id") String userId, @RequestBody User user) {
		return service.update(userId, user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = URI.ID_PATH_VAR)
	@ApiOperation(value = "Deletes User", notes = "Deletes the user from the database of the application")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public void delete(@PathVariable("id") String userId) {
		service.delete(userId);
	}
}
