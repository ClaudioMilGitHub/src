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
 * Servlet implementation class DeleteReviewServlet
 */
public class DeleteReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReviewServlet() {
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
		boolean hasReview;
		String idGioco = request.getParameter("gameIdForm");
		String idRecensione = request.getParameter("reviewIdInputForm");
		BusinessLogic.deleteRecensioneById(Long.parseLong(idRecensione));
		Gioco gioco = BusinessLogic.getGiocoById(Long.parseLong(idGioco));
		List<Recensione> listaRecensioni = BusinessLogic.getAllRecensioniByGame(gioco.getId());
		hasReview = false;
		request.setAttribute("listaRecensioni", listaRecensioni);
		request.setAttribute("hasReview", hasReview);
		request.setAttribute("gioco", gioco);
		request.getRequestDispatcher("public-jsp/PaginaRecensioni.jsp").forward(request, response);
	}

}
