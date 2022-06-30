package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args->{

              Student ash =
                    new Student( "ash","ash@gmail.com", LocalDate.of(2000, Month.MAY,5));

              Student mani = new Student("mani","mani@gmail.com",LocalDate.of(2020,Month.MAY,7));
              repository.saveAll(List.of(ash,mani));

        };
    }
}
