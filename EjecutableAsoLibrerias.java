/*
 * Irene Escudero Cazarez
 * 215698
 * 11/05//24
 * Clase para probar la clase libreria y libro
 */

import java.util.ArrayList;

public class EjecutableAsoLibrerias {
	public static void main(String[] args) {
	AsoLib candi;
	boolean resp;
	int cuantos;
	String donde, info, librerias;
	ArrayList<String> a;

	candi=new AsoLib("Candi");
	//Altas y bajas librerias
	resp=candi.altaLibreria("Polanco", "Calle 1", "Irene");//Caso alta correcta
	System.out.println(resp);
	resp=candi.altaLibreria("Polanco", "Calle 1", "Irene");//Alta a elemento ya existente
	System.out.println(resp);
	resp=candi.altaLibreria("Santa Fe", "Calle 2", "Melanie");//Caso alta correcta
	System.out.println(resp);
	resp=candi.altaLibreria("Tlalpan", "Calle 3", "Alain");//Caso alta correcta
	System.out.println(resp);
	resp=candi.bajaLibreria("Tlalpan");//Caso baja corecta
	System.out.println(resp);
	resp=candi.bajaLibreria("Chilpancingo");//Baja a un elemento inexistente
	
	//Altas y bajas libro
	System.out.println(resp);
	resp=candi.altaLibro("Uno", "Yo",2024, 500, "Penguin", 10, "Polanco");//Caso alta correcta
	System.out.println(resp);
	resp=candi.altaLibro("Dos", "Yo",2024, 500, "Penguin", 10, "Polanco");//Caso alta correcta
	System.out.println(resp);
	resp=candi.altaLibro("Uno", "Yo",2024, 500, "Penguin", 6, "Santa Fe");//Caso alta correcta
	System.out.println(resp);
	resp=candi.altaLibro("Uno", "Yo",2024, 500, "Penguin", 6, "Santa Fe");//Alta a un elemento que ya existe
	System.out.println(resp);
	resp=candi.altaLibro("Uno", "Yo",2024, 500, "Penguin", 6, "Chilpancingo");//Libreria inexistente
	System.out.println(resp);
	resp=candi.bajaLibro("Dos","Polanco");//Caso baja correcta
	System.out.println(resp);
	resp=candi.bajaLibro("Dos","Polanco");//Baja a un elemento inexistente
	System.out.println(resp);
	resp=candi.bajaLibro("Uno","Chilpancingo");//Baja a un elemento de una libreria inexistente
	System.out.println(resp);
	
	//Registrar venta
	resp=candi.registrarVenta("Uno","Polanco", 2);//Caso venta correcta
	System.out.println(resp);
	resp=candi.registrarVenta("Uno","Polanco", 100);//Vender mas libros de los que hay en existencia
	System.out.println(resp);
	resp=candi.registrarVenta("Dos","Polanco", 2);//Libro inexistente
	System.out.println(resp);
	resp=candi.registrarVenta("Uno","Chilpancingo", 2);//Libreria inexistente
	System.out.println(resp);
	resp=candi.registrarVenta("Uno","Santa Fe", 6);//Caso venta correcta en el que se venden todos los libros en existencia
	System.out.println(resp);
	
	//Dar de alta libros para poder apreciar las siguientes funciones
	System.out.println(candi.toString());
	resp=candi.altaLibro("Uno", "Yo",2024, 500, "Penguin", 6, "Santa Fe");
	System.out.println(resp);
	
	//Cuantos
	cuantos=candi.cuantosHayTituloTotal("Uno");//Caso correcto, debe haber 14 libros "Uno" entre todas las librerias
	System.out.println(cuantos);
	cuantos=candi.cuantosHayTituloTotal("Dos");//Libro inexistente, debe regresar 0
	System.out.println(cuantos);
	cuantos=candi.cuantosHayTituloLib("Uno", "Polanco");//Caso correcto, debe haber 8 libros "Uno" en "Polanco"
	System.out.println(cuantos);
	cuantos=candi.cuantosHayTituloLib("Dos", "Polanco");//Libro inexistente, debe regresar 0
	System.out.println(cuantos);
	cuantos=candi.cuantosHayTituloLib("Uno", "Chilpancingo");//Libreria inexistente, debe regresar 0
	System.out.println(cuantos);
	
	//Donde
	donde=candi.donde("Uno"); //Caso correcto, Polanco 8 y Santa Fe 6
	System.out.println(donde);
	donde=candi.donde("Dos"); //Libro inexistente
	System.out.println(donde);
	
	//Agregar ejemplares
	resp=candi.agregarEjemplares("Uno", 2, "Polanco");//Caso correcto
	System.out.println(resp);
	resp=candi.agregarEjemplares("Dos", 2, "Polanco");//Libro inexistente
	System.out.println(resp);
	resp=candi.agregarEjemplares("Uno", 2, "Chilpancingo");//Libreria inexistente
	System.out.println(resp);
	
	
	//Titulos por autor
	a=candi.titulosPorAutor("Yo no");//Autor inexistente
	System.out.println(a);
	a=candi.titulosPorAutor("Yo");//Caso correcto, ArrayList con el titulo "Uno"
	System.out.println(a);
	
	//Cambiar de libreria
	resp=candi.cambioDeLibreria("Dos","Polanco", "Santa Fe", 2);//libro inexistente
	System.out.println(resp);
	resp=candi.cambioDeLibreria("Uno","Chilpancingo", "Santa Fe", 2);//libreria inexistente
	System.out.println(resp);
	resp=candi.cambioDeLibreria("Uno","Polanco", "Cilpancingo", 2);//libreria destino inexistente
	System.out.println(resp);
	resp=candi.cambioDeLibreria("Uno","Polanco", "Santa Fe", 100);//Mas libros de los que hay
	System.out.println(resp);
	resp=candi.cambioDeLibreria("Uno","Polanco", "Santa Fe", 2);//Caso correcto
	System.out.println(resp);
	resp=candi.cambioDeLibreria("Uno","Polanco", "Santa Fe", 6);//Caso correcto, en el que se cambian todos los libros existentes a otra libreria
	System.out.println(resp);
	
	//Info
	info=candi.infoLibreria("Santa Fe");//Caso correcto
	System.out.println(info);
	info=candi.infoLibreria("Chilpancingo");//Libreria inexistente
	System.out.println(info);
	info=candi.infoLibro("Uno","Santa Fe");//Caso correcto
	System.out.println(info);
	info=candi.infoLibro("Dos","Santa Fe");//Libro inexistente
	System.out.println(info);
	info=candi.infoLibro("Uno","Chilpancingo");//Libreria inexistente
	System.out.println(info);
	
	//Librerias
	librerias=candi.librerias();//caso correcto
	System.out.println(librerias);
	
	}//main
}//class
