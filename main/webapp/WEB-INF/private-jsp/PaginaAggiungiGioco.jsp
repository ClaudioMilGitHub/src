<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/PaginaAggiungiGioco.css">
    <title>Benvenuto su STEAM</title>
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
                <div class="col-lg-12">
                    <form>
                        <fieldset>
                          <legend>Aggiungi il tuo gioco</legend>
                          <div class="mb-3">
                            <label for="TextInput" class="form-label" style="color: white;">Nome</label>
                            <input type="text" id="TextInput" class="form-control" placeholder="Nome del gioco">
                          </div>
                          <div class="form-group">
                            <label for="FormControlTextarea1" style="color: white;">Descrizione</label>
                            <textarea class="form-control" id="FormControlTextarea1" rows="3" placeholder="Aggiungi una descrizione..."></textarea>
                          </div>
                        </form>
                            <div class="form-group">
                                <p  style="color: white; margin-top: 2vh;">Prezzo</p>
                                <input type="range" name="range" class="Range" step="0.1" min="0" max="80" value="" onchange="rangePrimary.value=value">
                            <div class="Prezzo">
                                <input type="text" id="rangePrimary" placeholder="€">€</input>
                            
                            </div>
                        </div>
                          <div class="mb-3">
                            <label for="Select" class="form-label" style="color: white;">Genere</label>
                            <select id="Select" class="form-select">
                              <option></option>
                              <option></option>
                              <option></option>
                              <option></option>
                            </select>
                          </div>
                          <div>
                            <label style="color: white;">Data di rilascio:
                            <input type="date" name="rilascio">
                            </label>
                        </div>  
                          <div class="mb-3" id="Bottone" style="display: flex; justify-content: center;">
                          <button type="submit" class="btn btn-primary" style="background-color: #171a21;">Invia</button>
                        </fieldset>
                      </form>
                </div>
              </div>
                  
            <footer class="footer">
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