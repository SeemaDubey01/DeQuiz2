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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script src="/script/dequiz.js"></script>
<script src="/script/dequiz_ws.js"></script>
<script src="/script/classes.js"></script>
<link href="/CSS/dequiz.css" rel="stylesheet" type="text/css" />
<title>Join Quiz</title>
<script type="text/javascript">
$(document).ready(function(){
	openParticipantSocket(${deQuizMaster.deqmQuizId},  "${deQuizMaster.dquUserName}");
	saveUserId(${deQuizMaster.dquUserId});
	$("#showQuizDiv").hide();
	$("#resultWait").hide();
	$("#resultDiv").hide();
	
	$("#optionA").click(function(){selectedOption("a", $("#tmarks").text())});
	$("#optionB").click(function(){selectedOption("b", $("#tmarks").text())});
	$("#optionC").click(function(){selectedOption("c", $("#tmarks").text())});
	$("#optionD").click(function(){selectedOption("d", $("#tmarks").text())});
});

</script>
</head>
<body>
<H1 align="center"> Quiz #:${deQuizMaster.deqmQuizId } </H1>
<!-- waiting for participants -->
<H2>Welcome ${deQuizMaster.dquUserName}</H2>
<div id="participantDiv">
<H2>Waiting for QuizMaster to start the Quiz</H2>
</div>
<!-- question form -->
<div id="showQuizDiv" class="content-window">
<h1>Start Quiz</h1>
<div align="center" style="font-size:min(5vw,40);">
<!--  question number and question -->
  <div><span id="questionNo"></span>.  <span id="question"></span></div>
  <div id="quizdiv" class="quizdiv">
  <p id="optionA"></p>
  <p id="optionB"></p>
  <p id="optionC"></p>
  <p id="optionD"></p>
  </div><p/>

	<table id="timertable" Style="border:1px solid black;">
		<tr><td>Time remaining: <span id="timer">0</span> Seconds. </td></tr>
	</table>
	<table id="messagetable" Style="border:1px solid black;">
		<tr><td>Please wait for options</td></tr>
	</table>
</div><p/>
 <span id="tmarks" Style="display:none">0</span>
  </div>
<!--  End of content block -->
<!--  your result -->
<div id="resultWait">
<H3>Wait for your marks .....</H3>
</div>
<div id="resultDiv" align="center" style="font-size:min(5vw,40);">
<div id="oneresult"><H3>Result</H3>
<table style="border: 1px solid black">
	<tr><td>Answer for last question</td><td>....</td>
	<td><b><span id="lastResult">Incorrect</span></b></td></tr>
	<tr><td>Marks for last question</td><td>....</td>
	<td><b><span id="lastMarks">0</span></b></td></tr>
	<tr><td>Your total marks</td><td>....</td>
	<td><b><span id="totalMarks">0</span></b></td></tr>
</table>
<p/>
</div><div id="finalResult"></div>
<div id="rankingDiv" class="rankingDiv">
<table><tr><td colspan="4">Top 10 ranking</td></tr>
<tr><td>rank</td><td>name</td><td>total marks</td><td>last q marks</td></tr>
</table>
</div>
</div>
<!--  end of your result -->
</body>
</html>