package com.umbra.jdbc_rest_api.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.umbra.jdbc_rest_api.dto.CreateTodoRequest;
import com.umbra.jdbc_rest_api.dto.UpdateTodoRequest;
import com.umbra.jdbc_rest_api.model.Todo;
import com.umbra.jdbc_rest_api.repository.TodoRepository;

@Service
@Transactional
public class TodoService {

  private final TodoRepository repository;

  public TodoService(TodoRepository repository) {
    this.repository = repository;
  }

  @Transactional(readOnly = true)
  public List<Todo> findAll() {
    return repository.findAll();
  }

  public Todo findById(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found"));
  }

  public Todo create(CreateTodoRequest request) {
    return repository.save(request.title());
  }

  public void update(Long id, UpdateTodoRequest request) {
    repository.update(id, request.title(), request.completed());
  }

  public void delete(Long id) {
    Todo existing = repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found"));

    repository.delete(existing.getId());
  }

  public void toggleCompleted(Long id, String title) {
    Todo todo = repository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Todo not found: " + id));

    repository.update(id, title, !todo.isCompleted());
  }

}
