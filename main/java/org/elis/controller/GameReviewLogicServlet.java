package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

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
		System.out.println(idGioco);
		Gioco gioco = BusinessLogic.getGiocoById(Long.parseLong(idGioco));
		
		request.setAttribute("gioco", gioco);
		request.getRequestDispatcher("public-jsp/PaginaRecensioni.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String testoForm = request.getParameter("reviewInputForm");
		String idReviewForm = request.getParameter("reviewIdInputForm");
		String idGioco = request.getParameter("gameIdForm");
		String recensioneDaEliminare = request.getParameter("idRecensione");
		String operation = request.getParameter("operation");
		System.out.println("Operazione: " + operation);
		switch(operation) {
		case "update":
			Recensione recensione = BusinessLogic.getRecensioneById(Long.parseLong("idReviewForm"));
			BusinessLogic.updateTestoRecensione(recensione, testoForm);
			break;
		case "delete":
			BusinessLogic.deleteRecensioneById(Long.parseLong(recensioneDaEliminare));
			break;
		}
		
		Gioco gioco = BusinessLogic.getGiocoById(Long.parseLong(idGioco));
		request.setAttribute("gioco", gioco);
		request.getRequestDispatcher("public-jsp/PaginaRecensioni.jsp").forward(request, response);
		
		
	}

}
