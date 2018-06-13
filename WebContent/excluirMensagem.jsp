<%@page import="dao.MensagemDAO"%>
<%@page import="bean.Mensagem"%>
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

	String codigo = request.getParameter("id");
	
	int codigoInt = Integer.parseInt(codigo);
	Mensagem m1 = MensagemDAO.getOneMensagem(codigoInt);

	MensagemDAO.deleteMensagem(m1);
	
	%><script type="text/javascript">
	window.alert("Delete realizado com sucesso!");
	window.location.replace("http://localhost:8080/ProjetoFinal/listaMensagem.jsp");
	</script><%

%>
<head>
</head>
<body>
<h1><%=codigo%></h1>
</body>
</html>