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
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0&icon_names=play_arrow" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/Libreria.css">
<title>La Tua Libreria Giochi</title>
</head>
<body>

	<div class="container-fluid min-vh-100 d-flex flex-column">

		<!-- Navbar -->
		<% request.setAttribute("utenteLoggato", utenteLoggato); %>
		<jsp:include page="/includes/navbar.jsp" />

		<div class="card-container flex-grow-1	">
			
			<%for(Libreria l : BusinessLogic.getLibreriaByName(utenteLoggato.getUsername())){ %>
			<div class="card mb-3 "
				style="max-width: 1500px; color: gray; background-color: #171a21;">
				<div class="row flex-grow-1">

					<div class="col-md-3"
						style="display: flex; justify-content: center; align-items: center;">
						<img src="<%=l.getGioco().getImagePath() %>"
							class="img-fluid rounded-start" alt="..." width="300"
							style="border: 1px solid black; margin: 5px;">
					</div>
					<div class="col-md-6 align-content-center">
						<div class="card-body">
							<h3 class="card-title text-primary-emphasis text-center"><%=l.getGioco().getNome()%></h3>
							<p
								class="card-text text-center align-content-center text-info-emphasis"><%=l.getGioco().getDescrizione()%></p>
						</div>
					</div>
					<div
						class="col-md-3 flex-grow-1 align-content-center justify-content-center">

						<div class="card-body">

							<div class="btn-container w-50">
								<%if(utenteLoggato.getRuolo().ordinal() == 1) {%>
								<a href="https://www.youtube.com/watch?v=dQw4w9WgXcQ">
									<button type="button" class="btn btn-outline-primary"
										style="margin: 5px;">Gioca</button>
								</a>
								<%} else { %>
								<a href="<%=request.getContextPath()%>/UpdateGameLogicServlet">
									<button type="button" class="btn btn-outline-primary"
										style="margin: 5px;">Gestisci Gioco</button>
								</a>
								<%} %>
							</div>

							<p class="card-text text-info-emphasis">
								<%if(utenteLoggato.getRuolo().ordinal() == 1){ %>
								Tempo di Gioco:
								<%=l.getTempoGioco()%></p>
							<%}%>
						</div>
					</div>
				</div>
			</div>
			<%}%>

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