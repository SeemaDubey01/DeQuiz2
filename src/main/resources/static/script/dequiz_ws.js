/**
 * javascript file to handle websocket messaging 
 */
var thisQuizId;
var thisUserId;
var currentAnswer='x';
var totalMarks =  0;
var timerId1, timerId2;
	
function openAdminSocket(quizId){
	var socket = new SockJS('/dequizwebsocket');
	stompClient = Stomp.over(socket);
	thisQuizId = quizId;
	stompClient.connect({}, function(){
		stompClient.subscribe('/topic/adminQueue/' + quizId, onMessageReceivedAdminQueue);
	});
}

function openParticipantSocket(quizId, userName){
	thisQuizId = quizId;
	
	var socket = new SockJS('/dequizwebsocket');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(){
		stompClient.subscribe('/topic/participantQueue/' + quizId, onMessageReceivedParticipantQueue);
		var wsMessage = new WSMessage("NewPlayer", quizId, userName,0);
		stompClient.send("/app/DeQuiz.NewPlayer/" + quizId, {}, JSON
				.stringify(wsMessage));
	});
}
function onMessageReceivedAdminQueue(payload){
	var wsMessage = JSON.parse(payload.body);
	console.log("message received in queue: " + wsMessage.wsMessageType);
	var participantList = "<p/>";
		if (wsMessage.wsMessageType === 'NewPlayer' && 
			wsMessage.wsQuizId == thisQuizId ) {
			participantList = "<p><b>" + wsMessage.wsUserName + '</b> has joined the quiz </p>';
			$('#paritipants').append(participantList);
			console.log("new player joined: " + wsMessage.wsUserName );
		} else if (wsMessage.wsMessageType === 'ShowQuiz') {
			initializeAnsCounter(wsMessage.wsAnswer);
			populateQuestionDiv(wsMessage, "admin");
			console.log("quiz: " + wsMessage.wsQuizId + " question: " + wsMessage.wsQuestionNo + " received");
		} else if (wsMessage.wsMessageType == "SendAnswer"){
			displayStatAns(wsMessage.wsSelectedAns);			
		} else if (wsMessage.wsMessageType == "ShowResult"){
			displayResultTable(wsMessage.wsUserList, wsMessage.wsListSize);			
		}
		else if (wsMessage.wsMessageType == "EndQuiz"){
			displayFinalResult(wsMessage.wsUserName);			
		}
}

function onMessageReceivedParticipantQueue (payload){
	var wsMessage = JSON.parse(payload.body);
	if (wsMessage.wsMessageType === 'ShowQuiz' &&
			wsMessage.wsQuizId == thisQuizId ) {
		populateQuestionDiv(wsMessage,"participant");
		//console.log("quiz: " + wsMessage.wsQuizId + " question: " + wsMessage.wsQuestionNo + " received");
	} else if (wsMessage.wsMessageType === 'ShowResult' &&
			wsMessage.wsQuizId == thisQuizId ) {
		displayResultTable(wsMessage.wsUserList, wsMessage.wsListSize);
	}
	else if (wsMessage.wsMessageType === 'EndQuiz' &&
			wsMessage.wsQuizId == thisQuizId ) {
		displayFinalResult(wsMessage.wsUserName);
	}
}
function displayStatAns(selectedAns){
	var counter;
	switch (selectedAns){
	case "a":
		counter = parseInt($("#ansA").text(),10) + 1;
		$("#ansA").text(counter);
		break;
	case "b":
		counter = parseInt($("#ansB").text(),10) + 1;
		$("#ansB").text(counter);
		break;
	case "c":
		counter = parseInt($("#ansC").text(),10) + 1;
		$("#ansC").text(counter);
		break;
	case "d":
		counter = parseInt($("#ansD").text(),10) + 1;
		$("#ansD").text(counter);
	}
}
function getQuiz(){
	var questionNo = parseInt($("#questionNo").text(),10);
	var wsMessage = new WSMessage ("ShowQuiz", thisQuizId,"admin",questionNo);
	stompClient.send("/app/DeQuiz.ShowQuiz/" + thisQuizId, {}, JSON
			.stringify(wsMessage));
	return false;
}

function populateQuestionDiv(wsMessage, source){
	$("#participantDiv").hide();
	$("#resultDiv").hide();
		
	$('#questionNo').text(wsMessage.wsQuestionNo);
	$('#question').text(wsMessage.wsQuestion);
	$('#optionA').text(wsMessage.wsOption_a);
	$('#optionB').text(wsMessage.wsOption_b);
	$('#optionC').text(wsMessage.wsOption_c);
	$('#optionD').text(wsMessage.wsOption_d);
	$("#showQuizDiv").show();
	$("#quizdiv").hide();
	$("#timertable").hide();
	$("#messagetable").show();
	currentAnswer = wsMessage.wsAnswer;
	displayQuestionDiv(wsMessage.wsTimer, source);
}

