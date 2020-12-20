package com.dequiz.DeQuiz;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@EnableJpaRepositories("com.dequiz.DeQuiz.repo")
@SpringBootApplication

public class DeQuizApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(DeQuizApplication.class, args);
	}
	


}
