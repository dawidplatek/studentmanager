package com.platekdawid.studentmanager.service;

import com.platekdawid.studentmanager.exception.UserNotFoundException;
import com.platekdawid.studentmanager.model.Student;
import com.platekdawid.studentmanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudentById(Long id) {
        return studentRepository.findStudentById(id)
                .orElseThrow(()-> new UserNotFoundException("User by id" + id + "was not found"));
    }
    public void deleteStudent(Long id) {
        studentRepository.deleteStudentById(id);
    }
}

