package jdbcConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeQuery {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection conn;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test123", "root", "ntesh7@BIRLA");
			//Establishing connection
			System.out.println("Connected With the database successfully");
			
			String query1 = "CREATE TABLE IF NOT EXISTS Emp(ID INT PRIMARY KEY, Name VARCHAR(20), Salary BIGINT, Company VARCHAR(20), Age INT);";
			Statement createStmt = conn.createStatement();
			createStmt.executeUpdate(query1);
			
			String query2="insert into emp(ID, Name, Salary, Company, Age) values(?,?,?,?,?)";
			
			PreparedStatement insertStmt = conn.prepareStatement(query2);
			
			// take input from user
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
			
			System.out.println("Enter number of records to insert: ");
			int n = Integer.parseInt(br.readLine());
			
			while (n > 0) {
				System.out.println("Enter Employee ID: ");
				int id = Integer.parseInt(br.readLine());  
				System.out.println("Enter Employee Name: ");
				String name = br.readLine();
				System.out.println("Enter Employee Salary: ");
				int sal = Integer.parseInt(br.readLine());
				System.out.println("Enter Employee Company: ");
				String company = br.readLine();
				System.out.println("Enter Employee Age: ");
				int age = Integer.parseInt(br.readLine());
				
				insertStmt.setInt(1, id);
				insertStmt.setString(2, name);
				insertStmt.setInt(3, sal);
				insertStmt.setString(4, company);
				insertStmt.setInt(5, age);
				
				int result = insertStmt.executeUpdate();
				
				if (result > 0) {
					System.out.println("successfully inserted");
				} else {
		            System.out.println("unsucessful insertion ");
				}
				n--;
			}
			
			Statement queryStmt = conn.createStatement();
			ResultSet result = queryStmt.executeQuery("SELECT * FROM Emp");

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
			System.out.println("Error while connecting to the database");
			e.printStackTrace();
		}
	}
}
