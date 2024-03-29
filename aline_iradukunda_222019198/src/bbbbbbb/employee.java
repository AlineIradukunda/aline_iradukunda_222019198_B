package bbbbbbb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class employee {
	private int employee_id;
	private String employee_name;
	private String address;
	private String telephone;
	private String email;
	private String position;
	public employee() {}
	public employee(int employee_id, String employee_name, String address,String telephone, String email,String position) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.position = position;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/aline_iradukunda_r_m_s";
	    String user = "222019198";
	    String password = "222019198";

	    // SQL query to insert data
	    String sql = "INSERT INTO employee ( employee_name, address, telephone, email, position ) VALUES (?,?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.employee_name);
	       preparedStatement.setString(2, this.address);
	       preparedStatement.setString(3, this.telephone);
	       preparedStatement.setString(4, this.email);
	       preparedStatement.setString(5, this.position);
	       
	        
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
			    String sql = "SELECT * FROM employee";

			    try {
			        Connection con = DriverManager.getConnection(host, user, password);
			        PreparedStatement preparedStatement = con.prepareStatement(sql);
			        return preparedStatement.executeQuery();
			    } catch (SQLException e) {
			        e.printStackTrace();
			        return null;
			    }
			}

	public void update(int inputpid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/aline_iradukunda_r_m_s";
	    String user = "222019198";
	    String password = "222019198";

	    // SQL query to update data
	    String sql = "UPDATE employee SET  employee_name= ?,address= ?, telephone= ?, email=? ,Position= ?  WHERE employee_id= ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  stm.setString(1, this.getEmployee_name());
	          stm.setString(2, this.getAddress());
	          stm.setString(3, this.getTelephone());
	          stm.setString(4, this.getEmail());
	          stm.setString(5, this.getPosition()); // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(6, inputpid);
	       
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
	public void delete(int inputpid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/aline_iradukunda_r_m_s";
	    String user = "222019198";
	    String password = "222019198";

	    // SQL query to delete data
	    String sql = "DELETE FROM employee WHERE  employee_id = ?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputpid); // Assuming there is a column named 'id' for the WHERE clause

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


