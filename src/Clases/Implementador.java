package Clases;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;



public class Implementador implements Runnable{
	JProgressBar barCopia;
	JProgressBar bar;
	JProgressBar barQuery;
	JTextArea area;
	String ruta;
	String rutaOrigen;
	String rutaDestino;
	JButton buttonExaminar;
	JButton buttonProcesar;
	
	String filtro;
	public Implementador(JTextArea area,JProgressBar bar,JProgressBar barQuery,JProgressBar barCopia,String ruta,String rutaOrigen, String rutaDestino, JButton buttonExaminar, JButton buttonProcesar,String filtro){
		this.bar=bar;
		this.area=area;
		this.ruta=ruta;
		this.barQuery=barQuery;
		this.barCopia=barCopia;
		this.buttonExaminar=buttonExaminar;
		this.buttonProcesar=buttonProcesar;
		this.rutaOrigen=rutaOrigen;
		this.rutaDestino=rutaDestino;
		this.filtro=filtro;
	}

	public void habilitarBotones(){
		//this.buttonExaminar.setEnabled(true);
		this.buttonProcesar.setEnabled(true);
	}
	/**
	 * modif 23/03/2015 que filtre por selección inicial al buscar responsables no conf
	 * @param viajeConfTXT
	 * @param logNoOkTXT
	 * @param resBusquedaTXT
	 * @param progressBar
	 * @param progressBarBase
	 * @param textAreaLog
	 * @param resFiltro CONCESIONARIO,SUCURSAL,AMBOS
	 * @return
	 */
	private ArrayList<String> hacerBusquedaResponsableConformado(String viajeConfTXT,String logNoOkTXT,String resBusquedaTXT,JProgressBar progressBar,JProgressBar progressBarBase,JTextArea textAreaLog){
		ArrayList<String>personas=new ArrayList<String>();
		ArrayList<String>lineasViajeConf;
		ArrayList<String>lineasLogNoOk;
		EscribirArchivo escritor=new EscribirArchivo();
		
		ArrayList<String>responsables=new ArrayList<String>();
		responsables.add("Reclame los siguientes conformados a los siguientes usuarios-");
		responsables.add("-------------------------------------------------------------");
		responsables.add("CHASIS\t\t\tUSUARIO DE AS400");
		LeerArchivo lector=new LeerArchivo();
		lineasViajeConf=lector.leer(viajeConfTXT);
		lineasLogNoOk=lector.leer(logNoOkTXT);
		ArrayList<Integer>pipe=new ArrayList<Integer>();
		Map<String, String> mapaDeConformes = new HashMap<String, String>();
		String persona;
		String chasis;
		
		progressBar.setStringPainted(true);
		progressBar.setMaximum(lineasViajeConf.size()-1);
		progressBar.setAutoscrolls(true);
		progressBar.setValue(lineasViajeConf.size()-1);
		
		progressBarBase.setStringPainted(true);
		progressBarBase.setMaximum(lineasLogNoOk.size()-1);
		progressBarBase.setAutoscrolls(true);
		progressBarBase.setForeground(Color.BLACK);
		
		 
		textAreaLog.append("LEYENDO\t\t"+lineasViajeConf.size()+" registros"+"\n");
		 
		
		for(int i=0;i<lineasViajeConf.get(0).length();i++){
			
			if(lineasViajeConf.get(0).charAt(i)=='|'){//anotamos en que lineas estan los pipes
				
				pipe.add(i);
				textAreaLog.append("Buscando seperadores (PIPES), encontrado en "+i+"\n");
			}
			
		}
		int flagLeidoSeparador=0;
		textAreaLog.append("LEYENDO\t\t"+lineasViajeConf.size()+" registros"+"\n");
		 textAreaLog.append("GENERANDO INDICES\t\t\n");
		 
		for(int i=0;i<lineasViajeConf.size();i++){
			
			if(filtro.equals("AMBOS")){
				persona=lineasViajeConf.get(i).substring(pipe.get(pipe.size()-3)+1, pipe.get(pipe.size()-2));
				chasis=lineasViajeConf.get(i).substring(pipe.get(pipe.size()-2)+1, pipe.get(pipe.size()-1));
				mapaDeConformes.put(chasis, persona);
				textAreaLog.append("ASOCIANDO\t"+chasis+"\tcon\t"+persona+"\t\tS/FILTRO\n");
				
			}else if(filtro.equals("CONCESIONARIO")){
				   
				if(lineasViajeConf.get(i).substring(pipe.get(8)+1, pipe.get(9)).equals("C")){
				
				persona=lineasViajeConf.get(i).substring(pipe.get(pipe.size()-3)+1, pipe.get(pipe.size()-2));
				chasis=lineasViajeConf.get(i).substring(pipe.get(pipe.size()-2)+1, pipe.get(pipe.size()-1));
				mapaDeConformes.put(chasis, persona);
				textAreaLog.append("ASOCIANDO\t"+chasis+"\tcon\t"+persona+"\t\tCONCESIONARIO\n");
				}
				
			}else if(filtro.equals("SUCURSAL")){
				if(lineasViajeConf.get(i).substring(pipe.get(8)+1, pipe.get(9)).equals("S")){
				persona=lineasViajeConf.get(i).substring(pipe.get(pipe.size()-3)+1, pipe.get(pipe.size()-2));
				chasis=lineasViajeConf.get(i).substring(pipe.get(pipe.size()-2)+1, pipe.get(pipe.size()-1));
				mapaDeConformes.put(chasis, persona);
				textAreaLog.append("ASOCIANDO\t"+chasis+"\tcon\t"+persona+"\t\tSUCURSAL\n");
				}
			}
			//nuevo agregado para filtrar persona en func de seleccion inicial
			
			
			
			
			
			
			if(flagLeidoSeparador==0){
			//persona del 199 al 209
			textAreaLog.append("LEYENDO\t\tPersona en Pipe pos ="+(pipe.get(pipe.size()-3)+1)+" hasta PIPE pos ="+pipe.get(pipe.size()-2)+"\n");
			//chasis de 210 al 227
			textAreaLog.append("LEYENDO\t\tChasis  en Pipe pos ="+(pipe.get(pipe.size()-2)+1)+" hasta PIPE pos ="+pipe.get(pipe.size()-1)+"\n");
			}
			flagLeidoSeparador=1;
		
			/*acá está asociando chasis con persona, tomando datos de viajeconf.txt
			 * 
			 */
			
			
			
		}

		
		
		
     
			
		long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
		TInicio = System.currentTimeMillis(); //Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
		String chasisBuscar;
		 textAreaLog.append("BUSCANDO COINCIDENCIAS EN:\t\t\n");
		 String conformador;
       for( int i=0;i<lineasLogNoOk.size();i++){
    	   try{
    		  //chasisBuscar almacena un chasis sacado del lok no ok, para luego buscarlo en el hashmap
    	   chasisBuscar=lineasLogNoOk.get(i).substring(11,28).toUpperCase();
        	
        textAreaLog.append("BUSCANDO QUIÉN CONFORMÓ EN CHASIS NRO: "+chasisBuscar+"\n");
    	   }catch(Exception e){
    		   
    		   textAreaLog.append("ERROR EN LA LINEA "+i+" no lo puedo leer\n");
    		  
    		  chasisBuscar=null;
    	   }
    	   // ES EL USUARIO QUE ESTÁ EN VIAJECONF
        conformador=mapaDeConformes.get(chasisBuscar);
        if(conformador!=null){
        //escribir en resultado final
        textAreaLog.append("EL CHASIS "+chasisBuscar+" LO CONFORMÓ\t"+conformador+"\n");
        //responsables sera de donde sacara los datos para escribir informe final.
        responsables.add(chasisBuscar+"\t"+conformador);
        //ACA ESTA CARGANDO MAL ALGO, PORQUE CONFORMADOR NO CONTIENE A PERSONAS?
        if(!personas.contains(conformador)){
        	 personas.add(conformador);
		}
       
        }else{
        responsables.add(chasisBuscar+"\t"+"INEXISTENTE");
        textAreaLog.append("EL CHASIS "+chasisBuscar+" NO LO CONFORMÓ NADIE AÚN\n");
      //escribir en resultado final
       
        }
        progressBarBase.setValue(i);
       
        }//hasta acá el for
       
       int lineasTotales=0;
       textAreaLog.append("GENERANDO INFORME FINAL...\n");
       //resBusqueda txt se refiere a la ruta donde escribirá el informe y responsables el contenido
       lineasTotales=escritor.escribir(resBusquedaTXT, responsables);
       textAreaLog.append("INFORME TERMINADO!. Se escribieron "+lineasTotales+" lineas\n");
         
         
         TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
         tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
         textAreaLog.append("Tiempo de ejecución de filtrado de conformes: " + tiempo/1000+" Segundos\n");
		return personas;
         

	}

