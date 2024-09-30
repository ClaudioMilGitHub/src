package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Timestamp;
import java.time.LocalDate;

import org.elis.businesslogic.BusinessLogic;
import org.elis.model.Utente;

/**
 * Servlet implementation class RegistrationLogicServlet
 */
public class RegistrationLogicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationLogicServlet() {
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
	
		String username = request.getParameter("usernameFormInput");
		String email = request.getParameter("emailFormInput");
		String password= request.getParameter("passwordFormInput");
		String stringaRuolo = request.getParameter("ruoloFormInput");
		int ruolo;
		switch(stringaRuolo) {
		case "UTENTE_BASE":
			ruolo = 1;
			break;
		case "PUBLISHER":
			ruolo = 2;
			break;
			default:
				ruolo = 1;
				
		}
		String data= request.getParameter("dataNascitaFormInput");
		
		if(username == null || email == null || password == null || data == null || username.isEmpty() || email.isEmpty() || password.isEmpty() || data.isEmpty()) {
			request.getRequestDispatcher("public-jsp/PaginaRegistrazione.jsp").forward(request, response);
			return;
		}
		
		for(Utente u : BusinessLogic.getAllUtenti()) {
			if(u.getEmail().equals(email) && u.getUsername().equals(username)) {
				request.getRequestDispatcher("public-jsp/PaginaRegistrazione.jsp").forward(request, response);
				System.out.println("Utente già presente");
				return;
			}
		}
		
		if(password.length() < 8) {
			request.getRequestDispatcher("public-jsp/PaginaRegistrazione.jsp").forward(request, response);
			System.out.println("password meno di 8 caratteri");
			return;
		}else if(password.equals(password.toLowerCase())) {
			request.getRequestDispatcher("public-jsp/PaginaRegistrazione.jsp").forward(request, response);
			System.out.println("maiuscole e minuscole");
			return;
		}else if(!password.contains("!") || !password.contains("?") || !password.contains("$")) {
			request.getRequestDispatcher("public-jsp/PaginaRegistrazione.jsp").forward(request, response);
			System.out.println("carattere speciale");
			return;
		}
		
		
		LocalDate dataNascita = LocalDate.parse(data);
		BusinessLogic.addUtente(ruolo, username, email, password, dataNascita);	
		response.sendRedirect("public-jsp/PaginaLogin.jsp");
	}

}
