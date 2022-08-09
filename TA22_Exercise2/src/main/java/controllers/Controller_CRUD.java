package controllers;

import java.awt.event.*;
import java.sql.Connection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import models.*;
import views.*;

public class Controller_CRUD implements ActionListener {
	
	private Model_DB model;
	private View_tables view;
	
	public Controller_CRUD(Model_DB model, View_tables view) {
		this.model = model;
		this.view = view;
		this.view.showCustomers.addActionListener(this);
		this.view.createCustomers.addActionListener(this);
		this.view.createCustomer.addActionListener(this);
		this.view.editCustomerForm.addActionListener(this);
		this.view.editCustomer.addActionListener(this);
		this.view.deleteCustomer.addActionListener(this);
		this.view.showVideos.addActionListener(this);
		this.view.createVideos.addActionListener(this);
		this.view.createVideo.addActionListener(this);
		this.view.editVideos.addActionListener(this);
		this.view.editVideo.addActionListener(this);
		this.view.deleteVideos.addActionListener(this);
	}
	
	public void startView() {
		view.setTitle("C4_UD22_02");
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setVisible(true);
	}
	
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
		} else if (view.showVideos == e.getSource()) {
			
			showVideos();
		} else if (view.deleteVideos == e.getSource()) {
			
			deleteVideos();
			showVideos();
		} else if (view.createVideos == e.getSource()) {
			
			createVideosForm();
			
		} else if (view.createVideo == e.getSource()) {
			
			createVideo();
			showVideos();
		} else if (view.editVideos == e.getSource()) {
			
			editVideosForm();
		} else if (view.editVideo == e.getSource()) {
			
			editVideo();
			showVideos();
		}
	}
	
// --- Customers table	
	// Show
	public void showCustomers() {
		view.createCustomersPanel.setVisible(false);
		view.editCustomersPanel.setVisible(false);
		view.createVideosPanel.setVisible(false);
		view.editVideosPanel.setVisible(false);
		view.showCustomersPanelTop.setVisible(true);
		
		view.model = new DefaultTableModel();
		view.table = new JTable(view.model);
		view.showCustomersPanel.setViewportView(view.table);
		
		model.connection();
		
		// Columns
		String[] colu = model.getColumns("clientes");
		for (int i = 0; i < colu.length; i++) {
			view.model.addColumn(colu[i]);
		};
		
		// Data
		String[][] rows = model.getData("clientes");
		
		for (int i = 0; i < rows.length; i++) {
			
			Object[] row = new Object[] {rows[i][0], rows[i][1], rows[i][2], rows[i][3], rows[i][4], rows[i][5]};
			view.model.addRow(row);
		}
		
		model.closeConnection();
	}
	
	// Create
	public void createCustomersForm() {
		view.editCustomersPanel.setVisible(false);
		view.showCustomersPanelTop.setVisible(false);
		view.createVideosPanel.setVisible(false);
		view.editVideosPanel.setVisible(false);
		view.createCustomersPanel.setVisible(true);
	}
	
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
	
	// Edit
	public void editCustomersForm() {
		int row = view.table.getSelectedRow();
		String id = view.table.getModel().getValueAt(row, 0).toString();
		String name = view.table.getModel().getValueAt(row, 1).toString();
		String surname = view.table.getModel().getValueAt(row, 2).toString();
		String address = view.table.getModel().getValueAt(row, 3).toString();
		String dni = view.table.getModel().getValueAt(row, 4).toString();
		String date = view.table.getModel().getValueAt(row, 5).toString();
		
		view.showCustomersPanelTop.setVisible(false);
		view.createCustomersPanel.setVisible(false);
		view.createVideosPanel.setVisible(false);
		view.editVideosPanel.setVisible(false);
		view.editCustomersPanel.setVisible(true);
		
		view.id_customer_edit.setText(id);
		view.name_customer_edit.setText(name);
		view.surname_customer_edit.setText(surname);
		view.address_customer_edit.setText(address);
		view.dni_customer_edit.setText(dni);
		view.date_customer_edit.setText(date);
	}
	
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
	
	// Delete
	public void deleteCustomer() {
		int row = view.table.getSelectedRow();
		String id = view.table.getModel().getValueAt(row, 0).toString();
		
		model.connection();
		
		String query = "delete from clientes where id = " + id + ";";
		
		model.executeQuery(query);
		model.closeConnection();
	}
	
// --- Customers table	
	// Show
	public void showVideos() {
		view.createCustomersPanel.setVisible(false);
		view.editCustomersPanel.setVisible(false);
		view.createVideosPanel.setVisible(false);
		view.editVideosPanel.setVisible(false);
		view.showCustomersPanelTop.setVisible(true);
		
		view.model = new DefaultTableModel();
		view.table = new JTable(view.model);
		view.showCustomersPanel.setViewportView(view.table);
		
		model.connection();
		
		// Columns
		String[] colu = model.getColumns("videos");
		for (int i = 0; i < colu.length; i++) {
			view.model.addColumn(colu[i]);
		};
		
		// Data
		String[][] rows = model.getData("videos");
		
		for (int i = 0; i < rows.length; i++) {
			
			Object[] row = new Object[] {rows[i][0], rows[i][1], rows[i][2], rows[i][3]};
			view.model.addRow(row);
		}
		
		model.closeConnection();
	}
	
	// Create
	public void createVideosForm() {
		view.editCustomersPanel.setVisible(false);
		view.showCustomersPanelTop.setVisible(false);
		view.createCustomersPanel.setVisible(false);
		view.editVideosPanel.setVisible(false);
		view.createVideosPanel.setVisible(true);
	}
	
	public void createVideo() {
		model.connection();
		
		String title = view.title_video.getText();
		String director = view.director_video.getText();
		String cli_id = view.cli_id_video.getText();
		
		String query = "insert into videos(title, director, cli_id) values ('" + title + "', '" + director + "', " + cli_id + ");";
		
		model.executeQuery(query);
		model.closeConnection();
	}
	
	// Edit
	public void editVideosForm() {
		int row = view.table.getSelectedRow();
		String id = view.table.getModel().getValueAt(row, 0).toString();
		String title = view.table.getModel().getValueAt(row, 1).toString();
		String director = view.table.getModel().getValueAt(row, 2).toString();
		String cli_id = view.table.getModel().getValueAt(row, 3).toString();
		
		view.showCustomersPanelTop.setVisible(false);
		view.createCustomersPanel.setVisible(false);
		view.editCustomersPanel.setVisible(false);
		view.createVideosPanel.setVisible(false);
		view.editVideosPanel.setVisible(true);
		
		view.id_video_edit.setText(id);
		view.title_video_edit.setText(title);
		view.director_video_edit.setText(director);
		view.cli_id_video_edit.setText(cli_id);

	}
	
	public void editVideo() {
		model.connection();
		
		String id = view.id_video_edit.getText();
		String title = view.title_video_edit.getText();
		String director = view.director_video_edit.getText();
		String cli_id = view.cli_id_video_edit.getText();
		
		String query = "update videos set title='" + title + "', director='" + director + "', cli_id='" + cli_id + "' where id=" + id + ";";
		
		model.executeQuery(query);
		model.closeConnection();
	}
	
	// Delete
	public void deleteVideos() {
		int row = view.table.getSelectedRow();
		String id = view.table.getModel().getValueAt(row, 0).toString();
		
		model.connection();
		
		String query = "delete from videos where id = " + id + ";";
		
		model.executeQuery(query);
		model.closeConnection();
	}
}