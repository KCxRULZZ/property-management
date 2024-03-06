<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/styles/paymentStyle.css"%></style>
<style><%@include file="/styles/styles.css"%></style>
<title>Payment Page</title>
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

	<!-- Payment staring place -->
	<div class="paymentBox">
    <div class="payment">
    
    <form action="Payment" method="post">

       <label>Card Number :</label><br>
       <input class="InputofData" type="number" name="Cnumber" placeholder="xxxx-xxxx-xxxx"><br>
       
       <label>Name :</label><br>
       <input type="text" name="name" placeholder="Your Name"><br>
       
       <label>Card Type :</label><br>
       <input type="text" name="Ctype" placeholder="Card Type"><br>

       <label>Address :</label><br>
       <input type="text" name="address" placeholder="Address"><br>

       <label>Country :</label><br>
       <input type="text" name="Country" placeholder="Country"><br>

        <button type="submit">Submit</button>
    </form>

    </div>
    </div>
    
<!--Importing Footer-->
 <jsp:include page="./footer.jsp" />
    
</body>
</html>