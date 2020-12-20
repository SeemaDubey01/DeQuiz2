
function WSMessage(type, quizId, userName, questionNo){
	/*	wsMessageType;
	// NewUser, ShowQuiz, SendAnswer	
	wsQuizId;
	wsUserName;
	wsQuestionNo;
	wsmQuestion;
	wsOption_a;
	wsOption_b;
	wsOption_c;
	wsOption_d; 
	wsAnswer;
	wsQuizActive;
	wsTimer;
	wsSelectedAnswer;
	wsMarks;
*/
	this.wsMessageType = type;
	this.wsQuizId = quizId;
	this.wsUserName = userName; 
	this.wsQuestionNo = questionNo;
}

function WSAnsToAdmin(type, userId, quizId, questionNo, selectedAns, marks){
	this.wsMessageType = type;
	this.wsUserId = userId;
	this.wsQuizId = quizId;
	this.wsQuestionNo = questionNo;
	this.wsSelectedAns = selectedAns;
	this.wsMarks = marks;
}

