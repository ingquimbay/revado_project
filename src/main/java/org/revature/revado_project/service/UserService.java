package org.revature.revado_project.service;

import org.revature.revado_project.repository.UserRepo;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepo userRepo;

}
