/**
 * Validação de Formulário
 */

function validar() {
	let nome = formPassagem.nome.value;
	let origem = formPassagem.origem.value;
	let destino = formPassagem.destino.value;
	let valor = formPassagem.valor.value;
	
	if(nome === "") {
		alert("Preencha o campo nome");
		formPassagem.nome.focus();
		
		return false;
	} else {
		
		// 1º
		if(origem === "") {
			alert("Preencha o campo origem");
			formPassagem.origem.focus();
			
			return false;
		} else {
			
			// 2º
			if(destino === "") {
				alert("Preencha o campo destino");
				formPassagem.destino.focus();
				
				return false;
			} else {
				
				// 3º
				if(valor === "") {
					alert("Preencha o campo valor");
					formPassagem.valor.focus();
					
					return false;
				} else {
					document.forms["formPassagem"].submit();
				}
				
			}
			
		}
		
	}
}