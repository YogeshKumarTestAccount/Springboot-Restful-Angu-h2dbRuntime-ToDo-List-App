package com.yogesh.todo.controller;

import com.yogesh.todo.Application;
import com.yogesh.todo.controller.TodoController;
import com.yogesh.todo.model.TodoModel;
import com.yogesh.todo.repository.TodoRepository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by yogesh.kumar on 25/01/2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
//@WebAppConfiguration
public class TodoControllerTest {

    @Autowired
    private TodoRepository repository;

    @Before
    public void setUp() throws Exception {

        List<TodoModel> todos = Arrays.asList(
                new TodoModel("Task 1", false),
                new TodoModel("Task 2", false),
                new TodoModel("Task 3", false),
                new TodoModel("Task 4", false),
                new TodoModel("Task 5", false),
                new TodoModel("Task 6", true),
                new TodoModel("Task 7", true)
        );
        repository.deleteAll();
        todos.forEach(todo -> repository.save(todo));
    }

    @After
    public void tearDown() throws Exception {
        repository.deleteAll();
    }

    @Test
    public void testGetAll() {
        TodoController todoController = new TodoController(repository);

        Collection<TodoModel> actual = todoController.getAll();
        actual.forEach(System.out::println);
        assertEquals(7, actual.size());
    }

    @Test
    public void testGetComplete() {
        TodoController todoController = new TodoController(repository);

        Collection<TodoModel> actual = todoController.getComplete();
        actual.forEach(System.out::println);
        assertEquals(2, actual.size());
    }

    @Test
    public void testGetPending() {
        TodoController todoController = new TodoController(repository);

        Collection<TodoModel> actual = todoController.getPending();
        actual.forEach(System.out::println);
        assertEquals(5, actual.size());
    }


}