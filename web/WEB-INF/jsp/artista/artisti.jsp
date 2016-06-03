<%-- 
    Document   : artisti
    Created on : 7-mag-2016, 11.42.07
    Author     : FSEVERI\reginato2906
--%>

<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

   <!-- Navigation -->
        <jsp:include page="../layout/include.jsp"/>

            <jsp:include page="../layout/head.jsp"/>
    
    <jsp:include page="../layout/menu.jsp"/>

    <!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">Artisti</h2>
            </div>
        </div>
        <c:forEach items="${artisti}" var="artista">
            <div class="row">
                <div class="col-md-5">
                    <p><font size="4"><b>Identificatore:</b></font> <font size="3">${artista.getId()}</font></p>
                    <p><font size="4"><b>Nome artista:</b></font> <font size="3">${artista.getNomeArte()}</font></p>
                </div>    
            </div>        
            <hr>
        </c:forEach>
          
    <jsp:include page="../layout/foot.jsp"/>
