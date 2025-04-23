<%@ include file="header.jsp" %>

<form action="tarefa" method="POST">
	<label for="nome">Nome: </label>
	<input type="text" name="nome">
	
	<label for="descricao">Descricao: </label>
	<input type="text" name="descricao">

	<input type="submit" value="enviar">
</form>

<%@ include file="footer.jsp" %>