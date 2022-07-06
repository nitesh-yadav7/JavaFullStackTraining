package jdbcConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetEmployee {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection conn;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test123", "root", "ntesh7@BIRLA");
			//Establishing connection
			System.out.println("Connected With the database successfully");
			
            String query="SELECT * FROM Emp WHERE ID=?";
			
			PreparedStatement stmt = conn.prepareStatement(query);
			
			// take input from user
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
			System.out.println("Enter Employee ID: ");
			int n = Integer.parseInt(br.readLine());
				
			stmt.setInt(1, n);
			
			ResultSet result = stmt.executeQuery();
			
			System.out.println("ID\tName\tSalary\tCompany\tAge");
			while (result.next()) {
				int id = result.getInt("ID");
				String name = result.getString("Name");
				int salary = result.getInt("Salary");
				String company = result.getString("Company");
				int age = result.getInt("Age");
				System.out.println(id+"\t"+name+"\t"+salary+"\t"+company+"\t"+age);
			}
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}
}
