package controller;

import jakarta.servlet.RequestDispatcher;
import model.Order;
import model.OrderState;
import service.OrderService;
import service.OrderStatesService;
import model.Customer;

import java.io.IOException;
import java.util.List;
import java.net.URLEncoder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author suraj
 */
@WebServlet(name = "OrderController", urlPatterns = {"/OrderController"})
public class OrderController extends HttpServlet {

    private final OrderService orderPizzaService = new OrderService();
    private final OrderStatesService orderStatesService = new OrderStatesService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "viewall";
        }

        switch (action) {
            case "viewall":
                viewAllOrders(request, response);
                break;
            case "viewByCustomerId":
                viewOrdersByCustomerId(request, response);
                break;
            case "delete":
                deleteOrder(request, response);
                break;
            case "viewOrderDetails":
                getOrderDetailsByOrderId(request, response);
                break;
            default:
                response.sendRedirect("error.jsp");
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
                insertOrder(request, response);
                break;
            case "insertAndPay":
                insertOrderAndRedirectToPayment(request, response);
                break;
            case "delete":
                deleteOrder(request, response);
                break;
            default:
                response.sendRedirect("error.jsp");
        }
    }

    private void insertOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String orderID = request.getParameter("orderID");
        String customerID = request.getParameter("customerID");
        String pizzaID = request.getParameter("pizzaID");
        int extraToppingID = Integer.parseInt(request.getParameter("extraToppingID"));
        String orderType = request.getParameter("orderType");
        String deliveryAddress = request.getParameter("deliveryAddress");
        double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));

        // Using the OrderBuilder to create an Order object
        Order order = new Order.OrderBuilder(orderID)
                .customerID(customerID)
                .pizzaID(pizzaID)
                .extraToppingID(extraToppingID)
                .orderType(orderType)
                .deliveryAddress(deliveryAddress)
                .totalPrice(totalPrice)
                .build();

        boolean isInserted = orderPizzaService.insertOrder(order);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        if (isInserted) {
            response.getWriter().write("{\"success\": true}");
        } else {
            response.getWriter().write("{\"success\": false}");
        }
    }

    private void insertOrderAndRedirectToPayment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String orderID = request.getParameter("orderID");
        String customerID = request.getParameter("customerID");
        String pizzaID = request.getParameter("pizzaID");
        int extraToppingID = Integer.parseInt(request.getParameter("extraToppingID"));
        String orderType = request.getParameter("orderType");
        String deliveryAddress = request.getParameter("deliveryAddress");
        double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));

        // Using the OrderBuilder to create an Order object
        Order order = new Order.OrderBuilder(orderID)
                .customerID(customerID)
                .pizzaID(pizzaID)
                .extraToppingID(extraToppingID)
                .orderType(orderType)
                .deliveryAddress(deliveryAddress)
                .totalPrice(totalPrice)
                .build();

        boolean isInserted = orderPizzaService.insertOrder(order);

        if (isInserted) {
            String paymentUrl = "payment.jsp?"
                    + "orderID=" + URLEncoder.encode(orderID, "UTF-8")
                    + "&customerID=" + URLEncoder.encode(customerID, "UTF-8")
                    + "&pizzaID=" + URLEncoder.encode(pizzaID, "UTF-8")
                    + "&extraToppingID=" + extraToppingID
                    + "&orderType=" + URLEncoder.encode(orderType, "UTF-8")
                    + "&deliveryAddress=" + URLEncoder.encode(deliveryAddress, "UTF-8")
                    + "&totalPrice=" + totalPrice;

            response.sendRedirect(paymentUrl);
        } else {
            response.sendRedirect("error.jsp?message=" + URLEncoder.encode("Failed to insert order", "UTF-8"));
        }
    }

    private void viewAllOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orders = orderPizzaService.getAllOrders();
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("ViewAllOrders.jsp").forward(request, response);
    }

    private void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String orderID = request.getParameter("orderID");
        boolean isDeleted = orderPizzaService.deleteOrder(orderID);

        if (isDeleted) {
            response.sendRedirect("OrderController?action=viewall");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    private void viewOrdersByCustomerId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer loggedInCustomer = (Customer) session.getAttribute("loggedInCustomer");

        if (loggedInCustomer != null) {
            String customerID = loggedInCustomer.getCustomerID(); 
            if (customerID != null && !customerID.isEmpty()) {
                List<Order> orders = orderPizzaService.getOrdersByCustomerId(customerID);
                request.setAttribute("orders", orders);
                request.setAttribute("customerID", customerID);
                request.getRequestDispatcher("ViewOrdersByCustomerId.jsp").forward(request, response);
            } else {
                response.sendRedirect("error.jsp");
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    private void getOrderDetailsByOrderId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderID = request.getParameter("orderID");

        if (orderID != null && !orderID.isEmpty()) {
            Order order = orderPizzaService.getOrderById(orderID);

            if (order != null) {
                List<OrderState> orderStates = orderStatesService.getOrderStatesByOrderId(orderID);

                request.setAttribute("order", order);
                request.setAttribute("orderStates", orderStates);

                request.getRequestDispatcher("CustomerOrderDetails.jsp").forward(request, response);
            } else {
                response.sendRedirect("error.jsp");
            }
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
