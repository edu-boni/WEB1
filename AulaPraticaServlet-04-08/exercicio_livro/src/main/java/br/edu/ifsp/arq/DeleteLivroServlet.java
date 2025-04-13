package br.edu.ifsp.arq;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/excluir-livro")
public class DeleteLivroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteLivroServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null) { 
        	int id = Integer.parseInt(idParam);
            ArrayList<Livro> listaLivros = (ArrayList<Livro>) getServletContext().getAttribute("lista_livros");

            if (listaLivros != null) {
                listaLivros.removeIf(l -> l.getId() == id);
                getServletContext().setAttribute("lista_livros", listaLivros);
            }
        } 
    	resp.sendRedirect("listar-livros");
    }

    @Override
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
