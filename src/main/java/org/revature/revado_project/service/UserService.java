package org.revature.revado_project.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.revature.revado_project.entity.User;
import org.revature.revado_project.exception.UserNotFoundException;
import org.revature.revado_project.exception.UsernameAlreadyExistsException;
import org.revature.revado_project.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepo userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	public Optional<User> getUserById(UUID userId) throws UserNotFoundException {
		return userRepo.findById(userId);
	}

	public User getUserByUsername(String username) throws UserNotFoundException {
		return userRepo.findUserByUsername(username).get();
	}

	public User findUserByUsername(String username) {
		if (userRepo.findUserByUsername(username).isEmpty()) {
			throw new UserNotFoundException("User does not exists.");
		}
		return userRepo.findUserByUsername(username).get();
	}

	public User updateUser(User updatedUser) {
		User user = userRepo.findById(updatedUser.getId())
				.orElseThrow(() -> new UserNotFoundException("User not found."));
		user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
		return userRepo.save(user);
	}

	public User createUser(User user) throws UsernameAlreadyExistsException {
		return userRepo.save(user);
	}

	public User registerUser(User user) throws UsernameAlreadyExistsException {
		return userRepo.save(user);
	}

	public void deleteUser(UUID userId) {
		if (userRepo.findById(userId).isEmpty()) {
			throw new UserNotFoundException("User does not exists.");
		}
		userRepo.deleteById(userId);
	}

	public boolean usernameAlreadyExists(String username) {
		return userRepo.usernameExists(username);
	}

}
