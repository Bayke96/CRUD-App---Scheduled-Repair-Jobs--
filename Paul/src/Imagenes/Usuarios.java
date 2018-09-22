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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;

import org.apache.commons.lang3.text.WordUtils;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.sun.xml.internal.ws.util.StringUtils;

import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.beans.PropertyChangeListener;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Date;
import java.beans.PropertyChangeEvent;

public class Usuarios {
	private static JTextField txtACedula;
	private static JTextField txtAContraseña;
	private static JTextField txtMContraseña;
	private static JTextField txtMCedula;
	private static JTextField txtECedula;
	private static JTextField txtBCedula;
	private static JTable table;
	private static JTextField txtANombre;
	private static JTextField txtMNombre;

	public static void main(String[] args) {
		JFrame MenuP = new JFrame("Famain Guayana C.A - Menu");
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
		tabbedPane.addTab("Agregar  ", new ImageIcon(Usuarios.class.getResource("/Imagenes/add.png")), AgregarU, "Agregue un usuario");
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
		
		txtAContraseña = new JTextField();
		txtAContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		txtAContraseña.setBounds(137, 329, 122, 28);
		panel.add(txtAContraseña);
		txtAContraseña.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setBounds(137, 301, 122, 16);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 250, 250));
		lblNewLabel_1.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtACedula = new JTextField();
		txtACedula.setHorizontalAlignment(SwingConstants.CENTER);
		txtACedula.setBounds(137, 183, 122, 28);
		panel.add(txtACedula);
		txtACedula.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("C\u00E9dula");
		lblNewLabel.setBounds(137, 155, 122, 16);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("<html><center>AGREGAR</center>NUEVO USUARIO</html>");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblNewLabel_2.setForeground(new Color(255, 250, 250));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 36, 400, 137);
		panel.add(lblNewLabel_2);
		
		JLabel Errores = new JLabel("");
		
		JButton bAceptar = new JButton("Aceptar");
		bAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String validaciones = "<html>";
				if(txtACedula.getText().trim().equalsIgnoreCase("")){
					validaciones += "* Debe insertar una cédula<br />";
				}
				if(!txtACedula.getText().matches("[0-9]+") && !txtACedula.getText().equalsIgnoreCase("")){
					validaciones += "* El campo cédula solo acepta números<br />";
				}
				if(txtANombre.getText().trim().equalsIgnoreCase("")){
					validaciones += "* Debe insertar un nombre<br />";
				}
				if(!txtANombre.getText().matches("[A-Za-z ]*")){
					validaciones += "* El campo nombre solo acepta letras<br />";
				}
				if(txtAContraseña.getText().trim().equalsIgnoreCase("")){
					validaciones += "* Debe insertar una contraseña\n</html>";
				}
				BD operacion = new BD();
				Errores.setForeground(Color.yellow);
				Errores.setText(validaciones);
				if(validaciones.equalsIgnoreCase("<html>")){
					
					try {
						if(operacion.InsertarUsuario(Integer.parseInt(txtACedula.getText()), txtANombre.getText(), txtAContraseña.getText()) != ""){
							Errores.setText(operacion.InsertarUsuario(Integer.parseInt(txtACedula.getText()), txtANombre.getText(), txtAContraseña.getText()));
							return;
						}
						operacion.InsertarUsuario(Integer.parseInt(txtACedula.getText()), txtANombre.getText(), txtAContraseña.getText());
						
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						operacion.Desconectar();
					}
					
					txtACedula.setText("");
					txtANombre.setText("");
					txtAContraseña.setText("");
					Errores.setText("Usuario agregado");
					Errores.setForeground(Color.green);
				}
				
				
				BD operaciones = new BD();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				for(int i = model.getRowCount() - 1; i >= 0; i--){
					model.removeRow(i);
				}
				Statement stmt = null;
				operaciones.Conectar("famainguayana");
				try{
					DatabaseMetaData dbm = operaciones.conn.getMetaData();
					// check if "employee" table is there
					ResultSet tables = dbm.getTables(null, null, "Usuarios", null);
					if (tables.next()) {
						
						  String selectSQL = "SELECT UsuarioID, Cedula, Nombre FROM usuarios";
						  stmt = operaciones.conn.createStatement();
						  ResultSet rs = stmt.executeQuery(selectSQL);
						  while (rs.next()) {
						  	int ID = rs.getInt("UsuarioID");
						  	int Cedula = rs.getInt("Cedula");
						  	String nombre = WordUtils.capitalizeFully(rs.getString("Nombre").toLowerCase());	
						  	selectSQL = "SELECT Cliente from Trabajos WHERE Mecanico = ?";
						  	PreparedStatement preparedStatement = operaciones.conn.prepareStatement(selectSQL);
						  	
						  		preparedStatement.setString(1, WordUtils.capitalizeFully(nombre));
						  	
							 
							  ResultSet ds = preparedStatement.executeQuery();
							  while (ds.next()) {
							  	String trabajo = ds.getString("Cliente");
							  	model.addRow(new Object[]{ID, Cedula, nombre, trabajo});
							  }
						  	
						  	
						  	
						  	
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
		
		bAceptar.setFont(new Font("SansSerif", Font.BOLD, 12));
		bAceptar.setBackground(new Color(75, 0, 130));
		bAceptar.setForeground(new Color(255, 250, 250));
		bAceptar.setBounds(99, 369, 90, 28);
		panel.add(bAceptar);
		
		JButton bBorrar = new JButton("Borrar");
		bBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtACedula.setText("");
				txtAContraseña.setText("");
				txtANombre.setText("");
				Errores.setText("");
			}
		});
		bBorrar.setFont(new Font("SansSerif", Font.BOLD, 12));
		bBorrar.setBackground(new Color(75, 0, 130));
		bBorrar.setForeground(new Color(255, 250, 250));
		bBorrar.setBounds(194, 369, 90, 28);
		panel.add(bBorrar);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(new Color(255, 250, 250));
		lblNombre.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		lblNombre.setBounds(137, 223, 122, 16);
		panel.add(lblNombre);
		
		txtANombre = new JTextField();
		txtANombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtANombre.setColumns(10);
		txtANombre.setBounds(137, 251, 122, 28);
		panel.add(txtANombre);
		
		
		Errores.setVerticalAlignment(SwingConstants.TOP);
		Errores.setForeground(Color.YELLOW);
		Errores.setFont(new Font("SansSerif", Font.BOLD, 12));
		Errores.setHorizontalAlignment(SwingConstants.CENTER);
		Errores.setBounds(6, 420, 381, 79);
		panel.add(Errores);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Usuarios.class.getResource("/Imagenes/icono-trabajadores.png")));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(418, 33, 358, 399);
		AgregarU.add(lblNewLabel_4);
		
		JPanel ModificarU = new JPanel();
		ModificarU.setBackground(new Color(255, 250, 250));
		
		tabbedPane.addTab("Modificar  ", new ImageIcon(Usuarios.class.getResource("/Imagenes/modificar.png")), ModificarU, "Modifique un usuario existente");
		ModificarU.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(75, 0, 130));
		panel_1.setBounds(0, 0, 406, 517);
		ModificarU.add(panel_1);
		
		txtMContraseña = new JTextField();
		txtMContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		txtMContraseña.setColumns(10);
		txtMContraseña.setBounds(138, 340, 122, 28);
		panel_1.add(txtMContraseña);
		
		JLabel label = new JLabel("Contrase\u00F1a");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(255, 250, 250));
		label.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		label.setBounds(138, 312, 122, 16);
		panel_1.add(label);
		
		txtMCedula = new JTextField();
		txtMCedula.setHorizontalAlignment(SwingConstants.CENTER);
		txtMCedula.setColumns(10);
		txtMCedula.setBounds(138, 194, 122, 28);
		panel_1.add(txtMCedula);
		
		JLabel label_1 = new JLabel("C\u00E9dula");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(255, 250, 250));
		label_1.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		label_1.setBounds(138, 166, 122, 16);
		panel_1.add(label_1);
		
		JLabel lblmodificarusuarioExistente = new JLabel("<html><center>MODIFICAR</center>USUARIO EXISTENTE</html>");
		lblmodificarusuarioExistente.setHorizontalAlignment(SwingConstants.CENTER);
		lblmodificarusuarioExistente.setForeground(new Color(255, 250, 250));
		lblmodificarusuarioExistente.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblmodificarusuarioExistente.setBounds(0, 0, 400, 120);
		panel_1.add(lblmodificarusuarioExistente);
		
		JLabel Errores2 = new JLabel("");
		
		JButton button = new JButton("Aceptar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String validaciones = "<html>";
				if(txtMCedula.getText().trim().equalsIgnoreCase("")){
					validaciones += "* Debe insertar una cédula<br />";
				}
				if(!txtMCedula.getText().trim().matches("[0-9]+") && !txtMCedula.getText().equalsIgnoreCase("")){
					validaciones += "* El campo cédula solo acepta números<br />";
				}
				if(txtMNombre.getText().trim().equalsIgnoreCase("")){
					validaciones += "* Debe insertar un nombre<br />";
				}
				if(!txtMNombre.getText().matches("[A-Za-z ]*")){
					validaciones += "* El campo nombre solo acepta letras<br />";
				}
				if(txtMContraseña.getText().trim().equalsIgnoreCase("")){
					validaciones += "* Debe insertar una contraseña\n</html>";
				}
				Errores2.setForeground(Color.yellow);
				Errores2.setText(validaciones);
				if(validaciones.equalsIgnoreCase("<html>")){
					BD operacion = new BD();
					try {
						
						operacion.ActualizarUsuario(Integer.parseInt(txtMCedula.getText()), txtMNombre.getText(), txtMContraseña.getText(), Integer.parseInt(txtBCedula.getText()));
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						operacion.Desconectar();
					}
					txtBCedula.setText("");
					txtMCedula.setText("");
					txtMNombre.setText("");
					txtMContraseña.setText("");
					Errores2.setText("Usuario actualizado");
					Errores2.setForeground(Color.green);
				}
			}
		});
		button.setForeground(new Color(255, 250, 250));
		button.setFont(new Font("SansSerif", Font.BOLD, 12));
		button.setBackground(new Color(75, 0, 130));
		button.setBounds(93, 380, 90, 28);
		panel_1.add(button);
		
		
		
		JButton button_1 = new JButton("Borrar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBCedula.setText("");
				txtMCedula.setText("");
				txtMNombre.setText("");
				txtMContraseña.setText("");
				Errores2.setText("");
			}
		});
		button_1.setForeground(new Color(255, 250, 250));
		button_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		button_1.setBackground(new Color(75, 0, 130));
		button_1.setBounds(195, 380, 90, 28);
		panel_1.add(button_1);
		
		JLabel lblBuscarCdula = new JLabel("Buscar c\u00E9dula");
		lblBuscarCdula.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarCdula.setForeground(new Color(255, 250, 250));
		lblBuscarCdula.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		lblBuscarCdula.setBounds(56, 132, 122, 16);
		panel_1.add(lblBuscarCdula);
		
		txtBCedula = new JTextField();
		
		
		
		
		
		txtBCedula.setHorizontalAlignment(SwingConstants.CENTER);
		txtBCedula.setBounds(204, 126, 122, 28);
		panel_1.add(txtBCedula);
		txtBCedula.setColumns(10);
		
		txtBCedula.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
				  if(!txtBCedula.getText().matches("[0-9]+")){
					  Errores2.setForeground(Color.yellow);
						Errores2.setText("* La cédula solo acepta números para buscar!");
				 }
				  else{
					  Errores2.setText("");
					  BD operacion = new BD();
					  operacion.Conectar("FamainGuayana");
					  int cedula = 0;
					  try{
						  String selectSQL = "SELECT Cedula, Nombre, Contraseña FROM usuarios WHERE Cedula = ?";
						  PreparedStatement preparedStatement = operacion.conn.prepareStatement(selectSQL);
						  preparedStatement.setInt(1, Integer.parseInt(txtBCedula.getText()));
						  ResultSet rs = preparedStatement.executeQuery();
						  while (rs.next()) {
						  	cedula = rs.getInt("Cedula");
						  	String nombre = rs.getString("Nombre").toLowerCase();	
						  	String contraseña = rs.getString("Contraseña");	
						  	txtMCedula.setText(Integer.toString(cedula));
						  	txtMNombre.setText(WordUtils.capitalizeFully(nombre));
						  	txtMContraseña.setText(contraseña);
						  	
						  	
						  	
						  }
						  cedula = 0;
						  operacion.Desconectar();
					  }
					  catch(Exception x){
						  System.err.println(x);
						  
					  }
					  

					  
				  }
			  }
			  public void removeUpdate(DocumentEvent e) {
				  if(!txtBCedula.getText().matches("[0-9]+")){
					  Errores2.setForeground(Color.yellow);
					  Errores2.setText("* La cédula solo acepta números para buscar!");
				 }
				  else{
					  Errores2.setText("");
					  BD operacion = new BD();
					  operacion.Conectar("FamainGuayana");
					  int cedula = 0;
					  try{
						  String selectSQL = "SELECT Cedula, Nombre, Contraseña FROM usuarios WHERE Cedula = ?";
						  PreparedStatement preparedStatement = operacion.conn.prepareStatement(selectSQL);
						  preparedStatement.setInt(1, Integer.parseInt(txtBCedula.getText()));
						  ResultSet rs = preparedStatement.executeQuery();
						  while (rs.next()) {
						  	cedula = rs.getInt("Cedula");
						  	String nombre = rs.getString("Nombre").toLowerCase();	
						  	String contraseña = rs.getString("Contraseña");	
						  	txtMCedula.setText(Integer.toString(cedula));
						  	txtMNombre.setText(WordUtils.capitalizeFully(nombre));
						  	txtMContraseña.setText(contraseña);
						  	
						  	
						  	
						  	
						  }
						  cedula = 0;
						  operacion.Desconectar();
					  }
					  catch(Exception x){
						  System.err.println(x);
						 
					  }
					  

					  
				  }
			  }
			  public void insertUpdate(DocumentEvent e) {
				  if(!txtBCedula.getText().matches("[0-9]+")){
					  Errores2.setForeground(Color.yellow);
					  Errores2.setText("* La cédula solo acepta números para buscar!");
				 }
				  else{
					  Errores2.setText("");
					  BD operacion = new BD();
					  operacion.Conectar("FamainGuayana");
					  int cedula = 0;
					  try{
						  String selectSQL = "SELECT Cedula, Nombre, Contraseña FROM usuarios WHERE Cedula = ?";
						  PreparedStatement preparedStatement = operacion.conn.prepareStatement(selectSQL);
						  preparedStatement.setInt(1, Integer.parseInt(txtBCedula.getText()));
						  ResultSet rs = preparedStatement.executeQuery();
						  while (rs.next()) {
						  	cedula = rs.getInt("Cedula");
						  	
						  	String nombre = rs.getString("Nombre").toLowerCase();	
						  	String contraseña = rs.getString("Contraseña");	
						  	txtMCedula.setText(Integer.toString(cedula));
						  	txtMNombre.setText(WordUtils.capitalizeFully(nombre));
						  	txtMContraseña.setText(contraseña);
						  
						  }
						  cedula = 0;
						  operacion.Desconectar();
					  }
					  catch(Exception x){
						  System.err.println(x);
						  
					  }
					  

					  
				  }
			  }
		});
		
		txtMNombre = new JTextField();
		txtMNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtMNombre.setColumns(10);
		txtMNombre.setBounds(138, 272, 122, 28);
		panel_1.add(txtMNombre);
		
		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre_1.setForeground(new Color(255, 250, 250));
		lblNombre_1.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		lblNombre_1.setBounds(138, 244, 122, 16);
		panel_1.add(lblNombre_1);
		
		
		Errores2.setVerticalAlignment(SwingConstants.TOP);
		Errores2.setHorizontalAlignment(SwingConstants.CENTER);
		Errores2.setForeground(Color.YELLOW);
		Errores2.setFont(new Font("SansSerif", Font.BOLD, 12));
		Errores2.setBounds(0, 420, 400, 79);
		panel_1.add(Errores2);
		
		JButton button_4 = new JButton("Atr\u00E1s");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuP.dispose();
				MenuPrincipal.main(args);
			}
		});
		
		button_4.setForeground(new Color(255, 250, 250));
		button_4.setFont(new Font("SansSerif", Font.BOLD, 12));
		button_4.setBackground(new Color(75, 0, 130));
		button_4.setBounds(686, 473, 90, 28);
		ModificarU.add(button_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Usuarios.class.getResource("/Imagenes/edit.png")));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(411, 6, 365, 408);
		ModificarU.add(lblNewLabel_5);
		
		JPanel EliminarU = new JPanel();
		EliminarU.setBackground(new Color(255, 250, 250));
		
		tabbedPane.addTab("Eliminar  ", new ImageIcon(Usuarios.class.getResource("/Imagenes/eliminar.png")), EliminarU, "Elimine un usuario");
		EliminarU.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(75, 0, 130));
		panel_2.setBounds(0, 0, 406, 517);
		EliminarU.add(panel_2);
		
		txtECedula = new JTextField();
		txtECedula.setHorizontalAlignment(SwingConstants.CENTER);
		txtECedula.setColumns(10);
		txtECedula.setBounds(137, 220, 122, 28);
		panel_2.add(txtECedula);
		
		JLabel label_4 = new JLabel("C\u00E9dula");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(new Color(255, 250, 250));
		label_4.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		label_4.setBounds(137, 192, 122, 16);
		panel_2.add(label_4);
		
		JLabel lbleliminarusuarioExistente = new JLabel("<html><center>ELIMINAR</center>USUARIO EXISTENTE</html>");
		lbleliminarusuarioExistente.setHorizontalAlignment(SwingConstants.CENTER);
		lbleliminarusuarioExistente.setForeground(new Color(255, 250, 250));
		lbleliminarusuarioExistente.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lbleliminarusuarioExistente.setBounds(0, 36, 400, 137);
		panel_2.add(lbleliminarusuarioExistente);
		
		JLabel Errores3 = new JLabel("");
		
		JButton button_2 = new JButton("Aceptar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String validaciones = "<html>";
				if(txtECedula.getText().trim().equalsIgnoreCase("")){
					validaciones += "* Debe insertar una cédula<br />";
				}
				if(!txtECedula.getText().trim().matches("[0-9]+") && !txtECedula.getText().equalsIgnoreCase("")){
					validaciones += "* El campo cédula solo acepta números<br />";
				}
				Errores3.setForeground(Color.yellow);
				Errores3.setText(validaciones);
				if(validaciones.equalsIgnoreCase("<html>")){
					BD OP = new BD();
					try {
						int encontrar = OP.BuscarUsuario(Integer.parseInt(txtECedula.getText()));
						if(encontrar == 0){
							Errores3.setForeground(Color.yellow);
							Errores3.setText("* No existe ningún usuario con esta cedula dentro del sistema");
							return;
						}
						if(OP.BuscarUsuario(Integer.parseInt(txtECedula.getText())) != 0){
							OP.EliminarUsuario(Integer.parseInt(txtECedula.getText()));
							txtECedula.setText("");
							Errores3.setText("Usuario eliminado");
							Errores3.setForeground(Color.WHITE);
						}
						
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						OP.Desconectar();
					}
					
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
				txtECedula.setText("");
				Errores3.setText("");
			}
		});
		button_3.setForeground(new Color(255, 250, 250));
		button_3.setFont(new Font("SansSerif", Font.BOLD, 12));
		button_3.setBackground(new Color(75, 0, 130));
		button_3.setBounds(198, 260, 90, 28);
		panel_2.add(button_3);
		
		
		Errores3.setVerticalAlignment(SwingConstants.TOP);
		Errores3.setHorizontalAlignment(SwingConstants.CENTER);
		Errores3.setForeground(Color.YELLOW);
		Errores3.setFont(new Font("SansSerif", Font.BOLD, 12));
		Errores3.setBounds(0, 300, 400, 79);
		panel_2.add(Errores3);
		
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
		lblNewLabel_6.setIcon(new ImageIcon(Usuarios.class.getResource("/Imagenes/early-termination-of-probation.png")));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(418, 0, 302, 455);
		EliminarU.add(lblNewLabel_6);
		
		JPanel VisualizarU = new JPanel();
		VisualizarU.setBackground(new Color(255, 250, 250));
		
		tabbedPane.addTab("Visualizar  ", new ImageIcon(Usuarios.class.getResource("/Imagenes/visualizar.png")), VisualizarU, "Visualizar todos los usuarios");
		VisualizarU.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(75, 0, 130));
		panel_3.setBounds(0, 0, 782, 65);
		VisualizarU.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("LISTA DE USUARIOS\r\n");
		lblNewLabel_3.setForeground(new Color(255, 250, 250));
		lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 35));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(6, 6, 770, 53);
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(25, 93, 731, 374);
		VisualizarU.add(scrollPane);
		
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
				"<html><center>ID</center></html>", "C\u00E9dula", "Nombre", "Contrato Actual"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		
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
		table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );

		for (int i = 0; i < table.getModel().getColumnCount(); i++) {
		        table.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
		}
		
		
		
		
	
		
		table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		
		table.setRowSelectionAllowed(false);
		scrollPane.setViewportView(table);
		tabbedPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{AgregarU, ModificarU, EliminarU, VisualizarU}));
		MenuP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MenuP.setSize(800, 600);
		MenuP.setResizable(false);
		
		
		BD operaciones = new BD();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Statement stmt = null;
		operaciones.Conectar("famainguayana");
		try{
			DatabaseMetaData dbm = operaciones.conn.getMetaData();
			// check if "employee" table is there
			ResultSet tables = dbm.getTables(null, null, "Usuarios", null);
			if (tables.next()) {
				String trabajo = "";
				  String selectSQL = "SELECT UsuarioID, Cedula, Nombre FROM usuarios";
				  stmt = operaciones.conn.createStatement();
				  ResultSet rs = stmt.executeQuery(selectSQL);
				  while (rs.next()) {
				  	int ID = rs.getInt("UsuarioID");
				  	int Cedula = rs.getInt("Cedula");
				  	String nombre = WordUtils.capitalizeFully(rs.getString("Nombre").toLowerCase());	
				  	selectSQL = "SELECT Cliente from Trabajos WHERE Mecanico = ?";
				  	PreparedStatement preparedStatement = operaciones.conn.prepareStatement(selectSQL);
				  	
				  		preparedStatement.setString(1, WordUtils.capitalizeFully(nombre));
				  	
					 
					  ResultSet ds = preparedStatement.executeQuery();
					  while (ds.next()) {
					  	trabajo = ds.getString("Cliente");
					  	
					  }
				  	
					  model.addRow(new Object[]{ID, Cedula, nombre, trabajo});
				  	
				  	
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
			public void mouseClicked(MouseEvent arg0) {
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
		mntmNewMenuItem_3.setBackground(new Color(255, 250, 250));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Estadisticas generales");
		mntmNewMenuItem_4.setEnabled(false);
		mntmNewMenuItem_4.setBackground(new Color(255, 250, 250));
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem ReporteUsuarios = new JMenuItem("Reportes de usuarios");
		ReporteUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.print(PrintMode.FIT_WIDTH, new MessageFormat("FAMAIN GUAYANA C.A - USUARIOS"), new MessageFormat(new Date().toString()));;
				} catch (PrinterException de) {
					// TODO Auto-generated catch block
					de.printStackTrace();
				}
			}
		});
		mnNewMenu.add(ReporteUsuarios);
		
		JMenu MenuOpciones = new JMenu("Opciones");
		MenuOpciones.setFont(new Font("SansSerif", Font.BOLD, 12));
		menuBar.add(MenuOpciones);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Configurar impresora");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConfigurarImpresora.main(args);
			}
		});
		
		MenuOpciones.add(mntmNewMenuItem_1);
		
		MenuP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MenuP.setVisible(true);
		
		

	}
}
