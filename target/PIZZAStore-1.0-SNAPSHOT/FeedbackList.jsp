<%-- 
    Document   : FeedbackList
    Created on : Dec 25, 2024, 11:03:29 PM
    Author     : suraj
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>All Cheeses - Pizza Store</title>
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
            max-width: 1000px;
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

        /* Button Styles */
        .btn-add {
            background-color: #4CAF50;
            color: white;
            padding: 12px 24px;
            text-decoration: none;
            border-radius: 50px;
            display: inline-block;
            margin-bottom: 30px;
            transition: all 0.3s ease;
            font-weight: bold;
            text-transform: uppercase;
            letter-spacing: 1px;
        }
        .btn-add:hover {
            background-color: #45a049;
            box-shadow: 0 0 15px rgba(76, 175, 80, 0.5);
            transform: translateY(-2px);
        }

        /* Table Styles */
        .table {
            width: 100%;
            border-collapse: separate;
            border-spacing: 0 10px;
            color: #ffffff;
        }
        .table th {
            background-color: #ffd700;
            color: #121212;
            padding: 15px;
            text-align: left;
            text-transform: uppercase;
            letter-spacing: 1px;
            font-weight: bold;
        }
        .table td {
            padding: 15px;
            background-color: rgba(255, 255, 255, 0.1);
            border: none;
            transition: all 0.3s ease;
        }
        .table tr:hover td {
            background-color: rgba(255, 255, 255, 0.2);
            transform: scale(1.02);
        }

        /* Action Button Styles */
        .btn-edit, .btn-delete {
            padding: 8px 15px;
            text-decoration: none;
            border-radius: 20px;
            margin-right: 5px;
            transition: all 0.3s ease;
            font-weight: bold;
        }
        .btn-edit {
            background-color: #FFA500;
            color: black;
        }
        .btn-delete {
            background-color: #f44336;
            color: white;
        }
        .btn-edit:hover, .btn-delete:hover {
            opacity: 0.8;
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

    <!-- Main Content -->
    <div class="container">
        <h2><i class="fas fa-cheese mr-3"></i>Feedbacks</h2>
       
        <table class="table">
        <thead>
            <tr>
                <th>Feedback ID</th>
                <th>Customer ID</th>
                <th>Pizza ID</th>
                <th>Comment</th>
                <th>Rating</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="feedback" items="${feedbackList}">
                <tr>
                    <td>${feedback.feedback_ID}</td>
                    <td>${feedback.cus_ID}</td>
                    <td>${feedback.pizza_ID}</td>
                    <td>${feedback.comment}</td>
                    <td>${feedback.rating}</td>
                    <td>
                        <a href="FeedbackController?action=edit&feedback_ID=${feedback.feedback_ID}" class="btn btn-warning btn-sm">Edit</a>
                        <a href="FeedbackController?action=delete&feedback_ID=${feedback.feedback_ID}" class="btn btn-danger btn-sm"
                           onclick="return confirm('Are you sure you want to delete this feedback?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
</div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>


