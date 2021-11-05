package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.dao.PassagemDAO;
import model.Passagem;

@WebServlet(urlPatterns = {"/MainController", "/main", "/insert"})
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MainController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch (action) {
		case "/main":
			passagens(request, response);
			
			break;
		case "/insert":
			novaPassagem(request, response);
			
			break;
		default:
			response.sendRedirect("index.html");
			
			break;
		}
	}
	
	//Listar passagens
	protected void passagens(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("passagens.jsp");
	}
	
	//Nova Passagem
	private void novaPassagem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Criando um objeto Passagem
		Passagem passagem = new Passagem(null,
				request.getParameter("nome"),
				request.getParameter("origem"),
				request.getParameter("destino"),
				Double.valueOf(request.getParameter("valor")));
		
		System.out.println(passagem);
		
		PassagemDAO.insert(passagem);
	}
	
}
