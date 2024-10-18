package org.elis.controller;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.elis.businesslogic.BusinessLogic;
import org.elis.model.Utente;

/**
 * Servlet implementation class GestioneUtenteServlet
 */
public class GestioneUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestioneUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Utente> listaUtenti = BusinessLogic.getAllUtenti();
		request.setAttribute("listaUtenti", listaUtenti);
		request.getRequestDispatcher("WEB-INF/private-jsp/GestioneUtente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String operation = request.getParameter("operation");
		
		switch(operation) {
		case "suspend":
			Utente utente = BusinessLogic.getUtenteByName(username);
			utente = BusinessLogic.updateUtenteSuspension(utente, true);		
			break;
		case "delete":
			BusinessLogic.deleteUtenteByNome(username);
			break;
		case "resume":
			Utente suspendedUser = BusinessLogic.getUtenteByName(username);
			utente = BusinessLogic.updateUtenteSuspension(suspendedUser, false);
			break;
		}
		
		request.getRequestDispatcher("WEB-INF/private-jsp/GestioneUtente.jsp").forward(request, response);	
	}

}
