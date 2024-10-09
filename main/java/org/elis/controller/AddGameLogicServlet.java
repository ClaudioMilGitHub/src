package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;

import javax.swing.plaf.nimbus.NimbusStyle;

import org.elis.businesslogic.BusinessLogic;
import org.elis.model.Gioco;
import org.elis.model.Offerta;
import org.elis.model.Utente;

/**
 * Servlet implementation class AddGameLogicServlet
 */
public class AddGameLogicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGameLogicServlet() {
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
		request.getRequestDispatcher("WEB-INF/private-jsp/PaginaAggiungiGioco.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inizio");
		String nome = request.getParameter("nomeFormGioco");
		String descrizione = request.getParameter("descrizioneFormGioco");
		String genere = request.getParameter("genereFormGioco");
		String offerte = request.getParameter("offers");
		System.out.println(offerte);
		String img = request.getParameter("imgFormGioco");
		String img2 = request.getParameter("img2");
		Offerta offerta = null;
		System.out.println(img + "\n" + img2 + "\n");
		String prezzo2 = request.getParameter("prezzoFormGioco");
		String data = request.getParameter("releaseDateFormGioco");
		System.out.println("dopo input");
		if(nome == null || descrizione == null || genere == null || prezzo2 == null || data == null || nome.isEmpty() || descrizione.isEmpty() || genere.isEmpty() || prezzo2.isEmpty() || data.isEmpty()) {
			System.out.println("riempire correttamente i campi");
			request.getRequestDispatcher("WEB-INF/private-jsp/PaginaAggiungiGioco.jsp").forward(request, response);
			return;
		}
		for(Gioco g : BusinessLogic.getAllGiochi()) {
			if(g.getNome().equals(nome)) {
				System.out.println("nome già esistente");
				request.getRequestDispatcher("WEB-INF/private-jsp/PaginaAggiungiGioco.jsp").forward(request, response);
				return;
			}
		}
		
		if(offerte != null || !offerte.isEmpty() ) {
			System.out.println("offerte inserite");
			for(Offerta o: BusinessLogic.getAllOfferta()) {
				if(o.getNome().equals(offerte)) {
					offerta = o;
				}
			}
		}
		System.out.println("inizio parte finale");
		Utente utenteLoggato = (Utente)request.getSession().getAttribute("utenteLoggato");
		double prezzo = Double.parseDouble(prezzo2);
		LocalDate dataRilascio = LocalDate.parse(data);
		BusinessLogic.addGioco(nome, dataRilascio, descrizione, null, prezzo, offerta, utenteLoggato);
		System.out.println("fine! Gioco caricato");
		request.getRequestDispatcher("WEB-INF/private-jsp/PaginaPublisher.jsp").forward(request, response);
	}
	
	

}
