package com.dequiz.DeQuiz.Websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
	@Autowired
	WebSocketDAO webSocketDAO;
	@Autowired
    private SimpMessagingTemplate messagingTemplate;
	
	@MessageMapping("/DeQuiz.NewPlayer/{quizId}")
	@SendTo("/topic/adminQueue/{quizId}")
	public WSQuizMessage newPlayer(@DestinationVariable("quizId") Integer quizId, @Payload WSQuizMessage wsMessageDTO) {
		System.out.println("inside WS controller for new player: " + wsMessageDTO);
		
	//	webSocketDAO.initializeParticipantTable(wsMessageDTO);
		
		return wsMessageDTO;
	}
	
	@MessageMapping("/DeQuiz.ShowQuiz/{quizId}")
	@SendTo("/topic/participantQueue/{quizId}")
	public WSQuizMessage showQuiz(@DestinationVariable("quizId") Integer quizId, @Payload WSQuizMessage wsQuizMessage){
		System.out.println("admin is sending quiz to participant " + wsQuizMessage);
		wsQuizMessage = webSocketDAO.getQuizQuestion(wsQuizMessage.getWsQuizId(),wsQuizMessage.getWsQuestionNo());
		messagingTemplate.convertAndSend("/topic/adminQueue/" + quizId, wsQuizMessage);
		return wsQuizMessage;	
	}

	@MessageMapping("/DeQuiz.SelectedAns/{quizId}")
	@SendTo("/topic/adminQueue/{quizId}")
	public WSAnsMessage checkAnswer(@DestinationVariable("quizId") Integer quizId, @Payload WSAnsMessage wsAnsMessage){
		System.out.println("user is sending answer " + wsAnsMessage);
		webSocketDAO.updateAnswer(wsAnsMessage);
		
		return wsAnsMessage;	
	}
	@MessageMapping("/DeQuiz.ShowResult/{quizId}")
	@SendTo("/topic/participantQueue/{quizId}")
	public WSResultMessage showResult(@DestinationVariable("quizId") Integer quizId, @Payload WSQuizMessage wsQuizMessage){
		System.out.println("admin is sending result " + wsQuizMessage);
		WSResultMessage wsResultMessage = new WSResultMessage();
		wsResultMessage = webSocketDAO.getResultList(wsQuizMessage.getWsQuizId(),10);
		messagingTemplate.convertAndSend("/topic/adminQueue/" + quizId, wsResultMessage);
		return wsResultMessage;	
	}	
}


