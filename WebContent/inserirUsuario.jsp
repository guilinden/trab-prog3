<%@page import="bean.UsuarioDAO"%>
<%@page import="bean.Usuario"%>
<html>
<%
	
%>
	<head></head>
	<body>
		<form method="post">
			<h1>Login</h1>
		    Usuário: <input type="text" name="username"><br/>
		    Senha: <input type="password" name="password"><br/><br/>
		    <input type="submit" name="submit" value="submit">
		    <%
		    	if(request.getParameter("submit") != null){
		    		String username = request.getParameter("username");
		    		String password = request.getParameter("password");
		    		Usuario usuario = new Usuario(username,password);
		    		UsuarioDAO.addUsuario(usuario);
		    			
		    		    %>
		    		    <script>
		    		    	window.alert("Erro Usuario ou Senha");
		    		    </script>
		    		    <%
		    		}
		    	
		    	
		    %> 
		</form>
	</body>
</html>