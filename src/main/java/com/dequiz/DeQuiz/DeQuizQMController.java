package com.dequiz.DeQuiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dequiz.DeQuiz.Websocket.WebSocketDAO;
import com.dequiz.DeQuiz.dto.DeQuizLogin;
import com.dequiz.DeQuiz.dto.DeQuizMaster;
import com.dequiz.DeQuiz.repo.DeQuizMasterDBRepo;
import com.dequiz.DeQuiz.repo.DeQuizUserDBRepo;


@Controller
@SessionAttributes({"deQuizLogin","existingDistinctQuizlist"})
public class DeQuizQMController {
	@Autowired
	DeQuizMasterDBRepo dequizMasterrepo;
	
	@Autowired
	DeQuizUserDBRepo deQuizUserDBRepo;
	
	@Autowired
	WebSocketDAO wsMessageDAO;
	
	@PostMapping("/createquizHeader")
	private String createQuizHeader(@ModelAttribute("deQuizLogin") DeQuizLogin deQuizLogin, Model model, HttpSession session) {
		System.out.println("The value of selected button is22222222222222222222222 ----"+deQuizLogin.getDqlOperationType());
		String returntype = "";
		String operationType = deQuizLogin.getDqlOperationType();
		if(operationType.equalsIgnoreCase("create")) {
		DeQuizMaster deQuizMaster = new DeQuizMaster();
		Random random = new Random();
		int quizId = 100+random.nextInt(999-100);
		deQuizMaster.setDeqmQuizId(quizId);
		deQuizMaster.setDqlUserId(deQuizLogin.getDqlUserId());
		System.out.println("the object which comes here in master is"+deQuizMaster.getDqlUserId());
		model.addAttribute("deQuizMaster", deQuizMaster);
		returntype ="createquizHeader";
		}
		if(operationType.equalsIgnoreCase("addQuestion")) {
			DeQuizMaster deQuizMaster = new DeQuizMaster ();
			List<DeQuizMaster> deQuizMasterList = new ArrayList<DeQuizMaster>();
			deQuizMasterList = dequizMasterrepo.findByDeqmQuizId(deQuizLogin.getDeqmQuizId());
			long count = deQuizMasterList.stream().count();
			System.out.println("count of the list is-----------------"+count);
			System.out.println("Size of the list is------------------"+deQuizMasterList.size());
			if(deQuizMasterList.size()>10) {
				deQuizMaster = deQuizMasterList.stream().skip(count-1).findFirst().get();
				//deQuizMaster = deQuizMasterList.get(1);
				model.addAttribute("operationType", operationType);
				model.addAttribute("deQuizMaster", deQuizMaster);
				System.out.println("The last object is--------"+deQuizMaster);
				returntype = "viewquiz";
			}else
			{
				deQuizMaster = deQuizMasterList.stream().skip(count-1).findFirst().get();
				Integer quizSrNo = deQuizMaster.getDeqmQuizId() * 100 + deQuizMaster.getDeqmQuestionNo();
				
				deQuizMaster.setDeqmSrNbr(quizSrNo);
				dequizMasterrepo.save(deQuizMaster);
				deQuizMaster.nextQustionNo();

				System.out.println("outside create status: " + deQuizMaster);
				model.addAttribute("deQuizMaster", deQuizMaster);
				returntype = "createquizstatus";
			}
		}
		if(operationType.equalsIgnoreCase("view")) {
			DeQuizMaster deQuizMaster = new DeQuizMaster ();
			List<DeQuizMaster> deQuizMasterList = new ArrayList<DeQuizMaster>();
			deQuizMasterList = dequizMasterrepo.findByDeqmQuizId(deQuizLogin.getDeqmQuizId());
			deQuizMaster = deQuizMasterList.get(1);
			model.addAttribute("operationType", operationType);
			model.addAttribute("deQuizMaster", deQuizMaster);
			returntype = "viewquiz";
		}
		if(operationType.equalsIgnoreCase("edit")) {
			DeQuizMaster deQuizMaster = new DeQuizMaster ();
			List<DeQuizMaster> deQuizMasterList = new ArrayList<DeQuizMaster>();
			deQuizMasterList = dequizMasterrepo.findByDeqmQuizId(deQuizLogin.getDeqmQuizId());
			deQuizMaster = deQuizMasterList.get(1);
			model.addAttribute("operationType", operationType);
			model.addAttribute("deQuizMaster", deQuizMaster);
			returntype = "editquiz";
		}
		if(operationType.equalsIgnoreCase("editNew")) {
			DeQuizMaster deQuizMaster = new DeQuizMaster ();
			List<DeQuizMaster> deQuizMasterList = new ArrayList<DeQuizMaster>();
			deQuizMasterList = dequizMasterrepo.findByDeqmQuizId(deQuizLogin.getDeqmQuizId());
			model.addAttribute("deQuizMasterList", deQuizMasterList);
			returntype = "editquizNew";
		}
		if(operationType.equalsIgnoreCase("start")) {
			DeQuizMaster deQuizMaster = new DeQuizMaster ();
			deQuizMaster.setDeqmQuizId(deQuizLogin.getDeqmQuizId());
			wsMessageDAO.setQuizActive(deQuizMaster.getDeqmQuizId());
			model.addAttribute("deQuizMaster", deQuizMaster);
			System.out.println("Admin start quiz");
			returntype = "adminInQuiz";
		}
		if(operationType.equalsIgnoreCase("delete")) {
			Integer id = deQuizLogin.getDeqmQuizId();
			model.addAttribute("quizId", id);
			dequizMasterrepo.deleteByDeqmQuizId(id);
			
			returntype = "adminregisterok"; 
		}
		if(operationType.equalsIgnoreCase("resetResult")) {
			Integer id = deQuizLogin.getDeqmQuizId();
			model.addAttribute("quizId", id);
			deQuizUserDBRepo.deleteByDquQuizId(id);
			
			returntype = "adminregisterok";
		}
		return returntype;
		
	}
	
	
	
