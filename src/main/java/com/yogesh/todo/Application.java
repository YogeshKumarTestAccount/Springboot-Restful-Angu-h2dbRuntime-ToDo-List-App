package com.yogesh.todo;

import com.yogesh.todo.model.TodoModel;
import com.yogesh.todo.repository.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private TodoRepository repository;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		List<TodoModel> todos = Arrays.asList(
				new TodoModel("Task 1", false),
				new TodoModel("Task 2", false),
				new TodoModel("Task 3", false),
				new TodoModel("Task 4", false),
				new TodoModel("Task 5", false),
				new TodoModel("Task 6", false),
				new TodoModel("Task 7", true)
		);

		todos.forEach(todo ->
				repository.save(todo)
		);

//		repository.findAll().forEach(System.out::println);
	}
}
