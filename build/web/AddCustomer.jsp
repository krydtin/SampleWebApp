<%-- 
    Document   : AddCustomer
    Created on : Jul 27, 2014, 3:51:13 PM
    Author     : maq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="AddCustomer" method="post">
            <div> 
                Customer Id : <input type="number" name="inputId"/>
            </div>
            <div>
                Name : <input type="text" name="inputName"/>
            </div>
            <div>
                Email : <input type="text" name="inputEmail"/>
            </div>
            <div>
                Credit Limit : <input type="text" name="inputCreditLimit"/>
            </div>
            <div>
                <input type="submit" value="Add"/>
            </div>
        </form>
    </body>
</html>
