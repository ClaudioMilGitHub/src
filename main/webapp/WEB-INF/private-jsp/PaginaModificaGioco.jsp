<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.elis.model.*" %>
<%@page import="org.elis.businesslogic.BusinessLogic"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Modifica Gioco</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/PaginaModificaGioco.css">
</head>
<body>

     	 <% Utente utenteLoggato = (Utente) session.getAttribute("utenteLoggato"); %>
   		 <% List<Offerta> offerte = BusinessLogic.getAllOfferta(); %>
   		 <% List<Gioco> giochi = BusinessLogic.getAllGiochi(); %>
   		 <% List<Genere> generi = BusinessLogic.getAllGenere(); 
   		 Gioco giocoSelezionato = giochi.get(0);//(Gioco)request.getAttribute("giocoSelezionato");
   		 %>
    <div class="container-fluid">
         <!--  NavBar  -->
         <% request.setAttribute("utenteLoggato", utenteLoggato); %>
         <jsp:include page="/includes/navbar.jsp"/>
 
         <!-- Page -->

        <div class="row">
            <div class="col-lg-12">
                <fieldset>
                    <legend>Modifica gioco</legend>
                    <form action="<%= request.getContextPath() %>/UpdateGameLogicServlet" method="post">
                       
                        <div class="form-group">
                            <label for="gameSelect" style="color: white;">Seleziona un gioco:</label>
                            <select id="gameSelect" name="gameSelect" class="form-select">
                                <option value="">Seleziona il gioco</option>
                                <%for(int i=0; i < giochi.size(); i++) {%>
                                	<option value="<%=giochi.get(i).getId() %>"><%=giochi.get(i).getNome() %></option>
                                <%} %>
                                
                            </select>
                        </div>

                        <!-- Nome -->
                        <div class="form-group">
                            <label for="name" style="color: white;">Nome</label>
                            <input type="text" id="name" name="name" class="form-control" value='<%=giocoSelezionato.getNome() %>'>
                        </div>

                        <!-- Descrizione -->
                        <div class="form-group">
                            <label for="description" style="color: white;">Descrizione</label>
                            <textarea id="descrizioneFormGioco" name="descrizioneFormGioco" class="form-control" rows="4"></textarea>
                        </div>

                        <!-- Prezzo -->
                        <div class="form-group">
                            <label for="price" style="color: white;">Prezzo</label>
                            <input type="number" id="price" name="price" class="form-control" min="0" step="0.01">
                        </div>

                        <!-- Genere -->
                        <div class="form-group">
                            <label for="genere" style="color: white;">Genere</label>
                            <select id="genere" name="genere" class="form-select">
                                <option value="">Seleziona Genere...</option>
                               <%for(int i=0; i < generi.size(); i++) {%>
                                	<option value="<%=generi.get(i).getId() %>"><%=generi.get(i).getNome() %></option>
                                <%} %>
                            </select>
                        </div>

                        <!-- Copertina -->
                        <div class="row">
                            <div class="col-lg-6" style="margin-top: 3vh;">
                                <label for="coverImage" style="color: white;">Immagine di Copertina:</label>
                                <input type="file" id="coverImage" name="coverImage" accept="image/*">
                            </div>
                        </div>

                        <!-- Data di rilascio -->
                        <div class="form-group">
                            <label for="releaseDate" style="color: white;">Data di Rilascio</label>
                            <input type="date" id="releaseDate" name="releaseDate" class="form-control">
                        </div>

                        <!-- Offerte -->
                        <div class="form-group">
                            <label for="offers" style="color: white;">Offerte</label>
                            <select id="offers" name="offers" class="form-select" multiple>
                                <option value="Sconto">Offerta</option>
                                <%for(int i=0; i < offerte.size(); i++) {%>
                                	<option value="<%=offerte.get(i).getId() %>"><%=offerte.get(i).getNome() %></option>
                                <%} %>
                            </select>
                        </div>

                     
                        <button type="submit" class="btn btn-primary mt-3">Salva Modifiche</button>
                    </form>
                </fieldset>
            </div>
        </div>
    </div>
<div>
    <!-- Footer -->
    <jsp:include page="/includes/footer.jsp"/>

</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-wEmeIV1mKuiNp0TcNyvP2Nc36wWct5OSs1RbZxPDlvzf7z4xi1ywZyO8RXUnp4an" crossorigin="anonymous"></script>

</body>
</html>