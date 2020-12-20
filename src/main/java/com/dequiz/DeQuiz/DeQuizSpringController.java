package com.dequiz.DeQuiz;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.dequiz.DeQuiz.dto.DeQuizMaster;
import com.dequiz.DeQuiz.dto.DeQuizUser;
import com.dequiz.DeQuiz.repo.DeQuizMasterDBRepo;
import com.dequiz.DeQuiz.repo.DeQuizUserDBRepo;
/*

@Controller
public class DeQuizSpringController {
	

	@Autowired
	DeQuizUserDBRepo deQuizUserRepo;
	
	@Autowired
	DeQuizMasterDBRepo deQuizMasterRepo;

	@GetMapping("/joinQuiz")
	private String showForm(@Valid Model model) {
		DeQuizUser deQuizUser = new DeQuizUser();
		model.addAttribute("deQuizUser", deQuizUser);
		return "register_form";
	}


	@PostMapping("/joinQuiz")
	public String submitForm(@Valid @ModelAttribute("deQuizUser") DeQuizUser deQuizUser, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "register_form";
		} else {
			deQuizUser.setDquSessionId("Q:");
			deQuizUser.setDquAnswer("X");
			deQuizUser.setDquMarks(0);
			deQuizUser.setDquTotalMarks(0);
			deQuizUser.setDquQuestionNo(0);
			deQuizUser.setDquTotalMarks(0);
			model.addAttribute("user", deQuizUser);
			deQuizUserRepo.save(deQuizUser);
			return "registerok";

		}
	}

	
	/* startquiz requires userId, quizId and questionNo */
/*	@PostMapping("/startquiz")
	private String showQuiz(@ModelAttribute("deQuizUser") DeQuizUser deQuizUser, Model model) {	
		Integer quizId = deQuizUser.getDquQuizId() * 100 + deQuizUser.getDquQuestionNo() + 1;
		DeQuizMaster deQuizMaster = new DeQuizMaster ();
	
		Optional<DeQuizMaster> deQuizMasterMap = deQuizMasterRepo.findById(quizId);
		if (!deQuizMasterMap.isPresent()){
			Optional <DeQuizUser> deQuizUserMap = deQuizUserRepo.findById(deQuizUser.getDquUserId());
			if (deQuizUserMap.isPresent()){
				deQuizUser = deQuizUserMap.get();
				model.addAttribute("deQuizUserName",deQuizUser.getDquUserName());
				model.addAttribute("deQuizTotalNumber",deQuizUser.getDquTotalMarks());
				List<DeQuizUser> deQuizUserList = new ArrayList<DeQuizUser>();
				deQuizUserList = deQuizUserRepo.findforResultDisplay(deQuizUser.getDquQuizId());
				if(null!=deQuizUserList && deQuizUserList.size()!=0 ) {
					List<DeQuizUser> userResultList = new ArrayList<DeQuizUser>();
					userResultList =deQuizUserList.stream().limit(10).collect(Collectors.toList());
					System.out.println("passing list: " + deQuizUserList);
					model.addAttribute("userResultList",userResultList);
				}
			}
			return "finalresult";
		}
		
	
		deQuizMaster = deQuizMasterMap.get();
		deQuizMaster.setDquUserId(deQuizUser.getDquUserId());
		model.addAttribute("deQuizMaster",deQuizMaster);
		return "startquiz";
	}
	
/*  showresult needs 4 parameters - quizId, questionNo, answer and userId*/
/*	@PostMapping("/showresult")
	private String showResult(@ModelAttribute("deQuizMaster") DeQuizMaster deQuizMaster, Model model){
		System.out.println("Correct Ans: " +deQuizMaster.getDeqmAnswer() + " Selected:" + deQuizMaster.getSelectedAnswer());
		
		DeQuizUser deQuizUser = new DeQuizUser();
		Optional<DeQuizUser> deQuizUserMap = deQuizUserRepo.findById(deQuizMaster.getDquUserId());
		if (!deQuizUserMap.isPresent()){
			return "error";
		}
		deQuizUser = deQuizUserMap.get();
		deQuizUser.setDquQuestionNo(deQuizMaster.getDeqmQuestionNo());
		deQuizUser.setDquMarks(0);
		switch (deQuizMaster.getDeqmAnswer()) {
		case "a":
		case "A":
			deQuizUser.setDquCorrectAns(deQuizMaster.getDeqmOption_a());
			break;
		case "b":
		case "B":
			deQuizUser.setDquCorrectAns(deQuizMaster.getDeqmOption_b());
			break;
		case "c":
		case "C":
			deQuizUser.setDquCorrectAns(deQuizMaster.getDeqmOption_c());
			break;
		case "d":
		case "D":
			deQuizUser.setDquCorrectAns(deQuizMaster.getDeqmOption_d());
			break;
		default:
			deQuizUser.setDquCorrectAns("Anser not given by Quiz Master");
		}
		
		if(deQuizMaster.getDeqmAnswer().equalsIgnoreCase(deQuizMaster.getSelectedAnswer())) {
			deQuizUser.setDquMarks(deQuizMaster.getDquMarks());
			deQuizUser.setDquTotalMarks(deQuizUser.getDquTotalMarks()+deQuizUser.getDquMarks());
		}
		deQuizUser.setDquSessionId(deQuizUser.getDquSessionId() + " " + deQuizMaster.getDeqmQuestionNo() + 
				deQuizMaster.getSelectedAnswer() + deQuizUser.getDquMarks());
		deQuizUserRepo.save(deQuizUser);	
		model.addAttribute("deQuizUser",deQuizUser);
		return "showresult";
	}
	
	@GetMapping("/showresult/{quizId}")
	private String showResult(@PathVariable("quizId") Integer quizId, @ModelAttribute("deQuizUser") DeQuizMaster deQuizUser, Model model) {
		System.out.println("inside the controller");
		List<DeQuizUser> deQuizUserList = new ArrayList<DeQuizUser>();
		deQuizUserList = deQuizUserRepo.findforResultDisplay(quizId);
		model.addAttribute("deQuizUserName","Show Top 10");
		model.addAttribute("deQuizTotalNumber",0);
		if(null!=deQuizUserList && deQuizUserList.size()!=0 ) {
			List<DeQuizUser> userResultList = new ArrayList<DeQuizUser>();
			userResultList =deQuizUserList.stream().limit(10).collect(Collectors.toList());
			model.addAttribute("userResultList",userResultList);
		}
		return "finalresult";
	}
}
*/