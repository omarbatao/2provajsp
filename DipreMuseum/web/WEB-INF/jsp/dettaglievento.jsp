

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
                <button style="margin-top:47% " class="col-md-12 btn btn-success" data-toggle="modal" data-target="#tickets" >Acquista</button>
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
                                        <div  id="${categoria.getCodC()}" class="col-md-9">Bigetto categoria <b>${categoria.getDescrizione()}</b></div>
                                        <div class="form-group col-md-3">
                                            <select class="form-control" id="sel<%=i%>">
                                                <option value="" selected>0</option>
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
                                </form
                            </div>
                        </div>
                    </form>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Annulla</button>
                    <button type="button" class="btn btn-primary" onclick="addToCart()">Aggiungi al Carrello</button>
                </div>
                                    <script>
                                        function addToCart(){
                        var numcat = <%=i%>;
                        var idvisita = "${evento.getIdVisita()}";
                        for(var i=0;i<numcat;i++){
                            var categoria = "${categorie.get(i).getCodC}";
                            var numero = document.getElementById("sel"+i).innerHTML;
                            //salvare su sessioni
                            alert(idVisita+" "+categoria+" "+numero);
                        }
                    }
                                    </script>
                                    
            </div>
        </div>
    </div>

</div>

<jsp:include page="footer.jsp"/>
