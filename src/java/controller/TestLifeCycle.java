package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Collections;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author maq
 */
//@WebServlet(name = "TestLifeCycle", urlPatterns = {"/TestLifeCycle"})
public class TestLifeCycle extends HttpServlet {

    private int counter = 0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        counter++;
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestLifeCycle</title>");
            out.println("</head>");
            out.println("<body bgcolor=" + getInitParameter("background") + ">");
            out.println("<h1>Request number : " + counter + "</h1>");
            for (String paramName : Collections.list(request.getParameterNames())) {
                out.println(paramName + " : " + request.getParameter(paramName) + "<br>");
            }
            
            for (String a : request.getParameterValues("aa")) {
                out.println(a + "<br>");
            }
            out.println("</body>");
            out.println("</html>");
        }

    }

    @Override
    public void init() throws ServletException {
        final String initCounter = getInitParameter("initCounter");
        counter = initCounter == null ? 0 : Integer.parseInt(initCounter);
        System.out.println("I was born on " + (Calendar.getInstance().getTime()));
    }

    @Override
    public void destroy() {
        System.out.println("I was death on " + (Calendar.getInstance().getTime()));
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
