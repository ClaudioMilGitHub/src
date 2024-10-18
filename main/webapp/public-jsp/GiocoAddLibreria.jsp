<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/LogoutStyle.css">
    <title>STEAMfarlocco</title>
</head>
<body>
    <div class="container-fluid min-vh-100 d-flex flex-column">
        <!-- Header row-->
        <div class="row header">      
            <header>
                <div class="container">
                    <img src="https://store.akamai.steamstatic.com/public/shared/images/header/logo_steam.svg?t=962016" alt="Steam logo" width="176" height="44">
                </div>
            </header> 
        </div>

        <!-- Content row-->
        <div class="row flex-grow-1">
            <div class="col-lg-3">
                 
            </div>
            <div class="col-lg-6">
                <div id="box-1">
                    <div id="box-small">
                        <h2 class="mt-5">AGGIUNTO</h2>
                        <p>
                        Gioco Aggiunto Correttamente alla Libreria.
                        <a href="<%=request.getContextPath()%>/public-jsp/HomePage.jsp">
                        </a>
                        </p>
                    </div>
                </div> 
                           
            </div>
            <div class="col-lg-3">
                 
            </div>
            
        </div>

        <!-- Footer -->
        <%@include file="/includes/footer.jsp" %>
        
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
  
  	<script>
  	
  	 setTimeout(function() {
     	console.log('infunction');
         window.location.href = "<%=request.getContextPath()%>/index";
     }, 1500); // 1500 millisecondi = 1.5 secondi
     
  	</script>
   

    
    
</body>
</html>
