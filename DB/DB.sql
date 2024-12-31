/* -- Database: PizzaOrderingSystem
CREATE DATABASE PizzaOrderingSystem;

USE PizzaOrderingSystem;

-- Customer Table
CREATE TABLE Customer (
    cus_ID VARCHAR(20) PRIMARY KEY,
    cus_Name VARCHAR(100) NOT NULL,
    cus_Email VARCHAR(100) UNIQUE NOT NULL,
    cus_Phone VARCHAR(15) NOT NULL,
    LoyaltyPoint INT DEFAULT 0,
    cus_Password VARCHAR(50) NOT NULL
);


-- Employee Table
CREATE TABLE Employee (
    emp_ID VARCHAR(20) PRIMARY KEY,
    emp_Name VARCHAR(100) NOT NULL,
    emp_Email VARCHAR(100) UNIQUE NOT NULL,
    emp_Phone VARCHAR(15) NOT NULL,
    emp_Password VARCHAR(100) NOT NULL
);

-- Pizza Table
-- Main Pizza Table
CREATE TABLE Pizza (
    pizza_ID VARCHAR(20) PRIMARY KEY,
    pizza_Name VARCHAR(100) NOT NULL,
    crust VARCHAR(50),
    sauce VARCHAR(50),
    cheese VARCHAR(50),
    pizzaloyaltyPoints INT DEFAULT 0,
    price DECIMAL(10, 2) NOT NULL
);

-- Toppings Table (to handle pizza toppings as a one-to-many relationship)
CREATE TABLE PizzaToppings (
    topping_ID INT AUTO_INCREMENT PRIMARY KEY,
    pizza_ID VARCHAR(20),
    topping VARCHAR(50),
    FOREIGN KEY (pizza_ID) REFERENCES Pizza(pizza_ID) ON DELETE CASCADE
);

-- Extra Toppings Table (similar to toppings but for extras)
CREATE TABLE ExtraToppings (
    extraTopping_ID INT AUTO_INCREMENT PRIMARY KEY,
    extraTopping_Name VARCHAR(50),
    quantity_Grams VARCHAR(50)
);


-- FavoritePizza Table (to handle the many-to-many relationship between Customer and Pizza)
CREATE TABLE FavoritePizza (
    cus_ID VARCHAR(20),
    pizza_ID VARCHAR(20),
    PRIMARY KEY (cus_ID, pizza_ID),
    FOREIGN KEY (cus_ID) REFERENCES Customer(cus_ID) ON DELETE CASCADE,
    FOREIGN KEY (pizza_ID) REFERENCES Pizza(pizza_ID) ON DELETE CASCADE
);


-- Order Table
CREATE TABLE `Order` (
    order_ID VARCHAR(20) PRIMARY KEY,
    cus_ID VARCHAR(20),
    order_Type VARCHAR(50) NOT NULL,
    delivery_Address VARCHAR(255),
    total_Price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (cus_ID) REFERENCES Customer(cus_ID) ON DELETE CASCADE
);

-- OrderPizza Table (to handle many-to-many relationship between Order and Pizza)
CREATE TABLE OrderPizza (
    order_ID VARCHAR(20),
    pizza_ID VARCHAR(20),
    PRIMARY KEY (order_ID, pizza_ID),
    FOREIGN KEY (order_ID) REFERENCES `Order`(order_ID) ON DELETE CASCADE,
    FOREIGN KEY (pizza_ID) REFERENCES Pizza(pizza_ID) ON DELETE CASCADE
);

-- OrderState Table
CREATE TABLE OrderState (
    status_ID INT AUTO_INCREMENT PRIMARY KEY,
    status VARCHAR(50) NOT NULL,
    order_ID VARCHAR(20) UNIQUE,
    FOREIGN KEY (order_ID) REFERENCES `Order`(order_ID) ON DELETE CASCADE
);

-- OrderTracker Table
CREATE TABLE OrderTracker (
    tracker_ID INT AUTO_INCREMENT PRIMARY KEY,
    order_ID VARCHAR(20) NOT NULL,
    subscriber_ID VARCHAR(20) NOT NULL,
    FOREIGN KEY (order_ID) REFERENCES `Order`(order_ID) ON DELETE CASCADE,
    FOREIGN KEY (subscriber_ID) REFERENCES Customer(cus_ID) ON DELETE CASCADE
);

-- Payment Table
CREATE TABLE Payment (
    payment_ID VARCHAR(20) PRIMARY KEY,
    order_ID VARCHAR(20),
    payment_Method VARCHAR(20),
    amount DOUBLE NOT NULL,
    FOREIGN KEY (order_ID) REFERENCES `Order`(order_ID) ON DELETE CASCADE
);

-- Promotion Table
CREATE TABLE Promotion (
    promo_ID VARCHAR(20) PRIMARY KEY,
    promo_Details TEXT NOT NULL,
    discount DOUBLE NOT NULL
);

-- OrderPromotion Table (to link Promotions to Orders)
CREATE TABLE OrderPromotion (
    order_ID VARCHAR(20),
    promo_ID VARCHAR(20),
    PRIMARY KEY (order_ID, promo_ID),
    FOREIGN KEY (order_ID) REFERENCES `Order`(order_ID) ON DELETE CASCADE,
    FOREIGN KEY (promo_ID) REFERENCES Promotion(promo_ID) ON DELETE CASCADE
);

-- Feedback Table
CREATE TABLE Feedback (
    feedback_ID VARCHAR(20) PRIMARY KEY,
    cus_ID VARCHAR(20),
    pizza_ID VARCHAR(20),
    rating INT CHECK (rating BETWEEN 1 AND 5),
    comment TEXT,
    FOREIGN KEY (cus_ID) REFERENCES Customer(cus_ID) ON DELETE CASCADE,
    FOREIGN KEY (pizza_ID) REFERENCES Pizza(pizza_ID)ON DELETE CASCADE
);
*/
USE PizzaOrderingSystem;

