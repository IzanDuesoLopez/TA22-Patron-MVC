package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.Model_DB;
import views.View_tables;

public class Controller_CRUD implements ActionListener {

	private Model_DB model;
	private View_tables view;
	
	public Controller_CRUD(Model_DB model, View_tables view) {
		this.model = model;
		this.view = view;
		this.view.showScientists.addActionListener(this);
		this.view.createScientists.addActionListener(this);
		this.view.createScientist.addActionListener(this);
		this.view.editScientistsForm.addActionListener(this);
		this.view.editScientist.addActionListener(this);
		this.view.deleteScientist.addActionListener(this);
	}
	
	public void startView() {
		view.setTitle("C4_UD22_03");
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (view.showScientists == e.getSource()) {
			showScientists();
		} else if (view.createScientists == e.getSource()) {
			createScientistsForm();
		} else if (view.createScientist == e.getSource()) {
			createScientist();
			showScientists();
		} else if (view.editScientistsForm == e.getSource()) {
			editScientistsForm();
		} else if (view.editScientist == e.getSource()) {
			editScientist();
			showScientists();
		} else if (view.deleteScientist == e.getSource()) {
			deleteScientist();
			showScientists();
		}
	}
	
// --- Customers table	
	// Show
	public void showScientists() {
		view.createScientistsPanel.setVisible(false);
		view.editScientistsPanel.setVisible(false);
		view.showScientistsPanelTop.setVisible(true);
		
		view.model = new DefaultTableModel();
		view.table = new JTable(view.model);
		view.showScientistsPanel.setViewportView(view.table);
		
		model.connection();
		
		// Columns
		String[] colu = model.getColumns("cientificos");
		for (int i = 0; i < colu.length; i++) {
			view.model.addColumn(colu[i]);
		};
		
		// Data
		String[][] rows = model.getData("cientificos");
		
		for (int i = 0; i < rows.length; i++) {
			
			Object[] row = new Object[] {rows[i][0], rows[i][1]};
			view.model.addRow(row);
		}
		
		model.closeConnection();
	}
	
	// Create
	public void createScientistsForm() {
		view.editScientistsPanel.setVisible(false);
		view.showScientistsPanelTop.setVisible(false);
		view.createScientistsPanel.setVisible(true);
	}
	
	public void createScientist() {
		model.connection();
		
		String dni = view.dni_scientist.getText();
		String nomApels = view.nomApels_scientist.getText();
		
		String query = "insert into cientificos(dni, nomApels) values ('" + dni + "', '" + nomApels + "');";
		
		model.executeQuery(query);
		model.closeConnection();
	}
	
	// Edit
	public void editScientistsForm() {
		int row = view.table.getSelectedRow();
		String dni = view.table.getModel().getValueAt(row, 0).toString();
		String nomApels = view.table.getModel().getValueAt(row, 1).toString();

		view.showScientistsPanelTop.setVisible(false);
		view.createScientistsPanel.setVisible(false);
		view.editScientistsPanel.setVisible(true);
		
		view.dni_scientist_edit.setText(dni);
		view.nomApels_scientist_edit.setText(nomApels);
	}
	
	public void editScientist() {
		model.connection();
		
		String dni = view.dni_scientist_edit.getText();
		String nomApels = view.nomApels_scientist_edit.getText();
		
		String query = "update cientificos set nomApels='" + nomApels + "'where dni='" + dni + "';";
		
		model.executeQuery(query);
		model.closeConnection();
	}
	
	// Delete
	public void deleteScientist() {
		int row = view.table.getSelectedRow();
		String dni = view.table.getModel().getValueAt(row, 0).toString();
		
		model.connection();
		
		String query = "delete from cientificos where dni = '" + dni + "';";
		
		model.executeQuery(query);
		model.closeConnection();
	}
}
