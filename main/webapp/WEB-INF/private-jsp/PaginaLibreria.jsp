<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/Libreria.css">
<title>La Tua Libreria Giochi</title>
</head>
<body>
	<div class="container-fluid min-vh-100 d-flex flex-column">
	<!-- Navbar -->
	<% request.setAttribute("utenteLoggato", utenteLoggato); %>
	<jsp:include page="/includes/navbar.jsp"/>
	
	
	<%for(Libreria l : BusinessLogic.getLibreriaByName(utenteLoggato.getUsername())){ %>
		<div class="card mb-3 flex-grow-1" style="max-width: 1500px; color: gray; background-color: #171a21;">
	  <div class="row flex-grow-1">
	   
	    <div class="col-md-3 flex-grow-1" style="display: flex; justify-content: center; align-items: center;">
	      <img src="<%=l.getGioco().getImagePath() %>" class="img-fluid rounded-start" alt="..." width="300" style="border: 1px solid black; margin:5px;">
	    </div>
	    <div class="col-md-6 flex-grow-1">
	      <div class="card-body">
	        <h3 class="card-title text-primary-emphasis"><%=l.getGioco().getNome()%></h5>
	        <p class="card-text text-info-emphasis"><%=l.getGioco().getDescrizione()%></p>
	        
	      </div>
	    </div>
	    <div class="col-md-3 flex-grow-1">
	      <div class="card-body" style="display: flex; justify-content: center; align-items:center; flex-direction: column;">
	        
	        <p class="card-text text-info-emphasis">Tempo di Gioco: <%=l.getTempoGioco()%></p>
	        <a  href="https://www.youtube.com/watch?v=dQw4w9WgXcQ"><button type="button" class="btn btn-outline-primary" style="margin: 5px;">Gioca</button></a>
	      </div>
	    </div>
	    
	  </div>
	 
	</div>
	 <%} %>
	<!-- Footer -->
        <%@include file="/includes/footer.jsp" %>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>	
</body>
</html>