package jdbcConnection;

import java.sql.*;
import java.util.*;

public class SelectDataQuery {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection conn;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test123", "root", "ntesh7@BIRLA");
			//Establishing connection
			System.out.println("Connected With the database successfully");
			
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM Employee");
			
			ArrayList<ArrayList<String>> rlist = new ArrayList<ArrayList<String>>();
			ArrayList<String> list = new ArrayList<String>();
			
			System.out.println("ID\tName\tEmployee");
			while (result.next()) {
				list.clear();
				int id = result.getInt("ID");
				String name = result.getString("Name");
				String address = result.getString("Address");
				System.out.println(id+"\t"+name+"\t"+address);
				list.add(String.valueOf(id)+", "+name+", "+address);
				rlist.add(list);
			}
			
			System.out.println("arraylist: " + rlist);
			
			conn.close();
			
		} catch (SQLException e) {
			System.out.println("Error while connecting to the database");
			e.printStackTrace();
		}
	}
}

