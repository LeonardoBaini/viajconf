package Clases;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import Base.metodosSql;


public class GeneradorDeRutas {
	JProgressBar bar;
	int cantidadConsultas;
	ArrayList<String>chasis;
	ArrayList<String>rutas;
	JTextArea area;
	String rutaOrigen;
	String rutaDestino;
	
	public ArrayList<String> getRutas() {
		return rutas;
	}

	public GeneradorDeRutas(JProgressBar bar,String rutaOrigen,String rutaDestino, ArrayList<String>chasis, JTextArea area){
		this.bar=bar;
		this.chasis=chasis;
		this.area=area;
		this.rutaOrigen=rutaOrigen;
		this.rutaDestino=rutaDestino;
	}
	
	
		
	
/**
 * Entrega la ruta al archivo/s sacado del sql, pero sin la extension
 * @return
 */

	public ArrayList<String>entregarRutas(JTextArea areaLog) {
		
		ArrayList<String>rutas=new ArrayList<String>();
		rutaOrigen=rutaOrigen.replace('\\', '/');
		String sentenciaSql="select concat ('"+rutaOrigen+"/',numcaja,'/',barcode)" +
		" as 'Ruta a buscar' from flexibar.archivo where barcode=";
		
		
		
		
		metodosSql metodos=new metodosSql();
		int totalRegistros=chasis.size();
		 bar.setStringPainted(true);
		 bar.setMaximum(chasis.size()-1);		 
		 bar.setBackground(Color.white);
		 bar.setBorderPainted(true);
		 bar.setBackground(Color.white);
		 LineBorder thickBorder = new LineBorder(Color.green,2);
		 bar.setForeground(Color.BLACK);			
		 bar.setBorder(thickBorder);
		 EscribirArchivo log1=new EscribirArchivo();
		 String log;
		 String ruta=null;
		 int indiceRutas=0;
		 for(int x=0;x<totalRegistros;x++){			
			log=sentenciaSql+"'"+chasis.get(x)+"';";
			try {
				ruta=metodos.consultaSimple(log,area);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 /*try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			if(ruta!=null){
			ruta.replaceAll("/null","");
			rutas.add(ruta);
			
						
			area.append("Se buscarán los archivos en "+rutas.get(indiceRutas)+"\n");
			indiceRutas++;
			}else{
				
				 log1.escribirContinuacionUnaLinea(rutaDestino+"\\logNoOk.txt","No copiado "+chasis.get(x)+"\t porque no está en la base de datos MySql");
				 areaLog.append("Error al copiar "+chasis.get(x)+" porque no está en la base de datos MySql\n");
			
			}
			bar.setValue(x);
		 }
		

		return rutas;

		
		
		
	}
	
	

}
