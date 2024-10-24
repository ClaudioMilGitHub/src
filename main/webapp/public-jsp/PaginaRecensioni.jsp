<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="java.util.List"%>
<%@page import="org.elis.model.Utente"%>
<%@page import="org.elis.model.Gioco"%>
<%@page import="org.elis.model.Recensione"%>
<%@page import="org.elis.businesslogic.BusinessLogic"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
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
	href="<%=request.getContextPath()%>/css/PaginaRecensioni.css">


</head>
<body>
	
	<%Utente utenteLoggato = (Utente) session.getAttribute("utenteLoggato");%>
	<%Gioco gioco =  (Gioco) request.getAttribute("gioco");%>
	<%List<Recensione> listaRecensioni = (List<Recensione>) request.getAttribute("listaRecensioni"); %>
	<%boolean hasReview = (boolean) request.getAttribute("hasReview"); %>
	<%
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	%>
	<%String errorMessage = (String) request.getAttribute("errorMessage"); %>
	
	

<div class="container-fluid min-vh-100 d-flex flex-column">

		<!-- Navigation bar row-->

		<% request.setAttribute("utenteLoggato", utenteLoggato); %>
		<jsp:include page="/includes/navbar.jsp"/>

		<!-- Content row-->
		<div class="content flex-grow-1">
			<div class="row content-cards d-flex justify-content-center mb-3" id="row-cards">
				<div class="card mb-3" style="max-width: 1024px;">
					  <div class="row g-0">
					    <div class="col-md-5 game-card-image">
					      <img src="<%=gioco.getImagePath() %>" class="img-fluid rounded-start w-100 h-100" alt="game_image" style="object-fit: contain;">
					    </div>
					    <div class="col-md-7 d-flex">
					      <div class="card-body d-flex flex-column justify-content-center flex-grow-1">
					        <h5 class="card-title" style="color:#808080"><%=gioco.getNome() %></h5>
					        <p class="card-text"><%=gioco.getDescrizione() %></p>
					        <p class="card-text"><small class="text-body-secondary">Last updated 3 mins ago</small></p>
					      </div>
					    </div>
					  </div>
				</div>
						
			</div>		

			<div class="row recensioni">
			<%if(!listaRecensioni.isEmpty()){ %>
				<%for(int i = 0; i<listaRecensioni.size(); i++) {%>
					<div class="card m-auto mb-3" style="max-width: 1024px;">
						  <div class="card-header" style="color:grey">
						    <%=listaRecensioni.get(i).getDataCreazione().toLocalDate().format(formatter) %>
						  </div>
						  <div class="card-body">
						    <h4 class="card-title fw-bold" style="color:#c1dbf4"><%=listaRecensioni.get(i).getUtente().getUsername() %></h4>
						    <p class="card-text fs-6"><%=listaRecensioni.get(i).getTesto() %></p>
						    <%if(utenteLoggato != null && utenteLoggato.getId() == listaRecensioni.get(i).getUtente().getId()){ %>
						    
						    <button class = "btn btn-dark edit-btn mb-3">Modifica</button>
						    
						    <div class="edit-body mb-3 hide">
						    	<div class = "review-edit-form">
						    		<form action = "<%=request.getContextPath()%>/UpdateReviewServlet" method="POST">
									
									<div class = "review-text-form mb-3 d-flex flex-column">
										<input type="hidden" value="<%=listaRecensioni.get(i).getGioco().getId() %>" name = "gameIdForm" ></input>
							    		<input type="hidden" value="<%=listaRecensioni.get(i).getId() %>" name = "reviewIdInputForm" ></input>
							    		<label for="review-text">Nuova Recensione</label>
							    		<textarea rows="5" cols="33" name="reviewInputForm" id="review-text" class="form-control w-50 mt-1"></textarea>	
									</div>
	    		
						    		<div class = "review-edit-btn mb-3">
						    			<button class = "btn btn-success update" type="submit">	
						    					Invia Modifiche
						    			</button>
						    		</div>		
						    			
						    	</form>
						    	</div>
						    	
						    	<div class="review-delete-form">
							    	<form action = "<%=request.getContextPath()%>/DeleteReviewServlet" method="POST">
							    	
										<input type="hidden" value="<%=listaRecensioni.get(i).getGioco().getId() %>" name = "gameIdForm" ></input>
							    		<input type="hidden" value="<%=listaRecensioni.get(i).getId() %>" name = "reviewIdInputForm" ></input>    	
							    		<div class="review-delete-btn mb-3">
							    			<button class = "btn btn-danger" type="submit">	
							    					Elimina Recensione
							    			</button>
							    		</div>	
							    			
							    	</form>		
						    	</div>
						    		    	
						    </div>
						    <%}%>    
						  </div>
					</div>
				<%}%>
			<%} else { %>
				
					<h2 class="text-center" style="color:white;">Nessuna recensione pubblicata</h2>
					
				<%} %>
					
					<%if(!hasReview){%>
						<div class = "new-review-btn  text-center mb-3">
							<button class = "btn btn-success new ">Crea nuova Recensione</button>

						</div>
							<div class = "new-review-form hide text-center mb-3">
						    	<form action = "<%=request.getContextPath()%>/AddReviewServlet" method="POST" class = "m-auto d-flex flex-column w-50">
							    	
							    	<input type="hidden" value="<%=gioco.getId()%>" name = "gameIdForm" ></input>						    	
							    	<input type="hidden" value="<%=utenteLoggato.getId()%>" name = "userIdForm" ></input>
							    	
							    	<label for="review-text-area" style="color:white;">Recensione:</label>
							    	<textarea rows="5" cols="33" name="reviewInputForm" class = " form-control review-text-area" id = "review-text-area"></textarea>
							    	
							    	
							    	<div class = "new-review-form-btn text-center mt-3">
							    		<button class = "btn btn-success create w-25" type="submit">Pubblica recensione</button>
							    	</div>
							    	

						    	</form>
						    </div>
					<%}%>	  
					<%if(errorMessage != null) {%>
						<p class = "text-center" style = "color:white;"><%=errorMessage %></p>
					<%}%>  									
			</div>
		</div>
		
		
			<div class="col-lg-12 mb-3 h-75 d-flex justify-content-center">
				<button class="btn btn-dark carica-altro m-3" id="btn-home">
					<a href="#" id="link-home">Torna su</a>
				</button>
			</div>
	</div>


		<!-- Footer -->
        <%@include file="/includes/footer.jsp" %>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
		integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
		crossorigin="anonymous"></script>
	<script
		  src="https://code.jquery.com/jquery-3.6.0.min.js"
		  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		  crossorigin="anonymous"></script>
		  
	<script>
		
		$(document).ready(function(){
		
			const contextPath = '${pageContext.request.contextPath}';	
			
			$('.edit-btn').click(function(e){
			
				$('.edit-body').toggleClass('hide');
			});
			
			$('.new-review-btn').click(function(e){
				
				$('.new-review-form').toggleClass('hide');
			});
			
		});
	
	</script>


</body>
</html>