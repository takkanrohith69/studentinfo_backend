package com.jsp.Studentpage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.Studentpage.dto.Student;



public interface StudentRepository extends JpaRepository<Student, Integer> {
	//public Student findByEmail(String email);
 

}
  