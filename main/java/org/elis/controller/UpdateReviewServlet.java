package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.elis.businesslogic.BusinessLogic;
import org.elis.model.Gioco;
import org.elis.model.Recensione;

/**
 * Servlet implementation class AddReviewServlet
 */
public class UpdateReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean hasReview = true;
		String idGioco = request.getParameter("gameIdForm");
		String idRecensione = request.getParameter("reviewIdInputForm");
		String testo = request.getParameter("reviewInputForm");
		Recensione recensione = BusinessLogic.getRecensioneById(Long.parseLong(idRecensione));
		
		if(testo.isEmpty()) {
					
			Gioco gioco = BusinessLogic.getGiocoById(Long.parseLong(idGioco));
			List<Recensione> listaRecensioni = BusinessLogic.getAllRecensioniByGame(gioco.getId());
			request.setAttribute("errorMessage", "Il campo testo non può essere vuoto!");
			request.setAttribute("listaRecensioni", listaRecensioni);
			request.setAttribute("hasReview", hasReview);
			request.setAttribute("gioco", gioco);
			request.getRequestDispatcher("public-jsp/PaginaRecensioni.jsp").forward(request, response);
			return;
			
		}
		 
		BusinessLogic.updateTestoRecensione(recensione, testo);
		Gioco gioco = BusinessLogic.getGiocoById(Long.parseLong(idGioco));
		List<Recensione> listaRecensioni = BusinessLogic.getAllRecensioniByGame(gioco.getId());
		
		request.setAttribute("listaRecensioni", listaRecensioni);
		request.setAttribute("hasReview", hasReview);
		request.setAttribute("gioco", gioco);
		request.getRequestDispatcher("public-jsp/PaginaRecensioni.jsp").forward(request, response);
	}

}
