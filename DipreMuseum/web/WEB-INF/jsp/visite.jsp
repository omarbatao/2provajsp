<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="head.jsp"/>

<jsp:include page="menu.jsp"/>


<!-- Page Content -->
<div class="container">

    <!-- Marketing Icons Section -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header titoloevento">
                Visite
            </h1>
        </div>
    </div>
    <!-- /.row -->
    <!-- Features Section -->
        <c:forEach items="${visitedb}" var="visita">
        <div class="col-md-6">
            <div class="panel panel-default"  style="height:220px;">
                <div class="panel-heading">
                    <a href="./visite?id=${visita.getIdVisita()}"> <h4><i class="fa fa-university"></i>${visita.getTitolo()}</h4></a>
                </div>
                <div class="panel-body">
                    <p>${visita.getDescrizione()}</p>
                    <a href="./visite?id=${visita.getIdVisita()}" class="btn btn-default" style="position:absolute;bottom:40px;">Acquista</a>
                </div>
            </div>
        </div>
        </c:forEach>
</div>

<jsp:include page="contatti.jsp"/>
<jsp:include page="footer.jsp"/>
