package com.example.javatodoapi.infrastructure;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, String> {

    Todo findByTitleEquals(String title);

    Todo findByTitleEqualsAndIdNot(String title, String Id);
}
