<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dao.ProdutoDAO"%>
<%@page import="bean.Produto"%>
<%
int qt = 0;
double vl = 0.0d;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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
		%>
		<a href="logout.jsp"><h3>Logout</h3></a>
		<h1>Editar Produto</h1>
		<table>
			<tr>
				<th>Codigo</th></br>
				<th>Nome</th>
				<th>Qtd Estoque</th>
				<th>Valor</th>
			</tr>
			<tr>
				<td><%=p.getCdProduto()%></td>
				<td><%=p.getNomeProduto()%></td>
				<td><%=p.getQtEstoque()%></td>
				<td><%=p.getValor()%></td>
			</tr>
		</table>
		
		<h1>Novos Dados</h1>
			<form method="POST"> 
				Nome: <input type="text" name="nomeProduto" value="<%=p.getNomeProduto()%>"><br/>
				Qt Estoque: <input type="text" name="qtEstoque" value="<%=p.getQtEstoque()%>"><br/>
				Valor: <input type="text" name="valorProduto" value="<%=p.getValor()%>"><br/>
				<input type="submit" name="submit" value="submit"> 
			<%
				if(request.getParameter("submit") !=  null){
					try{
					String nome = request.getParameter("nomeProduto");
					String estoque = request.getParameter("qtEstoque");
					String preco = request.getParameter("valorProduto");
					qt = Integer.parseInt(estoque);
					vl = Double.parseDouble(preco);
					p.setNomeProduto(nome);
					p.setQtEstoque(qt);
					p.setValor(vl);
					ProdutoDAO.updateProduto(p);
					
					}
					catch(Exception e){
						System.out.println(e.getLocalizedMessage());
					}
					finally{
					%><script>
						window.alert("Produto editado com Sucesso");
						window.location.replace("http://localhost:8080/ProjetoFinal/listaProdutos.jsp");
					</script><%
					}
				}
			%>
			</form>
		
</body>
</html>