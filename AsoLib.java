/*
 * Irene Escudero Cazarez
 * 215698
 * Clase con un arreglo de librerias que tienen a su vez un arreglo de libros, una asociacion de librerias
 * 29/04/24
 */

import java.util.Objects;
import java.util.ArrayList;

public class AsoLib {
	private String nombre;
	private Libreria[] librerias;
	private final int MAX=15;
	private int ocupados;
	
//constructores
	public AsoLib() {
		ocupados=0;
		librerias=new Libreria[MAX];
	}
	public AsoLib(String nombre) {
		this();
		this.nombre = nombre;
		ocupados=0;
		librerias=new Libreria[MAX];
	}

//geters y setters
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
		AsoLib other = (AsoLib) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	public int compareTo(AsoLib otro) {
		return nombre.compareTo(otro.getNombre());
	}
	
//to String
	@Override
	public String toString() {
		int i;
		StringBuilder builder = new StringBuilder();
		builder.append("Librerias "+ nombre+"\n");
		builder.append("Ocupados: "+ ocupados+"\n");
		for(i=0;i<ocupados;i++) 
			builder.append(librerias[i].toString()+"\n");
		return builder.toString();
	}

//funcionalidad propia del problema
	public boolean altaLibreria(String nombre, String direccion, String gerente) {
		boolean resp=true;
		Libreria b;
		
		if(ocupados<MAX) {
			b=new Libreria(nombre,direccion,gerente);
			resp=ManejadorArreglosGenerico.altaOrdenada(librerias, ocupados, b);
			if(resp) 
				ocupados++;
			}else
				resp=false;
		return resp;	
		}
	
	
	public boolean bajaLibreria(String nombre) {
		boolean resp;
		Libreria b;
		
		b=new Libreria(nombre,"","");
		resp=ManejadorArreglosGenerico.bajaOrdenada(librerias, ocupados,b);
		if(resp) 
			ocupados--;
		return resp;	
		}
	
	public boolean altaLibro(String unTitulo, String unAutor, int unAnio, int unNumPaginas, String unEditorial, int ejem, String libreria) {
		boolean resp=false;
		Libreria b;
		int pos;
		if(ejem>0) {
		b=new Libreria(libreria, "","");
		pos=ManejadorArreglosGenerico.buscaBinaria(librerias, ocupados,b);
		if(pos>=0)
			resp=librerias[pos].altaLibro(unTitulo, unAutor, unAnio, unNumPaginas, unEditorial, ejem);
		}
		return resp;	
		}
	
	
	public boolean bajaLibro(String unTitulo, String libreria) {
		boolean resp=false;
		Libreria b;
		int pos;
		b=new Libreria(libreria, "","");
		pos=ManejadorArreglosGenerico.buscaBinaria(librerias, ocupados,b);
		if(pos>=0)
			resp=librerias[pos].bajaLibro(unTitulo);
		
		return resp;	
		}
	
	public boolean registrarVenta(String unTitulo, String libreria, int ejem) {
		boolean resp=false;
		Libreria b;
		int pos;
		b=new Libreria(libreria, "","");
		pos=ManejadorArreglosGenerico.buscaBinaria(librerias, ocupados,b);
		if(pos>=0)
		resp=librerias[pos].registrarVentaLib(unTitulo, ejem);
		return resp;
	}

	public int cuantosHayTituloTotal(String unTitulo) {
		int resp=0,i;
		for(i=0; i<ocupados;i++)
			resp=resp+librerias[i].cuantosHayTitulo(unTitulo);
		return resp;
	}
	
	public int cuantosHayTituloLib(String unTitulo, String libreria) {
		int resp=0;
		Libreria b;
		int pos;
		b=new Libreria(libreria, "","");
		pos=ManejadorArreglosGenerico.buscaBinaria(librerias, ocupados,b);
		if(pos>=0)
			resp=librerias[pos].cuantosHayTitulo(unTitulo);
		return resp;
	}

	public String donde(String unTitulo) {
		StringBuilder sb;
		int i, cuantos=0;
		sb=new StringBuilder();
		for(i=0; i<ocupados; i++)
			if(librerias[i].cuantosHayTitulo(unTitulo)>0) {
				sb.append(librerias[i].getNombre()+": "+librerias[i].cuantosHayTitulo(unTitulo)+"\n");
				cuantos++;
			}
		if(cuantos==0)
			sb.append("Libro no encontrado");
		return sb.toString();
	}
	
	public ArrayList<String> titulosPorAutor(String unAutor) {
		ArrayList<String> a;
		a=new ArrayList<String>();
		int i;
		for(i=0; i<ocupados;i++)
				a=ManejadorArreglosGenerico.unionArrayList(a, librerias[i].librosAutor(unAutor));
		return a;
	}
	
	public boolean cambioDeLibreria(String unTitulo, String libOrigen, String libDestino, int ejem) {
		boolean resp=false;
		Libreria b, c;
		int pos1,pos, cuantos, numPag, anio;
		String editorial, autor;
		b=new Libreria(libOrigen, "","");
		pos1=ManejadorArreglosGenerico.buscaBinaria(librerias, ocupados,b);
		if(pos1>=0) {
			if(librerias[pos1].cuantosHayTitulo(unTitulo)>0) {
				autor=librerias[pos1].getAutor(unTitulo);
				editorial=librerias[pos1].getEditorial(unTitulo);
				numPag=librerias[pos1].getNumPag(unTitulo);
				anio=librerias[pos1].getAnio(unTitulo);
				c=new Libreria(libDestino, "","");
				pos=ManejadorArreglosGenerico.buscaBinaria(librerias, ocupados,c);
				if(pos>=0) {
					resp=librerias[pos1].registrarVentaLib(unTitulo, ejem);
						if(resp) {
							cuantos=librerias[pos].cuantosHayTitulo(unTitulo);
							if(cuantos==0)
								librerias[pos].altaLibro(unTitulo,autor, anio, numPag, editorial, ejem);
							if(cuantos>0)
								resp=librerias[pos].agregarEjemplares(unTitulo, ejem);
						}
				}	
			}
		}	
		return resp;
	}

	public boolean agregarEjemplares(String unTitulo, int ejem, String libreria) {
		boolean resp=false;
		Libreria b;
		int pos;
		b=new Libreria(libreria, "","");
		pos=ManejadorArreglosGenerico.buscaBinaria(librerias, ocupados,b);
		if(pos>=0)
		resp=librerias[pos].agregarEjemplares(unTitulo, ejem);
		return resp;
	}
	
	public String infoLibreria(String libreria) {
		String resp;
		Libreria b;
		int pos;
		b=new Libreria(libreria, "","");
		pos=ManejadorArreglosGenerico.buscaBinaria(librerias, ocupados,b);
		if(pos>=0)
			resp=librerias[pos].toString();
		else
			resp="Libreria NO encontrada";
		return resp;
	}
	
	public String infoLibro(String titulo, String libreria) {
		String resp;
		Libreria b;
		int pos;
		b=new Libreria(libreria, "","");
		pos=ManejadorArreglosGenerico.buscaBinaria(librerias, ocupados,b);
		if(pos>=0) {
			resp=librerias[pos].infoLibro(titulo);
		}
		else
			resp="Libreria no encontrada";
		return resp;
	}
	
	public String librerias () {
		String resp;
		resp=ManejadorArreglosGenerico.imprimeArreglo(librerias, ocupados);
		return resp;
	}
	
	
}//class
