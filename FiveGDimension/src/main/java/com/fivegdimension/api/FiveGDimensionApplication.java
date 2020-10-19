package com.fivegdimension.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@CrossOrigin(origins = "http://localhost:4200")
public class FiveGDimensionApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiveGDimensionApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corConfigurer() {
		return new WebMvcConfigurer() {
			private final long MAX_AGE_SECS = 3600;

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedHeaders("*")
						.allowedMethods("HEAD", "OPTIONS", "GET", "POST", "PUT", "PATCH", "DELETE").exposedHeaders("Authorization")
						.allowCredentials(true).maxAge(MAX_AGE_SECS);
			}
		};
	}
}
