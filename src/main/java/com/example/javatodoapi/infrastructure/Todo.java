package com.example.javatodoapi.infrastructure;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

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

    public void setNewTodo(String title) {
        if (title.length() > 128) {
            throw new IllegalArgumentException("Todoの最大文字数を超えています");
        }

        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.isFinished = false;
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    public void updateTodo(String updatedTitle) {
        this.setTitle(updatedTitle);
        this.setUpdatedAt(LocalDateTime.now());
    }
}
