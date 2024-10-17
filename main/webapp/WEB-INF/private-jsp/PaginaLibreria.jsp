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
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid min-vh-100 d-flex flex-column">
	<!-- Navbar -->
	<% request.setAttribute("utenteLoggato", utenteLoggato); %>
	<jsp:include page="/includes/navbar.jsp"/>
	
	
		<div class="row flex-grow-1">
			<div class="col lg-6">
				<%for(Libreria l : BusinessLogic.getLibreriaByName(utenteLoggato.getUsername())){ %>
				<div class="row flex-grow-1" style="margin: 10px;">
					<div class="col lg-4">
					
						<img src="<%=l.getGioco().getImagePath() %>" width="300">
					</div>
					<div class="col lg-4">
						<h1 style="color: black;"><%=l.getGioco().getNome()%></h1>
					</div>
					<div class="col lg-4">
						<h1 style="color: black;"><%=l.getGioco().getDescrizione()%></h1>
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