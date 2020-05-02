package com.task.accessingdatamysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int number;
    private String diffDays;
    private String dueDate	;
    private String finishedDate;

    public Task() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDiffDays() {
		return diffDays;
	}

	public void setDiffDays(String diffDays) {
		this.diffDays = diffDays;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getFinishedDate() {
		return finishedDate;
	}

	public void setFinishedDate(String finishedDate) {
		this.finishedDate = finishedDate;
	}
	
	public Task(int number, String diffDays, String dueDate,  String finishedDate) {
	  this.number = number;
	  this.diffDays = diffDays;
	  this.dueDate = dueDate;
	  this.finishedDate = finishedDate;
    }
	
}





