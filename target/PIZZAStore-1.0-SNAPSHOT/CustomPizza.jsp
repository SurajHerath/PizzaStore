<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="service.*" %>
<%@ page import="model.*" %>
<%@ page import="java.util.List" %>

<%
    CrustService crustService = new CrustService();
    SauceService sauceService = new SauceService();
    CheeseService cheeseService = new CheeseService();
    ToppingService toppingService = new ToppingService();

    List<Crust> crusts = crustService.getAllCrusts();
    List<Sauce> sauces = sauceService.getAllSauces();
    List<Cheese> cheeses = cheeseService.getAllCheeses();
    List<Topping> toppings = toppingService.getAllToppings();

    request.setAttribute("crusts", crusts);
    request.setAttribute("sauces", sauces);
    request.setAttribute("cheeses", cheeses);
    request.setAttribute("toppings", toppings);
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
    <title>Pizza Customization - Pizza Store</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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
        h1 {
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
        .btn-primary {
            background-color: #4CAF50;
            border: none;
            padding: 12px 20px;
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

        /* Multiple Select Styles */
        select[multiple] {
            height: auto;
            min-height: 100px;
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

    <!-- Main Content -->
    <div class="container">
        <h1><i class="fas fa-pizza-slice mr-3"></i>Create Your Custom Pizza</h1>

        <form action="CustomPizzaController" method="POST">
            <input type="hidden" name="action" value="insert">

            <div class="form-group">
                <label for="customPizzaName">Pizza Name:</label>
                <input type="text" id="customPizzaName" name="customPizzaName" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="crustID">Choose Crust:</label>
                <select id="crustID" name="crustID" class="form-control" required>
                    <option value="">Select Crust</option>
                    <% if (crusts != null && !crusts.isEmpty()) {
                        for (Crust crust : crusts) { %>
                            <option value="<%= crust.getCrustID() %>" data-price="<%= crust.getCrustPrice() %>">
                                <%= crust.getCrustName() %> - $<%= String.format("%.2f", crust.getCrustPrice()) %>
                            </option>
                        <% }
                    } else { %>
                        <option value="">No crusts available</option>
                    <% } %>
                </select>
            </div>

            <div class="form-group">
                <label for="sauceID">Choose Sauce:</label>
                <select id="sauceID" name="sauceID" class="form-control" required>
                    <option value="">Select Sauce</option>
                    <% if (sauces != null && !sauces.isEmpty()) {
                        for (Sauce sauce : sauces) { %>
                            <option value="<%= sauce.getSauceID() %>" data-price="<%= sauce.getSaucePrice() %>">
                                <%= sauce.getSauceName() %> - $<%= String.format("%.2f", sauce.getSaucePrice()) %>
                            </option>
                        <% }
                    } else { %>
                        <option value="">No sauces available</option>
                    <% } %>
                </select>
            </div>

            <div class="form-group">
                <label for="cheeseID">Choose Cheese:</label>
                <select id="cheeseID" name="cheeseID" class="form-control" required>
                    <option value="">Select Cheese</option>
                    <% if (cheeses != null && !cheeses.isEmpty()) {
                        for (Cheese cheese : cheeses) { %>
                            <option value="<%= cheese.getCheeseID() %>" data-price="<%= cheese.getCheesePrice() %>">
                                <%= cheese.getCheeseName() %> - $<%= String.format("%.2f", cheese.getCheesePrice()) %>
                            </option>
                        <% }
                    } else { %>
                        <option value="">No cheeses available</option>
                    <% } %>
                </select>
            </div>

            <div class="form-group">
                <label for="toppingIDs">Choose Toppings:</label>
                <select id="toppingIDs" name="toppingIDs" class="form-control" multiple>
                    <option value="">Select Toppings</option>
                    <% if (toppings != null && !toppings.isEmpty()) {
                        for (Topping topping : toppings) { %>
                            <option value="<%= topping.getToppingID() %>" data-price="<%= topping.getToppingPrice() %>">
                                <%= topping.getToppingName() %> - $<%= String.format("%.2f", topping.getToppingPrice()) %>
                            </option>
                        <% }
                    } else { %>
                        <option value="">No toppings available</option>
                    <% } %>
                </select>
            </div>

            <div class="form-group">
                <label for="totalPrice">Total Price:</label>
                <input type="text" id="totalPrice" name="totalPrice" class="form-control" readonly>
            </div>

            <button type="submit" class="btn btn-primary w-100">
                <i class="fas fa-plus-circle mr-2"></i>Create Pizza
            </button>
        </form>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

    <script>
        $(document).ready(function () {
            function calculateTotalPrice() {
                let totalPrice = 0;

                // Add crust price
                totalPrice += parseFloat($("#crustID option:selected").data("price")) || 0;

                // Add sauce price
                totalPrice += parseFloat($("#sauceID option:selected").data("price")) || 0;

                // Add cheese price
                totalPrice += parseFloat($("#cheeseID option:selected").data("price")) || 0;

                // Add toppings price
                $("#toppingIDs option:selected").each(function () {
                    totalPrice += parseFloat($(this).data("price")) || 0;
                });

                // Display total price
                $("#totalPrice").val(totalPrice.toFixed(2));
            }

            $("#crustID, #sauceID, #cheeseID, #toppingIDs").on("change", calculateTotalPrice);
            calculateTotalPrice();

            $('form').on('submit', function(e) {
                e.preventDefault();
                var selectedToppings = $('#toppingIDs').val();
                $('<input>').attr({
                    type: 'hidden',
                    name: 'toppingIDs',
                    value: selectedToppings ? selectedToppings.join(',') : ''
                }).appendTo('form');
                this.submit();
            });
        });
    </script>
</body>
</html>

