package jdbcConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteQuery {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection conn;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test123", "root", "ntesh7@BIRLA");
			//Establishing connection
			System.out.println("Connected With the database successfully");
			
			String query="DELETE FROM employee WHERE ID=?";
			
			PreparedStatement stmt = conn.prepareStatement(query);
			
			// take input from user
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
			
			System.out.println("Enter ID of records to delete: ");
			int id = Integer.parseInt(br.readLine());
				
			stmt.setInt(1, id);
				
			int result = stmt.executeUpdate();
				
			if (result > 0) {
				System.out.println("successfully deleted");
			} else {
		        System.out.println("unsucessful delete");
			}
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Error while connecting to the database");
			e.printStackTrace();
		}
	}
}