<%@page import="dao.ProdutoDAO"%>
<%@page import="bean.Encomenda"%>
<%@page import="bean.Produto"%>
<%@page import="java.sql.SQLException"%>
<%@page import="bean.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.EncomendaDAO"%>

<%
String idProduto = request.getParameter("idProduto");
Produto produto = ProdutoDAO.getOneProduto(idProduto);

String fullName = request.getParameter("fullName");
String address = request.getParameter("address");
%>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="CSS/estilo.css">
	</head>
	<body>
		<div id="menu">
		<a href="Encomendas.jsp" class="menuitem"><h1>Linden & Co.</h1></a>
		<h3>Armas de fogo</h3>
		
			<a href="#home_content" class="menuitem">Home</a>
			<a href="#about_content" class="menuitem">Sobre</a>
			<a href="#mission_content" class="menuitem">Missao</a>
			<a href="mensagem.jsp" class="menuitem">Contato</a>
		</div>
		
		<h2>Complete sua compra!</h2>
		<h3><%=produto.getNomeProduto()%></h3>
		<h3>$<%=produto.getValor()%></h3>
		<form method = "POST">
			Full name<br>
			<input type="text" name="fullName"><br/><br/>
			Complete address<br>
			<input type="text" name="address"><br/><br/>
			Card Number<br>
			<input type="text"><br/><br/>
			CVC<br>
			<input type="text"><br/><br/>
			Expiration day<br>
			<input type="text"><br/><br/>
			<input type = "submit" value = "Submit" />
			<%
			if(fullName != null && address != null){

				try {
					
					Produto p2 = ProdutoDAO.getOneProduto(produto.getCdProduto());				
					Encomenda encomenda = new Encomenda(fullName,address, produto, produto.getValor());
					EncomendaDAO.addEncomenda(encomenda);
					ProdutoDAO.deduzirEstoque(produto,1);
					
				} catch(Exception e) {
					e.printStackTrace();
					%><script type="text/javascript">
					window.alert("Erro ao finalizar compra!");
					window.location.replace("http://localhost:8080/ProjetoFinal/Encomendas.jsp");
					</script><%
				}
				
				finally{
					%><script type="text/javascript">
					window.alert("Compra finalizada com sucesso!");
					window.location.replace("http://localhost:8080/ProjetoFinal/Encomendas.jsp");
					</script><%
				}
			}
			%>
		</form>

	</body>
	<style>

		
	</style>
	
	
</html>