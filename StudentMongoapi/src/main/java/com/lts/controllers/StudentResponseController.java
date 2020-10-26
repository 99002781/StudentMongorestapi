package com.lts.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lts.exception.StudentNotFoundException;
import com.lts.model.Student;
import com.lts.service.StudentService;

@RestController
@RequestMapping("/student-api")
public class StudentResponseController {
	@Autowired
	StudentService studentService;
	@PostMapping("/students")
    ResponseEntity<Student> addBook(@RequestBody Student student) {
        Student nstudent = studentService.addStudent(student);
        return ResponseEntity.ok(nstudent);
    }
    @GetMapping("/students/get-one/{stdId}")
    ResponseEntity<Student> getStudentById(@PathVariable("stdId")Integer stdid) throws StudentNotFoundException{
        Student nstudent = studentService.getStudentById(stdid);
        HttpHeaders header = new HttpHeaders();
        header.add("desc", "Getting student by Id");
        header.add("title", "One Student");
        return ResponseEntity.status(HttpStatus.OK)
                .headers(header).body(nstudent);
    }
    @GetMapping("/students")
    ResponseEntity<List<Student>> getAllStudents(){
        List<Student> studentList =  studentService.getAllStudents();
        return ResponseEntity.ok(studentList);
    }
    @GetMapping("/students/name/{name}")
    ResponseEntity<List<Student>> getStudentByName(@PathVariable("name")String name) throws StudentNotFoundException{
        List<Student> studentList =  studentService.getStudentByName(name);
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("/students/department/{department}")
    ResponseEntity<List<Student>> getStudentByDepartment(@PathVariable("department")String department) throws StudentNotFoundException{
        List<Student> studentList =  studentService.getStudentByDepartment(department);
        return ResponseEntity.ok(studentList);
    }


    @GetMapping("/students/age/{age}")
    ResponseEntity<List<Student>> findByAge(@PathVariable("age")Integer age) throws StudentNotFoundException{
        List<Student> studentList =  studentService.findByAge(age);
        return ResponseEntity.ok(studentList);
    }

}
