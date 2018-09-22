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
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class ConfigurarImpresora {

	public static void main(String[] args) {
		JFrame MenuImpresora = new JFrame("Famain Guayana C.A - Menu");
		MenuImpresora.setIconImage(Toolkit.getDefaultToolkit().getImage(ConfigurarImpresora.class.getResource("/Imagenes/LOGO.png")));
		MenuImpresora.getContentPane().setBackground(new Color(75, 0, 130));
		MenuImpresora.getContentPane().setLayout(null);
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		JLabel lblNewLabel = new JLabel("SELECCIONE LA IMPRESORA");
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setBackground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 33));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 508, 73);
		MenuImpresora.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		panel.setBounds(0, 134, 516, 120);
		MenuImpresora.getContentPane().add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File NImpresora = new File("NImpresora.txt");
				
				
					try {
						if(NImpresora.exists() == false){
						NImpresora.createNewFile();
						BufferedWriter writer = new BufferedWriter(new FileWriter(NImpresora));
						writer.write(comboBox.getSelectedItem().toString());
						writer.close();
						}
						else{
							BufferedWriter writer = new BufferedWriter(new FileWriter(NImpresora));	
							writer.write(comboBox.getSelectedItem().toString());
							writer.close();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
					
					MenuImpresora.dispose();
					
				}
			
			
		});
		btnNewButton.setBackground(new Color(75, 0, 130));
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton.setForeground(new Color(255, 250, 250));
		btnNewButton.setBounds(164, 70, 90, 28);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuImpresora.dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(75, 0, 130));
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton_1.setForeground(new Color(255, 250, 250));
		btnNewButton_1.setBounds(259, 70, 90, 28);
		panel.add(btnNewButton_1);
		
		
		comboBox.setBounds(133, 6, 240, 28);
		panel.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ConfigurarImpresora.class.getResource("/Imagenes/resize.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(173, 78, 173, 52);
		MenuImpresora.getContentPane().add(lblNewLabel_1);
		MenuImpresora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MenuImpresora.setSize(522, 282);
		MenuImpresora.setResizable(false);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		MenuImpresora.setLocation(dim.width/2-MenuImpresora.getSize().width/2, dim.height/2-MenuImpresora.getSize().height/2);
		
		
		
		MenuImpresora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		 PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
	       

	        for (PrintService printer : printServices)
	            comboBox.addItem(printer.getName());
		
		MenuImpresora.setVisible(true);
		
		

	}
}
