
function WSMessage(type, quizId, userName, questionNo){
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

