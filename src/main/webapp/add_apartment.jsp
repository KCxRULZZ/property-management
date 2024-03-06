<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/styles/styles.css"%></style>
<style><%@include file="/styles/add_property.css"%></style>
<title>Add Apartment Details</title>
</head>
<body>

<!--Importing Header-->
 <jsp:include page="./header.jsp" />


<!-- Add Apartment Details Content -->
 <div class="banner-register">
    <div class="add_property">
   
        <h1 style="color: black; text-align: center">Add Apartment Details</h1><br>
    
        <form action ="addApartment" method="post">

            Property Name : <br>
            <input type="text" name="pName" value = "<%= session.getAttribute("property_name") %>" placeholder="Enter property name" readonly>
			
            Number of Bedrooms : <br>
            <input type="text" name="num_bedrooms" placeholder="Enter number of bedrooms" required>

            Number of Bathrooms : <br>
            <input type="text" id="num_bathrooms" name="num_bathrooms"  placeholder="Enter number of barthrooms" required>
			
			Floor Number : <br>
            <input type="text" name="floor_number"  placeholder="Enter floor number" required>
            
            Has a Balcony? : <br>
            <select name="has_balcony" required>
                <option value="Yes">Yes</option>
                <option value="No">No</option>
            </select>
            
             Building Amenities (Swimming pool , GYM , etc...) : <br>
            <textarea id="building_amenities" name="building_amenities" rows="4" cols="50" placeholder="Enter Amenities"></textarea>
			
            <input type="submit" name="submit" value="Add" id="submitbtn"><br> 

        </form>

</div>
</div>


 <!--Importing Footer-->
 <jsp:include page="./footer.jsp" />

</body>
</html>