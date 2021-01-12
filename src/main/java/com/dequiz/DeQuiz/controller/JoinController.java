package com.dequiz.DeQuiz.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.dequiz.DeQuiz.Websocket.WebSocketDAO;
import com.dequiz.DeQuiz.dto.DeQuizMaster;
import com.dequiz.DeQuiz.dto.DeQuizUser;
import com.dequiz.DeQuiz.repo.DeQuizUserDBRepo;

@Controller
public class JoinController {

	@Autowired
	DeQuizUserDBRepo deQuizUserRepo;
	@Autowired
	WebSocketDAO wsMessageDAO;

	/* when participant user plan to join a quiz - no input, post to joinQuiz with quizId and userName */
	@GetMapping("/joinQuiz")
	private String showForm(@Valid Model model) {
		DeQuizUser deQuizUser = new DeQuizUser();
		model.addAttribute("deQuizUser", deQuizUser);
		return "joinQuiz";
	}

	@GetMapping("/userInQuiz")
	public String userInQuiz(@Valid @ModelAttribute("deQuizUser") DeQuizUser deQuizUser, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "joinQuiz";
		} else {
			System.out.println("user received: " +deQuizUser.getDquUserName());
			// save user details in table
			Optional<DeQuizUser> deQuizUserMap = deQuizUserRepo.findByDquQuizIdAndDquUserName(deQuizUser.getDquQuizId(), deQuizUser.getDquUserName());
			if (deQuizUserMap.isEmpty()) {
				deQuizUser.setDquSessionId("Q:");
				deQuizUser.setDquAnswer("X");
				deQuizUser.setDquMarks(0);
				deQuizUser.setDquTotalMarks(0);
				deQuizUser.setDquQuestionNo(0);
				deQuizUserRepo.save(deQuizUser);
				System.out.println("writing user name");
			}
			else {
				deQuizUser = deQuizUserMap.get();
			}
			DeQuizMaster deQuizMaster = new DeQuizMaster ();
			deQuizMaster.setDeqmQuizId(deQuizUser.getDquQuizId());
			deQuizMaster.setDquUserName(deQuizUser.getDquUserName());
			deQuizMaster.setDquUserId(deQuizUser.getDquUserId());
			deQuizMaster.setDquUserName(deQuizUser.getDquUserName());
			
			model.addAttribute("deQuizMaster", deQuizMaster);
			model.addAttribute("deQuizUser", deQuizUser);
			return "userInQuiz";
		}
	}
	/*
	@PostMapping("/joinQuiz")
	public String submitForm(@Valid @ModelAttribute("deQuizUser") DeQuizUser deQuizUser, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "joinQuiz";
		} else {
			// save user details in table
			deQuizUser.setDquSessionId("Q:");
			deQuizUser.setDquAnswer("X");
			deQuizUser.setDquMarks(0);
			deQuizUser.setDquTotalMarks(0);
			deQuizUser.setDquQuestionNo(0);
			deQuizUserRepo.save(deQuizUser);
			
			DeQuizMaster deQuizMaster = new DeQuizMaster ();
			deQuizMaster.setDeqmQuizId(deQuizUser.getDquQuizId());
			deQuizMaster.setDquUserName(deQuizUser.getDquUserName());
			deQuizMaster.setDquUserId(deQuizUser.getDquUserId());
			deQuizMaster.setDquUserName(deQuizUser.getDquUserName());
			
			model.addAttribute("deQuizMaster", deQuizMaster);
			return "userInQuiz";
		}
	}*/
	
}
