<%-- 
    Document   : Artisti
    Created on : 7-mag-2016, 10.49.26
    Author     : FSEVERI\reginato2906
--%>

<!DOCTYPE html>
<html lang="en">
   <!-- Navigation -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
            <jsp:include page="head.jsp"/>
            <title>Artisti</title>
    </head>
    <body>     
    <jsp:include page="menu.jsp"/>

    <!-- Page Content -->
    <div class="container">

        <!-- Page Heading/Breadcrumbs -->
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">Artisti</h2>
            </div>
        </div>
        
        
        <!-- Service Panels -->
        <!-- The circle icons use Font Awesome's stacked icon classes. For more information, visit http://fontawesome.io/examples/ -->
        <div class="row">
            <c:forEach items="${servizi}" var="servizio">
                <div class="col-md-3 col-sm-6" style="height: 550px;">
                    <div class="panel panel-default text-center" style="height: 100%;">
                        <div class="panel-heading">
                            <span class="fa-stack fa-5x">
                                  <i class="fa fa-circle fa-stack-2x text-primary"></i>
                                  <i class="fa fa-${servizio.getImmagine()} fa-stack-1x fa-inverse"></i>
                            </span>
                        </div>
                        <div class="panel-body">
                            <h3>${servizio.getTitolo()}</h3>
                            <p>${servizio.getDescrizione()}</p>
                            <p>Prezzo: ${servizio.getPrezzo()} &euro;</p>
                        </div>
                    </div>
                </div>
             </c:forEach>
            
        </div>

     <jsp:include page="footer.jsp"/>

</body>

</html>

                