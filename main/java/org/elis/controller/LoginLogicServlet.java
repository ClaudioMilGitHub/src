package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import org.elis.businesslogic.BusinessLogic;
import org.elis.model.*;

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
		HttpSession session = request.getSession();
		
		
		String email = request.getParameter("emailFormLogin");
		String password= request.getParameter("passwordFormLogin");
		String checkboxValue = request.getParameter("checkboxFormLogin");
		
		//Controllo che i campi non siano vuoti o nulli
		if(email == null || password == null || email.isBlank() || password.isBlank()) {
			request.setAttribute("messaggioDiErrore", "Riempire correttamente i campi.");
			request.getRequestDispatcher("public-jsp/PaginaLogin.jsp").forward(request, response);
			return;
		}
		//Controlla che le credenziali inserite siano corrette
		Utente u = BusinessLogic.loginUtente(email, password);
		
		//In caso l'utente abbia inserito le credenziali corrette, indirizza alla home page
		if(u != null) {
			
			if(u.isSuspended()) {
				request.setAttribute("messaggioDiErrore", "Utente sospeso.");
				request.getRequestDispatcher("public-jsp/PaginaLogin.jsp").forward(request, response);
				return;
			}
			//Verifica se la checkbox sia checked, per i cookies
			if(checkboxValue != null) {
				Cookie emailCookie = new Cookie("emailKey", email);
				Cookie passwordCookie = new Cookie("passwordKey", password);
				
				response.addCookie(emailCookie);
				response.addCookie(passwordCookie);
			}

			/*if(u.getRuolo() == Ruolo.PUBLISHER) {
				request.getRequestDispatcher("WEB-INF/private-jsp/HomePagePublisher.jsp").forward(request, response);
				return;
			}
			if(u.getRuolo() == Ruolo.ADMIN) {
				request.getRequestDispatcher("WEB-INF/private-jsp/HomePageAdmin.jsp").forward(request, response);
				return;
			}*/
			session.setAttribute("utenteLoggato", u);
			List<Gioco> listaGiochi = BusinessLogic.getAllGiochi();
			request.setAttribute("listaGiochi", listaGiochi);
			request.getRequestDispatcher("public-jsp/HomePage.jsp").forward(request, response);
			return;
			
		}else {
			request.setAttribute("messaggioDiErrore", "Credenziali Errate.");
			request.getRequestDispatcher("public-jsp/PaginaLogin.jsp").forward(request, response);
		}
	}
}