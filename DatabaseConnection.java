package jdbcConnection;

import java.sql.*;

public class DatabaseConnection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection conn;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test123", "root", "ntesh7@BIRLA");
			//Establishing connection
			System.out.println("Connected With the database successfully");
			
			String query="insert into employee(ID, Name, address) values(2,'Shreya','Bhilai')";
			
			Statement stmt = conn.createStatement();
			int result = stmt.executeUpdate(query);
			
			if (result > 0) {
				System.out.println("successfully inserted");
			} else {
	            System.out.println("unsucessful insertion ");
			}
		} catch (SQLException e) {
			System.out.println("Error while connecting to the database");
			e.printStackTrace();
		}
	}
}

