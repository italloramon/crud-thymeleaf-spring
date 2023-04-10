package com.italloramon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.italloramon.model.Student;
import com.italloramon.service.StudentService;

import jakarta.validation.Valid;

@Controller
public class StudentController {
	
	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		//Create student object to hold student form data
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		if (result.hasErrors()) {
			return "create_student";
		}
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}") 
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
		Student olderStudent = studentService.getStudentById(id);
		olderStudent.setId(id);
		olderStudent.setFirstName(student.getFirstName());
		olderStudent.setLastName(student.getLastName());
		olderStudent.setEmail(student.getEmail());
		
		studentService.updateStudent(olderStudent);
		
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
}
