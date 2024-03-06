<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/styles/styles.css"%></style>
<style><%@include file="/styles/property_list.css"%></style>
<title>Property List</title>
</head>
<body>

<!--Navigation Content-->
    <nav style="position: relative; background-color: black;">
        <div class="nav-bar">
            <img src="images/logo1.png" class="logo">
            
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="PropertyListServlet" style="color: rgb(255, 115, 0);">Property</a></li>
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
    
    	<!-- Property Content -->
    
    	<div class="propertyList">
    	
    	<% int imgCount = 1;%>
    
      	<c:forEach var="property" items="${propertyList}">
      	
      		<c:set var = "PID" value ="${property.PID}"/>
      		<c:set var = "OID" value ='<%= session.getAttribute("user_ID") %>'/>
      		<c:set var = "pName" value ="${property.pName}"/>
      		<c:set var = "pOwner" value ="${property.pOwner}"/>
      		<c:set var = "pAmount" value ="${property.pAmount}"/>
      		<c:set var = "pLocation" value ="${property.pLocation}"/>
      		<c:set var = "pContact" value ="${property.pContact}"/>
      		
      		
      		<c:url value="add_bookmark.jsp" var="addBookmark">
				<c:param name="PID" value="${PID}"/>
				<c:param name="OID" value="${OID}"/>
				<c:param name="pName" value="${pName}"/>
				<c:param name="pOwner" value="${pOwner}"/>
				<c:param name="pAmount" value="${pAmount}"/>
				<c:param name="pLocation" value="${pLocation}"/>
				<c:param name="pContact" value="${pContact}"/>
			</c:url>
      	
      		<div class="box">
            <div class="boxpic1" style="background-image: url('images/property<%=imgCount%>.jpg');"></div>
            <div class="boxtxt">
                <h1 class="Pname">${property.pName}</h1>
                <h5 class="padd">${property.pLocation}</h5>
                <h5 class="ppub">${property.pContact}</h5>
                <h1 class="amount">LKR ${property.pAmount}</h1>
                <div class="liitlebox">
                
						<%
						if ("Buyer".equals(accountType)) {
						%>

						<button class="buttonleft bleft">
							<a href="PaymentPage.jsp">Pay Now</a>
						</button>



						<button class="buttonRight bright">
							<a href="${addBookmark}">Bookmark</a>
						</button>

						<%
						}
						%>
					</div>
            </div>
        	</div>
        	<%
        	imgCount++;
        	%>
      	</c:forEach>
  
    	</div>
    

	<!--Importing Footer-->
    <jsp:include page="./footer.jsp" />


</body>
</html>