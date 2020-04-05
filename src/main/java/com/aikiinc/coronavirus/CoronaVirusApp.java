package com.aikiinc.coronavirus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CoronaVirusApp {

	public static void main(String[] args) {
		SpringApplication.run(CoronaVirusApp.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/virus/corona").allowedOrigins("http://localhost:9000");
				registry.addMapping("/api/virus/corona").allowedOrigins("http://localhost:4200");
				registry.addMapping("/api/virus/corona").allowedOrigins("https://pure-shore-41784.herokuapp.com");
			}
		};
	}
}
