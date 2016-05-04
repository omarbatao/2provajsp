<%-- 
    Document   : checklogin
    Created on : 23-apr-2016, 11.14.30
    Author     : FSEVERI\depaula2995
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>


        <%

            if (request.getAttribute("login") != null && request.getAttribute("login").equals("true")) {
                session.setAttribute("username", request.getAttribute("username"));
                session.setAttribute("userid", request.getAttribute("userid"));
                response.sendRedirect("./");
            } else {
                response.sendRedirect("./login?error=true");
            }

        %>
    </body>
</html>
