<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="org.elis.model.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/HomePageUtenteStyle.css">
    
    <title>Benvenuto su STEAM</title>
</head>
<body>

	<%Utente utenteLoggato = (Utente) session.getAttribute("utenteLoggato");%>
	<%List<Gioco> listaGiochi = (List<Gioco>) request.getAttribute("listaGiochi");%>

    <div class="container-fluid">
     
    <!--  Navbar -->
    <% request.setAttribute("utenteLoggato", utenteLoggato); %>
	<jsp:include page="/includes/navbar.jsp"/>
	

        <!-- Content row-->
        <div class="row content h-100">
            <div class="col-lg-3 col-sm mb-3 d-none d-lg-block">
                <div class="options-buttons">
                    <div class="col home_page_gutter-block ps-4">
                        <div class="col gutter_header">Sfoglia categorie</div>
                            <form action="CategorieServlet" method="POST">   
                                <button class="gutter_item" type="submit" value="avventura" name="avventuraInputForm">
                                    I più venduti
                                </button>
                                <button class="gutter_item" type="submit" value="ruolo" name="ruoloInputForm">
                                    Nuove uscite
                                </button>
                                <button class="gutter_item" type="submit" value="strategia" name="strategiaInputForm">
                                    In arrivo
                                </button>
                                <button class="gutter_item" type="submit" value="metroidvania" name="metroidvaniaInputForm">
                                    Offerte speciali
                                </button>
                                <button class="gutter_item" type="submit" value="azione" name="azioneInputForm">
                                    Titoli in VR
                                </button>
                            </form>        
                        <div class="col gutter_header">
                            Sfoglia per genere
                        </div>
                            <form action="<%=request.getContextPath()%>/SfogliaGiochiServlet" method="POST">   
                               <button class="gutter_item" type="submit" value="avventura" name="genereInputForm">
                                   Avventura
                               </button>
                               <button class="gutter_item" type="submit" value="ruolo" name="genereInputForm">
                                   Ruolo
                               </button>
                               <button class="gutter_item" type="submit" value="strategia" name="genereInputForm">
                                   Strategia
                               </button>
                               <button class="gutter_item" type="submit" value="metroidvania" name="genereInputForm">
                                   Metroidvania
                               </button>
                               <button class="gutter_item" type="submit" value="azione" name="genereInputForm">
                                   Azione
                               </button>
                           </form>                                  
                    </div>        
                </div>  
            </div>
            <div class="col-lg-6 card-container ">
                <%for(int i = 0; i < listaGiochi.size(); i++){%>				
					<div class="col">
						<div class="content-cards mb-3">
							<div class="card m-auto" style="width: 80%;">
								<img
									src="<%=listaGiochi.get(i).getImagePath() %>"
									class="card-img-top" alt="game_img">
								<div class="card-body">
									<h3 class="card-title"><%=listaGiochi.get(i).getNome() %></h3>
									<p class="card-text"><%=listaGiochi.get(i).getDescrizione() %></p>
									<a href="#" class="btn btn-outline-primary">Acquista</a>
								</div>
							</div>
						</div>
					</div>
			   <%}%>
         
            </div>
            <div class="col-lg-3">
                
            </div>
        </div>
		
		<!-- Footer -->
        <%@include file="/includes/footer.jsp" %>
        
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>