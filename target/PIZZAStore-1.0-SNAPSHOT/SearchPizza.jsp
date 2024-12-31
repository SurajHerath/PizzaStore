<%-- 
    Document   : SearchPizza
    Created on : Dec 19, 2024, 4:45:16 PM
    Author     : suraj
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    
    <title>Pizza - Free Bootstrap 4 Template by Colorlib</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Nothing+You+Could+Do" rel="stylesheet">

        <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
        <link rel="stylesheet" href="css/animate.css">

        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">

        <link rel="stylesheet" href="css/aos.css">

        <link rel="stylesheet" href="css/ionicons.min.css">

        <link rel="stylesheet" href="css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="css/jquery.timepicker.css">


        <link rel="stylesheet" href="css/flaticon.css">
        <link rel="stylesheet" href="css/icomoon.css">
        <link rel="stylesheet" href="css/style.css">
    
    <title>Search Pizza</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <div class="container">
        <h1>Search Pizza</h1>
        <form action="${pageContext.request.contextPath}/PizzaController?action=search" method="GET" class="form">
            <div class="form-group">
                <label for="keyword">Search Keyword:</label>
                <input type="text" id="keyword" name="keyword" required>
            </div>
            <button type="submit" class="btn btn-primary">Search</button>
        </form>
        
        <c:if test="${not empty searchResults}">
            <h2>Search Results</h2>
            <div class="pizza-list">
                <c:forEach items="${searchResults}" var="pizza">
                    <div class="pizza-card">
                        <h3>${pizza.pizza_Name}</h3>
                        <p><strong>ID:</strong> ${pizza.pizza_ID}</p>
                        <p><strong>Crust:</strong> ${pizza.crust}</p>
                        <p><strong>Sauce:</strong> ${pizza.sauce}</p>
                        <p><strong>Cheese:</strong> ${pizza.cheese}</p>
                        <p><strong>Loyalty Points:</strong> ${pizza.loyaltyPoints}</p>
                        <p><strong>Price:</strong> $${pizza.price}</p>
                        <a href="${pageContext.request.contextPath}/PizzaController?action=edit&id=${pizza.pizza_ID}" class="btn btn-secondary">Edit</a>
                        <a href="${pageContext.request.contextPath}/PizzaController?action=delete&id=${pizza.pizza_ID}" class="btn btn-danger">Delete</a>
                    </div>
                </c:forEach>
            </div>
        </c:if>
        
        <a href="${pageContext.request.contextPath}/PizzaController?action=list" class="btn btn-secondary">Back to Pizza List</a>
    </div>
</body>
</html>