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
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;

import org.apache.commons.lang3.text.WordUtils;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTable.PrintMode;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;

public class Trabajos {
	private static JTextField txtNCliente;
	private static JTextField txtEProyecto;
	private static JTable table;
	private static JTextField txtHCantidad;
	private static JTextField txtHCodigo;
	private static JTable table_1;
	private static JTextField txtMecanico;
	private static JTextField txtClient;
	private static JTextField txtMechanic;
	private static JTable table_3;
	private static JTextField txtCode;
	private static JTextField txtNProyecto;
	private static JTable table_2;

	public static void main(String[] args) {
		JFrame MenuP = new JFrame("Famain Guayana C.A - Menu");
		MenuP.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Productos op = new Productos();
				op.Conectar("FamainGuayana");
				PreparedStatement preparedStatement = null;
				
				if(table_1.getModel().getRowCount() > 0){
				try{
					op.conn.setAutoCommit(false);
					String DiscountSQL = "UPDATE Equipos SET Cantidad = Cantidad + ? WHERE Nombre = ?";
					preparedStatement = op.conn.prepareStatement(DiscountSQL);
					for(int i = 0; i < table_1.getRowCount(); i++){
						preparedStatement.setInt(1, Integer.parseInt(table_1.getModel().getValueAt(i, 2).toString()));
						preparedStatement.setString(2, table_1.getModel().getValueAt(i, 1).toString().toUpperCase());
						preparedStatement.addBatch();
					}
					
					preparedStatement.executeBatch();
					op.conn.commit();
					op.Desconectar();
				}
				  catch(SQLException se){
				      se.printStackTrace();
				  }
				}
			}
			@Override
			public void windowClosed(WindowEvent e) {
				Productos op = new Productos();
				op.Conectar("FamainGuayana");
				PreparedStatement preparedStatement = null;
				
				if(table_1.getModel().getRowCount() > 0){
				try{
					op.conn.setAutoCommit(false);
					String DiscountSQL = "UPDATE Equipos SET Cantidad = Cantidad + ? WHERE Nombre = ?";
					preparedStatement = op.conn.prepareStatement(DiscountSQL);
					for(int i = 0; i < table_1.getRowCount(); i++){
						preparedStatement.setInt(1, Integer.parseInt(table_1.getModel().getValueAt(i, 2).toString()));
						preparedStatement.setString(2, table_1.getModel().getValueAt(i, 1).toString().toUpperCase());
						preparedStatement.addBatch();
					}
					
					preparedStatement.executeBatch();
					op.conn.commit();
					op.Desconectar();
				}
				  catch(SQLException se){
				      se.printStackTrace();
				  }
				}
			}
		});
		
	
	
		MenuP.getContentPane().setBackground(new Color(75, 0, 130));
		MenuP.getContentPane().setLayout(null);
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 250, 250));
		tabbedPane.setBounds(6, 6, 782, 537);
		MenuP.getContentPane().add(tabbedPane);
		
		JPanel AgregarU = new JPanel();
		AgregarU.setBackground(new Color(255, 250, 250));
		AgregarU.setToolTipText("");
		AgregarU.setName("");
		tabbedPane.addTab("Agregar  ", new ImageIcon(Trabajos.class.getResource("/Imagenes/add.png")), AgregarU, "Agregue un usuario");
		AgregarU.setLayout(null);
		
		JButton bAtras = new JButton("Atr\u00E1s");
		bAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuP.dispose();
				MenuPrincipal.main(args);
			}
		});
		bAtras.setFont(new Font("SansSerif", Font.BOLD, 12));
		bAtras.setForeground(new Color(255, 250, 250));
		bAtras.setBackground(new Color(75, 0, 130));
		bAtras.setBounds(686, 473, 90, 28);
		AgregarU.add(bAtras);
		
		JPanel panel = new JPanel();
		panel.setRequestFocusEnabled(false);
		panel.setBorder(null);
		panel.setBackground(new Color(75, 0, 130));
		panel.setBounds(0, 0, 406, 517);
		AgregarU.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha de inicio");
		lblNewLabel_1.setBounds(106, 187, 198, 16);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 250, 250));
		lblNewLabel_1.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtNCliente = new JTextField();
		txtNCliente.setHorizontalAlignment(SwingConstants.CENTER);
		txtNCliente.setBounds(106, 91, 185, 28);
		panel.add(txtNCliente);
		txtNCliente.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre del cliente");
		lblNewLabel.setBounds(106, 71, 185, 16);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("AGREGAR NUEVO TRABAJO");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2.setForeground(new Color(255, 250, 250));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 6, 400, 47);
		panel.add(lblNewLabel_2);
		
		JLabel Errores = new JLabel("");
		Errores.setVerticalAlignment(SwingConstants.TOP);
		JDateChooser dateInicio = new JDateChooser();
		JDateChooser dateCulminacion = new JDateChooser();
		
		JButton bAceptar = new JButton("Aceptar");
		
		bAceptar.setFont(new Font("SansSerif", Font.BOLD, 12));
		bAceptar.setBackground(new Color(75, 0, 130));
		bAceptar.setForeground(new Color(255, 250, 250));
		bAceptar.setBounds(106, 409, 90, 28);
		panel.add(bAceptar);
		
		
		
		JButton bBorrar = new JButton("Borrar");
		bBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNCliente.setText("");
				txtHCodigo.setText("");
				txtHCantidad.setText("");
				txtMecanico.setText("");
				
				((JTextField)dateInicio.getDateEditor().getUiComponent()).setText("");
				((JTextField)dateCulminacion.getDateEditor().getUiComponent()).setText("");
				
				Errores.setText("");
				
				
				
				
				Productos op = new Productos();
				op.Conectar("FamainGuayana");
				PreparedStatement preparedStatement = null;
				
				if(table_1.getModel().getRowCount() > 0){
				try{
					op.conn.setAutoCommit(false);
					String DiscountSQL = "UPDATE Equipos SET Cantidad = Cantidad + ? WHERE Nombre = ?";
					preparedStatement = op.conn.prepareStatement(DiscountSQL);
					for(int i = 0; i < table_1.getRowCount(); i++){
						preparedStatement.setInt(1, Integer.parseInt(table_1.getModel().getValueAt(i, 2).toString()));
						preparedStatement.setString(2, table_1.getModel().getValueAt(i, 1).toString().toUpperCase());
						preparedStatement.addBatch();
					}
					
					preparedStatement.executeBatch();
					op.conn.commit();
					op.Desconectar();
				}
				  catch(SQLException se){
				      se.printStackTrace();
				  }
				}
				
				
				BD operaciones = new BD();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				Statement stmt = null;
				operaciones.Conectar("famainguayana");
				try{
					DefaultTableModel dm = (DefaultTableModel) table.getModel();
					DefaultTableModel dm2 = (DefaultTableModel) table_1.getModel();
					int rowCount = dm.getRowCount();
					int rowCount2 = dm2.getRowCount();
					//Remove rows one by one from the end of the table
					for (int i = rowCount - 1; i >= 0; i--) {
					    dm.removeRow(i);
					}
					for (int i = rowCount2 - 1; i >= 0; i--) {
					    dm2.removeRow(i);
					}
					DatabaseMetaData dbm = operaciones.conn.getMetaData();
					// check if "employee" table is there
					ResultSet tables = dbm.getTables(null, null, "Equipos", null);
					if (tables.next()) {
						
						  String selectSQL = "SELECT ProductoID, Nombre, Cantidad FROM Equipos";
						  stmt = operaciones.conn.createStatement();
						  ResultSet rs = stmt.executeQuery(selectSQL);
						  
						  while (rs.next()) {
						  	int ID = rs.getInt("ProductoID");
						  	String Nombre = WordUtils.capitalizeFully(rs.getString("Nombre").toLowerCase());	
						  	int cantidad = rs.getInt("Cantidad");
						  	
						  	model.addRow(new Object[]{ID, Nombre, cantidad + " unidades"});
						  	
						  	
						  }
						 
					}
					
					  
					  
				  }
				  catch(Exception x){
					  System.err.println(x);
				  }
				finally{
					 operaciones.Desconectar();
				}
				
				
				
			}
		});
		bBorrar.setFont(new Font("SansSerif", Font.BOLD, 12));
		bBorrar.setBackground(new Color(75, 0, 130));
		bBorrar.setForeground(new Color(255, 250, 250));
		bBorrar.setBounds(201, 409, 90, 28);
		panel.add(bBorrar);
		
		JLabel lblNewLabel_4 = new JLabel("N\u00B0");
		lblNewLabel_4.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblNewLabel_4.setForeground(new Color(255, 250, 250));
		lblNewLabel_4.setBounds(328, 51, 72, 28);
		panel.add(lblNewLabel_4);
		
		Trabajo OP = new Trabajo();
		lblNewLabel_4.setText("N° " + Integer.toString(OP.SeleccionarTrabajo()));
		OP.Desconectar();
		
		
		dateInicio.setBounds(106, 205, 198, 28);
		panel.add(dateInicio);
		dateInicio.setMinSelectableDate(new Date());
		
		JLabel lblCulminacin = new JLabel("Fecha de culminaci\u00F3n");
		lblCulminacin.setHorizontalAlignment(SwingConstants.CENTER);
		lblCulminacin.setForeground(new Color(255, 250, 250));
		lblCulminacin.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		lblCulminacin.setBounds(106, 245, 198, 16);
		panel.add(lblCulminacin);
		
		
		dateCulminacion.setBounds(106, 273, 198, 28);
		panel.add(dateCulminacion);
		dateCulminacion.setMinSelectableDate(new Date());
		
		JLabel lblAgregarHerramienta = new JLabel("AGREGAR HERRAMIENTA");
		lblAgregarHerramienta.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarHerramienta.setForeground(new Color(255, 250, 250));
		lblAgregarHerramienta.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		lblAgregarHerramienta.setBounds(106, 313, 185, 16);
		panel.add(lblAgregarHerramienta);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCdigo.setForeground(new Color(255, 250, 250));
		lblCdigo.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		lblCdigo.setBounds(22, 343, 122, 16);
		panel.add(lblCdigo);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setForeground(new Color(255, 250, 250));
		lblCantidad.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		lblCantidad.setBounds(230, 341, 122, 16);
		panel.add(lblCantidad);
		
		txtHCantidad = new JTextField();
		txtHCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		txtHCantidad.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtHCantidad.setBounds(258, 369, 66, 28);
		panel.add(txtHCantidad);
		txtHCantidad.setColumns(10);
		
		txtHCodigo = new JTextField();
		txtHCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtHCodigo.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtHCodigo.setBounds(48, 369, 66, 28);
		panel.add(txtHCodigo);
		txtHCodigo.setColumns(10);
		
		
		Errores.setFont(new Font("SansSerif", Font.BOLD, 12));
		Errores.setForeground(new Color(255, 255, 0));
		Errores.setHorizontalAlignment(SwingConstants.CENTER);
		Errores.setBounds(0, 444, 400, 67);
		panel.add(Errores);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String validaciones = "<html>";
				Productos OP = new Productos();
				if(txtHCodigo.getText().trim().equalsIgnoreCase("")){
					validaciones += "* Debe ingresar un código de herramienta<br />";
					Errores.setForeground(Color.YELLOW);
					Errores.setText(validaciones);
					return;
				}
				if(!txtHCodigo.getText().trim().matches("[0-9]+") && !txtHCodigo.getText().trim().equalsIgnoreCase("")){
					validaciones += "* El campo código solo acepta números<br />";
					Errores.setForeground(Color.YELLOW);
					Errores.setText(validaciones);
					return;
				}
				if(Integer.parseInt(txtHCodigo.getText().trim()) < 1){
					validaciones += "* El campo código solo acepta números positivos<br />";
					Errores.setForeground(Color.YELLOW);
					Errores.setText(validaciones);
					return;
				}
				if(txtHCantidad.getText().trim().equalsIgnoreCase("")){
					validaciones += "* Debe ingresar una cantidad de herramientas<br />";
					Errores.setForeground(Color.YELLOW);
					Errores.setText(validaciones);
					return;
				}
				if(!txtHCantidad.getText().trim().matches("[0-9]+") && !txtHCantidad.getText().trim().equalsIgnoreCase("")){
					validaciones += "* El campo cantidad solo acepta números<br />";
					Errores.setForeground(Color.YELLOW);
					Errores.setText(validaciones);
					return;
				}
				if(Integer.parseInt(txtHCantidad.getText().trim()) < 1){
					validaciones += "* El campo cantidad solo acepta números positivos<br />";
					Errores.setForeground(Color.YELLOW);
					Errores.setText(validaciones);
					return;
				}
				if(OP.BuscarEquipo(txtHCodigo.getText().trim()) == null){
					validaciones += "* No existe ningún equipo con este código<br />";
					Errores.setForeground(Color.YELLOW);
					Errores.setText(validaciones);
					return;
				}
				if(OP.ValidarCantidad(Integer.parseInt(txtHCodigo.getText().trim()), Integer.parseInt(txtHCantidad.getText().trim())) == false){
					validaciones += "* Este producto no tiene tal cantidad de unidades<br />";
					Errores.setForeground(Color.YELLOW);
					Errores.setText(validaciones);
					return;
				}
				Errores.setForeground(Color.YELLOW);
				Errores.setText(validaciones);
				String nombre = OP.DescontarHerramienta(Integer.parseInt(txtHCodigo.getText().trim()), Integer.parseInt(txtHCantidad.getText().trim()));
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				model.addRow(new Object[]{txtHCodigo.getText(), WordUtils.capitalizeFully(nombre.toLowerCase()), txtHCantidad.getText()});
				
				BD operaciones = new BD();
				model = (DefaultTableModel) table.getModel();
				Statement stmt = null;
				operaciones.Conectar("famainguayana");
				try{
					DefaultTableModel dm = (DefaultTableModel) table.getModel();
					int rowCount = dm.getRowCount();
					//Remove rows one by one from the end of the table
					for (int i = rowCount - 1; i >= 0; i--) {
					    dm.removeRow(i);
					}
					DatabaseMetaData dbm = operaciones.conn.getMetaData();
					// check if "employee" table is there
					ResultSet tables = dbm.getTables(null, null, "Equipos", null);
					if (tables.next()) {
						
						  String selectSQL = "SELECT ProductoID, Nombre, Cantidad FROM Equipos";
						  stmt = operaciones.conn.createStatement();
						  ResultSet rs = stmt.executeQuery(selectSQL);
						  
						  while (rs.next()) {
						  	int ID = rs.getInt("ProductoID");
						  	String Nombre = WordUtils.capitalizeFully(rs.getString("Nombre").toLowerCase());	
						  	int cantidad = rs.getInt("Cantidad");
						  	
						  	model.addRow(new Object[]{ID, Nombre, cantidad + " unidades"});
						  	
						  	
						  }
						 
					}
					
					  
					  
				  }
				  catch(Exception x){
					  System.err.println(x);
				  }
				finally{
					 operaciones.Desconectar();
				}
				
			}
		});
		btnNewButton.setBackground(new Color(75, 0, 130));
		btnNewButton.setForeground(new Color(255, 255, 0));
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton.setBounds(146, 341, 90, 28);
		panel.add(btnNewButton);
		
		JLabel lblNombreDeMecanico = new JLabel("Nombre del mecanico");
		lblNombreDeMecanico.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDeMecanico.setForeground(new Color(255, 250, 250));
		lblNombreDeMecanico.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		lblNombreDeMecanico.setBounds(106, 131, 185, 16);
		panel.add(lblNombreDeMecanico);
		
		txtMecanico = new JTextField();
		txtMecanico.setHorizontalAlignment(SwingConstants.CENTER);
		txtMecanico.setColumns(10);
		txtMecanico.setBounds(106, 147, 185, 28);
		panel.add(txtMecanico);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(418, 62, 358, 180);
		AgregarU.add(scrollPane);
		
		table = new JTable();
		table.setFocusable(false);
		table.setColumnSelectionAllowed(false);
		table.setFont(new Font("SansSerif", Font.BOLD, 12));
		table.setFillsViewportHeight(true);
		table.setGridColor(new Color(255, 250, 250));
		table.setShowVerticalLines(true);
		table.setRowMargin(1);
		table.setForeground(new Color(255, 250, 250));
		table.setBorder(null);
		table.setBackground(new Color(75, 0, 130));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombre", "Disponibles"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		
		
		DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
		headerRenderer.setBackground(Color.WHITE);
		headerRenderer.setForeground(new Color(75, 0, 130));
		headerRenderer.setHorizontalAlignment(JLabel.CENTER);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
		 centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
		table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		

		for (int i = 0; i < table.getModel().getColumnCount(); i++) {
		        table.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
		}
		
		
		
		
	
		
		
		
		table.setRowSelectionAllowed(false);
		scrollPane.setViewportView(table);
		
		BD operaciones = new BD();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Statement stmt = null;
		operaciones.Conectar("famainguayana");
		try{
			DatabaseMetaData dbm = operaciones.conn.getMetaData();
			// check if "employee" table is there
			ResultSet tables = dbm.getTables(null, null, "Equipos", null);
			if (tables.next()) {
				
				  String selectSQL = "SELECT ProductoID, Nombre, Cantidad FROM Equipos";
				  stmt = operaciones.conn.createStatement();
				  ResultSet rs = stmt.executeQuery(selectSQL);
				  while (rs.next()) {
				  	int ID = rs.getInt("ProductoID");
				  	String Nombre = WordUtils.capitalizeFully(rs.getString("Nombre").toLowerCase());	
				  	int cantidad = rs.getInt("Cantidad");
				  	
				  	model.addRow(new Object[]{ID, Nombre, cantidad + " unidades"});
				  	
				  	
				  }
				 
			}
			
			  
			  
		  }
		  catch(Exception x){
			  System.err.println(x);
		  }
		finally{
			 operaciones.Desconectar();
		}
	
		
		
		JLabel lblherramientasdisponibles = new JLabel("HERRAMIENTAS & EQUIPOS");
		lblherramientasdisponibles.setHorizontalAlignment(SwingConstants.CENTER);
		lblherramientasdisponibles.setForeground(new Color(75, 0, 130));
		lblherramientasdisponibles.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblherramientasdisponibles.setBounds(418, 0, 358, 50);
		AgregarU.add(lblherramientasdisponibles);
		
		JLabel lblHerramientasDelProyecto = new JLabel("HERRAMIENTAS DEL PROYECTO");
		lblHerramientasDelProyecto.setHorizontalAlignment(SwingConstants.CENTER);
		lblHerramientasDelProyecto.setForeground(new Color(75, 0, 130));
		lblHerramientasDelProyecto.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblHerramientasDelProyecto.setBounds(418, 254, 358, 50);
		AgregarU.add(lblHerramientasDelProyecto);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(418, 300, 358, 168);
		AgregarU.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setRowSelectionAllowed(false);
		table_1.setFocusable(false);
		table_1.setColumnSelectionAllowed(false);
		table_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		table_1.setFillsViewportHeight(true);
		table_1.setGridColor(new Color(75, 0, 130));
		table_1.setShowVerticalLines(true);
		table_1.setRowMargin(1);
		table_1.setForeground(new Color(75, 0, 130));
		table_1.setBorder(null);
		table_1.setBackground(new Color(255, 250, 250));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nombre", "Unidades"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_1.getColumnModel().getColumn(0).setResizable(false);
		table_1.getColumnModel().getColumn(1).setResizable(false);
		table_1.getColumnModel().getColumn(2).setResizable(false);
		scrollPane_1.setViewportView(table_1);
		
		
		headerRenderer.setBackground(Color.WHITE);
		headerRenderer.setForeground(new Color(75, 0, 130));
		headerRenderer.setHorizontalAlignment(JLabel.CENTER);
		
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
		 centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
		table_1.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table_1.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table_1.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		

		for (int i = 0; i < table_1.getModel().getColumnCount(); i++) {
			table_1.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
		}
		
		JPanel ModificarU = new JPanel();
		ModificarU.setLayout(null);
		ModificarU.setToolTipText("");
		ModificarU.setName("");
		ModificarU.setBackground(new Color(255, 250, 250));
		tabbedPane.addTab("Modificar  ", new ImageIcon(Trabajos.class.getResource("/Imagenes/modificar.png")), ModificarU, null);
		
		JButton button = new JButton("Atr\u00E1s");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuP.dispose();
				MenuPrincipal.main(args);
			}
		});
		button.setForeground(new Color(255, 250, 250));
		button.setFont(new Font("SansSerif", Font.BOLD, 12));
		button.setBackground(new Color(75, 0, 130));
		button.setBounds(686, 473, 90, 28);
		ModificarU.add(button);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setRequestFocusEnabled(false);
		panel_4.setBorder(null);
		panel_4.setBackground(new Color(75, 0, 130));
		panel_4.setBounds(0, 0, 406, 517);
		ModificarU.add(panel_4);
		
		JLabel label = new JLabel("Fecha de inicio");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(255, 250, 250));
		label.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		label.setBounds(103, 216, 198, 16);
		panel_4.add(label);
		
		txtClient = new JTextField();
		txtClient.setHorizontalAlignment(SwingConstants.CENTER);
		txtClient.setColumns(10);
		txtClient.setBounds(103, 120, 185, 28);
		panel_4.add(txtClient);
		
		JLabel label_1 = new JLabel("Nombre del cliente");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(255, 250, 250));
		label_1.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		label_1.setBounds(103, 100, 185, 16);
		panel_4.add(label_1);
		
		JLabel lblModificarTrabajoExistente = new JLabel("MODIFICAR TRABAJO EXISTENTE");
		lblModificarTrabajoExistente.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarTrabajoExistente.setForeground(new Color(255, 250, 250));
		lblModificarTrabajoExistente.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblModificarTrabajoExistente.setBounds(0, 6, 400, 33);
		panel_4.add(lblModificarTrabajoExistente);
		
		JButton btnAceptar = new JButton("Aceptar");
		
		btnAceptar.setForeground(new Color(255, 250, 250));
		btnAceptar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnAceptar.setBackground(new Color(75, 0, 130));
		btnAceptar.setBounds(103, 342, 90, 28);
		panel_4.add(btnAceptar);
		
		JButton btnBorrar = new JButton("Borrar");
		
		btnBorrar.setForeground(new Color(255, 250, 250));
		btnBorrar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnBorrar.setBackground(new Color(75, 0, 130));
		btnBorrar.setBounds(198, 342, 90, 28);
		panel_4.add(btnBorrar);
		
		JDateChooser StartDate = new JDateChooser();
		StartDate.setBounds(103, 234, 198, 28);
		panel_4.add(StartDate);
		
		JLabel label_5 = new JLabel("Fecha de culminaci\u00F3n");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(new Color(255, 250, 250));
		label_5.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		label_5.setBounds(103, 274, 198, 16);
		panel_4.add(label_5);
		
		JDateChooser EndDate = new JDateChooser();
		EndDate.setBounds(103, 302, 198, 28);
		panel_4.add(EndDate);
		
		JLabel Errors = new JLabel("");
		Errors.setVerticalAlignment(SwingConstants.TOP);
		Errors.setHorizontalAlignment(SwingConstants.CENTER);
		Errors.setForeground(Color.YELLOW);
		Errors.setFont(new Font("SansSerif", Font.BOLD, 12));
		Errors.setBounds(0, 444, 400, 67);
		panel_4.add(Errors);
		
		JLabel label_10 = new JLabel("Nombre del mecanico");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setForeground(new Color(255, 250, 250));
		label_10.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		label_10.setBounds(103, 160, 185, 16);
		panel_4.add(label_10);
		
		txtMechanic = new JTextField();
		txtMechanic.setHorizontalAlignment(SwingConstants.CENTER);
		txtMechanic.setColumns(10);
		txtMechanic.setBounds(103, 176, 185, 28);
		panel_4.add(txtMechanic);
		
		JLabel lblCdigo_1 = new JLabel("Introduzca el c\u00F3digo");
		lblCdigo_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCdigo_1.setForeground(new Color(255, 250, 250));
		lblCdigo_1.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		lblCdigo_1.setBounds(36, 43, 160, 16);
		panel_4.add(lblCdigo_1);
		
		txtCode = new JTextField();
		txtCode.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtCode.setHorizontalAlignment(SwingConstants.CENTER);
		txtCode.setColumns(10);
		txtCode.setBounds(203, 37, 72, 28);
		panel_4.add(txtCode);
		
		JButton btnBuscar = new JButton("Buscar");
		
		JLabel lblHerramientasProyecto = new JLabel("HERRAMIENTAS - PROYECTO N\u00B0");
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Trabajo Operaciones = new Trabajo();
				String validaciones = "<html>";
				if(!txtCode.getText().matches("[0-9]+")){
					validaciones += "* El campo código solo acepta números";
					Errors.setForeground(Color.yellow);
					Errors.setText(validaciones);
					return;
				}
				
				try {
					if(Operaciones.BuscarTrabajo(Integer.parseInt(txtCode.getText())) == false){
						validaciones += "* No existe un proyecto con este código dentro del sistema";
						Errors.setForeground(Color.yellow);
						Errors.setText(validaciones);
						return;
					}
					if(validaciones.equalsIgnoreCase("<html>")){
						lblHerramientasProyecto.setText("HERRAMIENTAS - PROYECTO N° " + txtCode.getText());
						Operaciones.BuscarHerramientas(table_3, Integer.parseInt(txtCode.getText()));
						Errors.setText("");
						
						
						operaciones.Conectar("famainguayana");
						try{
							
							 DatabaseMetaData dbm = operaciones.conn.getMetaData();
							    ResultSet rs = dbm.getTables(null, null, "TRABAJOS", null);
							    Statement stmt = null;
							    String selectSQL = "";
							    if (rs.next()) {
							    	 selectSQL = "SELECT Cliente, Mecanico, FInicio, FCulminacion FROM Trabajos WHERE NTrabajo = ?";
									  PreparedStatement preparedStatement = operaciones.conn.prepareStatement(selectSQL);
									  preparedStatement.setInt(1, Integer.parseInt(txtCode.getText()));
									  ResultSet ds = preparedStatement.executeQuery();
									  if (ds.next()) {
									  	txtClient.setText(ds.getString("Cliente"));
									  	txtMechanic.setText(ds.getString("Mecanico"));
									  	((JTextField)StartDate.getDateEditor().getUiComponent()).setText(ds.getString("FInicio"));
									  	((JTextField)EndDate.getDateEditor().getUiComponent()).setText(ds.getString("FCulminacion"));
									  }
								  	
								  
								  	
								  	
								  }
								 
							
							
							  
							  
						  }
						  catch(Exception x){
							  System.err.println(x);
						  }
						finally{
							 operaciones.Desconectar();
						}
						
						
					}
					
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
		
		btnBuscar.setForeground(new Color(255, 250, 250));
		btnBuscar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnBuscar.setBackground(new Color(75, 0, 130));
		btnBuscar.setBounds(283, 37, 90, 28);
		panel_4.add(btnBuscar);
		

		headerRenderer.setBackground(Color.WHITE);
		headerRenderer.setForeground(new Color(75, 0, 130));
		headerRenderer.setHorizontalAlignment(JLabel.CENTER);
		
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
		 centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		

		
	
			
			  
			  
		 
		
		lblHerramientasProyecto.setHorizontalAlignment(SwingConstants.CENTER);
		lblHerramientasProyecto.setForeground(new Color(75, 0, 130));
		lblHerramientasProyecto.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblHerramientasProyecto.setBounds(418, 254, 358, 50);
		ModificarU.add(lblHerramientasProyecto);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(418, 300, 358, 168);
		ModificarU.add(scrollPane_3);
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Unidades"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_3.getColumnModel().getColumn(0).setResizable(false);
		table_3.getColumnModel().getColumn(1).setResizable(false);
		table_3.setShowVerticalLines(true);
		table_3.setRowMargin(1);
		table_3.setGridColor(new Color(75, 0, 130));
		table_3.setForeground(new Color(75, 0, 130));
		table_3.setFont(new Font("SansSerif", Font.BOLD, 12));
		table_3.setFocusable(false);
		table_3.setFillsViewportHeight(true);
		table_3.setColumnSelectionAllowed(false);
		table_3.setBorder(null);
		table_3.setBackground(new Color(255, 250, 250));
		
		
		headerRenderer.setBackground(Color.WHITE);
		headerRenderer.setForeground(new Color(75, 0, 130));
		headerRenderer.setHorizontalAlignment(JLabel.CENTER);
		
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
		 centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		

		for (int i = 0; i < table_3.getModel().getColumnCount(); i++) {
			table_3.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
		}
		
		scrollPane_3.setViewportView(table_3);
		
		JButton btnNewButton_1 = new JButton("Eliminar herramienta");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table_3.getSelectedRow() != -1){
					Trabajo BD = new Trabajo();
					try {
						BD.EliminarHerramienta(table_3, Integer.parseInt(txtCode.getText()));
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		btnNewButton_1.setBackground(new Color(75, 0, 130));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton_1.setBounds(522, 473, 152, 28);
		ModificarU.add(btnNewButton_1);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(Trabajos.class.getResource("/Imagenes/delete.png")));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(418, 6, 358, 257);
		ModificarU.add(lblNewLabel_7);
		
		JPanel EliminarU = new JPanel();
		EliminarU.setBackground(new Color(255, 250, 250));
		
		tabbedPane.addTab("Eliminar  ", new ImageIcon(Trabajos.class.getResource("/Imagenes/eliminar.png")), EliminarU, "Elimine un usuario");
		EliminarU.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(75, 0, 130));
		panel_2.setBounds(0, 0, 406, 517);
		EliminarU.add(panel_2);
		
		txtEProyecto = new JTextField();
		txtEProyecto.setHorizontalAlignment(SwingConstants.CENTER);
		txtEProyecto.setColumns(10);
		txtEProyecto.setBounds(137, 220, 122, 28);
		panel_2.add(txtEProyecto);
		
		JLabel lblNProyecto = new JLabel("N\u00B0 Proyecto");
		lblNProyecto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNProyecto.setForeground(new Color(255, 250, 250));
		lblNProyecto.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		lblNProyecto.setBounds(137, 192, 122, 16);
		panel_2.add(lblNProyecto);
		
		JLabel lbleliminarusuarioExistente = new JLabel("<html><center>ELIMINAR</center>PROYECTO EXISTENTE</html>");
		lbleliminarusuarioExistente.setHorizontalAlignment(SwingConstants.CENTER);
		lbleliminarusuarioExistente.setForeground(new Color(255, 250, 250));
		lbleliminarusuarioExistente.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lbleliminarusuarioExistente.setBounds(0, 36, 400, 137);
		panel_2.add(lbleliminarusuarioExistente);
		
		JLabel Errores2 = new JLabel("");
		
		JButton button_2 = new JButton("Aceptar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String validaciones = "<html>";
				Trabajo BD = new Trabajo();
				if(txtEProyecto.getText().trim().equalsIgnoreCase("")){
					validaciones += "* Debe introducir un número de proyecto<br />";
				}
				if(!txtEProyecto.getText().matches("[0-9]+")){
					validaciones += "* Este campo solo permite introducir números<br />";
				}
				Errores2.setText(validaciones);
				try {
					if(BD.BuscarTrabajo(Integer.parseInt(txtEProyecto.getText())) == false){
						Errores2.setForeground(Color.YELLOW);
						Errores2.setText("* No existe este N° de proyecto");
						return;
					}
					if(validaciones.equalsIgnoreCase("<html>")){
						BD.EliminarProyecto(Integer.parseInt(txtEProyecto.getText()));
						txtEProyecto.setText("");
						Errores2.setForeground(Color.WHITE);
						Errores2.setText(" Proyecto eliminado");
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		button_2.setForeground(new Color(255, 250, 250));
		button_2.setFont(new Font("SansSerif", Font.BOLD, 12));
		button_2.setBackground(new Color(75, 0, 130));
		button_2.setBounds(103, 260, 90, 28);
		panel_2.add(button_2);
		
		JButton button_3 = new JButton("Borrar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEProyecto.setText("");
			}
		});
		button_3.setForeground(new Color(255, 250, 250));
		button_3.setFont(new Font("SansSerif", Font.BOLD, 12));
		button_3.setBackground(new Color(75, 0, 130));
		button_3.setBounds(198, 260, 90, 28);
		panel_2.add(button_3);
		
		
		Errores2.setHorizontalAlignment(SwingConstants.CENTER);
		Errores2.setForeground(new Color(255, 255, 0));
		Errores2.setFont(new Font("SansSerif", Font.BOLD, 12));
		Errores2.setBounds(0, 375, 400, 81);
		panel_2.add(Errores2);
		
		JButton button_5 = new JButton("Atr\u00E1s");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuP.dispose();
				MenuPrincipal.main(args);
			}
		});
		button_5.setForeground(new Color(255, 250, 250));
		button_5.setFont(new Font("SansSerif", Font.BOLD, 12));
		button_5.setBackground(new Color(75, 0, 130));
		button_5.setBounds(686, 473, 90, 28);
		EliminarU.add(button_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Trabajos.class.getResource("/Imagenes/PIC1.png")));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(472, 6, 310, 195);
		EliminarU.add(lblNewLabel_6);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Trabajos.class.getResource("/Imagenes/img_36879-2F726121-B232-D429-CE9D9519521ECC32.png")));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(418, 239, 358, 195);
		EliminarU.add(label_2);
		
		JPanel VisualizarU = new JPanel();
		VisualizarU.setBackground(new Color(255, 250, 250));
		
		tabbedPane.addTab("Visualizar  ", new ImageIcon(Trabajos.class.getResource("/Imagenes/visualizar.png")), VisualizarU, "Visualizar todos los usuarios");
		VisualizarU.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(75, 0, 130));
		panel_3.setBounds(0, 0, 782, 65);
		VisualizarU.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("LISTA DE TRABAJOS\r\n");
		lblNewLabel_3.setForeground(new Color(255, 250, 250));
		lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 35));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(186, 6, 416, 53);
		panel_3.add(lblNewLabel_3);
		
		JButton button_6 = new JButton("Atr\u00E1s");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuP.dispose();
				MenuPrincipal.main(args);
			}
		});
		button_6.setForeground(new Color(255, 250, 250));
		button_6.setFont(new Font("SansSerif", Font.BOLD, 12));
		button_6.setBackground(new Color(75, 0, 130));
		button_6.setBounds(686, 27, 90, 28);
		panel_3.add(button_6);
		
		txtNProyecto = new JTextField();
		txtNProyecto.setForeground(new Color(255, 255, 255));
		txtNProyecto.setHorizontalAlignment(SwingConstants.CENTER);
		txtNProyecto.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtNProyecto.setBackground(new Color(75, 0, 130));
		txtNProyecto.setBounds(363, 97, 67, 28);
		VisualizarU.add(txtNProyecto);
		txtNProyecto.setColumns(10);
		
		txtNProyecto.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
				  
			    if(txtNProyecto.getText().matches("[0-9]+")){
			    	BD operacion = new BD();
			    	DefaultTableModel md = (DefaultTableModel) table_2.getModel();
			    	for (int i = md.getRowCount() - 1; i >= 0; i--) {
					    md.removeRow(i);
					}
					  operacion.Conectar("FamainGuayana");
					  int cantidad = 0;
					  try{
						  String selectSQL = "";
						  PreparedStatement preparedStatement = null;
						  
								 selectSQL = "SELECT Cliente, Mecanico, FInicio, FCulminacion, Herramienta, Cantidad FROM Trabajos WHERE NTrabajo = ?";
								 preparedStatement = operacion.conn.prepareStatement(selectSQL);
								  preparedStatement.setInt(1, Integer.parseInt(txtNProyecto.getText()));
							  
						  
						  ResultSet rs = preparedStatement.executeQuery();
						  while (rs.next()) {
						  	String cliente = rs.getString("Cliente");
						  	String mecanico = rs.getString("Mecanico");
						  	String FInicio = rs.getString("FInicio");
						  	String FCulminacion = rs.getString("FCulminacion");
						  	String Herramienta = rs.getString("Herramienta");
						  	cantidad = rs.getInt("Cantidad");
						  	md.addRow(new Object[]{cliente, mecanico, FInicio, FCulminacion, Herramienta, cantidad + " unidades"});
						  }
						  	
						  
						  cantidad = 0;
						  operacion.Desconectar();
					  }
					  catch(Exception x){
						  System.err.println(x);
					  }
			    }
			  }
			  public void removeUpdate(DocumentEvent e) {
				  if(txtNProyecto.getText().matches("[0-9]+")){
				    	BD operacion = new BD();
				    	DefaultTableModel md = (DefaultTableModel) table_2.getModel();
				    	for (int i = md.getRowCount() - 1; i >= 0; i--) {
						    md.removeRow(i);
						}
						  operacion.Conectar("FamainGuayana");
						  int cantidad = 0;
						  try{
							  String selectSQL = "";
							  PreparedStatement preparedStatement = null;
							  
									 selectSQL = "SELECT Cliente, Mecanico, FInicio, FCulminacion, Herramienta, Cantidad FROM Trabajos WHERE NTrabajo = ?";
									 preparedStatement = operacion.conn.prepareStatement(selectSQL);
									  preparedStatement.setInt(1, Integer.parseInt(txtNProyecto.getText()));
								  
							  
							  ResultSet rs = preparedStatement.executeQuery();
							  while (rs.next()) {
							  	String cliente = rs.getString("Cliente");
							  	String mecanico = rs.getString("Mecanico");
							  	String FInicio = rs.getString("FInicio");
							  	String FCulminacion = rs.getString("FCulminacion");
							  	String Herramienta = rs.getString("Herramienta");
							  	cantidad = rs.getInt("Cantidad");
							  	md.addRow(new Object[]{cliente, mecanico, FInicio, FCulminacion, Herramienta, cantidad + " unidades"});
							  }
							  	
							  
							  cantidad = 0;
							  operacion.Desconectar();
						  }
						  catch(Exception x){
							  System.err.println(x);
						  }
				  }
			  }
			  public void insertUpdate(DocumentEvent e) {
				  if(txtNProyecto.getText().matches("[0-9]+")){
				    	BD operacion = new BD();
				    	DefaultTableModel md = (DefaultTableModel) table_2.getModel();
				    	for (int i = md.getRowCount() - 1; i >= 0; i--) {
						    md.removeRow(i);
						}
						  operacion.Conectar("FamainGuayana");
						  int cantidad = 0;
						  try{
							  String selectSQL = "";
							  PreparedStatement preparedStatement = null;
							  
									 selectSQL = "SELECT Cliente, Mecanico, FInicio, FCulminacion, Herramienta, Cantidad FROM Trabajos WHERE NTrabajo = ?";
									 preparedStatement = operacion.conn.prepareStatement(selectSQL);
									  preparedStatement.setInt(1, Integer.parseInt(txtNProyecto.getText()));
								  
							  
							  ResultSet rs = preparedStatement.executeQuery();
							  while (rs.next()) {
							  	String cliente = rs.getString("Cliente");
							  	String mecanico = rs.getString("Mecanico");
							  	String FInicio = rs.getString("FInicio");
							  	String FCulminacion = rs.getString("FCulminacion");
							  	String Herramienta = rs.getString("Herramienta");
							  	cantidad = rs.getInt("Cantidad");
							  	md.addRow(new Object[]{cliente, mecanico, FInicio, FCulminacion, Herramienta, cantidad + " unidades"});
							  }
							  	
							  
							  cantidad = 0;
							  operacion.Desconectar();
						  }
						  catch(Exception x){
							  System.err.println(x);
						  }
			  }
			  }

			 
			  
			});
		
		JLabel lblNewLabel_5 = new JLabel("N\u00B0 Proyecto");
		lblNewLabel_5.setForeground(new Color(75, 0, 130));
		lblNewLabel_5.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(325, 77, 145, 16);
		VisualizarU.add(lblNewLabel_5);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(6, 137, 770, 364);
		VisualizarU.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setBackground(new Color(75, 0, 130));
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cliente", "Mecanico", "Inicio", "Culminaci\u00F3n", "Herramienta", "Cantidad"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_2.getColumnModel().getColumn(0).setResizable(false);
		table_2.getColumnModel().getColumn(1).setResizable(false);
		table_2.getColumnModel().getColumn(2).setResizable(false);
		table_2.getColumnModel().getColumn(3).setResizable(false);
		table_2.getColumnModel().getColumn(4).setResizable(false);
		table_2.getColumnModel().getColumn(5).setResizable(false);
		
		table_2.setFocusable(false);
		table_2.setColumnSelectionAllowed(false);
		table_2.setFont(new Font("SansSerif", Font.BOLD, 12));
		table_2.setFillsViewportHeight(true);
		table_2.setGridColor(new Color(255, 250, 250));
		table_2.setShowVerticalLines(true);
		table_2.setRowMargin(1);
		table_2.setForeground(new Color(255, 250, 250));
		table_2.setBorder(null);
		table_2.setBackground(new Color(75, 0, 130));

