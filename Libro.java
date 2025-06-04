/*
 * Irene Escudero Cazarez
 * 215698
 * Clase libro para proyecto final AyP
 * 29/04/24
 */

import java.util.Objects;

public class Libro implements Comparable<Libro> {
	private String titulo;
	private String autor;
	private int anio;
	private int numPaginas;
	private String editorial;	
	
//Constructor
	public Libro(String unTitulo, String unAutor, int unAnio, int unNumPaginas, String unEditorial) {
		titulo = unTitulo;
		autor = unAutor;
		anio = unAnio;
		numPaginas = unNumPaginas;
		editorial = unEditorial;
	}
//Getters y Setters

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public int getAnio() {
		return anio;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public String getEditorial() {
		return editorial;
	}

	
//Comparaiones
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(titulo, other.titulo);
	}
	
	public int compareTo(Libro otro) {
		return titulo.compareTo(otro.getTitulo());
	}

	
//ToString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Título:             "+titulo+"\n");
		builder.append("Autor:              "+autor+"\n");
		builder.append("Año:                "+anio+"\n");
		builder.append("Número de páginas:  "+numPaginas+"\n");
		builder.append("Editorial:          "+editorial+"\n");
		return builder.toString();
	}
	
	
	
	
}//class