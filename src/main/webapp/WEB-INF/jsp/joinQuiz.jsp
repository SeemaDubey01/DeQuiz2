<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>JoinQuiz</title>
<meta name="description" content="Online quiz for variety of topics to enhance your knowledge. Gives a platform to play along with your fiends and families. Create your own quiz or join quiz.">
<meta name="keywords" content="Online Quiz, Online tests, dequiz, Indian quiz, entertainment, group activity">
<link href="/CSS/dequiz.css" rel="stylesheet" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/script/dequiz.js"></script>
</head>
<body>
<div id="headerpage"></div>
<!-- main content -->
<div class="content-window">
<H1>Join Quiz</H1>
	<h2>Participants please enter details</h2>
	Try sample quiz - 102 or 369<p/>
		<div id="registerform" align="center">
		<table>
		<form:form action="userInQuiz" method="get" modelAttribute="deQuizUser">
		<tr>
			<td><form:label path="dquQuizId">Quiz#:</form:label></td>
			<td><form:input path="dquQuizId" type = "number" /></td>
			<td><form:errors path="dquQuizId" cssClass="error" /></td>
		</tr><tr>
			<td><form:label path="dquUserName">Your Name:</form:label></td>
			<td><form:input path="dquUserName" /></td>
			<td><form:errors path="dquUserName" cssClass="error" /></td>
		</tr><tr>
			<td colspan="3" align="center"><form:button>submit</form:button></td>
		</tr>
		</form:form>
		</table><p/>
	</div>
</div>
<!--  Footer -->
<div id="footerpage" class="footer"></div>
<!--  end of Footer -->
</body>
</html>