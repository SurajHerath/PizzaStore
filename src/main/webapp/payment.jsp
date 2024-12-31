<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.text.NumberFormat"%>
<%@ page import="java.util.Locale"%>
<%@ page import="model.Customer"%>
<%@ page import="model.Order"%>
<%@ page import="model.Promotion"%>
<%@ page import="service.CustomerService"%>
<%@ page import="service.OrderService"%>
<%@ page import="service.PromotionService"%>
<%@ page import="java.net.URLEncoder"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Pizza Store - Payment</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Font imports -->
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Nothing+You+Could+Do" rel="stylesheet">

    <!-- CSS imports -->
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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    
    <!-- Custom CSS -->
    <style>
        body {
            background-color: #121212;
            color: #ffffff;
            font-family: 'Poppins', sans-serif;
            background-image: url('https://images.unsplash.com/photo-1513104890138-7c749659a591?ixlib=rb-1.2.1&auto=format&fit=crop&w=1950&q=80');
            background-size: cover;
            background-attachment: fixed;
            background-position: center;
        }
        .container {
            background-color: rgba(18, 18, 18, 0.8);
            border-radius: 15px;
            padding: 30px;
            margin-top: 50px;
            box-shadow: 0 0 20px rgba(255, 255, 255, 0.1);
        }
        h1 {
            color: #ffd700;
            text-align: center;
            margin-bottom: 30px;
            font-family: 'Josefin Sans', sans-serif;
            text-shadow: 2px 2px 4px rgba(0,0,0,0.5);
        }
        .form-label {
            color: #ffd700;
        }
        .form-control {
            background-color: rgba(255, 255, 255, 0.1);
            border: none;
            color: #ffffff;
        }
        .form-control:focus {
            background-color: rgba(255, 255, 255, 0.2);
            color: #ffffff;
            box-shadow: none;
        }
        .btn-success {
            background-color: #ffd700;
            border: none;
            color: #121212;
            font-weight: bold;
        }
        .btn-success:hover {
            background-color: #ffed4a;
            color: #121212;
        }
        .btn-primary {
            background-color: #4a69ff;
            border: none;
        }
        .btn-primary:hover {
            background-color: #6c8cff;
        }
        .btn-secondary {
            background-color: #6c757d;
            border: none;
        }
        .btn-secondary:hover {
            background-color: #7e868e;
        }
        /* Navbar styles */
        .navbar {
            background-color: rgba(18, 18, 18, 0.9) !important;
        }
        .navbar-brand {
            color: #ffd700 !important;
            font-family: 'Nothing You Could Do', cursive;
            font-size: 1.5rem;
        }
        .nav-link {
            color: #ffffff !important;
            font-family: 'Poppins', sans-serif;
        }
        .nav-link:hover {
            color: #ffd700 !important;
        }
    </style>
