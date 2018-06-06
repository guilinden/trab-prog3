<%@page import="bean.UpdateStatements"%>
<%@page import="bean.SelectStatements"%>
<%@page import="bean.Encomenda"%>
<html>
	<head></head>
	<body>
		<%
			String codigo = request.getParameter("idEncomenda");
			int codigoInt = Integer.parseInt(codigo);

			SelectStatements select = new SelectStatements();
			Encomenda e1 = select.getOneEncomenda(codigoInt);
		%>
		<h1>Edição de Encomenda</h1></br>
		<table>
		<tr>
    		<th>Nome do Cliente</th>
    		<th>Endereco</th> 
    		<th>Codigo Produto</th>
    		<th>Valor Total</th>   		
 		 </tr>
 		 <tr>
    		<td><%=e1.getNomeCliente()%></td>
    		<td><%=e1.getEndEntrega()%></td> 
    		<td><%=e1.getProduto().getCdProduto()%></td>
    		<td><%=e1.getValorTotal()%></td>
  		</tr>
  		</table>
 		 
		<br/>
		<h1>Novos Dados</h1>
		
		<form method = "POST">
			Nome Cliente: <input type="text" name="nomeCliente" value=<%=e1.getNomeCliente() %>><br/>
			Endereço: <input type="text" name="endereco" value=<%=e1.getEndEntrega()%>><br/>
			<input type="submit" name="submit" value="Submit">
			<%
				if(request.getParameter("submit") !=  null){
					String nomeCliente = request.getParameter("nomeCliente");
					String endereco = request.getParameter("endereco");
					e1.setNomeCliente(nomeCliente);
					e1.setEndEntrega(endereco);
					UpdateStatements update = new UpdateStatements();
					update.updateEncomenda(e1);
				}
			%>
			
		</form>
		<a href="listaEncomendas.jsp"><button>Cancelar</button></a>
	</body>
	<style>
	table, th, td {
    border: 1px solid black;
}
	</style>
</html>