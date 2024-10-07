package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Timestamp;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		response.sendRedirect("public-jsp/PaginaRegistrazione.jsp");
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username = request.getParameter("usernameFormInput");
		String email = request.getParameter("emailFormInput");
		String email2 = request.getParameter("email2FormInput");
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
		
		if(username == null || email == null || email2 == null || password == null || data == null || username.isEmpty() || email.isEmpty() || email2.isEmpty() || password.isEmpty() || data.isEmpty()) {
			request.setAttribute("messaggioDiErrore", "Riempire correttamente i campi.");
			request.getRequestDispatcher("public-jsp/PaginaRegistrazione.jsp").forward(request, response);
			return;
		}
		if(!email.equals(email2)) {
			request.setAttribute("messaggioDiErrore", "Confermare l'email in modo corretto.");
			request.getRequestDispatcher("public-jsp/PaginaRegistrazione.jsp").forward(request, response);
			return;
		}
		if(BusinessLogic.getAllUtenti() != null) {
			for(Utente u : BusinessLogic.getAllUtenti()) {
				if(u.getEmail().equals(email) || u.getUsername().equals(username)) {
					request.setAttribute("messaggioDiErrore", "Credenziali inserite non valide, email o username già esistenti.");
					request.getRequestDispatcher("public-jsp/PaginaRegistrazione.jsp").forward(request, response);
					System.out.println("Utente già presente");
					return;
				}
			}
		}
		
		System.out.println("is Valid? " + isValidPassword(password));
		if(!isValidPassword(password)) {
			request.setAttribute("messaggioDiErrore", "Password non corretta.");
			request.getRequestDispatcher("public-jsp/PaginaRegistrazione.jsp").forward(request, response);
			return;
		}
		LocalDate dataNascita = LocalDate.parse(data);
		BusinessLogic.addUtente(ruolo, username, email2, password, dataNascita);
		request.getRequestDispatcher("public-jsp/SuccessoRegistrazione.jsp").forward(request, response);
		
		
		
	}
	
	public boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;

        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$!?%^&+=])(?=\\S+$).{8,20}$";

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }

}
