package org.revature.revado_project.service;

import java.util.List;
import java.util.UUID;

import org.revature.revado_project.entity.Todo;
import org.revature.revado_project.entity.User;
import org.revature.revado_project.repository.TodoRepo;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {

	private final TodoRepo todoRepo;

	public List<Todo> getAllTodos() {
		return todoRepo.findByParentIsNull();
	}

	public List<Todo> getUserTodos(User user) {
		return todoRepo.findByUserAndParentIsNull(user);
	}

	public Todo getOneTodoById(UUID todoId) {
		return todoRepo.findById(todoId).get();
	}

	public Todo createTodo(Todo todo) {
		return todoRepo.save(todo);
	}

	public Todo addSubtask(UUID todoId, Todo todo) {
		Todo tParent = todoRepo.findById(todoId).get();
		todo.setUser(tParent.getUser());
		todo.setParent(tParent);
		todoRepo.save(todo);
		return tParent;
	}

	public Todo updateTodo(Todo updatedTodo) {
		Todo todo = null;
		if (todoRepo.existsById(updatedTodo.getId())) {
			todo = todoRepo.findById(updatedTodo.getId()).get();
			todo.setTitle(updatedTodo.getTitle());
			todo.setDescription(updatedTodo.getDescription());
			todo.setCompleted(updatedTodo.isCompleted());
		}
		return todoRepo.save(todo);
	}

	public void deleteTask(UUID todoId) {
		todoRepo.deleteById(todoId);
	}

}
