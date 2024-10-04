<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/LogoutStyle.css">
    <title>Logout STEAM</title>
</head>
<body>
    <div class="container-fluid">
        <!-- Header row-->
        <div class="row header">      
            <header>
                <div class="container">
                    <img src="https://store.akamai.steamstatic.com/public/shared/images/header/logo_steam.svg?t=962016" alt="Steam logo" width="176" height="44">
                </div>
            </header> 
        </div>

        <!-- Content row-->
        <div class="row">
            <div class="col-lg-3">
                 
            </div>
            <div class="col-lg-6">
                <div id="box-1">
                    <div id="box-small">
                        <h2 class="mt-5">Logout completato</h2>
                        <p>Hai effettuato il logout correttamente. <br><a href="<%=request.getContextPath()%>/public-jsp/PaginaLogin.jsp">Effettua il login di nuovo</a>.</p>
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
