<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<style><%@include file="/styles/styles.css"%></style>
<style><%@include file="/styles/add_property.css"%></style>
<title>Add Land Details</title>
</head>
<body>

<!--Importing Header-->
 <jsp:include page="./header.jsp" />


<!-- Add Land Details Content -->
 <div class="banner-register">
    <div class="add_property">
   
        <h1 style="color: black; text-align: center">Add Land Details</h1><br>
    
        <form action ="addLand" method="post">

            Property Name : <br>
            <input type="text" name="property_name" value = "<%= session.getAttribute("property_name") %>" placeholder="Enter property name" readonly>
			
            Land Area : <br>
            <input type="text" name="land_area" placeholder="Enter land area" required>

            Zoning type (e.g., residential, commercial, agricultural) : <br>
            <input type="text" id="zoning_type" name="zoning_type"  placeholder="Enter zoning type" required>
			
			Land Topography (e.g., flat, hilly, waterfront): <br>
            <input type="text" name="land_topography"  placeholder="Enter land topography" required>
            
            Land Accessibility : <br>
            <input type="text" name="land_accessibility"  placeholder="Enter land accessibility" required>
            
            Potential Use of the Land? (e.g., farming, subdivision, commercial development) : <br>
            <textarea id="potential_landuse" name="potential_landuse" rows="4" cols="50" placeholder="Enter potential use of the land"></textarea>
			
            <input type="submit" name="submit" value="Add" id="submitbtn"><br> 

        </form>

</div>
</div>


 <!--Importing Footer-->
 <jsp:include page="./footer.jsp" />

</body>
</html>