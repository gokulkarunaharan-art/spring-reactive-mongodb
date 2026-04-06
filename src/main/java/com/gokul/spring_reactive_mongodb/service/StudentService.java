package com.gokul.spring_reactive_mongodb.service;

import com.gokul.spring_reactive_mongodb.model.Student;
import com.gokul.spring_reactive_mongodb.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Flux<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Mono<Student> getStudentById(String id) {
        return studentRepository.findById(id);
    }

    public Mono<Student> saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Mono<Student> updateStudent(String id, Student student) {
        return studentRepository.findById(id).flatMap(foundStudent->{
            foundStudent.setName(student.getName());
            foundStudent.setSurname(student.getSurname());
            return studentRepository.save(foundStudent);
        });
    }

    public Mono<Void> deleteStudentById(String id) {
         return studentRepository.deleteById(id);
    }

}
