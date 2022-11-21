package com.lumidii.tasktrackerapi.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name= "TASK_TBL")
public class Task {
	
	@Id
	@GeneratedValue
	private int id;
	private String text;
	private String day;
	private boolean reminder;
}
