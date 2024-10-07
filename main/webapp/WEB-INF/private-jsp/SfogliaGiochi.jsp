<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="org.elis.model.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Avventura</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/SfogliaGiochi.css">

    
</head>
<body>

	<%List<Gioco> listaGiochi =  (List<Gioco>) request.getAttribute("listaGiochi");%>
	<%Genere genere =  (Genere) request.getAttribute("genere");%>

    <div class="container-fluid">

        <!-- Navigation bar row-->

        <div class="row navbar mb-3">
            <nav class="navbar navbar-expand-lg">
                <div class="container">
                    <a class="navbar-brand" href="#">
                        <img src="https://store.akamai.steamstatic.com/public/shared/images/header/logo_steam.svg?t=962016" alt="Steam logo" width="176" height="44">
                    </a>

                    <button class="navbar-toggler navbar-dark" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                      <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                      <div class="navbar-nav">
                        <a class="nav-link" aria-current="page" href="<%=request.getContextPath()%>/public-jsp/HomePage.jsp">Home</a>
                        <a class="nav-link" href="#">Profilo</a>
                      </div>
                    </div>
                    <div class="collapse navbar-collapse" id="navbarNavDropdown">
                        <div class="global-action">
                            <a class="action-link" href="<%=request.getContextPath()%>/PaginaLogic.jsp">Accedi</a>
                            <a class="action-link" href="<%=request.getContextPath()%>/PaginaRegistrazione.jsp">Registrati</a>
                        </div>  
                    </div>
                </div>
            </nav>        
        </div>

         <!-- Content row-->

        <div class="row content-carousel">
            <div class="col-lg-3 col-sm mb-3 d-none d-lg-block"> <!-- Left Column--></div>
            <div class="col-lg-6 content-container mb-5">
            	
            	<h1 class="titolo-genere ms-1"><%=genere.getNome()%></h1>
            	
                <!-- Insert game List here -->
                <div id="carouselExampleCaptions" class="carousel slide">
                    <div class="carousel-indicators">
                      <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                      <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
                      <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
                      <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="3" aria-label="Slide 4"></button>
                      <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="4" aria-label="Slide 5"></button>
                    </div>
                    <div class="carousel-inner">
                      <div class="carousel-item active">
                        <img src="https://wallpapers.com/images/hd/death-stranding-hd-e8t319t8a7c2e1w3.jpg" class="d-block w-100" alt="...">
                        <div class="carousel-caption d-none d-md-block">
                          <h5>First slide label <!--Put Game title here --></h5>
                          <p>Some representative placeholder content for the first slide.<!--Put Game description here --></p>
                        </div>
                      </div>
                      <div class="carousel-item">
                        <!--Put Game image here -->
                        <img src="https://wallpapers.com/images/hd/death-stranding-hd-e8t319t8a7c2e1w3.jpg" class="d-block w-100" alt="...">
                        <div class="carousel-caption d-none d-md-block">
                          <h5>Second slide label</h5>
                          <p>Some representative placeholder content for the second slide.</p>
                        </div>
                      </div>
                      <div class="carousel-item">
                        <img src="https://wallpapers.com/images/hd/death-stranding-hd-e8t319t8a7c2e1w3.jpg" class="d-block w-100" alt="...">
                        <div class="carousel-caption d-none d-md-block">
                          <h5>Third slide label</h5>
                          <p>Some representative placeholder content for the third slide.</p>
                        </div>
                      </div>
                      <div class="carousel-item">
                        <img src="https://wallpapers.com/images/hd/death-stranding-hd-e8t319t8a7c2e1w3.jpg" class="d-block w-100" alt="...">
                        <div class="carousel-caption d-none d-md-block">
                          <h5>4 slide label</h5>
                          <p>Some representative placeholder content for the third slide.</p>
                        </div>
                      </div>
                      <div class="carousel-item">
                        <img src="https://wallpapers.com/images/hd/death-stranding-hd-e8t319t8a7c2e1w3.jpg" class="d-block w-100" alt="...">
                        <div class="carousel-caption d-none d-md-block">
                          <h5>5 slide label</h5>
                          <p>Some representative placeholder content for the third slide.</p>
                        </div>
                      </div>
                      
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                      <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                      <span class="carousel-control-next-icon" aria-hidden="true"></span>
                      <span class="visually-hidden">Next</span>
                    </button>
                  </div>
            </div>
            <div class="col-lg-3 col-sm mb-3 d-none d-lg-block"> <!-- Right column--></div>
        </div>
        <div class="row content-cards" id="row-cards">
            <div class="col-lg-4">
                <div class="content-cards mb-3">
                    <div class="card m-auto" style="width: 80%;">
                        <img src="https://wallpapers.com/images/hd/death-stranding-hd-e8t319t8a7c2e1w3.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                          <h3 class="card-title">Death Stranding</h3>
                          <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                          <a href="#" class="btn btn-outline-primary">Acquista</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="content-cards mb-3">
                    <div class="card m-auto" style="width: 80%;">
                        <img src="https://wallpapers.com/images/hd/death-stranding-hd-e8t319t8a7c2e1w3.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                          <h3 class="card-title">Death Stranding</h3>
                          <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                          <a href="#" class="btn btn-outline-primary">Acquista</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="content-cards mb-3">
                    <div class="card m-auto" style="width: 80%;">
                        <img src="https://wallpapers.com/images/hd/death-stranding-hd-e8t319t8a7c2e1w3.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                          <h3 class="card-title">Death Stranding</h3>
                          <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                          <a href="#" class="btn btn-outline-primary">Acquista</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row more-cards-button">
          <div class="col-lg-12 mb-3 d-flex justify-content-center">
            <button class="btn btn-dark carica-altro m-3 carica-altro">Carica altro</button>
            <button class="btn btn-dark carica-altro m-3" id="btn-home"><a href="#" id="link-home">Torna su</a></button>
          </div>
        </div>
        <div class="row">
            <footer class="footer">
                <div class="content-logo d-flex flex-row justify-content-between">
                    <div class="footer-logo-steam">
                        <img src="https://store.akamai.steamstatic.com/public/images/v6/logo_steam_footer.png" alt="logo steam">
                    </div>
                    <div class="footer-valve">
                        <img src="https://store.akamai.steamstatic.com/public/images/footerLogo_valve_new.png" alt="logo">
                    </div>
                </div>
                <div class="content-footer color-white" id="footer_text">
                    Progetto ispirato a Steam per puri scopi didattici per il Master di Sviluppo Software e Applicazioni edizione Maggio. Gruppo di lavoro composto da Claudio Milano, Leandro Biccellari, Antonio Guglielmo e Simone Medori.
                </div>
            </footer>
        </div>
    </div> 
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
        
        <script type="text/javascript">
        $(document).ready(function(){

        $(document).on('click', '.carica-altro', function(){
            let cardRow = `
                <div class="row content-cards">
                <div class="col-lg-4">
                    <div class="content-cards mb-3">
                        <div class="card m-auto" style="width: 80%;">
                            <img src="https://wallpapers.com/images/hd/death-stranding-hd-e8t319t8a7c2e1w3.jpg" class="card-img-top" alt="immagine_gioco">
                            <div class="card-body">
                              <h3 class="card-title">Death Stranding</h3>
                              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                              <a href="#" class="btn btn-outline-primary">Acquista</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="content-cards mb-3">
                        <div class="card m-auto" style="width: 80%;">
                            <img src="https://wallpapers.com/images/hd/death-stranding-hd-e8t319t8a7c2e1w3.jpg" class="card-img-top" alt="immagine_gioco">
                            <div class="card-body">
                              <h3 class="card-title"><%=listaGiochi.getFirst().getNome() %></h3>
                              <p class="card-text"><%=listaGiochi.getFirst().getDescrizione() %></p>
                              <a href="#" class="btn btn-outline-primary">Acquista</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="content-cards mb-3">
                        <div class="card m-auto" style="width: 80%;">
                            <img src="https://wallpapers.com/images/hd/death-stranding-hd-e8t319t8a7c2e1w3.jpg" class="card-img-top" alt="immagine_gioco">
                            <div class="card-body">
                              <h3 class="card-title">Death Stranding</h3>
                              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                              <a href="#" class="btn btn-outline-primary">Acquista</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
                `     
            $('#row-cards').after(cardRow);       
        });
    });
        </script>
</body>
</html>