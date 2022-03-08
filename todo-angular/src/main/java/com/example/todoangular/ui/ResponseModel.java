package com.example.todoangular.ui;


public class ResponseModel {
	
	private Integer id;
	
	private String todoName;
	 
	private boolean isComplete;

	public ResponseModel() {
		super();
	}

	public ResponseModel(Integer id, String todoName, boolean isComplete) {
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
