

<%@page import="bean.SelectStatements"%>
<%@page import="bean.Produto"%>
<%@page import="java.sql.SQLException"%>
<%@page import="bean.Produto"%>
<%@page import="java.util.ArrayList"%>



<html>
	<head>
	</head>
	<body>
		<h1>Linden & Co.</h1>
		<h3>Guns and Ammo</h3>
		<%
	
		
		
		SelectStatements s1 = new SelectStatements();
		ArrayList<Produto> list = new ArrayList<Produto>();
		list = s1.ArrayList();

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
			<figcaption>$<%=preco%></figcaption>
			<figcaption><button onclick="location.href = 'cadastroEncomenda.jsp?idProduto=<%=id%>';" class="botaoComprar">Comprar</button></figcaption>
		</figure>
		
		<%
			
			}
			
		}
		
		%>
		

	</body>
	<style>
		img{
			margin-right: 20px;
			display: inline-block;
		}
		
		figure {
			display: inline-block;
		}

		figure img {
			vertical-align: top;
		}

		figure figcaption {
			text-align: center;
		}

		figcaption{
			padding-top: 10px;
		}
		
		
	</style>
	
	
</html>