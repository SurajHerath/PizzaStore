<%-- 
    Document   : CustomerOrderDetails
    Created on : Dec 25, 2024, 3:55:11 PM
    Author     : suraj
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Order"%>
<%@ page import="model.OrderState"%>
<%@ page import="service.OrderService"%>
<%@ page import="service.OrderStatesService"%>
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
        <link rel="stylesheet" href="css/style.css"><!-- comment -->
        
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Your Order Details - Pizza Store</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <style>
            /* Global Styles */
            body {
                font-family: 'Roboto', Arial, sans-serif;
                background-color: #121212;
                color: #ffffff;
                margin: 0;
                padding: 0;
                background-image: url('https://images.unsplash.com/photo-1513104890138-7c749659a591?ixlib=rb-1.2.1&auto=format&fit=crop&w=1950&q=80');
                background-size: cover;
                background-attachment: fixed;
                background-position: center;
            }

            .container {
                background-color: rgba(18, 18, 18, 0.8);
                border-radius: 15px;
                padding: 30px;
                margin-top: 30px;
                box-shadow: 0 0 20px rgba(255, 255, 255, 0.1);
            }

            h1, h2 {
                color: #ffd700;
                text-align: center;
                margin-bottom: 30px;
            }

            /* Navbar Styles */
            .navbar {
                background-color: rgba(18, 18, 18, 0.9);
                padding: 15px 0;
            }

            .navbar-brand {
                color: #ffd700;
                font-size: 1.5em;
                font-weight: bold;
            }

            .nav-link {
                color: #ffffff;
                margin: 0 15px;
                transition: color 0.3s ease;
            }

            .nav-link:hover {
                color: #ffd700;
            }

            /* Table Styles */
            .table {
                color: #ffffff;
                background-color: rgba(255, 255, 255, 0.1);
                border-radius: 10px;
                overflow: hidden;
            }

            .table th {
                background-color: rgba(255, 215, 0, 0.2);
                color: #ffd700;
                border-color: #343a40;
            }

            .table td {
                border-color: #343a40;
            }

            /* Card Styles */
            .card {
                background-color: rgba(255, 255, 255, 0.1);
                border: none;
                border-radius: 10px;
                margin-bottom: 20px;
            }

            .card-header {
                background-color: rgba(255, 215, 0, 0.2);
                color: #ffd700;
                font-weight: bold;
            }

            .card-body {
                color: #ffffff;
            }

            /* Timeline Styles */
            .timeline {
                position: relative;
                max-width: 1200px;
                margin: 0 auto;
            }

            .timeline::after {
                content: '';
                position: absolute;
                width: 6px;
                background-color: #ffd700;
                top: 0;
                bottom: 0;
                left: 50%;
                margin-left: -3px;
            }

            .timeline-item {
                padding: 10px 40px;
                position: relative;
                background-color: inherit;
                width: 50%;
            }

            .timeline-item::after {
                content: '';
                position: absolute;
                width: 25px;
                height: 25px;
                right: -17px;
                background-color: #ffd700;
                border: 4px solid #FF9F55;
                top: 15px;
                border-radius: 50%;
                z-index: 1;
            }

            .left {
                left: 0;
            }

            .right {
                left: 50%;
            }

            .right::after {
                left: -16px;
            }

            .timeline-content {
                padding: 20px 30px;
                background-color: rgba(255, 255, 255, 0.1);
                position: relative;
                border-radius: 6px;
            }

            /* Button Styles */
            .btn-custom {
                background-color: #ffd700;
                color: #121212;
                border: none;
                padding: 10px 20px;
                border-radius: 5px;
                font-weight: bold;
                transition: all 0.3s ease;
            }

            .btn-custom:hover {
                background-color: #ffea00;
                transform: translateY(-2px);
                box-shadow: 0 4px 8px rgba(255, 215, 0, 0.3);
            }
        </style>
    </head>
    <body>
        <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark" id="ftco-navbar">
    <div class="container">
        <a class="navbar-brand" href="index.html">
            <span class="flaticon-pizza-1 mr-1"></span>Pizza<br><small>Store</small>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a href="customerindex.jsp" class="nav-link">Home</a>
                </li>
                <li class="nav-item">
                    <a href="PizzaController?action=list" class="nav-link">Menu</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="customPizzaDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Custom Pizza
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="customPizzaDropdown">
                        <li><a class="dropdown-item" href="CustomPizza.jsp">Custom Pizza</a></li>
                        <li><a class="dropdown-item" href="CustomPizzaController?action=viewAll">View Custom Pizza</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a href="userProfile.jsp" class="nav-link">Profile</a>
                </li>
                <li class="nav-item">
                    <a href="OrderController?action=viewByCustomerId" class="nav-link">Orders</a>
                </li>
                <li class="nav-item">
                    <a href="FeedbackController?action=list" class="nav-link">Feedback</a>
                </li>
                <li class="nav-item">
                    <a href="about.html" class="nav-link">About</a>
                </li>
                <li class="nav-item">
                    <a href="contact.html" class="nav-link">Contact</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
        <div class="container mt-5">
            <h1 class="text-center mb-4"><i class="fas fa-receipt me-2"></i>Your Order Details</h1>

            <%
                String orderID = request.getParameter("orderID");
                if (orderID == null || orderID.isEmpty()) {
            %>
            <div class="alert alert-warning" role="alert">
                <i class="fas fa-exclamation-triangle me-2"></i>No order ID provided. Please check the URL and try again.
            </div>
            <%
            } else {
                OrderService orderService = new OrderService();
                OrderStatesService orderStatesService = new OrderStatesService();

                Order order = orderService.getOrderById(orderID);
                List<OrderState> orderStates = orderStatesService.getOrderStatesByOrderId(orderID);

                if (order != null) {
            %>
            <div class="row">
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-header">
                            <h2 class="mb-0"><i class="fas fa-info-circle me-2"></i>Order Information</h2>
                        </div>
                        <div class="card-body">
                            <table class="table table-borderless">
                                <tr>
                                    <th>Order ID</th>
                                    <td><%= order.getOrderID()%></td>
                                </tr>
                                <tr>
                                    <th>Customer ID</th>
                                    <td><%= order.getCustomerID()%></td>
                                </tr>
                                <tr>
                                    <th>Pizza ID</th>
                                    <td><%= order.getPizzaID()%></td>
                                </tr>
                                <tr>
                                    <th>Extra Topping ID</th>
                                    <td><%= order.getExtraToppingID()%></td>
                                </tr>
                                <tr>
                                    <th>Order Type</th>
                                    <td><%= order.getOrderType()%></td>
                                </tr>
                                <tr>
                                    <th>Delivery Address</th>
                                    <td><%= order.getDeliveryAddress()%></td>
                                </tr>
                                <tr>
                                    <th>Total Price</th>
                                    <td>$<%= String.format("%.2f", order.getTotalPrice())%></td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="card">
                        <div class="card-header">
                            <h2 class="mb-0"><i class="fas fa-history me-2"></i>Order Status History</h2>
                        </div>
                        <div class="card-body">
                            <div class="timeline">
                                <% for (int i = 0; i < orderStates.size(); i++) {
                                    OrderState state = orderStates.get(i);
                                    String timelineClass = i % 2 == 0 ? "left" : "right";
                                %>
                                <div class="timeline-item <%= timelineClass %>">
                                    <div class="timeline-content">
                                        <h4><%= state.getStatus() %></h4>
                                        <p>Status ID: <%= state.getStatus_ID() %></p>
                                    </div>
                                </div>
                                <% } %>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Add Feedback Button -->
            <div class="text-center mt-4">
                <a href="insertFeedback.jsp?pizzaID=<%= order.getPizzaID()%>&cus_ID=<%= order.getCustomerID()%>" class="btn btn-custom">
                    <i class="fas fa-comment-alt me-2"></i>Add Feedback
                </a>
            </div>

            <%
            } else {
            %>
            <div class="alert alert-warning" role="alert">
                <i class="fas fa-exclamation-triangle me-2"></i>Order not found. Please check the order ID and try again.
            </div>
            <%
                    }
                }
            %>

            <div class="text-center mt-4">
                <a href="index.jsp" class="btn btn-custom">
                    <i class="fas fa-home me-2"></i>Back to Home
                </a>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>

