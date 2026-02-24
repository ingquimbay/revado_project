package org.revature.revado_project.controller;

import java.util.List;
import java.util.UUID;

import org.revature.revado_project.entity.Todo;
import org.revature.revado_project.entity.User;
import org.revature.revado_project.service.TodoService;
import org.revature.revado_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
@RequestMapping("/todos")
public class TodoController {

	@Autowired
	private final TodoService service;

	@Autowired
	private UserService userService;

	@GetMapping
	public List<Todo> listTodos(@AuthenticationPrincipal UserDetails currentUser) {
		User user = userService.findUserByUsername(currentUser.getUsername());
		return service.getUserTodos(user);
	}

	@GetMapping("{todoid}")
	public Todo getTodo(@PathVariable("todoid") UUID todoId) {
		return service.getOneTodoById(todoId);
	}

	@PostMapping
	public Todo createTodo(@RequestBody Todo todo, @AuthenticationPrincipal UserDetails currentUser) {
		User user = userService.findUserByUsername(currentUser.getUsername());
		todo.setUser(user);
		return service.createTodo(todo);
	}

	@PostMapping("{todoid}/subtasks")
	public Todo createSubtask(@PathVariable("todoid") UUID todoId, @RequestBody Todo todo) {
		return service.addSubtask(todoId, todo);
	}

	@PutMapping
	public Todo updateTodo(@RequestBody Todo todo) {
		return service.updateTodo(todo);
	}

	@DeleteMapping("{todoid}")
	public String deleteTodo(@PathVariable("todoid") UUID todoId) {
		String todoTitle = service.getOneTodoById(todoId).getTitle();
		service.deleteTask(todoId);
		return "TODO " + todoTitle + " deleted successfully";
	}
}
