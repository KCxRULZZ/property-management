<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/styles/register.css"%></style>

		<%-- Check if the "success" attribute is present in the request --%>
		<c:if test="${not empty requestScope.success}">
    		<Script>alert("${requestScope.success}")</Script>
		</c:if>
		
		<%-- Check if the "error" attribute is present in the request --%>
		<c:if test="${not empty requestScope.error}">
    		<Script>alert("${requestScope.error}")</Script>
		</c:if>

<title>Register Page</title>
</head>
<body>
	
	<div class="banner-register">
    <!--Register Form Content-->
    <div class="register">
        
        <h1 style="color: black; text-align: center;">Register Form</h1>
		
    
        <form action ="insert" method="post">

            Full Name : <br>
            <input type="text" name="name" placeholder="Enter Full Name" required>

            Gender : 
            <input type="radio" id="Male" name="gender" value="Male">Male
            <input type="radio" id="Female" name="gender" value="Female">Female<br> <br>

            Mobile Number : <br>
            <input type="tel" id="phone" name="phone" pattern="[0-9]{10}" placeholder="07XXXXXXXX" required>

            Email : <br>
            <input type="email" id="email" name="email" placeholder="Enter Email" required>

            Address : <br>
            <textarea id="address" name="address" rows="4" cols="50" placeholder="Enter Address"></textarea> 

            Date of Birth : <br>
            <input type="date" name="dob" required>

            Password : <br>
            <input type="password" id="psw" name="psw" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required>

            Re-enter Password : <br>
            <input type="password" id="repsw" name="repsw" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required>

            User Type : <br>
            <select name="user_type" required>
                <option value="Buyer">Buyer</option>
                <option value="Seller">Seller</option> 
            </select> <br>

            <input type="submit" name="submit" value="Register" id="submitbtn"><br> 

            <p style="color: #121212; text-align: center;">Already have an account? <a href="login.jsp">Login here</a></p>

        </form>

    </div>
    </div>


</body>
</html>