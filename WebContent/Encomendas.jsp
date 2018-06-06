

<%@page import="bean.ProdutoDAO"%>
<%@page import="bean.EncomendaDAO"%>
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
		<form method= "POST">
		<figure>
			<img src="http://via.placeholder.com/300x250" id="produto3">
			<figcaption><%=nome%></figcaption>
			<figcaption>$<%=preco%></figcaption>
			<figcaption>
            		Quantidade: <input id="value" class="quantity" type="text" name="quantity" value="1"/>
        	</figcaption>
			<figcaption><input type="submit" value="submit" name="submit"></figcaption>
			<%
			if(request.getParameter("submit") != null){
        		String quant = request.getParameter("quantity");
        		%>
				<script>
					window.location.replace("http://localhost:8080/ProjetoFinal/cadastroEncomenda.jsp?idProduto=<%=p.getCdProduto()%>&quant=<%=request.getParameter("quantity")%>");
				</script>
				<%
			}
        	%>
		</figure>
		</form>
		
		
		<%
			
			}
			
		}
		
		%>
		<a href="mensagem.jsp"><h2>Entre em contato</h2></a>

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