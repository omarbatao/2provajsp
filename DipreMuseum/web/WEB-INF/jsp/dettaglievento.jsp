

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
        <div class="col-md-6">
            <img class="img-responsive" src="http://placehold.it/700x450" alt="">
        </div>
        <div class="col-md-6">
            <div class="row">
                <p> ${evento.getDescrizione()} </p>
            </div>
            <div class="row" style="padding-top: 49%">
                <button class="col-md-12 btn btn-success" onclick="./acquista">Acquista</button>
            </div>
        </div>
    </div>
    <!-- /.row -->



</div>

<jsp:include page="footer.jsp"/>
