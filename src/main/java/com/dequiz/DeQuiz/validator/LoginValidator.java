package com.dequiz.DeQuiz.validator;
import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.dequiz.DeQuiz.dto.DeQuizLogin;
import com.dequiz.DeQuiz.repo.DeQuizLoginDBRepo;


public class LoginValidator implements ConstraintValidator<LoginIdConstraint, Object> {
	
	@Autowired
	DeQuizLoginDBRepo logindbRepo;
	
	private DeQuizLogin quizLogin;
	
	 @Override
	    public void initialize(LoginIdConstraint loginId) {
	    }
	    @Override
	    public boolean isValid(Object value,
	      ConstraintValidatorContext cxt) {
	    	
	    	System.out.println("print the object-----user id is--->>>>>>>"+((DeQuizLogin)value).getDqlUserId());
	    	return value != null && ((DeQuizLogin)value).getDqlUserId()!=null && getAdmin(((DeQuizLogin)value).getDqlUserId())!=null
	    			&& ((DeQuizLogin)value).getDqlPassword()!=null && getAdmin(((DeQuizLogin)value).getDqlUserId()).getDqlPassword()!=null
	    			&& ((DeQuizLogin)value).getDqlPassword().equals(getAdmin(((DeQuizLogin)value).getDqlUserId()).getDqlPassword());
	    }
	
	  private DeQuizLogin getAdmin(String userIdfield){

	  System.out.println("Inside getAdmin"); 
	  Optional<DeQuizLogin> dequizLoginMap =logindbRepo.findById(userIdfield); 
	  if(dequizLoginMap.isPresent()) { 
		  quizLogin = dequizLoginMap.get();
	  System.out.println("Inside getAdmin getting mailid"+quizLogin.getDqlEmail());
	  } return quizLogin;
	  
	  }
	 
}
		  
	  

