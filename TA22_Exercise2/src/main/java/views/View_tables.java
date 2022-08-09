package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class View_tables extends JFrame{

	// Attributes.
	
	// Main panel
	public JPanel contentPane;
	
	// Right panel
	public JButton showCustomers;
	public JButton createCustomers;
	public JButton editCustomerForm;
	public JButton deleteCustomer;
	public JButton showVideos;
	public JButton createVideos;
	public JButton editVideos;
	public JButton deleteVideos;
	
	// Left panel for show customers
	public JPanel showCustomersPanelTop;
	public JScrollPane showCustomersPanel;
	public JTable table;
	public DefaultTableModel model;
	
	// Left panel for create customers
	public JPanel createCustomersPanel;
	public JTextField id_customer;
	public JTextField name_customer;
	public JTextField surname_customer;
	public JTextField address_customer;
	public JTextField dni_customer;
	public JTextField date_customer;
	public JButton createCustomer;
	
	// Left panel for edit customers
	public JPanel editCustomersPanel;
	public JTextField id_customer_edit;
	public JTextField name_customer_edit;
	public JTextField surname_customer_edit;
	public JTextField address_customer_edit;
	public JTextField dni_customer_edit;
	public JTextField date_customer_edit;
	public JButton editCustomer;
	
	// Left panel for create customers
	public JPanel createVideosPanel;
	public JTextField id_video;
	public JTextField title_video;
	public JTextField director_video;
	public JTextField cli_id_video;
	public JButton createVideo;
	
	// Left panel for edit customers
	public JPanel editVideosPanel;
	public JTextField id_video_edit;
	public JTextField title_video_edit;
	public JTextField director_video_edit;
	public JTextField cli_id_video_edit;
	public JButton editVideo;
	
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
		createCustomers = new JButton("Create");
		createCustomers.setBounds(54, 76, 89, 23);
		panelAdmin.add(createCustomers);
		
		JLabel lblNewLabel = new JLabel("Customers");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 89, 23);
		panelAdmin.add(lblNewLabel);
		
		showCustomers = new JButton("Show");
		showCustomers.setBounds(54, 45, 89, 23);
		panelAdmin.add(showCustomers);
		
		editCustomerForm = new JButton("Edit");
		editCustomerForm.setBounds(54, 107, 89, 23);
		panelAdmin.add(editCustomerForm);
		
		deleteCustomer = new JButton("Delete");
		deleteCustomer.setBounds(54, 138, 89, 23);
		panelAdmin.add(deleteCustomer);
		
		// Videos
		createVideos = new JButton("Create");
		createVideos.setBounds(54, 259, 89, 23);
		panelAdmin.add(createVideos);
		
		JLabel lblVideos = new JLabel("Videos");
		lblVideos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVideos.setBounds(10, 200, 89, 23);
		panelAdmin.add(lblVideos);
		
		showVideos = new JButton("Show");
		showVideos.setBounds(54, 228, 89, 23);
		panelAdmin.add(showVideos);
		
		editVideos = new JButton("Edit");
		editVideos.setBounds(54, 290, 89, 23);
		panelAdmin.add(editVideos);
		
		deleteVideos = new JButton("Delete");
		deleteVideos.setBounds(54, 321, 89, 23);
		panelAdmin.add(deleteVideos);
		
// ---- Left panel for button 'Show' for customers
		model = new DefaultTableModel();
		
		showCustomersPanelTop = new JPanel();
		showCustomersPanelTop.setBorder(new LineBorder(new Color(0, 0, 0)));
		showCustomersPanelTop.setBounds(10, 11, 700, 527);
		contentPane.add(showCustomersPanelTop);
		showCustomersPanelTop.setLayout(null);
		
		showCustomersPanel = new JScrollPane();
		showCustomersPanel.setBounds(10, 78, 680, 438);
		showCustomersPanelTop.add(showCustomersPanel);
		table = new JTable(model);
		showCustomersPanel.setViewportView(table);
		
		showCustomersPanelTop.setVisible(false);
		
