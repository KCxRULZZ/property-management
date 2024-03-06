<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/styles/styles.css"%></style>
<style><%@include file="/styles/add_property.css"%></style>
<title>Add Bookmark</title>
</head>
<body>
<!--Importing Header-->
 <jsp:include page="./header.jsp" />
 
 <!-- Add Bookmark Content -->
 <div class="banner-register">
    <div class="add_property">
    
    <%
    	
	    String PID = request.getParameter("PID");
		String OID = request.getParameter("OID");
		String pName = request.getParameter("pName");
		String pOwner = request.getParameter("pOwner");
		String pAmount = request.getParameter("pAmount");
		String pLocation = request.getParameter("pLocation");
		String pContact = request.getParameter("pContact");
    
    
    %>
   
        <h1 style="color: black; text-align: center">Add Bookmark</h1><br>
    
        <form action ="addBookmark" method="post">

            Property ID : <br>
            <input type="text" name="PID" value = "<%=PID%>" placeholder="Enter property name" readonly>
            
            Owner ID : <br>
            <input type="text" name="OID" value = "<%=OID%>" placeholder="Enter property name" readonly>
			
            Property Name : <br>
            <input type="text" name="pName" value = "<%=pName%>" placeholder="Enter number of bedrooms" readonly>

            Owner Name : <br>
            <input type="text" id="pOwner" name="pOwner" value = "<%=pOwner%>" placeholder="Enter number of barthrooms" readonly>
			
			Property Amount : <br>
            <input type="text" name="pAmount" value = "<%=pAmount%>" placeholder="How many square feet?" readonly>
      
            Property Location : <br>
            <textarea id="pLocation" name="pLocation" rows="4" cols="50" placeholder="Enter Location"readonly><%=pLocation%></textarea>
			
			Property Contact : <br>
            <input type="tel" name="pContact" value = "<%=pContact%>" placeholder="How many square feet?" readonly>
      
            <input type="submit" name="submit" value="Add Bookmark" id="submitbtn"><br> 

        </form>

</div>
</div>
 
 
 
 <!--Importing Footer-->
 <jsp:include page="./footer.jsp" />
</body>
</html>