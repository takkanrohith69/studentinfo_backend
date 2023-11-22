 package com.jsp.Studentpage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class StudentpageApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentpageApplication.class, args);
	}
	@Configuration
	public class webConfig implements WebMvcConfigurer{
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**")
			.allowedOrigins("*")
			.allowedMethods("GET" , "POST" , "PUT" , "DELETE" , "PATCH");
		}
	}   
  
} 

