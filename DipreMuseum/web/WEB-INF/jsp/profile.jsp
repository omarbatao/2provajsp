

<%@page import="models.CartaDiCredito"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Biglietto"%>
<%@page import="models.Servizio"%>
<%@page import="java.util.Calendar"%>
<%@page import="models.Visitatore"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="head.jsp"/>

<jsp:include page="menu.jsp"/>


<body>

    <div class="container">
        <div class="row" style='margin-top:50px'>
            <div class="col-lg-12">
                <div class="col-md-6">
                    <form class="form-horizontal" action='./update' method="POST">
                        <fieldset>
                            <div id="legend">
                                <legend class="">Profilo </legend>
                            </div>
                            <label style="color:#999999">Carta di credito: 
                                <c:if test="${fn:length(carte) gt 0}">
                                    ${carte.get(0).getCodC()}</c:if> 
                                <c:if test="${fn:length(carte) eq 0}">
                                    Nessuna Carta</c:if> 
                            </label>
                                <div class="control-group">
                                    <!-- Username -->
                                    <label class="control-label"  for="name">Nome</label>
                                    <div class="controls">
                                        <input type="text" id="username" name="nome" value="${profilo.getNome()}" class="input-xlarge">
                                </div>
                            </div>
                            <div class="control-group">
                                <!-- Username -->
                                <label class="control-label"  for="surname">Cognome</label>
                                <div class="controls">
                                    <input type="text" id="username" name="cognome" value="${profilo.getCognome()}" class="input-xlarge">
                                </div>
                            </div>
                            <div class="control-group">
                                <!-- Username -->
                                <label class="control-label"  for="date">Data di nascita</label>
                                <div class="controls">
                                    <input type="text" id="datepicker" name="dataN">
                                </div>
                            </div>
                            <div class="control-group">
                                <!-- Username -->
                                <label class="control-label"  for="username">Username</label>
                                <div class="controls">
                                    <input type="text" id="username" name="username" value="${profilo.getUsername()}" class="input-xlarge">
                                </div>
                            </div>

                            <div class="control-group">
                                <!-- Password-->
                                <label class="control-label" for="password">Password</label>
                                <div class="controls">
                                    <input type="password" id="password" name="password" value="${profilo.getPassword()}" class="input-xlarge">
                                </div>
                            </div>

                            <div class="control-group">
                                <!-- Button -->
                                <div class="controls">
                                    <br>
                                    <button class="btn btn-success" style="margin-bottom:30px">Aggiorna</button>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
                <div class="col-md-6">
                    <div id="legend">
                        <legend>I Tuoi Biglietti</legend>
                    </div>

                    <c:if test="${empty biglietti}">
                        <td colspan="4" style="text-align:center;">
                            Non hai nessun biglietto
                        </td>
                    </c:if>
                    <c:forEach items="${biglietti}" var="biglietto">

                        <div class="panel panel-body panel-default" style="position:relative">
                            <label class="control-label"  for="username">Biglietto cod#${biglietto.getCodB()} <div style="display:inline-block;position:absolute;right:10px;top:10px"> Validità : ${biglietto.getValidita()}</div></label>
                            <div style="position:relative">
                                <p>Nome Visita:<b> ${biglietto.getIdVisita().getTitolo()}</b></p>

                                <%

                                    Biglietto b = (Biglietto) pageContext.findAttribute("biglietto");
                                    List<Servizio> servizi = new ArrayList<Servizio>();
                                    servizi.addAll(b.getServizioCollection());
                                    request.setAttribute("servizi", servizi);
                                %>

                                <p>
                                    Categoria:  <b style="margin-right: 10px">${biglietto.getCategoria().getDescrizione()}</b>
                                    <c:if test="${fn:length(servizi) gt 0}">
                                        Servizio: <b>${servizi.get(0).getDescrizione()}</b>
                                    </c:if>
                                </p>
                                <p> ${biglietto.getIdVisita().getDescrizione()}</p>
                                <a  href="./evento?id=${biglietto.getIdVisita().getIdVisita()}">  <button class="btn btn-default" >info sulla visita</button></a>
                            </div>
                        </div>
                    </c:forEach>

                </div>

            </div>

        </div>
    </div>

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
</body>

<script>
    $(function () {
        $("#datepicker").datepicker({
            changeMonth: true,
            changeYear: true,
            showButtonPanel: true,
            yearRange: '1910:2016'

        });

    <%
        Visitatore vis = (Visitatore) request.getAttribute("profilo");
        Date data = vis.getDataN();
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

    %>
        $('#datepicker').datepicker("setDate", new Date(<%=year%>,<%=month%>,<%=day%>));
    });
</script>
<jsp:include page="footer.jsp"/>


<link rel="stylesheet" href="./resources/css/plugins/jquery_ui/jquery-ui.min.css"/>

