<%-- 
    Document   : ReviewOrder
    Created on : Dec 23, 2024, 6:32:48 PM
    Author     : suraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
    
    <title>Review Order</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>Review Your Order</h1>
    <p><strong>Pizza:</strong> ${pizzaName}</p>
    <p><strong>Extra Toppings:</strong> ${extraToppings}</p>
    <p><strong>Order Type:</strong> ${orderType}</p>
    <c:if test="${orderType == 'Delivery'}">
        <p><strong>Delivery Address:</strong> ${deliveryAddress}</p>
    </c:if>
    <p><strong>Discount:</strong> ${discount}</p>
    <p><strong>Total Price:</strong> $${totalPrice}</p>
    <form action="OrderController?action=placeOrder" method="POST">
        <button type="submit">Confirm Order</button>
    </form>
</body>
</html>

