<%-- 
    Document   : home
    Created on : 23-feb-2016, 9.46.48
    Author     : FSEVERI\ceretta2991
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./layout/head.jsp"/>
<jsp:include page="./layout/menu.jsp"/>



<!-- Page Content -->
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <%
                if (request.getParameter("error") != null) {
                    if (request.getParameter("error").equals("true")) {
                        if (request.getParameter("alreadylogged")!=null&&request.getParameter("alreadylogged").equals("true")) out.write("<div class='alert alert-info' role='alert'>Hai gi&agrave; effettuato l&#96; accesso</div>");      
                        if (request.getParameter("nomach")!=null&&request.getParameter("nomach").equals("true")) out.write("<div class='alert alert-danger' role='alert'>Utente inesistente</div>");          
                        if (request.getParameter("errpw")!=null&&request.getParameter("errpw").equals("true")) out.write("<div class='alert alert-danger' role='alert'>Password non valida</div>");      
                    }else{
                        if (request.getParameter("logged")!=null&&request.getParameter("logged").equals("true")) out.write("<div class='alert alert-success' role='alert'>Benvenuto!</div>");      
                    }
                }    
            %>
        </div>
    </div>     
    <div class="row">

        <!-- Blog Entries Column -->
        <div class="col-md-8">

            <h1 class="page-header">
                Events
                <small></small>
            </h1>

            <!-- First Blog Post -->
            <c:forEach items="${eventi}" var = "evento">
                <h2>
                    <a href="#">${evento.getTitolo()}</a>
                </h2>
                <p class="lead">
                    by ${evento.getIdU().getNickname()}
                </p>
                <p><span class="glyphicon glyphicon-time"></span> ${evento.getData()} ${evento.getLuogo().getNomeProvincia()}</p>
                <hr>
                <img style="height: 300px; width: 900px;" class="img-responsive img-related" src="${evento.getImmagine()}" alt="">
                <hr>
                <p>${evento.getDescrizione()} </p>
                <a class="btn btn-primary" href="./infoevento?eventoid=${evento.getId()}">Read More <span class="glyphicon glyphicon-chevron-right"></span></a>

                <hr>
            </c:forEach>

            <!-- Pager -->
            <ul class="pager">
                <li class="previous">
                    <a href="#">&larr; Older</a>
                </li>
                <li class="next">
                    <a href="#">Newer &rarr;</a>
                </li>
            </ul>

        </div>
       <script>

    function cerca() {
        var titolo = document.getElementById("ricercaevento").value;
        
        if(titolo==="") {
            pulisci();
            return;
        }
        var request = new XMLHttpRequest();
        var url = "./cercaevento?titoloevento=" + titolo;
        request.onreadystatechange = function () {
            showresults(request);
        };
        request.open("GET", url, true);
        request.send();
    }


    function showresults(val) {
        var resultstit = [];
        var resultsid = [];
        if ((val.readyState == 4) && (val.status == 200)) {
            if (val.responseText == "errore")
                resultstit.push("errore");
            else {
                val = $.parseXML(val.responseText)
                $xml = $(val);
                $($xml).find("evento").each(function (idx, v) {
                    resultstit[idx] = [];
                    resultsid[idx] = [];
                    $(v).find("id").each(function (i, vi) {
                        resultsid[idx].push($(vi).text());
                    });
                    $(v).find("titolo").each(function (i, vi) {
                        resultstit[idx].push($(vi).text());
                    });
                });

                add(resultstit, resultsid);
            }
        }
    }
    
    function pulisci(){
        $('#elenco ul').empty();
    }

    function add(r, id) {
        $('#elenco ul').empty();
        for (var i = 0; i < r.length; i++) {

            $("#elenco ul").append("<li  class='list-group-item cursore'  ><a href='./infoevento?eventoid=" + id[i] + "' >" + r[i] + '</a></li>');
        }
    }

</script> 

        <!-- Blog Sidebar Widgets Column -->
        <div class="col-md-4">

            <!-- Blog Search Well -->
            <div class="well">
                <h4>Search events</h4>
                <div class="input-group">
                    <input id="ricercaevento" type="cerca" placeholder="Find your events...." onkeyup="cerca()" class="form-control">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button">
                            <span class="glyphicon glyphicon-search"></span>
                        </button>
                    </span>
                </div>
                <div class="contenitore">
                    <div style="margin-top: 5px"  id="elenco">
                        <ul id="eve" class="list-group over" style="list-style-type: none;"></ul>
                    </div>
                </div>
                <!-- /.input-group -->
            </div>

            <!-- Blog Categories Well -->
            <div class="well">
                <h4>Blog Categories</h4>
                <div class="row">
                    <div class="col-lg-6">
                        <ul class="list-unstyled">
                            <c:forEach items="${categorie}" var = "categoria">
                                    <li><a href="#">${categoria.getNome()}</a></li>                                     
                                </c:forEach>
                        </ul>
                    </div>

                </div>
                <!-- /.row -->
            </div>

            <div class="well">
                    <h4>Aggiungi Evento</h4>
                    <hr>
                    <button type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target="#formevento">Aggiungi</button>
                <div class="modal fade" id="formevento" role="dialog">
                    <div class="modal-dialog">
                
                    <!-- Contenuto modal -->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Aggiungi evento:</h4>
                        </div>
                        <div class="modal-body">
                        <form >
                            <label for="id">Id</label>
                            <input type="text" class="form-control" id="Id evento">
                
                            <label for="evento">Titolo evento</label>
                            <input type="text" class="form-control" id="Titolo evento">
                
                            <label for="luogo">Luogo</label>
                            <input type="text" class="form-control" id="Luogo">
                
                            <label for="data">Data evento</label>
                            <input type="date" class="form-control" id="Data evento">
                
                            <label for="idU">Id Utente</label>
                            <input type="text" class="form-control" id="Id Utente">
                
                            <label for="categoria">Categoria</label>
                            <input type="text" class="form-control" id="Categoria">
                        </form>          
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary btn-block" data-dismiss="modal">Aggiungi</button>
                    </div>
                    </div>
                </div>
            </div>               
                        <!-- /.col-lg-6 -->
                    
                    <!-- /.row -->
                </div>
            <!-- Side Widget Well -->
            <!--<div class="well">
                <h4>Side Widget Well</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore, perspiciatis adipisci accusamus laudantium odit aliquam repellat tempore quos aspernatur vero.</p>
            </div>-->

        </div>

    </div>
    <!-- /.row -->

    <hr>



</div>
<!-- Footer -->


<jsp:include page="./layout/foot.jsp"/>
