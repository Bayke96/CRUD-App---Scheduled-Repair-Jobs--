package Imagenes;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;

public class Acceso {
	private static JTextField txtUsuario;
	private static JPasswordField txtContrase�a;
	public static JLabel ErrorUsuario = new JLabel("Debe introducir un usuario");
	public static JLabel ErrorContrase�a = new JLabel("Debe introducir una contrase\u00F1a");
	
	
	public static boolean IsAdmin = false;
	
	public JFrame window = new JFrame("Famain Guayana - C.A");

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		Acceso a = new Acceso();
		a.window.getContentPane().setBackground(new Color(75, 0, 130));
		a.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.window.setSize(500, 347);
		a.window.setResizable(false);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		a.window.setLocation(dim.width/2-a.window.getSize().width/2, dim.height/2-a.window.getSize().height/2);
		a.window.getContentPane().setLayout(null);
		
		JLabel ErrorUsuario = new JLabel("Debe introducir una c\u00E9dula");
		ErrorUsuario.setVisible(false);
		ErrorUsuario.setFont(new Font("SansSerif", Font.BOLD, 12));
		ErrorUsuario.setForeground(new Color(255, 255, 0));
		ErrorUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		ErrorUsuario.setBounds(200, 191, 162, 22);
		a.window.getContentPane().add(ErrorUsuario);
		
		JLabel ErrorContrase�a = new JLabel("Debe introducir una contrase\u00F1a");
		ErrorContrase�a.setVisible(false);
		ErrorContrase�a.setHorizontalAlignment(SwingConstants.CENTER);
		ErrorContrase�a.setForeground(Color.YELLOW);
		ErrorContrase�a.setFont(new Font("SansSerif", Font.BOLD, 11));
		ErrorContrase�a.setBounds(190, 265, 181, 28);
		a.window.getContentPane().add(ErrorContrase�a);
		
