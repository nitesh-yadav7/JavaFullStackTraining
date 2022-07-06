package jdbcConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateQuery {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection conn;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test123", "root", "ntesh7@BIRLA");
			//Establishing connection
			System.out.println("Connected With the database successfully");
			
			String query="UPDATE employee SET Name=? WHERE ID=?";
			
			PreparedStatement stmt = conn.prepareStatement(query);
			
			// take input from user
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
			
			System.out.println("Enter ID of records to update name: ");
			int id = Integer.parseInt(br.readLine());
			 
			System.out.println("Enter Employee Name: ");
			String name = br.readLine();
				
			stmt.setString(1, name);
			stmt.setInt(2, id);
				
			int result = stmt.executeUpdate();
				
			if (result > 0) {
				System.out.println("successfully updated");
			} else {
		        System.out.println("unsucessful update");
			}
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Error while connecting to the database");
			e.printStackTrace();
		}
	}
}
