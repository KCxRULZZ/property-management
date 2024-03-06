<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/styles/seller_profile.css"%></style>
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

<title>Seller Profile</title>
</head>
<body>

	 <!--Importing Header-->
    <jsp:include page="./header.jsp" />

	<!-- Seller Profile Content -->
	<div class="profile-container">
      <div class="profile-section">
        <h2>SELLER PROFILE</h2>
      </div>
      <div class="profile-details">
         <img src="images/profile.png" alt="profile picture" width="100px" height="100px" class="img1"/>
         <h1><%= session.getAttribute("user_name") %></h1>
      </div>
      
       <c:forEach var="Seller" items="${SellerDetails}">
       		
       		<c:set var = "Sid" value ="${Seller.id}"/>
            <c:set var = "Sname" value ="${Seller.name}"/>
            <c:set var = "Sgender" value ="${Seller.gender}"/>
            <c:set var = "Sphone" value ="${Seller.phone}"/>
            <c:set var = "Semail" value ="${Seller.email}"/>
            <c:set var = "Saddress" value ="${Seller.address}"/>
            <c:set var = "Sdob" value ="${Seller.dob}"/>

			<c:url value="update_seller.jsp" var="SellerUpdate">
				<c:param name="Sid" value="${Sid}" />
				<c:param name="Sname" value="${Sname}" />
				<c:param name="Sgender" value="${Sgender}" />
				<c:param name="Sphone" value="${Sphone}" />
				<c:param name="Semail" value="${Semail}" />
				<c:param name="Saddress" value="${Saddress}" />
				<c:param name="Sdob" value="${Sdob}" />
			</c:url>
		
		</c:forEach>
		
        <div class="profile-info">
          <p><b>Name:</b>		${Sname}</p>
          <p><b>Contact:</b>	${Sphone}</p>
          <p><b>Email:</b>		${Semail}</p>
        </div>

		<div class="profile-buttons">
			<button id="update-profile">
				<a href="${SellerUpdate}">Update Profile</a>
			</button>
			<button id="delete-profile">
				<a href="DeleteSellerServlet?deleteid=<%=session.getAttribute("user_ID")%>">Delete Profile</a>
			</button>
		</div>
	</div> 
    

    
    <div class="p-button">
        <button id="Add-Properties"><a href="add_property.jsp">Add Property</a></button>
    </div>

    
    <!-- Seller table content -->
    <div class="seller-table">
    	<h2>Property Ads</h2><br>
        <table class="table-style">
            <thead>
                <tr>
                    <th>Property ID</th>
                    <th>Property Name</th>
                    <th>Property Location</th>
                    <th>Property Amount</th>
                    <th>property Type</th>
                    <th width="18%">Operations</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="seller" items="${sellerProperty}">
                
                <c:set var = "PID" value ="${seller.PID}"/>
                <c:set var = "pName" value ="${seller.pName}"/>
                <c:set var = "pOwner" value ="${seller.pOwner}"/>
                <c:set var = "pContact" value ="${seller.pContact}"/>
                <c:set var = "pLocation" value ="${seller.pLocation}"/>
                <c:set var = "pAmount" value ="${seller.pAmount}"/>
                <c:set var = "pType" value ="${seller.pType}"/>
                <c:set var = "OID" value ="${seller.OID}"/>
                
                    	<tr>
                        <td>${seller.PID}</td>
                        <td>${seller.pName}</td>
                        <td>${seller.pLocation}</td>
                        <td>${seller.pAmount}</td>
                        <td>${seller.pType}</td>
                        <td>
                            <div style="text-align: center;">
                            
                            	<c:url value = "update_property.jsp" var = "sellerPropertyUpdate"> <!-- navigate updateProperty.jsp -->
                            		<c:param name="PID" value = "${PID}"/>
                            		<c:param name="pName" value = "${pName}"/>
                            		<c:param name="pOwner" value = "${pOwner}"/>
                            		<c:param name="pContact" value = "${pContact}"/>
                            		<c:param name="pLocation" value = "${pLocation}"/>
                            		<c:param name="pAmount" value = "${pAmount}"/>
                            		<c:param name="pType" value = "${pType}"/>
                            		<c:param name="OID" value = "${OID}"/>
                            	</c:url>
                            	
                                <button class="update-btn"><a href="${sellerPropertyUpdate}">Update</a></button>
                                
                                <button class="delete-btn"><a href="DeletePropertyServlet?deleteid=${seller.PID}">Delete</a></button>
                                
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br>
        
    </div>
    
    <!--Importing Footer-->
    <jsp:include page="./footer.jsp" />
	

</body>
</html>