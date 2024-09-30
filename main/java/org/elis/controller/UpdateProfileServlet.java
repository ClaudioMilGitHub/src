package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;

import org.elis.businesslogic.BusinessLogic;
import org.elis.model.Utente;

/**
 * Servlet implementation class UpdateProfileServlet
 */
@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Otteniamo l'utente loggato dalla sessione
        HttpSession session = request.getSession(false);
        Utente utenteLoggato = (Utente) session.getAttribute("utenteLoggato");

        if (utenteLoggato == null) {
            // Se l'utente non è loggato, reindirizzalo alla pagina di login
            response.sendRedirect("public-jsp/PaginaLogin.jsp");
            return;
        }

        // Recupera l'azione specifica dal pulsante premuto
        String action = request.getParameter("action");
        boolean isUpdated = false;

        switch (action) {
            case "updateUsername":
                String newUsername = request.getParameter("username");
                if (newUsername != null && !newUsername.isEmpty()) {
                    isUpdated = BusinessLogic.updateUtenteUsername(utenteLoggato, newUsername);
                }
                break;

            case "updateDataNascita":
                String newDataNascitaStr = request.getParameter("dataNascita");
                LocalDate newDataNascita = null;
                if (newDataNascitaStr != null && !newDataNascitaStr.isEmpty()) {
                    newDataNascita = LocalDate.parse(newDataNascitaStr);
                    isUpdated = BusinessLogic.updateUtenteDataNascita(utenteLoggato, newDataNascita);
                }
                break;

            case "updatePassword":
                String newPassword = request.getParameter("password");
                if (newPassword != null && !newPassword.isEmpty()) {
                    isUpdated = BusinessLogic.updateUtentePassword(utenteLoggato, newPassword);
                }
                break;

            default:
                request.setAttribute("error", "Azione non valida.");
                request.getRequestDispatcher("private-jsp/ProfileUpdate.jsp").forward(request, response);
                return;
        }

        if (isUpdated) {
            // Se l'aggiornamento è riuscito, aggiorna l'utente nella sessione
            session.setAttribute("utenteLoggato", utenteLoggato);
            response.sendRedirect("private-jsp/ProfileUpdatedSuccess.jsp");
        } else {
            // Se l'aggiornamento fallisce, mostra un messaggio di errore
            request.setAttribute("error", "Si è verificato un errore durante l'aggiornamento del profilo.");
            request.getRequestDispatcher("private-jsp/ProfileUpdate.jsp").forward(request, response);
        }
    }
}