</head>
<body>
    <!-- Navbar Section -->
    <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
        <div class="container">
            <a class="navbar-brand" href="index.jsp"><span class="flaticon-pizza-1 mr-1"></span>Pizza<br><small>Store</small></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="oi oi-menu"></span> Menu
            </button>
            <div class="collapse navbar-collapse" id="ftco-nav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item"><a href="index.jsp" class="nav-link">Home</a></li>
                    <li class="nav-item"><a href="menu.jsp" class="nav-link">Menu</a></li>
                    <li class="nav-item"><a href="services.jsp" class="nav-link">Services</a></li>
                    <li class="nav-item active"><a href="orderpizza.jsp" class="nav-link">Order</a></li>
                    <li class="nav-item"><a href="about.jsp" class="nav-link">About</a></li>
                    <li class="nav-item"><a href="contact.jsp" class="nav-link">Contact</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- END nav -->

    <!-- Main Content Section -->
    <div class="container mt-5">
        <h1 class="text-center">Complete Your Payment</h1>
        <% 
            String orderID = request.getParameter("orderID");
            String customerID = request.getParameter("customerID");
            String pizzaID = request.getParameter("pizzaID");
            String extraToppingID = request.getParameter("extraToppingID");
            String orderType = request.getParameter("orderType");
            String deliveryAddress = request.getParameter("deliveryAddress");
            String totalPriceStr = request.getParameter("totalPrice");

            if (orderID == null || orderID.isEmpty() || totalPriceStr == null || totalPriceStr.isEmpty()) {
                response.sendRedirect("error.jsp?message=" + URLEncoder.encode("Invalid Order Information", "UTF-8"));
                return;
            }

            double totalPrice = Double.parseDouble(totalPriceStr);

            CustomerService customerService = new CustomerService();
            Customer customer = customerService.getCustomerById(customerID);
            
            if (customer == null) {
                System.err.println("Customer not found for ID: " + customerID);
                response.sendRedirect("error.jsp?message=" + URLEncoder.encode("Customer not found for ID: " + customerID, "UTF-8"));
                return;
            }

            int loyaltyPoints = customer.getLoyaltyPoint();
            double loyaltyDiscountPercentage = Math.min(loyaltyPoints * 0.1, 50.0);
            double loyaltyDiscountAmount = totalPrice * (loyaltyDiscountPercentage / 100.0);
            
            PromotionService promotionService = new PromotionService();
            
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        %>
        <!-- Payment Form -->
        <form action="invoice.jsp" method="post">
            <input type="hidden" name="orderID" value="<%= orderID %>">
            <input type="hidden" name="customerID" value="<%= customerID %>">
            <input type="hidden" name="pizzaID" value="<%= pizzaID %>">
            <input type="hidden" name="extraToppingID" value="<%= extraToppingID %>">
            <input type="hidden" name="orderType" value="<%= orderType %>">
            <input type="hidden" name="deliveryAddress" value="<%= deliveryAddress %>">
            <input type="hidden" name="originalTotal" value="<%= totalPrice %>">
            
            <div class="mb-3">
                <label for="orderID" class="form-label">Order ID:</label>
                <input type="text" class="form-control" id="orderID" value="<%= orderID %>" readonly>
            </div>
            <div class="mb-3">
                <label for="customerName" class="form-label">Customer Name:</label>
                <input type="text" class="form-control" id="customerName" value="<%= customer.getCus_Name() %>" readonly>
            </div>
            <div class="mb-3">
                <label for="originalTotal" class="form-label">Original Total:</label>
                <input type="text" class="form-control" id="originalTotal" value="<%= currencyFormatter.format(totalPrice) %>" readonly>
            </div>
            <div class="mb-3">
                <label for="loyaltyPoints" class="form-label">Loyalty Points:</label>
                <input type="text" class="form-control" id="loyaltyPoints" value="<%= loyaltyPoints %>" readonly>
            </div>
            <div class="mb-3">
                <label for="loyaltyDiscount" class="form-label">Loyalty Discount:</label>
                <input type="text" class="form-control" id="loyaltyDiscount" value="<%= currencyFormatter.format(loyaltyDiscountAmount) %> (<%= String.format("%.1f%%", loyaltyDiscountPercentage) %>)" readonly>
            </div>
            <div class="mb-3">
                <label for="promoCode" class="form-label">Promo Code:</label>
                <input type="text" class="form-control" id="promoCode" name="promoCode">
                <button type="button" class="btn btn-secondary mt-2" onclick="applyPromoCode()">Apply Promo Code</button>
            </div>
            <div class="mb-3">
                <label for="finalTotal" class="form-label">Final Total:</label>
                <input type="text" class="form-control" id="finalTotal" name="finalTotal" value="<%= currencyFormatter.format(totalPrice - loyaltyDiscountAmount) %>" readonly>
            </div>
            <div class="mb-3">
                <label for="creditCardType" class="form-label">Credit Card Type:</label>
                <select class="form-control" id="creditCardType" name="creditCardType" required>
                    <option value="">Select Card Type</option>
                    <option value="visa">Visa</option>
                    <option value="mastercard">Mastercard</option>
                </select>
            </div>
            <button type="submit" class="btn btn-success btn-lg btn-block">Complete Payment</button>
        </form>
        <div class="text-center mt-4">
            <a href="orderpizza.jsp" class="btn btn-primary">Back to Order</a>
        </div>
    </div>

    <!-- JavaScript Section -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script>
       function applyPromoCode() {
    var promoCode = document.getElementById('promoCode').value;
    var originalTotal = <%= totalPrice %>;
    var loyaltyDiscount = <%= loyaltyDiscountAmount %>;

    // AJAX call to server to validate promo code and get discount
    fetch('ValidatePromoCodeServlet?promoCode=' + promoCode)
        .then(response => response.json())
        .then(data => {
            if (data.valid) {
                var promoDiscount = originalTotal * (data.discountPercentage / 100);
                var finalTotal = originalTotal - loyaltyDiscount - promoDiscount;
                document.getElementById('finalTotal').value = '$' + finalTotal.toFixed(2);
            } else {
                alert('Invalid promo code');
            }
        })
        .catch(error => console.error('Error:', error));
}

    </script>
</body>
</html>

