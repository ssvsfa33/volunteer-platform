package com.volunteer.volunteerplatform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.volunteer.volunteerplatform.mapper")  // 加上这行！
public class VolunteerPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(VolunteerPlatformApplication.class, args);
    }
}