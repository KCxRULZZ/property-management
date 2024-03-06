<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/styles/aboutus.css"%></style>
<title>About us</title>
</head>
<body>

	<!--Navigation Content-->
    <nav>
        <div class="nav-bar">
            <img src="images/logo1.png" class="logo">
            
            <ul>
                <li><a href="index.jsp" >Home</a></li>
                <li><a href="PropertyListServlet">Property</a></li>
                <li><a href="aboutus.jsp" style="color: rgb(255, 115, 0);">About Us</a></li>
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
            <h1>About Propertix</h1>
            <p>You can read our grow</p>
        </div>
    </div>

<!-- admin main page staring -->

    <div class="aboutmain">
      <div class="box1">
        <div class="missionpic"></div>
        <div class="missiontxt">
          Our mission is to revolutionize property management by providing a seamless online platform that empowers property owners, tenants, and property managers alike. We are committed to simplifying the complex processes of property management, making it efficient, transparent, and stress-free.</div>

      </div>
      <div class="box2">
        <div class="visiontxt">
          Our vision for the online property management system is to redefine the way property management is conducted in the digital age. We aspire to create a platform that seamlessly connects property owners, tenants, and property managers, streamlining operations and enhancing efficiency. Our vision is to empower property owners with real-time insights into their investments, providing them with the tools and data they need to make informed decisions.
        </div>
        <div class="visionpic"></div>
      </div>
      <div class="box2">
        <div class="targetpic"></div>
        <div class="targettxt">The target of an online property management system website is to provide property owners, landlords, and real estate professionals with a comprehensive and user-friendly platform to streamline their property management processes. Our website aims to offer a range of essential features, including efficient tenant screening, automated rent collection, property maintenance tracking, and insightful financial reporting. </div>
      </div>

    </div>
  
    <div class="ranquetsion">
      <div class="fqpic">

      </div>
      <br><br>
      <h1 class="fq">Frequantly Ask</h1>
      <dl>
        <dt><b>What is a property management website?</b></dt>
        <dd>A property management website is an online platform designed to help property owners and managers streamline their rental property operations. It typically offers features such as tenant screening, rent collection, maintenance tracking, and financial reporting.</dd>

        <dt><b>Why should I use a property management website?</b></dt>
        <dd>Property management websites make it easier to manage rental properties by automating tasks, providing valuable insights, and improving overall efficiency. They save time, reduce administrative burdens, and help you make informed decisions.</dd>

        <dt><b>Can I manage multiple properties on the website?</b></dt>
        <dd>Yes, our website is scalable and allows you to manage multiple properties from a single dashboard. You can track each property's performance and manage them efficiently.</dd>
      </dl>


    </div>

</body>
</html>