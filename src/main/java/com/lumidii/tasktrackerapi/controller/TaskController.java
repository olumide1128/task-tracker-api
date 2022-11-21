package com.lumidii.tasktrackerapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.lumidii.tasktrackerapi.Entity.Task;
import com.lumidii.tasktrackerapi.repository.TaskRepository;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/tasks")
public class TaskController {
	
	@Autowired
	private TaskRepository repo;
	
	@GetMapping
	public ResponseEntity<List<Task>> getTasks(){
		return ResponseEntity.ok(repo.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Task> getTask(@PathVariable Integer id) throws Exception{
		Optional<Task> task = repo.findById(id);
		if (task == null) {
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Task with id %d not found", id));
		}
		
		return ResponseEntity.ok(task.get());
	}
	
	@PostMapping
	public ResponseEntity<Task> createTask(@RequestBody Task task) {
		return ResponseEntity.ok(repo.save(task));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Task> updateTaskReminder(@RequestBody Task task, @PathVariable Integer id){
		Task existingTask = repo.findById(id).orElse(null);
		
		existingTask.setText(task.getText());
		existingTask.setDay(task.getDay());
		existingTask.setReminder(task.isReminder());
		
		return ResponseEntity.ok(repo.save(existingTask));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Task> deleteTask(@PathVariable Integer id) {
		repo.deleteById(id);
		Task t = repo.findById(id).orElse(null);
		return ResponseEntity.ok(t);
	}
		
}
