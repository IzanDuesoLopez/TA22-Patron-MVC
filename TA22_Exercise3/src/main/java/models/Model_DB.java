package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class Model_DB {
	private static Connection con;
	private final String user = "local";
	private final String pass = "Local123@";
	private final String ip = "jdbc:mysql://192.168.1.138:3306/C4_UD22_03";
	
	public Model_DB() {

	}
	
	/**
	 * Creates a connection
	 */
	public void connection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(ip, user, pass);
//			JOptionPane.showMessageDialog(null, "Successfull connection.");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERROR MESSAGE", 0);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Error charging the Driver for MySQL connection.");
			System.out.println("Message: " + e.getMessage() + "Cause: " + e.getCause());
		}
	}
	
	/**
	 * Closes a connection
	 */
	public void closeConnection(){

		try {
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "ERROR MESSAGE", 0);
		}
	}
	
	/**
	 * Executes querys.
	 * 
	 * @param con
	 * @param dbName
	 * @param query
	 */
	public void executeQuery(String query){
		try {
			Statement st = con.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String[] getColumns(String tableName) {
		try {
			Statement st = con.createStatement();
			ResultSet results = st.executeQuery("SELECT * FROM " + tableName + ";");
			ResultSetMetaData metadata = (ResultSetMetaData) results.getMetaData();
			int columnCount = metadata.getColumnCount();
			String[] columnNames = new String[columnCount];
			
			for (int i = 1; i <= columnCount; i++) {
				columnNames[i-1] = metadata.getColumnName(i);
			}
			return columnNames;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public String[][] getData(String tableName) {
		try {
			Statement st0 = con.createStatement();
			ResultSet results0 = st0.executeQuery("SELECT * FROM " + tableName + ";");
			ResultSetMetaData metadata = (ResultSetMetaData) results0.getMetaData();
			int columnCount = metadata.getColumnCount();
			
			Statement st = con.createStatement();
			ResultSet results = st.executeQuery("SELECT * FROM " + tableName + ";");

			int count = 0;
			while(results.next()) {
				count ++;
			}
			
			Statement st1 = con.createStatement();
			ResultSet results1 = st1.executeQuery("SELECT * FROM " + tableName + ";");
			
			String[][] data = new String[count][columnCount];
			
			int cont = 0;
			if(tableName.equals("cientificos")) {
				while(results1.next()) {
					data[cont][0] = results1.getString("dni");
					data[cont][1] = results1.getString("nomApels");
					cont++;
				}
				return data;	
			} else if (tableName.equals("proyectos")) {
				while(results1.next()) {
					data[cont][0] = results1.getString("id");
					data[cont][1] = results1.getString("nombre");
					data[cont][2] = results1.getString("horas");
					cont++;
				}
				return data;
			} else if (tableName.equals("asignados_a")) {
				while(results1.next()) {
					data[cont][0] = results1.getString("idAuto");
					data[cont][1] = results1.getString("cientifico");
					data[cont][2] = results1.getString("proyecto");
					cont++;
				}
				return data;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
