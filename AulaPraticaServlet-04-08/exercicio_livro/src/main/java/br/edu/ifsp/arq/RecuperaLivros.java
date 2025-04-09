package br.edu.ifsp.arq;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RecuperaLivros")
public class RecuperaLivros extends HttpServlet {
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

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        out.print("<html><head><title>Lista de Livros</title></head><body>");
        out.print("<h1>Livros Cadastrados</h1>");
        
        out.print("<table border='1'>");
        out.print("<tr><th>Título</th><th>Autor</th><th>Gêneros</th></tr>");
        
        for (Livro l : listaLivros) {
            out.print("<tr>");
            out.print("<td>" + l.titulo + "</td>");
            out.print("<td>" + l.autor + "</td>");
            out.print("<td>" + String.join(", ", l.generos) + "</td>");
            out.print("</tr>");
        }

        out.print("</table>");
        out.print("<br>");
        out.print("<a href='/index.html'>Voltar para o formulário</a>");
        out.print("</body></html>");
    }
}
