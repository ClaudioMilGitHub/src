<%@ page import="org.elis.businesslogic.BusinessLogic" %>
<%@ page import="org.elis.model.Utente" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String email = request.getParameter("emailFormInput");
    String username = request.getParameter("usernameFormInput");
    String password = request.getParameter("passwordFormInput");
    String dataNascita = request.getParameter("dataNascitaFormInput");

    Utente nuovoUtente = BusinessLogic.addUtente(1, username, email, password);  // Ruolo utente fisso a 1

    if (nuovoUtente != null) {
        // Registrazione riuscita
        out.println("<p>Registrazione avvenuta con successo!</p>");
        out.println("<a href='Login.jsp'>Vai al login</a>");
    } else {
        // Errore nella registrazione
        out.println("<p>Errore nella registrazione. Riprova!</p>");
        out.println("<a href='Registrazione.jsp'>Torna alla registrazione</a>");
    }
%>
