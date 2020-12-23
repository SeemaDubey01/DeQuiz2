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

<div align="center">
		<h2>Create your quiz</h2>
		<form:form action="createquizstatus" method="post" modelAttribute="quizmaster">
		<form:hidden path="deqmQuizId" value ="${quizmaster.deqmQuizId}"/>
		<form:hidden path="deqmQuestionNo" value ="${quizmaster.deqmQuestionNo}"/>
		<form:hidden path="dqlUserId" value ="${quizmaster.dqlUserId}"/>
        <form:hidden path="deqmQuizDesc" value ="${quizmaster.deqmQuizDesc}"/>
        <form:hidden path="deqmQuizActive" value ="${quizmaster.deqmQuizActive}"/>
        <form:hidden path="deqmTimer" value ="${quizmaster.deqmTimer}"/>
			<form:label path="deqmQuizId"><H2> Quiz#: ${quizmaster.deqmQuizId}</H2></form:label><p/>
			<form:label path="deqmQuestionNo">Question#: ${quizmaster.deqmQuestionNo}</form:label><p/>
			<table>
			<tr>
			<td><form:label path="deqmQuestion"> Question: </form:label></td>
			<td><form:input path="deqmQuestion"/></td>  
			<td><form:errors path="deqmQuestion" cssClass="error" /></td>
			</tr><tr>
			<td><form:label path="deqmOption_a"> Option A: </form:label></td>
			<td><form:input path="deqmOption_a" /></td>
			<td><form:errors path="deqmOption_a" cssClass="error" /></td>
			</tr><tr>
			<td><form:label path="deqmOption_b"> Option B: </form:label></td>
			<td><form:input path="deqmOption_b" /></td>
			<td><form:errors path="deqmOption_b" cssClass="error" /></td>
			</tr><tr>
			<td><form:label path="deqmOption_c"> Option C: </form:label></td>
			<td><form:input path="deqmOption_c" /></td>
			<td><form:errors path="deqmOption_c" cssClass="error" /></td>
			</tr><tr>
			<td><form:label path="deqmOption_d"> Option D: </form:label></td>
			<td><form:input path="deqmOption_d" /></td>
			<td><form:errors path="deqmOption_d" cssClass="error" /></td>
			</tr><tr>
			<td><form:label path="deqmAnswer"> Correct option: </form:label></td>
			<td><form:select path="deqmAnswer">
			    <form:option value="a" label="a"></form:option>
			    <form:option value="b" label="b"></form:option>
			    <form:option value="c" label="c"></form:option>
			    <form:option value="d" label="d"></form:option>
			</form:select>
			</tr>
			</table><p/>
			<form:button>submit</form:button><p/>
		</form:form>
	</div>
</div>
<!--  end of content block -->
<!--  Footer -->
<div id="footerpage"></div>
<!--  end of Footer -->
</body>
</html>