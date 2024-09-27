package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import org.elis.businesslogic.BusinessLogic;
import org.elis.model.Utente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import org.elis.businesslogic.BusinessLogic;
import org.elis.model.Utente;

/**
 * Servlet implementation class UpdateProfileServlet
 */
@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Ottieni i dati dal form inviato
        String newUsername = request.getParameter("username");
        String newPassword = request.getParameter("password");
        String newDataNascita = request.getParameter("dataNascita");

        // Otteniamo l'utente loggato dalla sessione
        HttpSession session = request.getSession(false);
        Utente utenteLoggato = (Utente) session.getAttribute("utenteLoggato");

        if (utenteLoggato == null) {
            // Se l'utente non è loggato, reindirizzalo alla pagina di login
            response.sendRedirect("public-jsp/PaginaLogin.jsp");
            return;
        }

        // Verifica che i campi obbligatori non siano vuoti
        if (newUsername == null || newUsername.isEmpty() ||
            newDataNascita == null || newDataNascita.isEmpty()) {
            request.setAttribute("error", "I campi obbligatori non possono essere vuoti.");
            request.getRequestDispatcher("private-jsp/ProfileUpdate.jsp").forward(request, response);
            return;
        }

        // Aggiorna solo i campi modificati
        utenteLoggato.setUsername(newUsername);
        utenteLoggato.setDataNascita(newDataNascita);

        // Se è stata inserita una nuova password, aggiorna anche quella
        if (newPassword != null && !newPassword.isEmpty()) {
            utenteLoggato.setPassword(newPassword);
        }

        // Salva le modifiche nel database tramite BusinessLogic
        boolean isUpdated = BusinessLogic.updateUtente(utenteLoggato);

        if (isUpdated) {
            // Se l'aggiornamento è riuscito, aggiorna l'utente nella sessione e reindirizza alla pagina di successo
            session.setAttribute("utenteLoggato", utenteLoggato);
            response.sendRedirect("private-jsp/ProfileUpdatedSuccess.jsp");
        } else {
            // Se l'aggiornamento fallisce, mostra un messaggio di errore
            request.setAttribute("error", "Si è verificato un errore durante l'aggiornamento del profilo.");
            request.getRequestDispatcher("private-jsp/ProfileUpdate.jsp").forward(request, response);
        }
    }

}