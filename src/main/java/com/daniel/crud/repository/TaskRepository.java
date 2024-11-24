package com.daniel.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.daniel.crud.model.Task;

@Repository
public interface TaskRepository  extends JpaRepository<Task, Long>{
}
