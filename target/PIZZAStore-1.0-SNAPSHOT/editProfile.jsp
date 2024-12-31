<%-- 
    Document   : editProfile
    Created on : Dec 26, 2024, 1:55:53 PM
    Author     : suraj
--%>

<%@page import="model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page session="true" %>
<%
    Customer customer = (Customer) session.getAttribute("loggedInCustomer");
    if (customer == null) {
        response.sendRedirect("login.jsp");
        return;
    }
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
    <title>Edit Profile - Pizza Store</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
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
        .main-content {
            padding: 50px 0;
        }

        .profile-container {
            background-color: rgba(18, 18, 18, 0.8);
            border-radius: 15px;
            padding: 30px;
            max-width: 500px;
            margin: 0 auto;
            box-shadow: 0 0 20px rgba(255, 255, 255, 0.1);
        }

        h1 {
            color: #ffd700;
            text-align: center;
            font-size: 2.5em;
            margin-bottom: 30px;
            text-shadow: 2px 2px 4px rgba(0,0,0,0.5);
        }

        /* Form Styles */
        .form-group {
            margin-bottom: 20px;
        }

        label {
            color: #ffd700;
            display: block;
            margin-bottom: 5px;
        }

        .form-control {
            background-color: rgba(255, 255, 255, 0.1);
            border: none;
            border-radius: 5px;
            color: #ffffff;
            padding: 10px;
        }

        .form-control:focus {
            background-color: rgba(255, 255, 255, 0.2);
            box-shadow: 0 0 0 0.2rem rgba(255, 215, 0, 0.25);
        }

        .btn-save {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            transition-duration: 0.4s;
            cursor: pointer;
            border-radius: 5px;
        }

        .btn-save:hover {
            background-color: #45a049;
            color: white;
        }

        /* Footer Styles */
        .footer {
            background-color: rgba(18, 18, 18, 0.9);
            color: #ffffff;
            text-align: center;
            padding: 10px 0;
            position: absolute;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container">
            <a class="navbar-brand" href="#"><i class="fas fa-pizza-slice mr-2"></i>Pizza Store</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Menu</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Orders</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Profile</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Main Content -->
    <div class="main-content">
        <div class="container">
            <div class="profile-container">
                <h1><i class="fas fa-user-edit mr-2"></i>Edit Your Profile</h1>
                <form action="UpdateProfileController" method="post">
                    <input type="hidden" name="customerId" value="<%= customer.getCus_ID() %>" />
                    <div class="form-group">
                        <label for="name"><i class="fas fa-user mr-2"></i>Name:</label>
                        <input type="text" id="name" name="name" value="<%= customer.getCus_Name() %>" class="form-control" required />
                    </div>
                    <div class="form-group">
                        <label for="email"><i class="fas fa-envelope mr-2"></i>Email:</label>
                        <input type="email" id="email" name="email" value="<%= customer.getCus_Email() %>" class="form-control" readonly />
                    </div>
                    <div class="form-group">
                        <label for="phone"><i class="fas fa-phone mr-2"></i>Phone:</label>
                        <input type="text" id="phone" name="phone" value="<%= customer.getCus_Phone() %>" class="form-control" required />
                    </div>
                    
                    <button type="submit" class="btn-save"><i class="fas fa-save mr-2"></i>Save Changes</button>
                </form>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <footer class="footer">
        <div class="container">
            <p>&copy; 2024 Pizza Store. All rights reserved.</p>
        </div>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

