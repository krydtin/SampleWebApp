<%-- 
    Document   : UpdateCustomer
    Created on : Aug 7, 2014, 1:03:34 AM
    Author     : maq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Customer</title>
    </head>
    <body>
        <h1>Update Customer</h1>
        <form action="UpdateCustomerServlet" method="post">
            <div>
                <div style="float: left">
                    id : 
                </div>
                <div style="float: left; padding-left: 30px">
                    <input type="text" name="id" required />
                </div>
                <div style="clear:both"></div>
            </div>
            <div>
                <div style="float: left">
                    name : 
                </div>
                <div style="float: left; padding-left: 30px">
                    <input type="text" name="name" required />
                </div>
                <div style="clear:both"></div>
            </div>
            <div>
                <div style="float: left">
                    credit limit : 
                </div>
                <div style="float: left; padding-left: 30px">
                    <input type="text" name="creditLimit" required />
                </div>
                <div style="clear:both"></div>
            </div>
            <div>
                <div style="float: left">
                    email : 
                </div>
                <div style="float: left; margin-left:  30px">
                    <input type="text" name="email" required />
                </div>
                <div style="clear:both"></div>
            </div>
            <div>
                <div></div>
                <div>
                    <input type="submit" name="update"/>
                </div>
            </div>
        </form>        
        <% String result = "";
            if (request.getAttribute("updateResult") != null) {
               result = (String) request.getAttribute("updateResult");
           }%>
        <% if (result != null && !result.isEmpty()) {
        %> 
        result = ${updateResult}
        <% }%>
    </body>
</html>
