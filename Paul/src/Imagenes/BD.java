package Imagenes;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;



public class BD {
	
	public String Usuario = "root";
	public String Contraseña = "";
	public Connection conn = null;
	
public BD(){
		
		String createDB = "CREATE DATABASE IF NOT EXISTS FamainGuayana";
		PreparedStatement preparedStatement = null;
		
		
		
		 try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
		      //STEP 3: Open a connection
		      
		      conn = DriverManager.getConnection("jdbc:mysql://localhost", Usuario, Contraseña);
		      preparedStatement = conn.prepareStatement(createDB);

		      preparedStatement.executeUpdate();
		      Desconectar();
		   }
		   catch(Exception e){
			   System.err.println(e);
		   }
	      
	}


public void Acceso(String usuario, char[] contraseña){
	 try{
	      //STEP 2: Register JDBC driver
		  ResultSet rs = null;
	      Conectar("FamainGuayana");
	     
	     
	      String query = "SELECT Cedula, contraseña FROM Usuarios WHERE Cedula = ?";
		  PreparedStatement pstmt = conn.prepareStatement(query); // create a statement
		  pstmt.setString(1, usuario.toLowerCase()); // set input parameter
		  rs = pstmt.executeQuery();
		  String User = "", Pass = "", conversion = "";
		  while (rs.next()) {
		        User = rs.getString(1);
		        Pass = rs.getString(2);
		  }
		  for(int i = 0; i < contraseña.length; i++){
			  conversion += contraseña[i];
		  }
		  if(User.equalsIgnoreCase("")){
			  JOptionPane.showMessageDialog(null, "Número de cedula invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
			  return;
		  }
		  if(User.equalsIgnoreCase(usuario) && !Pass.equals(conversion)){
			  JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
			  return;
		  }
		 
		  
		 Acceso b = new Acceso();
		 b.window.dispose();
		  MenuPrincipal.main(null);
	      Desconectar();
		  
	   }
	   catch(Exception e){
		   System.err.println(e);
		   return;
	   }
	 finally{
		 Desconectar();
	 }
     
}

	public String InsertarUsuario(int cedula, String nombre, String contraseña) throws SQLException{
		String mensaje = "";
		Conectar("famainguayana");
		 String sqlCreate = "CREATE TABLE IF NOT EXISTS usuarios" 
         + "  (UsuarioID int NOT NULL AUTO_INCREMENT,"
         + "   Cedula            INTEGER NOT NULL UNIQUE,"
         + "   Nombre          VARCHAR(72) NOT NULL,"
         + "   Contraseña          VARCHAR(50) NOT NULL,"
         + " PRIMARY KEY ( UsuarioID ))";

		 Statement stmt = conn.createStatement();
		 stmt.execute(sqlCreate);
		
		 if(BuscarUsuario(cedula) != 0){
			 mensaje = "* Esta cédula ya existe dentro del sistema";
			 return mensaje;
		 }
		 
		 Conectar("famainguayana");
		 
		 
		 String insertTableSQL = "INSERT INTO usuarios"
					+ "(Cedula, Nombre, Contraseña) VALUES"
					+ "(?,?,?)";
		PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
		preparedStatement.setInt(1, cedula);
		preparedStatement.setString(2, nombre.toUpperCase());
		preparedStatement.setString(3, contraseña);
		
			
		preparedStatement .executeUpdate();
		Desconectar();
		return mensaje;
	}
	
	public void ActualizarUsuario(int cedula, String nombre, String contraseña, int Bcedula) throws SQLException{
		Conectar("famainguayana");
		
		 
		 String insertTableSQL = "UPDATE Usuarios SET Cedula = ?, Nombre = ?, Contraseña = ? WHERE Cedula = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
		preparedStatement.setInt(1, cedula);
		preparedStatement.setString(2, nombre.toUpperCase());
		preparedStatement.setString(3, contraseña);
		preparedStatement.setInt(4, Bcedula);
		
			
		preparedStatement .executeUpdate();
		Desconectar();
	}
	
	public void EliminarUsuario(int cedula) throws SQLException{
		Conectar("famainguayana");
		
		 
		 String insertTableSQL = "DELETE FROM USUARIOS where Cedula = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
		preparedStatement.setInt(1, cedula);
		preparedStatement .executeUpdate();
		Desconectar();
	}
	
	public int BuscarUsuario(int Cedula) throws SQLException{
		int resultado = 0;
		Conectar("famainguayana");
		try{
			  String selectSQL = "SELECT Cedula FROM usuarios WHERE Cedula = ?";
			  PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
			  preparedStatement.setInt(1, Cedula);
			  ResultSet rs = preparedStatement.executeQuery();
			  while (rs.next()) {
			  	resultado = rs.getInt("Cedula");
			   	
			  	
			  }
		}
		catch(Exception e){
				  System.err.println(e);
			  }
		Desconectar();
		return resultado;
	}
	
	
	
	
	
	public void Conectar(String BD){
		
		   
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
		      //STEP 3: Open a connection
		      
		      conn = DriverManager.getConnection("jdbc:mysql://localhost/" + BD, Usuario, Contraseña);
		      
		   }
		   catch(Exception e){
			   System.err.println(e);
		   }
	}
	
	public void Desconectar(){
		try {
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		}
	}

}

