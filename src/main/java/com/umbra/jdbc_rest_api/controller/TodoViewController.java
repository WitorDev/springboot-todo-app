package com.umbra.jdbc_rest_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.umbra.jdbc_rest_api.dto.CreateTodoRequest;
import com.umbra.jdbc_rest_api.service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/todos")
public class TodoViewController {

  private final TodoService todoService;

  public TodoViewController(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping
  public String listTodos(Model model) {
    model.addAttribute("todos", todoService.findAll());
    return "todos";
  }

  @PostMapping("/{id}/{title}/toggle")
  public String toggleCompleted(@PathVariable Long id, @PathVariable String title) {
    todoService.toggleCompleted(id, title);
    return "redirect:/todos";
  }

  @GetMapping("/new")
  public String showCreateForm() {
    return "create-todo";
  }

  @PostMapping
  public String createTodo(@RequestParam String title) {
    todoService.create(new CreateTodoRequest(title));
    return "redirect:/todos";
  }

  @PostMapping("/{id}/delete")
  public String deleteTodo(@PathVariable Long id) {
    todoService.delete(id);
    return "redirect:/todos";
  }
}