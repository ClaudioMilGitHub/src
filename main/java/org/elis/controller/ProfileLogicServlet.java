package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.elis.model.Utente;

/**
 * Servlet implementation class ProfileLogicServlet
 */
public class ProfileLogicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileLogicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Otteniamo l'utente loggato dalla sessione
        HttpSession session = request.getSession(false);
        Utente utenteLoggato = (Utente) session.getAttribute("utenteLoggato");

        if (utenteLoggato == null) {
            // Se l'utente non è loggato, reindirizzalo alla pagina di login
            response.sendRedirect("public-jsp/Errore.jsp");
            return;
        }
        
        String ruolo = utenteLoggato.getRuolo().name();
        
        switch(ruolo) {
        case "UTENTE_BASE":
        	request.getRequestDispatcher("WEB-INF/private-jsp/Pagina_Utente.jsp").forward(request, response);
        	return;
        case "PUBLISHER":
        	request.getRequestDispatcher("WEB-INF/private-jsp/PaginaPublisher.jsp").forward(request, response);
        	return;
        case "ADMIN":
        	request.getRequestDispatcher("WEB-INF/private-jsp/PaginaAdmin.jsp").forward(request, response);
        	return;
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