function displayQuestionDiv(timer, source){
	var remainingSec = 5;
	var marks = 1000;
	var dispalyQuestion = "Y";
	
	timerId1 = setInterval(function(){
		$("#timer").text (remainingSec);
		remainingSec = remainingSec - 1;
		clearInterval(timerId2);
		marks = remainingSec * 100;
		if (remainingSec < 0 ) {
			if (dispalyQuestion == "Y" ){
				dispalyQuestion = "N";
//show options
				remainingSec = timer;
				marks = remainingSec * 100;
				$("#timer").text (remainingSec);
				//if (source == "participant") 	remainingSec = 5;
				$("#quizdiv").show();
				$("#timertable").show();
				$("#messagetable").hide();
			} else {
//submit the form
				//remainingSec = 0;
				clearInterval(timerId1);
				clearInterval(timerId2);
				
				if (source == "participant"){
					selectedOption("x",0);
//				$("#quizform").submit();
				}
			}
		}		
		timerId2 = setInterval(function(){
			marks = marks - 1;
			if (marks < 0) {
//				console.log("clearing final timer: " + timerId2);
				clearInterval(timerId2);
			}
			else {$("#tmarks").text (marks);	}
		},10);
	},1000);
}
function selectedOption(option, marks){
	var result = "Correct"
	if (option != currentAnswer){
		marks = 0;
		result = "Incorrect";
	}
	totalMarks = totalMarks + parseInt(marks,10);
	//console.log ("option: " + option + " marks: " + marks + " timerId1: " + timerId1 + " timerId2: " + timerId2  );
	clearInterval(timerId1);
	clearInterval(timerId2);
	showResultDiv(result, marks);
	$("#resultWait").show();
	var wsAnstoAdmin = new WSAnsToAdmin("SendAnswer", thisUserId, thisQuizId, $("#questionNo").text(), option, marks);
	stompClient.send("/app/DeQuiz.SelectedAns/" + thisQuizId, {}, JSON
			.stringify(wsAnstoAdmin));
}
function showResultDiv(result, marks){
	$("#lastResult").text(result);
	$("#lastMarks").text(marks);
	$("#totalMarks").text(totalMarks);
	$("#showQuizDiv").hide();
	//$("#resultDiv").show();
}
function showResult(){
	clearInterval(timerId1);
	clearInterval(timerId2);
	var wsMessage = new WSMessage("ShowResult", thisQuizId, "admin",0);
	stompClient.send("/app/DeQuiz.ShowResult/" + thisQuizId, {}, JSON
			.stringify(wsMessage));
}
function displayResultTable(userList, listSize){
	console.log("displaying result");
	$("#resultWait").hide();
	$("#showQuizDiv").hide();
	clearInterval(timerId1);
	clearInterval(timerId2);
	
	var wsInnerHtml="<table><tr><td colspan='4'><b>Top 10 positions<b></td></tr>" +
	"<tr><td>Position</td><td>Participant</td><td>Total Marks</td><td>Last Marks</td></tr>";
	var rank;
	//$('#rankingDiv').html(wsInnerHtml);
	$.each(userList, function(index, list){
		rank = parseInt(index,10) + 1;
		wsInnerHtml = wsInnerHtml + "<tr><td>" + rank + "</td><td>" + list.dquUserName + "</td><td>" + 
		list.dquTotalMarks + "</td><td>" + list.dquMarks + "</td></tr>"
		//$('#rankingDiv').append(wsInnerHtml);
	})
	//$('#rankingDiv').append("</table>");
	wsInnerHtml = wsInnerHtml + "</table>";
	$('#rankingDiv').html(wsInnerHtml);
	$("#resultDiv").show();
}
function displayFinalResult(wsUserName){
	$("#oneresult").hide();
	$("#nextQuestion").hide();
	$('#finalResult').html("<H3>Final Result</H3>");
	$('#finalResult').append("Winner of the Quiz:<H3 Style='color:red'>" + wsUserName +"</H3>");
	$('#finalResult').append("<table><tr><td><H3><a href='/index.html'>Home</a></H3></td></tr></table>");
}
function initializeAnsCounter(wsAnswer){
	$("#ansA").text(0);
	$("#ansB").text(0);
	$("#ansC").text(0);
	$("#ansD").text(0);
	$("#ansA").css("color","red");
	$("#ansB").css("color","red");
	$("#ansC").css("color","red");
	$("#ansD").css("color","red");
	switch (wsAnswer){
	case "a" :
		$("#ansA").css("color","green");
		break;
	case "b":
		$("#ansB").css("color","green");
		break;
	case "c":
		$("#ansC").css("color","green");
		break;
	case "d":
		$("#ansD").css("color","green");
	}
	
}
function saveUserId(userId){
	 thisUserId = userId;
}
