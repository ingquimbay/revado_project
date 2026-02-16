package org.revature.revado_project.service;

import java.util.ArrayList;
import java.util.List;

import org.revature.revado_project.entity.Todo;
import org.revature.revado_project.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {

	@Autowired
	private final TodoRepo todoRepo;
	
	public List<Todo> getAllTopTodos(){
		
		List<Todo> topTodos = todoRepo.findAll();
		for (Todo todo : topTodos) {
			if (!todo.getParent().equals(null)) {
				topTodos.remove(todo);
			}
		}
		return topTodos;
	}
	
	public List<Todo> getAllTodos(){
		return todoRepo.findAll();
	}
}
