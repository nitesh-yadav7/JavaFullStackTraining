package jdbcConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedQuery {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection conn;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test123", "root", "ntesh7@BIRLA");
			//Establishing connection
			System.out.println("Connected With the database successfully");
			
			String query="insert into employee(ID, Name, address) values(?,?,?)";
			
			PreparedStatement stmt = conn.prepareStatement(query);
			
			// take input from user
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
			
			System.out.println("Enter number of records to insert: ");
			int n = Integer.parseInt(br.readLine());
			
			while (n > 0) {
				System.out.println("Enter Employee ID: ");
				int id = Integer.parseInt(br.readLine());  
				System.out.println("Enter Employee Name: ");
				String name = br.readLine();
				System.out.println("Enter Employee Address: ");
				String address = br.readLine();
				
				stmt.setInt(1, id);
				stmt.setString(2, name);
				stmt.setString(3, address);
				
				int result = stmt.executeUpdate();
				
				if (result > 0) {
					System.out.println("successfully inserted");
				} else {
		            System.out.println("unsucessful insertion ");
				}
				n--;
			}
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Error while connecting to the database");
			e.printStackTrace();
		}
	}
}

