<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="head.jsp"/>

<jsp:include page="menu.jsp"/>


<!-- Page Content -->
<div class="container">

    <!-- Marketing Icons Section -->
    <div class="row">
        <div class="col-lg-12 ">
            <div class="page-header">
                <h1 class="titoloevento">
                    Eventi
                </h1>
                <div class="text-right">
                    <input id="ricercaevento" type="cerca" name="search" placeholder="Cerca evento.." onkeyup="cerca()">
                </div>
                <div class="contenitore">
                    <div id="test"></div>
                    <div style="margin-top: 5px"  id="elenco">
                        <ul id="eve" class="list-group over" style="list-style-type: none;"></ul>
                    </div>
                </div>

                <!--<i class="fa fa-search cursore"  aria-hidden="true" data-toggle="modal" data-target="#cerca"></i>-->
            </div> 
        </div>
    </div>




    <!-- /.row -->
    <!-- Features Section -->
    <div class="row test">
        <c:forEach items="${eventi}" var="evento">
            <div class="col-md-6" >
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
</div>

<script>

    function cerca() {
        var titolo = document.getElementById("ricercaevento").value;
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

    function add(r, id) {
        $('#elenco ul').empty();
        for (var i = 0; i < r.length; i++) {

            $("#elenco ul").append("<li  class='list-group-item cursore'  ><a href='./evento?id=" + id[i] + "' >" + r[i] + '</a></li>');
        }
    }






</script>

<jsp:include page="contatti.jsp"/>
<jsp:include page="footer.jsp"/>
