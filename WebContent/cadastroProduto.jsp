<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="bean.Produto"%>
<%@page import="bean.ProdutoDAO"%>
<%
String codProduto;
String nmProduto;
String qtdEstoque;    
String valor; 
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
		<input type="submit" value="Submit" />
		<%
		if(request.getParameter("submit") != null){
			try{
				codProduto = request.getParameter("cdProduto");
				nmProduto = request.getParameter("nomeProduto");
				qtdEstoque = request.getParameter("qtEstoque");    
				valor = request.getParameter("vlproduto");
				
				Integer quantidadeEstoque = Integer.parseInt(qtdEstoque);
				Double valorProduto = Double.parseDouble(valor);
				
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