package org.revature.revado_project.controller;

import org.revature.revado_project.service.UserService;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
	
	private final UserService service;

}
