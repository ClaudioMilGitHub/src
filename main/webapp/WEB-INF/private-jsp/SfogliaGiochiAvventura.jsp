<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="org.elis.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%List<Gioco> listaGiochi = (List<Gioco>) request.getAttribute("listaGiochi");
		Genere genere = (Genere) request.getAttribute("genere");
		%>
		<h1><%=genere.getNome() %></h1>
		
	<%
		if(listaGiochi != null){			
			for(Gioco g : listaGiochi){
				%>
				<%= g.getNome()%>
				<%
			}
		} else {
			%>
			<h2>Lista vuota</h2>
			<%
		}
		
	%>

</body>
</html>