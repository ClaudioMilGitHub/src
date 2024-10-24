<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.elis.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%Utente utenteLoggato = (Utente) request.getAttribute("utenteLoggato"); %>
	
	   <!-- Navigation bar row-->
        <div class="row navbar mb-3">
            <nav class="navbar navbar-expand-lg">
                <div class="container">
                    <a class="navbar-brand" href="<%=request.getContextPath()%>/index">
                        <img src="https://store.akamai.steamstatic.com/public/shared/images/header/logo_steam.svg?t=962016" alt="Steam logo" width="176" height="44">
                    </a>

                    <button class="navbar-toggler navbar-dark" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                      <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                      <div class="navbar-nav">
                      <%if(utenteLoggato != null){%>
	                       	<a class="nav-link" href="<%=request.getContextPath()%>/ProfileLogicServlet"><%=utenteLoggato.getUsername()%></a>
	                        <a class="nav-link" href="<%=request.getContextPath()%>/LibreriaServlet">Libreria</a>
	                        <a class="nav-link" href="<%=request.getContextPath()%>/LogoutServlet">Logout</a>
                      <%} else if(utenteLoggato == null){%>
                          <a class="nav-link" href="<%=request.getContextPath()%>/LoginLogicServlet">Accedi</a>
                          <a class="nav-link" href="<%=request.getContextPath()%>/RegistrationLogicServlet">Registrati</a>
                        <%}%>
                      </div>
                    </div>
                    <div class="collapse navbar-collapse" id="navbarNavDropdown">
                        <form class="d-flex" role="search">
                            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                            <button class="btn btn-outline-light" type="submit">Search</button>
                        </form>
                    </div>
                </div>
            </nav>
             
        </div>
</body>
</html>