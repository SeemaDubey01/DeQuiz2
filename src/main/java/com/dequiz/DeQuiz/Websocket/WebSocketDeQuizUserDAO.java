package com.dequiz.DeQuiz.Websocket;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.dequiz.DeQuiz.dto.DeQuizMaster;
import com.dequiz.DeQuiz.dto.DeQuizUser;
import com.dequiz.DeQuiz.repo.DeQuizMasterDBRepo;
import com.dequiz.DeQuiz.repo.DeQuizUserDBRepo;

@Component
public class WebSocketDeQuizUserDAO {

	@Autowired
	DeQuizUserDBRepo deQuizUserRepo;
	@Autowired
	DeQuizMasterDBRepo deQuizMasterRepo;
	
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
				wsQuizMessage.setWsMessageType("QuizEnd");
				wsQuizMessage.setWsQuizId(wsQuizId);
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

		public boolean updatekAnswer(WSAnsMessage wsAnsMessage) {
			DeQuizUser deQuizUser = new DeQuizUser();
			Optional<DeQuizUser> deQuizUserMap = deQuizUserRepo.findById(wsAnsMessage.getWsUserId());
			if (!deQuizUserMap.isPresent()){
				return false;
			}
			deQuizUser = deQuizUserMap.get();
			if (deQuizUser.getDquQuizId() != wsAnsMessage.getWsQuizId()) {
				return false;
			}
			deQuizUser.setDquMarks(wsAnsMessage.getWsMarks());
			deQuizUser.setDquTotalMarks(deQuizUser.getDquTotalMarks()+deQuizUser.getDquMarks());
			
			deQuizUser.setDquSessionId(deQuizUser.getDquSessionId() + " " + wsAnsMessage.getWsQuestionNo() + 
					wsAnsMessage.getWsSelectedAns() + wsAnsMessage.getWsMarks());
			deQuizUserRepo.save(deQuizUser);	
	
			return true;
		}
		
}
