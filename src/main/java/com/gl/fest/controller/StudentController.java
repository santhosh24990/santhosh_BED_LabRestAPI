package com.gl.fest.controller;

import java.util.List;
import java.util.Optional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gl.fest.service.Studentservice;
import com.gl.fest.model.Student;

@Controller
@RequestMapping ("students")
public class StudentController {
    
	@Autowired
    private Studentservice service;
	
 
    @GetMapping("list")
    public String showstudents(Model model) {
        List<Student> liststudent = service.listAll();
        model.addAttribute("liststudent", liststudent);
        return "student-list";
    }
 
    @GetMapping("showstudentform")
    public String add(Model model) {
    	Student student = new Student();
        model.addAttribute("student", student);
        return "student-form";
    }
 
    @PostMapping("save")
    public String saveStudent(@ModelAttribute("student") Student std) {
        service.save(std);
        return "redirect:/students/list";
    }
 
    @RequestMapping("update")
    public String showEditStudentPage(Model model,@RequestParam("id") int id) {
     Student updatedstudent = service.get(id);
     
     model.addAttribute("student", updatedstudent);
	return "student-form";
        
    }
    @RequestMapping ("delete")
    public String deletestudent(Model model,
			@RequestParam("id") int id) {
        service.delete(id);
        return "redirect:/students/list";
    }
}
