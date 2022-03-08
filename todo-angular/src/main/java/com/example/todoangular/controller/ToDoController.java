package com.example.todoangular.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoangular.service.ToDoService;
import com.example.todoangular.ui.RequestModel;
import com.example.todoangular.ui.ResponseModel;

@RestController
public class ToDoController {
	
	private final ModelMapper modelMapper;
	
	private final ToDoService toDoService;

	@Autowired
	public ToDoController(ModelMapper modelMapper, ToDoService toDoService) {
		super();
		this.modelMapper = modelMapper;
		this.toDoService = toDoService;
	}
	
	@GetMapping("/todos")
	public ResponseEntity<List<ResponseModel>> getTasks()
	{
	    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	    List<ResponseModel> list=toDoService.getTasks();
	    return ResponseEntity.ok(list);
	    
	}
	
	@PostMapping("/todos")
	public ResponseEntity<ResponseModel> createTask(@RequestBody RequestModel requestModel)
	{
	    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ResponseModel responseModel=toDoService.createTask(requestModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(responseModel);
	}
	
	@DeleteMapping("/todosById/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		toDoService.deleteTask(id);
		return ResponseEntity.ok("Deletion Successful");
		
	}
	
	@GetMapping("/todosById/{id}")
	public ResponseEntity<ResponseModel> getTaskById(@PathVariable("id") Integer id)
	{
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ResponseModel responseModel=toDoService.getTaskById(id);
		return ResponseEntity.ok(responseModel);
	}
	
	@PutMapping("/todosById/{id}")
	public ResponseEntity<ResponseModel> updateTask(@RequestBody RequestModel requestModel,@PathVariable("id") Integer id)
	{
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ResponseModel responseModel=toDoService.updateTask(requestModel, id);
		return ResponseEntity.ok(responseModel);
	}
	
	
	
	

}
