/**
 * Confirmação de exclusão de um contato
 */

function confirmar(id) {
	let resposta = confirm("Realmente deseja excluir?");
	
	if(resposta === true) {
		window.location.href = "delete?id=" + id;
	}
}
