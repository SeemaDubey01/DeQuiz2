<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>Registration Status</title>
<meta name="description" content="Online quiz for variety of topics to enhance your knowledge. Gives a platform to play along with your fiends and families. Create your own quiz or join quiz.">
<meta name="keywords" content="Online Quiz, Online tests, dequiz, Indian quiz, entertainment, group activity">
<link href="/CSS/dequiz.css" rel="stylesheet" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/script/dequiz.js"></script>
</head>
<body>
<div class="wrapper">
<!--  page header containg heading and menu -->
<div id="headerpage"></div>
<!--  end of page header -->
<!--  content block -->
<div class="content-window">
<H2>Registration Status <span></span></H2>
<div align="center" style="font-size:min(5vw,40);">
<form:form action="startquiz" method="post"  modelAttribute="deQuizUser">
	<form:hidden path="dquQuizId" value ="${deQuizUser.dquQuizId}"/>
	<form:hidden path="dquUserId" value ="${deQuizUser.dquUserId}"/>
	<form:hidden path="dquQuestionNo" value ="${deQuizUser.dquQuestionNo}"/>
	<form:hidden path="dquUserName" value ="${deQuizUser.dquUserName}"/>
	<form:label path="dquQuizId">Quiz#: <span>${deQuizUser.dquQuizId}</span></form:label><p/>
	<form:label path="dquUserName">Quiz#: <span>${deQuizUser.dquUserName}</span></form:label><p/>
	<form:button>Continue</form:button>
</form:form>		
</div>
</div>
<!--  Footer -->
<div id="footerpage" class="footer"></div>
<!--  end of Footer -->

</div>

</body>
</html>