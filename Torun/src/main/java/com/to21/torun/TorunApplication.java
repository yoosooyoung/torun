package com.to21.torun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@MapperScan(value= {"com.to21.torun.mapper"})
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class TorunApplication {

	public static void main(String[] args) {
		SpringApplication.run(TorunApplication.class, args);
	}
}
