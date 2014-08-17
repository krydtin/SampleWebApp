<%-- 
    Document   : MultipleTable
    Created on : Aug 17, 2014, 8:54:14 AM
    Author     : Krydtin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="/ErrorPage.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        int n = (Integer) request.getAttribute("number");
        String message = request.getAttribute("msg").toString();
    %>
    <body>
        <h4>Multiply Table</h4>
        <h3><font color="red"><%= message%></font></h3>
            <% if (n == 0) {
                throw new Exception(message);
            }
            %>
        <table>
            <tr><td colspan=5>Multiplication Table Of <%= n%></td></tr>
            <% for (int i = 1; i <= 12; i++) {%>
            <tr>
                <td><%= n%></td>
                <td> x </td>
                <td><%= i%></td>
                <td> = </td><td><%= n * i%></td>
            </tr>
            <%  } %>
        </table>
    </body>
</html>
