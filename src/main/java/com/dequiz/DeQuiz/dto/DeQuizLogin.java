package com.dequiz.DeQuiz.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import com.dequiz.DeQuiz.validator.ExtendedEmailValidator;

@Entity
public class DeQuizLogin {
	@Id
	@Size(min =5, max = 30, message = "Please give a valid user Name")
	private String dqlUserId;
	@Size(min =8, max = 30, message = "Password should have a minimum 8 characters")
	private String dqlPassword;
	@Size(min =3, max = 30, message = "Please give a valid user Name")
	private String dqlFirstName;
	@Size(min =3, max = 30, message = "Please give a valid user Name")
	private String dqlLastName;
	@ExtendedEmailValidator
	private String dqlEmail;
	
	@Transient
	private Integer deqmQuizId;
	@Transient
	private String dqlOperationType;
	
	

	public Integer getDeqmQuizId() {
		return deqmQuizId;
	}
	public void setDeqmQuizId(Integer deqmQuizId) {
		this.deqmQuizId = deqmQuizId;
	}
	
	public String getDqlUserId() {
		return dqlUserId;
	}
	public void setDqlUserId(String dqlUserId) {
		this.dqlUserId = dqlUserId;
	}
	public String getDqlFirstName() {
		return dqlFirstName;
	}
	
	public void setDqlFirstName(String dqlFirstName) {
		this.dqlFirstName = dqlFirstName;
	}
	public String getDqlPassword() {
		return dqlPassword;
	}
	public void setDqlPassword(String dqlPassword) {
		this.dqlPassword = dqlPassword;
	}
	public String getDqlLastName() {
		return dqlLastName;
	}
	public void setDqlLastName(String dqlLastName) {
		this.dqlLastName = dqlLastName;
	}
	public String getDqlEmail() {
		return dqlEmail;
	}
	public void setDqlEmail(String dqlEmail) {
		this.dqlEmail = dqlEmail;
	}
	public String getDqlOperationType() {
		return dqlOperationType;
	}
	public void setDqlOperationType(String dqlOperationType) {
		this.dqlOperationType = dqlOperationType;
	}
	
	
}
