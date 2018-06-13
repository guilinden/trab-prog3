<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dao.ProdutoDAO"%>
<%@page import="bean.Produto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

	String codigo = request.getParameter("cdProduto");
	Produto p = ProdutoDAO.getOneProduto(codigo);

	ProdutoDAO.deleteProduto(p);
	
	%><script type="text/javascript">
	window.alert("Delete realizado com sucesso!");
	window.location.replace("http://localhost:8080/ProjetoFinal/listaProdutos.jsp");
	</script><%

%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h1>Produto excluido:</h1>
<h1><%=codigo%></h1>
<h1><%=p.getNomeProduto()%></h1>
</body>
</html>