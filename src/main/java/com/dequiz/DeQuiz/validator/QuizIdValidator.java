package com.dequiz.DeQuiz.validator;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.dequiz.DeQuiz.dto.DeQuizMaster;
import com.dequiz.DeQuiz.repo.DeQuizMasterDBRepo;


public class QuizIdValidator implements ConstraintValidator<QuizIdConstraint, Integer> {
	
	@Autowired
	DeQuizMasterDBRepo masterdbRepo;
	
	private List<DeQuizMaster> qlist;
	
	 @Override
	    public void initialize(QuizIdConstraint quizId) {
	    }
	    @Override
	    public boolean isValid(Integer quizIdField,
	      ConstraintValidatorContext cxt) {
	    	
	    	if(masterdbRepo==null) {
	    		return true;
	    	}
	      qlist = getMasterList(quizIdField);
          return quizIdField!=null && qlist!=null && qlist.size()>0
        		  && qlist.get(0)!=null 
        		  && qlist.get(0).getDeqmQuizActive()!=null && qlist.get(0).getDeqmQuizActive().equalsIgnoreCase("Y") ;
	    }
	    
	  private List<DeQuizMaster> getMasterList(Integer quizId){
		  
		  List<DeQuizMaster> qMlist = masterdbRepo.findByDeqmQuizId(quizId);
		  return qMlist;
		  
	  }
}
