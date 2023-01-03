package com.lumidii.tasktrackerapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lumidii.tasktrackerapi.Entity.Task;
import com.lumidii.tasktrackerapi.repository.TaskRepository;

@SpringBootApplication
public class TaskTrackerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskTrackerApiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner init(TaskRepository taskRepo) {
		return args -> {
			taskRepo.save(new Task("9th, January, 2023", "Visit Therapy", false));
			taskRepo.save(new Task("26th, March, 2023", "Workout", true));
			taskRepo.save(new Task("2nd, January, 2023", "Do Laundry", false));
		};
	}

}
