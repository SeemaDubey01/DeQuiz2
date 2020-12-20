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
<link href="/CSS/dequiz.css" rel="stylesheet" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
<script src="/script/dequiz.js"></script>
</head>
<body>
<div id="headerpage"></div>
<!--  end of page header -->
<!--  content block -->
<div class="content-window">
<div align="center">
		<h2>Create your quiz</h2>
		<form:form action="/createquizDetail" method="post" modelAttribute="deQuizMaster">
		<form:hidden path="dqlUserId" value ="${deQuizMaster.dqlUserId}"/>
		<form:hidden path="deqmQuizId" value ="${deQuizMaster.deqmQuizId}"/>
			<table>
			<tr>
			<form:label path="dqlUserId"><H2> AdminId#: ${deQuizMaster.dqlUserId}</H2></form:label><p/>
			<form:label path="deqmQuizId"><H2> Quiz#: ${deQuizMaster.deqmQuizId}</H2></form:label><p/>
			<td><form:label path="deqmQuizDesc"> Quiz Desc: </form:label></td>
			<td><form:input path="deqmQuizDesc"/></td> 
			</tr>
			<td><form:label path="deqmQuizActive"> Active: </form:label></td>
			<td><form:select path="deqmQuizActive">
			    <form:option value="Y" label="Y"></form:option>
			    <form:option value="N" label="N"></form:option>
			</form:select>
			</td></tr>
			<td><form:label path="deqmTimer"> Timer (seconds): </form:label></td>
			<td><form:input path="deqmTimer" value="15" /></td>
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