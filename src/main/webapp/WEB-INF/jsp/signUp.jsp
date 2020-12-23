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
<title>Online Quiz for Everyone - DeQuiz</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link href="/CSS/dequiz.css" rel="stylesheet" type="text/css" />
<script src="/script/dequiz.js"></script>
</head>
<body>
<div id="headerpage"></div>
<!--  end of page header -->
<!--  content block -->
<div class="content-window">
<H2>Register QuizMaster</H2><p/>
<div align="center" style="font-size:min(5vw,40);">
		<table>
		<form:form action="/saveAdmin" method="post" modelAttribute="deQuizLogin">
		<tr>
			<td><form:label path="dqlUserId">User ID#:</form:label></td>
			<td><form:input path="dqlUserId"  /></td>
			<td><form:errors path="dqlUserId" cssClass="error" /></td>
		</tr><tr>
			<td><form:label path="dqlPassword">Password:</form:label></td>
			<td><form:password path="dqlPassword" /></td>
			<td><form:errors path="dqlPassword" cssClass="error" /></td>
		</tr><tr>
		</tr><tr>
			<td><form:label path="dqlFirstName">First Name:</form:label></td>
			<td><form:input path="dqlFirstName" /></td>
			<td><form:errors path="dqlFirstName" cssClass="error" /></td>
		</tr><tr>
		</tr><tr>
			<td><form:label path="dqlLastName">Last Name:</form:label></td>
			<td><form:input path="dqlLastName" /></td>
			<td><form:errors path="dqlLastName" cssClass="error" /></td>
		</tr><tr>
		</tr><tr>
			<td><form:label path="dqlEmail">Email Id:</form:label></td>
			<td><form:input path="dqlEmail" /></td>
			<td><form:errors path="dqlEmail" cssClass="error" /></td>
		</tr><tr><td><br/></td></tr>
		<tr>
			<td colspan="3" align="center"><form:button>submit</form:button></td>
		</tr>
		</form:form>
		</table>
	</div>
	<br/><br/>
</div>

<!--  end of content block -->
<!--  Footer -->
<div id="footerpage"></div>
<!--  end of Footer -->
</body>
</html>
