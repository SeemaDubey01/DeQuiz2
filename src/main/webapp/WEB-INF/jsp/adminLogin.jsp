<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="description" content="Online quiz for variety of topics to enhance your knowledge. Gives a platform to play along with your fiends and families. Create your own quiz or join existing quiz.">
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
<H1>Admin Login</H1><p/>
<div align="center" style="font-size:min(5vw,40);">
		
		<form action="login" method="POST">
		<table>
		<tr>
			<td>User ID#</td>
			<td><input name="username"  /></td>
			<td style="color:red;">${SPRING_SECURITY_LAST_EXCEPTION.message}</td>
		</tr><tr>
			<td>Password:</td>
			<td><input type="password" name="password" /></td>
		</tr>
		<tr><td colspan="3" align="center"><button type="submit">submit</button></td>
		<tr><td colspan="3" align="center"><a href="/signUp">Not Registered SignUp Here</a></td></tr>
		</table>
		</form>
		
	</div>
	<br/><br/>
</div>
<!--  end of content block -->
<!--  Footer -->
<div id="footerpage"></div>
<!--  end of Footer -->
</body>
</html>
