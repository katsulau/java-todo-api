package com.example.javatodoapi.infrastructure;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sun.istack.NotNull;

import lombok.Data;

@Entity
@Data
public class Todo {

    @Id
    private String id;

    private String title;

    private boolean isFinished;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
