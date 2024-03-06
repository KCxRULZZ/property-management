<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/styles/styles.css"%></style>
<style><%@include file="/styles/update_buyer.css"%></style>

		<%-- Check if the "success" attribute is present in the request --%>
		<c:if test="${not empty requestScope.success}">
    		<Script>alert("${requestScope.success}")</Script>
		</c:if>
		
		<%-- Check if the "error" attribute is present in the request --%>
		<c:if test="${not empty requestScope.error}">
    		<Script>alert("${requestScope.error}")</Script>
		</c:if>

<title>Update Page</title>
</head>
<body>
	
	<!--Importing Header-->
    <jsp:include page="./header.jsp" />

	<div class="banner-register">
    <!--Update Form Content-->
    <div class="buyer">
    	
    	<%
    		String id = request.getParameter("Bid");
    		String name = request.getParameter("Bname");
    		String gender = request.getParameter("Bgender");
    		String phone = request.getParameter("Bphone");
    		String email = request.getParameter("Bemail");
    		String address = request.getParameter("Baddress");
    		String dob = request.getParameter("Bdob");
    	%>
    	
        
        <h1 style="color: black; text-align: center">Update Buyer</h1><br>
    
        <form action ="updateUser" method="post">

			Buyer ID : <br>
            <input type="text" name="Bid" value = "<%=id%>" readonly>
			
            Full Name : <br>
            <input type="text" name="name" value = "<%=name%>" placeholder="Enter Full Name" required>
			
            Gender : 
            <input type="radio" id="Male" name="gender" value="Male" <%= "Male".equals(gender) ? "checked" : "" %>>Male
            <input type="radio" id="Female" name="gender" value="Female" <%= "Female".equals(gender) ? "checked" : "" %>>Female<br> <br>

            Mobile Number : <br>
            <input type="tel" id="phone" name="phone" value = "<%=phone%>" pattern="[0-9]{10}" placeholder="07XXXXXXXX" required>

            Email : <br>
            <input type="email" id="email" name="email" value = "<%=email%>" placeholder="Enter Email" required>

            Address : <br>
            <textarea id="address" name="address" rows="4" cols="50" placeholder="Enter Address"><%=address%></textarea> 

            Date of Birth : <br>
            <input type="date" name="dob" value = "<%=dob%>" required>

            <input type="submit" name="submit" value="Update" id="submitbtn"><br> 

        </form>

    </div>
    </div>
    
    <!--Importing Footer-->
    <jsp:include page="./footer.jsp" />

</body>
</html>