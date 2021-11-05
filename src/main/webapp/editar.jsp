<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Atualizar Passagem</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<h1>Atualizar Passagem</h1>
	<form name="formPassagem" action="">
		<table>
			<tr>
				<td><input type="text" name="id" class="caixa1" id="id"
				value="<% out.print(request.getAttribute("id")); %>" readonly></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" class="caixa1"
				value="<% out.print(request.getAttribute("nome")); %>"></td>
			</tr>
			<tr>
				<td><input type="text" name="origem" class="caixa1"
				value="<% out.print(request.getAttribute("origem")); %>"></td>
			</tr>
			<tr>
				<td><input type="text" name="destino" class="caixa1"
				value="<% out.print(request.getAttribute("destino")); %>"></td>
			</tr>
			<tr>
				<td><input type="text" name="valor" class="caixa2"
				value="<% out.print(request.getAttribute("valor")); %>"></td>
			</tr>
		</table>

		<input type="button" value="Salvar" class="botao"
			onclick="validar()">
	</form>

	<script src="scripts/validador.js"></script>
</body>
</html>