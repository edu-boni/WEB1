package br.edu.ifsp.arq;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/criar-livro")
public class CreateLivroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String titulo = req.getParameter("titulo");
        String autor = req.getParameter("autor");
        String[] generos = req.getParameterValues("generos");
        ArrayList<String> lista_generos = new ArrayList<String>();

        for (String g : generos) {
            lista_generos.add(g);
        }

        Livro livro = new Livro(titulo, autor, lista_generos);

        ArrayList<Livro> listaLivros = (ArrayList<Livro>) getServletContext().getAttribute("lista_livros");
        if (listaLivros == null) {
            listaLivros = new ArrayList<Livro>();
        }

        listaLivros.add(livro);
        getServletContext().setAttribute("lista_livros", listaLivros);
        getServletContext().setAttribute("livro", livro);
        resp.sendRedirect("listar-livros");
    }
}
