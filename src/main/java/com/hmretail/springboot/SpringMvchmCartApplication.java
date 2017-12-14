package com.hmretail.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.hmretail.springboot")
public class SpringMvchmCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvchmCartApplication.class, args);
	}
}
