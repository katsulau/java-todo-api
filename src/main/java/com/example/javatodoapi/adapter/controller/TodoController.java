package com.example.javatodoapi.adapter.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.javatodoapi.adapter.dto.request.RegisterTodoRequest;
import com.example.javatodoapi.adapter.dto.request.UpdateTodoRequest;
import com.example.javatodoapi.adapter.dto.response.TodoResponse;
import com.example.javatodoapi.service.TodoService;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private TodoService todoService;

    TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> getTodoList() {
        List<TodoResponse> todoResponseList = todoService.getTodoList();
        return ResponseEntity.ok(todoResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponse> getTodo(
            @PathVariable String id
    ) {
        TodoResponse todoResponse = todoService.getTodo(id);
        return ResponseEntity.ok(todoResponse);
    }

    @PostMapping
    public ResponseEntity registerTodo(
            @RequestBody RegisterTodoRequest registerTodoRequest
    ) {
        todoService.registerTodo(registerTodoRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTodo(
            @PathVariable String id,
            @RequestBody UpdateTodoRequest updateTodoRequest
    ) {
        todoService.updateTodo(id, updateTodoRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTodo(
            @PathVariable String id
    ) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok().build();
    }
}
