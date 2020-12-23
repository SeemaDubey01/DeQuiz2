<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="description" content="Online quiz for variety of topics to enhance your knowledge. Gives a platform to play along with your fiends and families. Create your own quiz or join quiz.">
<meta name="keywords" content="Online Quiz, Online tests, dequiz, Indian quiz, entertainment, group activity">
<title>DeQuiz - Create Quiz</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link href="/CSS/dequiz.css" rel="stylesheet" type="text/css" />
<script src="/script/dequiz.js"></script>
</head>
<body>
<div id="headerpage"></div>
<!--  end of page header -->
<!--  content block -->
<div class="content-window">
<H2> Create Quiz Status</H2><p/>
<form:form action="createquiz" method="post"  modelAttribute="deQuizMaster">
	<form:hidden path="deqmQuizId" value ="${deQuizMaster.deqmQuizId}"/>
	<form:hidden path="deqmQuestionNo" value ="${deQuizMaster.deqmQuestionNo}"/>
	<form:hidden path="dqlUserId" value ="${deQuizMaster.dqlUserId}"/>
<form:hidden path="deqmQuizDesc" value ="${deQuizMaster.deqmQuizDesc}"/>
<form:hidden path="deqmQuizActive" value ="${deQuizMaster.deqmQuizActive}"/>
<form:hidden path="deqmTimer" value ="${deQuizMaster.deqmTimer}"/>
	<form:label path="deqmQuizId">Quiz#: <span>${deQuizMaster.deqmQuizId}</span></form:label><p/>
	<form:label path="deqmQuestionNo">Question: <span>${deQuizMaster.deqmQuestionNo}</span></form:label><p/>
	
	<form:button>Create Another</form:button>
	<input type="button" onclick="location.href='getUserQuizList';" value="Go to Quiz List" />
</form:form>

</div>
<!--  end of content block -->
<!--  Footer -->
<div id="footerpage"></div>
<!--  end of Footer -->
</body>
</html>