<%-- 
    Document   : carrello
    Created on : May 2, 2016, 10:33:45 PM
    Author     : Omar
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="models.Biglietto"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="head.jsp"/>

<jsp:include page="menu.jsp"/>
<script>
    function del(n) {
       alert(n);
       $('#'+n+"'").remove();
    }
</script>

<!-- Page Content -->
<div class="container">
    <%!
        public String printrow(int count, Biglietto b, int qty) {

            return "<tr id='row" + count + "'>"
                    + "<td><b>" + b.getIdVisita().getTitolo() + "</b><br/><span style='float:right; cursor: pointer;' class='label label-danger label-as-badge' onclick='del('row"+count+"')'>Rimuovi</span> </td>"
                    + "<td>" + b.getIdVisita().getTariffa() + "</td>"
                    +"<td id='' style='display:none'>"+b.getCategoria().getCodC()+"</td>"
                    + "<td> Categoria <b style='color:green'>" +b.getCategoria().getDescrizione()+"</b> sconto: "+ b.getCategoria().getSconto() + "%</td>"
                    + "<td>" + qty + "</td>"
                    + "</tr>";
        }
        public void eliminaBiglietti(){
            
        }
    %>

    <div class="row">
        <div class="col-md-12">
            <h2 class="title">Carrello</h2>
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
                                        <th>Quantit&agrave;</th>

                                    </tr>
                                </thead>
                                <tbody>


                                    <%

                                        double price = 0.0;
                                        List<Biglietto> biglietti = (List) request.getAttribute("biglietti");

                                        if (biglietti == null) {
                                    %>
                                <td colspan="4" style="text-align:center;">Nessun biglietto nel carrello</td>
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
                                            } else if (bthis.getCategoria().equals(bnext.getCategoria())) {
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
                <div class="panel panel-warning">
                    <div class="panel-heading">Totale provvisorio: </div>
                    <div class="panel-body" style="color:red;text-align: center">
                        EUR <b style="font-size:200%"><%=price%></b>
                    </div>
                    <%
                        if (price == 0.0) {
                    %>
                    <div class="panel-footer "><button type="button" class="btn btn-primary btn-lg btn-block disabled">Acquista</button></div>
                    <%
                    } else {

                    %>
                    <div class="panel-footer "><button type="button" class="btn btn-primary btn-lg btn-block" data-toggle="modal" data-target="#grazie">Acquista</button></div>


                    <%                        }
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

                    <div class="page-header">
                        <h3>Grazie per aver effettuato l'acquisto</h3>
                        <br/>
                        <small>Ti aspettiamo al nostro evento!</small>
                    </div>

                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Ok</button>
                </div>

            </div>
        </div>
    </div>

</div>
<jsp:include page="footer.jsp"/>
