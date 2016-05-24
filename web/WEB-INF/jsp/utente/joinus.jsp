<%-- 
    Document   : JoinUs
    Created on : 15-mar-2016, 8.41.11
    Author     : FSEVERI\bizzotto3061
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../layout/head.jsp"/>
<jsp:include page="../layout/menu.jsp"/>

<div class="col-lg-7" >
    <c:if test="${risposta!=null}">
        <div style="color:red;text-align:center"><b>${risposta}</b></div> </br>
            </c:if>
    <form class="form" role="form" method="post" action="/registra" accept-charset="UTF-8" id="login-nav">
        <fieldset class="form-group">
            <label for="email">Email:</label>
            <input width="100" type="email" class="form-control" id="email" placeholder="Enter email">
        </fieldset>
        <fieldset class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" placeholder="Password">
        </fieldset>
        <fieldset class="form-group">
            <label for="nickname">Nickname:</label>
            <input type="text" class="form-control" id="nickname" placeholder="Nickname">
        </fieldset>
        <fieldset class="form-group">
            <label for="nome">Nome:</label>
            <input type="text" class="form-control" id="nome" placeholder="Nome">
        </fieldset>
        <fieldset class="form-group">
            <label for="cognome">Cognome:</label>
            <input type="text" class="form-control" id="cognome" placeholder="Cognome">
        </fieldset>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<jsp:include page="./layout/foot.jsp"/>
