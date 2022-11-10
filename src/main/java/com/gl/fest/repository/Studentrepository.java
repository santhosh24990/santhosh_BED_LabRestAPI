package com.gl.fest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.fest.model.Student;



@Repository
public interface Studentrepository extends JpaRepository<Student, Long>{
	
	

}
