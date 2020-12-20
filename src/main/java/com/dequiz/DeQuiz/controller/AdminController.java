 package com.dequiz.DeQuiz.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.dequiz.DeQuiz.dto.DeQuizLogin;
import com.dequiz.DeQuiz.dto.DeQuizMaster;
import com.dequiz.DeQuiz.repo.DeQuizLoginDBRepo;
import com.dequiz.DeQuiz.repo.DeQuizMasterDBRepo;


@Controller
@SessionAttributes({"deQuizLogin","existingDistinctQuizlist"})
public class AdminController {
	
	@Autowired
	private DeQuizLoginDBRepo deQuizLoginDBRepo;
	
	@Autowired
	private DeQuizMasterDBRepo deQuizMasterDBRepo;
	
	/* Display login page for QuizMaster 
	@GetMapping("/login")
	private String showForm(@Valid Model model) {
		DeQuizLogin deQuizLogin = new DeQuizLogin();
		System.out.println("inside login method for admin controller");
		model.addAttribute("deQuizLogin", deQuizLogin);
		return "adminLogin";
	}

		
	@PostMapping("/loginadmin")
	public String submitForm(@Valid @ModelAttribute("deQuizLogin") DeQuizLogin deQuizLogin, BindingResult bindingResult, Model model) {
		if(deQuizLogin.getDqlUserId()!=null) {
			DeQuizLogin dequizlogin = getAdmin(deQuizLogin.getDqlUserId());
			
			if (dequizlogin==null) {
				bindingResult.addError(new FieldError("deQuizLogin", "dqlUserId", "User id/password is incorrect"));
			}
			if (dequizlogin!=null && deQuizLogin!=null && !dequizlogin.getDqlPassword().equals(deQuizLogin.getDqlPassword())) {
				bindingResult.addError(new FieldError("deQuizLogin", "dqlUserId", "User id/password is incorrect"));
			}
		}
		if (bindingResult.hasErrors()) {
			return "adminLogin";
		} else {
			List<DeQuizMaster> existingQuizlist = new ArrayList<DeQuizMaster>();
			List<DeQuizMaster> existingDistinctQuizlist = new ArrayList<DeQuizMaster>();
			if(deQuizLogin!=null && deQuizLogin.getDqlUserId()!=null) {
				existingQuizlist=getExistingQuizes(deQuizLogin.getDqlUserId());
				existingDistinctQuizlist = io.vavr.collection.List.ofAll(existingQuizlist)
						  .distinctBy(DeQuizMaster::getDeqmQuizId)
						  .toJavaList();
			}
			model.addAttribute("existingQuizlist", existingQuizlist);
			model.addAttribute("existingDistinctQuizlist", existingDistinctQuizlist);
			model.addAttribute("deQuizLogin", deQuizLogin);
			return "adminregisterok";

		}
	}
	*/
	@GetMapping("/signUpNew")
	private String showSignUpForm(Model model) {
		System.out.println("Inside the get method--rtertertrt-");
		DeQuizLogin deQuizLogin = new DeQuizLogin();
		model.addAttribute("deQuizLogin", deQuizLogin);
		return "adminSignUp";
	}
	
	@PostMapping("/saveAdmin")
	public String saveAdmin(@Valid @ModelAttribute("deQuizLogin") DeQuizLogin deQuizLogin, BindingResult bindingResult, Model model) {
		if(deQuizLogin.getDqlUserId()!=null) {
			DeQuizLogin dequizlogin = getAdmin(deQuizLogin.getDqlUserId());;
			if (dequizlogin!=null && dequizlogin.getDqlUserId().equalsIgnoreCase(deQuizLogin.getDqlUserId())) {
				System.out.println("userid exists");
				bindingResult.addError(new FieldError("deQuizLogin", "dqlUserId", "UserId already exists please select a new userId"));
			}
		}
		
		if (bindingResult.hasErrors()){
			return "adminSignUp";
		} 
	
		else {
			model.addAttribute("deQuizLogin", deQuizLogin);
			model.addAttribute("dqlUserId",deQuizLogin.getDqlUserId());
			deQuizLoginDBRepo.save(deQuizLogin);
			return "adminregisterok";

		}
	}
	
	 private DeQuizLogin getAdmin(String userIdfield){
		  Optional<DeQuizLogin> dequizLoginMap =deQuizLoginDBRepo.findById(userIdfield); 
		  DeQuizLogin quizLogin = new DeQuizLogin();
		  if(dequizLoginMap.isPresent()) { 
			  quizLogin = dequizLoginMap.get();
		  } 
		  return quizLogin;
		  
		  }
	 
	/*
	 * @GetMapping("/forGotPassword") private String forgotPassword(Model model) {
	 * System.out.println("Inside the get method--rtertertrt-"); DeQuizLogin
	 * deQuizLogin = new DeQuizLogin(); model.addAttribute("deQuizLogin",
	 * deQuizLogin); return "forGotPassword"; }
	 */
	/*
	 * @PostMapping("/sendMail") public String
	 * processForgotPasswordForm(@Valid @ModelAttribute("deQuizLogin") DeQuizLogin
	 * deQuizLogin, BindingResult bindingResult, Model model) {
	 * Optional<DeQuizLogin> dequizloginoformailmap =
	 * deQuizLoginDBRepo.findByDqlEmail(deQuizLogin.getDqlEmail()); if
	 * (!dequizloginoformailmap.isPresent()) { bindingResult.addError(new
	 * FieldError("deQuizLogin", "dqlEmail", "Email id does not exist")); return
	 * "forGotPassword"; } else { DeQuizLogin deQuizLoginEmail =
	 * dequizloginoformailmap.get(); File imageFile = null; try { MimeMessage
	 * message = emailService.createMimemessage(); MimeMessageHelper helper = new
	 * MimeMessageHelper(message, true); helper.setFrom("contact@dequiz.co.in");
	 * helper.setTo(deQuizLoginEmail.getDqlEmail());
	 * helper.setSubject("DeQuiz forgot Password support");
	 * helper.setText("Dear "+deQuizLoginEmail.getDqlFirstName()
	 * +"\n Your DeQuiz password is "+deQuizLoginEmail.getDqlPassword());
	 * 
	 * try { imageFile = new
	 * ClassPathResource("static/images/dequiz_thumnail.jpg").getFile(); } catch
	 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * helper.addInline("rightSideImage",imageFile);
	 * emailService.sendEmail(message);
	 * 
	 * } catch (MessagingException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } return "sentMail";
	 */
				
	/*
	 * 
	 * }
	 * 
	 * }
	 */
		
		private List<DeQuizMaster> getExistingQuizes(String userId){
			List<DeQuizMaster> qMlist = deQuizMasterDBRepo.findByDqlUserId(userId);
			  return qMlist;
		}
	 
		 

}
