/*
 * Irene Escudero Cazarez
 * 215698
 * 09/05/24
 * Clase controlador para la ventana de asociacion de librerias
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class ControladorAsoLib extends VistaAsoLib{
	private AsoLib candhi;
	
	
	//Escuchas
	public class EscuchaAltaLibreria implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String nombre, dir, gerente;
			boolean resp;
			nombre=ctNom.getText();
			dir=ctDir.getText();
			gerente=ctGerente.getText();
			resp=candhi.altaLibreria(nombre, dir, gerente);
			if(resp)
				taInfo.setText("Alta exitosa libreria");
			else
				taInfo.setText("Alta NO exitosa libreria");
		}
	}//class escucha alta libreria
	
	public class EscuchaBajaLibreria implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String nombre;
			boolean resp;
			nombre=ctNom.getText();
			resp=candhi.bajaLibreria(nombre);
			if(resp)
				taInfo.setText("Baja exitosa libreria");
			else
				taInfo.setText("Baja NO exitosa libreria");
		}
	}//class escucha baja libreria
	
	public class EscuchaAltaLibro implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String titulo, autor, editorial, sAnio, sPag, sEjem, libreria;
			boolean resp;
			int anio, pag, ejem;
			titulo=ctTitulo.getText();
			autor=ctAutor.getText();
			editorial=ctEditorial.getText();
			sAnio=ctAnio.getText();
			sPag=ctPag.getText();
			sEjem=ctEjem.getText();
			try {
				anio=Integer.parseInt(sAnio);
				pag=Integer.parseInt(sPag);
				ejem=Integer.parseInt(sEjem);
				libreria=ctNom.getText();
				resp=candhi.altaLibro(titulo, autor, anio, pag, editorial, ejem, libreria);
			if(resp)
				taInfo.setText("Alta exitosa libro");
			else
				taInfo.setText("Alta NO exitosa libro");
			}catch(Exception p) {
				taInfo.setText("Alta NO exitosa");
			}
		}
	}//class escucha alta libro
	
	public class EscuchaBajaLibro implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String libreria, titulo;
			boolean resp;
			libreria=ctNom.getText();
			titulo=ctTitulo.getText();
			resp=candhi.bajaLibro(titulo, libreria);
			if(resp)
				taInfo.setText("Baja exitosa libro");
			else
				taInfo.setText("Baja NO exitosa libro");
		}
	}//class escucha baja libro
	
	public class EscuchaRegistrarVenta implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String libreria, titulo, sEjem;
			int ejem;
			boolean resp;
			libreria=ctNom.getText();
			titulo=ctTitulo.getText();
			sEjem=ctEjem.getText();
			try {
				ejem=Integer.parseInt(sEjem);
				resp=candhi.registrarVenta(titulo, libreria, ejem);
				if(resp)
					taInfo.setText("Venta exitosa");
				else
					taInfo.setText("Venta NO exitosa");
			}catch(Exception p) {
				taInfo.setText("Venta NO exitosa");
			}
		}
	}//class escucha registrar venta
	
	public class EscuchaCuantos implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String libreria, titulo;
			int resp;
			libreria=ctNom.getText();
			titulo=ctTitulo.getText();
			if(libreria.equals(""))
				resp=candhi.cuantosHayTituloTotal(titulo);
			else
				resp=candhi.cuantosHayTituloLib(titulo, libreria);
		 taInfo.setText(resp+"");
		}
	}//class escucha cuantos
	
	public class EscuchaDonde implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String titulo, resp;
			titulo=ctTitulo.getText();
			resp=candhi.donde(titulo);
			taInfo.setText(resp);
		}
	}//class escucha donde
	
	public class EscuchaAgregarEjemplares implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String titulo, sEjem, libreria;
			boolean resp;
			int ejem;
			titulo=ctTitulo.getText();
			libreria=ctNom.getText();
			sEjem=ctEjem.getText();
			try {
				ejem=Integer.parseInt(sEjem);
				resp=candhi.agregarEjemplares(titulo, ejem, libreria);
				if(resp)
					taInfo.setText("Ejemplares agregados");
				else
					taInfo.setText("Ejemplares NO agregados");
			}catch(Exception p) {
				taInfo.setText("Ejemplares NO agregados");
			}
			
		}
	}//class escucha agregar ejemplares
	
	public class EscuchaTitulosPorAutor implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String autor;
			ArrayList<String> a;
			autor=ctAutor.getText();
			a=candhi.titulosPorAutor(autor);
			if(a.size()==0)
				taInfo.setText("No contamos con libros del autor indicado");
			else
				taInfo.setText(a.toString());
		}
	}//class escucha titulos por autor
	
	public class EscuchaCambiarLib implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String titulo, libreria, libreriaDestino, sEjem;
			boolean resp;
			int ejem;
			titulo=ctTitulo.getText();
			libreria=ctNom.getText();
			libreriaDestino=ctLibDest.getText();
			sEjem=ctEjem.getText();
			try {
				ejem=Integer.parseInt(sEjem);
				resp=candhi.cambioDeLibreria(titulo, libreria, libreriaDestino, ejem);
				if(resp)
					taInfo.setText("Cambio exitoso");
				else
					taInfo.setText("Cambio NO exitoso");
			}catch(Exception p) {
				taInfo.setText("Cambio NO exitoso");
			}
		}
	}//class escucha cambiar libro de libreria
	
	public class EscuchaInfo implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String libreria, titulo, resp;
			libreria=ctNom.getText();
			titulo=ctTitulo.getText();
			if(titulo.equals(""))
				resp=candhi.infoLibreria(libreria);
			else
				resp=candhi.infoLibro(titulo, libreria);
			taInfo.setText(resp);
		}
	}//class escucha info
	
	public class EscuchaLibrerias implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String resp;
			resp=candhi.librerias();
			taInfo.setText(resp);
		}
	}//class escucha librerias
	
	//Lectura inicial
	public void lecturaInicial() {
		File archivo;
		Scanner lectura;
		int n, m, i, j, anio, pag, ejem;
		String titulo, autor, editorial, nombre, dir, gerente;
		boolean resp;
		archivo=new File("DatosLibreria.txt");
		try {
			lectura=new Scanner(archivo);
			n=lectura.nextInt();
			for(i=0; i<n; i++) {
				nombre=lectura.next();
				dir=lectura.next();
				gerente=lectura.next();
				resp=candhi.altaLibreria(nombre, dir, gerente);
				if(!resp)
					taInfo.setText(taInfo.getText()+"Alta no exitosa Libreria \n");
				else 
					taInfo.setText(taInfo.getText()+"Alta exitosa Libreria \n");
				m=lectura.nextInt();
				for(j=0; j<m;j++) {
					titulo=lectura.next();
					autor=lectura.next();
					anio=lectura.nextInt();
					pag=lectura.nextInt();
					editorial=lectura.next();
					ejem=lectura.nextInt();
					resp=candhi.altaLibro(titulo, autor, anio, pag, editorial, ejem, nombre);
					if(!resp)
						taInfo.setText(taInfo.getText()+"Alta no exitosa libro \n");
					else
						taInfo.setText(taInfo.getText()+"Alta exitosa libro \n");
				}
			}
			taInfo.setText(taInfo.getText()+"\n"+candhi.toString());
		}//try
		catch (FileNotFoundException e) {
			e.printStackTrace();
			taInfo.setText(e.toString());
		}//catch
	}//lectuira inicial
	
	//Constructor
	public ControladorAsoLib() {
		super();
		candhi=new AsoLib("Candhi");
		btAltaLibreria.addActionListener(new EscuchaAltaLibreria());
		btBajaLibreria.addActionListener(new EscuchaBajaLibreria());
		btAltaLibro.addActionListener(new EscuchaAltaLibro());
		btBajaLibro.addActionListener(new EscuchaBajaLibro());
		btVenta.addActionListener(new EscuchaRegistrarVenta());
		btCuantos.addActionListener(new EscuchaCuantos());
		btDonde.addActionListener(new EscuchaDonde());
		btAgregarEjem.addActionListener(new EscuchaAgregarEjemplares());
		btTitulosPorAutor.addActionListener(new EscuchaTitulosPorAutor());
		btCambiarLibreria.addActionListener(new EscuchaCambiarLib());
		btInfo.addActionListener(new EscuchaInfo());
		btLibrerias.addActionListener(new EscuchaLibrerias());
		lecturaInicial();
	}

}//class
