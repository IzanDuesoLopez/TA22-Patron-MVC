package controllers;

import java.awt.event.*;
import java.sql.Connection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import models.*;
import views.*;

public class Controller implements ActionListener {
	
	private Model model;
	private View view;
	
	/**
	 * Constructor with actionListener for components
	 * @param model
	 * @param view
	 */
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		this.view.showCustomers.addActionListener(this);
		this.view.createCustomers.addActionListener(this);
		this.view.createCustomer.addActionListener(this);
		this.view.editCustomerForm.addActionListener(this);
		this.view.editCustomer.addActionListener(this);
		this.view.deleteCustomer.addActionListener(this);
	}
	
	/**
	 * We start the view
	 */
	public void startView() {
		view.setTitle("C4_UD22_01");
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setVisible(true);
	}
	
	/**
	 *  On action performed, when we click buttons
	 */
	public void actionPerformed(ActionEvent e) {
		if (view.showCustomers == e.getSource()) {
			showCustomers();
		} else if (view.createCustomers == e.getSource()) {
			createCustomersForm();
		} else if (view.createCustomer == e.getSource()) {
			createCustomer();
			showCustomers();
		} else if (view.editCustomerForm == e.getSource()) {
			editCustomersForm();
		} else if (view.editCustomer == e.getSource()) {
			editCustomer();
			showCustomers();
		} else if (view.deleteCustomer == e.getSource()) {
			deleteCustomer();
			showCustomers();
		}
	}
	
	/**
	 *  Show customers table
	 */
	public void showCustomers() {
		view.createCustomersPanel.setVisible(false);
		view.editCustomersPanel.setVisible(false);
		view.showCustomersPanelTop.setVisible(true);
		view.model = new DefaultTableModel();
		view.table = new JTable(view.model);
		view.showCustomersPanel.setViewportView(view.table);
		
		model.connection();
		
		// Customers columns
		String[] colu = model.getColumns("clientes");
		for (int i = 0; i < colu.length; i++) {
			view.model.addColumn(colu[i]);
		};
		
		// Customers data
		String[][] rows = model.getData("clientes");
		
		for (int i = 0; i < rows.length; i++) {
			Object[] row = new Object[] {rows[i][0], rows[i][1], rows[i][2], rows[i][3], rows[i][4], rows[i][5]};
			view.model.addRow(row);
		}
		
		model.closeConnection();
	}
	
	// Create customers form
	public void createCustomersForm() {
		view.editCustomersPanel.setVisible(false);
		view.showCustomersPanelTop.setVisible(false);
		view.createCustomersPanel.setVisible(true);
	}
	
	// Create customer
	public void createCustomer() {
		model.connection();
		
		String name = view.name_customer.getText();
		String surname = view.surname_customer.getText();
		String address = view.address_customer.getText();
		String dni = view.dni_customer.getText();
		String date = view.date_customer.getText();
		
		String query = "insert into clientes(nombre, apellido, direccion, dni, fecha) values ('" + name + "', '" + surname + "', '" + address + "', " + dni + ", '" + date + "');";
		
		model.executeQuery(query);
		model.closeConnection();
	}
	
	// Edit customer form
	public void editCustomersForm() {
		try {
			int row = view.table.getSelectedRow();
			String id = view.table.getModel().getValueAt(row, 0).toString();
			String name = view.table.getModel().getValueAt(row, 1).toString();
			String surname = view.table.getModel().getValueAt(row, 2).toString();
			String address = view.table.getModel().getValueAt(row, 3).toString();
			String dni = view.table.getModel().getValueAt(row, 4).toString();
			String date = view.table.getModel().getValueAt(row, 5).toString();
			
			view.showCustomersPanelTop.setVisible(false);
			view.createCustomersPanel.setVisible(false);
			view.editCustomersPanel.setVisible(true);
			
			view.id_customer_edit.setText(id);
			view.name_customer_edit.setText(name);
			view.surname_customer_edit.setText(surname);
			view.address_customer_edit.setText(address);
			view.dni_customer_edit.setText(dni);
			view.date_customer_edit.setText(date);
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(view, "¡Must select a customer to edit it!");
			showCustomers(); // We show customers to app user
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	// Edit customer
	public void editCustomer() {
			model.connection();
			
			String id = view.id_customer_edit.getText();
			String name = view.name_customer_edit.getText();
			String surname = view.surname_customer_edit.getText();
			String address = view.address_customer_edit.getText();
			String dni = view.dni_customer_edit.getText();
			String date = view.date_customer_edit.getText();
			
			String query = "update clientes set nombre='" + name + "', apellido='" + surname + "', direccion='" + address + "', dni=" + dni + ", fecha='" + date + "' where id=" + id + ";";
			
			model.executeQuery(query);
			model.closeConnection();
	}
	
	// Delete customer
	public void deleteCustomer() {
		try {
			int row = view.table.getSelectedRow();
			String id = view.table.getModel().getValueAt(row, 0).toString();
			
			model.connection();
			
			String query = "delete from clientes where id = " + id + ";";
			
			model.executeQuery(query);
			model.closeConnection();
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(view, "¡Must select a customer to delete it!");
			System.out.println("Error: " + e.getMessage());
		}
	}
}