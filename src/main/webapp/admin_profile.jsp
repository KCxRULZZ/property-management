<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.Connection, java.sql.DriverManager, java.sql.Statement, java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/styles/styles.css"%></style>
<style><%@include file="/styles/admin_profile.css"%></style>

		<%-- Check if the "success" attribute is present in the request --%>
		<c:if test="${not empty requestScope.success}">
    		<Script>alert("${requestScope.success}")</Script>
		</c:if>
		
		<%-- Check if the "error" attribute is present in the request --%>
		<c:if test="${not empty requestScope.error}">
    		<Script>alert("${requestScope.error}")</Script>
		</c:if>

<title>Admin Profile</title>
</head>
<body>
    
    <!--Importing Header-->
    <jsp:include page="./header.jsp" />
    
    <!--Admin Profile Content-->
    <h1 class="heading">Admin Control</h1>

    <!-- Buyer table content -->
    <div class="buyer-table">
        <h2>Buyer Details</h2><br>
        <table class="table-style">
            <thead>
                <tr>
                    <th>Buyer ID</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>Phone No</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>DOB</th>
                    <th width="18%">Operations</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="buyer" items="${buyerDetails}">
                
                <c:set var = "Bid" value ="${buyer.id}"/>
                <c:set var = "Bname" value ="${buyer.name}"/>
                <c:set var = "Bgender" value ="${buyer.gender}"/>
                <c:set var = "Bphone" value ="${buyer.phone}"/>
                <c:set var = "Bemail" value ="${buyer.email}"/>
                <c:set var = "Baddress" value ="${buyer.address}"/>
                <c:set var = "Bdob" value ="${buyer.dob}"/>
                
                    	<tr>
                        <td>${buyer.id}</td>
                        <td>${buyer.name}</td>
                        <td>${buyer.gender}</td>
                        <td>${buyer.phone}</td>
                        <td>${buyer.email}</td>
                        <td>${buyer.address}</td>
                        <td>${buyer.dob}</td>
                        <td>
                            <div style="text-align: center;">
                            
                            	<c:url value = "update_buyer.jsp" var = "buyerUpdate">
                            		<c:param name="Bid" value = "${Bid}"/>
                            		<c:param name="Bname" value = "${Bname}"/>
                            		<c:param name="Bgender" value = "${Bgender}"/>
                            		<c:param name="Bphone" value = "${Bphone}"/>
                            		<c:param name="Bemail" value = "${Bemail}"/>
                            		<c:param name="Baddress" value = "${Baddress}"/>
                            		<c:param name="Bdob" value = "${Bdob}"/>
                            	</c:url>
                            	
                                <button class="update-btn"><a href="${buyerUpdate}">Update</a></button>
                                
                                <button class="delete-btn"><a href="DeleteUserServlet?deleteid=${buyer.id}">Delete</a></button>
                                
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <br>
        <h2>Seller Details</h2><br>
        <table class="table-style">
            <thead>
                <tr>
                    <th>Seller ID</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>Phone No</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>DOB</th>
                    <th width="18%">Operations</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="seller" items="${sellerDetails}">
                
                <c:set var = "Sid" value ="${seller.id}"/>
                <c:set var = "Sname" value ="${seller.name}"/>
                <c:set var = "Sgender" value ="${seller.gender}"/>
                <c:set var = "Sphone" value ="${seller.phone}"/>
                <c:set var = "Semail" value ="${seller.email}"/>
                <c:set var = "Saddress" value ="${seller.address}"/>
                <c:set var = "Sdob" value ="${seller.dob}"/>
                
                    	<tr>
                        <td>${seller.id}</td>
                        <td>${seller.name}</td>
                        <td>${seller.gender}</td>
                        <td>${seller.phone}</td>
                        <td>${seller.email}</td>
                        <td>${seller.address}</td>
                        <td>${seller.dob}</td>
                        <td>
                            <div style="text-align: center;">
                            	
                            	<c:url value = "update_seller.jsp" var = "sellerUpdate">
                            		<c:param name="Sid" value = "${Sid}"/>
                            		<c:param name="Sname" value = "${Sname}"/>
                            		<c:param name="Sgender" value = "${Sgender}"/>
                            		<c:param name="Sphone" value = "${Sphone}"/>
                            		<c:param name="Semail" value = "${Semail}"/>
                            		<c:param name="Saddress" value = "${Saddress}"/>
                            		<c:param name="Sdob" value = "${Sdob}"/>
                            	</c:url>
                            
                                <button class="update-btn"><a href="${sellerUpdate}">Update</a></button>
                                
                                <button class="delete-btn"><a href="DeleteUserServlet?deleteid=${seller.id}">Delete</a></button>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
    </div>
    
     <!-- Payment Details about property  -->
    
    <!-- Payment table content -->
	<div class="payment-table">
        <h2>Payment Details</h2><br>
        <table class="table-style">
            <thead>
                <tr>
                    <th>Payment ID</th>
                    <th>Card Number</th>
                    <th>Name</th>
                    <th>Card Type</th>
                    <th>Address</th>
                    <th>Country</th>
                    <th width="18%">Operations</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="pay" items="${paymentDetails}">
					
					<c:set var = "PaymentID" value ="${pay.paymentID}"/>
	                <c:set var = "Cnumber" value ="${pay.cNumber}"/>
	                <c:set var = "name" value ="${pay.name}"/>
	                <c:set var = "Ctype" value ="${pay.cType}"/>
	                <c:set var = "address" value ="${pay.address}"/>
	                <c:set var = "country" value ="${pay.country}"/>
					
                    	<tr>
                        <td>${pay.paymentID}</td>
                        <td>${pay.cNumber}</td>
                        <td>${pay.name}</td>
                        <td>${pay.cType}</td>
                        <td>${pay.address}</td>
                        <td>${pay.country}</td>
                        <td>
							
							<c:url value="payment_Update.jsp" var="payUpdate">
								<c:param name="PaymentID" value="${PaymentID}" />
								<c:param name="Cnumber" value="${Cnumber}" />
								<c:param name="name" value="${name}" />
								<c:param name="Ctype" value="${Ctype}" />
								<c:param name="address" value="${address}" />
								<c:param name="country" value="${country}" />

							</c:url> 
							
							<c:url value="payment_Delete.jsp" var="payDelete">
								<c:param name="PaymentID" value="${PaymentID}" />
								<c:param name="Cnumber" value="${Cnumber}" />
								<c:param name="name" value="${name}" />
								<c:param name="Ctype" value="${Ctype}" />
								<c:param name="address" value="${address}" />
								<c:param name="country" value="${country}" />
							</c:url>

							<div style="text-align: center;">  
                                <button class="update-btn"><a href="${payUpdate}">Update</a></button>
                                
                                <button class="delete-btn"><a href="${payDelete}">Delete</a></button>
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
