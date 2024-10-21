package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Scanner;

import org.elis.businesslogic.BusinessLogic;
import org.elis.model.Genere;
import org.elis.model.Gioco;
import org.elis.model.Offerta;
import org.elis.model.Utente;
import org.json.JSONObject;

/**
 * Servlet implementation class AddGameLogicServlet
 */

@MultipartConfig
public class AddGameLogicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String API_KEY = "a99205b54572da0875dcf3b8e51e4016";
       
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
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String nome = request.getParameter("nomeFormGioco");
		String descrizione = request.getParameter("descrizioneFormGioco");
		String genere = request.getParameter("genereFormGioco");
		String offerte = request.getParameter("offers");
		String prezzo2 = request.getParameter("prezzoFormGioco");
		String data = request.getParameter("releaseDateFormGioco");
		Offerta offerta = null;
		
		
		System.out.println("Genere = " + genere);
		System.out.println(offerte);
		
		// Recupero il file immagine dal form
		Part filePart = request.getPart("coverImage");
		InputStream fileInputStream = filePart.getInputStream();
		
		//Converto il file immagine in base64
		byte[] imageBytes = fileInputStream.readAllBytes();
		String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
		
		//Preparazione richiesta HTTP per l'API di imgBB
		String apiUrl = "https://api.imgbb.com/1/upload?key="+API_KEY;
		String urlParameters = "image=" + URLEncoder.encode(encodedImage, StandardCharsets.UTF_8.toString());
		
		//Effettuo richiesta HTTP di tipo POST
		
		URL url = new URL(apiUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

		
		try (OutputStream os = conn.getOutputStream()){
			byte[] input = urlParameters.getBytes();
			os.write(input, 0, input.length);
		}
		
		//Otteniamo risposta dalla API
		InputStream responseStream = conn.getInputStream();
		String jsonResponse;
		try(Scanner scanner = new Scanner(responseStream, StandardCharsets.UTF_8.name())){
			jsonResponse = scanner.useDelimiter("\\A").next();
		}
		
		//Estraggo URL dell'immaigne dalla risposta Json
		String imageUrl = extractImageUrlFromJson(jsonResponse);

		
		System.out.println(imageUrl);
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
		
		
		if(offerte!=null) {
			
			try {
				
				long idOfferta = Long.parseLong(offerte);
				offerta = BusinessLogic.getOffertaById(idOfferta);
				
			} catch(NumberFormatException e) {
				offerta = null;
			}
			
		}
			
		
		Utente utenteLoggato = (Utente)request.getSession().getAttribute("utenteLoggato");
		double prezzo = Double.parseDouble(prezzo2);
		LocalDate dataRilascio = LocalDate.parse(data);
		
		//Aggiungiamo il gioco al database e alle associazioni
		Gioco giocoAggiunto = BusinessLogic.addGioco(nome, dataRilascio, descrizione, imageUrl, prezzo, offerta, utenteLoggato);
		
		
		if(!genere.equalsIgnoreCase("null")) {
			long idGenere = Long.parseLong(genere);
			Genere genereGioco = BusinessLogic.getGenereById(idGenere);	
			BusinessLogic.aggiungiGiocoaGenere(genereGioco.getId(), giocoAggiunto.getId());
		}
		
		
		BusinessLogic.aggiungiGiocoALibreria(utenteLoggato, giocoAggiunto);
		
		if(utenteLoggato.getRuolo().ordinal() == 0) {
			request.getRequestDispatcher("WEB-INF/private-jsp/PaginaAdmin.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("WEB-INF/private-jsp/PaginaPublisher.jsp").forward(request, response);
	}

	private String extractImageUrlFromJson(String jsonResponse) {
		JSONObject jsonObject = new JSONObject(jsonResponse);
		if(jsonObject.getBoolean("success")) {
			return jsonObject.getJSONObject("data").getString("url");
		} else {
			throw new RuntimeException("Errore durante il caricamento dell'immagine: " + jsonObject.getString("error"));
		}
	}
}
