package com.gokul.spring_reactive_mongodb.webflux.fn;

import com.gokul.spring_reactive_mongodb.model.Student;
import com.gokul.spring_reactive_mongodb.repository.StudentRepository;
import com.gokul.spring_reactive_mongodb.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class WebFluxHandler {

    private final StudentService studentService;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ServerResponse.ok().body(studentService.getAllStudents(), Student.class);
    }
    public  Mono<ServerResponse> findById(ServerRequest request) {
        return studentService.getStudentById(request.pathVariable("studentId")).flatMap(student ->  ServerResponse.ok().bodyValue(student)).switchIfEmpty(ServerResponse.notFound().build());
    }
    public Mono<ServerResponse> saveStudent(ServerRequest request) {
        return request.bodyToMono(Student.class).flatMap(studentService::saveStudent).flatMap(student ->ServerResponse.created(URI.create(RouterConfig.STUDENT + "/" + student.getId())).bodyValue(student));
    }
    public Mono<ServerResponse> deleteStudent(ServerRequest request) {
        return studentService.getStudentById(request.pathVariable("studentId"))
                .flatMap(student -> studentService.deleteStudentById(student.getId())
                        .then(ServerResponse.noContent().build()))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
    public Mono<ServerResponse> updateStudent(ServerRequest request) {
        return studentService.getStudentById(request.pathVariable("studentId"))
                .flatMap(existingStudent ->  request.bodyToMono(Student.class))
                .flatMap(student ->  ServerResponse.ok().bodyValue(student))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
