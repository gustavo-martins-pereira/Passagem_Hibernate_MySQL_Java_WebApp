package application;

import java.util.List;

import controller.dao.PassagemDAO;
import model.Passagem;

public class Program {

	public static void main(String[] args) {
		
		List<Passagem> passagens = PassagemDAO.findAll();
		
		passagens.forEach(System.out::println);
		
	}

}
