

<%@page import="bean.SelectStatements"%>
<%@page import="bean.Produto"%>
<%@page import="java.sql.SQLException"%>
<%@page import="bean.Produto"%>
<%@page import="java.util.ArrayList"%>

<%
String idProduto = request.getParameter("idProduto");
%>

<html>
	<head>
	</head>
	<body>
		<h1>Linden & Co.</h1>
		<h3>Guns and Ammo</h3>
		
		<h2>Complete sua compra!</h2>
		<h3><%=idProduto%></h3>
		<form>
			First name:<input type="text">
		</form>

	</body>
	<style>

		
	</style>
	
	
</html>