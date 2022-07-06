import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*1. Consider a Product having Name, Price, Company in database table you have to pass this values in ArrayList using user define class and get name of the product having price >1000 ( 5 dummy entries in table)*/

public class StreamOfProducts {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection conn;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test123", "root", "ntesh7@BIRLA");
			//Establishing connection
			System.out.println("Connected With the database successfully");
			
			String query="SELECT * FROM Products";
			
			Statement stmt = conn.createStatement();
			ResultSet rst = stmt.executeQuery(query);
			
			ArrayList<Product> products = new ArrayList<Product>();
			
			while (rst.next()) {
				products.add(new Product(rst.getInt("ProductID"),rst.getString("Name"), rst.getInt("Price"), rst.getString("Company")));
			}
			
			System.out.println();
			System.out.println("Before filtering");
			System.out.println("ID  Name  Price  Company");
			products.stream().forEach(x -> System.out.println(x.ProductID +" "+ x.Name +" "+ x.Price +" "+ x.Company));
			
			List<Product> result = products.stream().filter(x -> x.Price > 2000).collect(Collectors.toList());
			
			System.out.println();
			System.out.println("After filtering");
			System.out.println("ID  Name  Price  Company");
			result.stream().forEach(x -> System.out.println(x.ProductID +" "+ x.Name +" "+ x.Price +" "+ x.Company));
			
		} catch (SQLException e) {
			System.out.println("Error while connecting to the database");
			e.printStackTrace();
		}
	}

}

class Product {
	int ProductID;
	String Name;
	int Price;
	String Company;
	
	Product(int id, String name, int price, String company) {
		this.ProductID = id;
		this.Name = name;
		this.Price = price;
		this.Company = company;
	}
}
