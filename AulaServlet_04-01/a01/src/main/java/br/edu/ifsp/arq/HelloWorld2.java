package br.edu.ifsp.arq;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloWorld2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String idade = req.getParameter("idade");
		PrintWriter out = resp.getWriter();
		
		out.append("<h1>Hello World de !</h1>");
		out.append("<h1>Nome: " + nome + "</h1>");
		out.append("<h1>Idade: " + idade + "</h1>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nomeTarefa = req.getParameter("nome");
		String descricao = req.getParameter("descricao");
		String periodos[] = req.getParameterValues("periodo");
		PrintWriter out = resp.getWriter();
		
		out.append("<h1>Nome: " + nomeTarefa + "</h1>");
		out.append("<h1>Idade: " + descricao + "</h1>");
		
		for (String p : periodos) {
			out.append("<h1>Período " + p + "</h1>");
		}
	}
	
	
	
}