// ---- Left panel for button 'Create' for customers
		createCustomersPanel = new JPanel();
		createCustomersPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		createCustomersPanel.setBounds(10, 11, 700, 527);
		contentPane.add(createCustomersPanel);
		createCustomersPanel.setLayout(null);
		
		// ID
		JLabel id_customer_label = new JLabel("ID");
		id_customer_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		id_customer_label.setBounds(100, 50, 80, 25);
		createCustomersPanel.add(id_customer_label);
		
		id_customer = new JTextField();
		id_customer.setBounds(180, 50, 150, 25);
		id_customer.setEditable(false);
		createCustomersPanel.add(id_customer);
		
		// Name
		JLabel name_customer_label = new JLabel("Nombre");
		name_customer_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		name_customer_label.setBounds(100, 90, 80, 25);
		createCustomersPanel.add(name_customer_label);
		
		name_customer = new JTextField();
		name_customer.setBounds(180, 90, 150, 25);
		createCustomersPanel.add(name_customer);
		
		// Surname
		JLabel surname_customer_label = new JLabel("Apellido");
		surname_customer_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		surname_customer_label.setBounds(100, 130, 80, 25);
		createCustomersPanel.add(surname_customer_label);
		
		surname_customer = new JTextField();
		surname_customer.setBounds(180, 130, 150, 25);
		createCustomersPanel.add(surname_customer);
		
		// Address
		JLabel address_customer_label = new JLabel("Direccion");
		address_customer_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		address_customer_label.setBounds(360, 50, 80, 25);
		createCustomersPanel.add(address_customer_label);
		
		address_customer = new JTextField();
		address_customer.setBounds(440, 50, 150, 25);
		createCustomersPanel.add(address_customer);
		
		// DNI
		JLabel dni_customer_label = new JLabel("DNI");
		dni_customer_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dni_customer_label.setBounds(360, 90, 80, 25);
		createCustomersPanel.add(dni_customer_label);
		
		dni_customer = new JTextField();
		dni_customer.setBounds(440, 90, 150, 25);
		createCustomersPanel.add(dni_customer);
		
		// Date
		JLabel fecha_customer_label = new JLabel("Fecha");
		fecha_customer_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fecha_customer_label.setBounds(360, 130, 80, 25);
		createCustomersPanel.add(fecha_customer_label);
		
		date_customer = new JTextField();
		date_customer.setBounds(440, 130, 150, 25);
		createCustomersPanel.add(date_customer);
		
		// Accept button for create
		createCustomer = new JButton("Aceptar");
		createCustomer.setBounds(300, 200, 80, 25);
		createCustomersPanel.add(createCustomer);
		
// ---- Left panel for button 'Edit' for customers
		editCustomersPanel = new JPanel();
		editCustomersPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		editCustomersPanel.setBounds(10, 11, 700, 527);
		contentPane.add(editCustomersPanel);
		editCustomersPanel.setLayout(null);
		
		// ID
		JLabel id_customer_label_edit = new JLabel("ID");
		id_customer_label_edit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		id_customer_label_edit.setBounds(100, 50, 80, 25);
		editCustomersPanel.add(id_customer_label_edit);
		
		id_customer_edit = new JTextField();
		id_customer_edit.setBounds(180, 50, 150, 25);
		id_customer_edit.setEditable(false);
		editCustomersPanel.add(id_customer_edit);
		
		// Name
		JLabel name_customer_label_edit = new JLabel("Nombre");
		name_customer_label_edit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		name_customer_label_edit.setBounds(100, 90, 80, 25);
		editCustomersPanel.add(name_customer_label_edit);
		
		name_customer_edit = new JTextField();
		name_customer_edit.setBounds(180, 90, 150, 25);
		editCustomersPanel.add(name_customer_edit);
		
		// Surname
		JLabel surname_customer_label_edit = new JLabel("Apellido");
		surname_customer_label_edit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		surname_customer_label_edit.setBounds(100, 130, 80, 25);
		editCustomersPanel.add(surname_customer_label_edit);
		
		surname_customer_edit = new JTextField();
		surname_customer_edit.setBounds(180, 130, 150, 25);
		editCustomersPanel.add(surname_customer_edit);
		
		// Address
		JLabel address_customer_label_edit = new JLabel("Direccion");
		address_customer_label_edit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		address_customer_label_edit.setBounds(360, 50, 80, 25);
		editCustomersPanel.add(address_customer_label_edit);
		
		address_customer_edit = new JTextField();
		address_customer_edit.setBounds(440, 50, 150, 25);
		editCustomersPanel.add(address_customer_edit);
		
		// DNI
		JLabel dni_customer_label_edit = new JLabel("DNI");
		dni_customer_label_edit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dni_customer_label_edit.setBounds(360, 90, 80, 25);
		editCustomersPanel.add(dni_customer_label_edit);
		
		dni_customer_edit = new JTextField();
		dni_customer_edit.setBounds(440, 90, 150, 25);
		editCustomersPanel.add(dni_customer_edit);
		
		// Date
		JLabel fecha_customer_label_edit = new JLabel("Fecha");
		fecha_customer_label_edit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fecha_customer_label_edit.setBounds(360, 130, 80, 25);
		editCustomersPanel.add(fecha_customer_label_edit);
		
		date_customer_edit = new JTextField();
		date_customer_edit.setBounds(440, 130, 150, 25);
		editCustomersPanel.add(date_customer_edit);
		
		// Accept button for create
		editCustomer = new JButton("Aceptar");
		editCustomer.setBounds(300, 200, 80, 25);
		editCustomersPanel.add(editCustomer);
		
