<%@page import="Models.Commento"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../layout/head.jsp"/>
<jsp:include page="../layout/menu.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="page-header">
                <h1>${evento.getTitolo()} <small>${evento.getData()} ${evento.getLuogo().getNomeProvincia()}</small></h1>
            </div>
        </div>
    </div>



    <!-- Comments Form -->
    <div class="well">
        <h4>Leave a Comment:</h4>
        <form role="form">
            <div class="form-group">
                <textarea class="form-control" rows="3"></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>

    <hr>

    <!-- Posted Comments -->
    <%!
        public String printrow(int voto){
            String s ="";
            for(int i=0;i<5;i++){
                if(i<voto){
                    s+="<span class='glyphicon glyphicon-star' aria-hidden='true'></span>";
                }else{
                    s+="<span class='glyphicon glyphicon-star-empty' aria-hidden='true'></span>";
                }
                
            }
            
            return s;
        }
    %>
    
    
    
    <!-- Comment -->
    <div class="row">
        <div class="media">
            <c:forEach items="${commenti}" var="commento"> 
                <div class="col-md-12">
                    <div class="media-body">
                        <c:if test="${commento.getVoto()<3 }">
                            <div class="panel panel-danger">
                                <div class="panel-heading">
                                    <div class="row">
                                        <div id="user" class="col-md-10">
                                            ${commento.getIdU().getNickname()}
                                        </div>
                                        <div id="voto" class="col-md-2">
                                             Voto: 
                                            <% 
                                                 Commento c = (Commento)pageContext.getAttribute("commento");
                                                 out.print(printrow(c.getVoto())); 
                                             %>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel-body"> ${commento.getCommento()}</div>
                            </div>
                        </c:if>
                        <c:if test="${commento.getVoto() ==3 }">
                            <div class="panel panel-warning">
                                <div class="panel-heading">
                                    <div class="row">
                                        <div id="user" class="col-md-10">
                                            ${commento.getIdU().getNickname()}
                                        </div>
                                        <div id="voto" class="col-md-2">
                                             Voto: 
                                            <% 
                                                 Commento a = (Commento)pageContext.getAttribute("commento");
                                                 out.print(printrow(a.getVoto())); 
                                             %>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel-body"> ${commento.getCommento()}</div>
                            </div>
                        </c:if>
                        <c:if test="${commento.getVoto() >3 }">
                            <div class="panel panel-success">
                                <div class="panel-heading">
                                    <div class="row">
                                        <div id="user" class="col-md-10">
                                            ${commento.getIdU().getNickname()}
                                        </div>
                                        <div id="voto" class="col-md-2">
                                            Voto:
                                             <% 
                                                 Commento b = (Commento)pageContext.getAttribute("commento");
                                                 out.print(printrow(b.getVoto())); 
                                             %>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel-body"> ${commento.getCommento()}</div>
                            </div>
                        </c:if>  
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

</div>



<jsp:include page="../layout/foot.jsp"/>