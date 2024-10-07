<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Benvenuto su STEAM</title>
  
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/PaginaModificaGioco.css">
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
        </section>
              <div class="row">
                <div class="col-lg-12">
                    <fieldset>
            <legend>Modifica gioco</legend>
            <div class="form-group">
            <label for="gameSelect" style="color: white;">Seleziona un gioco:</label>
            <select id="gameSelect">
                <option value="" aria-placeholder="Seleziona il gioco">...</option>
           
            </select>
        </div>

        <div class="form-group">
            <label style="color: white;">Seleziona i campi da modificare:</label>
            <div class="checkbox-group">
                <label style="color: white;"><input type="checkbox" class="fieldCheckbox" value="name" style="color: white;"> Nome</label>
                <label style="color: white;"><input type="checkbox" class="fieldCheckbox" value="description" style="color: white;"> Descrizione</label>
                <label style="color: white;"><input type="checkbox" class="fieldCheckbox" value="price" style="color: white;"> Prezzo</label>
                <label style="color: white;"><input type="checkbox" class="fieldCheckbox" value="genere" style="color: white;"> Genere</label>
                <label style="color: white;"><input type="checkbox" class="fieldCheckbox" value="releaseDate" style="color: white;"> Data di Rilascio</label>
            </div>
        </div>

      
        <div id="modifyFields">
            <form id="modifyForm">
             
                <div class="form-group hidden" id="field-name">
                    <label for="name" style="color: white;">Nome</label>
                    <input type="text" id="name" name="name">
                </div>

                <div class="form-group hidden" id="field-description">
                    <label for="description" style="color: white;">Descrizione</label>
                    <textarea id="description" name="description" rows="4"></textarea>
                </div>

            
                <div class="form-group hidden" id="field-price">
                    <label for="price" style="color: white;">Prezzo</label>
                    <input type="number" id="price" name="price" min="0" step="0.01">
                </div>

                <div class="form-group hidden" id="field-genere">
                    <label for="genere" style="color: white;">Genere</label>
                    <input type="text" id="genere" name="genere">
                </div>

               
                <div class="form-group hidden" id="field-releaseDate">
                    <label for="releaseDate" style="color: white;">Data di rilascio</label>
                    <input type="date" id="releaseDate" name="releaseDate">
                </div>

                <button type="submit" class="Invio">Salva Modifiche</button>
            </form>
        </div>
    </div>
    </div>

    
        <div id="message" class="hidden"></div>
    </div>
    <footer class="footer" style="margin-top: 48.5vh;">
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
    <script src="../JS/PaginaModificaGioco.js"></script>
</body>
</html>