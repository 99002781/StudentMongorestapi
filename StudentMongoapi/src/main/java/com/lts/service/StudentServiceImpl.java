package com.lts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lts.dao.StudentRepository;
import com.lts.exception.StudentNotFoundException;
import com.lts.model.Student;

@Service
public class StudentServiceImpl implements StudentService{
@Autowired
StudentRepository studentRepository;
	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		Student newstudent=studentRepository.save(student);
		return newstudent;
	}

	@Override
	public  Student getStudentById(Integer stdId) throws StudentNotFoundException {
		       return studentRepository.findById(stdId)
				.orElseThrow(()->new StudentNotFoundException("ID not available"));
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public List<Student> getStudentByName(String name) throws StudentNotFoundException {
		List<Student>studentList=studentRepository.getByName(name);
		if(studentList.isEmpty()) {
			throw new StudentNotFoundException("student not available");
		}
		return studentList;
	}
		// TODO Auto-generated method stub
		

	@Override
	public List<Student> getStudentByCity(String city) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		List<Student>studentList=studentRepository.getStudentByCity(city);
		if(studentList.isEmpty()) {
			throw new StudentNotFoundException("student not available");
		}
		return studentList;
	}

	@Override
	public List<Student> getStudentByDepartment(String department) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		List<Student>studentList=studentRepository.getStudentByDepartment(department);
		if(studentList.isEmpty()) {
			throw new StudentNotFoundException("student not available");
		}
		return studentList;
	}

	@Override
	public List<Student> findByAge(Integer age) throws StudentNotFoundException {
		List<Student>studentList=studentRepository.findByAge(age);
		if(studentList.isEmpty()) {
			throw new StudentNotFoundException("student not available");
		}
		return studentList;
	}


}
