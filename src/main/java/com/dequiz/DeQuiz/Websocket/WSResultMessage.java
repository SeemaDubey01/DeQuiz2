package com.dequiz.DeQuiz.Websocket;

import java.util.List;

import com.dequiz.DeQuiz.dto.DeQuizUser;

public class WSResultMessage {
	private String wsMessageType;
	// ShowResult
	private Integer wsQuizId;
	private Integer wsListSize;
	private List<DeQuizUser> wsUserList;
	
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
	public Integer getWsListSize() {
		return wsListSize;
	}
	public void setWsListSize(Integer wsListSize) {
		this.wsListSize = wsListSize;
	}
	public List<DeQuizUser> getWsUserList() {
		return wsUserList;
	}
	public void setWsUserList(List<DeQuizUser> wsUserList) {
		this.wsUserList = wsUserList;
	}
}
