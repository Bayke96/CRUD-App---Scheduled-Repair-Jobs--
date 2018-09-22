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
import javax.swing.UIManager;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.lang3.text.WordUtils;

public class Estadisticas {
	
	public static String Impresora = "";
	private static JTable table;

	public static void main(String[] args) {
		JFrame MenuP = new JFrame("Famain Guayana C.A - Menu");
		MenuP.setIconImage(Toolkit.getDefaultToolkit().getImage(Estadisticas.class.getResource("/Imagenes/LOGO.png")));
		MenuP.getContentPane().setBackground(new Color(75, 0, 130));
		MenuP.getContentPane().setLayout(null);
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		JLabel lblNewLabel = new JLabel("FAMAIN GUAYANA C.A - ESTADISTICAS");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(new Color(75, 0, 130));
		lblNewLabel.setBackground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 794, 88);
		MenuP.getContentPane().add(lblNewLabel);
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int year = Calendar.getInstance().get(Calendar.YEAR);
					table.print(PrintMode.FIT_WIDTH, new MessageFormat("ESTADISTICAS GENERALES - FAMAIN GUAYANA C.A"), new MessageFormat("" + year));
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnImprimir.setBackground(new Color(75, 0, 130));
		btnImprimir.setForeground(Color.WHITE);
		btnImprimir.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnImprimir.setBounds(588, 330, 90, 28);
		MenuP.getContentPane().add(btnImprimir);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuP.dispose();
				MenuPrincipal.main(args);
			}
		});
		btnAtras.setBackground(new Color(75, 0, 130));
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnAtras.setBounds(684, 330, 90, 28);
		MenuP.getContentPane().add(btnAtras);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 778, 218);
		MenuP.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFocusable(false);
		table.setColumnSelectionAllowed(false);
		table.setFont(new Font("SansSerif", Font.BOLD, 12));
		table.setFillsViewportHeight(true);
		table.setGridColor(new Color(75, 0, 130));
		table.setShowVerticalLines(true);
		table.setRowMargin(1);
		table.setForeground(new Color(75, 0, 130));
		table.setBorder(null);
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mes", "Mecanico del mes"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		
		DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
		headerRenderer.setBackground(Color.WHITE);
		headerRenderer.setForeground(new Color(75, 0, 130));
		headerRenderer.setHorizontalAlignment(JLabel.CENTER);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
		
		
		 centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		 
		 table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		

		for (int i = 0; i < table.getModel().getColumnCount(); i++) {
		        table.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
		}
	
		
		table.setRowSelectionAllowed(false);
		scrollPane.setViewportView(table);
		
		JLabel lblVentasTotales = new JLabel("Proyectos totales:");
		lblVentasTotales.setForeground(new Color(255, 255, 255));
		lblVentasTotales.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblVentasTotales.setBounds(20, 330, 275, 22);
		MenuP.getContentPane().add(lblVentasTotales);
		
		JLabel lblHerramientaMasUtilizada = new JLabel("Herramienta m\u00E1s utilizada:");
		lblHerramientaMasUtilizada.setForeground(Color.WHITE);
		lblHerramientaMasUtilizada.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblHerramientaMasUtilizada.setBounds(20, 364, 275, 22);
		MenuP.getContentPane().add(lblHerramientaMasUtilizada);
		MenuP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MenuP.setSize(800, 446);
		MenuP.setResizable(false);
		
		BD operaciones = new BD();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Statement stmt = null;
		operaciones.Conectar("famainguayana");
		try{
			DatabaseMetaData dbm = operaciones.conn.getMetaData();
			// check if "employee" table is there
			ResultSet tables = dbm.getTables(null, null, "trabajos", null);
			if (tables.next()) {
				String Mecanico = "";
				String selectSQL = "";
				int conteo = 0;
				int year = Calendar.getInstance().get(Calendar.YEAR);
				for(int i = 1; i <= 12; i++){
					if(i < 10) selectSQL = "SELECT Mecanico FROM trabajos WHERE FInicio LIKE '%0" + i + "/" + year + "' GROUP BY Mecanico ORDER BY Count(Mecanico) DESC LIMIT 1";
					if(i >= 10) selectSQL = "SELECT Mecanico FROM trabajos WHERE FInicio LIKE '%" + i + "/" + year + "' GROUP BY Mecanico ORDER BY Count(Mecanico) DESC LIMIT 1";
					  stmt = operaciones.conn.createStatement();
					  ResultSet rs = stmt.executeQuery(selectSQL);
					  ResultSet ds = null;
					  while (rs.next()) {
					  	Mecanico = WordUtils.capitalizeFully(rs.getString("Mecanico").toLowerCase());	
					  	
						
						  if(i == 1) model.addRow(new Object[]{"Enero", Mecanico, conteo});
						  if(i == 2) model.addRow(new Object[]{"Febrero", Mecanico, conteo});
						  if(i == 3) model.addRow(new Object[]{"Marzo", Mecanico, conteo});
						  if(i == 4) model.addRow(new Object[]{"Abril", Mecanico, conteo});
						  if(i == 5) model.addRow(new Object[]{"Mayo", Mecanico, conteo});
						  if(i == 6) model.addRow(new Object[]{"Junio", Mecanico, conteo});
						  if(i == 7) model.addRow(new Object[]{"Julio", Mecanico, conteo});
						  if(i == 8) model.addRow(new Object[]{"Agosto", Mecanico, conteo});
						  if(i == 9) model.addRow(new Object[]{"Septiembre", Mecanico, conteo});
						  if(i == 10) model.addRow(new Object[]{"Octubre", Mecanico, conteo});
						  if(i == 11) model.addRow(new Object[]{"Noviembre", Mecanico, conteo});
						  if(i == 12) model.addRow(new Object[]{"Diciembre", Mecanico, conteo});
					  	
					  	
					  }
					 
				}
				selectSQL = "SELECT NTrabajo from trabajos ORDER BY NTrabajo DESC LIMIT 1";
				stmt = operaciones.conn.createStatement();  
				ResultSet rs = stmt.executeQuery(selectSQL);
				while(rs.next()){
					lblVentasTotales.setText("Proyectos totales: " + rs.getInt("NTrabajo"));
				}
				selectSQL = "SELECT Herramienta from TRABAJOS GROUP BY Herramienta ORDER BY Count(Herramienta) DESC LIMIT 1";
				stmt = operaciones.conn.createStatement();  
				rs = stmt.executeQuery(selectSQL);
				while(rs.next()){
					lblHerramientaMasUtilizada.setText("Herramienta más utilizada: " + rs.getString("Herramienta"));
				} 
			}
			
			  
			  
		  }
		  catch(Exception x){
			  System.err.println(x);
		  }
		finally{
			 operaciones.Desconectar();
		}
	
		
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
		
		
		
		
		
		MenuOpciones.add(mntmNewMenuItem_1);
		
		MenuP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MenuP.setVisible(true);
		
		

	}
}
