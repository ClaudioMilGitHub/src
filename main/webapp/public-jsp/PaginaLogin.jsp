<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagina di Login</title>
</head>
<body>
	   <form action="<%=request.getContextPath()%>/LoginLogicServlet" method="post">
            <input type="email" placeholder="mario.rossi@gmail.com" name="emailLogin">
            <br>
            <input type="password" name="passwordLogin">
            <input type="submit" value="Login">
        </form>
</body>
</html>