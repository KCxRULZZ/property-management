<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/styles/styles.css"%></style>
<title>Home Page</title>
</head>
<body>

	<!--Navigation Content-->
    <nav>
        <div class="nav-bar">
            <img src="images/logo1.png" class="logo">
            
            <ul>
                <li><a href="index.jsp" style="color: rgb(255, 115, 0);">Home</a></li>
                <li><a href="PropertyListServlet">Property</a></li>
                <li><a href="aboutus.jsp">About Us</a></li>
            </ul>

            <%-- Check the user's account type and display the appropriate link --%>
    		<%
        		String accountType = (String) session.getAttribute("account");

        		if ("Buyer".equals(accountType)) {
    		%>
        		<p>
            		<a href="buyer_profile" class="user-display">
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

    <!--Index Content-->
    <div class = "banner-index">
        <div class="content">
            <h1>Welcome to Propertix</h1>
            <p>Get your dream property today</p>
        </div>
    </div>
    
    <!-- Location Content - from google maps -->
	<section class="location">
	    <div class="section-title">
	        <h1 class="h1">Location</h1>
	        <h4 class="h4map">Propertix Plus</h4>
	    </div>
	    <div class="map"> <!--google maps link-->
	    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15843.193344432502!2d79.95449056714044!3d6.914698446804928!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3ae256db1a6771c5%3A0x2c63e344ab9a7536!2sSri%20Lanka%20Institute%20of%20Information%20Technology!5e0!3m2!1sen!2slk!4v1685550835799!5m2!1sen!2slk" width="100%" height="450" style="border:0; border-radius:25px;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
	    </div>
	</section>

    <!--Team Information Content-->
<div class="our-team">

    <h1 class="heading">Our Team</h1>
    
    <div class="box-container">
    
        <div class="box">
            <center><img src="images/profile.png" alt=""></center>
            <h3>Senanayake S M A S N</h3>
            <p>IT22305282</p>
        </div>
    
        <div class="box">
            <center><img src="images/profile.png" alt=""></center>
            <h3>Fernando M K C</h3>
            <p>IT22346254</p>
        </div>
    
        <div class="box">
            <center><img src="images/profile.png" alt=""></center>
            <h3>Anupama S K D N</h3>
            <p>IT22323552</p>
        </div>
    
        <div class="box">
            <center><img src="images/profile.png" alt=""></center>
            <h3>Prasadh N H</h3>
            <p>IT22327758</p>
        </div>
    
    </div>
</div>


	<!-- why postion view part -->
	<div class="whyus-container">
	
	<h1 class="heading">Why us</h1><br>
	
		<p class="whyuspara">We truly target our customers. We provide
			many things, such as the ability to take your key when you finish the
			down payment. We sell properties for a small budget so you can save
			money, and if you have any property, you can sell your house or land.</p>
		<div class="whyus">
			<div class="card card1"></div>
			<div class="card card2"></div>
			<div class="card card3"></div>
		</div>
	</div>

	<!--Importing Footer-->
    <jsp:include page="./footer.jsp" />

</body>
</html>