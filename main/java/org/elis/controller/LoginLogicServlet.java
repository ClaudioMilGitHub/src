package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.elis.businesslogic.BusinessLogic;
import org.elis.model.Ruolo;
import org.elis.model.Utente;

/**
 * Servlet implementation class LoginLogicServlet
 */
public class LoginLogicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginLogicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("public-jsp/PaginaLogin.jsp");
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("emailLogin");
		String password= request.getParameter("passwordLogin");
		
		if(email == null || password == null || email.isBlank() || password.isBlank()) {
			request.setAttribute("messaggioDiErrore", "Riempire correttamente i campi.");
			request.getRequestDispatcher("public-jsp/PaginaLogin.jsp").forward(request, response);
			return;
		}
		
		Utente u = BusinessLogic.loginUtente(email, password);
		if(u != null) {
			if(u.getRuolo() == Ruolo.PUBLISHER) {
				request.getRequestDispatcher("WEB-INF/private-jsp/HomePagePublisher.jsp").forward(request, response);
				return;
			}
			if(u.getRuolo() == Ruolo.ADMIN) {
				request.getRequestDispatcher("WEB-INF/private-jsp/HomePageAdmin.jsp").forward(request, response);
				return;
			}
			request.getRequestDispatcher("public-jsp/HomePage.jsp").forward(request, response);
		}else {
			request.setAttribute("messaggioDiErrore", "Credenziali Errate.");
			request.getRequestDispatcher("public-jsp/PaginaLogin.jsp").forward(request, response);
		}
	}
}