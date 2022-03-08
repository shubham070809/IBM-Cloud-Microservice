package com.example.todoangular;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.todoangular.model.ToDo;
import com.example.todoangular.repo.ToDoRepository;


@SpringBootApplication
public class TodoAngularApplication implements CommandLineRunner{
	private final ToDoRepository toDoRepository;

	
	
	public TodoAngularApplication(ToDoRepository toDoRepository) {
		super();
		this.toDoRepository = toDoRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(TodoAngularApplication.class, args);
	}
	
	@Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		toDoRepository.save(new ToDo(1,"Recharge TV",true));
		toDoRepository.save(new ToDo(2,"Recharge Phone",true));
		toDoRepository.save(new ToDo(3,"Recharge Net",false));
	}
	

}
