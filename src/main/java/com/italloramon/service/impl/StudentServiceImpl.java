package com.italloramon.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.italloramon.model.Student;
import com.italloramon.repository.StudentRepository;
import com.italloramon.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	private final StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);
	}

}
