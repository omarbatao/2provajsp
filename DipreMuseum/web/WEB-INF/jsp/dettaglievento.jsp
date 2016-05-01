

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

                <!-- controllare se l'utente e' loggato o no -->
                <button class="col-md-12 btn btn-success" data-toggle="modal" data-target="#tickets" >Acquista</button>
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
                        <div class="form-group">
                             <div class="row" >
                                <div class="col-md-12" >
                                    <div class="col-md-4 headstyle"><b>Numero Biglietti</b></div>
                                    <div class="col-md-4 headstyle" ><b>Categoria Biglietto</b></div>
                                    <div class="col-md-4 headstyle " ><b>Aggiungi Biglietto</b></div>      
                                </div> 
                            </div> 
                            
                            
                            <div class="row" >
                                <div class="col-md-12">
                                    <div  class="col-md-4" style="text-align: center">1</div>
                                    <div class="col-md-4">
                                        <div class="form-group" id="categorie">
                                            <select class="form-control" id="sel">
                                                <c:forEach items="${categorie}" var="categoria">   
                                                    <option>${categoria.getDescrizione()}</option>
                                                </c:forEach>    
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-md-4 " style="text-align: center"><button type="button" class="btn btn-info" onclick="addRow('tickettable')"><span class="glyphicon glyphicon-plus"></span></button></div>
                                   
                                </div> 
                            </div>  
                            
                        </div>


                    </form>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Annulla</button>
                    <button type="button" class="btn btn-primary">Compra</button>
                </div>
            </div>
        </div>
    </div>

</div>

<jsp:include page="footer.jsp"/>
