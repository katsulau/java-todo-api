package com.example.javatodoapi.adapter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.javatodoapi.adapter.dto.TodoResponse;
import com.example.javatodoapi.service.TodoService;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private TodoService todoService;

    TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponse> getTodo(
            @PathVariable String id
    ) {
        TodoResponse todoResponse = todoService.getTodo(id);
        return ResponseEntity.ok(todoResponse);
    }
}
