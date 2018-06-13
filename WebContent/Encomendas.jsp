

<%@page import="bean.ProdutoDAO"%>
<%@page import="bean.EncomendaDAO"%>
<%@page import="bean.Produto"%>
<%@page import="java.sql.SQLException"%>
<%@page import="bean.Produto"%>
<%@page import="java.util.ArrayList"%>



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
		<%
	
		
		
		
		ArrayList<Produto> list = new ArrayList<Produto>();
		list = ProdutoDAO.ArrayList();

		String nome = "";
		Double preco = 0.0;
		String id  = "";
		
		
		for(Produto p : list){
			if(p.getQtEstoque() > 0){
				nome = p.getNomeProduto();
				preco = p.getValor();
				id = p.getCdProduto();
		%>
		<figure>
			<img src="http://via.placeholder.com/300x250" id="produto3">
			<figcaption><%=nome%></figcaption>
			<figcaption class="dinheiro">$<%=preco%></figcaption>
			<figcaption><a href="http://localhost:8080/ProjetoFinal/cadastroEncomenda.jsp?idProduto=<%=id%>">Comprar</a></figcaption>
		</figure>
	
		
		
		<%
			
			}
			
		}
		
		%>

	</body>
	
	
	
	
</html>