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
		this.view.btnShowProjects.addActionListener(this);
		this.view.btnCreateProjects.addActionListener(this);
		this.view.createProject.addActionListener(this);
		this.view.btnEditProjectsForm.addActionListener(this);
		this.view.btnEditProject.addActionListener(this);
		this.view.btnDeleteProjects.addActionListener(this);
		this.view.btnShowAsignados.addActionListener(this);
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
		} else if (view.btnShowProjects == e.getSource()) {
			showProjects();
		} else if (view.btnCreateProjects == e.getSource()) {
			createProjectsForm();
		} else if (view.createProject == e.getSource()) {
			createProjects();
			showProjects();
		} else if (view.btnEditProjectsForm == e.getSource()) {
			editProjectsForm();
		} else if (view.btnEditProject == e.getSource()) {
			editProject();
			showProjects();
		} else if (view.btnDeleteProjects == e.getSource()) {
			deleteProject();
			showProjects();
		} else if (view.btnShowAsignados == e.getSource()) {
			showAsignados();
		}
	}
	
	public void showAsignados() {
		view.createScientistsPanel.setVisible(false);
		view.editScientistsPanel.setVisible(false);
		view.createScientistsPanel.setVisible(false);
		view.showScientistsPanelTop.setVisible(true);
		
		view.model = new DefaultTableModel();
		view.table = new JTable(view.model);
		view.showScientistsPanel.setViewportView(view.table);
		
		model.connection();
		
		// Columns
		String[] colu = model.getColumns("asignados_a");
		for (int i = 0; i < colu.length; i++) {
			view.model.addColumn(colu[i]);
		}

		// Data
		String[][] rows = model.getData("asignados_a");

		for (int i = 0; i < rows.length; i++) {

			Object[] row = new Object[] { rows[i][0], rows[i][1], rows[i][2]};
			view.model.addRow(row);
		}
		
		model.closeConnection();
	}
	
	public void showProjects() {
		view.createScientistsPanel.setVisible(false);
		view.editScientistsPanel.setVisible(false);
		view.createScientistsPanel.setVisible(false);
		view.showScientistsPanelTop.setVisible(true);
		
		view.model = new DefaultTableModel();
		view.table = new JTable(view.model);
		view.showScientistsPanel.setViewportView(view.table);
		
		model.connection();
		
		// Columns
		String[] colu = model.getColumns("proyectos");
		for (int i = 0; i < colu.length; i++) {
			view.model.addColumn(colu[i]);
		}

		// Data
		String[][] rows = model.getData("proyectos");

		for (int i = 0; i < rows.length; i++) {

			Object[] row = new Object[] { rows[i][0], rows[i][1], rows[i][2]};
			view.model.addRow(row);
		}
		
		model.closeConnection();
	}
	
	// --- Customers table	
	// Show
	public void showScientists() {
		view.createScientistsPanel.setVisible(false);
		view.editScientistsPanel.setVisible(false);
		view.createProjectsPanel.setVisible(false);
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

	public void createProjects() {	
		model.connection();
		
		String id = view.id_projects.getText();
		String nombre = view.nombre_projects.getText();
		String horas = view.horas_projects.getText();
		
		String query = "insert into proyectos(id, nombre, horas) values ('" + id + "', '" + nombre + "', '" + horas + "');";
		
		model.executeQuery(query);
		model.closeConnection();
	}
	
	// Create Projects
	public void createProjectsForm() {
		view.editScientistsPanel.setVisible(false);
		view.showScientistsPanelTop.setVisible(false);
		view.createProjectsPanel.setVisible(true);
	}
	
	// Create Scientists
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
	public void editProjectsForm() {
		int row = view.table.getSelectedRow();
		String id = view.table.getModel().getValueAt(row, 0).toString();
		String nombre = view.table.getModel().getValueAt(row, 1).toString();
		String horas = view.table.getModel().getValueAt(row, 2).toString();
		
		view.showScientistsPanelTop.setVisible(false);
		view.createScientistsPanel.setVisible(false);
		view.createProjectsPanel.setVisible(false);
		view.editProjectsPanel.setVisible(true);
		
		view.id_projects_edit.setText(id);
		view.nombre_projects_edit.setText(nombre);
		view.horas_projects_edit.setText(horas);
	}
	
	public void editScientistsForm() {
		int row = view.table.getSelectedRow();
		String dni = view.table.getModel().getValueAt(row, 0).toString();
		String nomApels = view.table.getModel().getValueAt(row, 1).toString();

		view.showScientistsPanelTop.setVisible(false);
		view.createScientistsPanel.setVisible(false);
		view.createProjectsPanel.setVisible(false);
		view.editScientistsPanel.setVisible(true);
		
		view.dni_scientist_edit.setText(dni);
		view.nomApels_scientist_edit.setText(nomApels);
	}
	
	public void editProject() {
		model.connection();
		
		String id = view.id_projects_edit.getText();
		String nombre = view.nombre_projects_edit.getText();
		String horas = view.horas_projects_edit.getText();
		
		System.out.println(id + " " + nombre + " " + horas);
		int horasNum = Integer.parseInt(horas);
		System.out.println(horasNum);
	
		//, set horas =" + horasNum + " 
		String query = "update proyectos set nombre='" + nombre + "' where id='" + id + "';";
		String query2 = "update proyectos set horas=" + horasNum + " where id='" + id + "';";
		
		model.executeQuery(query);
		model.executeQuery(query2);
		model.closeConnection();
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
	
	public void deleteProject() {
		int row = view.table.getSelectedRow();
		String id = view.table.getModel().getValueAt(row, 0).toString();
		
		model.connection();
		
		String query = "delete from proyectos where id = '" + id + "';";
		
		model.executeQuery(query);
		model.closeConnection();
	}
}
