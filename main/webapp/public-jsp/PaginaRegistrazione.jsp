<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagina di Registrazione</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/PaginaRegistrazioneStyle.css">
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
            <div class="col-lg-1 ">
                 
            </div>
            <div class="col-lg-6 ">
                <div id="box-1">
                    <form action="<%=request.getContextPath()%>/RegistrationLogicServlet" method="post" class ="row g-3">
                       
                        <div class="col-mb-12 col-auto">
                            <label for="emailFormInput" class="form-label">EMAIL ADDRESS</label>
                            <input class="form-control" type="email" placeholder="rino.rano@gmail.com" name="emailFormInput">
                          </div>
                          <div class="col-mb-12 col-auto">
                            <label for="usernameFormInput" class="form-label">USERNAME</label>
                            <input class="form-control" type="text" placeholder="username" name="usernameFormInput">
                          </div>
                          <div class="col-mb-12 col-auto">
                            <label for="passwordFormInput" class="form-label">PASSWORD</label>
                            <input type="password" placeholder="password" name="passwordFormInput" class="form-control">
                          </div>
                          
                        <div class="col-md-7 col-auto">
                            <label for="dataNascitaFormInput" class="form-label">DATA DI NASCITA</label>
                            <input type="date" name="dataNascitaFormInput" class="form-control">
                        </div>
                        <div class="col-md-7 col-auto">
                            <label for="ruoloFormInput" class="form-label">RUOLO</label>
                            <select id="ruoloFormInput" name="ruoloFormInput" class="form-control">
                                <option value="UTENTE_BASE">Utente</option>
                                <option value="PUBLISHER">Publisher</option>
                            </select>
                        </div>
                        <div id="div-2" class="col-md-12 col-auto">
                            <input type="submit" value="REGISTRATI"  class="btn btn-outline-primary" id="btn">
                        </div>

                    </form>
            </div> 
                           
            </div>
            <div class="col-lg-5">
                <%String messaggio = (String)request.getAttribute("messaggioDiErrore");
					        if(messaggio != null){ %>
					        
					        <div id="box-e" class="p-3 mb-2 bg-dark text-white""><%=messaggio %></div>
					        <%} %>
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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>