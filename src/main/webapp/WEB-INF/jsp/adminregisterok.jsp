<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %> 
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
<script type="text/javascript">

function clickedit(){
	if($('input[name=deqmQuizId]:checked').length > 0){
		$('#dqlOperationType').attr('value','edit');
		$('#quizform').submit();
	}
	else{
		$('#errormessage').text('One quiz id needs to be selected')
		console.log('No quizid selected')
	}
}

function clickaddQuestion(){
	if($('input[name=deqmQuizId]:checked').length > 0){
		$('#dqlOperationType').attr('value','addQuestion');
		$('#quizform').submit();
	}
	else{
		$('#errormessage').text('One quiz id needs to be selected')
		console.log('No quizid selected')
	}
}


function clickeditNew(){
	if($('input[name=deqmQuizId]:checked').length > 0){
		$('#dqlOperationType').attr('value','editNew');
		$('#quizform').submit();
	}
	else{
		$('#errormessage').text('One quiz id needs to be selected')
		console.log('No quizid selected')
	}
}

function clickview(){
	if($('input[name=deqmQuizId]:checked').length > 0){
		$('#dqlOperationType').attr('value','view');
		$('#quizform').submit();
	}
	else{
		$('#errormessage').text('One quiz id needs to be selected')
		console.log('No quizid selected')
	}
}

function clickstart(){
	if($('input[name=deqmQuizId]:checked').length > 0){
		$('#dqlOperationType').attr('value','start');
		$('#quizform').submit();
	}
	else{
		$('#errormessage').text('One quiz id needs to be selected')
		console.log('No quizid selected')
	}
}

function clickdelete(){
	if($('input[name=deqmQuizId]:checked').length > 0){
		  var radioValue = $("input[name='deqmQuizId']:checked").val();
		var result = confirm("Want to delete Quiz Id"+ radioValue +" ?");
		  if (result==true) {
			  $('#dqlOperationType').attr('value','delete');
				$('#quizform').submit();
		  } else {
		   return false;
		  }
		
	}
	else{
		$('#errormessage').text('One quiz id needs to be selected')
		console.log('No quizid selected')
	}
}

function clickresetResult(){
	if($('input[name=deqmQuizId]:checked').length > 0){
		  var radioValue = $("input[name='deqmQuizId']:checked").val();
		var result = confirm("Want to clear the result for Quiz Id"+ radioValue +" ?");
		  if (result==true) {
			  $('#dqlOperationType').attr('value','resetResult');
				$('#quizform').submit();
		  } else {
		   return false;
		  }
		
	}
	else{
		$('#errormessage').text('One quiz id needs to be selected')
		console.log('No quizid selected')
	}
}

	
</script>
</head>
<body onload="MM_preloadImages('images/home_clicked.jpg','images/home_hover.jpg','images/aboutus_clicked.jpg','images/aboutus_hover.jpg','images/joinquiz_clicked.jpg','images/joinquiz_hover.jpg','images/contactus_clicked.jpg','images/contactus_hover.jpg','images/login_clicked.jpg','images/login_hover.jpg')">
<div class="wrapper">
<!--  page header containing heading and menu -->
<div align="center">
  <span ><img src="/images/dqlogo.jpg" alt="De Quiz" name="DeQuizLogo" width="80" height="80" id="DeQuizLogo" />
  </span> <span class="header">De Quiz</span>

