package views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class View extends JFrame{
	public JTextField textFieldNombre;
	public JTextField textFieldApellido;
	public JTextField textFieldDireccion;
	public JTextField textFieldDni;
	public JTextField textFieldFecha;
	public JLabel lblNombre;
	public JLabel lblApellido;
	public JLabel lblDireccion;
	public JLabel lblDni;
	public JLabel lblFecha;
	public JButton btnEnviarForm;
	public JButton btnVistaBuscar;
	public JButton btnVistaCrear;
	public JTextPane textPane;
	public JButton btnBorrarCliente;
	public JTable tablaUsuarios;
	public JScrollPane scrollTabla;
	public DefaultTableModel modeloTabla;
	
	public View() {
		getContentPane().setLayout(null);
		
		lblNombre = new JLabel("Nombre *");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(10, 11, 110, 15);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(10, 37, 211, 20);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		lblApellido = new JLabel("Apellido *");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellido.setBounds(10, 68, 110, 15);
		getContentPane().add(lblApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(10, 94, 211, 20);
		getContentPane().add(textFieldApellido);
		
		lblDireccion = new JLabel("Dirección *");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDireccion.setBounds(10, 125, 110, 15);
		getContentPane().add(lblDireccion);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBounds(10, 151, 211, 20);
		getContentPane().add(textFieldDireccion);
		
		lblDni = new JLabel("NIF/NIE *");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDni.setBounds(10, 182, 110, 15);
		getContentPane().add(lblDni);
		
		textFieldDni = new JTextField();
		textFieldDni.setColumns(10);
		textFieldDni.setBounds(10, 208, 211, 20);
		getContentPane().add(textFieldDni);
		
		lblFecha = new JLabel("Fecha de nacimiento * Ejemplo: 2022-01-01");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFecha.setBounds(10, 239, 318, 15);
		getContentPane().add(lblFecha);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(10, 265, 211, 20);
		getContentPane().add(textFieldFecha);
		
		btnEnviarForm = new JButton("Envíar");
		btnEnviarForm.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnEnviarForm.setBounds(30, 296, 167, 40);
		getContentPane().add(btnEnviarForm);
		
		btnVistaBuscar = new JButton("Buscar cliente");
		btnVistaBuscar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnVistaBuscar.setBounds(504, 24, 167, 40);
		getContentPane().add(btnVistaBuscar);
		
		btnVistaCrear = new JButton("Crear cliente");
		btnVistaCrear.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnVistaCrear.setBounds(504, 68, 167, 40);
		getContentPane().add(btnVistaCrear);
		
		textPane = new JTextPane();
		textPane.setBounds(10, 176, 331, 421);
		getContentPane().add(textPane);
		
		btnBorrarCliente = new JButton("Borrar cliente");
		btnBorrarCliente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnBorrarCliente.setBounds(504, 111, 167, 40);
		getContentPane().add(btnBorrarCliente);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(492, 11, 189, 150);
		getContentPane().add(lblNewLabel);
		lblNewLabel.setBorder(BorderFactory.createLineBorder(Color.black));
	}
}
