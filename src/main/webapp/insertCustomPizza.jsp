<%-- 
    Document   : insertCustomPizza
    Created on : Dec 24, 2024, 5:33:44 PM
    Author     : suraj
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Pizza" %>
<%@ page import="model.ExtraTopping" %>
<%@ page import="service.PizzaService" %>
<%@ page import="service.ExtraToppingService" %>
<%@ page import="service.OrderService" %>
<%@ page import="com.google.gson.Gson" %>

<%
    PizzaService pizzaService = new PizzaService();
    ExtraToppingService toppingService = new ExtraToppingService();
    OrderService orderService = new OrderService();

    List<Pizza> pizzas = pizzaService.getAllPizzas();
    List<ExtraTopping> toppings = toppingService.getAllExtraToppings();
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <title>Add New Cheese - Pizza Store</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
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

        /* Form Styles */
        .form-group label {
            color: #ffd700;
            font-weight: bold;
        }
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
        .btn-primary {
            background-color: #4CAF50;
            border: none;
            padding: 10px 20px;
            font-weight: bold;
            text-transform: uppercase;
            letter-spacing: 1px;
            transition: all 0.3s ease;
        }
        .btn-primary:hover {
            background-color: #45a049;
            box-shadow: 0 0 15px rgba(76, 175, 80, 0.5);
            transform: translateY(-2px);
        }
        .btn-secondary {
            background-color: #FFA500;
            border: none;
            color: #121212;
            padding: 10px 20px;
            font-weight: bold;
            text-transform: uppercase;
            letter-spacing: 1px;
            transition: all 0.3s ease;
        }
        .btn-secondary:hover {
            background-color: #FF8C00;
            box-shadow: 0 0 15px rgba(255, 165, 0, 0.5);
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
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container">
            <a class="navbar-brand" href="#"><i class="fas fa-pizza-slice mr-2"></i>Pizza Store</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Menu</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Cheeses</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Orders</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Contact</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Main Content -->
    <div class="container">
        <h2><i class="fas fa-cheese mr-3"></i>Create Your Custom Pizza</h2>
        
     
                            <form action="PizzaController?action=insertCustomPizza" method="post">
                                <div class="form-group">
                                    <label for="pizzaID">Pizza ID:</label>
                                    <input type="text" class="form-control" id="pizzaID" name="pizzaID" required>
                                </div>

                                <div class="form-group">
                                    <label for="pizzaType">Choose Pizza Type:</label>
                                    <select class="form-control" id="pizzaType" name="pizzaType" required onchange="updatePrice()">
                                        <option value="">Select Pizza</option>
                                        <% for (Pizza p : pizzas) { %>
                                        <option value="<%= p.getPizza_ID() %>" data-price="<%= p.getPrice() %>"><%= p.getPizza_Name() %> - $<%= p.getPrice() %></option>
                                        <% } %>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="size">Choose Size:</label>
                                    <select class="form-control" id="size" name="size" required onchange="updatePrice()">
                                        <option value="Small">Small</option>
                                        <option value="Medium">Medium</option>
                                        <option value="Large">Large</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="toppings1">Choose First Topping:</label>
                                    <select class="form-control" id="toppings1" name="toppings1" required onchange="updatePrice()">
                                        <option value="">Select First Topping</option>
                                        <% for (ExtraTopping t : toppings) { %>
                                        <option value="<%= t.getExtraTopping_ID() %>" data-price="<%= t.gettopping_Price() %>"><%= t.getExtraTopping_Name() %> - $<%= t.gettopping_Price() %></option>
                                        <% } %>
                                    </select>
                                </div>


                                <div class="form-group">
                                    <label for="totalPrice">Total Price:</label>
                                    <input type="text" class="form-control" id="totalPrice" name="totalPrice" readonly>
                                </div>

                                <div class="form-group">
                                    <label for="address">Delivery Address:</label>
                                    <input type="text" class="form-control" id="address" name="address" required>
                                </div>

                                <div class="form-group">
                                    <label for="status">Order Status:</label>
                                    <select class="form-control" id="status" name="status" required>
                                        <option value="Pending">Pending</option>
                                        <option value="Confirmed">Confirmed</option>
                                        <option value="Delivered">Delivered</option>
                                    </select>
                                </div>

                                <button type="submit" class="btn btn-primary btn-block">Place Order</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>

    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="js/main.js"></script>

    <script>
        function updatePrice() {
            var pizzaSelect = document.getElementById("pizzaType");
            var sizeSelect = document.getElementById("size");
            var toppings1Select = document.getElementById("toppings1");
            var toppings2Select = document.getElementById("toppings2");
            var totalPrice = 0;

            // Get base pizza price
            if (pizzaSelect.selectedIndex > 0) {
                var selectedPizzaPrice = parseFloat(pizzaSelect.options[pizzaSelect.selectedIndex].getAttribute("data-price"));
                totalPrice += selectedPizzaPrice;
            }

            // Apply size multiplier
            var sizeMultiplier = getSizeMultiplier(sizeSelect.value);
            totalPrice *= sizeMultiplier;

            // Add first topping price
            if (toppings1Select.selectedIndex > 0) {
                totalPrice += parseFloat(toppings1Select.options[toppings1Select.selectedIndex].getAttribute("data-price"));
            }

            // Add second topping price
            if (toppings2Select.selectedIndex > 0) {
                totalPrice += parseFloat(toppings2Select.options[toppings2Select.selectedIndex].getAttribute("data-price"));
            }

            document.getElementById("totalPrice").value = "$" + totalPrice.toFixed(2);
        }

        function getSizeMultiplier(size) {
            switch (size) {
                case "Small": return 1;
                case "Medium": return 1.5;
                case "Large": return 2;
                default: return 1;
            }
        }

        document.addEventListener('DOMContentLoaded', function () {
            updatePrice(); // Set initial price
        });
    </script>


    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>

