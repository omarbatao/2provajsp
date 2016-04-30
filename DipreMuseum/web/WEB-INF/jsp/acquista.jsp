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
            <h2 style="text-align: center; text-transform: uppercase">
                Acquista
            </h2>
            <hr/>
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
                <% int contatore=1; %>
                <h3>BIGLIETTO N. ${contatore}</h3>
                <form action="#">
                    <div class="col-md-4"><input type="categoria" class="form-control" placeholder="Categoria" name="categoria"></div>
                    <div class="col-md-4"><button class="btn btn-md btn-primary" type="submit">Aggiungi</button></div>
                </form>
            </div>
        </div>
    </div>
    <!-- /.row -->



</div>

<jsp:include page="footer.jsp"/>
