

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
                ${evento.getTitolo()}
            </h1>
        </div>
    </div>
    <!-- /.row -->
    <!-- Features Section -->
    <div class="row">
        <div class="col-lg-12">
            <h2 class="page-header">Dettagli evento</h2>
        </div>
        <div class="col-md-6">
            <img class="img-responsive" src="http://placehold.it/700x450" alt="">
        </div>
        <div class="col-md-6">
            <p> ${evento.getDescrizione()} </p>
        </div>
    </div>
    <!-- /.row -->



</div>

<jsp:include page="footer.jsp"/>
