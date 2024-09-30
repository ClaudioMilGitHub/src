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

        // Verifica se il parametro action è nullo
        if (action == null || action.isEmpty()) {
            request.setAttribute("error", "Azione non valida.");
            request.getRequestDispatcher("private-jsp/ProfileUpdate.jsp").forward(request, response);
            return;
        }

        // Controlli specifici per ogni campo nell'aggiornamento
        switch (action) {
            case "updateUsername":
                String newUsername = request.getParameter("username");
                if (newUsername != null && !newUsername.trim().isEmpty()) {
                    // Procedi con l'aggiornamento dell'username
                    isUpdated = BusinessLogic.updateUtenteUsername(utenteLoggato, newUsername);
                } else {
                    request.setAttribute("error", "Il campo Username non può essere vuoto.");
                    request.getRequestDispatcher("private-jsp/ProfileUpdate.jsp").forward(request, response);
                    return;
                }
                break;

            case "updateDataNascita":
                String newDataNascitaStr = request.getParameter("dataNascita");
                if (newDataNascitaStr != null && !newDataNascitaStr.trim().isEmpty()) {
                    try {
                        LocalDate newDataNascita = LocalDate.parse(newDataNascitaStr);
                        // Procedi con l'aggiornamento della data di nascita
                        isUpdated = BusinessLogic.updateUtenteDataNascita(utenteLoggato, newDataNascita);
                    } catch (Exception e) {
                        request.setAttribute("error", "Formato della data non valido.");
                        request.getRequestDispatcher("private-jsp/ProfileUpdate.jsp").forward(request, response);
                        return;
                    }
                } else {
                    request.setAttribute("error", "Il campo Data di Nascita non può essere vuoto.");
                    request.getRequestDispatcher("private-jsp/ProfileUpdate.jsp").forward(request, response);
                    return;
                }
                break;

            case "updatePassword":
                String newPassword = request.getParameter("password");
                if (newPassword != null && !newPassword.trim().isEmpty()) {
                    // Procedi con l'aggiornamento della password
                    isUpdated = BusinessLogic.updateUtentePassword(utenteLoggato, newPassword);
                } else {
                    request.setAttribute("error", "Il campo Password non può essere vuoto.");
                    request.getRequestDispatcher("private-jsp/ProfileUpdate.jsp").forward(request, response);
                    return;
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
