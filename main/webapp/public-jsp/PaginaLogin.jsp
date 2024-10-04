<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagina di Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/LoginStyle.css">
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
            <div class="col-lg-3 col-sm mb-3 d-none d-lg-block">
                 
            </div>
            <div class="col-lg-6 ">
                <div id="box-1">
                    <form action="<%=request.getContextPath()%>/LoginLogicServlet" method="post">
                        <div id="div-1">
                            <label id="label-e" for="Email" class="form-label">EMAIL ADDRESS</label>
                            <input type="email" class="form-control" id="Email" placeholder="mario.rossi@gmail.com" name="emailLogin">
                                    
                        </div>
                                
                        <div id="div-1">
                            <label id="label-p" for="Password" class="form-label">PASSWORD</label>
                            <input type="password" id="Password" class="form-control" name="passwordLogin">                
                        </div>
    
                        <div id="div-2">
                            <input type="submit" value="LOGIN"  class="btn btn-outline-primary" id="btn">
                            
                        </div>
                        <div>
                        <%String messaggio = (String)request.getAttribute("messaggioDiErrore");
					        if(messaggio != null){ %>
					        <div>
					        	<p><%=messaggio %></p>
					        </div>
					        <%} %>
                        </div>
                     
                    </form>
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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>