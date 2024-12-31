<%-- 
    Document   : invoice
    Created on : Dec 25, 2024, 6:10:46 PM
    Author     : suraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="model.Order"%>
<%@page import="service.OrderService"%>

<!DOCTYPE html>
<html lang="en">
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
    
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Invoice</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Invoice</h1>
        <% 
    String orderID = request.getParameter("orderID");
    String originalTotalStr = request.getParameter("originalTotal").replace(",", ""); // Remove commas
    double originalTotal = Double.parseDouble(originalTotalStr);  // Now parse
    String finalTotalStr = request.getParameter("finalTotal").replace("$", "").replace(",", ""); // Remove '$' and commas
    double finalTotal = Double.parseDouble(finalTotalStr); // Now parse
    String creditCardType = request.getParameter("creditCardType");

    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
    
    OrderService orderService = new OrderService();
    Order order = orderService.getOrderById(orderID);
%>

        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Order Invoice</h5>
                <p class="card-text">Thank you for your payment!</p>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"><strong>Order ID:</strong> <%= orderID %></li>
                    <li class="list-group-item"><strong>Original Total:</strong> <%= currencyFormatter.format(originalTotal) %></li>
                    <li class="list-group-item"><strong>Discounts Applied:</strong> <%= currencyFormatter.format(originalTotal - finalTotal) %></li>
                    <li class="list-group-item"><strong>Final Total:</strong> <%= currencyFormatter.format(finalTotal) %></li>
                    <li class="list-group-item"><strong>Payment Method:</strong> <%= creditCardType.substring(0, 1).toUpperCase() + creditCardType.substring(1) %></li>
                </ul>
                <div class="text-center mt-4">
                    <a href="ViewAllOrders.jsp" class="btn btn-primary">Back to Orders</a>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>