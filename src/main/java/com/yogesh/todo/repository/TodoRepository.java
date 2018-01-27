package com.yogesh.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.yogesh.todo.model.TodoModel;

/**
 * Created by yogesh.kumar on 25/01/2018.
 */
@RepositoryRestResource
public interface TodoRepository extends JpaRepository<TodoModel, Long> {

}
