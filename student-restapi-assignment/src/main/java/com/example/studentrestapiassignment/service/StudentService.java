package com.example.studentrestapiassignment.service;

import java.util.List;

import com.example.studentrestapiassignment.ui.StudentRequestModel;

public interface StudentService {
	public StudentRequestModel createStudent(StudentRequestModel requestModel);
    public List<StudentRequestModel> getAllStudent();
	public StudentRequestModel findByStudentId(int userId);
	public void deleteByStudentId(int studentId);
	public StudentRequestModel updateByStudentID(StudentRequestModel studentRequestModel, int studentId);

}
