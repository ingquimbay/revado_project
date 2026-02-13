package org.revature.revado_project.controller;

import org.revature.revado_project.service.TodoService;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TodoController {
	
	private final TodoService service;

}
