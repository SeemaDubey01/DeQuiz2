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
<!--	var remainingSec = 5;
	var marks = 1000;
	var dispalyQuestion = "Y";
	$("#msg").text (remainingSec);
	var timerId = setInterval(function(){
		$("#timer").text (remainingSec);
		remainingSec = remainingSec - 1;
		if (remainingSec < 0 ) {
			if (dispalyQuestion == "Y" ){
				dispalyQuestion = "N";
//show options
				remainingSec = ${deQuizMaster.deqmTimer};
		//		remainingSec = 100;
				marks = remainingSec * 100;		
				$("#quizdiv").show();
				$("#timertable").show();
				$("#messagetable").hide();
		//		clearInterval(timerId);
			} else {
//submit the form
				remainingSec = 0;
				$("#quizform").submit();
			}
		}		
		setInterval(function(){
			marks = marks - 1;
			if (marks < 0 ) marks =0;
			$("#tmarks").text (marks);	
			$("#dquMarks").attr("value",marks);
//			console.log("time: " + remainingSec + " marks: " + marks);
		},100);
//		clearInterval(timerId);	
/*		setTimeout(function calculateMarks(){
			marks = marks - 1;
			if (marks < 0 ) marks =0;
			$("#tmarks").text (marks);	
			$("#dquMarks").attr("value",marks);
			setTimeout(calculateMarks,100);
//			console.log("time: " + remainingSec + " marks: " + marks);
		},100);*/
		//console.log("time11: " + remainingSec + " marks: " + marks);
	},1000);
 -->
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
});
</script>
<title>DeQuiz: Start Quiz</title>
</head>
<body>
<div class="wrapper">
<!--  page header containing heading and menu -->
<div align="center">
  <span ><img src="images/dqlogo.jpg" alt="De Quiz" name="DeQuizLogo" width="80" height="80" id="DeQuizLogo" />
  </span> <span class="header">De Quiz</span>
</div>
<!--  end of page header -->
<!--  content block -->
<div class="content-window">
<h1>Start Quiz</h1>
<h3>the logged in  user is ${sessionScope.deQuizLogin.dqlUserId}</h3>
<div align="center" style="font-size:min(5vw,40);">
<!--  question number and question -->
<form:form id="quizform" action="/getNextQuestioin"  method="post" modelAttribute="deQuizMaster">
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
  <div id="quizdiv" class="quizdiv">
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
  Answer
  <form:label path="deqmAnswer">${deQuizMaster.deqmAnswer}</form:label>
  </p>
  </div><p/>
  <form:button name="submit" value = "submit">Next Question</form:button>
</form:form>
	
</div><p/>
</div>
<!--  End of content block -->
<!--  Footer -->
<div class="footer">
&copy; DeQuiz India 
</div>
<!--  end of Footer -->

</div>

</body>
</html>