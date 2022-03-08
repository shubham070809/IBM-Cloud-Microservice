package com.example.todoangular.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoangular.model.ToDo;
import com.example.todoangular.repo.ToDoRepository;
import com.example.todoangular.ui.RequestModel;
import com.example.todoangular.ui.ResponseModel;

@Service
public class ToDoServiceImpl implements ToDoService{

	private final ModelMapper modelMapper;
	private final ToDoRepository toDoRepository;
	
	
	@Autowired
	public ToDoServiceImpl(ModelMapper modelMapper, ToDoRepository toDoRepository) {
		super();
		this.modelMapper = modelMapper;
		this.toDoRepository = toDoRepository;
	}
	
	@Override
	public ResponseModel createTask(RequestModel requestModel) {
		// TODO Auto-generated method stub
	    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	    ToDo todo =modelMapper.map(requestModel,ToDo.class);
	    todo=toDoRepository.save(todo);
	    return modelMapper.map(todo,ResponseModel.class);
	}

	@Override
	public void deleteTask(Integer id) {
		// TODO Auto-generated method stub
		ToDo todo=toDoRepository.getById(id);
		if(todo==null)
		{
			System.out.println("No task with task id "+id+" found");
		}
		toDoRepository.delete(todo);
	}

	@Override
	public List<ResponseModel> getTasks() {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	    List<ResponseModel> list=new ArrayList<>();
	    Iterable<ToDo> iterable= toDoRepository.findAll();
	    Iterator<ToDo> iterator= iterable.iterator();
	    while (iterator.hasNext())
	    {
	    	list.add(modelMapper.map(iterator.next(),ResponseModel.class));
	       }
	        return list;
	}

	@Override
	public ResponseModel getTaskById(Integer id) {
		// TODO Auto-generated method stub
		ToDo todo=toDoRepository.getById(id);
		if(todo==null)
		{
			System.out.println("No task with task id "+id+" found");
		}
		return modelMapper.map(todo,ResponseModel.class);
	}

	@Override
	public ResponseModel updateTask(RequestModel requestModel, Integer id) {
		// TODO Auto-generated method stub
		ToDo todo=toDoRepository.getById(id);
		if(todo==null)
		{
			System.out.println("No task with task id "+id+" found");
		}
		
		todo.setTodoName(requestModel.getTodoName());
		todo.setComplete(requestModel.isComplete());
		todo=toDoRepository.save(todo);
		return modelMapper.map(todo,ResponseModel.class);
	}
	

}
