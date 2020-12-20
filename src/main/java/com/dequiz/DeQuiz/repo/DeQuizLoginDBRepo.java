package com.dequiz.DeQuiz.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dequiz.DeQuiz.dto.DeQuizLogin;

@Repository
public interface DeQuizLoginDBRepo extends JpaRepository <DeQuizLogin, String>{
	
	Optional<DeQuizLogin> findByDqlEmail(String dqlEmail);
	

}
