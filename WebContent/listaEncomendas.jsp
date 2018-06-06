

<%@page import="bean.SelectStatements"%>
<%@page import="bean.Produto"%>
<%@page import="java.sql.SQLException"%>
<%@page import="bean.Encomenda"%>
<%@page import="java.util.ArrayList"%>



<html>
	<head>
	</head>
	<body>
		<h1>Linden & Co.</h1>
		<h3>Guns and Ammo</h3>
		<%
	
		
		
		SelectStatements s1 = new SelectStatements();
		ArrayList<Encomenda> list = new ArrayList<Encomenda>();
		list = s1.ListaEncomendas();

		String nome = "";
		Double preco = 0.0;
		String id  = "";
		String endereco = "";
		String cod = "";
		%>
		<br><br>
		<h1>Lista de encomendas</h1>
		<table>
		<tr>
    		<th>Nome do Cliente</th>
    		<th>Endereco</th> 
    		<th>Codigo Produto</th>
    		<th>Valor Total</th>
    		
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