<%@page import="dao.UsuarioDAO"%>
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
		    		Usuario userFinal = UsuarioDAO.find(username, password);
		    		
		    		if (userFinal != null) {
		    		    request.getSession().setAttribute("user", userFinal.getNome()); // Put user in session.
		    		    response.sendRedirect("http://localhost:8080/ProjetoFinal/home.jsp"); // Go to some start page.
		    		} else {
		    		    request.setAttribute("error", "Unknown login, try again"); // Set error msg for ${error}
		    		    %>
		    		    <script>
		    		    	window.alert("Erro Usuario ou Senha");
		    		    </script>
		    		    <%
		    		}
		    	}
		    	
		    %> 
		</form>
	</body>
</html>