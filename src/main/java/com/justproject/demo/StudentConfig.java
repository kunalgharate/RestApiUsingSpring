package com.justproject.demo;


import com.justproject.demo.entities.Student;
import com.justproject.demo.repos.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class StudentConfig {
    List<Student> list = new ArrayList<Student>();

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository)
    {
        return args ->
        {
         Student kunal =   new Student("Kunal Gharate", LocalDate.of(1993, Month.NOVEMBER,17),"kunal@gmail.com");
            Student aditi =   new Student("Aditi Gharate", LocalDate.of(1998, Month.OCTOBER,04),"aditi@gmail.com");

            list.clear();
            list.add(kunal);
            list.add(aditi);

            studentRepository.saveAll(list);
        };


    }
}
