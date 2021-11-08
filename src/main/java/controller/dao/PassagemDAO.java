package controller.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

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
	}
	
	//Listar todas as Passagens
	public static List<Passagem> findAll() {
		createEntityManager();
		
		String jpql = "SELECT p FROM Passagem p ORDER BY nome_passageiro";
		return em.createQuery(jpql, Passagem.class).getResultList();
	}

	//Retorna a Passagem pelo id
	public static Passagem findById(Integer id) {
		createEntityManager();
		
		return em.find(Passagem.class, id);
	}
	
	//Atualiza a Passagem
	public static void updatePassagem(Integer id, HttpServletRequest request) {
		Passagem passagem = findById(id);
		
		em.getTransaction().begin();
		passagem = em.merge(passagem);
		em.flush();

		passagem.setNomeDoPassageiro(request.getParameter("nome"));
		passagem.setOrigem(request.getParameter("origem"));
		passagem.setDestino(request.getParameter("destino"));
		passagem.setValorDaPassagem(Double.valueOf(request.getParameter("valor")));
		
		em.getTransaction().commit();
	}
	
}
