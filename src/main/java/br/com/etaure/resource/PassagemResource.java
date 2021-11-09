package br.com.etaure.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.etaure.model.Passagem;

@Path("passagens")
public class PassagemResource {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String busca() {
		Passagem passagem = new Passagem(1, "Jéssica", "SP", "ES", 25.5);
		
		return passagem.toXML();
	}
	
}
