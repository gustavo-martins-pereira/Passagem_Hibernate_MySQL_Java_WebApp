package controller.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Passagem;

public class PassagemDAO {

	private static EntityManager em;
	
	private static void createEntityManager() {
		if(em == null) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("passagens");
			em = factory.createEntityManager();
		}
	}
	
	public static void insert(Passagem passagem) {
		System.out.println(em);
		
		createEntityManager();
		
		em.getTransaction().begin();
		em.persist(passagem);
		em.getTransaction().commit();
		em.close();
	}
	
}