<!--  page header containg heading and menu -->
<div class="menu-container">
<table >
  <tr>
    <td><a href="index.html" target="_top" onclick="MM_nbGroup('down','group1','Home','/images/home_clicked.jpg',1)" onmouseover="MM_nbGroup('over','Home','/images/home_clicked.jpg','/images/home_clicked.jpg',1)" onmouseout="MM_nbGroup('out')"><img src="/images/home.jpg" alt="Home" name="Home" class="menuitem" id="Home" onload="" /></a></td>
    <td><a href="aboutus.html" target="_top" onclick="MM_nbGroup('down','group1','AboutUs','/images/aboutus_clicked.jpg',1)" onmouseover="MM_nbGroup('over','AboutUs','/images/aboutus_hover.jpg','/images/aboutus_clicked.jpg',1)" onmouseout="MM_nbGroup('out')"><img src="/images/aboutus.jpg" alt="About Us" name="AboutUs" class="menuitem" id="AboutUs" onload="" /></a></td>
    <td><a href="joinQuiz" target="_top" onclick="MM_nbGroup('down','group1','JoinQuiz','/images/joinquiz_clicked.jpg',1)" onmouseover="MM_nbGroup('over','JoinQuiz','/images/joinquiz_hover.jpg','/images/joinquiz_clicked.jpg',1)" onmouseout="MM_nbGroup('out')"><img src="/images/joinquiz.jpg" alt="Join Quiz" name="JoinQuiz" class="menuitem" id="JoinQuiz" onload="" /></a></td>
    <td><a href="contactus.html" target="_top" onclick="MM_nbGroup('down','group1','ContactUs','/images/contactus_clicked.jpg',1)" onmouseover="MM_nbGroup('over','ContactUs','/images/contactus_hover.jpg','images/contactus_clicked.jpg',1)" onmouseout="MM_nbGroup('out')"><img src="/images/contactus.jpg" alt="Contact Us" name="ContactUs" class="menuitem" id="ContactUs" onload="" /></a></td>
    <td><a href="adminlogin" target="_top" onclick="MM_nbGroup('down','group1','LogIn','/images/login_clicked.jpg',1)" onmouseover="MM_nbGroup('over','LogIn','/images/login_hover.jpg','/images/login_hover.jpg',1)" onmouseout="MM_nbGroup('out')"><img src="/images/login_clicked.jpg" alt="Log in" name="LogIn" class="menuitem" id="LogIn" onload="" /></a></td>
  </tr>
</table>
</div></div>
<!--  end of page header -->
<!--  content block -->
<div class="content-window">
<H2>Registration Status <span></span></H2>
<div align="center" style="font-size:min(5vw,40);">
<form:form action="/QuizMaster/createquizHeader" method= "post" id="quizform" modelAttribute="deQuizLogin">
<form:hidden path="dqlUserId" value ="${deQuizLogin.dqlUserId}"/>

<form:hidden path="dqlOperationType" value ="create" />

	<form:label path="dqlUserId"> Admin: <span>${deQuizLogin.dqlUserId}</span>Welcome to DeQuiz<br/>Now you can start creating quiz</form:label><p/>
    <form:button name="create" value="create" >Create Quiz</form:button>
    <button name ="addQuestion" type="button" value ="" onclick="clickaddQuestion()">Add Question</button>
    <button name="view" type="button" value="view" onclick="clickview()">View Quiz</button>
    <button name="edit" type="button" value="edit" onclick="clickedit()">Edit Quiz</button>
    <button name="start" type="button" value="start" onclick="clickstart()">Start Quiz</button>
    <button name ="delete" type="button" value ="delete" onclick="clickdelete()">Delete Quiz</button>
    <button name ="resetResult" type="button" value ="resetResult" onclick="clickresetResult()">Reset Result</button>
    
    <div id="errormessage" class="error"></div>
    
    <table>
	<c:if test="${not empty existingDistinctQuizlist}">

	   <tr>
	   <td>Select quiz id </td>
	   <td>QuizId</td>
	   <td>Quiz Description</td>
	   </tr>
        <c:forEach var="listValue" items="${existingDistinctQuizlist}">
        <tr>
        <td><form:radiobutton path="deqmQuizId" value ="${listValue.deqmQuizId}"/></td>
           <td> ${listValue.deqmQuizId}</td>
             <td>${listValue.deqmQuizDesc}</td>
             </tr>
        </c:forEach>
  
	</c:if>
	</table>
</form:form>		
</div><p/>
</div>
<!--  end of content block -->
<!--  Footer -->
<div class="footer">
&copy; DeQuiz India
</div>
<!--  end of Footer -->
</div>
</body>
</html>