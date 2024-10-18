<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="org.elis.model.*"%>
    <%@page import="org.elis.businesslogic.BusinessLogic"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%Utente utenteLoggato = (Utente) session.getAttribute("utenteLoggato");%>
	<%List<Gioco> listaGiochi = BusinessLogic.getAllGiochiByIdUtente(utenteLoggato.getId()); %>
	<%for(Gioco gioco : listaGiochi){
		System.out.println(gioco.getNome());
	}%>
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

</body>
</html>