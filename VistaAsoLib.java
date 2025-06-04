/*
 * Irene Escudero Cazarez
 * 215698
 * 11/05/24
 * Clase para vista de ventana para la clase AsoLib
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class VistaAsoLib extends JFrame {
    protected JLabel etLibreria, etNom, etDir, etGerente, etLibro, etTitulo, etAutor, etAnio, etPag, etEditorial, etEjem, etLibDest, etAux;
    protected JTextField ctNom, ctDir, ctGerente, ctTitulo, ctAutor, ctAnio, ctPag, ctEditorial, ctEjem, ctLibDest;
    protected JButton btAltaLibreria, btBajaLibreria, btAltaLibro, btBajaLibro, btVenta, btCuantos, btDonde, btAgregarEjem, btCambiarLibreria, btInfo, btLibrerias, btTitulosPorAutor;
    protected JTextArea taInfo;
    protected JScrollPane scrollPane;
    protected Border miBorde;
    protected JPanel miPanel;
    protected Color fondo, verde, rojo, azul;

    public VistaAsoLib() {
        super("Librerias Candhi");

        // Colors
        fondo = new Color(195, 195, 195);
        verde = new Color(142, 209, 114);
        rojo = new Color(222, 78, 64);
        azul = new Color(145, 215, 243);

        //Panel con GridBagLayout
        miPanel = new JPanel(new GridBagLayout());
        miPanel.setBackground(fondo);
        miBorde = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        miPanel.setBorder(miBorde);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(2, 2, 2, 2);

        //Primer renglon
        etLibreria = new JLabel("Libreria");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        miPanel.add(etLibreria, gbc);

        //Segundo renglon
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        ctNom = new JTextField(25);
        miPanel.add(ctNom, gbc);

        gbc.gridx = 1;
        ctDir = new JTextField(25);
        miPanel.add(ctDir, gbc);

        gbc.gridx = 2;
        ctGerente = new JTextField(25);
        miPanel.add(ctGerente, gbc);
        
        gbc.gridx = 3;
        ctLibDest = new JTextField(20);
        miPanel.add(ctLibDest, gbc);

        gbc.gridx = 6;
        btAltaLibreria = new JButton("Alta");
        btAltaLibreria.setBackground(verde);
        miPanel.add(btAltaLibreria, gbc);

        gbc.gridx = 7;
        btBajaLibreria = new JButton("Baja");
        btBajaLibreria.setBackground(rojo);
        miPanel.add(btBajaLibreria, gbc);
        
        //Tercer renglon
        gbc.gridwidth = 1;
        gbc.gridy = 2;
        gbc.gridx = 0;
        etNom = new JLabel("Nombre");
        miPanel.add(etNom, gbc);

        gbc.gridx = 1;
        etDir = new JLabel("Direccion");
        miPanel.add(etDir, gbc);

        gbc.gridx = 2;
        etGerente = new JLabel("Gerente");
        miPanel.add(etGerente, gbc);
        
        gbc.gridx = 3;
        etLibDest = new JLabel("Libreria Destino");
        miPanel.add(etLibDest, gbc);

        //Cuarto renglon
        gbc.gridwidth = 1;
        etLibro = new JLabel("Libro");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        miPanel.add(etLibro, gbc);
        
        //Quinto renglon 
        gbc.gridwidth = 1;
        gbc.gridy = 4;
        ctTitulo = new JTextField(20);
        miPanel.add(ctTitulo, gbc);

        gbc.gridx = 1;
        ctAutor = new JTextField(20);
        miPanel.add(ctAutor, gbc);

        gbc.gridx = 2;
        ctAnio = new JTextField(20);
        miPanel.add(ctAnio, gbc);
        
        gbc.gridx = 3;
        ctPag = new JTextField(20);
        miPanel.add(ctPag, gbc);

        gbc.gridx = 4;
        ctEditorial = new JTextField(20);
        miPanel.add(ctEditorial, gbc);
        
        gbc.gridx = 5;
        ctEjem = new JTextField(20);
        miPanel.add(ctEjem, gbc);
        
        gbc.gridx = 6;
        btAltaLibro = new JButton("Alta");
        btAltaLibro.setBackground(verde);
        miPanel.add(btAltaLibro, gbc);

        gbc.gridx = 7;
        btBajaLibro = new JButton("Baja");
        btBajaLibro.setBackground(rojo);
        miPanel.add(btBajaLibro, gbc);
      
        //Sexto renglon
        gbc.gridwidth = 1;
        etTitulo = new JLabel("Titulo  	           	   ");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        miPanel.add(etTitulo, gbc);
        
        gbc.gridx = 1;
        etAutor = new JLabel("Autor                   	  ");
        miPanel.add(etAutor, gbc);

        gbc.gridx = 2;
        etAnio = new JLabel("Año             		          ");
        miPanel.add(etAnio, gbc);
        
        gbc.gridx = 3;
        etPag = new JLabel("Paginas          		     ");
        miPanel.add(etPag, gbc);

        gbc.gridx = 4;
        etEditorial = new JLabel("Editorial    	          	   ");
        miPanel.add(etEditorial, gbc);
        
        gbc.gridx = 5;
        etEjem = new JLabel("Ejemplares                ");
        miPanel.add(etEjem, gbc);

        //Septimo renglon
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        btVenta = new JButton("Registrar Venta");
        btVenta.setBackground(azul);
        miPanel.add(btVenta, gbc);
        
        gbc.gridx = 1;
        btCuantos = new JButton("Cuantos");
        btCuantos.setBackground(azul);
        miPanel.add(btCuantos, gbc);
        
        gbc.gridx = 2;
        btDonde = new JButton("Donde");
        btDonde.setBackground(azul);
        miPanel.add(btDonde, gbc);
        
        gbc.gridx = 3;
        btAgregarEjem = new JButton("Agregar ejemplares");
        btAgregarEjem.setBackground(azul);
        miPanel.add(btAgregarEjem, gbc);
        
        gbc.gridx = 4;
        btTitulosPorAutor = new JButton("Titulos por autor");
        btTitulosPorAutor.setBackground(azul);
        miPanel.add(btTitulosPorAutor, gbc);
        
        gbc.gridx = 5;
        btCambiarLibreria = new JButton("Cambiar libreria");
        btCambiarLibreria.setBackground(azul);
        miPanel.add(btCambiarLibreria, gbc);
        
        gbc.gridx = 6;
        btInfo = new JButton("Informacion");
        btInfo.setBackground(azul);
        miPanel.add(btInfo, gbc);
        
        gbc.gridx = 7;
        btLibrerias = new JButton("Librerias");
        btLibrerias.setBackground(azul);
        miPanel.add(btLibrerias, gbc);
        
        
        //text area
        taInfo = new JTextArea(5, 3);
        scrollPane = new JScrollPane(taInfo);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 9;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        miPanel.add(scrollPane, gbc);

        //set
        setContentPane(miPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(950, 600);
        setLocationRelativeTo(null); // Center on screen
    }//Constructor

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VistaAsoLib().setVisible(true);
        });
    }//main
}//class

