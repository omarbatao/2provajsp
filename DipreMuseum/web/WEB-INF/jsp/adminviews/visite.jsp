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
                            <button type="submit" class="btn btn-default">Find</button>
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
                                    
                                    
                                    
                                    <a href="#" class="list-group-item">
                                        <span class="badge">just now</span>
                                        <i class="fa fa-fw fa-calendar"></i> 
                                        <div class ="left">Calendar updated</div>
                                        <div class="right"><button class="btn btn-warning"><i class="fa fa-pencil" aria-hidden="true"></i></button> <button class="btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i></button></div>
                                    </a>
                                    
                                    <a href="#" class="list-group-item">
                                        <span class="badge">4 minutes ago</span>
                                        <i class="fa fa-fw fa-comment"></i> Commented on a post
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">23 minutes ago</span>
                                        <i class="fa fa-fw fa-truck"></i> Order 392 shipped
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">46 minutes ago</span>
                                        <i class="fa fa-fw fa-money"></i> Invoice 653 has been paid
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">1 hour ago</span>
                                        <i class="fa fa-fw fa-user"></i> A new user has been added
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">2 hours ago</span>
                                        <i class="fa fa-fw fa-check"></i> Completed task: "pick up dry cleaning"
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">yesterday</span>
                                        <i class="fa fa-fw fa-globe"></i> Saved the world
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">two days ago</span>
                                        <i class="fa fa-fw fa-check"></i> Completed task: "fix error on sales page"
                                    </a>
                                </div>
                                <div class="text-right">
                                    <a href="#">View All Activity <i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                        </div>


                    </div>
                </div>
            </div>
            <!-- /#wrapper -->

            <jsp:include page="../footer.jsp"/>
