<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="org.elis.model.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/Pagina_Admin.css">
    <title>Pagina Admin</title>
</head>
<body>
	
	<%Utente utenteLoggato = (Utente) session.getAttribute("utenteLoggato");%>

<div class="container-fluid min-vh-100 d-flex flex-column">

            <!--  Navbar -->
    		<% request.setAttribute("utenteLoggato", utenteLoggato); %>
			<jsp:include page="/includes/navbar.jsp"/>
			
			<!-- Content -->
              <div class="row flex-grow-1">
                <div class="col-lg-3">
                  <div class="card mb-3">
                    <div class="card-body text-center" style="background-color: #536f86 ;">
                      <img src="https://static.miraheze.org/nonciclopediawiki/9/9e/Richard_Benson_urla_2.jpg" alt="avatar"
                        class="rounded-circle img-fluid" style="width: 150px;">
                      <h5 class="my-3">@
					  <% if(utenteLoggato.getRuolo() != null){
                            	
                      %>
                            	
                      <%=utenteLoggato.getRuolo()%>
                            	
                      <%
                      }     
                      %>
					  </h5>
                      <p class="text-muted mb-4">
						<% if(utenteLoggato.getUsername() != null){
                            	
                            	%>
                            	
                            	<%=utenteLoggato.getUsername()%>
                            	
                            	<%
                            }     
                            %>
						</p>
                      <p>Sito Web</p>
                      <p class="text-muted mb-4">
						<% if(utenteLoggato.getSitoWeb() != null){
                            	
                            	%>
                            	
                            	<%=utenteLoggato.getSitoWeb()%>
                            	
                            	<%
                            }     
                            %>
					</p>
                
                    </div>
                </div>
            </div>
                  <div class="col-lg-9 mb-3">
                    <div class="card mb-9">
                    <ul class="list-group list-group-flush rounded-3">
                      <div class="card-body" style="background-color: #536f86 ;">
                        <div class="row">
                          <div class="col-sm-3" >
                            <p class="mb-0">Nome</p>
                          </div>
                          <div class="col-sm-9">
                            <p class="text-muted mb-0"> 
                            <% if(utenteLoggato.getNome() != null){
                            	
                            	%>
                            	
                            	<%=utenteLoggato.getNome()%>
                            	
                            	<%
                            }     
                            %>
                            </p>
                          </div>
                        </div>
                        <hr>
                        <div class="row flex-grow-1">
                          <div class="col-sm-3" >
                            <p class="mb-0">Cognome</p>
                          </div>
                          <div class="col-sm-9">
                            <p class="text-muted mb-0"> 
							<% if(utenteLoggato.getCognome() != null){
                           	
                           	%>
                           	
                           	<%=utenteLoggato.getCognome()%>
                           	
                           	<%
                            }     
                            %>
                            </p>
                          </div>
                        </div>
                        <hr>
                        <div class="row flex-grow-1">
                          <div class="col-sm-3">
                            <p class="mb-0">Email</p>
                          </div>
                          <div class="col-sm-9">
                            <p class="text-muted mb-0"> 
							<% if(utenteLoggato.getEmail() != null){
                           	
                           	%>
                           	
                           	<%=utenteLoggato.getEmail()%>
                           	
                           	<%
                            }     
                            %>								
							</p>
                          </div>
                        </div>
                        <hr>
                        <div class="row flex-grow-1">
                          <div class="col-sm-3" >
                            <p class="mb-0">Data di nascita</p>
                          </div>
                          <div class="col-sm-9">
                            <p class="text-muted mb-0"> 
                            <% if(utenteLoggato.getDataNascita() != null){
                           	
                           	%>
                           	
                           	<%=utenteLoggato.getDataNascita()%>
                           	
                           	<%
                            }     
                            %>
                            </p>
                          </div>
                        </div>
                        <hr>
                        <div class="row flex-grow-1">
                          <div class="col-sm-3">
                            <p class="mb-0">Telefono</p>
                          </div>
                          <div class="col-sm-9">
                            <p class="text-muted mb-0"> 
                            <% if(utenteLoggato.getTelefono() != null){
                           	
                           	%>
                           	
                           	<%=utenteLoggato.getTelefono()%>
                           	
                           	<%
                            }     
                            %>                          
                            </p>
                          </div>
                        </div>
                        <hr>
                        <div class="row flex-grow-1">
                          <div class="col-sm-3">
                            <p class="mb-0">Indirizzo</p>
                          </div>
                          <div class="col-sm-9">
                            <p class="text-muted mb-0"> 
							<% if(utenteLoggato.getIndirizzo() != null){
                           	
                           	%>
                           	
                           	<%=utenteLoggato.getIndirizzo()%>
                           	
                           	<%
                            }     
                            %>
							</p>
                          </div>
                        </div>
                      </div>
                    </ul>
                    </div>
                  </div>
                </div>
                <div class="row flex-grow-1">
                
                <div class="col-lg-6" style="display: flex; justify-content: left;">
                <div class="card text-white-emphasis  mb-3" style="background-color: #536f86">
                <div class="card-header">Gestione utenti</div>
                <div class="card-body bg-dark card text-primary-emphasis">
                <div class="d-grid" >
                <div id="btn2">
                                        <a href="<%=request.getContextPath()%>/GestioneUtenteServlet"><button class="btn btn-outline-primary" type="button">Gestisci utenti</button></a>
                                        
                </div>  
                </div>
                </div>        
                </div>
                </div>
                
                <div class="col-lg-6" style="display: flex; justify-content: right;">
                <div class="card text-white-emphasis  mb-3" style="background-color: #536f86">
                <div class="card-header">Gestione giochi</div>
                <div class="card-body bg-dark card text-primary-emphasis">
                <div class="d-grid gap-2">
                <div id="btn2">
                                            <a href="<%=request.getContextPath()%>/AddGameLogicServlet"><button class="btn  btn-outline-primary" type="button">Aggiungi gioco</button></a>
                                            <a href="<%=request.getContextPath()%>/UpdateGameLogicServlet"><button class="btn btn-outline-primary" type="button">Aggiorna gioco</button></a>
                                            <a href="<%=request.getContextPath()%>/DeleteGameLogicServlet"><button class="btn btn-outline-primary" type="button">Rimuovi gioco</button></a>
                </div>
                </div>  
                </div>
                </div>      
                </div>
                </div>
	            <!-- Footer -->
	            <%@include file="/includes/footer.jsp" %>
                </div>

                       
             
            
    
   
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>