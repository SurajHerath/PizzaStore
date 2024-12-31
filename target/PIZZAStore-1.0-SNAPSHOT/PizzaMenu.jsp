<%-- 
    Document   : PizzaMenu
    Created on : Dec 19, 2024, 4:46:11 PM
    Author     : suraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Pizza"%>
<%@page import="java.util.List"%>
<%@ page import="java.util.List, java.util.Map, java.util.Set, java.util.HashMap" %>

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
        
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Pizza Menu - Pizza Store</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
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

            /* Main Content Styles */
            .main {
                padding: 40px 0;
            }

            h1 {
                color: #ffd700;
                text-align: center;
                font-size: 2.5em;
                margin-bottom: 30px;
                text-shadow: 2px 2px 4px rgba(0,0,0,0.5);
            }

            .page-content {
                background-color: rgba(18, 18, 18, 0.8);
                border-radius: 15px;
                padding: 30px;
                margin-top: 30px;
                box-shadow: 0 0 20px rgba(255, 255, 255, 0.1);
            }

            /* Search Form Styles */
            #searchForm {
                margin-bottom: 30px;
            }

            #searchInput {
                background-color: rgba(255, 255, 255, 0.1);
                border: none;
                color: #ffffff;
                padding: 10px 15px;
                border-radius: 5px 0 0 5px;
            }

            #searchForm .btn-primary {
                background-color: #ffd700;
                color: #121212;
                border: none;
                padding: 10px 20px;
                border-radius: 0 5px 5px 0;
                font-weight: bold;
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

            /* Button Styles */
            .btn-custom {
                margin: 2px;
                padding: 5px 10px;
                font-size: 0.9em;
                border-radius: 5px;
                transition: all 0.3s ease;
            }

            .btn-warning {
                background-color: #ffc107;
                border-color: #ffc107;
                color: #000;
            }

            .btn-danger {
                background-color: #dc3545;
                border-color: #dc3545;
            }

            .btn-info {
                background-color: #17a2b8;
                border-color: #17a2b8;
            }

            .btn-custom:hover {
                transform: translateY(-2px);
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            }

            /* Footer Styles */
            .footer {
                background-color: rgba(18, 18, 18, 0.9);
                color: #ffffff;
                padding: 20px 0;
                margin-top: 40px;
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

        <!-- END nav -->
        <main class="main">
            <div class="container">
                <h1><i class="fas fa-pizza-slice mr-3"></i>Pizza Menu</h1>

                <div class="page-content">
                    <form id="searchForm" method="GET" action="PizzaController">
                        <input type="hidden" name="action" value="search" />
                        <div class="input-group mb-4">
                            <input type="text" id="searchInput" name="query" class="form-control" placeholder="Search by Pizza Name or ID" autocomplete="off" required>
                            <button type="submit" class="btn btn-primary"><i class="fas fa-search mr-2"></i>Search</button>
                        </div>
                    </form>

                    <div class="table-responsive">
                        <table id="tblPizza" class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Pizza ID</th>
                                    <th>Pizza Name</th>
                                    <th>Crust</th>
                                    <th>Sauce</th>
                                    <th>Cheese</th>
                                    <th>Price</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    // Fetch pizzas to display
                                    List<Pizza> searchResults = (List<Pizza>) request.getAttribute("searchResults");
                                    List<Pizza> pizzasToDisplay = (searchResults != null && !searchResults.isEmpty()) ? searchResults : (List<Pizza>) request.getAttribute("pizzas");

                                    if (pizzasToDisplay != null && !pizzasToDisplay.isEmpty()) {
                                        for (Pizza pizza : pizzasToDisplay) {
                                %>
                                <tr>
                                    <td><%= pizza.getPizza_ID()%></td>
                                    <td><%= pizza.getPizza_Name()%></td>
                                    <td><%= pizza.getCrust()%></td>
                                    <td><%= pizza.getSauce()%></td>
                                    <td><%= pizza.getCheese()%></td>
                                    <td>$<%= String.format("%.2f", pizza.getPrice())%></td>
                                    <td>
                                        <a href="PizzaController?action=edit&pizza_ID=<%= pizza.getPizza_ID()%>" class="btn btn-warning btn-custom"><i class="fas fa-edit"></i> Edit</a>
                                        <a href="PizzaController?action=order&pizza_ID=<%= pizza.getPizza_ID()%>" class="btn btn-success btn-custom"><i class="fas fa-shopping-cart"></i> Order</a>
                                        <a href="PizzaController?action=delete&pizza_ID=<%= pizza.getPizza_ID()%>" class="btn btn-danger btn-custom" onclick="return confirm('Are you sure you want to delete this pizza?');"><i class="fas fa-trash-alt"></i> Delete</a>
                                        <a href="insertFavoritePizza.jsp?pizza_ID=<%= pizza.getPizza_ID()%>" class="btn btn-info btn-custom"><i class="fas fa-heart"></i> Favorite</a>
                                    </td>
                                </tr>
                                <%
                                    }
                                } else {
                                %>
                                <tr>
                                    <td colspan="7" class="text-center">No pizzas found.</td>
                                </tr>
                                <%
                                    }
                                %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </main>

       

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>

