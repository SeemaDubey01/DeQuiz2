package com.dequiz.DeQuiz.Multiplayer;

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
//@RequestMapping("/multiplayer")
public class DeQuizJoinController {

	@Autowired
	DeQuizUserDBRepo deQuizUserRepo;
	@Autowired
	WebSocketDAO wsMessageDAO;

	/* when participant user plan to join a quiz - no input, post to joinQuiz with quizId and userName */
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
// send message to admin that you have joined - quizId & userName
//			wsMessageDAO.participantJoined(deQuizUser.getDquQuizId(), deQuizUser.getDquUserName());
// add one check to see if quiz is active and muliplayer
			deQuizUser.setDquSessionId("Q:");
			deQuizUser.setDquAnswer("X");
			deQuizUser.setDquMarks(0);
			deQuizUser.setDquTotalMarks(0);
			deQuizUser.setDquQuestionNo(0);
			deQuizUserRepo.save(deQuizUser);
//			model.addAttribute("user", deQuizUser);
//			return "registerok";
			
			DeQuizMaster deQuizMaster = new DeQuizMaster ();
			deQuizMaster.setDeqmQuizId(deQuizUser.getDquQuizId());
			deQuizMaster.setDquUserName(deQuizUser.getDquUserName());
			deQuizMaster.setDquUserId(deQuizUser.getDquUserId());
			deQuizMaster.setDquUserName(deQuizUser.getDquUserName());
			
			model.addAttribute("deQuizMaster", deQuizMaster);
			return "userInQuiz";
		}
	}
/* Waiting for Admin to start the quiz - no userId, quizId & questionNo; output quizMaster, post participantDashboard*/
	@PostMapping("/startquiz")
	private String userStartQuiz(@ModelAttribute("deQuizMaster") DeQuizUser deQuizUser, Model model) {
// set the quiz status to Active		
		System.out.println("MP start quiz: " + deQuizUser);
		
		DeQuizMaster deQuizMaster = new DeQuizMaster ();
		deQuizMaster.setDeqmQuizId(deQuizUser.getDquQuizId());
		deQuizMaster.setDquUserName(deQuizUser.getDquUserName());
		deQuizMaster.setDquUserId(deQuizUser.getDquUserId());
		deQuizMaster.setDquUserName(deQuizUser.getDquUserName());
		
		model.addAttribute("deQuizMaster", deQuizMaster);
		return "userInQuiz";
	}
	
/* Admin starting the quiz - no input, output quizId, post adminStartQuiz*/
	@GetMapping("/adminStartQuiz")
	private String adminStartQuiz(Model model) {
		DeQuizMaster deQuizMaster = new DeQuizMaster();
		model.addAttribute("deQuizMaster", deQuizMaster);
		return "adminStartQuiz";
	}

/* Admin waiting for participant - no quizId, output quizId, post adminStartQuiz*/
	@PostMapping("/adminStartQuiz")
	private String postAdminStartQuiz(@ModelAttribute("deQuizMaster") DeQuizMaster deQuizMaster, Model model) {
// set the quiz status to Active	
		wsMessageDAO.setQuizActive(deQuizMaster.getDeqmQuizId());
		model.addAttribute("deQuizMaster", deQuizMaster);
		System.out.println("Admin start quiz");
		return "adminInQuiz";
	}

}
