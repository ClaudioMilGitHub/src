<%@ page import="org.elis.businesslogic.BusinessLogic" %>
<%@ page import="org.elis.model.Utente" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String email = request.getParameter("emailFormInput");
    String username = request.getParameter("usernameFormInput");
    String password = request.getParameter("passwordFormInput");
    String dataNascita = request.getParameter("dataNascitaFormInput");

    Utente nuovoUtente = BusinessLogic.addUtente(1, username, email, password);  // Ruolo utente fisso a 1

    if (nuovoUtente != null) {
        // Registrazione riuscita
        out.println("<p>Registrazione avvenuta con successo!</p>");
        out.println("<a href='Login.jsp'>Vai al login</a>");
    } else {
        // Errore nella registrazione
        out.println("<p>Errore nella registrazione. Riprova!</p>");
        out.println("<a href='Registrazione.jsp'>Torna alla registrazione</a>");
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Pagina_Registrazione_SteamFarlocco</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>
    <link rel="stylesheet" href="../CSS/SteamFarlocco.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <h1>STEAM (Farlocco)</h1>
<div  class="container">
      
        <div class="row">
            <div class="col-xl-12">
                <img src="../RES/TrenoSteam.png" width="100pv" class="Logo" alt="Logo">
            </div>
        </div>
        <div class="row">
            <div class="col-xl-12">      
                <form action="" method="post" class ="Dati">
                    <input type="email" placeholder="rino.rano@gmail.com" name="emailFormInput">
                
                    <input type="text" placeholder="username" name="usernameFormInput">

                    <input type="date" name="dataNascitaFormInput">
                    
                    <input type="password" placeholder="password" name="passwordFormInput">
                </form>
            </div>
        </div>
        <div class="row">
            <div class="col-xl-12" >  
                <div class ="Dati">  
                    <p style="color:rgb(45, 47, 91);" id="selezioneU">Che tipo di utente sei?</p>
                    <select id="ruoloFormInput">
                        <option value="UTENTE_BASE">Utente</option>
                        <option value="PUBLISHER">Publisher</option>
                    </select> 
                    <p style="color:rgb(45, 47, 91);" id="avvertimento">
                        (*il PUBLISHER può anche caricare il proprio gioco)
                    </p>
                    <input type="submit" value="Registrati">
                </div>
            </div>
        </div>
                    
            
</div>

                    
                  
               
</body>
</html>
