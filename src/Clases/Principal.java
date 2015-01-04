package Clases;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import jxl.read.biff.BiffException;
public class Principal {


	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 * @throws BiffException 
	 */
	
	public static void main(String[] args) throws BiffException, IOException {
		
    	PantallaPrincipal pantalla=new PantallaPrincipal();
		pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PantallaPrincipal.setDefaultLookAndFeelDecorated(true);
		pantalla.setLocationRelativeTo(null);
		URL urlDeLaImagen = Principal.class.getClassLoader().getResource("Imagenes/F_DE_FURLONG.png");
		ImageIcon icon = new ImageIcon(urlDeLaImagen);
		pantalla.setIconImage(icon.getImage());
		pantalla.setExtendedState(JFrame.MAXIMIZED_BOTH);
		pantalla.setVisible(true);
		
		
		 
		
		
	 	
		
	
	
	
	}

}
