package Clases;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.ScrollPane;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorChooserUI;
import javax.swing.text.DefaultCaret;

import jxl.write.Border;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;


public class PantallaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabel = null;
	private JButton jButtonExaminar = null;
	private JTextField jTextFieldRuta = null;
	private JButton jButtonProcesar = null;
	private JLabel jLabelVisor = null;
	private JScrollPane jScrollPane = null;
	private JTextArea jTextAreaLog = null;
	private JProgressBar jProgressBar = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JProgressBar jProgressBarBase = null;
	private JLabel jLabel3 = null;
	private JProgressBar jProgressBarDatos = null;
	private JLabel jLabel4 = null;
	private JButton jButtonOrigen = null;
	private JTextField jTextFieldRutaOrigen = null;
	private JLabel jLabel41 = null;
	private JButton jButtonDestino = null;
	private JTextField jTextFieldRutaDestino = null;
	private JLabel jLabel411 = null;
	private JLabel jLabel412 = null;
	private JLabel jLabel4121 = null;
	private JLabel jLabel4122 = null;
	private JCheckBox jCheckBoxAmbos = null;
	private JCheckBox jCheckBoxConcesionario = null;
	private JCheckBox jCheckBoxSucursal = null;
	private JLabel LogTXT = null;
	/**
	 * This is the default constructor
	 */
	public PantallaPrincipal() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(1242, 529);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/F_DE_FURLONG.png")));
		
		this.setContentPane(getJContentPane());
		this.setTitle("Filtrador de documentación (con cruce de conformados).                                                                                                                                                                                  V 2.2");
		//this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Camiones.jpg")));
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
		
			LogTXT = new JLabel();
			LogTXT.setBounds(new Rectangle(13, 166, 106, 16));
			LogTXT.setText("");
			LogTXT.setForeground(Color.white);
			jLabel4122 = new JLabel();
			jLabel4122.setBounds(new Rectangle(168, 131, 105, 19));
			jLabel4122.setText("AMBOS");
			jLabel4122.setForeground(Color.white);
			jLabel4121 = new JLabel();
			jLabel4121.setBounds(new Rectangle(168, 193, 105, 19));
			jLabel4121.setText("SUCURSAL");
			jLabel4121.setForeground(Color.white);
			jLabel412 = new JLabel();
			jLabel412.setBounds(new Rectangle(168, 162, 105, 19));
			jLabel412.setText("CONCESIONARIO");
			jLabel412.setForeground(Color.white);
			jLabel411 = new JLabel();
			jLabel411.setBounds(new Rectangle(12, 135, 112, 16));
			jLabel411.setText("Seleccione FILTRO");
			jLabel411.setForeground(Color.white);
			jLabel41 = new JLabel();
			jLabel41.setBounds(new Rectangle(11, 100, 221, 17));
			jLabel41.setText("Seleccione Carpeta de DESTINO");
			jLabel41.setForeground(Color.white);
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(11, 55, 229, 19));
			jLabel4.setText("Seleccione Carpeta de ORIGEN");
			jLabel4.setForeground(Color.white);
			jContentPane = new FondoPpal();
			jContentPane.setLayout(null);
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(10, 358, 235, 18));
			jLabel3.setText("Progreso de copia de datos");
			jLabel3.setForeground(Color.white);
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(10, 293, 235, 19));
			jLabel2.setText("Progreso de busqueda en base de datos");
			jLabel2.setForeground(Color.white);
			jLabel1 = new JLabel();
			jLabel1.setForeground(Color.white);
			jLabel1.setBounds(new Rectangle(10, 227, 191, 20));
			jLabel1.setText("Progreso de archivo leido");
			jLabelVisor = new JLabel();
			jLabelVisor.setForeground(Color.white);
			jLabelVisor.setBounds(new Rectangle(446, 122, 137, 26));
			jLabelVisor.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
			jLabelVisor.setIcon(new ImageIcon(getClass().getResource("/iconos/Info.png")));
			jLabelVisor.setText("Visor de sucesos");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(11, 13, 244, 16));
			jLabel.setText("Seleccione archivo VIAJECONF.TXT a leer");
			jLabel.setForeground(Color.white);
			
			
			
			
			
			jContentPane.add(jLabel, null);
			jContentPane.add(getJButtonExaminar(), null);
			jContentPane.add(getJTextFieldRuta(), null);
			jContentPane.add(getJButtonProcesar(), null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getJProgressBar(), null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(getJProgressBarBase(), null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(getJProgressBarDatos(), null);
			jContentPane.add(jLabelVisor, null);
			jContentPane.add(jLabel4, null);
			jContentPane.add(getJButtonOrigen(), null);
			jContentPane.add(getJTextFieldRutaOrigen(), null);
			jContentPane.add(jLabel41, null);
			jContentPane.add(getJButtonDestino(), null);
			jContentPane.add(getJTextFieldRutaDestino(), null);
			jContentPane.add(jLabel411, null);
			jContentPane.add(jLabel412, null);
			jContentPane.add(jLabel4121, null);
			jContentPane.add(jLabel4122, null);
			jContentPane.add(getJCheckBoxAmbos(), null);
			jContentPane.add(getJCheckBoxConcesionario(), null);
			jContentPane.add(getJCheckBoxSucursal(), null);
			jContentPane.add(LogTXT, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jButtonExaminar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonExaminar() {
		if (jButtonExaminar == null) {
			jButtonExaminar = new JButton();
			jButtonExaminar.setBounds(new Rectangle(262, 12, 120, 32));
			jButtonExaminar.setText("Examinar");
			jButtonExaminar.setIcon(new ImageIcon(getClass().getResource("/iconos/Search.png")));
			jButtonExaminar.setBorderPainted(true);
			LineBorder thickBorder = new LineBorder(Color.green,2);
			jButtonExaminar.setBorder(thickBorder);

			jButtonExaminar.setBackground(new Color(159));
			jButtonExaminar.setForeground(Color.white);
			jButtonExaminar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					FileChooser file=new FileChooser();
					String ruta=file.lanzarSeleccion();
					jTextFieldRuta.setText(ruta);
				}
			});
		}
		return jButtonExaminar;
	}

	/**
	 * This method initializes jTextFieldRuta	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldRuta() {
		if (jTextFieldRuta == null) {
			jTextFieldRuta = new JTextField();
			jTextFieldRuta.setBounds(new Rectangle(400, 13, 728, 20));
			jTextFieldRuta.setText("D:\\Desktop\\VIAJCONF.txt");
			LineBorder thickBorder = new LineBorder(Color.green,2);
			jTextFieldRuta.setBorder(thickBorder);
			jTextFieldRuta.setBackground(Color.white);
		}
		return jTextFieldRuta;
	}

	/**
	 * This method initializes jButtonProcesar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private ArrayList<String>dividirArchivos(String rutaOrigen,String rutaDestino,int cantMaxRegistrosAleer){
		LeerArchivo leer=new LeerArchivo();
		ArrayList<String>nuevosArchivos = null;
		ArrayList<String>auxiliar;
		auxiliar=leer.leer(rutaOrigen);//Defino la ruta de origen
		
		if(cantMaxRegistrosAleer<auxiliar.size()){//si hay que dividir hacemos division
		nuevosArchivos= new ArrayList<String>();
		EscribirArchivo escritor=new EscribirArchivo();
		System.out.println(auxiliar.size());
		List<String> nuevoArchivo;		
		String nombreArch=rutaOrigen.substring(rutaOrigen.lastIndexOf("\\"));
		nombreArch=nombreArch.replaceAll(".txt","");
		nombreArch=nombreArch.substring((nombreArch.lastIndexOf("\\")+1));
		
			System.out.println("Finishh");
			int cantMax=cantMaxRegistrosAleer;// Defino la cantidad máxima de registros soportados por la pc
			int partes=auxiliar.size()/cantMax;
		System.out.println(partes);
		System.out.println("Fin deberia ser "+auxiliar.size());
		int desde=0;
		int hasta=0;
		//String rutaDestino="D:\\Desktop\\pruebaDivide\\VIAJCONF";// Defino el destino
		for(int i=1;i<partes+1;i++){
			hasta=cantMax*i;
			System.out.println("va desde "+desde+" hasta "+hasta);
			nuevoArchivo=auxiliar.subList(desde, hasta);
			escritor.escribirLista(rutaDestino+"\\"+nombreArch+i+".txt", nuevoArchivo);//Cada archichivo de va a llamar igual pero con un nro adelante
			nuevosArchivos.add(rutaDestino+"\\"+nombreArch+i+".txt");// hasta cantMax de archivos a escribir.
			desde=hasta;
			
			if(i==partes){
				System.out.println("va desde "+desde+" hasta "+auxiliar.size());
				nuevoArchivo=auxiliar.subList(desde, auxiliar.size());
				escritor.escribirLista(rutaDestino+"\\"+nombreArch+i+".txt", nuevoArchivo);
				nuevosArchivos.add(rutaDestino+"\\"+nombreArch+i+".txt");
				return nuevosArchivos;
			}
		}
		}
		return nuevosArchivos;
	}
	private JButton getJButtonProcesar() {
		if (jButtonProcesar == null) {
			jButtonProcesar = new JButton();
			jButtonProcesar.setBounds(new Rectangle(11, 441, 231, 46));
			jButtonProcesar.setText("Procesar");
			jButtonProcesar.setBackground(new Color(159));
			jButtonProcesar.setIcon(new ImageIcon(getClass().getResource("/iconos/Modify.png")));
			jButtonProcesar.setForeground(Color.white);
			LineBorder thickBorder = new LineBorder(Color.green,2);
			jButtonProcesar.setBorder(thickBorder);
			jButtonProcesar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {	
					
					try{
						jTextAreaLog.setText("");
						
						
						String filtro=null;
						if(jCheckBoxAmbos.isSelected()){
							filtro="AMBOS";
						}else if (jCheckBoxConcesionario.isSelected()){
							filtro="CONCESIONARIO";
						}else if(jCheckBoxSucursal.isSelected()){
							filtro="SUCURSAL";
						}
						
						ArrayList<String>nuevosarchivos=dividirArchivos(jTextFieldRuta.getText(), jTextFieldRutaDestino.getText(), 500);
						
						jButtonProcesar.setEnabled(false);
						
						
						Thread tarea = null;
						
						Implementador lector = null;		
						
						if(nuevosarchivos!=null){
							
							lector=new Implementador(jTextAreaLog,jProgressBar,jProgressBarBase,jProgressBarDatos,nuevosarchivos,jTextFieldRutaOrigen.getText(),jTextFieldRutaDestino.getText(),jButtonExaminar,jButtonProcesar,filtro,LogTXT,jTextFieldRuta.getText());
							tarea=new Thread(lector);
							
							tarea.start();
						}else{
							nuevosarchivos=new ArrayList<String>();
							nuevosarchivos.add(jTextFieldRuta.getText());
							lector=new Implementador(jTextAreaLog,jProgressBar,jProgressBarBase,jProgressBarDatos,nuevosarchivos,jTextFieldRutaOrigen.getText(),jTextFieldRutaDestino.getText(),jButtonExaminar,jButtonProcesar,filtro,LogTXT,jTextFieldRuta.getText());
							tarea=new Thread(lector);
							tarea.start();
							
						}
							
							
						
							
						
						//	Runnable lector=new Implementador(jTextAreaLog,jProgressBar,jProgressBarBase,jProgressBarDatos,nuevosarchivos.get(i),jTextFieldRutaOrigen.getText(),jTextFieldRutaDestino.getText(),jButtonExaminar,jButtonProcesar,filtro);				
						
					//	new Thread(lector).start();//.start();
						
						
						
										
						}catch(Exception e1){
							JOptionPane.showMessageDialog(null,e1.getMessage()+" \n Saliendo del programa.");
							System.exit(0);
						}
				}});}
		
		return jButtonProcesar;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(442, 146, 685, 328));
			jScrollPane.setViewportView(getJTextAreaLog());
			
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTextAreaLog	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextAreaLog() {
		if (jTextAreaLog == null) {
			jTextAreaLog = new JTextArea();
			DefaultCaret caret = (DefaultCaret)jTextAreaLog.getCaret();
			caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
			LineBorder thickBorder = new LineBorder(Color.green,2);
			
			jTextAreaLog.setBorder(thickBorder);
			jTextAreaLog.setBackground(Color.white);
			jTextAreaLog.setEditable(false);
		}
		return jTextAreaLog;
	}

	/**
	 * This method initializes jProgressBar	
	 * 	
	 * @return javax.swing.JProgressBar	
	 */
	private JProgressBar getJProgressBar() {
		if (jProgressBar == null) {
			jProgressBar = new JProgressBar();
			jProgressBar.setBounds(new Rectangle(10, 258, 409, 24));
			jProgressBar.setBackground(Color.white);
			LineBorder thickBorder = new LineBorder(Color.green,2);
			jProgressBar.setForeground(Color.BLACK);
			
			jProgressBar.setBorder(thickBorder);
		}
		return jProgressBar;
	}

	/**
	 * This method initializes jProgressBarBase	
	 * 	
	 * @return javax.swing.JProgressBar	
	 */
	private JProgressBar getJProgressBarBase() {
		if (jProgressBarBase == null) {
			jProgressBarBase = new JProgressBar();
			jProgressBarBase.setBounds(new Rectangle(10, 323, 409, 24));
			jProgressBarBase.setBackground(Color.white);
			LineBorder thickBorder = new LineBorder(Color.green,2);
			jProgressBarBase.setBorder(thickBorder);
		}
		return jProgressBarBase;
	}

	/**
	 * This method initializes jProgressBarDatos	
	 * 	
	 * @return javax.swing.JProgressBar	
	 */
	private JProgressBar getJProgressBarDatos() {
		if (jProgressBarDatos == null) {
			jProgressBarDatos = new JProgressBar();
			jProgressBarDatos.setBounds(new Rectangle(10, 387, 409, 24));
			jProgressBarDatos.setBackground(Color.white);
			LineBorder thickBorder = new LineBorder(Color.green,2);
			jProgressBarDatos.setBorder(thickBorder);
		}
		return jProgressBarDatos;
	}

	/**
	 * This method initializes jButtonOrigen	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonOrigen() {
		if (jButtonOrigen == null) {
			jButtonOrigen = new JButton();
			jButtonOrigen.setBounds(new Rectangle(262, 49, 120, 31));
			jButtonOrigen.setForeground(Color.white);
			jButtonOrigen.setBorder(new LineBorder(Color.green, 2));
			jButtonOrigen.setBorderPainted(true);
			jButtonOrigen.setText("Examinar");
			jButtonOrigen.setIcon(new ImageIcon(getClass().getResource("/iconos/Search.png")));
			jButtonOrigen.setBackground(new Color(159));
			jButtonOrigen.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					FileChooser file=new FileChooser();					
					String ruta=file.lanzarSeleccionDeCarpeta();
					jTextFieldRutaOrigen.setText(ruta);
				}
			});
		}
		return jButtonOrigen;
	}

	/**
	 * This method initializes jTextFieldRutaOrigen	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldRutaOrigen() {
		if (jTextFieldRutaOrigen == null) {
			jTextFieldRutaOrigen = new JTextField();
			jTextFieldRutaOrigen.setBounds(new Rectangle(400, 55, 728, 20));
			jTextFieldRutaOrigen.setBorder(new LineBorder(Color.green, 2));
			jTextFieldRutaOrigen.setText("D:\\Desktop\\Documentos Digitalizados");
			jTextFieldRutaOrigen.setBackground(Color.white);
		}
		return jTextFieldRutaOrigen;
	}

	/**
	 * This method initializes jButtonDestino	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonDestino() {
		if (jButtonDestino == null) {
			jButtonDestino = new JButton();
			jButtonDestino.setBounds(new Rectangle(262, 85, 120, 32));
			jButtonDestino.setForeground(Color.white);
			jButtonDestino.setBorder(new LineBorder(Color.green, 2));
			jButtonDestino.setBorderPainted(true);
			jButtonDestino.setText("Examinar");
			jButtonDestino.setIcon(new ImageIcon(getClass().getResource("/iconos/Search.png")));
			jButtonDestino.setBackground(new Color(159));
			jButtonDestino.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					FileChooser file=new FileChooser();					
					String ruta=file.lanzarSeleccionDeCarpeta();
					jTextFieldRutaDestino.setText(ruta);
				}
			});
		}
		return jButtonDestino;
	}

	/**
	 * This method initializes jTextFieldRutaDestino	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldRutaDestino() {
		if (jTextFieldRutaDestino == null) {
			jTextFieldRutaDestino = new JTextField();
			jTextFieldRutaDestino.setBorder(new LineBorder(Color.green, 2));
			jTextFieldRutaDestino.setText("D:\\Desktop\\Destino de los archivos");
			jTextFieldRutaDestino.setBounds(new Rectangle(400, 97, 728, 20));
			jTextFieldRutaDestino.setBackground(Color.white);
		}
		return jTextFieldRutaDestino;
	}

	/**
	 * This method initializes jCheckBoxAmbos	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private void deshabilitarCheckBox(Boolean ambos,Boolean concesionario,Boolean sucursal){
		jCheckBoxAmbos.setSelected(ambos);
		jCheckBoxConcesionario.setSelected(concesionario);
		jCheckBoxSucursal.setSelected(sucursal);
		
	}
	private JCheckBox getJCheckBoxAmbos() {
		if (jCheckBoxAmbos == null) {
			jCheckBoxAmbos = new JCheckBox();
			jCheckBoxAmbos.setBorder(new LineBorder(Color.green, 2));
			jCheckBoxAmbos.setBorderPainted(true);
			jCheckBoxAmbos.setForeground(Color.black);
			jCheckBoxAmbos.setBackground(Color.white);
			jCheckBoxAmbos.setSelected(true);
			
			jCheckBoxAmbos.setBounds(new Rectangle(305, 135, 17, 17));
			jCheckBoxAmbos.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					deshabilitarCheckBox(true, false, false);
				}
			});
		}
		return jCheckBoxAmbos;
	}

	/**
	 * This method initializes jCheckBoxConcesionario	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxConcesionario() {
		if (jCheckBoxConcesionario == null) {
			jCheckBoxConcesionario = new JCheckBox();
			jCheckBoxConcesionario.setBounds(new Rectangle(305, 164, 17, 17));
			jCheckBoxConcesionario.setForeground(Color.black);
			jCheckBoxConcesionario.setBorder(new LineBorder(Color.green, 2));
			jCheckBoxConcesionario.setBorderPainted(true);
			jCheckBoxConcesionario.setBackground(Color.white);
			jCheckBoxConcesionario.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					deshabilitarCheckBox(false, true, false);
				}
			});
		}
		return jCheckBoxConcesionario;
	}

	/**
	 * This method initializes jCheckBoxSucursal	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxSucursal() {
		if (jCheckBoxSucursal == null) {
			jCheckBoxSucursal = new JCheckBox();
			jCheckBoxSucursal.setBounds(new Rectangle(305, 195, 17, 17));
			jCheckBoxSucursal.setForeground(Color.black);
			jCheckBoxSucursal.setBorder(new LineBorder(Color.green, 2));
			jCheckBoxSucursal.setBorderPainted(true);
			jCheckBoxSucursal.setBackground(Color.white);
			jCheckBoxSucursal.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					deshabilitarCheckBox(false,false,true);
				}
			});
		}
		return jCheckBoxSucursal;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
