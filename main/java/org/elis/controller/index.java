package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.elis.businesslogic.BusinessLogic;
import org.elis.model.Utente;
import org.elis.model.Gioco;

/**
 * Servlet implementation class index
 */
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utente loggato = (Utente) request.getSession().getAttribute("utenteLoggato");
		
		if(loggato != null) {
			switch(loggato.getRuolo()) {
			case UTENTE_BASE:  case PUBLISHER:  case ADMIN:
				
				List<Gioco> listaGiochi = BusinessLogic.getAllGiochi();
				request.setAttribute("listaGiochi", listaGiochi);
				request.getRequestDispatcher("public-jsp/HomePage.jsp").forward(request, response);
				return;
			
			default:
				response.sendRedirect("public-jsp/Errore.jsp");
				return;
			}
			
		}
		
		List<Gioco> listaGiochi = BusinessLogic.getAllGiochi();
		request.setAttribute("listaGiochi", listaGiochi);
		request.getRequestDispatcher("public-jsp/HomePage.jsp").forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
