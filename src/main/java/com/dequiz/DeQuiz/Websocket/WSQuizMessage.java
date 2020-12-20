package com.dequiz.DeQuiz.Websocket;

import org.springframework.stereotype.Component;

@Component
public class WSQuizMessage {
	private String wsMessageType;
// NewUser, SendQuiz, SendAnswer	
	private Integer wsQuizId;
	private String wsUserName;
	private Integer wsQuestionNo;
	private String wsQuestion;
	private String wsOption_a;
	private String wsOption_b;
	private String wsOption_c;
	private String wsOption_d; 
	private String wsAnswer;
	private String wsQuizActive;
	private Integer wsTimer;
	private String wsSelectedAnswer;
	private Integer wsMarks;

	public String getWsMessageType() {
		return wsMessageType;
	}
	public void setWsMessageType(String wsMessageType) {
		this.wsMessageType = wsMessageType;
	}
	public Integer getWsQuizId() {
		return wsQuizId;
	}
	public void setWsQuizId(Integer wsQuizId) {
		this.wsQuizId = wsQuizId;
	}
	public String getWsUserName() {
		return wsUserName;
	}
	public void setWsUserName(String wsUserName) {
		this.wsUserName = wsUserName;
	}
	public Integer getWsQuestionNo() {
		return wsQuestionNo;
	}
	public void setWsQuestionNo(Integer wsQuestionNo) {
		this.wsQuestionNo = wsQuestionNo;
	}
	public String getWsQuestion() {
		return wsQuestion;
	}
	public void setWsQuestion(String wsQuestion) {
		this.wsQuestion = wsQuestion;
	}
	public String getWsOption_a() {
		return wsOption_a;
	}
	public void setWsOption_a(String wsOption_a) {
		this.wsOption_a = wsOption_a;
	}
	public String getWsOption_b() {
		return wsOption_b;
	}
	public void setWsOption_b(String wsOption_b) {
		this.wsOption_b = wsOption_b;
	}
	public String getWsOption_c() {
		return wsOption_c;
	}
	public void setWsOption_c(String wsOption_c) {
		this.wsOption_c = wsOption_c;
	}
	public String getWsOption_d() {
		return wsOption_d;
	}
	public void setWsOption_d(String wsOption_d) {
		this.wsOption_d = wsOption_d;
	}
	public String getWsAnswer() {
		return wsAnswer;
	}
	public void setWsAnswer(String wsAnswer) {
		this.wsAnswer = wsAnswer;
	}
	public String getWsQuizActive() {
		return wsQuizActive;
	}
	public void setWsQuizActive(String wsQuizActive) {
		this.wsQuizActive = wsQuizActive;
	}
	public Integer getWsTimer() {
		return wsTimer;
	}
	public void setWsTimer(Integer wsTimer) {
		this.wsTimer = wsTimer;
	}
	public String getWsSelectedAnswer() {
		return wsSelectedAnswer;
	}
	public void setWsSelectedAnswer(String wsSelectedAnswer) {
		this.wsSelectedAnswer = wsSelectedAnswer;
	}
	public Integer getWsMarks() {
		return wsMarks;
	}
	public void setWsMarks(Integer wsMarks) {
		this.wsMarks = wsMarks;
	}
	@Override
	public String toString() {
		return "messageType: " + wsMessageType + " quiz:" + wsQuizId + " name:" + wsUserName + " Q:" + wsQuestionNo;
	}
	
}

