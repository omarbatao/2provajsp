

<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="head.jsp"/>

<jsp:include page="menu.jsp"/>

<link rel="stylesheet" type="text/css" href="./resources/css/login/styles.css">


<div class="container">
    <div class="row">

        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h1 class="text-center login-title">Effettua il login per continuare su Dipr&egrave; Museum</h1>
            <div class="account-wall">
        <%
        if(request.getParameter("error")!=null && request.getParameter("error").equals("true"))
            out.print("<h4 style='text-align:center;color:red;padding-top:30px'>Login errato</h4>");
        %>
                <form class="form-signin" action="./checklogin" method="POST">
                <input type="text" class="form-control" placeholder="Username" name="username" required autofocus>
                <input type="password" class="form-control" placeholder="Password" name="password" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit">
                    Log in</button>
                   <div style="text-align:center"> <br> <b>Oppure</b><div>
            <a href="./register" class="text-center new-account"><h4>Crea un account</h4> </a>
                </form>
            </div>
            
        </div>
    </div>
</div>

   
<jsp:include page="footer.jsp"/>
