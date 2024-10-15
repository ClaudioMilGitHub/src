<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.elis.model.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/PaginaAggiungiGioco.css">
    <title>Pagina_Aggiungi_Gioco</title>
</head>
<body>
    
    <% Utente utenteLoggato = (Utente) session.getAttribute("utenteLoggato"); %>

    <div class="container-fluid">

        <!--  NavBar  -->
        <% request.setAttribute("utenteLoggato", utenteLoggato); %>
        <jsp:include page="/includes/navbar.jsp"/>

        <!-- Page -->
        <div class="row">
            <div class="col-lg-12">
                <form id="gameForm" action="<%= request.getContextPath() %>/AddGameLogicServlet" method="post" enctype="multipart/form-data">
                    <fieldset>
                        <legend>Aggiungi il tuo gioco</legend>
                        
                        <!-- Nome del gioco -->
                        <div class="mb-3">
                            <label for="TextInput" class="form-label" style="color: white;">Nome</label>
                            <input type="text" id="TextInput" class="form-control" placeholder="Nome del gioco" name="nomeFormGioco">
                        </div>

                        <!-- Descrizione del gioco -->
                        <div class="form-group">
                            <label for="FormControlTextarea1" style="color: white;">Descrizione</label>
                            <textarea class="form-control" id="FormControlTextarea1" rows="3" placeholder="Aggiungi una descrizione..." name="descrizioneFormGioco"></textarea>
                        </div>

                        <!-- Genere del gioco -->
                        <div class="mb-3">
                            <label for="Select" class="form-label" style="color: white; margin-top: 2vh;">Genere</label>
                            <select id="Select" class="form-select" name="genereFormGioco">
                                <option>Genere</option>
                                <option value="Strategia">Strategia</option>
                                <option value="Avventura">Avventura</option>
                                <option value="Azione">Azione</option>
                            </select>
                        </div>

                        <!-- Offerte -->
                        <div class="mb-3">
                            <label for="offers" style="color: white;">Offerte</label>
                            <select id="select" name="offers" class="form-select">
                                <option value="Sconto">Sconto</option>
                                <option value="Natale">Natalizio</option>
                                <option value="Halloween">Sconti dell'orrore</option>
                                <option value="Black Friday">Black Friday</option>
                                <option value="Blue Monday">Blue Monday</option>
                            </select>
                        </div>

                        <!-- Immagine di copertina -->
                        <div class="row">
                            <div class="col-lg-6">
                                <label for="coverImage" style="color: white;">Immagine di Copertina:</label>
                                <input type="file" id="coverImage" name="coverImage" accept="image/*" required>
                            </div>
                        </div>

                        <!-- Prezzo del gioco -->
                        <div class="row">
                            <div class="col-lg-6">
                                <div style="display: flex; flex-direction: column;">
                                    <label for="rangePrimary" style="color: white; display: flex; justify-content: center; margin-bottom: 2%;">Prezzo</label>
                                    <input type="range" name="range" class="Range" step="0.1" min="0" max="80" value="" onchange="rangePrimary.value=value">
                                    <input type="text" name="prezzoFormGioco" id="rangePrimary" placeholder="€" style="border-left: 2vh; border-radius: 5px; margin-top: 2%;">
                                </div>
                            </div>
                        </div>

                        <!-- Data di rilascio -->
                        <div class="row">
                            <div class="col-lg-12">
                                <div style="display: flex; flex-direction: column;">
                                    <label for="releaseDate" style="color: white; display: flex; justify-content: center; margin-bottom: 2vh;">Data di rilascio</label>
                                    <input type="date" id="releaseDate" name="releaseDateFormGioco" style="border-radius: 5px;">
                                </div>
                            </div>
                        </div>

                        <!-- Pulsante di invio -->
                        <div class="mb-3">
                            <button type="submit" class="Invio">Invio</button>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>

        <!-- Footer -->
        <jsp:include page="/includes/footer.jsp"/>

    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-wEmeIV1mKuiNp0TcNyvP2Nc36wWct5OSs1RbZxPDlvzf7z4xi1ywZyO8RXUnp4an" crossorigin="anonymous"></script>

</body>
</html>
