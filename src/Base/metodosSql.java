package Base;



import java.awt.Choice;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
/*import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;*/

import java.util.Date;

import java.util.Locale;
import java.util.Map.Entry;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;






@SuppressWarnings("unused")
public class metodosSql extends ConexionMySql {
	
	
	
	public metodosSql() {
	}
	public  void reiniciarServicio(String servicio) throws IOException, InterruptedException{
    	Runtime runtime = Runtime.getRuntime();
        

    	
    	String[] script = {"cmd.exe", "/c", "sc", "query", servicio, "|", "find", "/C", "\"RUNNING\""};//to check whether service is running or not
    	
    	String[] script1 = {"cmd.exe", "/c", "sc", "start", servicio};//to start service

    	String[] script2 = {"cmd.exe", "/c", "sc", "stop", servicio};//to stop service
    	
    	Process process = runtime.exec(script);
    	System.out.println(process.getInputStream());
    	InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        
        if(Arrays.toString(script).equals("1")){//si está iniciado
        	Process process1 = runtime.exec(script2);//para servicio
        	Thread.sleep(3000);//espera 3 segundos
        	Process process2 = runtime.exec(script1);//inicia el servicio
        }else{
        	Process process3 = runtime.exec(script1);//inicia el servicio
        }

       

    }
	
	int conexionesFallidas=0;
	
	public String consultaSimple(String SentenciaSql, JTextArea area) throws IOException, InterruptedException {
		if(conexionesFallidas==2){
			System.out.println("Reiniciando el servicio de MYSQL");
			reiniciarServicio("MySql");
			area.append("Reiniciando el servicio de MySql\n");
			conexionesFallidas=0;
		}
		
		ResultSet res =null;
		String resultado=null;
		int estadoConexion=0;
		
		
		ConexionMySql con = new ConexionMySql();
		System.out.println(SentenciaSql);
		
		
		try {
			estadoConexion=con.conectar();
			
			if(estadoConexion==0){//Si mysql necesita más tiempo para liberar conexiones, le damos 1 segundo.
				Thread.sleep(2000);
				con.desconectar();
				conexionesFallidas++;
				area.append("Hay un problema con la base, no se puede conectar\n");
				area.append("Tratando de resolver\n");
				consultaSimple(SentenciaSql,area);
				
			}else{
			
			conexionesFallidas=0;
			con.resulsete=con.statemente.executeQuery(SentenciaSql);
			res = con.resulsete;
			
			
			
			 
	            while ( res.next()){
	            	
	               resultado=res.getString(1);
	            }
	        con.desconectar();
			}
			

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.out.println("Error en metodosSql.consultarUnaColumna"+e.getMessage());
			
		}

		return resultado;
		

	}

}
