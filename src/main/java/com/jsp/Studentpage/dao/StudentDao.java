package com.jsp.Studentpage.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Studentpage.dto.Student;
import com.jsp.Studentpage.repository.StudentRepository;

@Repository
public class StudentDao {
	  
	@Autowired
	StudentRepository studentRepo;
	
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}
	
//	public List<Student> findAll() {
//		return studentRepo.findAll();
//	}
	
}
 