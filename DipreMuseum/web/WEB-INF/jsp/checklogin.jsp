<%-- 
    Document   : checklogin
    Created on : 23-apr-2016, 11.14.30
    Author     : FSEVERI\depaula2995
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (username != null && password != null) {
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                response.sendRedirect("./");
            } else {
                response.sendRedirect("error.jsp");
            }

        %>
    </body>
</html>
