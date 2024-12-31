/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.RequestDispatcher;
import model.Pizza;
import service.PizzaService;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ExtraTopping;
import service.ExtraToppingService;

/**
 *
 * @author suraj
 */
@WebServlet(name = "PizzaController", urlPatterns = {"/PizzaController"})
public class PizzaController extends HttpServlet {
    private final PizzaService pizzaService = new PizzaService();
    private final ExtraToppingService extraToppingService = new ExtraToppingService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "list":
                    listPizzas(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deletePizza(request, response);
                    break;
                 case "order":
                    showOrderForm(request, response);
                    break;
                default:
                    response.sendRedirect("error.jsp");
            }
        } catch (ServletException | IOException e) {
            response.sendRedirect("error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "add":
                    addPizza(request, response);
                    break;
                case "update":
                    updatePizza(request, response);
                    break;
                default:
                    response.sendRedirect("error.jsp");
            }
        } catch (IOException e) {
            response.sendRedirect("error.jsp");
        }
    }
    
    private void addPizza(HttpServletRequest request, HttpServletResponse response) throws IOException {
    try {
        System.out.println("[DEBUG] addPizza() invoked.");

        // Create Pizza object using parameters from the request
        Pizza pizza = new Pizza(
                request.getParameter("pizza_ID"),
                request.getParameter("pizza_Name"),
                request.getParameter("crust"),
                request.getParameter("sauce"),
                request.getParameter("cheese"),
                Double.parseDouble(request.getParameter("price"))
        );

        // Log pizza details for debugging
        System.out.println("[DEBUG] Pizza created: " + pizza);

        // Attempt to add the pizza via the service layer
        boolean isAdded = pizzaService.addPizza(pizza);
        System.out.println("[DEBUG] Pizza added to database: " + isAdded);

        // Redirect based on success or failure
        if (isAdded) {
            System.out.println("[DEBUG] Redirecting to PizzaController?action=list");
            response.sendRedirect("PizzaController?action=list");
        } else {
            System.out.println("[DEBUG] Redirecting to error.jsp");
            response.sendRedirect("error.jsp");
        }
    } catch (Exception e) {
        // Log any exceptions that occur
        System.out.println("[ERROR] Exception in addPizza(): " + e.getMessage());
        e.printStackTrace();
        response.sendRedirect("error.jsp");
    }
}


    private void listPizzas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("[DEBUG] Invoking listPizzas()...");
    List<Pizza> pizzas = pizzaService.getAllPizzas();
    if (pizzas == null || pizzas.isEmpty()) {
        System.out.println("[DEBUG] No pizzas available to display.");
    } else {
        System.out.println("[DEBUG] Pizzas fetched: " + pizzas.size());
    }
    request.setAttribute("pizzas", pizzas);
    RequestDispatcher dispatcher = request.getRequestDispatcher("PizzaMenu.jsp");
    dispatcher.forward(request, response);
}

     private void showOrderForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pizzaId = request.getParameter("pizza_ID");
        Pizza pizza = pizzaService.getPizzaById(pizzaId);
        List<ExtraTopping> extraToppings = extraToppingService.getAllExtraToppings();

        request.setAttribute("pizza", pizza);
        request.setAttribute("extraToppings", extraToppings);

        RequestDispatcher dispatcher = request.getRequestDispatcher("OrderPizza.jsp");
        dispatcher.forward(request, response);
    }
    

   private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("Entering showEditForm method...");

    // Fetching the pizza ID from the request
    String pizzaId = request.getParameter("pizza_ID");
    System.out.println("Received pizza ID: " + pizzaId);

    // Fetching the pizza details from the service
    Pizza pizza = pizzaService.getPizzaById(pizzaId);
    System.out.println("Fetched Pizza: " + (pizza != null ? pizza.toString() : "null"));

    // Check if the pizza exists
    if (pizza == null) {
        System.out.println("Pizza not found. Redirecting to error.jsp...");
        response.sendRedirect("error.jsp");
        return;
    }

    // Setting the pizza as a request attribute
    request.setAttribute("pizza", pizza);
    System.out.println("Pizza set as request attribute. Forwarding to UpdatePizza.jsp...");

    // Forwarding the request to UpdatePizza.jsp
    RequestDispatcher dispatcher = request.getRequestDispatcher("UpdatePizza.jsp");
    dispatcher.forward(request, response);

    System.out.println("Exiting showEditForm method...");
}



    
    private void updatePizza(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Pizza pizza = new Pizza(
                request.getParameter("pizza_ID"),
                request.getParameter("pizza_Name"),
                request.getParameter("crust"),
                request.getParameter("sauce"),
                request.getParameter("cheese"),
                Double.parseDouble(request.getParameter("price"))
        );
        if (pizzaService.updatePizza(pizza)) {
            response.sendRedirect("PizzaController?action=list");
        } else {
            response.sendRedirect("error.jsp");
        }
    }  
    

    private void deletePizza(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pizzaId = request.getParameter("pizza_ID");
        if (pizzaService.deletePizza(pizzaId)) {
            response.sendRedirect("PizzaController?action=list");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
