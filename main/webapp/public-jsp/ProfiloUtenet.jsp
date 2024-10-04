<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.elis.model.Utente" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/ProfileStyle.css">
    <title>Profilo Giocatore - STEAM</title>
</head>
<body>

    <% Utente utenteLoggato = (Utente) request.getAttribute("utenteLoggato"); %>
    
    <div class="container-fluid">
        <div class="profile-container mt-5 p-4">
            <div class="text-center">
                <img src="<%= utenteLoggato.getProfileImage() %>" alt="Immagine Profilo" class="img-fluid rounded-circle" style="width: 150px; height: 150px;">
                <h2 class="mt-3">Profilo di <%= utenteLoggato.getUsername() %></h2>
                <p class="text-muted">🎮 Giocatore di Steam</p>
            </div>

            <div class="profile-info mt-4">
                <h4>Informazioni Personali</h4>
                <p><strong>Username:</strong> <%= utenteLoggato.getUsername() %></p>
                <p><strong>Email:</strong> <%= utenteLoggato.getEmail() %></p>
                <p><strong>Data di Nascita:</strong> <%= utenteLoggato.getDataNascita() %></p>
                <p><strong>Ruolo:</strong> <%= utenteLoggato.getRuolo() %></p>
            </div>

            <div class="game-stats mt-4">
                <h4>Statistiche di Gioco</h4>
                <p><strong>Ore di Gioco:</strong> <%= utenteLoggato.getOreDiGioco() %> ⏳</p>
                <p><strong>Giochi Comprati:</strong> <%= utenteLoggato.getGiochiComprati() %> 🛒</p>
                <p><strong>Gioco Preferito:</strong> <%= utenteLoggato.getGiocoPreferito() %> ❤️</p>
            </div>

            <div class="text-center mt-4">
                <h4>Modifica Profilo</h4>
                <form action="<%=request.getContextPath()%>/UpdateProfileServlet" method="post">
                    <input type="hidden" name="action" value="updateUsername">
                    <div class="mb-3">
                        <label for="username" class="form-label">Nuovo Username</label>
                        <input type="text" class="form-control" id="username" name="username" placeholder="Inserisci nuovo username">
                    </div>
                    <button type="submit" class="btn btn-custom">Aggiorna Username</button>
                </form>

                <form action="<%=request.getContextPath()%>/UpdateProfileServlet" method="post" class="mt-3">
                    <input type="hidden" name="action" value="updateDataNascita">
                    <div class="mb-3">
                        <label for="dataNascita" class="form-label">Nuova Data di Nascita</label>
                        <input type="date" class="form-control" id="dataNascita" name="dataNascita">
                    </div>
                    <button type="submit" class="btn btn-custom">Aggiorna Data di Nascita</button>
                </form>

                <form action="<%=request.getContextPath()%>/UpdateProfileServlet" method="post" class="mt-3">
                    <input type="hidden" name="action" value="updatePassword">
                    <div class="mb-3">
                        <label for="password" class="form-label">Nuova Password</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="Inserisci nuova password">
                    </div>
                    <button type="submit" class="btn btn-custom">Aggiorna Password</button>
                </form>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-..."></script>
</body>
</html>
