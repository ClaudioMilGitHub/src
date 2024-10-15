<%@page import="org.elis.model.Gioco"%>
<%@page import="org.elis.model.Utente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
Utente utenteLoggato = (Utente) request.getSession().getAttribute("utenteLoggato");
%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/PaginaUtente.css">
<title>Profilo_Utente</title>
</head>
<body>
	<div class="container-fluid">
		<section>
			<div class="row navbar mb-3" style="background-color: #171a21;">
				<nav class="navbar navbar-expand-lg">
					<div class="container">
						<a class="navbar-brand" href="#"> <img
							src="https://store.akamai.steamstatic.com/public/shared/images/header/logo_steam.svg?t=962016"
							alt="Steam logo" width="176" height="44">
						</a>

						<button class="navbar-toggler navbar-dark" type="button"
							data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
							aria-controls="navbarNavAltMarkup" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
							<div class="navbar-nav">
								<a class="nav-link" aria-current="page"
									href="public-jsp/HomePage.jsp">Home</a> <a class="nav-link"
									href="#">Negozio</a>
							</div>
						</div>
						<div class="collapse navbar-collapse" id="navbarNavDropdown">
							<form class="d-flex" role="search">
								<input class="form-control me-2" type="search"
									placeholder="Cerca" aria-label="Search" style="margin: auto;">
								<button class="btn btn-outline-success" type="submit"
									style="margin: auto;">Cerca</button>
							</form>
						</div>

					</div>
				</nav>
			</div>
			<div class="profile-container mt-5 p-4">
				<div class="text-center">
					<img
						src="https://www.romics.it/sites/default/files/styles/medium_compact_teaser/public/2024-03/cicciogamer89_foto.jpg?h=2a479378&itok=bS4pfQYa"
						alt="Immagine Profilo" class="img-fluid rounded-circle"
						style="width: 150px; height: 150px;">
					<h2 class="mt-3">
						Profilo di
						<%=utenteLoggato.getUsername()%></h2>
					<p class="text" style="font-size: large;">🎮</p>
					<p class="text" style="color: white;">Giocatore di Steam</p>
				</div>

				<div class="profile-info mt-4">
					<h4>Informazioni Personali</h4>
					<p>
						<strong>Username:</strong>
						<%=utenteLoggato.getUsername()%></p>
					<p>
						<strong>Email:</strong>
						<%=utenteLoggato.getEmail()%></p>
					<p>
						<strong>Data di Nascita:</strong>
						<%=utenteLoggato.getDataNascita()%></p>
					<p>
						<strong>Ruolo:</strong>
						<%=utenteLoggato.getRuolo()%></p>
				</div>


				<div class="text-center mt-4">
					<form action="<%=request.getContextPath()%>/UpdateProfileServlet">
						<button type="submit" class="btn btn-custom">Aggiorna
							Profilo</button>
					</form>
				</div>
			</div>
			<%@include file="/includes/footer.jsp"%>
	</div>
	
	</section>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-..."></script>
</body>
</html>
