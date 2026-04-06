package com.gokul.spring_reactive_mongodb;

import com.gokul.spring_reactive_mongodb.model.Student;
import com.gokul.spring_reactive_mongodb.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.mongodb.MongoDBContainer;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.awaitility.Awaitility.await;

@SpringBootTest
@Testcontainers
public class StudentServiceTest {

    @Container
    @ServiceConnection
    private static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:latest");

    @Autowired
    private StudentService studentService;


    @Test
    public void saveStudent() {
        Student testStudent = getStudent();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Mono<Student> saveMono = studentService.saveStudent(testStudent);
        saveMono.subscribe(student -> {
            System.out.println(student.getName());
            atomicBoolean.set(true);
        });
        await().untilTrue(atomicBoolean);
    }

    private Student getStudent() {
        return Student.builder().name("gokul").surname("karunaharan").build();
    }
}
