<jsp:include page="include.jsp"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="Models.Utente" scope="session" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./resources/css/style.css" />
        <link href="./resources/css/bootstrap.min.css" rel="stylesheet">
        <link href="./resources/css/blog-home.css" rel="stylesheet">
        <script src="./resources/js/jquery.js"></script>
        <script src="./resources/js/bootstrap.min.js"></script>
        <title >${titolopagina}</title>
    </head>
    <body>
