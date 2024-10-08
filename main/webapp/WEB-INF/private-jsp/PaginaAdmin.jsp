<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/Pagina_Admin.css">
    <title>Pagina_Admin</title>
</head>
<body>
<div class="container-fluid">
<section>
            <div class="row navbar mb-3" style="background-color: #171a21;">
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
                          </div>
                        </div>
                        <div class="collapse navbar-collapse" id="navbarNavDropdown">
                            <form class="d-flex" role="search">
                                <input class="form-control me-2" type="search" placeholder="Cerca" aria-label="Search">
                                <button class="btn btn-outline-success" type="submit">Cerca</button>
                            </form>
                        </div>
                       
                    </div>
                </nav>
            </div>
              <div class="row">
                <div class="col-lg-3">
                  <div class="card mb-3">
                    <div class="card-body text-center" style="background-color: #536f86 ;">
                      <img src="https://static.miraheze.org/nonciclopediawiki/9/9e/Richard_Benson_urla_2.jpg" alt="avatar"
                        class="rounded-circle img-fluid" style="width: 150px;">
                      <h5 class="my-3">@Admin</h5>
                      <p class="text-muted mb-1">Admin</p>
                      <p class="text-muted mb-4">Roma, RM</p>
                      </li>
                
                    </div>
                </div>
            </div>
                  <div class="col-lg-9">
                    <div class="card mb-9">
                    <ul class="list-group list-group-flush rounded-3">
                      <div class="card-body" style="background-color: #536f86 ;">
                        <div class="row">
                          <div class="col-sm-3" >
                            <p class="mb-0">Nome</p>
                          </div>
                          <div class="col-sm-9">
                            <p class="text-muted mb-0"> > </p>
                          </div>
                        </div>
                        <hr>
                        <div class="row">
                          <div class="col-sm-3" >
                            <p class="mb-0">Cognome</p>
                          </div>
                          <div class="col-sm-9">
                            <p class="text-muted mb-0"> ></p>
                          </div>
                        </div>
                        <hr>
                        <div class="row">
                          <div class="col-sm-3">
                            <p class="mb-0">Email</p>
                          </div>
                          <div class="col-sm-9">
                            <p class="text-muted mb-0"> ></p>
                          </div>
                        </div>
                        <hr>
                        <div class="row">
                          <div class="col-sm-3" >
                            <p class="mb-0">Data di nascita</p>
                          </div>
                          <div class="col-sm-9">
                            <p class="text-muted mb-0"> ></p>
                          </div>
                        </div>
                        <hr>
                        <div class="row">
                          <div class="col-sm-3">
                            <p class="mb-0">Telefono</p>
                          </div>
                          <div class="col-sm-9">
                            <p class="text-muted mb-0"> ></p>
                          </div>
                        </div>
                        <hr>
                        <div class="row">
                          <div class="col-sm-3">
                            <p class="mb-0">Indirizzo</p>
                          </div>
                          <div class="col-sm-9">
                            <p class="text-muted mb-0"> ></p>
                          </div>
                        </div>
                      </div>
                    </ul>
                    </div>
                  </div>
                </div>
                <div class="row">
                <div class="col-lg-6">
                <div class="card text-white bg-secondary mb-3">
                <div class="card-header">Gestione giochi</div>
                <div class="card-body">
                <div class="d-grid gap-2">
                <div id="btn2">
                                            <a href="PaginaAggiungiGioco.jsp"><button class="btn btn-primario" type="button" style="background-color: #536f86;">Aggiungi gioco</button></a>
                                            <a href="PaginaModificaGioco.jsp"><button class="btn btn-secondario" type="button" style="background-color:#2c3b47;">Aggiorna gioco</button></a>
                                            <a href="PaginaEliminaGioco.jsp"><button class="btn btn-terziario" type="button" style="background-color: #171a21;">Rimuovi gioco</button></a>
                </div>
                </div>  
                </div>
                </div>      
                </div>
                </div>
                <div class="col-lg-6">
                <div class="card text-white bg-secondary mb-3">
                <div class="card-header">Gestione utenti</div>
                <div class="card-body">
                <div class="d-grid gap-2" >
                <div id="btn2">
                                        <a href="PaginaAggiungiUtente.jsp"><button class="btn btn-primario" type="button" style="background-color: #536f86;">Aggiungi un utente</button></a>
                                        <a href="PaginaSospendiUtente.jsp"><button class="btn btn-secondario" type="button" style="background-color:#2c3b47;">Sospendi un utente </button></a>
                                        <a href="PaginaEliminaUtente.jsp"><button class="btn btn-terziario" type="button" style="background-color: #171a21;">Rimuovi un utente</button></a>
                </div>  
                </div>
                </div>        
                </div>
                </div>
                </div>
                </div>
                       
             
            <footer class="footer" style="margin-top: 19vh;">
                <div class="content-logo d-flex justify-content-between">
                    <div class="footer-logo-steam">
                        <img src="https://store.akamai.steamstatic.com/public/images/v6/logo_steam_footer.png" alt="logo steam">
                    </div>
                    <div class="footer-valve">
                        <img src="https://store.akamai.steamstatic.com/public/images/footerLogo_valve_new.png" alt="logo">
                    </div>
                </div>
                <div class="content-footer color-white d-flex justify-content: center" id="footer_text"  >
                    Progetto ispirato a Steam per puri scopi didattici per il Master di Sviluppo Software e Applicazioni edizione Maggio. Gruppo di lavoro composto da Claudio Milano, Leandro Biccellari, Antonio Guglielmo e Simone Medori.
                </div>
            </footer>
</section>
</div>     
   
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>