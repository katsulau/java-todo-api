package com.example.javatodoapi.adapter.mapper;

import org.springframework.stereotype.Component;

import com.example.javatodoapi.adapter.dto.TodoResponse;
import com.example.javatodoapi.infrastructure.Todo;

@Component
public class TodoMapper {

    public static TodoResponse mappingToTodoResponse(Todo todo) {
        TodoResponse todoResponse =  new TodoResponse();

        todoResponse.setId(todo.getId());
        todoResponse.setTitle(todo.getTitle());
        todoResponse.setFinished(todo.isFinished());
        todoResponse.setCreatedAt(todo.getCreatedAt());
        todoResponse.setUpdatedAt(todo.getUpdatedAt());

        return todoResponse;
    }
}
