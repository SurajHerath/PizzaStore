package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CustomPizza;
import service.CustomPizzaService;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomPizzaController", urlPatterns = {"/CustomPizzaController"})
public class CustomPizzaController extends HttpServlet {
    private CustomPizzaService customPizzaService;

    @Override
    public void init() throws ServletException {
        customPizzaService = new CustomPizzaService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "delete":
                deleteCustomPizza(request, response);
                break;
            case "list":
            default:
                listCustomPizzas(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "insert";
        }

        switch (action) {
            case "insert":
                insertCustomPizza(request, response);
                break;
            case "update":
                updateCustomPizza(request, response);
                break;
        }
    }

    private void insertCustomPizza(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("customPizzaName");
        int crustID = Integer.parseInt(request.getParameter("crustID"));
        int sauceID = Integer.parseInt(request.getParameter("sauceID"));
        int cheeseID = Integer.parseInt(request.getParameter("cheeseID"));
        String toppingIDs = request.getParameter("toppingIDs");
        double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));

        CustomPizza customPizza = new CustomPizza(0, name, crustID, sauceID, cheeseID, toppingIDs, totalPrice);

        if (customPizzaService.insertCustomPizza(customPizza)) {
            response.sendRedirect("CustomPizzaController?action=list");
        } else {
            response.getWriter().write("Error inserting pizza");
        }
    }

    private void updateCustomPizza(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("customPizzaID"));
        String name = request.getParameter("customPizzaName");
        int crustID = Integer.parseInt(request.getParameter("crustID"));
        int sauceID = Integer.parseInt(request.getParameter("sauceID"));
        int cheeseID = Integer.parseInt(request.getParameter("cheeseID"));
        String toppingIDs = request.getParameter("toppingIDs");
        double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));

        CustomPizza customPizza = new CustomPizza(id, name, crustID, sauceID, cheeseID, toppingIDs, totalPrice);

        if (customPizzaService.updateCustomPizza(customPizza)) {
            response.sendRedirect("CustomPizzaController?action=list");
        } else {
            response.getWriter().write("Error updating pizza");
        }
    }

    private void deleteCustomPizza(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("customPizzaID"));

        if (customPizzaService.deleteCustomPizza(id)) {
            response.sendRedirect("CustomPizzaController?action=list");
        } else {
            response.getWriter().write("Error deleting pizza");
        }
    }

    private void listCustomPizzas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomPizza> pizzas = customPizzaService.getAllCustomPizzas();
        request.setAttribute("pizzas", pizzas);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewAllCustomPizza.jsp");
        dispatcher.forward(request, response);
    }
}

