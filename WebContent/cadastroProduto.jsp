<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="bean.Produto"%>
<%@page import="bean.ProdutoDAO"%>
<%
String codProduto = request.getParameter("cdProduto");
String nmProduto = request.getParameter("nomeProduto");
String qtdEstoque = request.getParameter("qtEstoque");    
String valor = request.getParameter("vlProduto");
double valorProduto = 0.0d;
int quantidadeEstoque = 0;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Produto</title>
</head>
<body>

	<h1>Linden & Co;</h1>
	<h3>Cadastrar Produto</h3>

	<form method="POST">


		Codigo: <input type="text" name="cdProduto"><br />
		Nome: <input type="text" name="nomeProduto"><br /> 
		Qt. Estoque <input type="text" name="qtEstoque"> <br /> 
		Valor : <input type="text" name="vlProduto"> <br /> 
		<input type="submit" value="submit" name="submit"/>
		<%
		if(request.getParameter("submit") != null){
			try{
				quantidadeEstoque = Integer.parseInt(qtdEstoque);
				valorProduto = Double.parseDouble(valor);

				Produto p = new Produto(codProduto, nmProduto, quantidadeEstoque, valorProduto);
				ProdutoDAO.addProduto(p);
			}
			catch(Exception e){
				e.printStackTrace();
				%><script type="text/javascript">
					window.alert("Erro ao cadastrar o produto!");
					window.location.replace("http://localhost:8080/ProjetoFinal/cadastroProduto.jsp");
				</script><%
			}
			finally{
				%><script type="text/javascript">
					window.alert("Produto cadastrado com sucesso!");
					window.location.replace("http://localhost:8080/ProjetoFinal/cadastroProduto.jsp");
				</script>
		<%
			}			
		}
	%>
	

	</form>
</body>
</html>