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
		<h1>Editar encomenda</h1>
		
		<form method = "POST">
			Nome Cliente: <input type="text" name="nomeCliente" value=<%=e1.getNomeCliente() %>><br/>
			Endereço: <input type="text" name="endereco" value=<%=e1.getEndEntrega()%>><br/>
			<input type="submit" name="submit" value="Submit">
			<%
				if(request.getParameter("submit") !=  null){
					String nomeCliente = request.getParameter("nomeCliente");
					String endereco = request.getParameter("endereco");
				}
			%>
		</form>
	</body>
</html>