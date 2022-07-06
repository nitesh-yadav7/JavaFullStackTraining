package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetHighPaidEmployees {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection conn;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test123", "root", "ntesh7@BIRLA");
			//Establishing connection
			System.out.println("Connected With the database successfully");
			
            String query="SELECT Name FROM Emp WHERE SALARY > 150000";
			
			PreparedStatement stmt = conn.prepareStatement(query);
			
			ResultSet result = stmt.executeQuery();
			
			System.out.println("Employees having salary greater than 1.5 Lacs");
			while (result.next()) {
				String name = result.getString("Name");
				System.out.println(name);
			}
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}
}
