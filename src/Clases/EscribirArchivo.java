package Clases;

import java.io.*;//no olviden importar esta librería al inicio de su programa 
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class EscribirArchivo {

	public EscribirArchivo(){
		
	}

	
	 
/*
 * escribir sobre escribe el archivo dado
 */
	
	/*Para escribir a continuación hacer:
	 * try 
    {
            BufferedWriter out = new BufferedWriter(new FileWriter(RutaAlArchivo, true));
            
            out.write(linea);
            out.newLine();
            
            out.close();
    }
	 */
	 public int escribir(String RutaAlArchivo,ArrayList<String> lista ) { 		 
	int lineasTotalesEscritas=0;

		 
	 try{ 
	 
	 
	 BufferedWriter bw = new BufferedWriter(new FileWriter(RutaAlArchivo, true)); 
	
	 for(int i=0;i<lista.size();i++){
	
	 bw.write(lista.get(i));
	 bw.newLine();
	 lineasTotalesEscritas++;
	  }
	 
	 bw.close(); 


	 }catch(IOException e){
		 JOptionPane.showConfirmDialog(null,"Error "+e.getMessage());
	 };
	return lineasTotalesEscritas; 


	  } 
	 public int escribirLista(String RutaAlArchivo,List lista ) { 		 
			int lineasTotalesEscritas=0;

			 


			 
			 try{ 
			
			 
			
			 BufferedWriter bw = new BufferedWriter(new FileWriter(RutaAlArchivo, true)); 
			
			 for(int i=0;i<lista.size();i++){
			 bw.write(lista.get(i).toString());
			 bw.newLine();
			 lineasTotalesEscritas++;
			  }
			 
			 bw.close(); 


			 }catch(IOException e){
				 JOptionPane.showConfirmDialog(null,"Error "+e.getMessage());
			 };
			return lineasTotalesEscritas; 


			  } 




public void escribirUnaLinea(String RutaAlArchivo,String linea ) { 		 
	 

	

	
	 try{ 
	
	 BufferedWriter bw = new BufferedWriter(new FileWriter(RutaAlArchivo, true)); 
	 
	 bw.write(linea);
	 bw.close(); 


	 }catch(IOException e){
		 
		 JOptionPane.showConfirmDialog(null,"Error "+e.getMessage());
	 }; 

	 

	  } 

public void escribirContinuacionUnaLinea(String RutaAlArchivo,String linea ) { 		 
	 

	try 
    {
            BufferedWriter out = new BufferedWriter(new FileWriter(RutaAlArchivo, true));
            
            out.write(linea);
            out.newLine();
            
            out.close();
    } catch (IOException e) 
    {
    	JOptionPane.showMessageDialog(null, e.getMessage()+" Cerrando el programa\n");
    	System.exit(0);
    	
    } 
} 

}
