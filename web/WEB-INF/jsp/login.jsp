<%-- 
    Document   : login
    Created on : 12-mar-2016, 9.26.08
    Author     : FSEVERI\reginato2906
--%>

<%@page import="com.site.Database"%>
<%@page import="Models.WA2P_Utente"%>
<%@page import="java.util.ArrayList"%>
<%
    String userid = request.getParameter("username");    
    String pwd = request.getParameter("password"); 
    Database d= new Database();
    ArrayList<WA2P_Utente> u = d.getUtenti();
    for (WA2P_Utente ut: u){
        if( ut.getNickname().equals(userid) && ut.getPw().equals(pwd)){
           session.setAttribute("userid", userid);
           response.sendRedirect("home.jsp"); 
        }
    }   
     
    out.println("Invalid password <a href='home.jsp'>Login errato</a>");
%>