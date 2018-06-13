<%@page import="bean.MensagemDAO"%>
<%@page import="bean.Mensagem"%>
<html>
<%
	
%>
	<head>
		<link rel="stylesheet" type="text/css" href="CSS/estilo.css">	
	</head>
	<body>
		<form method="post">
		<div id="menu">
		<a href="Encomendas.jsp" class="menuitem"><h1>Linden & Co.</h1></a>
		<h3>Armas de fogo</h3>
		
			<a href="#home_content" class="menuitem">Home</a>
			<a href="#about_content" class="menuitem">Sobre</a>
			<a href="#mission_content" class="menuitem">Missao</a>
			<a href="mensagem.jsp" class="menuitem">Contato</a>
		</div>
			<h1>Mensagem</h1>
		    Nome: <input type="text" name="name"><br/>
		    Texto: <input type="text" name="text"><br/><br/>
		    Email: <input type="text" name="email"><br/><br/>
		    <input type="submit" name="submit" value="submit">
		    <%
		    	if(request.getParameter("submit") != null){
		    		String name = request.getParameter("name");
		    		String text = request.getParameter("text");
		    		String email = request.getParameter("email");
		    		Mensagem msgFinal = new Mensagem(name, text, email);
		    		
		    		MensagemDAO.addMensagem(msgFinal);
		    			    		
		    
		    	}
		    	
		    %> 
		</form>
	</body>
</html>