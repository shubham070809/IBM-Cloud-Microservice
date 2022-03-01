package com.example.studentrestapiassignment.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentrestapiassignment.service.StudentService;
import com.example.studentrestapiassignment.ui.StudentRequestModel;

@RestController
public class StudentController {
	
	private final ModelMapper modelMapper;
    private final StudentService studentService;

    public StudentController(ModelMapper modelMapper, StudentService studentService) {
        this.modelMapper = modelMapper;
        this.studentService = studentService;
    }
    
    @GetMapping("/students")
    public ResponseEntity<List<StudentRequestModel>> getUsers()
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<StudentRequestModel> list=new ArrayList<>();
        List<StudentRequestModel> studentRequestModel=studentService.getAllStudent();
        for (StudentRequestModel d:studentRequestModel)
        {
            list.add(modelMapper.map(d,StudentRequestModel.class));
        }
       
        return ResponseEntity.ok(list);
    }
    
    @PostMapping("/students")
    public ResponseEntity<StudentRequestModel> createUser(@RequestBody StudentRequestModel userRequestModel)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        StudentRequestModel studentRequestModel=modelMapper.map(userRequestModel,StudentRequestModel.class);
//        userDto.setUserId(UUID.randomUUID().toString());
        studentRequestModel=studentService.createStudent(userRequestModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(studentRequestModel,StudentRequestModel.class));
    }
    
    
    @GetMapping("/students/{studentId}")
    public ResponseEntity<StudentRequestModel> findByStudentId(@PathVariable("studentId") int studentId)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return ResponseEntity.ok(modelMapper.map(studentService.findByStudentId(studentId),StudentRequestModel.class));
    }
    
    @DeleteMapping("/students/{studentId}")
    public void deleteByStudentId(@PathVariable("studentId") int studentId)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        studentService.deleteByStudentId(studentId);
    }
    
    @PutMapping("/students/{studentId}")
    public ResponseEntity<StudentRequestModel> updateByStudentId(@RequestBody StudentRequestModel studentRequestModel,@PathVariable("studentId") int studentId)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return ResponseEntity.ok(modelMapper.map(studentService.updateByStudentID(studentRequestModel,studentId),StudentRequestModel.class));
        
    }
    
    

}
