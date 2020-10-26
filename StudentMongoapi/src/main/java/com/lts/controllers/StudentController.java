package com.lts.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lts.exception.StudentNotFoundException;
import com.lts.model.Student;
import com.lts.service.StudentService;

public class StudentController {
	@Autowired
StudentService studentService;
@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
	return studentService.addStudent(student);
}
@GetMapping("/students/get-one/{stdId}")
public Student getStudentById(@PathVariable("stdId")Integer stdId) throws StudentNotFoundException {
	return studentService.getStudentById(stdId);
	
}
@GetMapping("/students/name/{name}")
public List<Student> getStudentByName(@PathVariable("name")String name) throws StudentNotFoundException{
	return studentService.getStudentByName(name);
}

@GetMapping("/students/department/{department}")
public List<Student> getStudentByDepartment(@PathVariable("department")String department) throws StudentNotFoundException{
	return studentService.getStudentByDepartment(department);
}
@GetMapping("/students/get-one/{age}")
public List<Student> findByAge(@PathVariable("age")Integer age) throws StudentNotFoundException {
	return studentService.findByAge(age);
	
}
}
