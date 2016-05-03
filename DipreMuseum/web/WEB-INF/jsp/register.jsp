

<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="head.jsp"/>

<jsp:include page="menu.jsp"/>


<body>

    <div class="container">
        <div class="row" style='margin-top:50px'>
            <div class="col-lg-12">
                <form class="form-horizontal" action='./register' method="POST">
                    <fieldset>
                        <div id="legend">
                            <legend class="">Register</legend>
                        </div>

                        <div class="control-group">
                            <!-- Username -->
                            <label class="control-label"  for="name">Nome</label>
                            <div class="controls">
                                <input type="text" id="username" name="nome" placeholder="" class="input-xlarge">
                                <p class="help-block">Username can contain any letters or numbers, without spaces</p>
                            </div>
                        </div>
                        <div class="control-group">
                            <!-- Username -->
                            <label class="control-label"  for="surname">Cognome</label>
                            <div class="controls">
                                <input type="text" id="username" name="cognome" placeholder="" class="input-xlarge">
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
                                <input type="text" id="username" name="username" placeholder="" class="input-xlarge">
                                <p class="help-block">Username can contain any letters or numbers, without spaces</p>
                            </div>
                        </div>

                        <div class="control-group">
                            <!-- Password-->
                            <label class="control-label" for="password">Password</label>
                            <div class="controls">
                                <input type="password" id="password" name="password" placeholder="" class="input-xlarge">
                                <p class="help-block">Password should be at least 4 characters</p>
                            </div>
                        </div>

                        <div class="control-group">
                            <%
                            if(request.getParameter("exists")!=null && request.getParameter("exists").equals("true"))
            out.print("<h4 style='text-align:left;color:red'>Lo username non è disponibile</h4>");
                               if(request.getParameter("fields")!=null && request.getParameter("fields").equals("true"))
            out.print("<h4 style='text-align:left;color:red'>Devi riempire tutti i campi</h4>");
                            
                            %>
                            <!-- Button -->
                            <div class="controls">
                                <button class="btn btn-success">Register</button>
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
    });
</script>
<jsp:include page="footer.jsp"/>


<link rel="stylesheet" href="./resources/css/plugins/jquery_ui/jquery-ui.min.css"/>

