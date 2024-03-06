<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/styles/buyer_profile.css"%></style>
<style><%@include file="/styles/styles.css"%></style>

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

<title>Buyer Profile</title>
</head>
<body>

	 <!--Importing Header-->
    <jsp:include page="./header.jsp" />

	<!-- Seller Profile Content -->
	<div class="profile-container">
      <div class="profile-section">
        <h2>BUYER PROFILE</h2>
      </div>
      <div class="profile-details">
         <img src="images/profile.png" alt="profile picture" width="100px" height="100px" class="img1"
         />
         <h1><%= session.getAttribute("user_name") %></h1>
      </div>
      
      <c:forEach var="buyer" items="${buyerDetails}">
       		
       		<c:set var = "Bid" value ="${buyer.id}"/>
            <c:set var = "Bname" value ="${buyer.name}"/>
            <c:set var = "Bgender" value ="${buyer.gender}"/>
            <c:set var = "Bphone" value ="${buyer.phone}"/>
            <c:set var = "Bemail" value ="${buyer.email}"/>
            <c:set var = "Baddress" value ="${buyer.address}"/>
            <c:set var = "Bdob" value ="${buyer.dob}"/>

			<c:url value="update_buyer.jsp" var="buyerUpdate">
				<c:param name="Bid" value="${Bid}" />
				<c:param name="Bname" value="${Bname}" />
				<c:param name="Bgender" value="${Bgender}" />
				<c:param name="Bphone" value="${Bphone}" />
				<c:param name="Bemail" value="${Bemail}" />
				<c:param name="Baddress" value="${Baddress}" />
				<c:param name="Bdob" value="${Bdob}" />
			</c:url>
		
		</c:forEach>


        <div class="profile-info">
          <p><b>Name:</b>		${Bname}</p>
          <p><b>Contact:</b>	${Bphone}</p>
          <p><b>Email:</b>		${Bemail}</p>
        </div>
  
        <div class="profile-buttons">
          <button id="update-profile">
				<a href="${buyerUpdate}">Update Profile</a>
			</button>
			<button id="delete-profile">
				<a href="DeleteBuyerServlet?deleteid=<%=session.getAttribute("user_ID")%>">Delete Profile</a>
			</button>
        </div>
    </div> 
 	
 	 <!-- Buyer table content -->
    <div class="buyer-table">
    	<h2>Bookmarks</h2><br>
        <table class="table-style">
            <thead>
                <tr>
                    <th>Bookmark ID</th>
                    <th>Property Name</th>
                    <th>Property Owner</th>
                    <th>Property Amount</th>
                    <th>Property Location</th>
                    <th>Property Contact</th>
                    <th width="18%">Operations</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="bookmark" items="${bookmarkDetails}">
                
                
                    	<tr>
                        <td>${bookmark.bookID}</td>
                        <td>${bookmark.pName}</td>
                        <td>${bookmark.pOwner}</td>
                        <td>${bookmark.pAmount}</td>
                        <td>${bookmark.pAddress}</td>
                        <td>${bookmark.oContact}</td>
                        <td>
                            <div style="text-align: center;">                         
                                
                                <button class="delete-btn"><a href="DeleteBookmarkServlet?deleteid=${bookmark.bookID}">Delete</a></button>
                                
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    
     <!--Importing Footer-->
    <jsp:include page="./footer.jsp" />

</body>
</html>