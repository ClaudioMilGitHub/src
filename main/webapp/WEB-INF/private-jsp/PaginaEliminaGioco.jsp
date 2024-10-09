<%@page import="org.elis.businesslogic.BusinessLogic"%>
<%@page import="org.elis.model.Gioco"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Pagina_Elimina_Gioco</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/PaginaEliminaGioco.css">
    
</head>
<body>
<div class="container-fluid">
<section>
        <div class="row navbar mb-3" style="background-color: #171a21;">
            <nav class="navbar navbar-expand-lg">
                <div class="container">
                <a class="navbar-brand" href="HomePageUtente.jsp">
                <img src="https://store.akamai.steamstatic.com/public/shared/images/header/logo_steam.svg?t=962016" alt="Steam logo" width="176" height="44">
                </a>
                <button class="navbar-toggler navbar-dark" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
                </button>
                    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                    <a class="nav-link" aria-current="page" href="HomePageUtente.jsp">Home</a>
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
                        </div>
                </nav>
            </div>

            <div class="row">
            <div class="col-lg-12">
                <form action="<%=request.getContextPath()%>/DeleteGameLogicServlet" method="post">
                    <fieldset>
                                <legend>Elimina gioco</legend>
                    <div class="mb-3">
                    <div class="form-group">
                                <label for="gameSelect" style="color: white;">Seleziona il gioco da eliminare:</label>
                            <select id="gameSelect" name="game" class="form-select">
                                <option value="" aria-placeholder="Seleziona il gioco">...</option>
                                <%
                                for(Gioco g : BusinessLogic.getAllGiochi()){ %>
                                
                                <option value="<%=g.getNome() %>" aria-placeholder=""><%=g.getNome() %></option>
                                
                                <%} %>
                            </select>
                    </div>
                    </div>
                  
                                <button type="submit" class="Elimina" style="margin-top: 5vh;" >ELIMINA</button>
                    
                    </fieldset>
                </form>
            </div>
            </div>
                    
       
        <footer class="footer">
                <div class="content-logo d-flex justify-content-between">
                <div class="footer-logo-steam">
                            <img src="https://store.akamai.steamstatic.com/public/images/v6/logo_steam_footer.png" alt="logo steam">
                <div class="footer-valve">
                            <img src="https://store.akamai.steamstatic.com/public/images/footerLogo_valve_new.png" alt="logo">
                </div>
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