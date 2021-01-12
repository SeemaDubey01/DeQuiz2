<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
<script src="/script/dequiz.js"></script>
<link href="/CSS/dequiz.css" rel="stylesheet" type="text/css" />
 
<script type="text/javascript">
/*
$(document).ready(function(){
  $("#quizdiv").hide();
  $("#timertable").hide();
  $("#optionA").click(function(){
		$("#selectedAnswer").attr("value","a");
		$("#quizform").submit();
  });
  $("#optionB").click(function(){
		$("#selectedAnswer").attr("value","b");
		$("#quizform").submit();
  });
  $("#optionC").click(function(){
		$("#selectedAnswer").attr("value","c");
		$("#quizform").submit(); 
  });
  $("#optionD").click(function(){
		$("#selectedAnswer").attr("value","d");
		$("#quizform").submit();
  });
});*/
</script>
<title>DeQuiz: Start Quiz</title>
</head>
<body>
<div id="headerpage"></div>
<!--  end of page header -->
<!--  content block -->
<div class="content-window">
<H2>Welcome ${deQuizLogin.dqlUserId}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<span style="background-color: lightblue; font-size:20px; text-align:right">
	<a href="/logout" style="text-decoration:none;color:red; ">Log Out</a></span></H2>
<h1>View Quiz</h1>
<div align="center" style="font-size:min(5vw,40);">
<!--  question number and question -->
<form:form id="quizform" action="getNextQuestioin"  method="post" modelAttribute="deQuizMaster">
  <div>${deQuizMaster.deqmQuestionNo}.  ${deQuizMaster.deqmQuestion}</div>
  
  <form:hidden path="deqmQuizId" value="${deQuizMaster.deqmQuizId}"/>
  <form:hidden path="deqmQuestionNo" value="${deQuizMaster.deqmQuestionNo}"/>
  <form:hidden path="dquUserId" value="${deQuizMaster.dquUserId}"/>
  <form:hidden path="deqmAnswer" value="${deQuizMaster.deqmAnswer}"/>
  <form:hidden path="deqmOption_a" value="${deQuizMaster.deqmOption_a}"/>
  <form:hidden path="deqmOption_b" value="${deQuizMaster.deqmOption_b}"/>
  <form:hidden path="deqmOption_c" value="${deQuizMaster.deqmOption_c}"/>
  <form:hidden path="deqmOption_d" value="${deQuizMaster.deqmOption_d}"/>
  <form:hidden path="dquMarks" value="0"/>
    <form:hidden path="selectedAnswer" value="x"/>
  <div id="quizdiv1" class="quizdiv">
  <p id="optionA">
  <form:label path="deqmOption_a">${deQuizMaster.deqmOption_a}</form:label>
  </p>
  <p id="optionB">
  <form:label path="deqmOption_b">${deQuizMaster.deqmOption_b}</form:label>
  </p>
  <p id="optionC">
  <form:label path="deqmOption_c">${deQuizMaster.deqmOption_c}</form:label>
  </p>
  <p id="optionD">
  <form:label path="deqmOption_d">${deQuizMaster.deqmOption_d}</form:label>
  </p>
  <p id="Answer">
  Answer:
  <form:label path="deqmAnswer">${deQuizMaster.deqmAnswer}</form:label>
  </p>
  </div><p/>
  <form:button name="submit" value = "submit">Next Question</form:button>
</form:form>
	
</div><p/>
</div>
<!--  End of content block -->
<!--  Footer -->
<div id="footerpage"></div>
<!--  end of Footer -->
</body>
</html>