package com.example.boxes;

import com.example.boxes.service.Parser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BoxesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoxesApplication.class, args);
	}
	@Bean
	public Parser getParser (){
		return new Parser();
	}

}
