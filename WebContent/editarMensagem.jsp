<%@page import="bean.MensagemDAO"%>
<%@page import="bean.Mensagem"%>
<html>
	<head></head>
	<body>
		<%
		
		if(session.getAttribute("user") == null){
			%>
			<script>
				window.alert("Login necessário");
				window.location.replace("http://localhost:8080/ProjetoFinal/login.jsp");
			</script>
			<%
		}
		
			String codigo = request.getParameter("id");
			int codigoInt = Integer.parseInt(codigo);

			
			Mensagem m1 = MensagemDAO.getOneMensagem(codigoInt);
		%>
		<a href="logout.jsp"><h3>Logout</h3></a>
		<h1>Edição de Mensagem</h1></br>
		<table>
		<tr>
    		<th>Nome do Cliente</th>
    		<th>Texto</th> 
    		<th>Email</th>   		
 		 </tr>
 		 <tr>
    		<td><%=m1.getNome()%></td>
    		<td><%=m1.getTexto()%></td> 
    		<td><%=m1.getEmail()%></td>
    		
  		</tr>
  		</table>
 		 
		<br/>
		<h1>Novos Dados</h1>
		
		<form method = "POST">
			Nome Cliente: <input type="text" name="nome" value="<%=m1.getNome() %>"><br/>
			Texto: <input type="text" name="texto" value="<%=m1.getTexto()%>"><br/>
			Email: <input type="text" name="email" value="<%=m1.getEmail()%>"><br/>
			<input type="submit" name="submit" value="Submit">
			<%
				if(request.getParameter("submit") !=  null){
					String nomeCliente = request.getParameter("nome");
					String texto = request.getParameter("texto");
					String email = request.getParameter("email");
					m1.setNome(nomeCliente);
					m1.setTexto(texto);
					m1.setEmail(email);
					MensagemDAO.updateMensagem(m1);
					%>
					<script>
						window.alert("Editado com Sucesso");
						window.location.replace("http://localhost:8080/ProjetoFinal/listaMensagem.jsp");
					</script>
					<%
				}
			%>
			
		</form>
		<a href="listaMensagem.jsp"><button>Cancelar</button></a>
	</body>
	<style>
	table, th, td {
    border: 1px solid black;
}
	</style>
</html>