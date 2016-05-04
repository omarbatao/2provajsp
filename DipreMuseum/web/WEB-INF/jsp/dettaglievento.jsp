

<%@page import="models.Visita"%>
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

                <% if (session.getAttribute("username") != null && !session.getAttribute("username").toString().equals("")) {%>
                <button style="margin-top:47% " class="col-md-12 btn btn-success" data-toggle="modal" data-target="#tickets" >Acquista</button>



                <%}%>
                 <% if (session.getAttribute("username") == null || session.getAttribute("username").toString().equals("")) {%>
                 <a href="./register"><button style="margin-top:47% " class="col-md-12 btn btn-warning" data-toggle="modal">Registati per Acquistare un biglietto</button></a>
                <%}%>

            </div>
        </div>
    </div>
    <!-- /.row -->

    <!-- Modal -->
    <div class="modal fade" id="tickets" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Acquista biglietti</h4>
                </div>

                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="row">
                            <div class="col-md-12">

                                <% int i = 0;%>
                                <c:forEach items="${categorie}" var="categoria">
                                    <div  id="${categoria.getCodC()}" class="col-md-9 catDiv">Bigetto categoria <b>${categoria.getDescrizione()}</b></div>
                                    <div class="form-group col-md-3">
                                        <select class="form-control" id="sel<%=i%> selectList">
                                            <option>0</option>
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                            <option>5</option>
                                            <option>6</option>
                                            <option>7</option>
                                            <option>8</option>                                                
                                            <option>9</option>
                                            <option>10</option>
                                        </select>
                                    </div>
                                    <%i++;%>
                                </c:forEach>

                            </div>
                        </div>
                    </form>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Annulla</button>
                    <button type="button" class="btn btn-primary" id="addcarrello">Aggiungi al Carrello</button>
                </div>

            </div>
        </div>
    </div>


</div>

<script>
    $('document').ready(function () {

        $('#addcarrello').click(function () {

            var qtys = [];
            var idVisita = "${evento.getIdVisita()}";
            var tipo = "";
            var categoria = [];

    <%
        Visita vs = (Visita) request.getAttribute("evento");
        if (vs.getDataI() == null) {
    %>
            tipo = 0;
    <%
    } else {
    %>
            tipo = 1;
    <%}%>
            var req = "/addgruppobigliettocategoria";

            $('select.form-control :selected').each(function (i) {
                var qty = ($(this).text());
                qtys[i] = qty;
            });

            console.log("qty= " + qtys);
            console.log("idVisita= " + idVisita);

            /*            
             @RequestParam(value = "idVisita", required = true) String idVisita,
             @RequestParam(value = "tipo", required = true) int tipo,
             @RequestParam(value = "categoria", required = true) String categoria,
             @RequestParam(value = "qty", required = true) int qty) {*/


            $('div.catDiv').each(function (i) {
                var cat = $(this).find("b").text();
                categoria[i] = cat;
            });

            console.log("categoria= " + categoria);

            for (var i = 0; i < 5; i++) {
                if (qtys[i] != 0) {

                    console.log("REQUEST ./addgruppobigliettocategoria?qty=" + qtys[i] + "&idVisita=" + idVisita + "&categoria=" + categoria[i] + "&tipo=" + tipo);

                    $.get("./addgruppobigliettocategoria?qty=" + qtys[i] + "&idVisita=" + idVisita + "&categoria=" + categoria[i] + "&tipo=0", function (resp) {
                        console.log(resp);

                    });
                }

            }
            $("#tickets").modal('toggle');

        });




    });

</script>
<jsp:include page="footer.jsp"/>
