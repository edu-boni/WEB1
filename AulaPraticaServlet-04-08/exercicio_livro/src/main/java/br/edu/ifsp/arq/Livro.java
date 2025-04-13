package br.edu.ifsp.arq;
import java.util.ArrayList;

public class Livro {
	private static int contador = 1;
	private String titulo;
	private String autor;
	private int id;
	ArrayList<String> generos;

	public Livro(String titulo, String autor, ArrayList<String> generos) {
		this.id = contador++;
		this.titulo = titulo;
		this.autor = autor;
		this.generos = generos;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public ArrayList<String> getAtributos() {
		return generos;
	}
	
	public ArrayList<String> getGeneros() {
		return generos;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setGeneros(ArrayList<String> generos) {
		this.generos = generos;
	}
}
