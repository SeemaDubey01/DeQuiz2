<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="description" content="Online quiz for variety of topics to enhance your knowledge. Gives a platform to play along with your fiends and families. Create your own quiz or join quiz.">
<meta name="keywords" content="Online Quiz, Online tests, dequiz, Indian quiz, entertainment, group activity">
<title>DeQuiz - Create Quiz Details</title>
</head>
<body>
<H2> Create Detail Quiz</H2><p/>
<form:form action="/createquiz" method="post"  modelAttribute="deQuizMaster">
<form:hidden path="dqlUserId" value ="${deQuizMaster.dqlUserId}"/>
<form:hidden path="deqmQuizDesc" value ="${deQuizMaster.deqmQuizDesc}"/>
<form:hidden path="deqmQuizActive" value ="${deQuizMaster.deqmQuizActive}"/>
<form:hidden path="deqmTimer" value ="${deQuizMaster.deqmTimer}"/>
<form:hidden path="deqmQuizId" value ="${deQuizMaster.deqmQuizId}"/>

	
	<form:button>Create Quiz Details</form:button>
</form:form>

<a href="/getUserQuizList">Back</a>
</body>
</html>