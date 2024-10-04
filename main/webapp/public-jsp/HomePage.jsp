<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                        <a class="nav-link" aria-current="page" href="#">Home</a>
                        <a class="nav-link" href="#">Negozio</a>
                        <a class="nav-link" href="#">Profilo</a>
                      </div>
                    </div>
                    <div class="collapse navbar-collapse" id="navbarNavDropdown">
                        <form class="d-flex" role="search">
                            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                            <button class="btn btn-outline-success" type="submit">Search</button>
                        </form>
                    </div>
                    <div class="collapse navbar-collapse" id="navbarNavDropdown">
                        <div class="global-action">
                            <a class="action-link" href="<%=request.getContextPath()%>/LoginLogicServlet">Accedi</a>
                        </div>  
                    </div>
                </div>
            </nav>
             
        </div>

        <!-- Content row-->
        <div class="row content h-100">
            <div class="col-lg-3 col-sm mb-3 d-none d-lg-block">
                <div class="options-buttons">
                    <div class="col home_page_gutter-block ps-4">
                        <div class="col gutter_header">Sfoglia categorie</div>
                            <a href="#" class="gutter_item">
                                I più venduti
                            </a>
                            <a href="#" class="gutter_item">
                                Nuove uscite
                            </a>
                            <a href="#" class="gutter_item">
                                In arrivo
                            </a>
                            <a href="#" class="gutter_item">
                                Offerte speciali
                            </a>
                            <a href="#" class="gutter_item">
                                Titoli in VR
                            </a>               
                        <div class="col gutter_header">
                            Sfoglia per genere
                        </div>
                            <a href="#" class="gutter_item">
                                Avventura
                            </a>
                            <a href="#" class="gutter_item">
                                Ruolo
                            </a>
                            <a href="#" class="gutter_item">
                                Strategia
                            </a>
                            <a href="#" class="gutter_item">
                                Metroidvania
                            </a>
                            <a href="#" class="gutter_item">
                                Azione
                            </a>                                   
                    </div>        
                </div>  
            </div>
            <div class="col-lg-6 card-container ">
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
                <div class="content-cards mb-3">
                    <div class="card m-auto" style="width: 80%;">
                        <img src="https://wallpapers.com/images/hd/death-stranding-hd-e8t319t8a7c2e1w3.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                          <h3 class="card-title">Card title</h3>
                          <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                          <a href="#" class="btn btn-outline-primary">Go somewhere</a>
                        </div>
                    </div>
                </div>           
            </div>
            <div class="col-lg-3">
                
            </div>
        </div>

        <!-- Footer row-->
        <div class="row footer">
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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>