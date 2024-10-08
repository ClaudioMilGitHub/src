package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.elis.businesslogic.BusinessLogic;
import org.elis.model.*;

/**
 * Servlet implementation class SfogliaAvventuraServlet
 */
public class SfogliaGiochiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SfogliaGiochiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String genereInput = request.getParameter("genereInputForm");
		
		Genere genere = BusinessLogic.getGenereByName(genereInput);
		long idGenere = genere.getId();
		
		List<Gioco> listaGiochi = BusinessLogic.getAllGiochiByGenere(idGenere);
		
		for (Gioco gioco : listaGiochi) {
			System.out.println(gioco.getNome());
			System.out.println(gioco.getId());
			System.out.println(gioco.getDescrizione());
		}
		
		request.setAttribute("genere", genere);
		request.setAttribute("listaGiochi", listaGiochi);
		request.getRequestDispatcher("WEB-INF/private-jsp/SfogliaGiochi.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}