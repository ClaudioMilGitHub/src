package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.elis.businesslogic.BusinessLogic;
import org.elis.model.Gioco;
import org.elis.model.Libreria;
import org.elis.model.Utente;

/**
 * Servlet implementation class LibreriaServlet
 */
public class LibreriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibreriaServlet() {
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
		request.getRequestDispatcher("WEB-INF/private-jsp/PaginaLibreria.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utente utenteLoggato = (Utente)request.getSession().getAttribute("utenteLoggato");
		if(utenteLoggato == null) {
			response.sendRedirect("public-jsp/Errore.jsp");
			return;
		}
		System.out.println(utenteLoggato.getUsername());
		String prova = request.getParameter("addLib");
		if(prova.isEmpty() || prova == null) {
			System.out.println(prova);
			response.sendRedirect("public-jsp/Errore.jsp");
			return;
		}
		
		Gioco game = BusinessLogic.getGiocoByName(prova);
		
		Libreria l = BusinessLogic.getLibreriaByName(utenteLoggato.getUsername());
			if(l.getGioco().getNome().equals(game.getNome())) {
				response.sendRedirect("public-jsp/Errore.jsp");
				return;
			}
		
		
		
		BusinessLogic.aggiungiGiocoALibreria(utenteLoggato, game);
		response.sendRedirect("public-jsp/GiocoAddLibreria.jsp");
		
		
	}

}
