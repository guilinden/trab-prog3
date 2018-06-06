<%@page import="bean.MensagemDAO"%>
<%@page import="bean.Mensagem"%>
<html>
<%
	
%>
	<head></head>
	<body>
		<form method="post">
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