package com.jsp.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.task.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
}