/*CREATE TABLE ExtraToppings (
    extraTopping_ID INT AUTO_INCREMENT PRIMARY KEY,
    extraTopping_Name VARCHAR(50),
    quantity_Grams VARCHAR(50),
    topping_Price double
);



-- Order Table
CREATE TABLE `Order` (
    order_ID VARCHAR(20) PRIMARY KEY,
    cus_ID VARCHAR(20),
    pizza_ID VARCHAR(20),
    extraTopping_ID INT,
    order_Type VARCHAR(50) NOT NULL,
    delivery_Address VARCHAR(255),
    total_Price double NOT NULL,
    FOREIGN KEY (cus_ID) REFERENCES Customer(cus_ID) ON DELETE CASCADE,
    FOREIGN KEY (pizza_ID) REFERENCES pizza(pizza_ID) ON DELETE CASCADE,
    FOREIGN KEY (extraTopping_ID) REFERENCES extratoppings(extraTopping_ID) ON DELETE CASCADE
);

CREATE TABLE crust (
    crust_ID INT AUTO_INCREMENT PRIMARY KEY,
    crust_Name VARCHAR(50) NOT NULL,
    crust_Price DOUBLE NOT NULL
);

-- Table for Sauces
CREATE TABLE sauce (
    sauce_ID INT AUTO_INCREMENT PRIMARY KEY,
    sauce_Name VARCHAR(50) NOT NULL,
    sauce_Price DOUBLE NOT NULL
);

-- Table for Cheeses
CREATE TABLE cheese (
    cheese_ID INT AUTO_INCREMENT PRIMARY KEY,
    cheese_Name VARCHAR(50) NOT NULL,
    cheese_Price DOUBLE NOT NULL
);

-- Table for Toppings
CREATE TABLE topping (
    topping_ID INT AUTO_INCREMENT PRIMARY KEY,
    topping_Name VARCHAR(50) NOT NULL,
    topping_Price DOUBLE NOT NULL
);

-- Table for Custom Pizzas
CREATE TABLE custompizza (
    customPizza_ID INT AUTO_INCREMENT PRIMARY KEY,
    customPizza_Name VARCHAR(100) NOT NULL,
    crust_ID INT,
    sauce_ID INT,
    cheese_ID INT,
    topping_ID INT, -- Store multiple toppings as comma-separated values
    total_Price DOUBLE NOT NULL,
    FOREIGN KEY (crust_ID) REFERENCES crust(crust_ID),
    FOREIGN KEY (sauce_ID) REFERENCES sauce(sauce_ID),
    FOREIGN KEY (cheese_ID) REFERENCES cheese(cheese_ID),
	FOREIGN KEY (topping_ID) REFERENCES topping(topping_ID)
);
-- OrderState Table
CREATE TABLE OrderState (
    status_ID INT AUTO_INCREMENT PRIMARY KEY,
    status VARCHAR(50) NOT NULL,
    order_ID VARCHAR(20) UNIQUE,
    FOREIGN KEY (order_ID) REFERENCES `Order`(order_ID) ON DELETE CASCADE
);

CREATE TABLE Promotion (
    promo_ID VARCHAR(20) PRIMARY KEY,
    promo_Details TEXT NOT NULL,
    discount DOUBLE NOT NULL,
    start_date DATE,
    end_date DATE
);
*/
SHOW VARIABLES LIKE 'datadir';