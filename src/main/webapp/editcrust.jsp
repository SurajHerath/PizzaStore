<%-- 
    Document   : editcrust
    Created on : Dec 24, 2024, 4:21:21 PM
    Author     : suraj
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<<!DOCTYPE html>
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
                    <a href="adminindex.jsp" class="nav-link">Home</a>
                </li>
                <li class="nav-item">
                    <a href="CustomerController?action=list" class="nav-link">View All Customers</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="extraToppingDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Extra Topping
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="extraToppingDropdown">
                        <li><a class="dropdown-item" href="InsertExtraTopping.jsp">Insert Extra Topping</a></li>
                        <li><a class="dropdown-item" href="ExtraToppingController?action=list">View All Extra Topping</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pizzaDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Pizza
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="pizzaDropdown">
                        <li><a class="dropdown-item" href="InsertPizza.jsp">Insert Pizza</a></li>
                        <li><a class="dropdown-item" href="PizzaController?action=list">View All Pizza</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="orderDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Order
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="orderDropdown">
                        <li><a class="dropdown-item" href="OrderController?action=viewall">View All Orders</a></li>
                        <li><a class="dropdown-item" href="OrderStatesController?action=viewall">View All Order States</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="layerDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Layer
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="layerDropdown">
                        <li><a class="dropdown-item" href="insertCrust.jsp">Insert Crust</a></li>
                        <li><a class="dropdown-item" href="CrustController?action=view">View All Crust</a></li>
                        <li><a class="dropdown-item" href="insertSauce.jsp">Insert Sauce</a></li>
                        <li><a class="dropdown-item" href="SauceController?action=viewAll">View All Sauce</a></li>
                        <li><a class="dropdown-item" href="insertcheese.jsp">Insert Cheese</a></li>
                        <li><a class="dropdown-item" href="CheeseController?action=viewAll">View All Cheese</a></li>
                        <li><a class="dropdown-item" href="insertTopping.jsp">Insert Topping</a></li>
                        <li><a class="dropdown-item" href="ToppingController?action=viewAll">View All Topping</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>


    <!-- Main Content -->
    <div class="container">
        <h2><i class="fas fa-cheese mr-3"></i>Edit Crust</h2>
        
    <form action="CrustController" method="post">
        <input type="hidden" name="action" value="update" />
        <input type="hidden" name="crustID" value="${crust.crustID}" />
        
        <label for="crustName">Crust Name:</label>
        <input type="text" class="form-control" id="crustName" name="crustName" value="${crust.crustName}" required />
        <br><br>
        
        <label for="crustPrice">Crust Price:</label>
        <input type="number" class="form-control"id="crustPrice" name="crustPrice" value="${crust.crustPrice}" step="0.01" required />
        <br><br>
        
        <button type="submit" class="btn btn-primary"><i class="fas fa- mr-2"></i>Edit Crust</button>
        
    </form>

    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>

