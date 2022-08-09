package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import models.Model;
import views.View;

public class Controller implements ActionListener{

	
	private Model model;
	private View view;
	private String nombre;
	private String apellido;
	private String direccion;
	private int dni;
	private String fecha;
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		this.view.btnEnviarForm.addActionListener(this);
		this.view.btnVistaBuscar.addActionListener(this);
		this.view.btnVistaCrear.addActionListener(this);
		this.view.btnBuscarCliente.addActionListener(this);
		this.view.btnVistaBorrarCliente.addActionListener(this);
		this.view.btnBorrarCliente.addActionListener(this);
	}
	
	public void startView() {
		view.setTitle("Formulario");
		view.pack();
		view.setBounds(100, 100, 693, 656);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setLocationRelativeTo(null);
		view.setVisible(true);
		view.btnBuscarCliente.setVisible(false);
		view.btnBorrarCliente.setVisible(false);
		view.textPane.setVisible(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(view.btnEnviarForm == e.getSource()) {
			crearUsuario();
		} else if (view.btnVistaBuscar == e.getSource()) {
			changeViewFormatBtnBuscar();
		} else if (view.btnVistaCrear == e.getSource()) {
			changeViewFormatCrear();
		} else if (view.btnBuscarCliente == e.getSource()) {
			botonBuscarCliente();
		} else if (view.btnVistaBorrarCliente == e.getSource()) {
			changeViewFormatBtnBorrar();
		} else if (view.btnBorrarCliente == e.getSource()) {
			botonEliminarCliente();
		}
	}
	
	public void botonEliminarCliente() {
		try {
			this.nombre = view.textFieldNombre.getText();
			this.apellido = view.textFieldApellido.getText();
			boolean nombreValido = nombre.matches("[a-zA-Z]+");
			boolean apellidoValido = nombre.matches("[a-zA-Z]+");

			if (nombreValido && apellidoValido) {
				String query = "delete from cliente where nombre='" + nombre + "' and apellido='" + apellido + "';";
				model.insertSql("C4_UD22_01", query);
			}

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(view, "Ha surgido un error!");
			System.out.println(e2.getMessage());
		}
	}
	
	public void botonBuscarCliente() {
		try {
			this.nombre = view.textFieldNombre.getText();
			this.apellido = view.textFieldApellido.getText();
			boolean nombreValido = nombre.matches("[a-zA-Z]+");
			boolean apellidoValido = nombre.matches("[a-zA-Z]+");

			if (nombreValido && apellidoValido) {
				model.connectMySql();
				model.getValues("C4_UD22_01", "cliente", nombre, apellido, view);
				model.closeConnection();
			}

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(view, "Ha surgido un error!");
			System.out.println(e2.getMessage());
		}
	}
	
	public void crearUsuario() {
		try {
			this.nombre = view.textFieldNombre.getText();
			this.apellido = view.textFieldApellido.getText();
			this.direccion = view.textFieldDireccion.getText();
			this.dni = Integer.parseInt(view.textFieldDni.getText());
			this.fecha = view.textFieldFecha.getText();
			boolean nombreValido = nombre.matches("[a-zA-Z]+");
			boolean apellidoValido = nombre.matches("[a-zA-Z]+");

			if (nombreValido && apellidoValido) {
				String query = "insert into cliente(nombre, apellido, direccion, dni, fecha) values ('" + nombre
						+ "', '" + apellido + "', '" + direccion + "', " + dni + ", '" + fecha + "')";
				model.insertSql("C4_UD22_01", query);
			}

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(view, "Ha surgido un error!");
			System.out.println(e2.getMessage());
		}
	}
	
	public void changeViewFormatBtnBorrar() {
		view.lblDireccion.setVisible(false);
		view.lblDni.setVisible(false);
		view.lblFecha.setVisible(false);
		
		view.textFieldDireccion.setVisible(false);
		view.textFieldDni.setVisible(false);
		view.textFieldFecha.setVisible(false);
		
		view.btnEnviarForm.setVisible(false);
		view.btnVistaCrear.setVisible(true);
		view.btnBorrarCliente.setVisible(true);
		view.textPane.setVisible(true);
		
		view.btnBuscarCliente.setVisible(false);
	}
	
	public void changeViewFormatBtnBuscar() {
		view.lblDireccion.setVisible(false);
		view.lblDni.setVisible(false);
		view.lblFecha.setVisible(false);
		
		view.textFieldDireccion.setVisible(false);
		view.textFieldDni.setVisible(false);
		view.textFieldFecha.setVisible(false);
		
		view.btnEnviarForm.setVisible(false);
		view.btnVistaCrear.setVisible(true);
		view.btnBuscarCliente.setVisible(true);
		
		view.textPane.setVisible(true);
		
		view.btnBorrarCliente.setVisible(false);
	}
	
	public void changeViewFormatCrear() {
		view.lblDireccion.setVisible(true);
		view.lblDni.setVisible(true);
		view.lblFecha.setVisible(true);
		
		view.textFieldDireccion.setVisible(true);
		view.textFieldDni.setVisible(true);
		view.textFieldFecha.setVisible(true);
		
		view.btnEnviarForm.setVisible(true);
		view.btnBuscarCliente.setVisible(false);
		view.textPane.setVisible(false);
		
		view.btnBorrarCliente.setVisible(false);
	}
}
