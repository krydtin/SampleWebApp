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
 * @author maq
 */
@WebServlet(name = "AddCustomerServlet", urlPatterns = {"/AddCustomer"})
public class AddCustomerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        final String id = request.getParameter("inputId");
        final String name = request.getParameter("inputName");
        final String email = request.getParameter("inputEmail");
        final String creditLimit = request.getParameter("inputCreditLimit");
        final Customer customer = new Customer();
        customer.setCustomerId(Integer.parseInt(id));
        customer.setName(name);
        customer.setEmail(email);
        customer.setCreditLimit(Integer.parseInt(creditLimit));
        customer.insertNewCustomer();
        final List<Customer> customers = Customer.findByName(name);
        request.setAttribute("customers", customers);
        getServletContext().getRequestDispatcher("/CustomerList.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
