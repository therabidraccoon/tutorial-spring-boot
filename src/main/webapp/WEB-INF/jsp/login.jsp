<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>BENVENUTO SUL PORTALE</h1>

	<form action="/login" method="post">
		<input type="text" name="username" placeholder="Username" /> <input
			type="text" name="password" placeholder="Password" /> <input
			type="submit" value="LOGIN" />
	</form>
	<div>
		<h2>PAGINE CON PARAM</h2>
		<a href="/pagina-param?num-pagina=1">1</a> <a
			href="/pagina-param?num-pagina=2">2</a> <a
			href="/pagina-param?num-pagina=3">3</a> <a
			href="/pagina-param?num-pagina=4">4</a> <a
			href="/pagina-param?num-pagina=5">5</a> <a
			href="/pagina-param?num-pagina=6">6</a> <a
			href="/pagina-param?num-pagina=7">7</a>
	</div>
	<div>
		<h2>PAGINE CON PATH VARIABLE</h2>
		<a href="/1/pagina">1</a> <a href="/2/pagina">2</a> <a
			href="/3/pagina">3</a> <a href="/4/pagina">4</a> <a href="/5/pagina">5</a>
		<a href="/6/pagina">6</a> <a href="/7/pagina">7</a>
	</div>
</body>
</html>