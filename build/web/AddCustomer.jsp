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
        <title>Add Customer</title>
    </head>
    <body>
        <form action="AddCustomer" method="post">
            <table>
                <tr>
                    <td>Customer Id : </td>
                    <td><input type="number" required name="inputId"/></td>
                </tr>
                <tr>
                    <td>Name : </td>
                    <td><input type="text" required name="inputName"/></td>
                </tr>
                <tr>
                    <td>Email : </td>
                    <td><input type="text" required name="inputEmail"/></td>
                </tr>
                <tr>
                    <td>Credit Limit : </td>
                    <td><input type="text" required name="inputCreditLimit"/></td>
                </tr>
                <tr>
                    <td/>
                    <td><input type="submit" value="Add" style="float: right"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
