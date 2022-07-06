package jdbcConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeManager {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test123", "root", "ntesh7@BIRLA");
		//Establishing connection
		System.out.println("Connected With the database successfully");

		// createDB if not exists
		createDB(conn);
		
		// initiate buffer reader for taking user inputs
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 		
		
		// Menu interface
		while (true) {
			System.out.println("+-----------------------------------------+");
			System.out.println("|    Welcome to Employee Management App   |");
			System.out.println("+-----------------------------------------+");
			System.out.println("Press 1 to Get Employee Details");
			System.out.println("Press 2 to Insert Employee Details");
			System.out.println("Press 3 to Update Employee Details");
			System.out.println("Press 4 to Delete Employee Details");
			System.out.println("Press 5 to Exit");
			System.out.println("Enter Your Choice: ");
			String choice = br.readLine();
			
			switch (choice) {
				case "1": getEmployee(conn, br);
			            break;
				case "2": insertEmployee(conn, br);
						break;
				case "3": updateEmployee(conn, br);
						break;
				case "4": deleteEmployee(conn, br);
						break;
				case "5": conn.close();
				        br.close();
						System.exit(0);
				        break;
				default: System.out.println("Incorrect Choice! Try Again.");
			}
			
			for (int i = 0; i < 4; ++i) System.out.println("----------------------------------------------");
		}
	
	}
	
	// create database
	public static void createDB(Connection conn) throws SQLException {	
		String query1 = "CREATE TABLE IF NOT EXISTS EmpManager(ID INT PRIMARY KEY, Name VARCHAR(20), Mobile VARCHAR(20), Email VARCHAR(20), Address VARCHAR(20));";
		Statement createStmt = conn.createStatement();
		createStmt.executeUpdate(query1);
	}
	
	// select
	public static void getEmployee(Connection conn, BufferedReader br) throws SQLException, NumberFormatException, IOException {
		// String query="SELECT * FROM EmpManager WHERE Name=?"
		String query = "{CALL getEmployeeByName(?)}";
		
		// PreparedStatement stmt = conn.prepareStatement(query);
		CallableStatement stmt = conn.prepareCall(query);
		
		System.out.println("Enter Employee Name to get Details: ");
		// String name = br.readLine();
		String emp_name = br.readLine();	
		
		// stmt.setString(1, name);
		stmt.setString(1, emp_name);
		ResultSet result = stmt.executeQuery();
		
		if (!result.isBeforeFirst()) {
			System.out.println("No Records Found!");
			return;
		}
		
		System.out.println("ID\tName\tMobile\tEmail\tAddress");
		while (result.next()) {
			int id = result.getInt("ID");
			String name = result.getString("Name");
			String mob = result.getString("Mobile");
			String email = result.getString("Email");
			String add = result.getString("Address");
			System.out.println(id+"\t"+name+"\t"+mob+"\t"+email+"\t"+add);
		}
	}
	
	// insert
	public static void insertEmployee(Connection conn, BufferedReader br) throws SQLException, NumberFormatException, IOException {
		String query="Insert into EmpManager(ID, Name, Mobile, Email, Address) values(?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(query);
		
		System.out.println("Enter number of records to insert: ");
		int n = Integer.parseInt(br.readLine());
		
		while (n > 0) {
			System.out.println("Enter ID: ");
			int id = Integer.parseInt(br.readLine());  
			System.out.println("Enter Name: ");
			String name = br.readLine();
			System.out.println("Enter Mobile: ");
			String mob = br.readLine();
			System.out.println("Enter Email: ");
			String email = br.readLine();
			System.out.println("Enter Address: ");
			String add = br.readLine();
			
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setString(3, mob);
			stmt.setString(4, email);
			stmt.setString(5, add);
			
			int result = stmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("Successfully Inserted Employee Details");
				System.out.println("------------------------------------------");
			} else {
	            System.out.println("Data Not Inserted");
			}
			n--;
		}
	}
	
	// update
	public static void updateEmployee(Connection conn, BufferedReader br) throws SQLException, NumberFormatException, IOException {
		
		// String query="UPDATE empmanager SET Name=? WHERE ID=?";
		String query = "{CALL updateEmployeeName(?,?)}";
		
		//PreparedStatement stmt = conn.prepareStatement(query);
		CallableStatement stmt = conn.prepareCall(query);
		
		System.out.println("Enter ID to Update Name: ");
		int id = Integer.parseInt(br.readLine());
		 
		System.out.println("Enter New Name: ");
		String name = br.readLine();
		
		//stmt.setString(1, name);
		//stmt.setInt(2, id);
		stmt.setInt(1, id);
		stmt.setString(2, name);
			
		int result = stmt.executeUpdate();
			
		if (result > 0) {
			System.out.println("Successfully Updated Employee Details");
		} else {
	        System.out.println("Data Not Updated");
		}
	}
	
	// delete
	public static void deleteEmployee(Connection conn, BufferedReader br) throws SQLException, NumberFormatException, IOException {
		
		// String query="DELETE FROM empmanager WHERE ID=?";
		String query = "{CALL deleteEmployeeById(?)}";
		
		// PreparedStatement stmt = conn.prepareStatement(query);
		CallableStatement stmt = conn.prepareCall(query);
		
		System.out.println("Enter ID to Delete: ");
		int id = Integer.parseInt(br.readLine());
			
		stmt.setInt(1, id);
		
		System.out.println("Enter yes to proceed: ");
		String confirmation = br.readLine();

		int result = 0;
		if (confirmation.toLowerCase().equals("yes")) {
			result = stmt.executeUpdate();
		}
			
		if (result > 0) {
			System.out.println("Successfully Deleted Employee Details");
		} else {
	        System.out.println("Data Not Deleted");
		}
	}
}

/* Develop a Console base Application for Employee Records 
 * Management in java as per given scenario 
 * Create Employee table in Database using Java Program.
 *  Table should contain ID, Name, Mobile, Email, Address Columns.
 *  User Should be welcome with a greeting message 
 *  Ask users choice for data manipulation such As Insert, 
 *  Update, Delete, Select As per selected choice user should 
 *  be able to perform desired tasks. Take all input from users
 *  only. Delete and Update should be done on basis of ID only,
 *  retrieval of data should be done on basis of name
*/
