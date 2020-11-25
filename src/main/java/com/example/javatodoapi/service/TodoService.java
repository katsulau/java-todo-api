package com.example.javatodoapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.javatodoapi.adapter.dto.request.RegisterTodoRequest;
import com.example.javatodoapi.adapter.dto.request.UpdateTodoRequest;
import com.example.javatodoapi.adapter.dto.response.TodoResponse;
import com.example.javatodoapi.adapter.mapper.TodoMapper;
import com.example.javatodoapi.infrastructure.TodoRepository;
import com.example.javatodoapi.infrastructure.Todo;
import com.example.javatodoapi.model.exception.BadRequestException;
import com.example.javatodoapi.model.exception.NotFoundException;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    public List<TodoResponse> getTodoList() {
        List<Todo> todoList = todoRepository.findAll();
        return TodoMapper.mapToTodoResponseList(todoList);
    }

    public TodoResponse getTodo(String uuid) {
        Todo todo = todoRepository.findById(uuid).orElseThrow(() -> new NotFoundException("商品が見つかりません"));
        return TodoMapper.mappingToTodoResponse(todo);
    }

    public void registerTodo(RegisterTodoRequest registerTodoRequest) {
        String title = registerTodoRequest.getTitle();

        Todo todoTable = todoRepository.findByTitleEquals(title);

        if (todoTable != null) {
            throw new BadRequestException("すでに同じTodoが存在します");
        }

        try {
            Todo todo = new Todo();
            todo.setNewTodo(title);
            todoRepository.save(todo);
        } catch (Exception exception) {
            throw new BadRequestException(exception.getMessage(), exception);
        }
    }

    public void updateTodo(String id, UpdateTodoRequest updateTodoRequest) {
        String updatedTitle = updateTodoRequest.getTitle();

        Todo todoTable = todoRepository.findByTitleEqualsAndIdNot(updatedTitle, id);

        // 更新対象のTodoのタイトルが、他のTodoと被らないか
        if (todoTable != null) {
            throw new BadRequestException("すでに同じTodoが存在します");
        }

        // 更新対象のTodoが存在するか
        Todo targetTodoTable = todoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("更新対象のTodoが存在しません"));

        // Todoのタイトルが、128字以内か
        targetTodoTable.updateTodo(updatedTitle);

        todoRepository.save(targetTodoTable);
    }


    public void deleteTodo(String id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow( () -> new NotFoundException("削除対象のTodoが存在しません"));
        todoRepository.delete(todo);
    }
}
