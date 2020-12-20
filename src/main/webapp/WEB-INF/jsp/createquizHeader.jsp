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
<link href="CSS/dequiz.css" rel="stylesheet" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
<script src="script/dequiz.js"></script>
</head>
<body onload="MM_preloadImages('images/home_clicked.jpg','images/home_hover.jpg','images/aboutus_clicked.jpg','images/aboutus_hover.jpg','images/joinquiz_clicked.jpg','images/joinquiz_hover.jpg','images/contactus_clicked.jpg','images/contactus_hover.jpg','images/login_clicked.jpg','images/login_hover.jpg')">
<div class="wrapper">
<!--  page header containg heading and menu -->
<div align="center">
  <span ><img src="images/dqlogo.jpg" alt="De Quiz" name="DeQuizLogo" width="80" height="80" id="DeQuizLogo" />
  </span> <span class="header">De Quiz</span>

<!--  page header containg heading and menu -->
<div class="menu-container">
<table >
  <tr>
    <td><a href="index.html" target="_top" onclick="MM_nbGroup('down','group1','Home','images/home_clicked.jpg',1)" onmouseover="MM_nbGroup('over','Home','images/home_clicked.jpg','images/home_clicked.jpg',1)" onmouseout="MM_nbGroup('out')"><img src="images/home.jpg" alt="Home" name="Home" class="menuitem" id="Home" onload="" /></a></td>
    <td><a href="aboutus.html" target="_top" onclick="MM_nbGroup('down','group1','AboutUs','images/aboutus_clicked.jpg',1)" onmouseover="MM_nbGroup('over','AboutUs','images/aboutus_hover.jpg','images/aboutus_clicked.jpg',1)" onmouseout="MM_nbGroup('out')"><img src="images/aboutus.jpg" alt="About Us" name="AboutUs" class="menuitem" id="AboutUs" onload="" /></a></td>
    <td><a href="joinQuiz" target="_top" onclick="MM_nbGroup('down','group1','JoinQuiz','images/joinquiz_clicked.jpg',1)" onmouseover="MM_nbGroup('over','JoinQuiz','images/joinquiz_hover.jpg','images/joinquiz_clicked.jpg',1)" onmouseout="MM_nbGroup('out')"><img src="images/joinquiz.jpg" alt="Join Quiz" name="JoinQuiz" class="menuitem" id="JoinQuiz" onload="" /></a></td>
    <td><a href="contactus.html" target="_top" onclick="MM_nbGroup('down','group1','ContactUs','images/contactus_clicked.jpg',1)" onmouseover="MM_nbGroup('over','ContactUs','images/contactus_hover.jpg','images/contactus_clicked.jpg',1)" onmouseout="MM_nbGroup('out')"><img src="images/contactus.jpg" alt="Contact Us" name="ContactUs" class="menuitem" id="ContactUs" onload="" /></a></td>
    <td><a href="adminlogin" target="_top" onclick="MM_nbGroup('down','group1','LogIn','images/login_clicked.jpg',1)" onmouseover="MM_nbGroup('over','LogIn','images/login_hover.jpg','images/login_hover.jpg',1)" onmouseout="MM_nbGroup('out')"><img src="images/login_clicked.jpg" alt="Log in" name="LogIn" class="menuitem" id="LogIn" onload="" /></a></td>
  </tr>
</table>
</div></div>
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
<div class="footer">
&copy; DeQuiz India
</div>
<!--  end of Footer -->
</div>
</body>
</html>