package com.to21.torun;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@MapperScan(basePackages = "com.to21.torun", annotationClass = Mapper.class)
public class TorunApplication {

	public static void main(String[] args) {
		SpringApplication.run(TorunApplication.class, args);
	}
}
