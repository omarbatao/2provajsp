

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
        <div class="col-md-8">
            <div class="panel panel-default">
                <div class="panel-heading dettagli"><h4>Data Inizio</h4></div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="panel panel-default">
                <div class="panel-heading dettagli"><i class="fa fa-calendar"></i><h4> ${evento.getDataI()}</h4></div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-8">
            <div class="panel panel-default">
                <div class="panel-heading dettagli"><h4>Data Fine</h4></div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="panel panel-default">
                <div class="panel-heading dettagli"><i class="fa fa-calendar"></i><h4> ${evento.getDataF()}</h4></div>
            </div>
        </div>
    </div>
            <div class="row">
        <div class="col-md-8">
            <div class="panel panel-default">
                <div class="panel-heading dettagli"><h4>Prezzo</h4></div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="panel panel-default">
                    <div class="panel-heading dettagli"><i class="fa fa-dollar"></i><h4> ${evento.getTariffa()}</h4></div>
            </div>
        </div>
    </div>

    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading dettagli">
                <h4>Descrizione </h4>
            </div>
            <div class="panel-body">
                <p>${evento.getDescrizione()}</p>
            </div>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">

        <% if (session.getAttribute("username") != null && !session.getAttribute("username").toString().equals("")) {%>
        <div style="text-align:center;margin-top: 2%;bottom:0px;width:100%"> 
            <button style="position:absolute;bottom:0px;width:50%;left: 25%;right: 5%" class="btn btn-success" data-toggle="modal" data-target="#tickets" >Acquista</button>
        </div>



        <%}%>
        <% if (session.getAttribute("username") == null || session.getAttribute("username").toString().equals("")) {%>
        <div style="text-align:center;margin-top: 2%;bottom:0px;width:100%"> 
            <a href="./register"><button class="btn btn-primary" data-toggle="modal" style="width: 30%;">Registrati per Acquistare un biglietto</button></a>
            <b>Oppure</b>
                <a href="./login"><button type="button" class="btn btn-info" style="width: 25%;">Effettua il login</button></a>
        </div>
        <%}%>


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
                                <div  id="${categoria.getCodC()}" class="col-md-6 catDiv">Bigetto categoria <b>${categoria.getDescrizione()}</b></div>
                                <div class="form-group col-md-3">
                                    <select class="form-control qtyselect" id="sel<%=i%> selectList">
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
                                <div class="form-group col-md-3">
                                    <select class="form-control serviziSelect">
                                        <%int primoElemento = 0;%>
                                        <c:forEach items="${servizi}" var="servizio">
                                            <%
                                                if (primoElemento == 0) {
                                                    out.print("<option>Nessuno</option>");
                                                    primoElemento++;
                                                }
                                            %>
                                            <option>${servizio.getDescrizione()}</option>

                                        </c:forEach>

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
            var servizi = [];
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

            $('select.qtyselect :selected').each(function (i) {
                var qty = ($(this).text());
                qtys[i] = qty;
            });

            $('select.serviziSelect :selected').each(function (i) {
                var servizio = ($(this).text());
                servizi[i] = servizio;
            });

            console.log("qty= " + qtys);
            console.log("servizi= " + servizi);
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

                    $.get("./addgruppobigliettocategoria?qty=" + qtys[i] + "&idVisita=" + idVisita + "&categoria=" + categoria[i] + "&tipo=0&servizio=" + servizi[i], function (resp) {
                        console.log(resp);
                    });
                }

            }
            $("#tickets").modal('toggle');

        });







    });

</script>
<jsp:include page="footer.jsp"/>
