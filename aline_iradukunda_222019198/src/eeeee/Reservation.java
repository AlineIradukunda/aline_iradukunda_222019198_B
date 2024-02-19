package eeeee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Reservation {
	private int reservation_id;
	private String customer_id;
	private String reservation_time;
	private String table_number;

	public Reservation() {}
	public Reservation(int reservation_id, String customer_id, String reservation_time,String table_number) {
		super();
		this.reservation_id = reservation_id;
		this.customer_id = customer_id;
		this.reservation_time = reservation_time;
		this.table_number = table_number;
		
}
	public int getReservation_id() {
		return reservation_id;
	}
	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getReservation_time() {
		return reservation_time;
	}
	public void setReservation_time(String reservation_time) {
		this.reservation_time = reservation_time;
	}
	public String getTable_number() {
		return table_number;
	}
	public void setTable_number(String table_number) {
		this.table_number = table_number;
	}
	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/aline_iradukunda_r_m_s";
	    String user = "222019198";
	    String password = "222019198";

	    // SQL query to insert data
	    String sql = "INSERT INTO reservation (customer_id, reservation_time, table_number) VALUES (?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.customer_id);
	       preparedStatement.setString(2, this.reservation_time);
	       preparedStatement.setString(3, this.table_number);
	       
	       
	        
	        // Execute the query
	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	System.out.println("Data insert successfully!");
	            JOptionPane.showMessageDialog(null, "Data insert successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to register data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }}
	 
			public static ResultSet viewData() {
			    String host = "jdbc:mysql://localhost/aline_iradukunda_r_m_s";
			    String user = "222019198";
			    String password = "222019198";

			    String sql = "SELECT * FROM reservation";

			    try {
			        Connection con = DriverManager.getConnection(host, user, password);
			        PreparedStatement preparedStatement = con.prepareStatement(sql);
			        return preparedStatement.executeQuery();
			    } catch (SQLException e) {
			        e.printStackTrace();
			        return null;
			    }
			}

	public void update(int inputreservation_id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/aline_iradukunda_r_m_s";
	    String user = "222019198";
	    String password = "222019198";

	    // SQL query to update data
	    String sql = "UPDATE reservation SET  customer_id= ?,reservation_time= ?, table_number= ? WHERE reservation_id= ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  stm.setString(1, this.getCustomer_id());
	          stm.setString(2, this.getReservation_time());
	          stm.setString(3, this.getTable_number());
	           // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(4, inputreservation_id);
	       
	        // Execute the update
	        int rowsAffected = stm.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data updated successfully!");
	            JOptionPane.showMessageDialog(null, "Data updated successfully!!","After update",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to update data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }   
	}
	public void delete(int inputreservation_id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/aline_iradukunda_r_m_s";
	    String user = "222019198";
	    String password = "222019198";

	    // SQL query to delete data
	    String sql = "DELETE FROM reservation WHERE  reservation_id = ?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputreservation_id); // Assuming there is a column named 'id' for the WHERE clause

	        // Execute the delete
	        int rowsAffected = pl.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data deleted successfully!");
	            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to delete data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	
	}
}





