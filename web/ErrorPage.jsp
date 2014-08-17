<%-- 
    Document   : ErrorPage
    Created on : Aug 17, 2014, 10:43:37 AM
    Author     : Krydtin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <h1>Test Error</h1>
        <% 
            String message = request.getAttribute("msg").toString();
        %>
        <h3><%= exception %></h3>
    </body>
</html>