table_2.getColumnModel().getColumn(0).setResizable(false);
		table_2.getColumnModel().getColumn(1).setResizable(false);
		table_2.getColumnModel().getColumn(2).setResizable(false);
		
		
		headerRenderer = new DefaultTableCellRenderer();
		headerRenderer.setBackground(Color.WHITE);
		headerRenderer.setForeground(new Color(75, 0, 130));
		headerRenderer.setHorizontalAlignment(JLabel.CENTER);
		centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
		 centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
		table_2.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table_2.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table_2.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		table_2.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		table_2.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		table_2.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
		

		for (int i = 0; i < table_2.getModel().getColumnCount(); i++) {
		        table_2.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
		}
		
		
		
		
	
		
		
		
		table_2.setRowSelectionAllowed(false);
		
		scrollPane_2.setViewportView(table_2);
		tabbedPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{AgregarU, EliminarU, VisualizarU}));
		MenuP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MenuP.setSize(800, 600);
		MenuP.setResizable(false);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		MenuP.setLocation(dim.width/2-MenuP.getSize().width/2, dim.height/2-MenuP.getSize().height/2);
		
		JMenuBar menuBar = new JMenuBar();
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
			public void mouseClicked(MouseEvent e) {
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
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					table_2.print(PrintMode.FIT_WIDTH, new MessageFormat("FAMAIN GUAYANA C.A - TRABAJO N° " + txtNProyecto.getText()), new MessageFormat(new Date().toString()));
					
				} catch (PrinterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		mntmNewMenuItem_2.setBackground(new Color(255, 250, 250));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Reportes de herramientas");
		mntmNewMenuItem_3.setEnabled(false);
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.print(PrintMode.FIT_WIDTH, new MessageFormat("FAMAIN GUAYANA C.A - INVENTARIO"), new MessageFormat(new Date().toString()));;
				} catch (PrinterException de) {
					// TODO Auto-generated catch block
					de.printStackTrace();
				}
			}
		});
		mntmNewMenuItem_3.setBackground(new Color(255, 250, 250));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Estadisticas generales");
		mntmNewMenuItem_4.setEnabled(false);
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
		
		bAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String validaciones = "<html>";
				Trabajo OP = new Trabajo();
				if(txtNCliente.getText().trim().equalsIgnoreCase("")){
					validaciones += "* Debe escribir el nombre del cliente<br />";
				}
				if(txtMecanico.getText().trim().equalsIgnoreCase("")){
					validaciones += "* Debe escribir el nombre del mecanico<br />";
					
				}
				if(!txtMecanico.getText().trim().matches("^[ A-Za-z]+$") && !txtMecanico.getText().trim().equalsIgnoreCase("")){
					validaciones += "* El campo mecanico solo acepta letras<br />";
					Errores.setForeground(Color.YELLOW);
					Errores.setText(validaciones);
					return;
				}
				if(((JTextField)dateInicio.getDateEditor().getUiComponent()).getText().equalsIgnoreCase("")){
					validaciones += "* Debe elegir una fecha de inicio<br />";
				}
				if(((JTextField)dateCulminacion.getDateEditor().getUiComponent()).getText().equalsIgnoreCase("")){
					validaciones += "* Debe elegir una fecha de culminación<br />";
				}
				Errores.setForeground(Color.YELLOW);
				Errores.setText(validaciones);
				if(table_1.getRowCount() < 1){
					validaciones += "* El proyecto debe incluir al menos una herramienta<br />";
					Errores.setForeground(Color.YELLOW);
					Errores.setText(validaciones);
					return;
				}
				
				try {
					int Numero = Integer.parseInt(lblNewLabel_4.getText().replaceAll("\\D+",""));
					OP.CrearTrabajo(Numero, txtNCliente.getText(), txtMecanico.getText(), 
							((JTextField)dateInicio.getDateEditor().getUiComponent()).getText(), 
							((JTextField)dateCulminacion.getDateEditor().getUiComponent()).getText(), 
							table_1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				lblNewLabel_4.setText("N° " + Integer.toString(OP.SeleccionarTrabajo()));
				txtNCliente.setText("");
				txtHCodigo.setText("");
				txtHCantidad.setText("");
				txtMecanico.setText("");
				
				
				((JTextField)dateInicio.getDateEditor().getUiComponent()).setText("");
				((JTextField)dateCulminacion.getDateEditor().getUiComponent()).setText("");
				
				Errores.setForeground(Color.GREEN);
				Errores.setText("Proyecto agregado");
				
				
				
				
				
				
				
				BD operaciones = new BD();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				Statement stmt = null;
				operaciones.Conectar("famainguayana");
				try{
					DefaultTableModel dm = (DefaultTableModel) table.getModel();
					DefaultTableModel dm2 = (DefaultTableModel) table_1.getModel();
					int rowCount = dm.getRowCount();
					int rowCount2 = dm2.getRowCount();
					//Remove rows one by one from the end of the table
					for (int i = rowCount - 1; i >= 0; i--) {
					    dm.removeRow(i);
					}
					for (int i = rowCount2 - 1; i >= 0; i--) {
					    dm2.removeRow(i);
					}
					DatabaseMetaData dbm = operaciones.conn.getMetaData();
					// check if "employee" table is there
					ResultSet tables = dbm.getTables(null, null, "Equipos", null);
					if (tables.next()) {
						
						  String selectSQL = "SELECT ProductoID, Nombre, Cantidad FROM Equipos";
						  stmt = operaciones.conn.createStatement();
						  ResultSet rs = stmt.executeQuery(selectSQL);
						  
						  while (rs.next()) {
						  	int ID = rs.getInt("ProductoID");
						  	String Nombre = WordUtils.capitalizeFully(rs.getString("Nombre").toLowerCase());	
						  	int cantidad = rs.getInt("Cantidad");
						  	
						  	model.addRow(new Object[]{ID, Nombre, cantidad + " unidades"});
						  	
						  	
						  }
						 
					}
					
					  
					  
				  }
				  catch(Exception x){
					  System.err.println(x);
				  }
				finally{
					 operaciones.Desconectar();
					 
				}
				
				
			}
		});
		
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				Errors.setText("");
				txtCode.setText("");
				txtClient.setText("");
				txtMechanic.setText("");
				((JTextField)StartDate.getDateEditor().getUiComponent()).setText("");
				((JTextField)EndDate.getDateEditor().getUiComponent()).setText("");
				
				lblHerramientasProyecto.setText("HERRAMIENTAS - PROYECTO N°");
				
				
				Productos op = new Productos();
				op.Conectar("FamainGuayana");
				PreparedStatement preparedStatement = null;
				
				
				
				
				
			}
		});
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String validaciones = "<html>";
				Trabajo OP = new Trabajo();
				if(txtCode.getText().trim().equalsIgnoreCase("")){
					validaciones += "* Debe escribir el código del proyecto<br />";
					
				}
				if(!txtCode.getText().matches("[0-9]+")){
					validaciones += "* El campo código solo acepta números<br />";
					
				}
				if(txtClient.getText().trim().equalsIgnoreCase("")){
					validaciones += "* Debe escribir el nombre del cliente<br />";
				}
				if(txtMechanic.getText().trim().equalsIgnoreCase("")){
					validaciones += "* Debe escribir el nombre del mecanico<br />";
					
				}
				if(!txtMechanic.getText().trim().matches("^[ A-Za-z]+$") && !txtMecanico.getText().trim().equalsIgnoreCase("")){
					validaciones += "* El campo mecanico solo acepta letras<br />";
					Errors.setForeground(Color.YELLOW);
					Errors.setText(validaciones);
					return;
				}
				if(((JTextField)StartDate.getDateEditor().getUiComponent()).getText().equalsIgnoreCase("")){
					validaciones += "* Debe elegir una fecha de inicio<br />";
				}
				if(((JTextField)EndDate.getDateEditor().getUiComponent()).getText().equalsIgnoreCase("")){
					validaciones += "* Debe elegir una fecha de culminación<br />";
				}
				Errors.setForeground(Color.YELLOW);
				Errors.setText(validaciones);
				if(table_3.getRowCount() < 1){
					validaciones += "* El proyecto debe incluir al menos una herramienta<br />";
					Errors.setForeground(Color.YELLOW);
					Errors.setText(validaciones);
					return;
				}
				if(validaciones.equalsIgnoreCase("<html>")){
					try {
						OP.ActualizarTrabajo(Integer.parseInt(txtCode.getText()), txtClient.getText(), txtMechanic.getText(), 
								((JTextField)StartDate.getDateEditor().getUiComponent()).getText(), 
								((JTextField)EndDate.getDateEditor().getUiComponent()).getText(), table_3);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				
					Errors.setText("");
					txtCode.setText("");
					txtClient.setText("");
					txtMechanic.setText("");
					((JTextField)StartDate.getDateEditor().getUiComponent()).setText("");
					((JTextField)EndDate.getDateEditor().getUiComponent()).setText("");
					
					Errors.setForeground(Color.green);
					Errors.setText("Trabajo actualizado");
					
					
					lblHerramientasProyecto.setText("HERRAMIENTAS - PROYECTO N°");
					
					
					DefaultTableModel dm2 = (DefaultTableModel) table_3.getModel();
					
					int rowCount2 = dm2.getRowCount();
					//Remove rows one by one from the end of the table
					for (int i = rowCount2 - 1; i >= 0; i--) {
					    dm2.removeRow(i);
					}
					
				}
				
				
				
				
			}
		});
		
		MenuOpciones.add(mntmNewMenuItem_1);
		
		MenuP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MenuP.setVisible(true);
		
		

	}
}
