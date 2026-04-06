package com.gokul.spring_reactive_mongodb.bootstrap;

import com.gokul.spring_reactive_mongodb.model.Student;
import com.gokul.spring_reactive_mongodb.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataPopulator implements CommandLineRunner {

    private final StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        LoadUsers();
    }

    public void LoadUsers(){
        studentRepository.deleteAll().thenMany(studentRepository.saveAll(List.of(
                Student.builder().name("John").surname("Doe").build(),
                Student.builder().name("Jane").surname("Doe").build(),
                Student.builder().name("Jane").surname("Doe").build(),
                Student.builder().name("Jane").surname("Doe").build()
        ))).subscribe();
    }
}