		JButton BotonAceptar = new JButton("Aceptar");
		BotonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtUsuario.getText().trim().equalsIgnoreCase("") && txtContrase�a.getText().equalsIgnoreCase("")){
					ErrorUsuario.setVisible(true);
					ErrorContrase�a.setVisible(true);
					return;
				}
				if(txtUsuario.getText().trim().equalsIgnoreCase("")){
					ErrorUsuario.setVisible(true);
					ErrorContrase�a.setVisible(false);
					return;
				}
				if(txtContrase�a.getText().equalsIgnoreCase("")){
					ErrorUsuario.setVisible(false);
					ErrorContrase�a.setVisible(true);
					return;
				}
				if(txtUsuario.getText().trim().equalsIgnoreCase("admin") && txtContrase�a.getText().equalsIgnoreCase("246810")){
					Acceso.IsAdmin = true;
					a.window.dispose();
					MenuPrincipal.main(args);
					return;
				}
				
					ErrorUsuario.setVisible(false);
					ErrorContrase�a.setVisible(false);
					BD conexion = new BD();
					conexion.Acceso(txtUsuario.getText().trim(), txtContrase�a.getPassword());
					
				
			}
		});
		BotonAceptar.setFont(new Font("SansSerif", Font.BOLD, 12));
		BotonAceptar.setBackground(new Color(75, 0, 130));
		BotonAceptar.setForeground(new Color(255, 255, 255));
		BotonAceptar.setBounds(378, 185, 90, 28);
		a.window.getContentPane().add(BotonAceptar);
		
		JButton BotonSalir = new JButton("Salir");
		BotonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		BotonSalir.setFont(new Font("SansSerif", Font.BOLD, 12));
		BotonSalir.setBackground(new Color(75, 0, 130));
		BotonSalir.setForeground(new Color(255, 255, 255));
		BotonSalir.setBounds(378, 265, 90, 28);
		a.window.getContentPane().add(BotonSalir);
		
		JButton BotonBorrar = new JButton("Borrar");
		BotonBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsuario.setText("");
				txtContrase�a.setText("");
				
				ErrorUsuario.setVisible(false);
				ErrorContrase�a.setVisible(false);
			}
		});
		BotonBorrar.setFont(new Font("SansSerif", Font.BOLD, 12));
		BotonBorrar.setBackground(new Color(75, 0, 130));
		BotonBorrar.setForeground(new Color(255, 255, 255));
		BotonBorrar.setBounds(378, 225, 90, 28);
		a.window.getContentPane().add(BotonBorrar);
		
		txtUsuario = new JTextField();
		txtUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtUsuario.getText().trim().equalsIgnoreCase("")){
					ErrorUsuario.setVisible(true);
					ErrorContrase�a.setVisible(false);
					return;
				}
				txtContrase�a.requestFocus();
			}
		});
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setBounds(225, 153, 122, 28);
		a.window.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("N\u00FAmero de c\u00E9dula");
		lblUsuario.setFont(new Font("Cambria Math", Font.BOLD, 12));
		lblUsuario.setForeground(new Color(255, 250, 250));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(86, 156, 127, 22);
		a.window.getContentPane().add(lblUsuario);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		panel.setBounds(0, 0, 494, 141);
		a.window.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(Acceso.class.getResource("/Imagenes/LOGO.png")));
		lblIcono.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcono.setBounds(6, 6, 152, 129);
		panel.add(lblIcono);
		
		JLabel lblTitulo = new JLabel("FAMAIN GUAYANA C.A");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 23));
		lblTitulo.setForeground(new Color(75, 0, 130));
		lblTitulo.setBounds(156, 33, 332, 71);
		panel.add(lblTitulo);
		
		JLabel lblContrase�a = new JLabel("Contrase\u00F1a");
		lblContrase�a.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrase�a.setForeground(new Color(255, 250, 250));
		lblContrase�a.setFont(new Font("Cambria Math", Font.BOLD, 12));
		lblContrase�a.setBounds(86, 231, 127, 22);
		a.window.getContentPane().add(lblContrase�a);
		
		txtContrase�a = new JPasswordField();
		txtContrase�a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtUsuario.getText().trim().equalsIgnoreCase("") && txtContrase�a.getText().equalsIgnoreCase("")){
					ErrorUsuario.setVisible(true);
					ErrorContrase�a.setVisible(true);
					return;
				}
				if(txtUsuario.getText().trim().equalsIgnoreCase("")){
					ErrorUsuario.setVisible(true);
					ErrorContrase�a.setVisible(false);
					return;
				}
				if(txtContrase�a.getText().equalsIgnoreCase("")){
					ErrorUsuario.setVisible(false);
					ErrorContrase�a.setVisible(true);
					return;
				}
				if(txtUsuario.getText().trim().equalsIgnoreCase("admin") && txtContrase�a.getText().equalsIgnoreCase("246810")){
					Acceso.IsAdmin = true;
					a.window.dispose();
					MenuPrincipal.main(args);
					return;
				}
					
					ErrorUsuario.setVisible(false);
					ErrorContrase�a.setVisible(false);
					BD conexion = new BD();
					conexion.Acceso(txtUsuario.getText().trim(), txtContrase�a.getPassword());
					
				
			}
		});
		txtContrase�a.setHorizontalAlignment(SwingConstants.CENTER);
		txtContrase�a.setBounds(225, 225, 122, 28);
		a.window.getContentPane().add(txtContrase�a);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Mostrar contrase\u00F1a");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected() == true) txtContrase�a.setEchoChar((char) 0);
				if(chckbxNewCheckBox.isSelected() == false) txtContrase�a.setEchoChar('*');
			}
		});
		chckbxNewCheckBox.setFont(new Font("Cambria Math", Font.BOLD, 12));
		chckbxNewCheckBox.setForeground(new Color(255, 250, 250));
		chckbxNewCheckBox.setBounds(45, 265, 155, 18);
		a.window.getContentPane().add(chckbxNewCheckBox);
		
		txtUsuario.setText("");
		txtContrase�a.setText("");
		
		a.window.getContentPane().repaint();
		
		a.window.setVisible(true);

	}
}
