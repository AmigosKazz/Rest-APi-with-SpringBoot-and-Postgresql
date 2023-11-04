package com.example.CrudAPI.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student mariam = new Student(
                    "Mariam",
                    LocalDate.of(2000, 1, 5),
                    "kaznrahandrinavo@gmail.com");
            Student alex = new Student(
                    "Alex",
                    LocalDate.of(2003, 4, 5),
                    "Alex@gmail.com");
            Student kazz = new Student(
                    "kazz",
                    LocalDate.of(2000, 1, 5),
                    "kazz@gmail.com");

            studentRepository.saveAll(
                    List.of(mariam, alex, kazz)
            );
        };

}
}
