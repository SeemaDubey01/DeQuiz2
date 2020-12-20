package com.dequiz.DeQuiz.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

@Entity
public class DeQuizMaster {
	@Id
	private Integer deqmSrNbr;
	private Integer deqmQuizId;
	private Integer deqmQuestionNo;
	@Size(min = 5, max = 200, message = "Length of question can not be less than 5 or more than 200")
	private String deqmQuestion;
	@Size(min = 1,max = 40, message = "Length of option can not be less than 1 or more than 40")
	private String deqmOption_a;
	@Size(min = 1,max = 40, message = "Length of option can not less than 1 or be more than 40")
	private String deqmOption_b;
	@Size(min = 1,max = 40, message = "Length of option can not be less than 1 or more than 40")
	private String deqmOption_c;
	@Size(min = 1,max = 40, message = "Length of option can not be less than 1 or more than 40")
	private String deqmOption_d; 
	private String deqmAnswer;
	private String deqmQuizActive;
	private Integer deqmTimer;
	private String dqlUserId;
	private String deqmQuizDesc;
	
	@Transient
    private String editType;
	@Transient
	private String selectedAnswer;
	@Transient
	private Integer dquUserId;
	@Transient
	private Integer dquMarks;
	@Transient
	private String dquUserName;

/*
    @OneToMany(targetEntity=DeQuizUser.class,cascade=CascadeType.ALL )
    @JoinColumn(referencedColumnName="dquUserId")
    private List<DeQuizUser> users = new ArrayList<DeQuizUser>();
 */   
	
	public String getDeqmQuizDesc() {
		return deqmQuizDesc;
	}
	public String getEditType() {
		return editType;
	}
	public void setEditType(String editType) {
		this.editType = editType;
	}
	public void setDeqmQuizDesc(String deqmQuizDesc) {
		this.deqmQuizDesc = deqmQuizDesc;
	}
	
	public Integer getDquUserId() {
		return dquUserId;
	}
	public String getDqlUserId() {
		return dqlUserId;
	}
	public void setDqlUserId(String dqlUserId) {
		this.dqlUserId = dqlUserId;
	}
	public void setDquUserId(Integer dquUserId) {
		this.dquUserId = dquUserId;
	}
	public String getSelectedAnswer() {
		return selectedAnswer;
	}
	public void setSelectedAnswer(String selectedAnswer) {
		this.selectedAnswer = selectedAnswer;
	}
	public Integer getDeqmQuizId() {
		return deqmQuizId;
	}
	public void setDeqmQuizId(Integer deqmQuizId) {
		this.deqmQuizId = deqmQuizId;
	}
	public Integer getDeqmQuestionNo() {
		return deqmQuestionNo;
	}
	public void setDeqmQuestionNo(Integer deqmQuestionNo) {
		this.deqmQuestionNo = deqmQuestionNo;
	}
	public String getDeqmQuestion() {
		return deqmQuestion;
	}
	public void setDeqmQuestion(String deqmQuestion) {
		this.deqmQuestion = deqmQuestion;
	} 
	public String getDeqmOption_a() {
		return deqmOption_a;
	}
	public void setDeqmOption_a(String deqmOption_a) {
		this.deqmOption_a = deqmOption_a;
	}
	public String getDeqmOption_b() {
		return deqmOption_b;
	}
	public void setDeqmOption_b(String deqmOption_b) {
		this.deqmOption_b = deqmOption_b;
	}
	public String getDeqmOption_c() {
		return deqmOption_c;
	}
	public void setDeqmOption_c(String deqmOption_c) {
		this.deqmOption_c = deqmOption_c;
	}
	public String getDeqmOption_d() {
		return deqmOption_d;
	}
	public void setDeqmOption_d(String deqmOption_d) {
		this.deqmOption_d = deqmOption_d;
	}
	public String getDeqmAnswer() {
		return deqmAnswer;
	}
	public void setDeqmAnswer(String deqmAnswer) {
		this.deqmAnswer = deqmAnswer;
	}
	public Integer getDeqmSrNbr() {
		return deqmSrNbr;
	}
	public void setDeqmSrNbr(Integer deqmSrNbr) {
		this.deqmSrNbr = deqmSrNbr;
	}
	public String getDeqmQuizActive() {
		return deqmQuizActive;
	}
	public void setDeqmQuizActive(String deqmQuizActive) {
		this.deqmQuizActive = deqmQuizActive;
	}
	public Integer getDquMarks() {
		return dquMarks;
	}
	public void setDquMarks(Integer dquMarks) {
		this.dquMarks = dquMarks;
	}
	public Integer getDeqmTimer() {
		return deqmTimer;
	}
	public String getDquUserName() {
		return dquUserName;
	}
	public void setDquUserName(String dquUserName) {
		this.dquUserName = dquUserName;
	}
	public void setDeqmTimer(Integer deqmTimer) {
		this.deqmTimer = deqmTimer;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "quidId: " + deqmQuizId + " question#: " + deqmQuestionNo + 
				" question: " + deqmQuestion + 
				" a: " + deqmOption_a + " b: " + deqmOption_b + " c: " + deqmOption_c
				+ " d: " + deqmOption_d + " ans: " + deqmAnswer ;
	}
	
	public Integer nextQustionNo () {
		deqmQuestionNo = deqmQuestionNo + 1;
		deqmQuestion = " ";
		deqmOption_a = " ";
		deqmOption_b = " ";
		deqmOption_c = " ";
		deqmOption_d = " ";
		deqmAnswer = " ";
		return deqmQuestionNo;
	}
	
}

