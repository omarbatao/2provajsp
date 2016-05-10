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
                Eventi
            </h1>
        </div>
    </div>
    <!-- /.row -->
    <!-- Features Section -->
        <c:forEach items="${eventi}" var="evento">
        <div class="col-md-6">
            <div class="panel panel-default" style="height:320px;position:relative">
                <div class="panel-heading">
                    <h4><i class="fa fa-university"></i> ${evento.getTitolo()}</h4>
                </div>
                <div class="panel-heading">
                    <h4><i class="fa fa-calendar"></i> ${evento.getDataI()} <i class="fa fa-ellipsis-h"></i> ${evento.getDataF()}</h4>
                </div>
                <div class="panel-heading">
                    <h4><i class="fa fa-euro"></i> ${evento.getTariffa()}</h4>
                </div>
                <div class="panel-body">
                    <p>${evento.getDescrizione()}</p>
                </div>
                <div>
                <a  href="./evento?id=${evento.getIdVisita()}">  <button class="btn btn-info"  style="bottom:10px;right: 5%;left:5%;position:absolute;width:90%;">Informazioni</button></a>
                </div>
            </div>
        </div>
        </c:forEach>
</div>

<jsp:include page="contatti.jsp"/>
<jsp:include page="footer.jsp"/>
