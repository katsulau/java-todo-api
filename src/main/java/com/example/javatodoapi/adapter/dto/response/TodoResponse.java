package com.example.javatodoapi.adapter.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TodoResponse {

    private String id;

    private String title;

    private boolean isFinished;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
