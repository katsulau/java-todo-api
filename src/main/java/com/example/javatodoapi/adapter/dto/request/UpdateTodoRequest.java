package com.example.javatodoapi.adapter.dto.request;

import lombok.Data;

@Data
public class UpdateTodoRequest {
    private String title;
    private boolean isFinished;
}
