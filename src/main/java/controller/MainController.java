package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.dao.PassagemDAO;
import model.Passagem;

@WebServlet(urlPatterns = {"/MainController", "/main", "/insert", "/listarPassagens", "/update", "/delete"})
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
				response.sendRedirect("main");
				
				break;
			case "/listarPassagens":
				Passagem passagem = procurarPassagem(request, response);
				listarPassagens(passagem, request, response);
				
				break;
			case "/update":
				atualizarPassagem(request, response);
				
				break;
			case "/delete":
				deletarPassagem(request, response);
				
				break;
			default:
				response.sendRedirect("index.html");
				
				break;
		}
	}
	
	//Listar passagens
	protected void passagens(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Passagem> passagens = PassagemDAO.findAll();
		
		//Encaminhar lista para o documento "passagem.jsp"
		request.setAttribute("passagens", passagens);
		RequestDispatcher rd = request.getRequestDispatcher("passagens.jsp");
		rd.forward(request, response);
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
	
	//Devolve um objeto do tipo Passagem procurando pelo id
	private Passagem procurarPassagem(HttpServletRequest request, HttpServletResponse response) {
		//Recebimento do id do contato que será editado
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		return PassagemDAO.findById(id);
	}
	
	//Preenche os campos do editar.jsp
	private void listarPassagens(Passagem passagem, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Preencher os campos vazios do editar.jsp
		request.setAttribute("id", passagem.getId());
		request.setAttribute("nome", passagem.getNomeDoPassageiro());
		request.setAttribute("origem", passagem.getOrigem());
		request.setAttribute("destino", passagem.getDestino());
		request.setAttribute("valor", passagem.getValorDaPassagem());
		
		//Encaminhar ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}
	
	//Atualiza uma Passagem de acordo com os dados dos campos
	private void atualizarPassagem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Pega o Id da Passagem
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		//Atualiza a passagem
		PassagemDAO.updatePassagem(id, request);
		
		//Redireciona para o documento passagens.jsp
		response.sendRedirect("main");
	}
	
	//Remove uma passagem
	private void deletarPassagem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		PassagemDAO.deletePassagem(id);
		
		response.sendRedirect("main");
	}
	
}
