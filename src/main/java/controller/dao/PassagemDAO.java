package controller.dao;

import java.util.List;

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
	
	//Inserir uma Passagem
	public static void insert(Passagem passagem) {
		createEntityManager();
		
		em.getTransaction().begin();
		em.persist(passagem);
		em.getTransaction().commit();
		em.close();
	}
	
	//Listar todas as Passagens
	public static List<Passagem> findAll() {
		createEntityManager();
		
		String jpql = "SELECT p FROM Passagem p";
		return em.createQuery(jpql, Passagem.class).getResultList();
	}
	
}
