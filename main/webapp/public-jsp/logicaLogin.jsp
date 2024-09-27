<%@ page import="org.elis.businesslogic.BusinessLogic" %>
<%@ page import="org.elis.model.Utente" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String email = request.getParameter("emailLogin");
    String password = request.getParameter("passwordLogin");

    Utente utente = BusinessLogic.getUtenteByName(email);

    if (utente != null && utente.getPassword().equals(password)) {
        // Login riuscito
        session.setAttribute("utenteLoggato", utente);
        response.sendRedirect("Home.jsp");
    } else {
        // Login fallito
        out.println("<p>Email o password errati!</p>");
        out.println("<a href='Login.jsp'>Riprova</a>");
    }
%>
