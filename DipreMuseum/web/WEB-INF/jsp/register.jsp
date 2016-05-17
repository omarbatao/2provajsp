

<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="head.jsp"/>

<jsp:include page="menu.jsp"/>

<% if (session.getAttribute("username") != null && !session.getAttribute("username").toString().equals("")) {%>
<c:redirect url="./"/>                
<%}%>
<body>

    <div class="container">
        <div class="row" style='margin-top:50px'>
            <div class="col-lg-12">
                <form class="form-horizontal" action='./register' method="POST">

                    <div id="legend">
                        <legend class="">Register</legend>
                    </div>

                    <div class="control-group">
                        <!-- Username -->
                        <label class="control-label"  for="name">Nome</label>
                        <div class="controls">
                            <input type="text" id="username" name="nome" placeholder="Nome" class="input-xlarge">
                        </div>
                    </div>
                    <div class="control-group">
                        <!-- Username -->
                        <label class="control-label"  for="surname">Cognome</label>
                        <div class="controls">
                            <input type="text" id="username" name="cognome" placeholder="Cognome" class="input-xlarge">
                        </div>
                    </div>
                    <div class="control-group">
                        <!-- Username -->
                        <label class="control-label"  for="date">Data di nascita</label>
                        <div class="controls">
                            <input type="text" id="datepicker" placeholder="Data di nascita" name="dataN">
                        </div>
                    </div>
                    <div class="control-group">
                        <!-- Username -->
                        <label class="control-label"  for="username">Username</label>
                        <div class="controls">
                            <input type="text" id="username" name="username" placeholder="Username" class="input-xlarge">
                        </div>
                    </div>

                    <div class="control-group">
                        <!-- Password-->
                        <label class="control-label" for="password">Password</label>
                        <div class="controls">
                            <input type="password" id="password" name="password" placeholder="Password" class="input-xlarge">
                        </div>
                    </div>

                    <div class="control-group">
                        <!-- Password-->
                        <label class="control-label" for="codcarta">Carta di credito</label>
                        <div class="controls">
                            <input type="text" maxLength="16" name="cartacredito" placeholder="Carta di credito" class="input-xlarge">
                        </div>
                    </div>
                    <div class="control-group">
                        <!-- Username -->
                        <label class="control-label"  for="date">Data scadenza carta</label>
                        <div class="controls">
                            <input type="text" id="datepickercarta" placeholder="Data scadenza carta" name="dataS">
                        </div>
                    </div>
                    <div class="control-group">
                        <!-- Username -->
                        <label class="control-label"  for="date">Pin carta</label>
                        <div class="controls">
                            <input type="password" maxlength="4"   placeholder="Pin carta" id="datepickercarta" name="pin">
                        </div>
                    </div>

                    <div class="control-group">
                        <%
                            if (request.getParameter("exists") != null && request.getParameter("exists").equals("true")) {
                                out.print("<h4 style='text-align:left;color:red'>Lo username non è disponibile</h4>");
                            }
                            if (request.getParameter("fields") != null && request.getParameter("fields").equals("true")) {
                                out.print("<h4 style='text-align:left;color:red'>Devi riempire tutti i campi</h4>");
                            }

                        %>
                        <!-- Button -->
                        <div class="controls">
                             <br>
                            <button class="btn btn-success">Register</button>
                        </div>
                    </div>

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
        $("#datepickercarta").datepicker({
            changeMonth: true,
            changeYear: true,
            showButtonPanel: true,
            yearRange: '2016:2050'

        });
    });
</script>
<jsp:include page="footer.jsp"/>




