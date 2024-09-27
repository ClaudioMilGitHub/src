package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Timestamp;

import org.elis.businesslogic.BusinessLogic;

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
		int ruolo = request.getParameter("ruoloFormInput");
		String dataNascita= request.getParameter("dataNascitaFormInput");
		
		if(username == null || email == null || password == null || dataNascita == null || username.isEmpty() || email.isEmpty() || password.isEmpty() || dataNascita.isEmpty()) {
			request.getRequestDispatcher("public-jsp/PaginaRegistrazione.jsp").forward(request, response);
			return;
		}
		
		BusinessLogic.addUtente(ruolo, username, email, password, dataNascita);	
		response.sendRedirect("public-jsp/PaginaLogin.jsp");
	}

}