class Productos extends BD {
	
	public String DescontarHerramienta(int Codigo, int Cantidad){
		Conectar("famainguayana");
		String NombreHerramienta = "";
		try{
			String DiscountSQL = "UPDATE Equipos SET Cantidad = Cantidad - ? WHERE ProductoID = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(DiscountSQL);
			preparedStatement = conn.prepareStatement(DiscountSQL);
			preparedStatement.setInt(1, Cantidad);
			preparedStatement.setInt(2, Codigo);
			preparedStatement .executeUpdate();
			String SelectSQL = "SELECT Nombre FROM Equipos WHERE ProductoID = ?";
			preparedStatement = conn.prepareStatement(SelectSQL);
			preparedStatement.setInt(1, Codigo);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				NombreHerramienta = rs.getString("Nombre");
			}
		}
		catch(Exception x){
			x.printStackTrace();
		}
		Desconectar();
		return NombreHerramienta;
	}
	
	public Boolean ValidarCantidad(int Codigo, int Cantidad){
		boolean Valido = true;
		int ammount = 0;
		Conectar("famainguayana");
		try{
			String ValidateSQL = "SELECT Cantidad FROM Equipos WHERE ProductoID = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(ValidateSQL);
			preparedStatement.setInt(1, Codigo);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				ammount = rs.getInt("Cantidad");
			}
			if(Cantidad > ammount){
				Valido = false;
			}
		}
		catch(Exception x){
			x.printStackTrace();
		}
		Desconectar();
		return Valido;
	}
	
	public Object BuscarEquipo(String nombre){
		String encontrado = null;
		Conectar("famainguayana");
		
		try{
			 String selectSQL = "";
			if(nombre.matches("^[ A-Za-z]+$")){
				 selectSQL = "SELECT Nombre FROM Equipos WHERE Nombre = ?";
				  PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
				  preparedStatement.setString(1, nombre.toUpperCase());
				  ResultSet rs = preparedStatement.executeQuery();
				  while (rs.next()) {
				  	encontrado = rs.getString("Nombre");
				  }
			}
			if(nombre.matches("[0-9]+")){
				 selectSQL = "SELECT Nombre FROM Equipos WHERE ProductoID = ?";
				  PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
				  preparedStatement.setInt(1, Integer.parseInt(nombre));
				  ResultSet rs = preparedStatement.executeQuery();
				  while (rs.next()) {
				  	encontrado = rs.getString("Nombre");
				  }
			}
			 
			 
			  Desconectar();
				
		}
		catch(Exception e){
				  System.err.println(e);
			  }
		return encontrado;
		
	}

	
	public String InsertarEquipo(String nombre, String marca, int cantidad) throws SQLException{
		String mensaje = null;
		Conectar("famainguayana");
		 String sqlCreate = "CREATE TABLE IF NOT EXISTS Equipos" 
         + "  (ProductoID int NOT NULL AUTO_INCREMENT,"
         + "   Nombre            VARCHAR(98) NOT NULL UNIQUE,"
         + "   Marca          VARCHAR(72) NOT NULL,"
         + "   Cantidad          INT NOT NULL,"
         + " PRIMARY KEY ( ProductoID ))";

		 Statement stmt = conn.createStatement();
		 stmt.execute(sqlCreate);
		
		 if(BuscarEquipo(nombre) != null){
			 mensaje = "* Esta equipo ya se encuentra en el sistema";
			 return mensaje;
		 }
		 
		 Conectar("famainguayana");
		 
		 
		 String insertTableSQL = "INSERT INTO Equipos"
					+ "(Nombre, Marca, Cantidad) VALUES"
					+ "(?,?,?)";
		PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
		preparedStatement.setString(1, nombre.toUpperCase());
		preparedStatement.setString(2, marca);
		preparedStatement.setInt(3, cantidad);
		
			
		preparedStatement .executeUpdate();
		Desconectar();
		return mensaje;
	}
	
	
	public void ActualizarEquipo(String nombre, String marca, int cantidad, Object CodNombre) throws SQLException{
		Conectar("famainguayana");
		
		
		
		String insertTableSQL = "";
		PreparedStatement preparedStatement = null;
		 if(CodNombre.toString().matches("^[ A-Za-z]+$")){
			 insertTableSQL = "UPDATE Equipos SET Nombre = ?, Marca = ?, Cantidad = ? WHERE Nombre = ?";
				preparedStatement = conn.prepareStatement(insertTableSQL);
				preparedStatement.setString(1, nombre.toUpperCase());
				preparedStatement.setString(2, marca);
				preparedStatement.setInt(3, cantidad);
				preparedStatement.setString(4, CodNombre.toString().toUpperCase());
		 }
		 if(CodNombre.toString().matches("[0-9]+")){
			 insertTableSQL = "UPDATE Equipos SET Nombre = ?, Marca = ?, Cantidad = ? WHERE ProductoID = ?";
				preparedStatement = conn.prepareStatement(insertTableSQL);
				preparedStatement.setString(1, nombre.toUpperCase());
				preparedStatement.setString(2, marca);
				preparedStatement.setInt(3, cantidad);
				preparedStatement.setInt(4, Integer.parseInt(CodNombre.toString()));
		 }
		
		
			
		preparedStatement .executeUpdate();
		Desconectar();
		
		
	}
	
	public void EliminarProducto(int codigo) throws SQLException{
		Conectar("famainguayana");
		
		 
		 String insertTableSQL = "DELETE FROM Equipos where ProductoID = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
		preparedStatement.setInt(1, codigo);
		preparedStatement .executeUpdate();
		Desconectar();
	}
	
}

