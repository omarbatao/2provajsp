<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./layout/head.jsp"/>
<jsp:include page="./layout/menu.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="page-header">
                <h1>${evento.getTitolo()} <small>${evento.getData()} ${evento.getLuogo().getNomeProvincia()}</small></h1>
            </div>
        </div>
    </div>
    
    <div class="row">
        <div class="col-md-12">
            <div class="page-header">
                <h1>${evento.getTitolo()} <small>${evento.getData()} ${evento.getLuogo().getNomeProvincia()}</small></h1>
            </div>
        </div>
    </div>        
            
</div>



<jsp:include page="./layout/foot.jsp"/>