package com.yogesh.todo.controller;

import com.yogesh.todo.model.TodoModel;
import com.yogesh.todo.repository.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * Created by yogesh.kumar on 25/01/2018.
 */
@RestController
@RequestMapping("todo")
public class TodoController {

    @Autowired
    private TodoRepository repository;

    public TodoController(TodoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Collection<TodoModel> getAll() {

        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

    @PostMapping(value = "")
    public TodoModel add(@RequestBody TodoModel todo) {

        repository.save(todo);
        return todo;
    }

    @PutMapping(value = "/{id}")
    public TodoModel update(@PathVariable("id") String id, @RequestBody TodoModel todo) {

        repository.save(todo);
        return todo;
    }

    @GetMapping("/complete")
    public Collection<TodoModel> getComplete() {

        return repository.findAll().stream()
                .filter(todo -> todo.getCompleted())
                .collect(Collectors.toList());
    }

    @GetMapping("/pending")
    public Collection<TodoModel> getPending() {

        return repository.findAll().stream()
                .filter(todo -> !todo.getCompleted())
                .collect(Collectors.toList());
    }


    @GetMapping(value = "/{id}")
    public TodoModel findById(@PathVariable("id") Long id) {

        TodoModel todo = repository.findOne(id);
        return todo;
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {

        repository.delete(id);
    }


}