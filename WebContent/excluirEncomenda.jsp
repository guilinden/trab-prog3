<%@page import="bean.EncomendaDAO"%>
<%@page import="bean.Encomenda"%>
<html>
<%
if(session.getAttribute("user") == null){
	%>
	<script>
		window.alert("Login necessário");
		window.location.replace("http://localhost:8080/ProjetoFinal/login.jsp");
	</script>
	<%
}

	String codigo = request.getParameter("idEncomenda");
	
	int codigoInt = Integer.parseInt(codigo);
	Encomenda e1 = EncomendaDAO.getOneEncomenda(codigoInt);

	EncomendaDAO.deleteEncomenda(e1);
	
	%><script type="text/javascript">
	window.alert("Delete realizado com sucesso!");
	window.location.replace("http://localhost:8080/ProjetoFinal/listaEncomendas.jsp");
	</script><%

%>
<head>
</head>
<body>
<h1><%=codigo%></h1>
<h1><%=e1.getNomeCliente()%></h1>
</body>
</html>