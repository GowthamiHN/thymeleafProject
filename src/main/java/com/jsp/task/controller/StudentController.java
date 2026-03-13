package com.jsp.task.controller;

import java.util.List;
import java.util.jar.Attributes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jsp.task.entity.Student;
import com.jsp.task.repository.StudentRepository;

@Controller
public class StudentController {
	@Autowired
	StudentRepository studentRepository;

	@GetMapping({"/","/main"})
	public String main() {
		return "main.html";
	}
	
	@GetMapping("/add")
	public String add() {
		return "add.html";
	}
	@PostMapping("/add")
	public String loadAdd(Student student, RedirectAttributes attributes) {
		studentRepository.save(student);
		attributes.addFlashAttribute("message", "Data Added Successfully");
		return "redirect:/main";
	}
	@GetMapping("/manage")
	public String manage(ModelMap map) {
		List<Student> list=studentRepository.findAll();
		map.put("list", list);
		return "manage.html";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam int id, RedirectAttributes atrributes) {
		studentRepository.deleteById(id);
		atrributes.addFlashAttribute("msg", "Data deleted Success");
		return "redirect:/manage";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam int id,ModelMap map) {
		Student student= studentRepository.findById(id).orElseThrow();
		map.put("student", student);
		return "edit.html";
	}
	
	@PostMapping("/update")
	public String update(Student student, RedirectAttributes attributes) {
		studentRepository.save(student);
		attributes.addFlashAttribute("message", "Data Updated Successfully");
		return "redirect:/manage";
		
	}
}

