package org.revature.revado_project.controller;

import java.util.List;
import java.util.UUID;

import org.revature.revado_project.entity.User;
import org.revature.revado_project.exception.UserNotFoundException;
import org.revature.revado_project.exception.UsernameAlreadyExistsException;
import org.revature.revado_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

	@Autowired
	private final UserService service;

	@GetMapping
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}

	@GetMapping("{userid}")
	public User getUser(@PathVariable("userid") UUID userId) {
		return service.getUserById(userId).get();
	}

	@PostMapping
	public User createUser(@RequestBody User user) throws UsernameAlreadyExistsException {
		return service.createUser(user);
	}

	@PutMapping
	public User updateUser(@RequestBody User user) {
		return service.updateUser(user);
	}

	@DeleteMapping("{userid}")
	public String deleteUser(@PathVariable("userid") UUID userId) {
		String username = service.getUserById(userId).get().getUsername();
		service.deleteUser(userId);
		return "User " + username + " deleted successfully.";
	}
}
