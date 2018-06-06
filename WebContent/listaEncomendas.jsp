

<%@page import="bean.SelectStatements"%>
<%@page import="bean.Produto"%>
<%@page import="java.sql.SQLException"%>
<%@page import="bean.Encomenda"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.servlet.http.*"%>

<html>
	<head>
	</head>
	<body>
		<h1>Linden & Co.</h1>
		<h3>Guns and Ammo</h3>
		<a href="logout.jsp"><h3>Logout</h3></a>
		<%
		
		if(session.getAttribute("user") == null){
			%>
			<script>
				window.alert("Login necessário");
				window.location.replace("http://localhost:8080/ProjetoFinal/login.jsp");
			</script>
			<%
		}
		
		SelectStatements s1 = new SelectStatements();
		ArrayList<Encomenda> list = new ArrayList<Encomenda>();
		list = s1.ListaEncomendas();

		String nome = "";
		Double preco = 0.0;
		String id  = "";
		String endereco = "";
		String cod = "";
		%>
		<br>
		<h1>Lista de encomendas</h1>
		<table>
		<tr>
    		<th>Nome do Cliente</th>
    		<th>Endereco</th> 
    		<th>Codigo Produto</th>
    		<th>Valor Total</th>
    		<th></th>
    		<th></th>
    		
 		 </tr>
		<%
		
		for(Encomenda e : list){
			
				nome = e.getNomeCliente();
				preco = e.getValorTotal();
				endereco = e.getEndEntrega();
				Produto p1 = e.getProduto();
				cod = p1.getCdProduto();
				
		%>
		
		<tr>
    		<td><%=nome%></td>
    		<td><%=endereco%></td> 
    		<td><%=cod%></td>
    		<td><%=preco%></td>
    		<td><a href="excluirEncomenda.jsp?idEncomenda=<%=e.getIdEncomenda()%>">Exluir</a></td>
    		<td><a href="editarEncomenda.jsp?idEncomenda=<%=e.getIdEncomenda()%>">Editar</a></td>
  		</tr>
		
		
		<%
			
			}
			
		
		
		%>
		</table>

	</body>
	<style>
	table, th, td {
    border: 1px solid black;
}
	</style>
	
	
</html>