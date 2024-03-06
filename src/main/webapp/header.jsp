<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <!--Navigation Content-->
    <nav style="position: relative; background-color: black;">
        <div class="nav-bar">
            <img src="images/logo1.png" class="logo">
            
            <ul>
                <li><a href="index.jsp" >Home</a></li>
                <li><a href="PropertyListServlet">Property</a></li>
                <li><a href="aboutus.jsp">About Us</a></li>
            </ul>

            <%-- Check if a session exists and if not, create a new one --%>
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