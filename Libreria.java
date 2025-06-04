/*
 * Irene Escudero Cazarez
 * 215698
 * Clase libreria para proyecto final AyP
 * 29/04/24
 */

import java.util.Objects;
import java.util.ArrayList;
public class Libreria implements Comparable <Libreria> {
	private String nombre;
	private String direccion;
	private String gerente;
	private Libro[] libros;
	private Integer[] ejemplares;
	private final int MAX=50; //capacidad de almacenamiento de las librerias (estantes o repisas)
	private int ocupados;
	
	
	//Constructores
	public Libreria() {
		ocupados=0;
		libros= new Libro[MAX];
		ejemplares= new Integer[MAX];
	}
		
	public Libreria(String nombre, String direccion, String gerente) {
		this();
		ocupados=0;
		this.direccion = direccion;
		this.nombre = nombre;
		this.gerente = gerente;
		libros= new Libro[MAX];
		ejemplares= new Integer[MAX];
	}
	//Getters y Setters
	
	public String getGerente() {
		return gerente;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getOcupados() {
		return ocupados;
	}
	
	//Comparaciones
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libreria other = (Libreria) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	public int compareTo(Libreria otra) {
		return nombre.compareTo(otra.getNombre());
	}
	
	//ToString
	@Override
	public String toString() {
		int i;
		StringBuilder builder = new StringBuilder();
		builder.append("Nombre:       "+nombre+"\n");
		builder.append("Dirección:    "+direccion+"\n");
		builder.append("Gerente:      "+gerente+"\n");
		builder.append("Ocupados:     "+ocupados+"\n");
		builder.append("Libros disponibles en la sucursal: \n");
		for(i=0; i<ocupados; i++) {
			builder.append(libros[i].getTitulo()+": "+ejemplares[i]+"\n");
		}
		return builder.toString();
	}
	
	//funcionalidad propia del problema
	public boolean altaLibro(String unTitulo, String unAutor, int unAnio, int unNumPaginas, String unEditorial, int ejem) {
		boolean resp=true;
		Libro b;
		int pos;
		
		if(ocupados<MAX) {
			b=new Libro(unTitulo,unAutor,unAnio,unNumPaginas,unEditorial);
			resp=ManejadorArreglosGenerico.altaOrdenada(libros, ocupados, b);
			if(resp) {
				ocupados++;
				pos=ManejadorArreglosGenerico.buscaBinaria(libros, ocupados, b);
				ManejadorArreglosGenerico.recorrePosDer(ejemplares, ocupados-1, pos);
				ejemplares[pos]=ejem;
			}
			}else
				resp=false;
		return resp;	
		}
	
	
	public boolean bajaLibro(String unTitulo) {
		boolean resp;
		Libro b;
		int pos;
		
		b=new Libro(unTitulo,"",0, 0, "");
		pos=ManejadorArreglosGenerico.buscaBinaria(libros, ocupados, b);
		resp=ManejadorArreglosGenerico.bajaOrdenada(libros, ocupados,b);
		if(resp) {
			ManejadorArreglosGenerico.recorrePosIzq(ejemplares, ocupados, pos);
			ocupados--;
		}
		return resp;	
		}
	

	public boolean registrarVentaLib(String unTitulo, int ejem) {
		boolean resp=true;
		Libro b;
		int pos;
		
		b=new Libro(unTitulo,"",0, 0, "");
		pos=ManejadorArreglosGenerico.buscaBinaria(libros, ocupados, b);
		if(pos>=0) {
			if(ejemplares[pos]>ejem) {
				ejemplares[pos]=ejemplares[pos]-ejem;
				resp=true;
			}else {
			if(ejemplares[pos]<ejem)
				resp=false;
			if(ejemplares[pos]==ejem)
				resp=bajaLibro(unTitulo);
			}
		}else
			resp=false;
		return resp;
	}


	public int cuantosHayTitulo(String unTitulo) {
		int resp=0;
		Libro b;
		int pos;
		
		b=new Libro(unTitulo,"",0, 0, "");
		pos=ManejadorArreglosGenerico.buscaBinaria(libros, ocupados, b);
		if(pos>=0)
			resp=ejemplares[pos];
		return resp;
	}
	
	public ArrayList<String> librosAutor(String unAutor){
		ArrayList<String> a;
		int i;
		a=new ArrayList<String>();
		for(i=0; i<ocupados; i++)
			if(libros[i].getAutor().equals(unAutor))
				if(!a.contains(libros[i].getTitulo()))
					a.add(libros[i].getTitulo());
		return a;
	}
	
	public String getAutor(String unTitulo) {
		Libro b;
		int pos;
		String autor;
		
		b=new Libro(unTitulo,"",0, 0, "");
		pos=ManejadorArreglosGenerico.buscaBinaria(libros, ocupados, b);
		autor=libros[pos].getAutor();
		return autor;
	}
	
	public int getAnio(String unTitulo) {
		Libro b;
		int pos, anio;
		
		b=new Libro(unTitulo,"",0, 0, "");
		pos=ManejadorArreglosGenerico.buscaBinaria(libros, ocupados, b);
		anio=libros[pos].getAnio();
		return anio;
	}
	
	public int getNumPag(String unTitulo) {
		Libro b;
		int pos, numPag;
		
		b=new Libro(unTitulo,"",0, 0, "");
		pos=ManejadorArreglosGenerico.buscaBinaria(libros, ocupados, b);
		numPag=libros[pos].getNumPaginas();
		return numPag;
	}
	
	public String getEditorial(String unTitulo) {
		Libro b;
		int pos;
		String editorial;
		
		b=new Libro(unTitulo,"",0, 0, "");
		pos=ManejadorArreglosGenerico.buscaBinaria(libros, ocupados, b);
		editorial=libros[pos].getEditorial();
		return editorial;
	}
	
	public boolean agregarEjemplares(String unTitulo, int ejem) {
		boolean resp=false;
		Libro b;
		int pos;
		
		b=new Libro(unTitulo,"",0, 0, "");
		pos=ManejadorArreglosGenerico.buscaBinaria(libros, ocupados, b);
		if(pos>=0) {
			ejemplares[pos]=ejemplares[pos]+ejem;
			resp=true;
		}
		return resp;
	}
	
	public String infoLibro(String titulo) {
		String resp;
		Libro b;
		int pos;
		b=new Libro(titulo, "",0, 0, "");
		pos=ManejadorArreglosGenerico.buscaBinaria(libros, ocupados,b);
		if(pos>=0)
			resp=libros[pos].toString();
		else
			resp="Libro no encontrado";
		return resp;
	}

}//class