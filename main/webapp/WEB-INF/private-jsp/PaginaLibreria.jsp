<%@page import="org.elis.model.Utente"%>
<%@page import="org.elis.model.Libreria"%>
<%@page import="org.elis.businesslogic.BusinessLogic"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%Utente utenteLoggato = (Utente) session.getAttribute("utenteLoggato");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/PaginaLibreria.css">
<title>La Tua Libreria Giochi</title>
</head>
<body>
	<div class="container-fluid min-vh-100 d-flex flex-column">
	<!-- Navbar -->
	<% request.setAttribute("utenteLoggato", utenteLoggato); %>
	<jsp:include page="/includes/navbar.jsp"/>
	
    <div class="card mb-3" style="max-width: 540px;">
        <div class="row g-0">
            <%for(Libreria l : BusinessLogic.getLibreriaByName(utenteLoggato.getUsername())){ %>
          <div class="col-md-4">
            <img src="<%=l.getGioco().getImagePath() %>" class="img-fluid rounded-start" alt="..." width="300">
          </div>
          <div class="col-md-8">
            <div class="card-body">
              <h5 class="card-title"><%=l.getGioco().getNome()%></h5>
              <p class="card-text"><%=l.getGioco().getDescrizione()%></p>
              <a href="https://www.youtube.com/watch?v=dQw4w9WgXcQ"><button type="button" style="display: flex; justify-content: center;color: white;">Gioca</button></a>
            </div>
            
          </div>
          <%} %>
        </div>
      </div>
	
	<!-- Footer -->
        <%@include file="/includes/footer.jsp" %>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>	
</body>
</html>