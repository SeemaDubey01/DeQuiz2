package com.dequiz.DeQuiz.Websocket;

public class WSAnsMessage {
	private String wsMessageType;
	private Integer wsUserId;
	private Integer wsQuizId;
	private Integer wsQuestionNo;
	private String wsSelectedAns;
	private Integer wsMarks;
	public String getWsMessageType() {
		return wsMessageType;
	}
	public void setWsMessageType(String wsMessageType) {
		this.wsMessageType = wsMessageType;
	}
	public Integer getWsUserId() {
		return wsUserId;
	}
	public void setWsUserId(Integer wsUserId) {
		this.wsUserId = wsUserId;
	}
	public Integer getWsQuizId() {
		return wsQuizId;
	}
	public void setWsQuizId(Integer wsQuizId) {
		this.wsQuizId = wsQuizId;
	}
	public Integer getWsQuestionNo() {
		return wsQuestionNo;
	}
	public void setWsQuestionNo(Integer wsQuestionNo) {
		this.wsQuestionNo = wsQuestionNo;
	}
	public String getWsSelectedAns() {
		return wsSelectedAns;
	}
	public void setWsSelectedAns(String wsSelectedAns) {
		this.wsSelectedAns = wsSelectedAns;
	}
	public Integer getWsMarks() {
		return wsMarks;
	}
	public void setWsMarks(Integer wsMarks) {
		this.wsMarks = wsMarks;
	}
	@Override
	public String toString() {
		return "AnsMsg: user:" + wsUserId +" quiz:" + wsQuizId +" Q:" + wsQuestionNo + " ans:" + wsSelectedAns +" marks:" + wsMarks;
	}
	
}
