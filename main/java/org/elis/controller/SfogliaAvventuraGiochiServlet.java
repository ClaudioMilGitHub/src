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
public class SfogliaAvventuraGiochiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SfogliaAvventuraGiochiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Gioco> listaGiochi = BusinessLogic.getAllGiochiByGenere(1);
		Genere g = BusinessLogic.getGenereByName("avventura");

		request.setAttribute("genere", g);
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
