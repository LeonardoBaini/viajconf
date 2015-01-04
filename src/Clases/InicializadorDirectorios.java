package Clases;



import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
public class InicializadorDirectorios {
	
	public InicializadorDirectorios(){
		
	}
	/**
	 * // ejemplo ruta x:\\devtroce\\java
	 * @param ruta ej x:\\devtroce\\java
	 * @return true si se creo o false si no se pudo crear
	 */
	public boolean crearCarpetas(String ruta){
		File folder = new File(ruta);
		if (!folder.exists()) { 

			folder.mkdirs(); 
			return true;
		}
		else{

			return false;
		}
		

		
	}
	
	public boolean esDirectorio(String ruta){
		File folder = new File(ruta);
	
		if (folder.isDirectory()) 
		{ 
			return true;

	    }
		return false;

		}
	
	public boolean esFichero(String ruta){
		File folder = new File(ruta);	
		
		if (folder.isFile()) {
			return true;
		
	    }else{
		return false;
	    }
	}
	
	public boolean existeFichero(String ruta){
		File fichero = new File(ruta);	
		
		if (fichero.exists()) {
			return true;
		
	    }else{
		return false;
	    }
	}
	public boolean esDirectorioVacio(String ruta){
		File folder = new File(ruta);
		
		
		 File[] ficheros = folder.listFiles();		


		if (ficheros.length==0) 
		{ 
			return true;

	    }
		return false;

		}
	
	/**
	 * Da la extension de un archivo dado
	 * @param archivoSinext (ruta completa al arch sin ext)
	 * @param ruta ruta a la carpeta
	 * @return 
	 */
	public String darExtension(String archivoSinext,String ruta){
		String extension=null;
		File folder = new File(ruta);
		archivoSinext=archivoSinext.substring(archivoSinext.lastIndexOf("/")+1,archivoSinext.length()-1);
		
		 File[] ficheros = folder.listFiles();	//Lista los archivos	


		
		 for(int i=0;i<ficheros.length;i++){
			 
			 if(ficheros[i].toString().contains(archivoSinext)&&!esDirectorio(ficheros[i].toString())){
			 extension = ficheros[i].toString();
			 extension=extension.substring(extension.length()-4);//largo de la extension
			 System.out.println(extension);
			 return extension;
			 }
		 }
		return extension;
	}
	
	/**
	 * 
	 * @param Ruta completa al archivo inicio
	 * @param Ruta completa al archivo destino
	 * @throws IOException
	 */
	
	 
	public void copyFile(String sourceFile, String  destFile) throws IOException {
		
		File origen = new File(sourceFile);

		File destino = new File(destFile);
		
		InputStream in = new FileInputStream(origen);

		OutputStream out = new FileOutputStream(destino);
		
		byte[] buf = new byte[1024];

		int len;

		 

		while ((len = in.read(buf)) > 0) {

		  out.write(buf, 0, len);

		}

		in.close();

		out.close();




	}
	/**
	 * 
	 * @param archivosOrigen con ruta full
	 * @param archivosDestino carpeta
	 * @param bar
	 */
	public void copiarArchivosAruta(ArrayList<String>archivosOrigen,String carpeta,JProgressBar bar,JTextArea areaLog){
		int tamanioOrigen=archivosOrigen.size();
		bar.setMaximum(tamanioOrigen);
		 bar.setStringPainted(true);
		 bar.setBackground(Color.white);
		 bar.setBorderPainted(true);
		 bar.setBackground(Color.white);
		 LineBorder thickBorder = new LineBorder(Color.green,2);
		 bar.setForeground(Color.BLACK);			
		 bar.setBorder(thickBorder);
		 EscribirArchivo log=new EscribirArchivo();
		 areaLog.append("COMENZANDO COPIA DE DATOS...");
			
		for(int i=0;i<tamanioOrigen;i++){
			try {
				if(existeFichero(archivosOrigen.get(i))){
				//System.out.println("Comenzando copia");
				String origen=archivosOrigen.get(i);
				String destino=carpeta+archivosOrigen.get(i).substring(archivosOrigen.get(i).lastIndexOf("/"));
				copyFile(origen, destino);
				log.escribirContinuacionUnaLinea(carpeta+"\\logOk.txt","Copiado ok desde "+archivosOrigen.get(i)+" hasta "+carpeta);
				bar.setValue(i+1);
				areaLog.append("Copiando "+origen+" a "+destino+"\n");
				}else{
					log.escribirContinuacionUnaLinea(carpeta+"\\logNoOk.txt","No copiado "+archivosOrigen.get(i).substring(archivosOrigen.get(i).lastIndexOf("/")+1,archivosOrigen.get(i).lastIndexOf("."))+"\t porque el archivo no está en "+archivosOrigen.get(i).substring(0, archivosOrigen.get(i).lastIndexOf("/")));
					bar.setValue(i+1);
					areaLog.append("Error al copiar "+archivosOrigen.get(i)+"\n");
				
				}
				//System.out.println("Archivo copiado");
			} catch (IOException e) {
				
				log.escribirContinuacionUnaLinea(carpeta+"\\logNoOk.txt","No copiado "+archivosOrigen.get(i).substring(archivosOrigen.get(i).lastIndexOf("/")+1,archivosOrigen.get(i).lastIndexOf("."))+"\t porque "+e.getMessage());
				areaLog.append("Error al copiar "+archivosOrigen.get(i)+"porque "+e.getMessage()+"\n");
				System.out.println(e.getMessage());//;e.printStackTrace();
			}
		}
		
	}
	
	public String dameFechaDeHoy(){
		 SimpleDateFormat formateador = new SimpleDateFormat("yyyy'-'MM'-'dd", new Locale("es_ES"));
		 Date fechaDate = new Date();
         String fecha=formateador.format(fechaDate);
	
	return fecha;
	}
	public String dameHora(){
	Calendar calendario = new GregorianCalendar();
	int hora, minutos;
	hora =calendario.get(Calendar.HOUR_OF_DAY);
	minutos = calendario.get(Calendar.MINUTE);
	
	
	return String.valueOf(hora)+String.valueOf(minutos);
	
	}

	public boolean ficherosSonIguales(String sourceFile, String  destFile) throws IOException {
		File origen = new File(sourceFile);

		File destino = new File(destFile);
		
		if(origen.equals(destino)){
			return true;
		
		}else{
			return false;
			
		}



	}
	public boolean borrarFichero(String rutaCompletaConNombreFichero){
		
		File fichero = new File(rutaCompletaConNombreFichero);
		if (fichero.delete())

			   return true;

			else

			  return false;
		


		
	}
	public boolean abrirDirectorio(String ruta){
		
		Runtime r = Runtime.getRuntime();
		@SuppressWarnings("unused")
		Process p = null;

		try {
			p = r.exec("explorer.exe "+ruta);
			return true;
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null,"Error! "+e.getMessage());
			return false;
		}

		
	}

}
