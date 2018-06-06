

<%@page import="bean.Encomenda"%>
<%@page import="bean.SelectStatements"%>
<%@page import="bean.Produto"%>
<%@page import="java.sql.SQLException"%>
<%@page import="bean.Produto"%>
<%@page import="java.util.ArrayList"%>

<%
String idProduto = request.getParameter("idProduto");

SelectStatements s1 = new SelectStatements();
Produto produto = s1.getOneProduto(idProduto);

String fullName = request.getParameter("fullName");
String address = request.getParameter("address");
%>

<html>
	<head>
	</head>
	<body>
		<h1>Linden & Co.</h1>
		<h3>Guns and Ammo</h3>
		
		<h2>Complete sua compra!</h2>
		<h3><%=produto.getNomeProduto()%></h3>
		<h3>$<%=produto.getValor()%></h3>
		<form method = "POST">
			Full name:<input type="text" name="fullName"><br/><br/>
			Complete address:<input type="text" name="address"><br/><br/>
			Card Number:<input type="text"><br/><br/>
			CVC:<input type="text"><br/><br/>
			Expiration day:<input type="text"><br/><br/>
			<input type = "submit" value = "Submit" />
			<%
			if(fullName != null && address != null){

				try {
					Encomenda encomenda = new Encomenda(fullName,address, produto, produto.getValor());
					encomenda.addEncomenda();
				} catch(Exception e) {
					e.printStackTrace();
					%><script type="text/javascript">
					window.alert("Erro ao finalizar compra!");
					window.location.replace("http://localhost:8080/ProjetoFinal/Encomendas.jsp");
					</script><%
				}
				
				finally{
					%><script type="text/javascript">
					window.alert("Compra finalizada com sucesso!");
					window.location.replace("http://localhost:8080/ProjetoFinal/Encomendas.jsp");
					</script><%
				}
			}
			%>
		</form>

	</body>
	<style>

		
	</style>
	
	
</html>