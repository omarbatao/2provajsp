<%
    session.invalidate();
    String location = "/SecondaProvaWebApp";
    response.sendRedirect(location);
%>