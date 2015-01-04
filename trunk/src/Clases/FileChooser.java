package Clases;

import javax.swing.JFileChooser;

import javax.swing.filechooser.FileNameExtensionFilter;



public class FileChooser {

	public String lanzarSeleccionDeCarpeta(){
		JFileChooser chooser = new JFileChooser();

		chooser.setCurrentDirectory(new java.io.File("."));

		//Titulo que llevara la ventana

		chooser.setDialogTitle("Seleccione su CARPETA");

		//Elegiremos archivos del directorio

		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//FILES_AND_DIRECTORIES);

		chooser.setAcceptAllFileFilterUsed(true);

		//chooser.addChoosableFileFilter(new FileNameExtensionFilter("Sólo documentos de Excel 2003", "XLS"));





		//Si seleccionamos algún archivo retornaremos su directorio

		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

		System.out.println("Directorio: " + chooser.getSelectedFile());
		 
		//Si no seleccionamos nada retornaremos No seleccion

		} else {

		System.out.println("No seleccion ");

		}
		return chooser.getSelectedFile().toString();

		}
public String lanzarSeleccion(){
JFileChooser chooser = new JFileChooser();

chooser.setCurrentDirectory(new java.io.File("."));

//Titulo que llevara la ventana

chooser.setDialogTitle("Seleccione su archivo DE TEXTO (VIAJECONF.txt)");

//Elegiremos archivos del directorio

chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);//FILES_AND_DIRECTORIES);

chooser.setAcceptAllFileFilterUsed(false);

chooser.addChoosableFileFilter(new FileNameExtensionFilter("Sólo Documentos de Texto", "TXT"));





//Si seleccionamos algún archivo retornaremos su directorio

if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

System.out.println("Directorio: " + chooser.getSelectedFile());
 
//Si no seleccionamos nada retornaremos No seleccion

} else {

System.out.println("No seleccion ");

}
return chooser.getSelectedFile().toString();

}

}
