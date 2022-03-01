package com.example.studentrestapiassignment.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentrestapiassignment.entity.Student;
import com.example.studentrestapiassignment.repo.StudentRepository;
import com.example.studentrestapiassignment.ui.StudentRequestModel;


@Service
public class StudentServiceImpl implements StudentService{
	
	private final ModelMapper modelMapper;
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(ModelMapper modelMapper, StudentRepository studentRepository) {
        this.modelMapper = modelMapper;
        this.studentRepository = studentRepository;
    }


	@Override
	public StudentRequestModel createStudent(StudentRequestModel requestModel) {
		 modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	        Student student=modelMapper.map(requestModel,Student.class);
	        student=studentRepository.save(student);
	        return modelMapper.map(student,StudentRequestModel.class);
	}

	@Override
	public List<StudentRequestModel> getAllStudent() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	       List<StudentRequestModel> list=new ArrayList<>();
	        Iterable<Student> iterable= studentRepository.findAll();

	       Iterator<Student> iterator= iterable.iterator();
	       while (iterator.hasNext())
	       {
	           list.add(modelMapper.map(iterator.next(),StudentRequestModel.class));
	       }
	        return list;
	}


	@Override
	public StudentRequestModel findByStudentId(int studentId) {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		/*What does optional do??
		 * */
		Optional<Student> studentResponse=studentRepository.findById(studentId);
		Student student =studentResponse.get();
		//Student student=studentRepository.findById(studentId);
		return modelMapper.map(student,StudentRequestModel.class);
	}


	@Override
	public void deleteByStudentId(int studentId) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(studentId);
		
	}


	@Override
	public StudentRequestModel updateByStudentID(StudentRequestModel studentRequestModel, int studentId) {
		// TODO Auto-generated method stub
		Optional<Student> studentResponse=studentRepository.findById(studentId);
		Student student=studentResponse.get();
		
		student.setFirstName(studentRequestModel.getFirstName());
		student.setLastName(studentRequestModel.getLastName());
		student.setEmail(studentRequestModel.getEmail());
		student.setImages(studentRequestModel.getImages());
		
		studentRepository.save(student);
		
		return modelMapper.map(student,StudentRequestModel.class);
		
	}
	
}
