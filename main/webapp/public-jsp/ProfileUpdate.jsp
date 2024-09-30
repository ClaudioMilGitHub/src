<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="org.elis.model.Utente" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Aggiornamento Profilo - SteamFarlocco</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2 class="mt-5">Aggiorna il tuo profilo</h2>

        <% 
            // Mostra eventuali messaggi di errore passati dal servlet
            String errorMessage = (String) request.getAttribute("error");
            if (errorMessage != null) {
        %>
            <div class="alert alert-danger"><%= errorMessage %></div>
        <% } %>

        <%
            // Recupera la sessione esistente
            HttpSession currentSession = session;

            if (currentSession == null || currentSession.getAttribute("utenteLoggato") == null) {
                // Se la sessione non esiste o l'utente non è loggato, reindirizza al login
                response.sendRedirect("public-jsp/PaginaLogin.jsp");
                return;
            }

            // Recupera l'utente loggato dalla sessione
            Utente utenteLoggato = (Utente) currentSession.getAttribute("utenteLoggato");
            
            // Recupera i dati dell'utente per mostrarli nel form
            String currentEmail = utenteLoggato.getEmail();
            String currentUsername = utenteLoggato.getUsername();
            String currentDataNascita = (utenteLoggato.getDataNascita() != null) ? utenteLoggato.getDataNascita().toString() : "";
        %>
        
        <form action="UpdateProfileServlet" method="post">
            <!-- Email (bloccata, non modificabile) -->
            <div class="form-group">
                <label for="email">Email (non modificabile)</label>
                <input type="email" class="form-control" id="email" name="email" value="<%= currentEmail %>" readonly>
            </div>

            <!-- Campo per aggiornare l'username -->
            <div class="form-group mt-3">
                <label for="username">Username</label>
                <input type="text" class="form-control" id="username" name="username" value="<%= currentUsername %>">
                <button type="submit" name="action" value="updateUsername" class="btn btn-primary mt-2">Aggiorna Username</button>
            </div>

            <!-- Campo per aggiornare la data di nascita -->
            <div class="form-group mt-3">
                <label for="dataNascita">Data di nascita</label>
                <input type="date" class="form-control" id="dataNascita" name="dataNascita" value="<%= currentDataNascita %>">
                <button type="submit" name="action" value="updateDataNascita" class="btn btn-primary mt-2">Aggiorna Data di Nascita</button>
            </div>

            <!-- Campo per aggiornare la password -->
            <div class="form-group mt-3">
                <label for="password">Nuova Password</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Inserisci nuova password (opzionale)">
                <button type="submit" name="action" value="updatePassword" class="btn btn-primary mt-2">Aggiorna Password</button>
            </div>
        </form>

    </div>
</body>
</html>
