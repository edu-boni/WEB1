package br.edu.ifsp.arq;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/listar-livros")
public class ReadLivroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadLivroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Livro> listaLivros = (ArrayList<Livro>) getServletContext().getAttribute("lista_livros");
		
		PrintWriter out = resp.getWriter();
		out.print("<head><title>Lista de Livros</title><link rel='stylesheet' href='estilo.css'></head>");
		out.print("<h1>Livros Cadastrados</h1>");
		
		out.print("<table border='1'>");
		out.print("<tr><th>Título</th><th>Autor</th><th>Gêneros</th><th>Edição</th><th>Exclusão</th></tr>");
		
		for (Livro l : listaLivros) {
		    out.print("<tr>");
		    out.print("<td>" + l.getTitulo() + "</td>");
		    out.print("<td>" + l.getAutor() + "</td>");
		    out.print("<td>" + String.join(", ", l.generos) + "</td>");
		    out.print("<td>");
		    out.print("<a href='editar-livro?id=" + l.getId() + "'>Editar</a>");
		    out.print("</td>");
		    out.print("<td>");
		    out.print("<a href='excluir-livro?id=" + l.getId() + "'>Excluir</a>");
		    out.print("</td>");
		    out.print("</tr>");
		}


		
		out.print("</table>");
		out.print("<br>");
		out.print("<a href='/exercicio_livro/index.html'>Voltar para o formulário</a>");
		out.print("</body></html>");
		resp.setContentType("text/html");    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
