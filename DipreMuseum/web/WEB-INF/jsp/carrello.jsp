<%-- 
    Document   : carrello
    Created on : May 2, 2016, 10:33:45 PM
    Author     : Omar
--%>

<%@page import="models.Servizio"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="models.Biglietto"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="head.jsp"/>

<jsp:include page="menu.jsp"/>
<script>
    /*$(document).ready(function () {
     $("#acquistarichiesta").click(function () {
     alert("cliccato");
     $.post("./bigliettocompra",
     {
     comprabiglietti: true
     }, function (resp) {
     console.log(resp);
     
     }
     );
     });
     });*/


    function del(n, qty) {
        alert(n + " qty: " + qty);
        $('#' + n + "'").remove();
    }

    function invia(categoria, idvisita) {
        console.log("inviato: " + categoria + " " + idvisita);
        $.get("./rimuovibiglietto?categoria=" + categoria + "&idVisita=" + idvisita, function () {
            location.reload();
        });
    }
</script>

<!-- Page Content -->
<div class="container">
    <%!        public String printrow(int count, Biglietto b, int qty) {

            String codC = b.getCategoria().getCodC().toString();

            String idV = b.getIdVisita().getIdVisita();

            List<Servizio> servizi = new ArrayList<Servizio>();
            servizi.addAll(b.getServizioCollection());

            return "<tr id='row" + count + "'>"
                    + "<td><b>" + b.getIdVisita().getTitolo() + "</b><br/><span style='float:right; cursor: pointer;' class='label label-primary label-as-badge'  onclick=invia('" + codC + "','" + idV + "')>Rimuovi</span> </td>"
                    + "<td>" + b.getIdVisita().getTariffa() + "</td>"
                    + "<td id='' style='display:none'>" + b.getCategoria().getCodC() + "</td>"
                    + "<td> Categoria <b style='color:green'>" + b.getCategoria().getDescrizione() + "</b> sconto: " + b.getCategoria().getSconto() + "%</td>"
                    + "<td>" + servizi.get(0).getDescrizione() + "</td>"
                    + "<td>" + qty + "</td>"
                    + "</tr>";
        }

        public void eliminaBiglietti() {

        }
    %>

    <div class="row">
        <div class="col-md-12">
            <h2 class="title">Carrello</h2>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <%
                if (request.getParameter("comprati") != null) {
                    if (request.getParameter("comprati").equals("true")) {

            %>
            <div class="alert alert-success" role="alert">Hai acquistato i biglietti con successo</div>
            <%            } else {
            %>
            <div class="alert alert-danger" role="alert">Operazione non riuscita</div>
            <%
                    }
                }
            %>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">  
            <div class="col-md-9">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"><i class="fa fa-cart-arrow-down"></i> Il tuo carrello </h3>
                    </div>
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th>Evento/Visita</th>
                                        <th>Prezzo</th>
                                        <th>Sconto categoria</th>
                                        <th>Servizio</th>
                                        <th>Quantit&agrave;</th>

                                    </tr>
                                </thead>
                                <tbody>


                                    <%
                                        double price = 0.0;
                                        List<Biglietto> biglietti = (List) request.getAttribute("biglietti");

                                        if (biglietti == null) {
                                    %>
                                <td colspan="5" style="text-align:center;">Nessun biglietto nel carrello</td>
                                <%
                                    } else {
                                        //out.write("<script>alert('"+biglietti.toString()+"')</script>");
                                        int rowcount = 1;
                                        int bperc = 1;
                                        for (int i = 0; i < biglietti.size(); i++) {
                                            Biglietto bthis = biglietti.get(i);
                                            //out.write("<script>alert('"+bthis.getIdVisita().getTitolo()+"')</script>");
                                            if (i + 1 >= biglietti.size()) {
                                                out.write(printrow(rowcount, bthis, bperc));
                                                int sconto = bthis.getCategoria().getSconto();
                                                double tariffa = bthis.getIdVisita().getTariffa().doubleValue();
                                                price += (tariffa * bperc) - (((tariffa * sconto) / 100) * bperc);
                                                break;
                                            }
                                            Biglietto bnext = biglietti.get(i + 1);

                                            if (bnext == null) {
                                                out.write(printrow(rowcount, bthis, bperc));
                                                int sconto = bthis.getCategoria().getSconto();
                                                double tariffa = bthis.getIdVisita().getTariffa().doubleValue();
                                                price += (tariffa * bperc) - (((tariffa * sconto) / 100) * bperc);
                                                break;
                                            } else if (bthis.getCategoria().equals(bnext.getCategoria()) && bthis.getIdVisita().getIdVisita().equals(bnext.getIdVisita().getIdVisita())) {
                                                bperc++;
                                            } else {
                                                out.write(printrow(rowcount, bthis, bperc));
                                                int sconto = bthis.getCategoria().getSconto();
                                                double tariffa = bthis.getIdVisita().getTariffa().doubleValue();
                                                price += (tariffa * bperc) - (((tariffa * sconto) / 100) * bperc);
                                                rowcount++;
                                                bperc = 1;
                                            }
                                        }

                                    }
                                %>
                                </tbody>
                            </table>
                        </div>

                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="panel panel-default">
                    <div class="panel-heading">Totale provvisorio: </div>
                    <div class="panel-body" style="color:red;text-align: center">
                        EUR <b style="font-size:200%"><%
                            String priceFormatted = String.format("%.4g%n", price);
                            out.print(priceFormatted);
                            %></b>
                    </div>
                    <%
                        if (price == 0.0) {
                    %>
                    <div class="panel-footer "><button type="button" class="btn btn-primary btn-lg btn-block disabled">Acquista</button></div>
                    <%
                    } else {

                    %>

                    <div class="panel-footer ">
                        <button id="acquistaactive" type="button" class="btn btn-primary btn-lg btn-block" data-toggle="modal" data-target="#grazie">Acquista</button>
                    </div>

                    <%}
                    %>

                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="grazie" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Grazie</h4>
                </div>

                <div class="modal-body">
                    <h3>Acquistare i biglietti? </h3>

                </div>

                <div class="modal-footer">

                    <form action="./bigliettocompra" method="post">
                        <button  type="button" class="btn btn-danger"  data-dismiss="modal" style="margin:5px">No</button>
                        <input type="hidden" name="comprabiglietti" value =" true"/>
                        <button type="submit" class="btn btn-warning" style="margin:5px">Ok</button>
                    </form>

                </div>

            </div>
        </div>
    </div>

</div>
<jsp:include page="footer.jsp"/>