<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/styles/styles.css"%></style>
<style><%@include file="/styles/add_property.css"%></style>
<title>Update Property</title>
</head>
<body>

<!--Importing Header-->
 <jsp:include page="./header.jsp" />
 
 <%
 	String PID = request.getParameter("PID");
	String pName = request.getParameter("pName");
	String pOwner = request.getParameter("pOwner");
	String pContact = request.getParameter("pContact");
	String pLocation = request.getParameter("pLocation");
	String pAmount = request.getParameter("pAmount");
	String pType = request.getParameter("pType");
	String OID = request.getParameter("OID");
  %>
 
 <!--Update Property Content-->
 <div class="banner-register">
    <div class="add_property">
   
        <h1 style="color: black; text-align: center">Update Property</h1><br>
    
        <form action ="updateProperty" method="post">
			
			Property ID : <br>
            <input type="text" name="PID" value = "<%=PID%>" placeholder="Enter property name" readonly>
			
			
            Property Name : <br>
            <input type="text" name="pName" value = "<%=pName%>" placeholder="Enter property name" required>
			
            Owner Name : <br>
            <input type="text" name="pOwner" value = "<%=pOwner%>" placeholder="Enter property owner name" required>

            Owner Number : <br>
            <input type="tel" id="pContact" name="pContact" pattern="[0-9]{10}" value="<%=pContact%>" placeholder="07XXXXXXXX" required>

            Property Location : <br>
            <textarea id="pLocation" name="pLocation" rows="4" cols="50" placeholder="Enter Location"><%=pLocation%></textarea> 
            
            Property Amount (in LKR) : <br>
            <input type="text" name="pAmount" value="<%=pAmount %>" placeholder="Enter property amount" required>
            
            Property Type : <br>
           <select name="property_type" required>
    			<option value="House" <%= "House".equals(pType) ? "selected" : "" %>>House</option> <!-- DEFAULT SELECT TYPE HOUSE -->
    			<option value="Apartment" <%= "Apartment".equals(pType) ? "selected" : "" %>>Apartment</option>
    			<option value="Land" <%= "Land".equals(pType) ? "selected" : "" %>>Land</option>
			</select>
            
			
            <input type="submit" name="submit" value="Update" id="submitbtn"><br> 

        </form>

    </div>
    </div>
 
 <!--Importing Footer-->
 <jsp:include page="./footer.jsp" />

</body>
</html>