	private ArrayList<Integer> entregarUbicacionPipes(ArrayList<String> lineasViajeConf,JTextArea textAreaLog){
		ArrayList<Integer>pipe=new ArrayList<Integer>();
			for(int i=0;i<lineasViajeConf.get(0).length();i++){
			
			if(lineasViajeConf.get(0).charAt(i)=='|'){//anotamos en que lineas estan los pipes
				
				pipe.add(i);
				textAreaLog.append("Buscando seperadores (PIPES), encontrado en "+i+"\n");
			}
			
		}
			return pipe;
		
	}
	
	
	public void run() {
		
		//leer archivo
		LeerArchivo lector=new LeerArchivo();
		ArrayList<String>lineasViajeConf;
		lineasViajeConf=lector.leer(ruta);
		ArrayList<Integer>pipe=entregarUbicacionPipes(lineasViajeConf, area);
		
		String chasis=null;
		String resFiltro=null;
		 bar.setStringPainted(true);
		 bar.setMaximum(lineasViajeConf.size()-1);
		 bar.setBackground(Color.white);
		// bar.setForeground(Color.GREEN.brighter());
		 bar.setBorderPainted(true);			 
		 area.setAutoscrolls(true);
			ArrayList<String>contenido=new ArrayList<String>();
			int j=0;
			try{
			 
				
				 
				 if(filtro.equals("AMBOS")){
					 for(int i=0;i<lineasViajeConf.size();i++){   
					 j=i;										//linea 209         a    226
						chasis=lineasViajeConf.get(i).substring(pipe.get(pipe.size()-2)+1, pipe.get(pipe.size()-1));
						area.append("LEYENDO "+lineasViajeConf.get(i)+"\n");
						contenido.add(chasis) ;
					 }
					 
				 }else if(filtro.equals("CONCESIONARIO")){
					 for(int i=0;i<lineasViajeConf.size();i++){
					 j=i;	
					 resFiltro=lineasViajeConf.get(i).substring(pipe.get(8)+1, pipe.get(9));
					 if(resFiltro.equals("C")){
					 //linea 209         a    226
						chasis=lineasViajeConf.get(i).substring(pipe.get(pipe.size()-2)+1, pipe.get(pipe.size()-1));
						area.append("LEYENDO "+lineasViajeConf.get(i)+"\n");
						contenido.add(chasis) ;
					 }
					 }
					 
					 
				 }else if(filtro.equals("SUCURSAL")){
					 for(int i=0;i<lineasViajeConf.size();i++){
					 j=i;
					 resFiltro=lineasViajeConf.get(i).substring(pipe.get(8)+1, pipe.get(9));
					 if(resFiltro.equals("S")){                  //linea 209         a    226
						chasis=lineasViajeConf.get(i).substring(pipe.get(pipe.size()-2)+1, pipe.get(pipe.size()-1));
						area.append("LEYENDO "+lineasViajeConf.get(i)+"\n");
						contenido.add(chasis) ;
					 
				   }
				 }
				
				
				 }
			 
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,"Error en el archivo origen en la linea "+j+" está vacía o es más corta que la anterior, corríjala y luego reintente \n"+e.getLocalizedMessage());
				System.exit(0);
			}
			
			 
			 
