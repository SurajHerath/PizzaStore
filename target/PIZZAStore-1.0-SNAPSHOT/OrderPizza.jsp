<%-- 
    Document   : OrderPizza
    Created on : Dec 23, 2024, 10:13:40 AM
    Author     : Suraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Pizza" %>
<%@ page import="model.ExtraTopping" %>
<%@ page import="model.Customer" %>
<%@ page import="service.PizzaService" %>
<%@ page import="service.ExtraToppingService" %>
<%@ page import="service.CustomerService" %>

<%
    PizzaService pizzaService = new PizzaService();
    ExtraToppingService toppingService = new ExtraToppingService();
    CustomerService customerService = new CustomerService();

    List<Pizza> pizzas = pizzaService.getAllPizzas();
    List<ExtraTopping> toppings = toppingService.getAllExtraToppings();
    List<Customer> customers = customerService.getAllCustomers();
%>

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
        <title>Order Pizza - Pizza Store</title>
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
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

            /* Container Styles */
            .container {
                max-width: 800px;
                margin: 20px auto;
            }

            /* Order Form Styles */
            .order-form {
                background-color: rgba(44, 44, 44, 0.9);
                padding: 30px;
                border-radius: 15px;
                box-shadow: 0 0 20px rgba(255,255,255,0.1);
            }

            /* Header Styles */
            h2 {
                color: #ffd700;
                text-align: center;
                font-size: 2.5em;
                margin-bottom: 30px;
                text-shadow: 2px 2px 4px rgba(0,0,0,0.5);
            }

            /* Form Group Styles */
            .form-group {
                margin-bottom: 1.5rem;
            }

            /* Label Styles */
            label {
                color: #ffd700;
                font-weight: bold;
                margin-bottom: 0.5rem;
                display: block;
            }

            /* Input and Select Styles */
            .form-control {
                background-color: rgba(255, 255, 255, 0.1);
                border: none;
                color: #ffffff;
                padding: 10px 15px;
                border-radius: 5px;
            }

            .form-control:focus {
                background-color: rgba(255, 255, 255, 0.2);
                box-shadow: 0 0 0 0.2rem rgba(255, 215, 0, 0.25);
            }

            /* Button Styles */
            .btn-success {
                background-color: #4CAF50;
                border: none;
                padding: 12px 20px;
                font-weight: bold;
                text-transform: uppercase;
                letter-spacing: 1px;
                transition: all 0.3s ease;
            }

            .btn-success:hover {
                background-color: #45a049;
                box-shadow: 0 0 15px rgba(76, 175, 80, 0.5);
                transform: translateY(-2px);
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
        </style>
    </head>
    <body>
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

        <!-- Main Content -->
        <main>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-8">
                        <div class="order-form">
                            <h2><i class="fas fa-pizza-slice mr-3"></i>Order Your Pizza</h2>
                            <form id="orderForm" action="OrderController?action=insertAndPay" method="post">
                                <input type="hidden" name="action" value="insertOrder">

                                <div class="form-group">
                                    <label for="orderID">Order ID:</label>
                                    <input type="text" class="form-control" id="orderID" name="orderID" required>
                                </div>

                                <div class="form-group">
                                    <label for="customerID">Customer:</label>
                                    <select class="form-control" id="customerID" name="customerID" required>
                                        <option value="">Select Customer</option>
                                        <% if (customers != null) {
                                                for (Customer c : customers) {%>
                                        <option value="<%= c.getCus_ID()%>">
                                            <%= c.getCus_Name()%> (ID: <%= c.getCus_ID()%>)
                                        </option>
                                        <% }
                                            } %>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="pizzaID">Pizza:</label>
                                    <select class="form-control" id="pizzaID" name="pizzaID" required onchange="updatePrice()">
                                        <option value="">Select Pizza</option>
                                        <% if (pizzas != null) {
                                                for (Pizza p : pizzas) {%>
                                        <option value="<%= p.getPizza_ID()%>" data-price="<%= p.getPrice()%>">
                                            <%= p.getPizza_Name()%> - $<%= String.format("%.2f", p.getPrice())%>
                                        </option>
                                        <% }
                                            } %>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="extraToppingID">Extra Topping:</label>
                                    <select class="form-control" id="extraToppingID" name="extraToppingID" required onchange="updatePrice()">
                                        <option value="">Select Topping</option>
                                        <% if (toppings != null) {
                                                for (ExtraTopping t : toppings) {%>
                                        <option value="<%= t.getExtraTopping_ID()%>" data-price="<%= t.gettopping_Price()%>">
                                            <%= t.getExtraTopping_Name()%> - $<%= String.format("%.2f", t.gettopping_Price())%>
                                        </option>
                                        <% }
                                            }%>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="orderType">Order Type:</label>
                                    <select class="form-control" id="orderType" name="orderType" required onchange="toggleDeliveryAddress()">
                                        <option value="Delivery">Delivery</option>
                                        <option value="Pickup">Pickup</option>
                                    </select>
                                </div>

                                <div class="form-group" id="deliveryAddressGroup">
                                    <label for="deliveryAddress">Delivery Address:</label>
                                    <input type="text" class="form-control" id="deliveryAddress" name="deliveryAddress">
                                </div>

                                <div class="form-group">
                                    <label for="totalPrice">Total Price:</label>
                                    <input type="text" class="form-control" id="totalPriceDisplay" readonly>
                                    <input type="hidden" id="totalPrice" name="totalPrice" value="0">
                                </div>

                                <button type="submit" class="btn btn-success w-100">
                                    <i class="fas fa-shopping-cart mr-2"></i>Place Order and Proceed to Payment
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

        <script>
            function updatePrice() {
                var pizzaSelect = document.getElementById("pizzaID");
                var toppingSelect = document.getElementById("extraToppingID");
                var totalPrice = 0;

                // Get pizza price
                if (pizzaSelect.selectedIndex > 0) {
                    var pizzaPrice = parseFloat(pizzaSelect.options[pizzaSelect.selectedIndex].getAttribute("data-price")) || 0;
                    totalPrice += pizzaPrice;
                }

                // Get topping price
                if (toppingSelect.selectedIndex > 0) {
                    var toppingPrice = parseFloat(toppingSelect.options[toppingSelect.selectedIndex].getAttribute("data-price")) || 0;
                    totalPrice += toppingPrice;
                }

                // Update both display and hidden price fields
                document.getElementById("totalPriceDisplay").value = "$" + totalPrice.toFixed(2);
                document.getElementById("totalPrice").value = totalPrice.toFixed(2);
            }

            function toggleDeliveryAddress() {
                var orderType = document.getElementById("orderType").value;
                var deliveryAddressGroup = document.getElementById("deliveryAddressGroup");
                var deliveryAddressInput = document.getElementById("deliveryAddress");

                if (orderType === "Pickup") {
                    deliveryAddressGroup.style.display = "none";
                    deliveryAddressInput.required = false;
                    deliveryAddressInput.value = "";
                } else {
                    deliveryAddressGroup.style.display = "block";
                    deliveryAddressInput.required = true;
                }
            }

            // Form validation before submit
            document.getElementById("orderForm").onsubmit = function (e) {
                var customerID = document.getElementById("customerID").value;
                var pizzaID = document.getElementById("pizzaID").value;
                var extraToppingID = document.getElementById("extraToppingID").value;
                var orderID = document.getElementById("orderID").value;
                var orderType = document.getElementById("orderType").value;
                var deliveryAddress = document.getElementById("deliveryAddress").value;
                var totalPrice = document.getElementById("totalPrice").value;

                if (!customerID || !pizzaID || !extraToppingID || !orderID || !orderType || (orderType === "Delivery" && !deliveryAddress) || !totalPrice) {
                    alert("Please fill in all required fields");
                    e.preventDefault();
                    return false;
                }
                return true;
            };

            // Initialize price and delivery address visibility on page load
            document.addEventListener('DOMContentLoaded', function () {
                updatePrice();
                toggleDeliveryAddress();
            });

            function goToPayment() {
                var orderID = document.getElementById("orderID").value;
                var customerID = document.getElementById("customerID").value;
                var pizzaID = document.getElementById("pizzaID").value;
                var extraToppingID = document.getElementById("extraToppingID").value;
                var orderType = document.getElementById("orderType").value;
                var deliveryAddress = document.getElementById("deliveryAddress").value;
                var totalPrice = document.getElementById("totalPrice").value;

                if (!orderID || !customerID || !pizzaID || !extraToppingID || !orderType || (orderType === "Delivery" && !deliveryAddress) || !totalPrice) {
                    alert("Please fill in all required fields before proceeding to payment.");
                    return;
                }

                var paymentUrl = "payment.jsp?" +
                        "orderID=" + encodeURIComponent(orderID) +
                        "&customerID=" + encodeURIComponent(customerID) +
                        "&pizzaID=" + encodeURIComponent(pizzaID) +
                        "&extraToppingID=" + encodeURIComponent(extraToppingID) +
                        "&orderType=" + encodeURIComponent(orderType) +
                        "&deliveryAddress=" + encodeURIComponent(deliveryAddress) +
                        "&totalPrice=" + encodeURIComponent(totalPrice);

                window.location.href = paymentUrl;
            }
        </script>
    </body>
</html>