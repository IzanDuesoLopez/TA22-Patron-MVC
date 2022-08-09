package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import views.View;

public class Model {

	private static Connection connect;
	private int id;
	private String nombre;
	private String apellido;
	private String direccion;
	private String dni;
	private String fecha;
	
	public Model() {

	}

	// Method for connecting to the database
	public static void connectMySql() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // We use the driver
			connect = DriverManager.getConnection("jdbc:mysql://192.168.1.138:3306?useTimezone=true&serverTimezone=UTC", "local", "Local123@"); // We connect to our fedora server
			System.out.println("> You've been connected to the server <"); // We print that we've been connected
		} catch (Exception ex) { // If some code returns error
			System.out.println("> Can't connect to database <");
			System.out.println(ex);
		}
	}

	// Method for closing the connection
	public static void closeConnection() {
		try {
			connect.close(); // We close the connection
			System.out.println("> Connection ended <");
		} catch (SQLException e) {
			Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	// Method to insert data on table
	public static void insertSql(String database, String queryCreateTable) {
		// We use a try to proceed with connection, use the database, and insert the data
		try {
			connectMySql(); // We connect to MySQL
			// We use the table
			String querydatabase = "use " + database + ";";
			java.sql.Statement stdatabase = connect.createStatement();
			stdatabase.executeUpdate(querydatabase);

			// Query SQL
			java.sql.Statement st = connect.createStatement();
			st.executeUpdate(queryCreateTable);
			JOptionPane.showMessageDialog(null, "¡Operación realizada con éxito!");

			closeConnection();
			// We do a catch in case an error exists
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "¡Error ejecutando la operación!");
		}
	}
	
	// Method that get mysql values
		public void getValues(String database_name, String table, View view) {
			try {
				int contador = 0;
				connectMySql();
				String query_use = "use " + database_name + ";";
				java.sql.Statement st_use_database = connect.createStatement();
				st_use_database.executeUpdate(query_use);
				
				String result = "select * from " + table + ";";
				java.sql.Statement st_select = connect.createStatement();
				java.sql.ResultSet registers = st_select.executeQuery(result);
				
				System.out.println("\n"+table);
				// We print table registers, controlling the number of attributes that every register has
				view.textPane.setText(table+"\n");
				view.modeloTabla = new DefaultTableModel();
				view.scrollTabla = new JScrollPane();
				view.scrollTabla.setBounds(10, 176, 607, 421);
				view.tablaUsuarios = new JTable(view.modeloTabla);
				view.tablaUsuarios.setBounds(10, 20, 460, 680);
				view.modeloTabla.addColumn("ID");
				view.modeloTabla.addColumn("Nombre");
				view.modeloTabla.addColumn("Apellido");
				view.modeloTabla.addColumn("Dirección");
				view.modeloTabla.addColumn("NIF/NIE");
				view.modeloTabla.addColumn("Fecha");
				view.getContentPane().add(view.tablaUsuarios);
				
				while(registers.next()) {
					view.modeloTabla.insertRow(view.modeloTabla.getRowCount(), new Object[] { registers.getString("id"),
							registers.getString("nombre"), registers.getString("apellido"), registers.getString("direccion"),
							registers.getString("dni"), registers.getString("fecha")});
				}
				System.out.println("\n");
				
				closeConnection();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println("The data retrieve failed");
			}
		}

}
