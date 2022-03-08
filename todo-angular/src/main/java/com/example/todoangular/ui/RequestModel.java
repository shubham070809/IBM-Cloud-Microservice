package com.example.todoangular.ui;

public class RequestModel {
	
	private String todoName;
	 
	private boolean isComplete;

	public RequestModel() {
		super();
	}

	public RequestModel(String todoName, boolean isComplete) {
		super();
		this.todoName = todoName;
		this.isComplete = isComplete;
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
