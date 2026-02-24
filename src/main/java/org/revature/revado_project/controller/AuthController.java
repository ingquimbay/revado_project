package org.revature.revado_project.controller;

import org.revature.revado_project.entity.User;
import org.revature.revado_project.exception.UsernameAlreadyExistsException;
import org.revature.revado_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class AuthController {

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping
	public String registerUser(@RequestBody User user) throws UsernameAlreadyExistsException {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.registerUser(user);
		return "User registered successfully.";
	}
}