	@PostMapping("/createquizDetail")
	private String postQuizHeader(@ModelAttribute("deQuizMaster") DeQuizMaster deQuizMaster, Model model) {
		System.out.println("The admi created the quiz is---"+deQuizMaster.getDqlUserId());
		System.out.println("The quiz id22222222222 of the quiz is"+deQuizMaster.getDeqmQuizId());
		deQuizMaster.setDeqmSrNbr(deQuizMaster.getDeqmQuizId()*100);
		deQuizMaster.setDeqmQuestion("Its quiz header for all the quiz created");
		deQuizMaster.setDeqmOption_a("X");
		deQuizMaster.setDeqmOption_b("X");
		deQuizMaster.setDeqmOption_c("X");
		deQuizMaster.setDeqmOption_d("X");
		deQuizMaster.setDeqmAnswer("");
		deQuizMaster.setDeqmQuestionNo(00);
		deQuizMaster.setDquMarks(00);
		
		dequizMasterrepo.save(deQuizMaster);
		model.addAttribute("quizmaster", deQuizMaster);
		return "createquizDetail";
	}
	
	@PostMapping("/createquiz")
	private String CrateQuiz( @ModelAttribute("quizmaster") DeQuizMaster quizmaster, @Valid Model model) {
		System.out.println("The value of question number coming as---"+quizmaster.getDeqmQuestionNo());
		if (quizmaster.getDeqmQuestionNo() == null ) {
			quizmaster.setDeqmQuestionNo(1);
		} 
		
		model.addAttribute("quizmaster", quizmaster);
		return "createquiz";
		
	}

	@PostMapping("/createquizstatus")
	private String CreateQuizStatus(@Valid @ModelAttribute("quizmaster") DeQuizMaster deQuizMaster, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "createquiz";
		} 
// insert the quiz into DeQuizMaster table
		Integer quizSrNo = deQuizMaster.getDeqmQuizId() * 100 + deQuizMaster.getDeqmQuestionNo();
		
		deQuizMaster.setDeqmSrNbr(quizSrNo);
		dequizMasterrepo.save(deQuizMaster);
		deQuizMaster.nextQustionNo();

		System.out.println("outside create status: " + deQuizMaster);
		model.addAttribute("deQuizMaster", deQuizMaster);
		return "createquizstatus";
	}
	
	@PostMapping("/getNextQuestioin")
	private String getNextQuestion(@ModelAttribute("deQuizMaster") DeQuizMaster deQuizMaster, Model model,HttpSession session) {
		Integer quizId = deQuizMaster.getDeqmQuizId() * 100 + deQuizMaster.getDeqmQuestionNo() + 1;
	
		Optional<DeQuizMaster> deQuizMasterMap = dequizMasterrepo.findById(quizId);
		if (!deQuizMasterMap.isPresent()){
			
			return "adminregisterok";
		}
		
	
		deQuizMaster = deQuizMasterMap.get();
		model.addAttribute("deQuizMaster",deQuizMaster);
	
		return "viewquiz";
	}
	@PostMapping("/getNextQuestioinEdit")
	private String getNextQuestionEdit(@ModelAttribute("deQuizMaster") DeQuizMaster deQuizMaster, Model model) {
		if(deQuizMaster.getEditType().equalsIgnoreCase("next")) {
		Integer quizId = deQuizMaster.getDeqmQuizId() * 100 + deQuizMaster.getDeqmQuestionNo() + 1;
		Optional<DeQuizMaster> deQuizMasterMap = dequizMasterrepo.findById(quizId);
		if (!deQuizMasterMap.isPresent()){
			return "adminregisterok";
		}
		deQuizMaster = deQuizMasterMap.get();
		model.addAttribute("deQuizMaster",deQuizMaster);
	
		return "editquiz";
		}
		if(deQuizMaster.getEditType().equalsIgnoreCase("save")) {
			System.out.println("The id of the question is----"+deQuizMaster.getDeqmSrNbr());
			System.out.println("Values inside object"+deQuizMaster.getDeqmOption_c()+" And option d is"+deQuizMaster.getDeqmOption_d());
			dequizMasterrepo.save(deQuizMaster);
			model.addAttribute("deQuizMaster", deQuizMaster);
			return "editquiz";
		}
		if(deQuizMaster.getEditType().equalsIgnoreCase("previous")){
			Integer quizId = deQuizMaster.getDeqmQuizId() * 100 + deQuizMaster.getDeqmQuestionNo() - 1;
			Optional<DeQuizMaster> deQuizMasterMap = dequizMasterrepo.findById(quizId);
			if (!deQuizMasterMap.isPresent()){
				return "allQuestions";
			}
			deQuizMaster = deQuizMasterMap.get();
			model.addAttribute("deQuizMaster",deQuizMaster);
		
			return "editquiz";
			}
		return "editquiz";
	}
	
	@GetMapping("/getUserQuizList")
	private String getUserQuizList(Model model) {
	
			return "adminregisterok";
		
	}

}

