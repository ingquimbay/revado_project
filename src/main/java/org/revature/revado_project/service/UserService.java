package org.revature.revado_project.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.revature.revado_project.entity.User;
import org.revature.revado_project.exception.UserNotFoundException;
import org.revature.revado_project.exception.UsernameAlreadyExistsException;
import org.revature.revado_project.repository.UserRepo;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepo userRepo;

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	public Optional<User> getUserById(UUID userId) throws UserNotFoundException {
		return userRepo.findById(userId);
	}

	public User findUserByUsername(String username) throws UsernameNotFoundException {
		return userRepo.findUserByUsername(username).get();
	}

	public User updateUser(User updatedUser) {
		User user = null;
		if (userRepo.existsById(updatedUser.getId())) {
			user = userRepo.findById(updatedUser.getId()).get();
			user.setUsername(updatedUser.getUsername());
			user.setPassword(updatedUser.getPassword());
		}
		return userRepo.save(user);
	}

	public User createUser(User user) throws UsernameAlreadyExistsException {
		return userRepo.save(user);
	}

	public User registerUser(User user) throws UsernameAlreadyExistsException {
		return userRepo.save(user);
	}

	public void deleteUser(UUID userId) throws UserNotFoundException {
		userRepo.deleteById(userId);
	}

	public boolean usernameAlreadyExists(String username) {
		return userRepo.usernameExists(username);
	}

}
