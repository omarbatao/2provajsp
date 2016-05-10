<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="head.jsp"/>

<body>
    <div id="wrapper">
        <jsp:include page="menu.jsp"/>
        <script>
            function del(idvisita) {
                $.ajax({
                    type: "POST",
                    url: "./eliminavisita",
                    data: {idvisita: idvisita},
                    success: function () {
                        window.location.replace("./adminvisits?eliminato=true");
                    },
                    error: function () {
                        window.location.replace("./adminvisits?eliminato=false");
                    }
                });
            }
        </script>
        <div id="page-wrapper" >
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Visits <small>manage visits</small>
                        </h1>
                    </div>
                </div>
            </div>
            <!-- /.row -->

            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <%
                            if (request.getParameter("inseriti") != null) {
                                if (request.getParameter("inseriti").equals("true")) {
                                    out.write(" <div class='alert alert-success' role='alert'>Successfully added visit</div>");
                                }
                            }
                            if (request.getParameter("aggiornato") != null) {
                                if (request.getParameter("aggiornato").equals("true")) {
                                    out.write(" <div class='alert alert-success' role='alert'>Successfully updated visit</div>");
                                }
                            }
                            if (request.getParameter("eliminato") != null) {
                                if (request.getParameter("eliminato").equals("true")) {
                                    out.write(" <div class='alert alert-success' role='alert'>Successfully delited visit</div>");
                                } else {
                                    out.write(" <div class='alert alert-danger' role='alert'>Error visit not delited </div>");
                                }
                            }
                        %>
                    </div>
                </div>


                <div class="row pad">
                    <div class="col-md-12">
                        <form class="form-inline" role="search" action="./cercavisit" method="post">
                            <button type="button" class="btn btn-success" data-toggle='modal' data-target="#inserisci">Add visit</button>
                            <div class="form-group">
                                <input type="text" name="idvisita" class="form-control" placeholder="Find visit by id">
                            </div>
                            <button type="submit" class="btn btn-default">Search</button>
                        </form>
                    </div>
                </div>
                <div class="modal fade" id="inserisci" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">

                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">Add new visit</h4>
                            </div>

                            <div class="modal-body">
                                <form action="./addvisit" method="post">
                                    <div class="form-group">
                                        <label for="idvisita">Visit's id</label>
                                        <input name="idvisita" type="text" class="form-control" id="idvisita" placeholder="Visit's code">
                                    </div>
                                    <div class="form-group">
                                        <label for="titolo">Title</label>
                                        <input name="titolo" type="text" class="form-control" id="titolo" placeholder="Visit's title">
                                    </div>
                                    <div class="form-group">
                                        <label for="desc">Description</label>
                                        <textarea name="desc" type="text" class="form-control" id="desc" placeholder="Visit's description"></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label for="price">Price</label>
                                        <input name="price" type="text" class="form-control" id="price" placeholder="Visit's price">
                                    </div>
                                    <button type="submit" class="btn btn-warning">Add</button>
                                    <button  type="button" class="btn btn-default"  data-dismiss="modal">Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>





                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-list fa-fw"></i> List of visits</h3>
                            </div>
                            <div class="panel-body">
                                <div class="list-group">

                                    <c:forEach  items="${visite}" var="visita">
                                        <a href="#modal${visita.getIdVisita()}" class="list-group-item" data-toggle='modal'>
                                            <!--<span class="badge"><button>ciao</button></span>
                                            <i class="fa fa-fw fa-calendar"></i>
                                            Calendar updated-->
                                            <!--<div class="col-md-3"><button class="btn btn-warning"><i class="fa fa-pencil" aria-hidden="true"></i></button> <button class="btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i></button></div>-->

                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="col-md-9 paddingtop" >
                                                        ${visita.getTitolo()}
                                                    </div>
                                                    <div class="col-md-3 centertext" >
                                                        <div class="btn-group" role="group" >
                                                            <button type="button" class="btn btn-warning" ><i class="fa fa-pencil" aria-hidden="true"></i></button>
                                                            <button type="button" class="btn btn-danger" onclick="del('${visita.getIdVisita()}')"><i class="fa fa-trash" aria-hidden="true"></i></button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                        </a>
                                        <div class="modal fade" id="modal${visita.getIdVisita()}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                            <div class="modal-dialog" role="document">
                                                <div class="modal-content">

                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                        <h4 class="modal-title" id="myModalLabel">visit information</h4>
                                                    </div>

                                                    <div class="modal-body">
                                                        <form action="./modificavisit" method="post">
                                                            <input type="hidden" name="oldidvisita" value="${visita.getIdVisita()}" >
                                                            <div class="form-group">
                                                                <label for="newidvisita">Visit's id</label>
                                                                <input name="newidvisita" type="text" class="form-control" id="newidvisita" value="${visita.getIdVisita()}">
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="titolo">Title</label>
                                                                <input name="titolo" type="text" class="form-control" id="titolo" value="${visita.getTitolo()}">
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="desc">Description</label>
                                                                <textarea name="desc" type="text" class="form-control" id="desc">${visita.getDescrizione()}</textarea>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="price">Price</label>
                                                                <input name="price" type="text" class="form-control" id="price" value="${visita.getTariffa()}">
                                                            </div>
                                                            <button type="submit" class="btn btn-warning">Modify</button>
                                                            <button  type="button" class="btn btn-default"  data-dismiss="modal">Close</button>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="../footer.jsp"/>