class Trabajo extends BD {
	
	public void EliminarProyecto(int codigo) throws SQLException{
		Conectar("famainguayana");
		
		 
		 String insertTableSQL = "DELETE FROM Trabajos where NTrabajo = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
		preparedStatement.setInt(1, codigo);
		preparedStatement .executeUpdate();
		Desconectar();
	}
	
	public void BuscarHerramientas(JTable tabla, int NTrabajo) throws SQLException{
		Conectar("famainguayana");
		String selectSQL = "";
		String herramienta = "";
		int cantidad = 0;
		DefaultTableModel model = (DefaultTableModel) tabla.getModel();
		for (int i = tabla.getRowCount() - 1; i >= 0; i--) {
		    model.removeRow(i);
		}
		PreparedStatement preparedStatement = null;
		
			selectSQL = "SELECT Herramienta, Cantidad FROM Trabajos WHERE NTrabajo = ?";
			  preparedStatement = conn.prepareStatement(selectSQL);
			  preparedStatement.setInt(1, NTrabajo);
			  ResultSet rs = preparedStatement.executeQuery();
			  while (rs.next()) {
			  	herramienta = rs.getString("Herramienta");
			  	cantidad = rs.getInt("Cantidad");
			  	model.addRow(new Object[]{herramienta, cantidad});
			  }
			  
			  DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			  centerRenderer.setHorizontalAlignment( JLabel.CENTER );
				
			  tabla.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
			  tabla.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
				
			  
		
		Desconectar();
	}
	
	
	
	public boolean BuscarTrabajo(int Codigo) throws SQLException{
		boolean Encontrado = false;
		Conectar("famainguayana");
		 String selectSQL = "SELECT NTrabajo FROM Trabajos WHERE NTrabajo = ?";
		  PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
		  preparedStatement.setInt(1, Codigo);
		  ResultSet rs = preparedStatement.executeQuery();
		  while (rs.next()) {
		  	Encontrado = true;
		  }
		  Desconectar();
		return Encontrado;
		
	}
	
