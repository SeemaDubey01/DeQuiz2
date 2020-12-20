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
    <td><a href="index.html" target="_top" onclick="MM_nbGroup('down','group1','Home','images/home_clicked.jpg',1)" onmouseover="MM_nbGroup('over','Home','images/home_hover.jpg','images/home_clicked.jpg',1)" onmouseout="MM_nbGroup('out')"><img src="images/home.jpg" alt="Home" name="Home" class="menuitem" id="Home" onload="" /></a></td>
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
<div class="footer">
&copy; DeQuiz India
</div>
<!--  end of Footer -->
</div>
</body>
</html>
