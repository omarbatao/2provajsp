<%-- 
    Document   : logout
    Created on : 23-apr-2016, 11.26.46
    Author     : FSEVERI\depaula2995
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <% 
            session.invalidate();
            response.sendRedirect("./");
        %>
    </body>
</html>
