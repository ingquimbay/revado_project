package org.revature.revado_project.service;

import java.util.List;

import org.revature.revado_project.entity.Todo;
import org.revature.revado_project.repository.TodoRepo;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {

	private TodoRepo todoRepo;

	public List<Todo> getAllTodos() {
		return todoRepo.findAll();
	}

}
