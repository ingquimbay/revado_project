package org.revature.revado_project.repository;

import java.util.Optional;
import java.util.UUID;

import org.revature.revado_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {

	boolean usernameExists(String username);
	
	Optional<User> findUserByUsername(String username);
}
