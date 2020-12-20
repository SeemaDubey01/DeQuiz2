package com.dequiz.DeQuiz.Websocket;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dequiz.DeQuiz.dto.DeQuizMaster;
import com.dequiz.DeQuiz.dto.DeQuizUser;
import com.dequiz.DeQuiz.repo.DeQuizMasterDBRepo;
import com.dequiz.DeQuiz.repo.DeQuizUserDBRepo;

@Component
public class WebSocketDAO {
	@Autowired
	DeQuizUserDBRepo deQuizUserRepo;
	@Autowired
	DeQuizMasterDBRepo deQuizMasterRepo;
	
	public void participantJoined(Integer wsQuizId, String wsUserName) {
		WSQuizMessage wsQuizMessage = new WSQuizMessage();
		wsQuizMessage.setWsMessageType("NewPlayer");
		wsQuizMessage.setWsQuizId(wsQuizId);
		wsQuizMessage.setWsUserName(wsUserName);
		System.out.println("Simpmessage Sending message: quizId: " + wsQuizId + " joined-" + wsUserName);
	}

	public void initializeParticipantTable(WSQuizMessage wsQuizMessage) {
		DeQuizUser deQuizUser = new DeQuizUser();
		deQuizUser.setDquQuizId(wsQuizMessage.getWsQuizId());
		deQuizUser.setDquUserName(wsQuizMessage.getWsUserName());
		deQuizUser.setDquSessionId("Q:");
		//deQuizUser.setDquAnswer("X");
		deQuizUser.setDquMarks(0);
		deQuizUser.setDquTotalMarks(0);
		deQuizUser.setDquQuestionNo(0);
		deQuizUserRepo.save(deQuizUser);
	}

	public WSQuizMessage getQuizQuestion(Integer wsQuizId, Integer wsQuestionNo) {
		Integer quizId = wsQuizId * 100 + wsQuestionNo + 1;
		//DeQuizMaster deQuizMaster = new DeQuizMaster ();
		WSQuizMessage wsQuizMessage = new WSQuizMessage();
		DeQuizMaster quizMaster = new DeQuizMaster();
		Optional<DeQuizMaster> deQuizMaster = deQuizMasterRepo.findById(quizId);
		if (deQuizMaster.isPresent()){
			quizMaster=deQuizMaster.get();
			//quizMaster.setDeqmAnswer("X");
			wsQuizMessage = this.populateWSMessage(wsQuizMessage, quizMaster);
		} else {
			wsQuizMessage.setWsMessageType("EndQuiz");
			wsQuizMessage.setWsQuizId(wsQuizId);
			WSResultMessage wsResultMessage = new WSResultMessage();
			wsResultMessage = this.getResultList(wsQuizId, 1);
			wsQuizMessage.setWsUserName(wsResultMessage.getWsUserList().get(0).getDquUserName());
			this.setQuizInactive(wsQuizId);
		}
		return wsQuizMessage;
	}
	
	public WSQuizMessage populateWSMessage(WSQuizMessage wsQuizMessage, DeQuizMaster deQuizMaster) {
		wsQuizMessage.setWsMessageType("ShowQuiz");
		wsQuizMessage.setWsQuizId(deQuizMaster.getDeqmQuizId());
		wsQuizMessage.setWsUserName(" ");
		wsQuizMessage.setWsQuestionNo(deQuizMaster.getDeqmQuestionNo());
		wsQuizMessage.setWsQuestion(deQuizMaster.getDeqmQuestion());
		wsQuizMessage.setWsOption_a(deQuizMaster.getDeqmOption_a());
		wsQuizMessage.setWsOption_b(deQuizMaster.getDeqmOption_b());
		wsQuizMessage.setWsOption_c(deQuizMaster.getDeqmOption_c());
		wsQuizMessage.setWsOption_d(deQuizMaster.getDeqmOption_d());
		wsQuizMessage.setWsAnswer(deQuizMaster.getDeqmAnswer());
		wsQuizMessage.setWsQuizActive(deQuizMaster.getDeqmQuizActive());
		wsQuizMessage.setWsTimer(deQuizMaster.getDeqmTimer());
		wsQuizMessage.setWsSelectedAnswer("X");
		wsQuizMessage.setWsMarks(0);
		return wsQuizMessage;
	}

	public boolean updateAnswer(WSAnsMessage wsAnsMessage) {
		DeQuizUser deQuizUser = new DeQuizUser();
		Optional<DeQuizUser> deQuizUserMap = deQuizUserRepo.findById(wsAnsMessage.getWsUserId());
		if (!deQuizUserMap.isPresent()){
			return false;
		}
		deQuizUser = deQuizUserMap.get();
		if (!deQuizUser.getDquQuizId().equals(wsAnsMessage.getWsQuizId())) {
			System.out.println("msg: " + wsAnsMessage.getWsQuizId() + " table:" + deQuizUser.getDquQuizId());
			return false;
		}
		deQuizUser.setDquMarks(wsAnsMessage.getWsMarks());
		deQuizUser.setDquTotalMarks(deQuizUser.getDquTotalMarks()+deQuizUser.getDquMarks());
		
		deQuizUser.setDquSessionId(deQuizUser.getDquSessionId() + " " + wsAnsMessage.getWsQuestionNo() + 
				wsAnsMessage.getWsSelectedAns() + wsAnsMessage.getWsMarks());
		deQuizUserRepo.save(deQuizUser);	

		return true;
	}

	public WSResultMessage getResultList(Integer wsQuizId, Integer wsListSize) {
		WSResultMessage wsResultMessage = new WSResultMessage();
		wsResultMessage.setWsMessageType("ShowResult");
		wsResultMessage.setWsListSize(wsListSize);
		wsResultMessage.setWsQuizId(wsQuizId);
		
		List<DeQuizUser> deQuizUserList = new ArrayList<DeQuizUser>();
		deQuizUserList = deQuizUserRepo.findforResultDisplay(wsQuizId);
		
		if(null!=deQuizUserList && deQuizUserList.size()!=0 ) {
			List<DeQuizUser> userResultList = new ArrayList<DeQuizUser>();
			userResultList =deQuizUserList.stream().limit(wsListSize).collect(Collectors.toList());
			wsResultMessage.setWsUserList(userResultList);
		}
		return wsResultMessage;
	}

	public void setQuizActive(Integer deqmQuizId) {
		Integer wsSrNbr = deqmQuizId * 100 + 1;
		DeQuizMaster deQuizMaster = new DeQuizMaster();
		Optional<DeQuizMaster> deQuizMasterMap = deQuizMasterRepo.findById(wsSrNbr);
		if (deQuizMasterMap.isPresent()){
			deQuizMaster = deQuizMasterMap.get();
			deQuizMaster.setDeqmQuizActive("Y");
			deQuizMasterRepo.save(deQuizMaster);
		}
	}
	
	public void setQuizInactive(Integer deqmQuizId) {
		DeQuizMaster deQuizMaster = new DeQuizMaster();
		Integer wsSrNbr = deqmQuizId * 100 + 1;
		Optional<DeQuizMaster> deQuizMasterMap = deQuizMasterRepo.findById(wsSrNbr);
		if (deQuizMasterMap.isPresent()){
			deQuizMaster = deQuizMasterMap.get();
			deQuizMaster.setDeqmQuizActive("N");
			deQuizMasterRepo.save(deQuizMaster);
		}
	}
}

