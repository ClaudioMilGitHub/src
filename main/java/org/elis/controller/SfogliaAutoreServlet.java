package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.elis.businesslogic.BusinessLogic;
import org.elis.model.Genere;
import org.elis.model.Gioco;
import org.elis.model.Libreria;
import org.elis.model.Utente;

/**
 * Servlet implementation class SfogliaAutoreServlet
 */
public class SfogliaAutoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SfogliaAutoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String autoreInput = request.getParameter("autoreInputForm");
		System.out.println("autore input : " + autoreInput);
		
		
		Utente utente = BusinessLogic.getUtenteByName(autoreInput);
		List<Gioco> listaGiochi = BusinessLogic.getAllGiochiByIdUtente(utente.getId());
		request.setAttribute("autore", utente);
		request.setAttribute("listaPublisher", listaGiochi);
		request.getRequestDispatcher("public-jsp/SfogliaGiochiAutore.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
