package com.gl.fest.service;
import com.gl.fest.model.*;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.fest.repository.Studentrepository;

@Service
public class Studentservice {
	
	@Autowired
	private Studentrepository repo;
	public List< Student > listAll() {
		return repo.findAll();
	    }
	    
	    public void save(Student std) {
	        repo.save(std);
	    }
	    
	    public Student get(long id) {
	        return repo.findById(id).get();
	    }
	    
	    public void delete(long id) {
	        repo.deleteById(id);
	    }
	 
	}

