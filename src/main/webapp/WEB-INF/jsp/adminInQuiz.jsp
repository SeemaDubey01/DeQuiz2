<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="description" content="Online quiz for variety of topics to enhance your knowledge. Gives a platform to play along with your fiends and families. Create your own quiz or join quiz.">
<meta name="keywords" content="Online Quiz, Online tests, dequiz, Indian quiz, entertainment, group activity">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-171638931-1"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-171638931-1');
</script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script src="/script/dequiz.js"></script>
<script src="/script/dequiz_ws.js"></script>
<script src="/script/classes.js"></script>
<link href="/CSS/dequiz.css" rel="stylesheet" type="text/css" />
<title>Admin - Quiz Participants</title>
<script type="text/javascript">
$(document).ready(function(){
	openAdminSocket(${deQuizMaster.deqmQuizId});
	$("#getQuiz").click(getQuiz);
	$("#showQuizDiv").hide();
	$("#resultDiv").hide();
	$("#showResult").click(showResult);
	$("#nextQuestion").click(getQuiz);
});
</script>
</head>
<body>
<H1 align="center"> Quiz #:${deQuizMaster.deqmQuizId } </H1>
<!-- waiting for participants -->
<div id="participantDiv">
<H2>Waiting for participants</H2>
	<form:form id="getQuiz" modelAttribute="deQuizMaster">
		<H2>Starting quiz #${deQuizMaster.deqmQuizId }</H2>
		<p>Participant lists:</p>
		<div id="paritipants"></div>
		<form:button>Start Quiz</form:button>
	</form:form>
</div>
<!-- question form -->
<div id="showQuizDiv" class="content-window">
<h1>QuizMaster Panel > Start Quiz</h1>
<div align="center" style="font-size:min(5vw,40);">
<!--  question number and question -->
  <div><span id="questionNo">0</span>.  <span id="question"></span></div>
  <div id="quizdiv" class="quizdiv">
  <p id="optionA"></p>
  <p id="optionB"></p>
  <p id="optionC"></p>
  <p id="optionD"></p>
  </div><p/>

	<table id="timertable" Style="border:1px solid black;">
		<tr><td>Time remaining: <span id="timer">0</span> Seconds. <!-- Marks<span id="tmarks">0</span> --></td></tr>
	</table>
	<table id="messagetable" Style="border:1px solid black;">
		<tr><td>Please wait for options</td></tr>
	</table><P/>
	<table id="stats" Style="border:1px solid black;">
		<tr><td>Answer received: A: <span id="ansA">0</span> B:<span id="ansB">0</span> C: <span id="ansC">0</span> D: <span id="ansD">0</span></td></tr>
	</table><p/>
	<table>
	<tr><td><button id="showResult">Next</button>
	</table>
</div><p/>
</div>
<!--  End of content block -->
<!--  your result -->
<div id="resultDiv" align="center" style="font-size:min(5vw,40);">
<div id="finalResult"></div>
<div id="rankingDiv" class="rankingDiv"></div><p/>
<button id="nextQuestion">Next Question</button>
</div>
<!--  end of your result -->

</body>
</html>