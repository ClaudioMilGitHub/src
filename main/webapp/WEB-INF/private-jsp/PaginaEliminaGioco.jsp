<%@page import="org.elis.businesslogic.BusinessLogic"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.elis.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Pagina Elimina Gioco</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/PaginaEliminaGioco.css">

</head>
<body>

	<%Utente utenteLoggato = (Utente) session.getAttribute("utenteLoggato");%>
	<%List<Gioco> listaGiochi = new ArrayList<>();%>
	<%if(utenteLoggato.getRuolo().name() == "PUBLISHER"){
		listaGiochi = BusinessLogic.getGiochiByUtente(utenteLoggato); 
	}%>
	
	<%if(utenteLoggato.getRuolo().name() == "ADMIN"){
		listaGiochi = BusinessLogic.getAllGiochi();
	}%>
	
	<div class="container-fluid min-vh-100 d-flex flex-column">


		<!--  Navbar -->
		<% request.setAttribute("utenteLoggato", utenteLoggato); %>
		<jsp:include page="/includes/navbar.jsp" />

	

	<div class="row flex-grow-1">
		<div class="col-lg-12">				
					<div class="list-group">
					<%if(!listaGiochi.isEmpty()){ %>
						<%for(int i=0; i< listaGiochi.size(); i++) {%>
						  
						  <button style="border: 2px solid;" type="button" class="list-group-item list-group-item-action d-flex mb-3 bg-dark text-dander-emphasis" value = "<%=listaGiochi.get(i).getNome() %>">
								<div class="d-flex justify-content-between align-items-center">
								        <div>
								            <span class="fw-bold me-3 text-warning-emphasis">ID: <%=listaGiochi.get(i).getId()%></span>
								            <span class="me-3 text-info-emphasis">Titolo: <span class="text-warning-emphasis"><%=listaGiochi.get(i).getNome()%></span></span>
								        </div>
								        <span class="text-muted text-info-emphasis">Data Creazione: <%=listaGiochi.get(i).getDataCreazione()%></span>
								 </div>
							</button>

						<%}
						} else {%>
							<h2 class = "text-center fw-bold" style = "color:white;">Nessun gioco da eliminare</h2>
						<%} %>
						 
					</div>
		</div>
	</div>


	<!-- Footer -->
	<%@include file="/includes/footer.jsp"%>
	
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
		integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
		crossorigin="anonymous"></script>
		
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
	
	$(document).ready(function() {

		const contextPath = '${pageContext.request.contextPath}';
			
	    $('.list-group-item').click(function() {
	        var gameName = $(this).val();
	        alert(gameName);
	        $.ajax({
	            type: 'POST',
	            url: contextPath + '/DeleteGameLogicServlet',
	            data: { 
	                gameName: gameName 
	            },
	            success: function(response) {
	                // Gestione della risposta
	                alert('Gioco eliminato con successo');
	                location.reload();
	            },
	            error: function(xhr, status, error) {
	                // Gestione degli errori
	                alert('Errore durante l\'eliminazione:', error);
	            }
	        });
	    });
	});
	
	</script>
</body>
</html>