package br.edu.ifsp.arq;
import java.util.ArrayList;

public class Livro {
	String titulo;
	String autor;
	ArrayList<String> generos;

	public Livro(String titulo, String autor, ArrayList<String> generos) {
		this.titulo = titulo;
		this.autor = autor;
		this.generos = generos;
	}
	
	public String getNome() {
		return titulo;
	}

	public String getDescricao() {
		return autor;
	}

	public ArrayList<String> getAtributos() {
		return generos;
	}

	@Override
	public String toString() {
		String s = this.titulo + " \n" + this.autor;
		for (String a : generos) {
			s += a + " \n";
		}
		return s;
	}
}
