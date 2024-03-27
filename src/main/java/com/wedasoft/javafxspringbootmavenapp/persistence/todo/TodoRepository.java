package com.wedasoft.javafxspringbootmavenapp.persistence.todo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
