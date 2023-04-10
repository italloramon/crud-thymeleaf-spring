package com.italloramon.service;

import java.util.List;

import com.italloramon.model.Student;

public interface StudentService {
	
	Student getStudentById(Long id);
	
	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student updateStudent(Student student);
	
	void deleteStudentById(Long id);
}
