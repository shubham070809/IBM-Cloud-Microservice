package com.example.todoangular.model;

import javax.persistence.*;

@Entity
@Table(name="todoangular")
public class ToDo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name = "task_name")
	private String todoName;
	 
	@Column(name = "task_status")
	private boolean isComplete;

	public ToDo() {
		super();
	}

	public ToDo(Integer id, String todoName, boolean isComplete) {
		super();
		this.id = id;
		this.todoName = todoName;
		this.isComplete = isComplete;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTodoName() {
		return todoName;
	}

	public void setTodoName(String todoName) {
		this.todoName = todoName;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	
	
}
