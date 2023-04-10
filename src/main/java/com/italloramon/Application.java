package com.italloramon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.italloramon.model.Student;
import com.italloramon.repository.StudentRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student student1 = new Student("Itallo Ramon", "Veiga Paranhos", "irvp@ic.ufal.br");
		Student student2 = new Student("Carlos", "Eduardo de Melo Gomes", "cemg@ic.ufal.br");
		Student student3 = new Student("Daniel", "José da Silva", "djsp@ic.ufal.br");
		Student student4 = new Student("Rafael", "Silva Santos", "rssp@ic.ufal.br");
		studentRepository.save(student1);
		studentRepository.save(student2);
		studentRepository.save(student3);
		studentRepository.save(student4);
		
	}

}
