<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!--css file link-->
<style><%@include file="/styles/login.css"%></style>

<%-- Check if the "success" attribute is present in the request --%>
<c:if test="${not empty requestScope.success}">
	<Script>
		alert("${requestScope.success}")
	</Script>
</c:if>

<%-- Check if the "error" attribute is present in the request --%>
<c:if test="${not empty requestScope.error}">
	<Script>
		alert("${requestScope.error}")
	</Script>
</c:if>

<title>Login Page</title>
</head>
<body>
	
	<!--Login form content-->
    <div class="banner-login">
    <div class="content">
            <div class="login-container">
                <h1>Login</h1>

                <form action = "log" method="post">

                    <label for="email">Email :</label>
                    <input type="email" id="email" name="email" placeholder="Enter your email" required autocomplete="off">

                    <label for="password">Password :</label>
                    <input type="password" id="password" name="password" placeholder="Enter your password" required autocomplete="off">

                    <input type="submit" name="submit" value="Log in">
                    
                    <%-- Check if the "error" attribute is present in the request --%>
					<c:if test="${not empty requestScope.error}">
    					<div class="error-message" style = "color : red; text-align: center;">
        					<p>${requestScope.error}</p> <br>
    					</div>
					</c:if>

                    <p style="color: black; text-align: center;">Don't have an account?  <a href="register.jsp" class="create-account">Create Account</a></p>
                </form>
            </div>
    </div>
    </div>

</body>
</html>