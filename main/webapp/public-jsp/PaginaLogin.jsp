<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagina di Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/PaginaLogin.css">
</head>
<body>
	<div class="container-fluid min-vh-100 d-flex flex-column">
		<!-- Header row-->
		<div class="row header">
			<header>
				<div class="container">
					<a class="navbar-brand" href="<%=request.getContextPath()%>/index">
                        <img src="https://store.akamai.steamstatic.com/public/shared/images/header/logo_steam.svg?t=962016" alt="Steam logo" width="176" height="44">
                    </a>
				</div>
			</header>
		</div>

		<!-- Content row-->
		<div class="row flex-grow-1">
			<div class="col-lg-3 col-sm mb-3 d-none d-lg-block"></div>
			<div class="col-lg-6 ">
				<div id="box-1">
					<%
		String email = "";
		String password = "";
		Cookie [] cookies = request.getCookies();
		for(Cookie c : cookies){
			if(c.getName().equals("emailKey")){
				email = c.getValue();
			}
			if(c.getName().equals("passwordKey")){
				password = c.getValue();
			}
		}
		%>
					<form action="<%=request.getContextPath()%>/LoginLogicServlet"
						method="post" class="row g-3">

						<div class="col-mb-12 ">
							<label for="emailFormLogin" class="form-label">EMAIL
								ADDRESS</label> <input value="<%=email %>" id="emailFormLogin"
								class="form-control" type="email"
								placeholder="rino.rano@gmail.com" name="emailFormLogin">
						</div>

						<div class="col-mb-12 ">
							<label for="passwordFormLogin" class="form-label">PASSWORD</label>
							<input value="<%=password %>" id="passwordFormLogin"
								type="password" placeholder="password" name="passwordFormLogin"
								class="form-control">
						</div>
						<div class="col-mb-12 " style="color: #b5b5b5;">
							<label for="checkboxFormLogin">Rimanere Connesso</label> <input
								<%if(!email.isBlank() && !password.isBlank()){%> checked <%} %>
								type="checkbox" name="checkboxFormLogin">
						</div>

						<div id="div-2" class="col-md-12">
							<input type="submit" value="ACCEDI"
								class="btn btn-outline-success" id="btn">

						</div>
						<div id="div-2" class="col-md-12 mt-5 text-danger">
							<%String messaggio = (String)request.getAttribute("messaggioDiErrore");
					        if(messaggio != null){ %>

							<p><%=messaggio %></p>

							<%} %>
						</div>
					</form>
					<div id="div-3" class="col-mb-12 ">
						<%if(messaggio != null){ %>
						<p>
							Non sei ancora Registrato? Clicca qui per <a
								href="public-jsp/PaginaRegistrazione.jsp">Registrarti</a>.
						</p>
						<%}else{ %>
						<p>
							Non sei ancora Registrato? Clicca qui per <a
								href="PaginaRegistrazione.jsp">Registrarti</a>.
						</p>

						<%} %>
					</div>
				</div>

			</div>
			<div class="col-lg-3"></div>
		</div>

		<!-- Footer row-->
		<div class="row footer">
			<footer class="footer">
				<div class="content-logo d-flex flex-row justify-content-between">
					<div class="footer-logo-steam">
						<img
							src="https://store.akamai.steamstatic.com/public/images/v6/logo_steam_footer.png"
							alt="logo steam">
					</div>
					<div class="footer-valve">
						<img
							src="https://store.akamai.steamstatic.com/public/images/footerLogo_valve_new.png"
							alt="logo">
					</div>
				</div>
				<div class="content-footer color-white" id="footer_text">
					Progetto ispirato a Steam per puri scopi didattici per il Master di
					Sviluppo Software e Applicazioni edizione Maggio. Gruppo di lavoro
					composto da Claudio Milano, Leandro Biccellari, Antonio Guglielmo e
					Simone Medori.</div>
			</footer>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>