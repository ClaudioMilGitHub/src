package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.elis.businesslogic.BusinessLogic;
import org.elis.model.Gioco;
import org.elis.model.Offerta;
import org.elis.model.Utente;

/**
 * Servlet implementation class UpdateGameLogicServlet
 */
public class UpdateGameLogicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateGameLogicServlet() {
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
        
        List<Gioco> giochi = BusinessLogic.getAllGiochi();
        request.setAttribute("giochi", giochi);
		request.getRequestDispatcher("WEB-INF/private-jsp/PaginaModificaGioco.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("start");
		String idGame = request.getParameter("gameSelect");
		System.out.println(idGame);
		String name = request.getParameter("name");
		String descrizione = request.getParameter("descrizioneFormGioco");
		String genere = request.getParameter("genere");
		System.out.println(genere);
		String offerte = request.getParameter("offers");
		String prezzo2 = request.getParameter("price");
		String data = request.getParameter("releaseDate");
		Offerta offerta = null;
		
		
		
			
		
		
		//Controlliamo che il gioco selezionato sia nel DB
		if(idGame == null && idGame.trim().isEmpty()) {
			request.setAttribute("error", "Gioco inesistente.");
        	request.getRequestDispatcher("WEB-INF/private-jsp/PaginaModificaGioco.jsp").forward(request, response);
        	return;
		}
		
		
		long id = Long.parseLong(idGame);
		
		//Selezioniamo il gioco da modificare
				Gioco game = BusinessLogic.getGiocoById(id);
		
		
		//Update nome del gioco
        if(name != null && !name.trim().isEmpty()) {
            
        	// Controlla che il nome non sia già esistente
        	for(Gioco g : BusinessLogic.getAllGiochi()) {
        		if(g.getNome().equals(name)) {
        			request.setAttribute("error", "Nome già Esistente.");
                	request.getRequestDispatcher("WEB-INF/private-jsp/PaginaModificaGioco.jsp").forward(request, response);
                	return;
        		}
        	}
        	// Procedi con l'aggiornamento del nome
        	BusinessLogic.updateGiocoNome(game, name); 
        	
        }
        
        //Update della descrizione del gioco
        if(descrizione != null && !descrizione.trim().isEmpty()) {
        	BusinessLogic.updateGiocoDescrizione(game, descrizione);
        }
        
        //Update del prezzo del gioco
        if(prezzo2 != null && !prezzo2.trim().isEmpty()) {
        	double prezzo = Double.parseDouble(prezzo2);
        	BusinessLogic.updateGiocoPrezzo(game, prezzo);
        }
        
      //Update Data di Rilascio
        if (data != null && !data.trim().isEmpty()) {
            try {
                LocalDate newDataRilascio = LocalDate.parse(data);
                // Procedi con l'aggiornamento della data
                BusinessLogic.updateGiocoDataRilascio(game, newDataRilascio);
            } catch (Exception e) {
            	request.setAttribute("error", "Data non Valida.");
                request.getRequestDispatcher("WEB-INF/private-jsp/PaginaModificaGioco.jsp").forward(request, response);
                return;
            }
        }
        
        //Update genere
        if(genere != null && !genere.trim().isEmpty()) {
        	if(BusinessLogic.getGenereById(Long.parseLong(genere)) == null) {
            	request.setAttribute("error", "Genere già esistente.");
                request.getRequestDispatcher("WEB-INF/private-jsp/PaginaModificaGioco.jsp").forward(request, response);
                return;
        	}
        	BusinessLogic.aggiungiGiocoaGenere(Long.parseLong(genere), game.getId());
        }
        
        request.getRequestDispatcher("WEB-INF/private-jsp/PaginaPublisher.jsp").forward(request, response);
       
	}


}
