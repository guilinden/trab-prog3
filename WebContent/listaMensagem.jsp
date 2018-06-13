<%@page import="dao.MensagemDAO"%>
<%@page import="bean.Produto"%>
<%@page import="java.sql.SQLException"%>
<%@page import="bean.Mensagem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.servlet.http.*"%>

<html>
	<head>
	</head>
	<body>
		<h1>Linden & Co.</h1>
		<h3>Guns and Ammo</h3>
		<a href="logout.jsp"><h3>Logout</h3></a>
		<a href="home.jsp"><h3>Home</h3></a>
		<%
		
		if(session.getAttribute("user") == null){
			%>
			<script>
				window.alert("Login necessário");
				window.location.replace("http://localhost:8080/ProjetoFinal/login.jsp");
			</script>
			<%
		}

		ArrayList<Mensagem> list = new ArrayList<Mensagem>();
		list = MensagemDAO.ListaMensagens();

		String nome = "";
		String texto  = "";
		String email = "";
		int id;
		%>
		<br>
		<h1>Lista de mensagens</h1>
		<table>
		<tr>
    		<th>Nome do Cliente</th>
    		<th>Mensagem</th> 
    		<th>Email</th>
    		<th></th>
    		<th></th>
    		
 		 </tr>
		<%
		
		for(Mensagem m : list){
			
				nome = m.getNome();
				texto = m.getTexto();
				email = m.getEmail();
				id = m.getId();
		%>
		
		<tr>
    		<td><%=nome%></td>
    		<td><%=texto%></td> 
    		<td><%=email%></td>
    		<td><a href="excluirMensagem.jsp?id=<%=id%>">Exluir</a></td>
    		<td><a href="editarMensagem.jsp?id=<%=m.getId()%>">Editar</a></td>
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