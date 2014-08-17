<%-- 
    Document   : CustomerList
    Created on : Jul 20, 2014, 11:48:33 AM
    Author     : INT676
--%>

<%@page import="java.util.List"%>
<%@page import="model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer List</title>
    </head>
    <body>
        <h1>Customer List</h1>
        <form action="SearchCustomer" method="post">
            Search Customer By Name:<input type="text" required name="s"/>
            <input type="submit" value="Search" />
        </form>
        <hr>
       
        <c:forEach items="${customers}" var="c">
            ${c.name} ${c.email}<br> 
        </c:forEach>
    </body>
</html>
