package com.umbra.jdbc_rest_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umbra.jdbc_rest_api.dto.CreateTodoRequest;
import com.umbra.jdbc_rest_api.dto.UpdateTodoRequest;
import com.umbra.jdbc_rest_api.model.Todo;
import com.umbra.jdbc_rest_api.service.TodoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

  private final TodoService service;

  public TodoController(TodoService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<Todo>> getAllTodos() {
    return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public Todo getById(@PathVariable Long id) {
    return service.findById(id);
  }

  @PostMapping
  public ResponseEntity<Todo> create(@Valid @RequestBody CreateTodoRequest createTodoRequest) {
    Todo todo = service.create(createTodoRequest);
    return new ResponseEntity<>(todo, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Todo> update(@PathVariable Long id,
      @Valid @RequestBody UpdateTodoRequest request) {
    Todo updatedTodo = service.update(id, request);
    return ResponseEntity.ok(updatedTodo);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    service.delete(id);
  }
}
