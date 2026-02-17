package org.revature.revado_project.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.revature.revado_project.entity.User;
import org.revature.revado_project.repository.UserRepo;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepo userRepo;

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	public Optional<User> getUserById(UUID userId) {
		return userRepo.findById(userId);
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

	public User createUser(User user) {
		return userRepo.save(user);
	}

	public void deleteUser(UUID userId) {
		userRepo.deleteById(userId);
	}

}
