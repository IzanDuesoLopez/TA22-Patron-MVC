package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class View_tables extends JFrame{

	// Attributes.
	
	// Main panel
	public JPanel contentPane;
	
	// Right panel
	public JButton showScientists;
	public JButton createScientists;
	public JButton editScientistsForm;
	public JButton deleteScientist;
	
	// Left panel for show scientists
	public JPanel showScientistsPanelTop;
	public JScrollPane showScientistsPanel;
	public JTable table;
	public DefaultTableModel model;
	
	// Left panel for create scientists
	public JPanel createScientistsPanel;
	public JTextField dni_scientist;
	public JTextField nomApels_scientist;
	public JButton createScientist;
	
	// Left panel for edit scientists
	public JPanel editScientistsPanel;
	public JTextField dni_scientist_edit;
	public JTextField nomApels_scientist_edit;
	public JButton editScientist;
	
	// Right panel Projects
	public JButton btnCreateProjects;
	public JButton btnEditProjectsForm;
	public JButton btnDeleteProjects;
	public JButton btnShowProjects;

	
	public View_tables() {
		
		// Parameters of the main window.
		setBounds(400, 200, 951, 588);
		
// ---- Creating the Jpanel that will contain the components.
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
// ---- Right panel containing all the buttons to perform the actions.
		JPanel panelAdmin = new JPanel();
		panelAdmin.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelAdmin.setBounds(722, 11, 203, 527);
		contentPane.add(panelAdmin);
		panelAdmin.setLayout(null);
		
		// Customers
		createScientists = new JButton("Create");
		createScientists.setBounds(54, 76, 89, 23);
		panelAdmin.add(createScientists);
		
		JLabel lblNewLabel = new JLabel("Scientists");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 89, 23);
		panelAdmin.add(lblNewLabel);
		
		showScientists = new JButton("Show");
		showScientists.setBounds(54, 45, 89, 23);
		panelAdmin.add(showScientists);
		
		editScientistsForm = new JButton("Edit");
		editScientistsForm.setBounds(54, 107, 89, 23);
		panelAdmin.add(editScientistsForm);
		
		deleteScientist = new JButton("Delete");
		deleteScientist.setBounds(54, 138, 89, 23);
		panelAdmin.add(deleteScientist);
		
		JLabel lblProject = new JLabel("Projects");
		lblProject.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProject.setBounds(10, 172, 89, 23);
		panelAdmin.add(lblProject);
		
		btnShowProjects = new JButton("Show");
		btnShowProjects.setBounds(54, 199, 89, 23);
		panelAdmin.add(btnShowProjects);
		
		btnCreateProjects = new JButton("Create");
		btnCreateProjects.setBounds(54, 228, 89, 23);
		panelAdmin.add(btnCreateProjects);
		
		btnEditProjectsForm = new JButton("Edit");
		btnEditProjectsForm.setBounds(54, 256, 89, 23);
		panelAdmin.add(btnEditProjectsForm);
		
		btnDeleteProjects = new JButton("Delete");
		btnDeleteProjects.setBounds(54, 283, 89, 23);
		panelAdmin.add(btnDeleteProjects);
		
// ---- Left panel for button 'Show' for scientists
		model = new DefaultTableModel();
		
		showScientistsPanelTop = new JPanel();
		showScientistsPanelTop.setBorder(new LineBorder(new Color(0, 0, 0)));
		showScientistsPanelTop.setBounds(10, 11, 700, 527);
		contentPane.add(showScientistsPanelTop);
		showScientistsPanelTop.setLayout(null);
		
		showScientistsPanel = new JScrollPane();
		showScientistsPanel.setBounds(10, 78, 680, 438);
		showScientistsPanelTop.add(showScientistsPanel);
		table = new JTable(model);
		showScientistsPanel.setViewportView(table);
		
		showScientistsPanelTop.setVisible(false);
		
		// Left panel for button 'Show' for projects
//		model = new DefaultTableModel();
//
//		showProjectsPanelTop = new JPanel();
//		showProjectsPanelTop.setBorder(new LineBorder(new Color(0, 0, 0)));
//		showProjectsPanelTop.setBounds(10, 11, 700, 527);
//		contentPane.add(showProjectsPanelTop);
//		showProjectsPanelTop.setLayout(null);
//
//		showProjectsPanel = new JScrollPane();
//		showProjectsPanel.setBounds(10, 78, 680, 438);
//		showProjectsPanelTop.add(showProjectsPanel);
//		table = new JTable(model);
//		showProjectsPanel.setViewportView(table);
//
//		showProjectsPanel.setVisible(false);
		
// ---- Left panel for button 'Create' for scientists
		createScientistsPanel = new JPanel();
		createScientistsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		createScientistsPanel.setBounds(10, 11, 700, 527);
		contentPane.add(createScientistsPanel);
		createScientistsPanel.setLayout(null);
		
		// DNI
		JLabel id_scientist_label = new JLabel("DNI");
		id_scientist_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		id_scientist_label.setBounds(100, 50, 80, 25);
		createScientistsPanel.add(id_scientist_label);
		
		dni_scientist = new JTextField();
		dni_scientist.setBounds(180, 50, 150, 25);
		dni_scientist.setEditable(true);
		createScientistsPanel.add(dni_scientist);
		
		// nomApels
		JLabel name_scientist_label = new JLabel("Nombre");
		name_scientist_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		name_scientist_label.setBounds(100, 90, 80, 25);
		createScientistsPanel.add(name_scientist_label);
		
		nomApels_scientist = new JTextField();
		nomApels_scientist.setBounds(180, 90, 150, 25);
		createScientistsPanel.add(nomApels_scientist);
		
		// Accept button for create
		createScientist = new JButton("Aceptar");
		createScientist.setBounds(300, 200, 80, 25);
		createScientistsPanel.add(createScientist);
				
		// ---- Left panel for button 'Edit' for customers
		editScientistsPanel = new JPanel();
		editScientistsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		editScientistsPanel.setBounds(10, 11, 700, 527);
		contentPane.add(editScientistsPanel);
		editScientistsPanel.setLayout(null);
		
		// DNI
		JLabel dni_scientist_label_edit = new JLabel("ID");
		dni_scientist_label_edit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dni_scientist_label_edit.setBounds(100, 50, 80, 25);
		editScientistsPanel.add(dni_scientist_label_edit);
		
		dni_scientist_edit = new JTextField();
		dni_scientist_edit.setBounds(180, 50, 150, 25);
		dni_scientist_edit.setEditable(true);
		editScientistsPanel.add(dni_scientist_edit);
		
		// nomApels
		JLabel nomApels_scientist_label_edit = new JLabel("Nombre");
		nomApels_scientist_label_edit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nomApels_scientist_label_edit.setBounds(100, 90, 80, 25);
		editScientistsPanel.add(nomApels_scientist_label_edit);
		
		nomApels_scientist_edit = new JTextField();
		nomApels_scientist_edit.setBounds(180, 90, 150, 25);
		editScientistsPanel.add(nomApels_scientist_edit);
		
		// Accept button for create
		editScientist = new JButton("Aceptar");
		editScientist.setBounds(300, 200, 80, 25);
		editScientistsPanel.add(editScientist);
	}
}
