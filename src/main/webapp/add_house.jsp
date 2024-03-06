<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/styles/styles.css"%></style>
<style><%@include file="/styles/add_property.css"%></style>
<title>Add House Details</title>
</head>
<body>

<!--Importing Header-->
 <jsp:include page="./header.jsp" />
 
 
 <!-- Add House Details Content -->
 <div class="banner-register">
    <div class="add_property">
   
        <h1 style="color: black; text-align: center">Add House Details</h1><br>
    
        <form action ="addHouse" method="post">  <!--Navigate to addHouse servlet -->

            Property Name : <br>
            <input type="text" name="pName" value = "<%= session.getAttribute("property_name") %>" placeholder="Enter property name" readonly>
			
            Number of Bedrooms : <br>
            <input type="text" name="num_bedrooms" placeholder="Enter number of bedrooms" required>

            Number of Bathrooms : <br>
            <input type="text" id="num_bathrooms" name="num_bathrooms"  placeholder="Enter number of barthrooms" required>
			
			Square Feet : <br>
            <input type="text" name="square_footage"  placeholder="How many square feet?" required>
            
            Has a Garage? : <br>
            <select name="has_garage" required>
                <option value="Yes">Yes</option>
                <option value="No">No</option>
            </select>
            
             House Amenities (Swimming pool , Fireplace , etc...) : <br>
            <textarea id="house_amenities" name="house_amenities" rows="4" cols="50" placeholder="Enter Amenities"></textarea>
			
            <input type="submit" name="submit" value="Add" id="submitbtn"><br> 

        </form>

</div>
</div>
 
 
 <!--Importing Footer-->
 <jsp:include page="./footer.jsp" />

</body>
</html>