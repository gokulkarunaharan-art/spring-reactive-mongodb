package com.gokul.spring_reactive_mongodb.webflux.fn;

import com.gokul.spring_reactive_mongodb.model.Student;
import com.gokul.spring_reactive_mongodb.repository.StudentRepository;
import com.gokul.spring_reactive_mongodb.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@RestController
//@RequiredArgsConstructor
//public class OldController {
//    private final StudentService studentService;
//    private static final String STUDENT = "/api/student";
//    private static final String STUDENT_ID = "/api/student/{studentId}";
//
//    @GetMapping(STUDENT)
//    public Flux<Student> getStudents() {
//        return studentService.getAllStudents();
//    }
//    @DeleteMapping(STUDENT_ID)
//    public Mono<Void> deleteStudentById(@PathVariable String studentId) {
//        return studentService.deleteStudentById(studentId);
//    }
//    @PostMapping(STUDENT)
//    public Mono<Student> saveStudent(@RequestBody Student student) {
//        return studentService.saveStudent(student);
//    }
//    @PutMapping(STUDENT_ID)
//    public Mono<Student> updateStudent(@PathVariable String studentId, @RequestBody Student student) {
//        return studentService.updateStudent(studentId,student);
//    }
//}
