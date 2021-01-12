package com.dequiz.DeQuiz.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dequiz.DeQuiz.dto.DeQuizLogin;
import com.dequiz.DeQuiz.repo.DeQuizLoginDBRepo;

@Service
public class DeQuizUserDetailsService implements UserDetailsService{

	@Autowired
	DeQuizLoginDBRepo deQuizLoginDBRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<DeQuizLogin> deQuizLoginMap = deQuizLoginDBRepo.findById(username);
		if(!deQuizLoginMap.isPresent()){
			throw new UsernameNotFoundException("user not found: " + username);
		}
		return new DeQuizUserDetails(deQuizLoginMap.get());
	}

}


