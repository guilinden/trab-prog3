<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="dao.ProdutoDAO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="bean.Produto"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

td, td {
	text-align: left;
}
</style>
<body>
	<h1>Linden & Co.</h1>
	<h2>Guns and Ammo</h2>
	<br />

	<a href="cadastroProduto.jsp"><h3>Novo Produto</h3></a>
	<a href="home.jsp"><h3>Home</h3></a>
	<a href="logout.jsp"><h3>Logout</h3></a>

	<%
		if (session.getAttribute("user") == null) {
	%>
	<script>
		window.alert("Login necessário");
		window.location.replace("http://localhost:8080/ProjetoFinal/login.jsp");
	</script>
	<%
		}
	%>

	<%
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		produtos = ProdutoDAO.ArrayList();
		String cdProduto = "";
		String nomeProduto = "";
		int qtEstoque = 0;
		double valor = 0.0d;
	%>
	<br/>
	<h1>Lista de Produtos</h1>
	<table style="width: 50%">
		<tr>
			<th>Codigo</th>
			<th>Nome</th>
			<th>Qtd Estoque</th>
			<th>Valor Total</th>
			<th>Editar</th>
			<th>Excluir</th>
		</tr>
		<%
			for (Produto p : produtos) {

				cdProduto = p.getCdProduto();
				nomeProduto = p.getNomeProduto();
				qtEstoque = p.getQtEstoque();
				valor = p.getValor();
		%>
		<tr>
			<td><%=cdProduto%></td>
			<td><%=nomeProduto%></td>
			<td><%=qtEstoque%></td>
			<td><%=valor%></td>
			<!-- <td><a href="excluirProduto.jsp?cdProduto=<%=p.getCdProduto()%>">Exluir</a></td> -->
			<!-- <td><a href="editarProduto.jsp?cdProduto=<%=p.getCdProduto()%>">Editar</a></td>  -->
		</tr>

		<%
			}
		%>
	</table>
</body>
</html>