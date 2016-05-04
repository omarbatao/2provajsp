

<%@page import="java.util.Calendar"%>
<%@page import="javafx.scene.chart.PieChart.Data"%>
<%@page import="models.Visitatore"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="head.jsp"/>

<jsp:include page="menu.jsp"/>


<body>

    <div class="container">
        <div class="row" style='margin-top:50px'>
            <div class="col-lg-12">
                <form class="form-horizontal" action='./update' method="POST">
                    <fieldset>
                        <div id="legend">
                            <legend class="">Profilo</legend>
                        </div>

                        <div class="control-group">
                            <!-- Username -->
                            <label class="control-label"  for="name">Nome</label>
                            <div class="controls">
                                <input type="text" id="username" name="nome" value="${profilo.getNome()}" class="input-xlarge">
                                <p class="help-block">Username can contain any letters or numbers, without spaces</p>
                            </div>
                        </div>
                        <div class="control-group">
                            <!-- Username -->
                            <label class="control-label"  for="surname">Cognome</label>
                            <div class="controls">
                                <input type="text" id="username" name="cognome" value="${profilo.getCognome()}" class="input-xlarge">
                                <p class="help-block">Username can contain any letters or numbers, without spaces</p>
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
                                <p class="help-block">Username can contain any letters or numbers, without spaces</p>
                            </div>
                        </div>

                        <div class="control-group">
                            <!-- Password-->
                            <label class="control-label" for="password">Password</label>
                            <div class="controls">
                                <input type="password" id="password" name="password" value="${profilo.getPassword()}" class="input-xlarge">
                                <p class="help-block">Password should be at least 4 characters</p>
                            </div>
                        </div>

                        <div class="control-group">
                            <!-- Button -->
                            <div class="controls">
                                <button class="btn btn-success">Aggiorna</button>
                            </div>
                        </div>
                    </fieldset>
                </form>

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

