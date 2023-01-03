package com.lumidii.tasktrackerapi.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name= "TASK_TBL")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="TEXT")
	private String text;
	
	@Column(name="`DAY`")
	private String day;
	
	@Column(name="REMINDER")
	private boolean reminder;

	
	//Constructor
	public Task(String day, String text, boolean reminder) {
		this.text = text;
		this.day = day;
		this.reminder = reminder;
	}
	
	
}