// ---- Left panel for button 'Create' for videos
		createVideosPanel = new JPanel();
		createVideosPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		createVideosPanel.setBounds(10, 11, 700, 527);
		contentPane.add(createVideosPanel);
		createVideosPanel.setLayout(null);
		
		// ID
		JLabel id_video_label = new JLabel("ID");
		id_video_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		id_video_label.setBounds(100, 50, 80, 25);
		createVideosPanel.add(id_video_label);
		
		id_video = new JTextField();
		id_video.setBounds(180, 50, 150, 25);
		id_video.setEditable(false);
		createVideosPanel.add(id_video);
		
		// Title
		JLabel title_video_label = new JLabel("Title");
		title_video_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		title_video_label.setBounds(100, 90, 80, 25);
		createVideosPanel.add(title_video_label);
		
		title_video = new JTextField();
		title_video.setBounds(180, 90, 150, 25);
		createVideosPanel.add(title_video);
		
		// Director
		JLabel director_video_label = new JLabel("Director");
		director_video_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		director_video_label.setBounds(100, 130, 80, 25);
		createVideosPanel.add(director_video_label);
		
		director_video = new JTextField();
		director_video.setBounds(180, 130, 150, 25);
		createVideosPanel.add(director_video);
		
		// cli_id
		JLabel cli_id_video_label = new JLabel("cli_id");
		cli_id_video_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cli_id_video_label.setBounds(100, 170, 80, 25);
		createVideosPanel.add(cli_id_video_label);
		
		cli_id_video = new JTextField();
		cli_id_video.setBounds(180, 170, 150, 25);
		createVideosPanel.add(cli_id_video);
		
		// Accept button for create
		createVideo = new JButton("Aceptar");
		createVideo.setBounds(300, 220, 80, 25);
		createVideosPanel.add(createVideo);
		
// ---- Left panel for button 'Edit' for videos
		editVideosPanel = new JPanel();
		editVideosPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		editVideosPanel.setBounds(10, 11, 700, 527);
		contentPane.add(editVideosPanel);
		editVideosPanel.setLayout(null);
		
		// ID
		JLabel id_video_label_edit = new JLabel("ID");
		id_video_label_edit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		id_video_label_edit.setBounds(100, 50, 80, 25);
		editVideosPanel.add(id_video_label_edit);
		
		id_video_edit = new JTextField();
		id_video_edit.setBounds(180, 50, 150, 25);
		id_video_edit.setEditable(false);
		editVideosPanel.add(id_video_edit);
		
		// Title
		JLabel title_video_label_edit = new JLabel("Title");
		title_video_label_edit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		title_video_label_edit.setBounds(100, 90, 80, 25);
		editVideosPanel.add(title_video_label_edit);
		
		title_video_edit = new JTextField();
		title_video_edit.setBounds(180, 90, 150, 25);
		editVideosPanel.add(title_video_edit);
		
		// Director
		JLabel director_video_label_edit = new JLabel("Director");
		director_video_label_edit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		director_video_label_edit.setBounds(100, 130, 80, 25);
		editVideosPanel.add(director_video_label_edit);
		
		director_video_edit = new JTextField();
		director_video_edit.setBounds(180, 130, 150, 25);
		editVideosPanel.add(director_video_edit);
		
		// cli_id
		JLabel cli_id_video_label_edit = new JLabel("cli_id");
		cli_id_video_label_edit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cli_id_video_label_edit.setBounds(100, 170, 80, 25);
		editVideosPanel.add(cli_id_video_label_edit);
		
		cli_id_video_edit = new JTextField();
		cli_id_video_edit.setBounds(180, 170, 150, 25);
		editVideosPanel.add(cli_id_video_edit);
		
		// Accept button for create
		editVideo = new JButton("Aceptar");
		editVideo.setBounds(300, 220, 80, 25);
		editVideosPanel.add(editVideo);
	}
}
