package com.lumidii.tasktrackerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lumidii.tasktrackerapi.Entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

}
