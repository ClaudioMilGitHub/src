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
import org.elis.model.Utente;

/**
 * Servlet implementation class DeleteGameLogicServlet
 */
public class DeleteGameLogicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteGameLogicServlet() {
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
		request.getRequestDispatcher("WEB-INF/private-jsp/PaginaEliminaGioco.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
        Utente utenteLoggato = (Utente) session.getAttribute("utenteLoggato");

        if (utenteLoggato == null) {
            response.sendRedirect("public-jsp/Errore.jsp");
            return;
        }
        System.out.println("prima input");
        String nome = request.getParameter("game");
        System.out.println("dopo input");
        for(Gioco g : BusinessLogic.getAllGiochi()) {
        	if(g.getNome().equals(nome)) {
        		BusinessLogic.deleteGiocoByNome(nome);
        	}
        }
        System.out.println("dopo ciclo");
        request.getRequestDispatcher("public-jsp/SuccessoRegistrazione.jsp").forward(request, response);
        
	}

}
