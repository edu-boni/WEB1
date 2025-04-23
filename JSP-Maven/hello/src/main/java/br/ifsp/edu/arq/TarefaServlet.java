package br.ifsp.edu.arq;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/tarefa")
public class TarefaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TarefaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		
		if (nome.isEmpty() || descricao.isEmpty()) {
			String msg = "Nome e descrição não podem ser vazios";
			getServletContext().setAttribute("mensagem", msg);
			getServletContext().getRequestDispatcher("index.jsp").forward(request, response)
		}else {
			ArrayList<Tarefa> lista = (ArrayList<Tarefa>) getServletContext().getAttribute("lista");
			
			if (lista == null) {
				lista = new ArrayList<Tarefa>();
			}
			Tarefa t = new Tarefa(nome, descricao);
			
			getServletContext().setAttribute("tarefa", t);
			
			getServletContext().getRequestDispatcher("/resposta.jsp").forward(request, response);
		}
		
		
		
	
	}

}
