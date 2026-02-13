package org.revature.revado_project.repository;

import java.util.UUID;

import org.revature.revado_project.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepo extends JpaRepository<Todo, UUID>{

}
