<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Pagina Registrazione SteamFarlocco</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>
    <link rel="stylesheet" href="../CSS/SteamFarlocco.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <img src="../RES/TrenoSteam.png" width="100pv" class="Logo" alt="Logo">
    <div  class="container">
      
        <div class="row">
            <div class="col-xl-8">
                <p style="color:rgb(45, 47, 91);" class="descrizione">
                    Registrati sul nostro SteamFarlocco
                 </p>
            </div>
            <div class="row">
                    <div class="col-xl-12">
                <form action="<%=request.getContextPath()%>/RegistrationLogicServlet" method="post" class ="Dati">
                    <input type="email" placeholder="rino.rano@gmail.com" name="emailFormInput">
                
                    <input type="text" placeholder="username" name="usernameFormInput">

                    <input type="date" name="dataNascitaFormInput">
                    
                    <input type="password" placeholder="password" name="passwordFormInput">
                    
                    <select id="ruoloFormInput" name="ruoloFormInput">
                        <option value="UTENTE_BASE">Utente</option>
                        <option value="PUBLISHER">Publisher</option>
                    </select> 
                    
                    <input type="submit" value="Registrati">
                </form>
            </div>
    </div> 
</body>
</html>