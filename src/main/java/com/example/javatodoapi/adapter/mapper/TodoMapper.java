package com.example.javatodoapi.adapter.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.javatodoapi.adapter.dto.response.TodoResponse;
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

    public static List<TodoResponse> mapToTodoResponseList(List<Todo> todoList) {
        return todoList.stream().map(TodoMapper::mappingToTodoResponse).collect(Collectors.toList());
    }

}
