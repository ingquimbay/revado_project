package org.revature.revado_project.controller;

import java.util.List;

import org.revature.revado_project.entity.Todo;
import org.revature.revado_project.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoController {

	@Autowired
	private final TodoService service;

	@GetMapping
	public List<Todo> listTodos() {
		return service.getAllTodos();
	}

}
