<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="org.elis.model.Utente" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/ProfileUpdate.css">
    <title>Aggiornamento Profilo - SteamFarlocco</title>
    
</head>
<body>
<% 
            // Recupera la sessione esistente
            HttpSession currentSession = request.getSession(false);
            Utente utenteLoggato = (currentSession != null) ? (Utente) currentSession.getAttribute("utenteLoggato") : null;

            if (utenteLoggato == null) {
                // Se la sessione non esiste o l'utente non � loggato, reindirizza al login
                response.sendRedirect("public-jsp/PaginaLogin.jsp");
                return;
            }

            // Recupera i dati dell'utente per mostrarli nel form
            String currentEmail = utenteLoggato.getEmail();
            String currentUsername = utenteLoggato.getUsername();
            String currentDataNascita = (utenteLoggato.getDataNascita() != null) ? utenteLoggato.getDataNascita().toString() : "";
        %>

    <div class="container-fluid min-vh-100 d-flex flex-column">
	    
	 <!--  Navbar -->
    <% request.setAttribute("utenteLoggato", utenteLoggato); %>
	<jsp:include page="/includes/navbar.jsp"/>
 
        <div class="profile-container mt-5 p-4 flex-grow-1">


				<div class="text-center mt-4">
					<h4>Modifica Profilo</h4>
					<form action="<%=request.getContextPath()%>/UpdateProfileServlet" method="post" class="mt-3">
						
						<input type="hidden" name="action" value="updateUsername">
						<div class="mb-4">
							<label for="username" class="form-label">Nuovo Username</label> <input
								type="text" class="form-control" id="username" name="username"
								placeholder="Inserisci nuovo username">
						</div>
						
					

					
						<input type="hidden" name="action" value="updateDataNascita">
						<div class="mb-4">
							<label for="dataNascita" class="form-label">Nuova Data di
								Nascita</label> <input type="date" class="form-control" id="dataNascita"
								name="dataNascita">
						</div>
						
					

					
						
						<input type="hidden" name="action" value="updatePassword">
						<div class="mb-4">
							<label for="password" class="form-label">Nuova Password</label> <input
								type="password" class="form-control" id="password"
								name="password" placeholder="Inserisci nuova password">
						</div>
						<button type="submit" class="btn btn-custom mt-5">Aggiorna
							</button>
					</form>
					
				</div>
			</div>

        <% 
            // Mostra eventuali messaggi di errore passati dal servlet
            String errorMessage = (String) request.getAttribute("error");
            if (errorMessage != null) {
        %>
            <div class="alert alert-danger mt-3"><%= errorMessage %></div>
        <% } %>
        
    <!-- Footer -->    
    <%@include file="/includes/footer.jsp"%>
    </div>
    
    <script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-..."></script>
</body>
</html>
