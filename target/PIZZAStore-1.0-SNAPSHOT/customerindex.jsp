<%-- 
    Document   : customerindex
    Created on : Dec 26, 2024, 6:52:06 AM
    Author     : suraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <li class="nav-item"><a href="FavoritePizzaController?action=viewByCusId"" class="nav-link">Favorite</a></li>
            </ul>
        </div>
    </div>
</nav>

        <!-- END nav -->

        <section class="home-slider owl-carousel img" style="background-image: url(images/bg_1.jpg);">
            <div class="slider-item">
                <div class="overlay"></div>
                <div class="container">
                    <div class="row slider-text align-items-center" data-scrollax-parent="true">

                        <div class="col-md-6 col-sm-12 ftco-animate">
                            <span class="subheading">Delicious</span>
                            <h1 class="mb-4">Italian Cuizine</h1>
                            <p class="mb-4 mb-md-5">A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                            <p><a href="#" class="btn btn-primary p-3 px-xl-4 py-xl-3">Order Now</a> <a href="PizzaController?action=list" class="btn btn-white btn-outline-white p-3 px-xl-4 py-xl-3">View Menu</a></p>
                        </div>
                        <div class="col-md-6 ftco-animate">
                            <img src="images/bg_1.png" class="img-fluid" alt="">
                        </div>

                    </div>
                </div>
            </div>

            <div class="slider-item">
                <div class="overlay"></div>
                <div class="container">
                    <div class="row slider-text align-items-center" data-scrollax-parent="true">

                        <div class="col-md-6 col-sm-12 order-md-last ftco-animate">
                            <span class="subheading">Crunchy</span>
                            <h1 class="mb-4">Italian Pizza</h1>
                            <p class="mb-4 mb-md-5">A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                            <p><a href="#" class="btn btn-primary p-3 px-xl-4 py-xl-3">Order Now</a> <a href="#" class="btn btn-white btn-outline-white p-3 px-xl-4 py-xl-3">View Menu</a></p>
                        </div>
                        <div class="col-md-6 ftco-animate">
                            <img src="images/bg_2.png" class="img-fluid" alt="">
                        </div>

                    </div>
                </div>
            </div>

            <div class="slider-item" style="background-image: url(images/bg_3.jpg);">
                <div class="overlay"></div>
                <div class="container">
                    <div class="row slider-text justify-content-center align-items-center" data-scrollax-parent="true">

                        <div class="col-md-7 col-sm-12 text-center ftco-animate">
                            <span class="subheading">Welcome</span>
                            <h1 class="mb-4">We cooked your desired Pizza Recipe</h1>
                            <p class="mb-4 mb-md-5">A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                            <p><a href="#" class="btn btn-primary p-3 px-xl-4 py-xl-3">Order Now</a> <a href="#" class="btn btn-white btn-outline-white p-3 px-xl-4 py-xl-3">View Menu</a></p>
                        </div>

                    </div>
                </div>
            </div>
        </section>

        <section class="ftco-intro">
            <div class="container-wrap">
                <div class="wrap d-md-flex">
                    <div class="info">
                        <div class="row no-gutters">
                            <div class="col-md-4 d-flex ftco-animate">
                                <div class="icon"><span class="icon-phone"></span></div>
                                <div class="text">
                                    <h3>000 (123) 456 7890</h3>
                                    <p>A small river named Duden flows</p>
                                </div>
                            </div>
                            <div class="col-md-4 d-flex ftco-animate">
                                <div class="icon"><span class="icon-my_location"></span></div>
                                <div class="text">
                                    <h3>198 West 21th Street</h3>
                                    <p>Suite 721 New York NY 10016</p>
                                </div>
                            </div>
                            <div class="col-md-4 d-flex ftco-animate">
                                <div class="icon"><span class="icon-clock-o"></span></div>
                                <div class="text">
                                    <h3>Open Monday-Friday</h3>
                                    <p>8:00am - 9:00pm</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="social d-md-flex pl-md-5 p-4 align-items-center">
                        <ul class="social-icon">
                            <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                            <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                            <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </section>

        <section class="ftco-about d-md-flex">
            <div class="one-half img" style="background-image: url(images/about.jpg);"></div>
            <div class="one-half ftco-animate">
                <div class="heading-section ftco-animate ">
                    <h2 class="mb-4">Welcome to <span class="flaticon-pizza">Pizza</span> A Restaurant</h2>
                </div>
                <div>
                    <p>On her way she met a copy. The copy warned the Little Blind Text, that where it came from it would have been rewritten a thousand times and everything that was left from its origin would be the word "and" and the Little Blind Text should turn around and return to its own, safe country. But nothing the copy said could convince her and so it didn’t take long until a few insidious Copy Writers ambushed her, made her drunk with Longe and Parole and dragged her into their agency, where they abused her for their.</p>
                </div>
            </div>
        </section>

        <section class="ftco-section ftco-services">
            <div class="overlay"></div>
            <div class="container">
                <div class="row justify-content-center mb-5 pb-3">
                    <div class="col-md-7 heading-section ftco-animate text-center">
                        <h2 class="mb-4">Our Services</h2>
                        <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 ftco-animate">
                        <div class="media d-block text-center block-6 services">
                            <div class="icon d-flex justify-content-center align-items-center mb-5">
                                <span class="flaticon-diet"></span>
                            </div>
                            <div class="media-body">
                                <h3 class="heading">Healthy Foods</h3>
                                <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
                            </div>
                        </div>      
                    </div>
                    <div class="col-md-4 ftco-animate">
                        <div class="media d-block text-center block-6 services">
                            <div class="icon d-flex justify-content-center align-items-center mb-5">
                                <span class="flaticon-bicycle"></span>
                            </div>
                            <div class="media-body">
                                <h3 class="heading">Fastest Delivery</h3>
                                <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
                            </div>
                        </div>      
                    </div>
                    <div class="col-md-4 ftco-animate">
                        <div class="media d-block text-center block-6 services">
                            <div class="icon d-flex justify-content-center align-items-center mb-5"><span class="flaticon-pizza-1"></span></div>
                            <div class="media-body">
                                <h3 class="heading">Original Recipes</h3>
                                <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
                            </div>
                        </div>    
                    </div>
                </div>
            </div>
        </section>

        

            <div class="container">
                <div class="row justify-content-center mb-5 pb-3 mt-5 pt-5">
                    <div class="col-md-7 heading-section text-center ftco-animate">
                        <h2 class="mb-4">Our Menu Pricing</h2>
                        <p class="flip"><span class="deg1"></span><span class="deg2"></span><span class="deg3"></span></p>
                        <p class="mt-5">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="pricing-entry d-flex ftco-animate">
                            <div class="img" style="background-image: url(images/pizza-1.jpg);"></div>
                            <div class="desc pl-3">
                                <div class="d-flex text align-items-center">
                                    <h3><span>Italian Pizza</span></h3>
                                    <span class="price">$20.00</span>
                                </div>
                                <div class="d-block">
                                    <p>A small river named Duden flows by their place and supplies</p>
                                </div>
                            </div>
                        </div>
                        <div class="pricing-entry d-flex ftco-animate">
                            <div class="img" style="background-image: url(images/pizza-2.jpg);"></div>
                            <div class="desc pl-3">
                                <div class="d-flex text align-items-center">
                                    <h3><span>Hawaiian Pizza</span></h3>
                                    <span class="price">$29.00</span>
                                </div>
                                <div class="d-block">
                                    <p>A small river named Duden flows by their place and supplies</p>
                                </div>
                            </div>
                        </div>
                        <div class="pricing-entry d-flex ftco-animate">
                            <div class="img" style="background-image: url(images/pizza-3.jpg);"></div>
                            <div class="desc pl-3">
                                <div class="d-flex text align-items-center">
                                    <h3><span>Greek Pizza</span></h3>
                                    <span class="price">$20.00</span>
                                </div>
                                <div class="d-block">
                                    <p>A small river named Duden flows by their place and supplies</p>
                                </div>
                            </div>
                        </div>
                        <div class="pricing-entry d-flex ftco-animate">
                            <div class="img" style="background-image: url(images/pizza-4.jpg);"></div>
                            <div class="desc pl-3">
                                <div class="d-flex text align-items-center">
                                    <h3><span>Bacon Crispy Thins</span></h3>
                                    <span class="price">$20.00</span>
                                </div>
                                <div class="d-block">
                                    <p>A small river named Duden flows by their place and supplies</p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="pricing-entry d-flex ftco-animate">
                            <div class="img" style="background-image: url(images/pizza-5.jpg);"></div>
                            <div class="desc pl-3">
                                <div class="d-flex text align-items-center">
                                    <h3><span>Hawaiian Special</span></h3>
                                    <span class="price">$49.91</span>
                                </div>
                                <div class="d-block">
                                    <p>A small river named Duden flows by their place and supplies</p>
                                </div>
                            </div>
                        </div>
                        <div class="pricing-entry d-flex ftco-animate">
                            <div class="img" style="background-image: url(images/pizza-6.jpg);"></div>
                            <div class="desc pl-3">
                                <div class="d-flex text align-items-center">
                                    <h3><span>Ultimate Overload</span></h3>
                                    <span class="price">$20.00</span>
                                </div>
                                <div class="d-block">
                                    <p>A small river named Duden flows by their place and supplies</p>
                                </div>
                            </div>
                        </div>
                        <div class="pricing-entry d-flex ftco-animate">
                            <div class="img" style="background-image: url(images/pizza-7.jpg);"></div>
                            <div class="desc pl-3">
                                <div class="d-flex text align-items-center">
                                    <h3><span>Bacon Pizza</span></h3>
                                    <span class="price">$20.00</span>
                                </div>
                                <div class="d-block">
                                    <p>A small river named Duden flows by their place and supplies</p>
                                </div>
                            </div>
                        </div>
                        <div class="pricing-entry d-flex ftco-animate">
                            <div class="img" style="background-image: url(images/pizza-8.jpg);"></div>
                            <div class="desc pl-3">
                                <div class="d-flex text align-items-center">
                                    <h3><span>Ham &amp; Pineapple</span></h3>
                                    <span class="price">$20.00</span>
                                </div>
                                <div class="d-block">
                                    <p>A small river named Duden flows by their place and supplies</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="ftco-gallery">
            <div class="container-wrap">
                <div class="row no-gutters">
                    <div class="col-md-3 ftco-animate">
                        <a href="#" class="gallery img d-flex align-items-center" style="background-image: url(images/gallery-1.jpg);">
                            <div class="icon mb-4 d-flex align-items-center justify-content-center">
                                <span class="icon-search"></span>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-3 ftco-animate">
                        <a href="#" class="gallery img d-flex align-items-center" style="background-image: url(images/gallery-2.jpg);">
                            <div class="icon mb-4 d-flex align-items-center justify-content-center">
                                <span class="icon-search"></span>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-3 ftco-animate">
                        <a href="#" class="gallery img d-flex align-items-center" style="background-image: url(images/gallery-3.jpg);">
                            <div class="icon mb-4 d-flex align-items-center justify-content-center">
                                <span class="icon-search"></span>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-3 ftco-animate">
                        <a href="#" class="gallery img d-flex align-items-center" style="background-image: url(images/gallery-4.jpg);">
                            <div class="icon mb-4 d-flex align-items-center justify-content-center">
                                <span class="icon-search"></span>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </section>


        <section class="ftco-counter ftco-bg-dark img" id="section-counter" style="background-image: url(images/bg_2.jpg);" data-stellar-background-ratio="0.5">
            <div class="overlay"></div>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-10">
                        <div class="row">
                            <div class="col-md-6 col-lg-3 d-flex justify-content-center counter-wrap ftco-animate">
                                <div class="block-18 text-center">
                                    <div class="text">
                                        <div class="icon"><span class="flaticon-pizza-1"></span></div>
                                        <strong class="number" data-number="100">0</strong>
                                        <span>Pizza Branches</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 col-lg-3 d-flex justify-content-center counter-wrap ftco-animate">
                                <div class="block-18 text-center">
                                    <div class="text">
                                        <div class="icon"><span class="flaticon-medal"></span></div>
                                        <strong class="number" data-number="85">0</strong>
                                        <span>Number of Awards</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 col-lg-3 d-flex justify-content-center counter-wrap ftco-animate">
                                <div class="block-18 text-center">
                                    <div class="text">
                                        <div class="icon"><span class="flaticon-laugh"></span></div>
                                        <strong class="number" data-number="10567">0</strong>
                                        <span>Happy Customer</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 col-lg-3 d-flex justify-content-center counter-wrap ftco-animate">
                                <div class="block-18 text-center">
                                    <div class="text">
                                        <div class="icon"><span class="flaticon-chef"></span></div>
                                        <strong class="number" data-number="900">0</strong>
                                        <span>Staff</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

       

        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center mb-5 pb-3">
                    <div class="col-md-7 heading-section ftco-animate text-center">
                        <h2 class="mb-4">Recent from blog</h2>
                        <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                    </div>
                </div>
                <div class="row d-flex">
                    <div class="col-md-4 d-flex ftco-animate">
                        <div class="blog-entry align-self-stretch">
                            <a href="blog-single.html" class="block-20" style="background-image: url('images/image_1.jpg');">
                            </a>
                            <div class="text py-4 d-block">
                                <div class="meta">
                                    <div><a href="#">Sept 10, 2018</a></div>
                                    <div><a href="#">Admin</a></div>
                                    <div><a href="#" class="meta-chat"><span class="icon-chat"></span> 3</a></div>
                                </div>
                                <h3 class="heading mt-2"><a href="#">The Delicious Pizza</a></h3>
                                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 d-flex ftco-animate">
                        <div class="blog-entry align-self-stretch">
                            <a href="blog-single.html" class="block-20" style="background-image: url('images/image_2.jpg');">
                            </a>
                            <div class="text py-4 d-block">
                                <div class="meta">
                                    <div><a href="#">Sept 10, 2018</a></div>
                                    <div><a href="#">Admin</a></div>
                                    <div><a href="#" class="meta-chat"><span class="icon-chat"></span> 3</a></div>
                                </div>
                                <h3 class="heading mt-2"><a href="#">The Delicious Pizza</a></h3>
                                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 d-flex ftco-animate">
                        <div class="blog-entry align-self-stretch">
                            <a href="blog-single.html" class="block-20" style="background-image: url('images/image_3.jpg');">
                            </a>
                            <div class="text py-4 d-block">
                                <div class="meta">
                                    <div><a href="#">Sept 10, 2018</a></div>
                                    <div><a href="#">Admin</a></div>
                                    <div><a href="#" class="meta-chat"><span class="icon-chat"></span> 3</a></div>
                                </div>
                                <h3 class="heading mt-2"><a href="#">The Delicious Pizza</a></h3>
                                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>


        <section class="ftco-appointment">
            <div class="overlay"></div>
            <div class="container-wrap">
                <div class="row no-gutters d-md-flex align-items-center">
                    <div class="col-md-6 d-flex align-self-stretch">
                        <div id="map"></div>
                    </div>
                    <div class="col-md-6 appointment ftco-animate">
                        <h3 class="mb-3">Contact Us</h3>
                        <form action="#" class="appointment-form">
                            <div class="d-md-flex">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="First Name">
                                </div>
                            </div>
                            <div class="d-me-flex">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Last Name">
                                </div>
                            </div>
                            <div class="form-group">
                                <textarea name="" id="" cols="30" rows="3" class="form-control" placeholder="Message"></textarea>
                            </div>
                            <div class="form-group">
                                <input type="submit" value="Send" class="btn btn-primary py-3 px-4">
                            </div>
                        </form>
                    </div>    			
                </div>
            </div>
        </section>

        <footer class="ftco-footer ftco-section img">
            <div class="overlay"></div>
            <div class="container">
                <div class="row mb-5">
                    <div class="col-lg-3 col-md-6 mb-5 mb-md-5">
                        <div class="ftco-footer-widget mb-4">
                            <h2 class="ftco-heading-2">About Us</h2>
                            <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                            <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-5">
                                <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                                <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                                <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 mb-5 mb-md-5">
                        <div class="ftco-footer-widget mb-4">
                            <h2 class="ftco-heading-2">Recent Blog</h2>
                            <div class="block-21 mb-4 d-flex">
                                <a class="blog-img mr-4" style="background-image: url(images/image_1.jpg);"></a>
                                <div class="text">
                                    <h3 class="heading"><a href="#">Even the all-powerful Pointing has no control about</a></h3>
                                    <div class="meta">
                                        <div><a href="#"><span class="icon-calendar"></span> Sept 15, 2018</a></div>
                                        <div><a href="#"><span class="icon-person"></span> Admin</a></div>
                                        <div><a href="#"><span class="icon-chat"></span> 19</a></div>
                                    </div>
                                </div>
                            </div>
                            <div class="block-21 mb-4 d-flex">
                                <a class="blog-img mr-4" style="background-image: url(images/image_2.jpg);"></a>
                                <div class="text">
                                    <h3 class="heading"><a href="#">Even the all-powerful Pointing has no control about</a></h3>
                                    <div class="meta">
                                        <div><a href="#"><span class="icon-calendar"></span> Sept 15, 2018</a></div>
                                        <div><a href="#"><span class="icon-person"></span> Admin</a></div>
                                        <div><a href="#"><span class="icon-chat"></span> 19</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-6 mb-5 mb-md-5">
                        <div class="ftco-footer-widget mb-4 ml-md-4">
                            <h2 class="ftco-heading-2">Services</h2>
                            <ul class="list-unstyled">
                                <li><a href="#" class="py-2 d-block">Cooked</a></li>
                                <li><a href="#" class="py-2 d-block">Deliver</a></li>
                                <li><a href="#" class="py-2 d-block">Quality Foods</a></li>
                                <li><a href="#" class="py-2 d-block">Mixed</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 mb-5 mb-md-5">
                        <div class="ftco-footer-widget mb-4">
                            <h2 class="ftco-heading-2">Have a Questions?</h2>
                            <div class="block-23 mb-3">
                                <ul>
                                    <li><span class="icon icon-map-marker"></span><span class="text">203 Fake St. Mountain View, San Francisco, California, USA</span></li>
                                    <li><a href="#"><span class="icon icon-phone"></span><span class="text">+2 392 3929 210</span></a></li>
                                    <li><a href="#"><span class="icon icon-envelope"></span><span class="text">info@yourdomain.com</span></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 text-center">

                        <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                    </div>
                </div>
            </div>
        </footer>



        <!-- loader -->
        <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


        <script src="js/jquery.min.js"></script>
        <script src="js/jquery-migrate-3.0.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.easing.1.3.js"></script>
        <script src="js/jquery.waypoints.min.js"></script>
        <script src="js/jquery.stellar.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/aos.js"></script>
        <script src="js/jquery.animateNumber.min.js"></script>
        <script src="js/bootstrap-datepicker.js"></script>
        <script src="js/jquery.timepicker.min.js"></script>
        <script src="js/scrollax.min.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
        <script src="js/google-map.js"></script>
        <script src="js/main.js"></script>

    </body>
</html>

