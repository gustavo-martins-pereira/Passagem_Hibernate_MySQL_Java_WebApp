<%@page import="java.util.ArrayList"%>
<%@ page import="br.com.etaure.model.Passagem" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%
    	ArrayList<Passagem> passagens =
    	(ArrayList<Passagem>) request.getAttribute("passagens");
    %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Agendamento de Passagens</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Passagens</h1>
	<a href="cadastro.html" class="botao">Cadastrar Passagem</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome do Passageiro</th>
				<th>Origem</th>
				<th>Destino</th>
				<th>Valor da Passagem</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<% for(int i = 0; i < passagens.size(); i++) { %>
				<tr>
					<td><%= passagens.get(i).getId() %></td>
					<td><%= passagens.get(i).getNomeDoPassageiro() %></td>
					<td><%= passagens.get(i).getOrigem() %></td>
					<td><%= passagens.get(i).getDestino() %></td>
					<td><%= passagens.get(i).getValorDaPassagem() %></td>
					<td>
						<a href="listarPassagens?id=
						<%= passagens.get(i).getId() %>" class="botao">Editar</a>
						<a href="javascript: confirmar(<%= passagens.get(i).getId() %>)"
						class="botao2">Excluir</a>
					</td>
				</tr>
			<% } %>
		</tbody>
	</table>
	<script type="text/javascript" src="scripts/confirmador.js"></script>
</body>
</html>