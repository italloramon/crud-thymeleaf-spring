package com.italloramon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.italloramon.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
