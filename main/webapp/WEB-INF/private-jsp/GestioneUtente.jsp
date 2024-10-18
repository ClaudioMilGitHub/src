<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
<%@page import="org.elis.model.*"%>
<%@page import="org.elis.businesslogic.BusinessLogic"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Gestione Utente</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/GestioneUtenteStyle.css">
</head>
<body>

	<%Utente utenteLoggato = (Utente) session.getAttribute("utenteLoggato");%>
	<%List<Utente> listaUtenti = BusinessLogic.getAllUtenti();%>

    <div class="container-fluid min-vh-100 d-flex flex-column">
     
    <!--  Navbar -->
    <% request.setAttribute("utenteLoggato", utenteLoggato); %>
	<jsp:include page="/includes/navbar.jsp"/>
	

        <!-- Content row-->
        <!--  Lista Utenti -->
        <div class="row content flex-grow-1">
            <div class="col mb-3">
            	<h2 class = "text-center fw-bold" style="color:white;">Lista Utenti</h2>
				<ul class="list-group cProductsList">
					<%for(int i =0 ; i < listaUtenti.size(); i++){
						if(listaUtenti.get(i).getRuolo().ordinal() != 0 && !listaUtenti.get(i).isSuspended()) {%>
						<li class="list-group-item d-flex"><p
							class="p-0 m-0 flex-grow-1"><%=listaUtenti.get(i).getUsername() %></p>
						<button class="btn btn-warning suspend">SUSPEND</button>
						<button class="btn btn-danger delete">DELETE</button></li>
					<%}
					}%>
				</ul>

			</div>
        </div>
        
        <!-- Lista Utenti Sospesi -->
        <div class="row content flex-grow-1">
            <div class="col">
            	<h2 class="text-center fw-bold" style="color:white;">Utenti Sospesi</h2>
				<ul class="list-group cProductsList">
					<%for(int i =0 ; i < listaUtenti.size(); i++){
						if(listaUtenti.get(i).getRuolo().ordinal() != 0 && listaUtenti.get(i).isSuspended()) {%>
						<li class="list-group-item d-flex"><p
							class="p-0 m-0 flex-grow-1"><%=listaUtenti.get(i).getUsername() %></p>
						<button class="btn btn-success resume">RESUME</button>
						<button class="btn btn-danger delete">DELETE</button></li>
					<%}
					}%>
				</ul>

			</div>
        </div>
		
		<!-- Footer -->
        <%@include file="/includes/footer.jsp" %>
        
    </div>
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
	
	$(document).ready(function() {

		const contextPath = '${pageContext.request.contextPath}';
		
		
		$('.suspend').click(function() {
		    var username = $(this).siblings('p').text();
		    const operation = 'suspend';

		    $.ajax({
	            type: 'POST',
	            url: contextPath + '/GestioneUtenteServlet',
	            data: { 
	            	username: username,
	            	operation: operation
	            },
	            success: function(response) {
	                // Gestione della risposta
	                alert('Utente sospeso con successo');
	                location.reload();
	            },
	            error: function(xhr, status, error) {
	                // Gestione degli errori
	                alert('Errore durante l\'eliminazione:', error);
	            }
	        });
		});
		
		$('.resume').click(function() {
		    var username = $(this).siblings('p').text();
		    const operation = 'resume';

		    $.ajax({
	            type: 'POST',
	            url: contextPath + '/GestioneUtenteServlet',
	            data: { 
	            	username: username,
	            	operation: operation
	            },
	            success: function(response) {
	                // Gestione della risposta
	                alert('Utente riabilitato con successo');
	                location.reload();
	            },
	            error: function(xhr, status, error) {
	                // Gestione degli errori
	                alert('Errore durante l\'eliminazione:', error);
	            }
	        });
		});

		// Per il bottone DELETE 
		$('.delete').click(function() {
		    const username = $(this).siblings('p').text();
		    const operation = 'delete';

		    $.ajax({
	            type: 'POST',
	            url: contextPath + '/GestioneUtenteServlet',
	            data: { 
	            	username: username,
	            	operation: operation
	            },
	            success: function(response) {
	                // Gestione della risposta
	                alert('Utente eliminato con successo');
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