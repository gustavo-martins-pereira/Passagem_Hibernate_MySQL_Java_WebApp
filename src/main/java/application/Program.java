package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Passagem;

public class Program {

	public static void main(String[] args) {
		
		Passagem passagem = new Passagem(null, "Gustavo", "SP", "ES", 25.00);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("passagens");
		EntityManager em = factory.createEntityManager();
		
		System.out.println(passagem);
		
		em.getTransaction().begin();
		em.persist(passagem);
		em.getTransaction().commit();
		em.close();
		
	}

}
