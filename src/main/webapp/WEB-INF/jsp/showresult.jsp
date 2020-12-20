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
<link href="CSS/dequiz.css" rel="stylesheet" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
<script src="script/dequiz.js"></script>
<script type="text/javascript">
function preventBack(){
	window.history.forward();
}
$(document).ready(function(){
setTimeout(preventBack,0);
});
</script>

<title>Insert title here</title>
</head>
<body>
<div class="wrapper">
<!--  page header containg heading and menu -->
<div align="center">
  <span ><img src="images/dqlogo.jpg" alt="De Quiz" name="DeQuizLogo" width="80" height="80" id="DeQuizLogo" />
  </span> <span class="header">De Quiz</span>
</div>
<!--  end of page header -->
<!--  content block -->
<div class="content-window">
<div><H1>${deQuizUser.dquUserName}</H1></div>
<div align="center" style="font-size:min(5vw,40);" >
<form:form action="/startquiz"  method="post" modelAttribute="deQuizUser">
  <form:hidden path="dquUserId" value="${deQuizUser.dquUserId}"/>
  <form:hidden path="dquQuizId" value="${deQuizUser.dquQuizId}"/>
  <form:hidden path="dquQuestionNo" value="${deQuizUser.dquQuestionNo}"/>
  <form:label path="dquMarks">Your points for last question is:<b>${deQuizUser.dquMarks}</b></form:label><p/>
  <form:label path="dquTotalMarks">Your total points for this is:<b>${deQuizUser.dquTotalMarks}</b></form:label> <p/>
	<form:button>Next Question</form:button>	
</form:form>
<p>Correct Answer: ${deQuizUser.dquCorrectAns}</p>
<p/><span id="userMessage" ></span><p/>
</div>
</div>
<!--  Footer -->
<div class="footer">
&copy; DeQuiz India 
</div>
<!--  end of Footer -->

</div>

</body>
</html>