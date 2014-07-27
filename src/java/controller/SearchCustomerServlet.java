package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;

/**
 *
 * @author INT676
 */
@WebServlet("/SearchCustomer")
public class SearchCustomerServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String s = request.getParameter("s");
        final List<Customer> customers = Customer.findByName(s);
        request.setAttribute("customers", customers);
        getServletContext().getRequestDispatcher("/CustomerList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         processRequest(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         processRequest(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    
}
