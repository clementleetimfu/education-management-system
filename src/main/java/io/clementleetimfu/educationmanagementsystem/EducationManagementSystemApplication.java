package io.clementleetimfu.educationmanagementsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("io.clementleetimfu.educationmanagementsystem.mapper")
@SpringBootApplication
public class EducationManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EducationManagementSystemApplication.class, args);
    }

}
