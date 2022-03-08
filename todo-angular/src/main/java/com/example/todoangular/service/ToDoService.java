package com.example.todoangular.service;

import java.util.List;

import com.example.todoangular.ui.RequestModel;
import com.example.todoangular.ui.ResponseModel;

public interface ToDoService {
	
	public ResponseModel createTask(RequestModel requestModel);
	public void deleteTask(Integer id);
	public List<ResponseModel> getTasks();
	public ResponseModel getTaskById(Integer id);
	public ResponseModel updateTask(RequestModel requestModel,Integer id);
	

}
