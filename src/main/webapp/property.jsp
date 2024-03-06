<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/styles/styles.css"%></style>
<title>Property Page</title>
</head>
<body>

<!--Navigation Content-->
    <nav style="position: relative; background-color: black;">
        <div class="nav-bar">
            <img src="images/logo1.png" class="logo">
            
            <ul>
                <li><a href="index.jsp" style="color: rgb(255, 115, 0);">Home</a></li>
                <li><a href="#">Property</a></li>
                <li><a href="#">Services</a></li>
                <li><a href="#">About Us</a></li>
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
            		<a href="seller_profile.jsp" class="user-display">
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
    
    <!-- payment container -->
	<div class="paymentBox">
	    <div class="payment">
	    <form>
	
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
    
    
    <!--Footer Content-->
	<footer class="footer">
     <div class="container">
        <div class="row">
        
        	<div class="footer-col">
        		<div class="logoaddress">
                	<img src="images/logo.png"  id="Logofooter" alt=""> <br> <br>
               		<p class="address">conbusi@support.com+10 873 672 6782600/D,<br>Green road, Colombo</p>
            	</div>
            </div>
            
            <div class="footer-col">
                <h4>Quick Links</h4>
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="#">Property</a></li>
                    <li><a href="#">Services</a></li>
                    <li><a href="#">About Us</a></li>
                </ul>
            </div>
            
            <div class="footer-col">
                <h4>Contact Us</h4>
                <ul>
                    <li><a href="#">Facebook</a></li>
                    <li><a href="#">Twitter</a></li>
                    <li><a href="#">Gamil</a></li>
                    <li><a href="#">Instagram</a></li>
                </ul>
            </div>
            
            <div class="footer-col">
                <h4>Account</h4>
                <ul>
                    <li><a href="login.jsp">Log In</a></li>
                    <li><a href="register.jsp">Register</a></li>
                </ul>
            </div>
        </div>
     </div>
  	 </footer>

</body>
</html>