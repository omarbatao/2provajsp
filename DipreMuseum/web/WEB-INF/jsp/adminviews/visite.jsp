<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../head.jsp"/>

<body>
    <div id="wrapper">
        <jsp:include page="menu.jsp"/>
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
                <div class="row pad">
                    <div class="col-md-12">
                        <form class="form-inline" role="search">
                             <button type="button" class="btn btn-success">Add visit</button>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Find Visit">
                            </div>
                            <button type="submit" class="btn btn-default">Search</button>
                        </form>
                    </div>  
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-list fa-fw"></i> List of visit</h3>
                            </div>
                            <div class="panel-body">
                                <div class="list-group">
                                    <c:forEach  items="${visite}" var="visita">
                                        <a href="#" class="list-group-item" >
                                        <!--<span class="badge"><button>ciao</button></span>
                                        <i class="fa fa-fw fa-calendar"></i> 
                                        Calendar updated-->
                                        <!--<div class="col-md-3"><button class="btn btn-warning"><i class="fa fa-pencil" aria-hidden="true"></i></button> <button class="btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i></button></div>-->
                                        <div class="container">
                                            <div class="row">
                                                <div class="col-md-12"> 
                                                    <div class="col-md-9 paddingtop" >
                                                        ${visita.getTitolo()}
                                                    </div>
                                                    <div class="col-md-3 centertext" >
                                                        <button class="btn btn-warning"><i class="fa fa-pencil" aria-hidden="true"></i></button> <button class="btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i></button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                    </c:forEach>
                                </div>
                               
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /#wrapper -->
        </div>
            <jsp:include page="../footer.jsp"/>
