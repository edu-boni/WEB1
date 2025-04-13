package br.edu.ifsp.arq;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/editar-livro", "/atualizar-livro"})
public class UpdateLivroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdateLivroServlet() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null) {
            int id = Integer.parseInt(idParam);
            ArrayList<Livro> listaLivros = (ArrayList<Livro>) getServletContext().getAttribute("lista_livros");

            if (listaLivros != null) {
                Livro livro = null;
                for (Livro l : listaLivros) {
                    if (l.getId() == id) {
                        livro = l;
                        break;
                    }
                }

                if (livro != null) {
                    response.setContentType("text/html");
                    PrintWriter out = response.getWriter();
                    out.print("<html><head><title>Editar Livro</title></head><body>");
                    out.print("<h1>Editar Livro</h1>");
                    out.print("<form action='atualizar-livro' method='post'>");
                    out.print("<input type='hidden' name='id' value='" + livro.getId() + "' />");
                    out.print("<label for='titulo'>Título do livro:</label> ");
                    out.print("<input type='text' id='titulo' name='titulo' value='" + livro.getTitulo() + "'><br><br>");
                    out.print("<label for='autor'>Autor:</label> ");
                    out.print("<input id='autor' name='autor' value='" + livro.getAutor() + "'></input><br><br>");

                    out.print("<input type='checkbox' id='ficcao' name='generos' value='ficcao'");
                    if (livro.getGeneros().contains("ficcao")) out.print(" checked");
                    out.print("> <label for='ficcao'>Ficção</label><br><br>");

                    out.print("<input type='checkbox' id='naoficcao' name='generos' value='naoficcao'");
                    if (livro.getGeneros().contains("naoficcao")) out.print(" checked");
                    out.print("> <label for='naoficcao'>Não-Ficção</label><br><br>");

                    out.print("<input type='checkbox' id='fantasia' name='generos' value='fantasia'");
                    if (livro.getGeneros().contains("fantasia")) out.print(" checked");
                    out.print("> <label for='fantasia'>Fantasia</label><br><br>");

                    out.print("<input type='checkbox' id='romance' name='generos' value='romance'");
                    if (livro.getGeneros().contains("romance")) out.print(" checked");
                    out.print("> <label for='romance'>Romance</label><br><br>");

                    out.print("<button type='submit'>Salvar Alterações</button>");
                    out.print("</form>");
                    out.print("<br><br>");
                    out.print("<a href='listar-livros'>Voltar para a lista de livros</a>");
                    out.print("</body></html>");
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Livro não encontrado");
                }
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID não fornecido");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String[] generos = request.getParameterValues("generos");

        if (idParam != null && titulo != null && autor != null && generos != null) {
            int id = Integer.parseInt(idParam);
            ArrayList<Livro> listaLivros = (ArrayList<Livro>) getServletContext().getAttribute("lista_livros");

            if (listaLivros != null) {
                Livro livro = null;
                for (Livro l : listaLivros) {
                    if (l.getId() == id) {
                        livro = l;
                        break;
                    }
                }

                if (livro != null) {
                    livro.setTitulo(titulo);
                    livro.setAutor(autor);
                    livro.setGeneros(new ArrayList<String>());
                    for (String g : generos) {
                        livro.getGeneros().add(g);
                    }
                    getServletContext().setAttribute("lista_livros", listaLivros);
                }
            }
            response.sendRedirect("listar-livros");
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Dados incompletos");
        }
    }
}
