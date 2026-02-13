package org.revature.revado_project.service;

import org.revature.revado_project.repository.TodoRepo;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {

	private final TodoRepo todoRepo;
	
	
}
