<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/styles/paymentUpdateTemp.css"%></style>
<style><%@include file="/styles/styles.css"%></style>
<title>Update Payment </title>
</head>
<body>
<!--Navigation Content-->
    <nav>
        <div class="nav-bar">
            <img src="images/logo1.png" class="logo">
            
            <ul>
                <li><a href="index.jsp" >Home</a></li>
                <li><a href="PropertyListServlet" style="color: rgb(255, 115, 0)" >Property</a></li>
                <li><a href="aboutus.jsp">About Us</a></li>
            </ul>

            <%-- Check the user's account type and display the appropriate link --%>
    		<%
        		String accountType = (String) session.getAttribute("account");

        		if ("Buyer".equals(accountType)) {
    		%>
        		<p>
            		<a href="buyer_profile.jsp" class="user-display">
                		<%= session.getAttribute("user_name") %>
            		</a>
        		</p>
    		<%
        		} else if ("Seller".equals(accountType)) {
    		%>
        		<p>
            		<a href="seller_profile" class="user-display">
                		<%= session.getAttribute("user_name") %>
            		</a>
        		</p>
    		<%
        		} else if ("admin".equals(accountType)) {
    		%>
        		<p>
            		<a href="admin_profile" class="user-display" style="text-transform: uppercase;">
                		Admin Profile
            		</a>
        		</p>
    		<%
        		}
    		%>

            <a href='logout' class='logout'>Log Out</a>
            
        </div>
        </nav>

    	<%
    		String id = request.getParameter("PaymentID");
    		String Cnumber = request.getParameter("Cnumber");
    		String name = request.getParameter("name");
    		String Ctype = request.getParameter("Ctype");
    		String address = request.getParameter("address");
    		String country = request.getParameter("country");
    	%>
    	

		<!-- Payment staring place -->
		<div class="paymentBox">
		<h1 style="color: white; text-align: center">Update Payment</h1><br>
    <div class="payment">
    <form action="UpdatePayment" method="post">
    
    <label>PaymentId :</label><br>
       <input class="InputofData" type="number" name="id" value="<%=id %>" readonly><br>
       
       <label>Card Number :</label><br>
       <input class="InputofData" type="number" name="Cnumber" value="<%=Cnumber%>"><br>
       
       <label>Name :</label><br>
       <input type="text" name="name" value="<%=name%>"><br>
       
       <label>Card Type :</label><br>
       <input type="text" name="Ctype" value="<%=Ctype%>"><br>

       <label>Address :</label><br>
       <input type="text" name="address" value="<%=address%>"><br>

       <label>Country :</label><br>
       <input type="text" name="Country" value="<%=country%>"><br>

        <button type="submit" name="pass" >Update</button>
    </form>

    </div>
    </div>
    
<!--Importing Footer-->
 <jsp:include page="./footer.jsp" />
</body>
</html>