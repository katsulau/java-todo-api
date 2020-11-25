package com.example.javatodoapi.service;

import org.springframework.stereotype.Service;

import com.example.javatodoapi.adapter.dto.TodoResponse;
import com.example.javatodoapi.adapter.mapper.TodoMapper;
import com.example.javatodoapi.infrastructure.TodoRepository;
import com.example.javatodoapi.infrastructure.Todo;
import com.example.javatodoapi.model.exception.NotFoundException;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoResponse getTodo(String uuid) {
        Todo todo = todoRepository.findById(uuid).orElseThrow(() -> new NotFoundException("商品が見つかりません"));
        return TodoMapper.mappingToTodoResponse(todo);
    }
}
