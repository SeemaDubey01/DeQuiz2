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
	}
}	
</script>
</head>
<body>
<div id="headerpage"></div>
<!--  end of page header -->
<!--  content block -->
<div class="content-window">
<H2>Welcome ${deQuizLogin.dqlUserId}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<span style="background-color: lightblue; font-size:20px; text-align:right">
	<a href="/logout" style="text-decoration:none;color:red; ">Log Out</a></span></H2>
<div align="center" style="font-size:min(5vw,40);">
<ul>
	<li>One</li>
	<li id='loginSec'>Two</li>
</ul>
<form:form action="/QuizMaster/createquizHeader" method= "post" id="quizform" modelAttribute="deQuizLogin">
<form:hidden path="dqlUserId" value ="${deQuizLogin.dqlUserId}"/>

<form:hidden path="dqlOperationType" value ="create" />
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
<div id="footerpage"></div>
<!--  end of Footer -->
</body>
</html>