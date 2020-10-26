package com.lts.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lts.exception.StudentNotFoundException;
import com.lts.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student,Integer>{
	List<Student>findByAge(Integer age);
	Student getStudentById(Integer stdId) throws StudentNotFoundException;
	List<Student> getAllStudents()throws StudentNotFoundException;
	List<Student>getByName(String name)throws StudentNotFoundException;
	List<Student>getStudentByCity(String city)throws StudentNotFoundException;
	List<Student>getStudentByDepartment(String department)throws StudentNotFoundException;


}
