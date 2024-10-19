package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.elis.businesslogic.BusinessLogic;
import org.elis.model.Utente;

/**
 * Servlet implementation class UpdateProfileServlet
 */
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
        Utente utenteLoggato = (Utente) session.getAttribute("utenteLoggato");

        if (utenteLoggato == null) {
            response.sendRedirect("public-jsp/Errore.jsp");
            return;
        }
		request.getRequestDispatcher("WEB-INF/private-jsp/ProfileUpdate.jsp").forward(request, response);
	}

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
        
        
        	String username = request.getParameter("username");
            String password = request.getParameter("password");
            String data = request.getParameter("dataNascita");
            
            //Update Username
            if(username != null && !username.trim().isEmpty()) {
                
            	// Controlla che lo username non sia già esistente
            	for(Utente u : BusinessLogic.getAllUtenti()) {
            		if(u.getUsername().equals(username)) {
            			request.setAttribute("error", "Username già selezionato.");
                    	request.getRequestDispatcher("WEB-INF/private-jsp/ProfileUpdate.jsp").forward(request, response);
                    	return;
            		}
            	}
            	// Procedi con l'aggiornamento dell'username
            	BusinessLogic.updateUtenteUsername(utenteLoggato, username); 
            }
            //Update Password
            if(password != null && !password.trim().isEmpty()) {
            	// Controlla che la password rispetti i parametri 
            	
            	if(!isValidPassword(password)) {
        			request.setAttribute("error", "Password non corretta. \n La Password deve contenere almeno una Lettera maiuscola, un carattere numerico, un carattere speciale [!?%&@], contenere un minimo di 8 caratteri e un massimo di 20.");
        			request.getRequestDispatcher("WEB-INF/private-jsp/ProfileUpdate.jsp").forward(request, response);
        			return;
        		}
            	// Procedi con l'aggiornamento della password
            	BusinessLogic.updateUtentePassword(utenteLoggato, password);
            }
            //Update Data di Nascità
            if (data != null && !data.trim().isEmpty()) {
                try {
                    LocalDate newDataNascita = LocalDate.parse(data);
                    // Procedi con l'aggiornamento della data di nascita
                    BusinessLogic.updateUtenteDataNascita(utenteLoggato, newDataNascita);
                } catch (Exception e) {
                	request.setAttribute("error", "Data non Valida.");
                    request.getRequestDispatcher("WEB-INF/private-jsp/Pagina_Utente.jsp").forward(request, response);
                    return;
                }
            }
        
        
        
     
        
		/*
		 * 
		 * 
		// Recupera l'azione specifica dal pulsante premuto
        String action = request.getParameter("action");
        // Verifica se il parametro action è nullo
        if (action == null || action.isEmpty()) {
            request.setAttribute("error", "Azione non valida.");
            request.getRequestDispatcher("WEB-INF/private-jsp/ProfileUpdate.jsp").forward(request, response);
            return;
        }
        
        
        
        
        
        // Controlli specifici per ogni campo nell'aggiornamento
        switch (action) {
            case "updateUsername":
                String newUsername = request.getParameter("username");
                if (newUsername != null && !newUsername.trim().isEmpty()) {
                    // Procedi con l'aggiornamento dell'username
                    BusinessLogic.updateUtenteUsername(utenteLoggato, newUsername);
                } else {
                  
                    request.getRequestDispatcher("WEB-INF/private-jsp/Pagina_Utente.jsp").forward(request, response);
                    return;
                }
                break;

            case "updateDataNascita":
                String newDataNascitaStr = request.getParameter("dataNascita");
                if (newDataNascitaStr != null && !newDataNascitaStr.trim().isEmpty()) {
                    try {
                        LocalDate newDataNascita = LocalDate.parse(newDataNascitaStr);
                        // Procedi con l'aggiornamento della data di nascita
                        BusinessLogic.updateUtenteDataNascita(utenteLoggato, newDataNascita);
                    } catch (Exception e) {
                        
                        request.getRequestDispatcher("WEB-INF/private-jsp/Pagina_Utente.jsp").forward(request, response);
                        return;
                    }
                } else {
                    
                    request.getRequestDispatcher("WEB-INF/private-jsp/Pagina_Utente.jsp").forward(request, response);
                    return;
                }
                break;

            case "updatePassword":
                String newPassword = request.getParameter("password");
                if (newPassword != null && !newPassword.trim().isEmpty()) {
                    // Procedi con l'aggiornamento della password
                    BusinessLogic.updateUtentePassword(utenteLoggato, newPassword);
                } else {
                    
                    request.getRequestDispatcher("WEB-INF/private-jsp/Pagina_Utente.jsp").forward(request, response);
                    return;
                }
                break;

            default:
                
                request.getRequestDispatcher("WEB-INF/private-jsp/Pagina_Utente.jsp").forward(request, response);
                return;
        }
        */

        // Aggiornamento riuscito, aggiorna l'utente nella sessione
        session.setAttribute("utenteLoggato", utenteLoggato);
        request.getRequestDispatcher("WEB-INF/private-jsp/Pagina_Utente.jsp").forward(request, response);
    }

public boolean isValidPassword(final String password) {

    Pattern pattern;
    Matcher matcher;

    final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$!?%^&+=])(?=\\S+$).{8,20}$";

    pattern = Pattern.compile(PASSWORD_PATTERN);
    matcher = pattern.matcher(password);

    return matcher.matches();

}

}
