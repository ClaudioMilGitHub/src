<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="org.elis.model.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sfoglia per genere</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/SfogliaGiochi.css">


</head>
<body>
	
	<%Utente utenteLoggato = (Utente) session.getAttribute("utenteLoggato");%>
	<%List<Gioco> listaGiochi =  (List<Gioco>) request.getAttribute("listaGiochi");%>
	<%Genere genere =  (Genere) request.getAttribute("genere");%>

<div class="container-fluid min-vh-100 d-flex flex-column">

		<!-- Navigation bar row-->

		<% request.setAttribute("utenteLoggato", utenteLoggato); %>
		<jsp:include page="/includes/navbar.jsp"/>

		<!-- Content row-->
		
		<div class="row content-cards flex-grow-1" id="row-cards">
			<%if(listaGiochi.size() == 0){ %>
				<p class="text-center fs-1" style = "color:#ffff;">Ancora nessun gioco qui!</p>
			<%} else {%>
				<p class="text-center fs-1" style = "color:#ffff;"><%=genere.getNome() %></p>
			<%}%>
			<%for(int i = 0; i < listaGiochi.size(); i++){%>
				<div class="col-lg-4">
					
					<div class="content-cards mb-3">
						<div class="card m-auto" style="width: 80%;">
							<img
								src="<%=listaGiochi.get(i).getImagePath() %>"
								class="card-img-top" alt="...">
							<div class="card-body">
								<h3 class="card-title"><%=listaGiochi.get(i).getNome() %></h3>
								<p class="card-text"><%=listaGiochi.get(i).getDescrizione() %></p>
								<%if(utenteLoggato != null){
									
										if( i < utenteLoggato.getGiochi().size() && utenteLoggato.getGiochi().get(i) != null){

											if(listaGiochi.get(i).getNome().equalsIgnoreCase(utenteLoggato.getGiochi().get(i).getNome())) 
											{

												%>
												<a href="#" class="btn btn-outline-primary">In libreria</a>
												<%} else {%>
														<a href="#" class="btn btn-outline-primary">Acquista</a>
													<%}									
											} else {%>
												<a href="#" class="btn btn-outline-primary">Acquista</a>
											<%}
										} else {%>
											<a href="#" class="btn btn-outline-primary">Acquista</a>
										<%}%>							</div>
						</div>
					</div>
				</div>	
			<%}%>	
		</div>
		
		
			<div class="col-lg-12 mb-3 h-75 d-flex justify-content-center">
				<button class="btn btn-dark carica-altro m-3" id="btn-home">
					<a href="#" id="link-home">Torna su</a>
				</button>
			</div>


		<!-- Footer -->
        <%@include file="/includes/footer.jsp" %>
</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
		integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
		crossorigin="anonymous"></script>


</body>
</html>