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
<title>Pagina_Elimina_Gioco</title>
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
			<form action="<%=request.getContextPath()%>/DeleteGameLogicServlet"
				method="post">
				<fieldset>
					<legend>Elimina gioco</legend>
					<div class="mb-3">
						<div class="form-group">
							<label for="gameSelect" style="color: white;">Seleziona
								il gioco da eliminare:</label> <select id="gameSelect" name="game"
								class="form-select">
								<option value="" aria-placeholder="Seleziona il gioco">...</option>
								<%
                                for(Gioco g : listaGiochi){ %>

								<option value="<%=g.getNome() %>" aria-placeholder=""><%=g.getNome() %></option>

								<%} %>
							</select>
						</div>
					</div>

					<button type="submit" class="Elimina" style="margin-top: 5vh;">ELIMINA</button>

				</fieldset>
			</form>
		</div>
	</div>


	<!-- Footer -->
	<%@include file="/includes/footer.jsp"%>
	
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
		integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
		crossorigin="anonymous"></script>
</body>
</html>