	public int SeleccionarTrabajo(){
		int Numero = 0;
		Conectar("famainguayana");
		try{
			
			 DatabaseMetaData dbm = conn.getMetaData();
			    ResultSet rs = dbm.getTables(null, null, "TRABAJOS", null);
			    Statement stmt = null;
			    String selectSQL = "";
			    if (rs.next()) {
			    	 selectSQL = "SELECT NTrabajo FROM TRABAJOS ORDER BY NTrabajo DESC LIMIT 1";
					  stmt = conn.createStatement();
					  ResultSet ds = stmt.executeQuery(selectSQL);
					  while (ds.next()) {
					  	Numero = ds.getInt("NTrabajo");
					  }
			    } else {
			      Numero = 1;
			      return Numero;
			    }
			
				
			 Desconectar();
		}
		catch(Exception e){
				  System.err.println(e);
			  }
		return Numero + 1;
	}
	
	public void CrearTrabajo(int NTrabajo, String cliente, String mecanico, String inicio, String culminacion, JTable tabla) throws SQLException{
		
		Conectar("famainguayana");
		 String sqlCreate = "CREATE TABLE IF NOT EXISTS Trabajos" 
         + "  (TrabajoID int NOT NULL AUTO_INCREMENT,"
         + "   NTrabajo          INT NOT NULL,"		 
         + "   Cliente            VARCHAR(98) NOT NULL,"
         + "   Mecanico          VARCHAR(72) NOT NULL,"
         + "   FInicio          VARCHAR(24) NOT NULL,"
         + "   FCulminacion          VARCHAR(24) NOT NULL,"
         + "   Herramienta          VARCHAR(72) NOT NULL,"
         + "   Cantidad          INT NOT NULL,"
         + " PRIMARY KEY ( TrabajoID ))";

		 Statement stmt = conn.createStatement();
		 stmt.execute(sqlCreate);
		
		 
		 
		 String insertTableSQL = "";
		 PreparedStatement preparedStatement = null;
		 conn.setAutoCommit(false);
		 insertTableSQL = "INSERT INTO Trabajos"
					+ "(NTrabajo, Cliente, Mecanico, FInicio, FCulminacion, Herramienta, Cantidad) VALUES"
					+ "( ? , ? , ? , ? , ?, ? , ? )";
		 preparedStatement = conn.prepareStatement(insertTableSQL);
		 for(int i = 0; i < tabla.getRowCount(); i++){
			 preparedStatement.setInt(1, NTrabajo);
			 
				preparedStatement.setString(2, cliente);
				preparedStatement.setString(3, WordUtils.capitalizeFully(mecanico));
				preparedStatement.setString(4, inicio);
				preparedStatement.setString(5, culminacion);
				preparedStatement.setString(6, tabla.getValueAt(i, 1).toString());
				preparedStatement.setInt(7, Integer.parseInt(tabla.getValueAt(i, 2).toString()));
				preparedStatement.addBatch();
		 }
		 
		 preparedStatement.executeBatch();
		 conn.commit();
		Desconectar();
		
	}
	
	public void EliminarHerramienta(JTable tabla, int Codigo) throws SQLException{
		int Fila = tabla.getSelectedRow();
		
		String Nombre = (String) tabla.getValueAt(Fila, 0).toString();
		Conectar("famainguayana");
		 String insertTableSQL = "DELETE FROM Trabajos where Herramienta = ? LIMIT 1";
			PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, Nombre);
			preparedStatement.executeUpdate();
			DefaultTableModel dbm = (DefaultTableModel) tabla.getModel();
			dbm.removeRow(Fila);
		Desconectar();
	}
	
	public void ActualizarTrabajo(int codigo, String cliente, String mecanico, String inicio, String culminacion, JTable tabla) throws SQLException{
		Conectar("famainguayana");
					
		
			 String insertTableSQL = "UPDATE Trabajos SET Cliente = ?, Mecanico = ?, FInicio = ?, FCulminacion = ? WHERE Ntrabajo = ?";
				PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
				preparedStatement.setString(1, cliente);
				preparedStatement.setString(2, WordUtils.capitalizeFully(mecanico));
				preparedStatement.setString(3, inicio);
				preparedStatement.setString(4, culminacion);
				preparedStatement.setInt(5, codigo);
					
				preparedStatement .executeUpdate();
		
		Desconectar();
	}
	
}