			 for(int x=0;x<contenido.size();x++){
				 area.append("LEYENDO\t\t"+contenido.get(x)+"\n");
				 
				 bar.setValue(x);
				
				 
				// System.out.println(contenido.get(x));
			 }
			 bar.setValue(bar.getMaximum());
			 area.append("SE LEYERON \t\t"+contenido.size()+"FILAS");
			 
			 // Hasta acá leyo el excel
			
			 
			 rutaDestino=rutaDestino.replace('\\', '/');
			 
		GeneradorDeRutas gene=new GeneradorDeRutas(barQuery,rutaOrigen,rutaDestino, contenido,area);		
		ArrayList<String>rutasArchivos=null;
		rutasArchivos=gene.entregarRutas(area);// Obtiene las rutas del SQL de los archivos pero sin la extensión
		
		ArrayList<String>rutasCompletas=new ArrayList<String>();
		InicializadorDirectorios ini=new InicializadorDirectorios();
		
		String extension=null;
		String rutaalaCarpeta=null;
		EscribirArchivo log=new EscribirArchivo();
		int tamanioRutasArchivos=rutasArchivos.size();
		for(int i=0;i<tamanioRutasArchivos;i++){
			try{
			rutaalaCarpeta=rutasArchivos.get(i).substring(0,rutasArchivos.get(i).lastIndexOf("/"));// El directorio donde está el archivo
			
			extension=ini.darExtension(rutasArchivos.get(i), rutaalaCarpeta);// obtiene la extension del archivo
			area.append("\nOBTENIENDO LA EXTENSIÓN DE LOS ARCHIVOS....\n");
			if(extension!=null){
			rutasCompletas.add(rutasArchivos.get(i)+extension);// carga la ruta completa al archivo
			area.append("\nGENERANDO RUTAS A BUSCAR.."+i+" de "+tamanioRutasArchivos+"\n");
			}else{
				log.escribirContinuacionUnaLinea(rutaDestino+"\\logNoOk.txt","No copiado "+rutasArchivos.get(i).substring(rutasArchivos.get(i).lastIndexOf("/")+1)+"\t porque el archivo no se encuentra en "+rutaalaCarpeta);
			}
			
			}catch(Exception e){
				
				log.escribirContinuacionUnaLinea(rutaDestino+"\\logNoOk.txt","No copiado "+rutasArchivos.get(i).substring(rutasArchivos.get(i).lastIndexOf("/")+1)+"\t porque el archivo no se encuentra en "+rutaalaCarpeta);
			}
			
			}
		area.append("\nPREPARANDOSE PARA COPIAR, POR FAVOR AGUARDE...\n");
		ini.copiarArchivosAruta(rutasCompletas,rutaDestino, barCopia, area);//rutadestino no debe terminar con "/"
		if(	barCopia.getValue()==barCopia.getMaximum()){
		//JOptionPane.showMessageDialog(null,"Proceso finalizado.\nPara más detalles, vea el LOG en su Carpeta de Destino.");
		}else{
		JOptionPane.showMessageDialog(null,"Proceso finalizado con errores.\nPara más detalles, vea el LOG en su Carpeta de Destino.");	
		}
		habilitarBotones();
		try{
		ArrayList<String>persona=null;
			
			// ACA PONER FUNCION DE BÚSQUEDA FINAL
		persona=hacerBusquedaResponsableConformado(ruta, rutaDestino+"\\logNoOk.txt", rutaDestino+"\\INFORME_FINAL.txt", barQuery, barCopia, area);
		
		rutaDestino=rutaDestino.replace('/','\\');
		
		for(int i=0;i<persona.size();i++){
			//find "AMANDAT" d:\desktop\viajconf.txt  > d:\desktop\AMANDAT.txt
			
			persona.set(i,"find \""+persona.get(i).replaceAll(" ", "")+"\""+" \""+rutaDestino+"\\INFORME_FINAL.txt\" > \""+rutaDestino+"\\"+persona.get(i).replaceAll(" ", "")+".txt\"");
		}
		EscribirArchivo escritor=new EscribirArchivo();
		escritor.escribir(rutaDestino+"\\FILTRADOR.bat", persona);
		
		JOptionPane.showMessageDialog(null,"Proceso finalizado.\nPara más detalles, vea el LOG en "+rutaDestino);//su Carpeta de Destino.");
			
			ini.abrirDirectorio(rutaDestino);
		}catch(Exception e){
			
		}
		
		

		
		
	}
	}


