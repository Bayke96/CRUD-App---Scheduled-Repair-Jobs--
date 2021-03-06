package Imagenes;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

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
import java.util.HashMap;
import java.util.Map;
import java.beans.PropertyChangeEvent;

public class Equipos {
	private static JTextField txtENombre;
	private static JTextField txtECantidad;
	private static JTextField txtMCantidad;
	private static JTextField txtMNombre;
	private static JTextField txtXCodigo;
	private static JTextField txtBProducto;
	private static JTable table;
	private static JTextField txtEMarca;
	private static JTextField txtMMarca;

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
		tabbedPane.addTab("Agregar  ", new ImageIcon(Equipos.class.getResource("/Imagenes/add.png")), AgregarU, "Agregue un usuario");
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
		
		txtECantidad = new JTextField();
		txtECantidad.setHorizontalAlignment(SwingConstants.CENTER);
		txtECantidad.setBounds(137, 310, 122, 28);
		panel.add(txtECantidad);
		txtECantidad.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad");
		lblNewLabel_1.setBounds(137, 282, 122, 16);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 250, 250));
		lblNewLabel_1.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtENombre = new JTextField();
		txtENombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtENombre.setBounds(137, 164, 122, 28);
		panel.add(txtENombre);
		txtENombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(137, 136, 122, 16);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("<html><center>AGREGAR</center>NUEVO EQUIPO</html>");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblNewLabel_2.setForeground(new Color(255, 250, 250));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 6, 400, 118);
		panel.add(lblNewLabel_2);
		
		JLabel Errores = new JLabel("");
		
		JButton bAceptar = new JButton("Aceptar");
		bAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String validaciones = "<html>";
				if(txtENombre.getText().trim().equalsIgnoreCase("")){
					validaciones += "* Debe insertar un nombre<br />";
				}
				
				if(txtEMarca.getText().trim().equalsIgnoreCase("")){
					validaciones += "* Debe insertar una marca<br />";
				}
				if(txtECantidad.getText().trim().equalsIgnoreCase("")){
					validaciones += "* Debe insertar una cantidad\n</html>";
					
				}
				if(!txtECantidad.getText().equalsIgnoreCase("") && !txtECantidad.getText().matches("-?[1-9]\\d*|0")){
					validaciones += "* El campo cantidad solo acepta n�meros<br />";
					Errores.setForeground(Color.yellow);
					Errores.setText(validaciones);
					return;
				}
				if(!txtECantidad.getText().trim().equalsIgnoreCase("") && Integer.parseInt(txtECantidad.getText()) < 1){
					validaciones += "* La cantidad debe ser mayor a 0\n</html>";
					
				}
				Errores.setForeground(Color.yellow);
				Errores.setText(validaciones);
				Productos AddOp = new Productos();
				if(validaciones.equalsIgnoreCase("<html>")){
					
					try {
						if(AddOp.InsertarEquipo(txtENombre.getText(), txtEMarca.getText(), Integer.parseInt(txtECantidad.getText())) != null){
							Errores.setText("* Este producto ya existe dentro del sistema");
							return;
						}
						AddOp.InsertarEquipo(txtENombre.getText(), txtEMarca.getText(), Integer.parseInt(txtECantidad.getText()));
						
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						AddOp.Desconectar();
					}
					
					txtENombre.setText("");
					txtEMarca.setText("");
					txtECantidad.setText("");
					Errores.setText("Producto agregado");
					Errores.setForeground(Color.green);
				}
					
				
				
			}
		});
		
		bAceptar.setFont(new Font("SansSerif", Font.BOLD, 12));
		bAceptar.setBackground(new Color(75, 0, 130));
		bAceptar.setForeground(new Color(255, 250, 250));
		bAceptar.setBounds(100, 350, 90, 28);
		panel.add(bAceptar);
		
		JButton bBorrar = new JButton("Borrar");
		bBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtENombre.setText("");
				txtECantidad.setText("");
				txtEMarca.setText("");
				Errores.setText("");
			}
		});
		bBorrar.setFont(new Font("SansSerif", Font.BOLD, 12));
		bBorrar.setBackground(new Color(75, 0, 130));
		bBorrar.setForeground(new Color(255, 250, 250));
		bBorrar.setBounds(195, 350, 90, 28);
		panel.add(bBorrar);
		
		JLabel lblNombre = new JLabel("Marca");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(new Color(255, 250, 250));
		lblNombre.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		lblNombre.setBounds(137, 204, 122, 16);
		panel.add(lblNombre);
		
		txtEMarca = new JTextField();
		txtEMarca.setHorizontalAlignment(SwingConstants.CENTER);
		txtEMarca.setColumns(10);
		txtEMarca.setBounds(137, 232, 122, 28);
		panel.add(txtEMarca);
		
		
		Errores.setVerticalAlignment(SwingConstants.TOP);
		Errores.setForeground(Color.YELLOW);
		Errores.setFont(new Font("SansSerif", Font.BOLD, 12));
		Errores.setHorizontalAlignment(SwingConstants.CENTER);
		Errores.setBounds(6, 420, 381, 79);
		panel.add(Errores);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Equipos.class.getResource("/Imagenes/Toolbox.png")));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(418, 33, 358, 399);
		AgregarU.add(lblNewLabel_4);
		
		JPanel ModificarU = new JPanel();
		ModificarU.setBackground(new Color(255, 250, 250));
		
		tabbedPane.addTab("Modificar  ", new ImageIcon(Equipos.class.getResource("/Imagenes/modificar.png")), ModificarU, "Modifique un usuario existente");
		ModificarU.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(75, 0, 130));
		panel_1.setBounds(0, 0, 406, 517);
		ModificarU.add(panel_1);
		
		txtMCantidad = new JTextField();
		txtMCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		txtMCantidad.setColumns(10);
		txtMCantidad.setBounds(138, 340, 122, 28);
		panel_1.add(txtMCantidad);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setForeground(new Color(255, 250, 250));
		lblCantidad.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		lblCantidad.setBounds(138, 312, 122, 16);
		panel_1.add(lblCantidad);
		
		txtMNombre = new JTextField();
		txtMNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtMNombre.setColumns(10);
		txtMNombre.setBounds(138, 194, 122, 28);
		panel_1.add(txtMNombre);
		
		JLabel lblNuevoNombre = new JLabel("Nombre");
		lblNuevoNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoNombre.setForeground(new Color(255, 250, 250));
		lblNuevoNombre.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		lblNuevoNombre.setBounds(138, 166, 122, 16);
		panel_1.add(lblNuevoNombre);
		
		JLabel lblmodificarusuarioExistente = new JLabel("<html><center>MODIFICAR</center>EQUIPO EXISTENTE</html>");
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
				if(txtMNombre.getText().trim().equalsIgnoreCase("")){
					validaciones += "* Debe insertar un nombre<br />";
				}
				if(txtMMarca.getText().trim().equalsIgnoreCase("")){
					validaciones += "* Debe insertar una marca<br />";
				}
				if(txtMCantidad.getText().trim().equalsIgnoreCase("")){
					validaciones += "* Debe insertar una cantidad\n</html>";
					
				}
				if(!txtMCantidad.getText().equalsIgnoreCase("") && !txtMCantidad.getText().matches("-?[1-9]\\d*|0")){
					validaciones += "* El campo cantidad solo acepta n�meros<br />";
					Errores.setForeground(Color.yellow);
					Errores.setText(validaciones);
					return;
				}
				if(!txtMCantidad.getText().trim().equalsIgnoreCase("") && Integer.parseInt(txtMCantidad.getText()) < 1){
					validaciones += "* La cantidad debe ser mayor a 0\n</html>";
					
				}
				Errores2.setForeground(Color.yellow);
				Errores2.setText(validaciones);
				if(validaciones.equalsIgnoreCase("<html>")){
					Productos operacion = new Productos();
					try {
						if(operacion.BuscarEquipo(txtBProducto.getText()) != null && !operacion.BuscarEquipo(txtBProducto.getText()).toString().equalsIgnoreCase(txtMNombre.getText())){
							Errores2.setText("* Ya existe un producto con este nombre dentro del sistema");
							return;
						}
						if(operacion.BuscarEquipo(txtMNombre.getText()) == txtMNombre.getText() && !txtMNombre.getText().equalsIgnoreCase(txtBProducto.getText())){
							Errores2.setText("* Ya existe un producto con este nombre dentro del sistema");
							return;
						}
						operacion.ActualizarEquipo(txtMNombre.getText(), txtMMarca.getText(), Integer.parseInt(txtMCantidad.getText()), txtBProducto.getText());
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						
						e.printStackTrace();
					}finally{
						operacion.Desconectar();
					}
					
					txtBProducto.setText("");
					txtMNombre.setText("");
					txtMMarca.setText("");
					txtMCantidad.setText("");
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
				txtBProducto.setText("");
				txtMNombre.setText("");
				txtMMarca.setText("");
				txtMCantidad.setText("");
				Errores2.setText("");
			}
		});
		button_1.setForeground(new Color(255, 250, 250));
		button_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		button_1.setBackground(new Color(75, 0, 130));
		button_1.setBounds(195, 380, 90, 28);
		panel_1.add(button_1);
		
		JLabel lblBuscarCdula = new JLabel("Codigo / Nombre");
		lblBuscarCdula.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarCdula.setForeground(new Color(255, 250, 250));
		lblBuscarCdula.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		lblBuscarCdula.setBounds(56, 132, 122, 16);
		panel_1.add(lblBuscarCdula);
		
		txtBProducto = new JTextField();
		
		
		
		
		
		txtBProducto.setHorizontalAlignment(SwingConstants.CENTER);
		txtBProducto.setBounds(204, 126, 122, 28);
		panel_1.add(txtBProducto);
		txtBProducto.setColumns(10);
		
		txtBProducto.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
				
				  if(!txtBProducto.getText().trim().equalsIgnoreCase("")){
					  Errores2.setText("");
					  BD operacion = new BD();
					  operacion.Conectar("FamainGuayana");
					  int cantidad = 0;
					  try{
						  String selectSQL = "";
						  PreparedStatement preparedStatement = null;
						  if(txtBProducto.getText().toString().matches("^[ A-Za-z]+$")){
							 selectSQL = "SELECT Nombre, Marca, Cantidad FROM Equipos WHERE Nombre = ?";
							 preparedStatement = operacion.conn.prepareStatement(selectSQL);
							  preparedStatement.setString(1, txtBProducto.getText());
						  }
						  if(txtBProducto.getText().toString().matches("[0-9]+")){
								 selectSQL = "SELECT Nombre, Marca, Cantidad FROM Equipos WHERE ProductoID = ?";
								 preparedStatement = operacion.conn.prepareStatement(selectSQL);
								  preparedStatement.setInt(1, Integer.parseInt(txtBProducto.getText()));
							  }
						  
						  ResultSet rs = preparedStatement.executeQuery();
						  while (rs.next()) {
						  	cantidad = rs.getInt("Cantidad");
						  	String nombre = rs.getString("Nombre").toLowerCase();	
						  	String marca = rs.getString("Marca");	
						  	txtMNombre.setText(WordUtils.capitalizeFully(nombre));
						  	txtMMarca.setText(marca);
						  	txtMCantidad.setText(Integer.toString(cantidad));
						  	
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
				
				  if(!txtBProducto.getText().trim().equalsIgnoreCase("")){
					  Errores2.setText("");
					  BD operacion = new BD();
					  operacion.Conectar("FamainGuayana");
					  int cantidad = 0;
					  try{
						  String selectSQL = "";
						  PreparedStatement preparedStatement = null;
						  if(txtBProducto.getText().toString().matches("^[ A-Za-z]+$")){
							 selectSQL = "SELECT Nombre, Marca, Cantidad FROM Equipos WHERE Nombre = ?";
							 preparedStatement = operacion.conn.prepareStatement(selectSQL);
							  preparedStatement.setString(1, txtBProducto.getText());
						  }
						  if(txtBProducto.getText().toString().matches("[0-9]+")){
								 selectSQL = "SELECT Nombre, Marca, Cantidad FROM Equipos WHERE ProductoID = ?";
								 preparedStatement = operacion.conn.prepareStatement(selectSQL);
								  preparedStatement.setInt(1, Integer.parseInt(txtBProducto.getText()));
							  }
						  
						  ResultSet rs = preparedStatement.executeQuery();
						  while (rs.next()) {
						  	cantidad = rs.getInt("Cantidad");
						  	String nombre = rs.getString("Nombre").toLowerCase();	
						  	String marca = rs.getString("Marca");	
						  	txtMNombre.setText(WordUtils.capitalizeFully(nombre));
						  	txtMMarca.setText(marca);
						  	txtMCantidad.setText(Integer.toString(cantidad));
						  	
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
				 
				  if(!txtBProducto.getText().trim().equalsIgnoreCase("")){
					  Errores2.setText("");
					  BD operacion = new BD();
					  operacion.Conectar("FamainGuayana");
					  int cantidad = 0;
					  try{
						  String selectSQL = "";
						  PreparedStatement preparedStatement = null;
						  if(txtBProducto.getText().toString().matches("^[ A-Za-z]+$")){
							 selectSQL = "SELECT Nombre, Marca, Cantidad FROM Equipos WHERE Nombre = ?";
							 preparedStatement = operacion.conn.prepareStatement(selectSQL);
							  preparedStatement.setString(1, txtBProducto.getText());
						  }
						  if(txtBProducto.getText().toString().matches("[0-9]+")){
								 selectSQL = "SELECT Nombre, Marca, Cantidad FROM Equipos WHERE ProductoID = ?";
								 preparedStatement = operacion.conn.prepareStatement(selectSQL);
								  preparedStatement.setInt(1, Integer.parseInt(txtBProducto.getText()));
							  }
						  
						  ResultSet rs = preparedStatement.executeQuery();
						  while (rs.next()) {
						  	cantidad = rs.getInt("Cantidad");
						  	String nombre = rs.getString("Nombre").toLowerCase();	
						  	String marca = rs.getString("Marca");	
						  	txtMNombre.setText(WordUtils.capitalizeFully(nombre));
						  	txtMMarca.setText(marca);
						  	txtMCantidad.setText(Integer.toString(cantidad));
						  	
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
		
		txtMMarca = new JTextField();
		txtMMarca.setHorizontalAlignment(SwingConstants.CENTER);
		txtMMarca.setColumns(10);
		txtMMarca.setBounds(138, 272, 122, 28);
		panel_1.add(txtMMarca);
		
		JLabel lblNombre_1 = new JLabel("Marca");
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
		lblNewLabel_5.setIcon(new ImageIcon(Equipos.class.getResource("/Imagenes/update.png")));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(406, 6, 376, 408);
		ModificarU.add(lblNewLabel_5);
		
		JPanel EliminarU = new JPanel();
		EliminarU.setBackground(new Color(255, 250, 250));
		
		tabbedPane.addTab("Eliminar  ", new ImageIcon(Equipos.class.getResource("/Imagenes/eliminar.png")), EliminarU, "Elimine un usuario");
		EliminarU.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(75, 0, 130));
		panel_2.setBounds(0, 0, 406, 517);
		EliminarU.add(panel_2);
		
		txtXCodigo = new JTextField();
		txtXCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtXCodigo.setColumns(10);
		txtXCodigo.setBounds(137, 220, 122, 28);
		panel_2.add(txtXCodigo);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCdigo.setForeground(new Color(255, 250, 250));
		lblCdigo.setFont(new Font("Simplified Arabic", Font.BOLD, 15));
		lblCdigo.setBounds(137, 192, 122, 16);
		panel_2.add(lblCdigo);
		
		JLabel lbleliminarusuarioExistente = new JLabel("<html><center>ELIMINAR</center>EQUIPO EXISTENTE</html>");
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
				if(txtXCodigo.getText().trim().equalsIgnoreCase("")){
					validaciones += "* Debe insertar un c�digo<br />";
				}
				if(!txtXCodigo.getText().trim().matches("[0-9]+") && !txtXCodigo.getText().equalsIgnoreCase("")){
					validaciones += "* El campo c�dula solo acepta n�meros<br />";
				}
				Errores3.setForeground(Color.yellow);
				Errores3.setText(validaciones);
				if(validaciones.equalsIgnoreCase("<html>")){
					Productos OP = new Productos();
					try {
						
						if(OP.BuscarEquipo(txtXCodigo.getText()) == null){
							Errores3.setForeground(Color.yellow);
							Errores3.setText("* No existe ning�n equipo con este codigo dentro del sistema");
							return;
						}
						if(OP.BuscarEquipo(txtXCodigo.getText()) != null){
							OP.EliminarProducto(Integer.parseInt(txtXCodigo.getText()));
							txtXCodigo.setText("");
							Errores3.setText("Equipo eliminado");
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
				txtXCodigo.setText("");
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
		lblNewLabel_6.setIcon(new ImageIcon(Equipos.class.getResource("/Imagenes/Delete-Icon-PNG-Graphic-Cave.png")));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(405, 0, 377, 455);
		EliminarU.add(lblNewLabel_6);
		
		JPanel VisualizarU = new JPanel();
		VisualizarU.setBackground(new Color(255, 250, 250));
		
		tabbedPane.addTab("Visualizar  ", new ImageIcon(Equipos.class.getResource("/Imagenes/visualizar.png")), VisualizarU, "Visualizar todos los usuarios");
		VisualizarU.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(75, 0, 130));
		panel_3.setBounds(0, 0, 782, 65);
		VisualizarU.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("LISTA DE EQUIPOS\r\n");
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
				"<html><center>N� Producto</center></html>", "Nombre", "Marca", "Cantidad"
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
			ResultSet tables = dbm.getTables(null, null, "Equipos", null);
			if (tables.next()) {
				
				  String selectSQL = "SELECT ProductoID, Nombre, Marca, Cantidad FROM Equipos";
				  stmt = operaciones.conn.createStatement();
				  ResultSet rs = stmt.executeQuery(selectSQL);
				  while (rs.next()) {
				  	int ID = rs.getInt("ProductoID");
				  	String Nombre = WordUtils.capitalizeFully(rs.getString("Nombre").toLowerCase());	
				  	String Marca = WordUtils.capitalizeFully(rs.getString("Marca").toLowerCase());	
				  	int cantidad = rs.getInt("Cantidad");
				  	
				  	model.addRow(new Object[]{ID, Nombre, Marca, cantidad + " unidades"});
				  	
				  	
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
				Equipos.main(args);
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
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					table.print(PrintMode.FIT_WIDTH, new MessageFormat("FAMAIN GUAYANA C.A - INVENTARIO"), new MessageFormat(new Date().toString()));;
				} catch (PrinterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
		
		MenuOpciones.add(mntmNewMenuItem_1);
		
		MenuP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MenuP.setVisible(true);
		
		

	}
}
