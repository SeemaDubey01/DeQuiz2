<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="description" content="Online quiz for variety of topics to enhance your knowledge. Gives a platform to play along with your fiends and families. Create your own quiz or join quiz.">
<meta name="keywords" content="Online Quiz, Online tests, dequiz, Indian quiz, entertainment, group activity">
<title>DeQuiz - Admin - Start Quiz</title>
</head>
<body>
<div class="content-window">
<H1>Start Quiz</H1>
	<h2>Start quiz for your team here</h2>
		<div id="startform" align="center">
		<table>
		<form:form action="adminStartQuiz" method="post" modelAttribute="deQuizMaster">
		<tr>
			<td><form:label path="deqmQuizId">Quiz#:</form:label></td>
			<td><form:input path="deqmQuizId" type = "number" /></td>
		</tr><tr>
			<td colspan="3" align="center"><form:button>submit</form:button></td>
		</tr>
		</form:form>
		</table><p/>
	</div>
</div>

</body>
</html>