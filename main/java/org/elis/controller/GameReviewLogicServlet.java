package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.elis.businesslogic.BusinessLogic;
import org.elis.model.Gioco;
import org.elis.model.Recensione;
import org.elis.model.Utente;

/**
 * Servlet implementation class GameReviewLogicServlet
 */
public class GameReviewLogicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameReviewLogicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idGioco = request.getParameter("gameId");
		String utenteLoggatoId = request.getParameter("utenteLoggato");
		
		Utente utenteLoggato = BusinessLogic.getUtenteById(Long.parseLong(utenteLoggatoId));
		Gioco gioco = BusinessLogic.getGiocoById(Long.parseLong(idGioco));
		
		boolean hasReview = false;
		
		List<Recensione> listaRecensioni = BusinessLogic.getAllRecensioniByGame(gioco.getId());
		
		List<Recensione> CurrentUserReviews = BusinessLogic.getRecensioneByUtente(utenteLoggato);
		
		for (Recensione recensione : CurrentUserReviews) {
			if(recensione.getGioco().getId() == gioco.getId()) {
				hasReview = true;
			}
		}
		
		request.setAttribute("hasReview", hasReview);
		request.setAttribute("listaRecensioni", listaRecensioni);
		request.setAttribute("gioco", gioco);
		request.getRequestDispatcher("public-jsp/PaginaRecensioni.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
