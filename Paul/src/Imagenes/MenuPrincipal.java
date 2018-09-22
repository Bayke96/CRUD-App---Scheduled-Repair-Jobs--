package Imagenes;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable.PrintMode;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Date;

public class MenuPrincipal {
	
	public static String Impresora = "";

	public static void main(String[] args) {
		JFrame MenuP = new JFrame("Famain Guayana C.A - Menu");
		MenuP.setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/Imagenes/LOGO.png")));
		MenuP.getContentPane().setBackground(new Color(75, 0, 130));
		MenuP.getContentPane().setLayout(null);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("NImpresora.txt"));
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    if (line != null) {
		        MenuPrincipal.Impresora = line;
		    }
		
		    br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		panel.setBounds(0, 285, 794, 264);
		MenuP.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(75, 0, 130), new Color(75, 0, 130)));
		panel_1.setBackground(new Color(255, 250, 250));
		panel_1.setBounds(6, 6, 249, 252);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/soporte_home.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(6, 6, 237, 121);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblP1a = new JLabel("Nombre del proyecto");
		lblP1a.setHorizontalAlignment(SwingConstants.CENTER);
		lblP1a.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblP1a.setBounds(6, 154, 237, 16);
		panel_1.add(lblP1a);
		
		JLabel lblP1b = new JLabel("Fecha inicio");
		lblP1b.setHorizontalAlignment(SwingConstants.CENTER);
		lblP1b.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblP1b.setBounds(6, 182, 237, 16);
		panel_1.add(lblP1b);
		
		JLabel lblP1c = new JLabel("Fecha culminaci\u00F3n");
		lblP1c.setHorizontalAlignment(SwingConstants.CENTER);
		lblP1c.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblP1c.setBounds(6, 210, 237, 16);
		panel_1.add(lblP1c);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(75, 0, 130), new Color(75, 0, 130)));
		panel_2.setBackground(new Color(255, 250, 250));
		panel_2.setBounds(265, 6, 262, 252);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblP2a = new JLabel("Nombre del proyecto");
		lblP2a.setHorizontalAlignment(SwingConstants.CENTER);
		lblP2a.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblP2a.setBounds(6, 152, 250, 16);
		panel_2.add(lblP2a);
		
		JLabel lblP2b = new JLabel("Fecha inicio");
		lblP2b.setHorizontalAlignment(SwingConstants.CENTER);
		lblP2b.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblP2b.setBounds(6, 180, 250, 16);
		panel_2.add(lblP2b);
		
		JLabel lblP2c = new JLabel("Fecha culminaci\u00F3n");
		lblP2c.setHorizontalAlignment(SwingConstants.CENTER);
		lblP2c.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblP2c.setBounds(6, 208, 250, 16);
		panel_2.add(lblP2c);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/mantenimiento-slider.png")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(6, 6, 250, 134);
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(75, 0, 130), new Color(75, 0, 130)));
		panel_3.setBackground(new Color(255, 250, 250));
		panel_3.setBounds(539, 6, 249, 252);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblP3a = new JLabel("Nombre del proyecto");
		lblP3a.setHorizontalAlignment(SwingConstants.CENTER);
		lblP3a.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblP3a.setBounds(6, 154, 237, 16);
		panel_3.add(lblP3a);
		
		JLabel lblP3b = new JLabel("Fecha inicio");
		lblP3b.setHorizontalAlignment(SwingConstants.CENTER);
		lblP3b.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblP3b.setBounds(6, 182, 237, 16);
		panel_3.add(lblP3b);
		
		JLabel lblP3c = new JLabel("Fecha culminaci\u00F3n");
		lblP3c.setHorizontalAlignment(SwingConstants.CENTER);
		lblP3c.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblP3c.setBounds(6, 210, 237, 16);
		panel_3.add(lblP3c);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/509.png")));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(6, 6, 237, 133);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("ULTIMOS TRABAJOS");
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setBackground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 168, 782, 105);
		MenuP.getContentPane().add(lblNewLabel);
		MenuP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MenuP.setSize(800, 600);
		MenuP.setResizable(false);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		MenuP.setLocation(dim.width/2-MenuP.getSize().width/2, dim.height/2-MenuP.getSize().height/2);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(75, 0, 130));
		menuBar.setBackground(new Color(255, 250, 250));
		MenuP.setJMenuBar(menuBar);
		
		JMenu MenuInicio = new JMenu("Inicio");
		MenuInicio.setFont(new Font("SansSerif", Font.BOLD, 12));
		menuBar.add(MenuInicio);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Salir");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Acceso.IsAdmin = false;
				MenuP.dispose();
				Acceso.main(args);
			}
		});
		mntmNewMenuItem.setBackground(new Color(255, 250, 250));
		MenuInicio.add(mntmNewMenuItem);
		
		JMenu MenuAdmin = new JMenu("P-Admin");
		MenuAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MenuP.dispose();
				Usuarios.main(args);
			}
		});
		
		MenuAdmin.setVisible(false);
		MenuAdmin.setFont(new Font("SansSerif", Font.BOLD, 12));
		menuBar.add(MenuAdmin);
		
		if(Acceso.IsAdmin == true) MenuAdmin.setVisible(true);
		
		JMenu MenuTrabajos = new JMenu("Trabajos");
		MenuTrabajos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MenuP.dispose();
				Trabajos.main(args);
			}
		});
		MenuTrabajos.setFont(new Font("SansSerif", Font.BOLD, 12));
		menuBar.add(MenuTrabajos);
		
		JMenu MenuEquipos = new JMenu("Herramientas y equipos");
		MenuEquipos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuP.dispose();
				Equipos.main(args);
			}
		});
		MenuEquipos.setFont(new Font("SansSerif", Font.BOLD, 12));
		menuBar.add(MenuEquipos);
		
		JMenu MenuReportes = new JMenu("Reportes");
		MenuReportes.setFont(new Font("SansSerif", Font.BOLD, 12));
		menuBar.add(MenuReportes);
		
		JMenu mnNewMenu = new JMenu("Visualizar reportes");
		mnNewMenu.setBackground(new Color(255, 250, 250));
		MenuReportes.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Reportes de trabajos");
		mntmNewMenuItem_2.setEnabled(false);
		mntmNewMenuItem_2.setBackground(new Color(255, 250, 250));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Reportes de herramientas");
		mntmNewMenuItem_3.setEnabled(false);
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mntmNewMenuItem_3.setBackground(new Color(255, 250, 250));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Estadisticas generales");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmNewMenuItem_4.setBackground(new Color(255, 250, 250));
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenu MenuOpciones = new JMenu("Opciones");
		MenuOpciones.setFont(new Font("SansSerif", Font.BOLD, 12));
		menuBar.add(MenuOpciones);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Configurar impresora");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurarImpresora.main(args);
			}
		});
		
		Trabajo BD = new Trabajo();
		BD.Conectar("famainguayana");
		try{
			int conteo = 3;
			 DatabaseMetaData dbm = BD.conn.getMetaData();
			    ResultSet rs = dbm.getTables(null, null, "TRABAJOS", null);
			    
			    if (rs.next()) {
			    	Statement stmt = null;
				    String selectSQL = "";
			    	 selectSQL = "SELECT DISTINCT Cliente, FInicio, FCulminacion FROM trabajos group by Cliente ORDER BY NTrabajo DESC";
					  stmt = BD.conn.createStatement();
					  ResultSet ds = stmt.executeQuery(selectSQL);
					  while (ds.next()) {
					  	String Nombre = ds.getString("Cliente");
					  	String FInicio = ds.getString("FInicio");
					  	String FCulminacion = ds.getString("FCulminacion");
					  	
					  		if(conteo == 1){
						  		lblP3a.setText(Nombre);
						  		lblP3b.setText(FInicio);
						  		lblP3c.setText(FCulminacion);
						  	}
						  	if(conteo == 2){
						  		lblP2a.setText(Nombre);
						  		lblP2b.setText(FInicio);
						  		lblP2c.setText(FCulminacion);
						  	}
						  	if(conteo == 3){
						  		lblP1a.setText(Nombre);
						  		lblP1b.setText(FInicio);
						  		lblP1c.setText(FCulminacion);
						  	}
					  
					  	
					  	conteo --;
					  }
			    }
			    else{
			    	return;
			    }
			   
			
				
			    BD.Desconectar();
		}
		catch(Exception e){
				  System.err.println(e);
			  }
		
		
		
		
		
		MenuOpciones.add(mntmNewMenuItem_1);
		
		MenuP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MenuP.setVisible(true);
		
		

	}
}
