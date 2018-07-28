import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class IsolationTest {
	
	public static void main(String[] args) throws ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver"); 
		String url = "jdbc:mysql://localhost:3306/";
		String db = "test";
		
		Connection con1 = null;
		Connection con2 = null;
		
		try {
			con1 = DriverManager.getConnection(url + db);
			con2 = DriverManager.getConnection(url +db);
			Statement stmt1 = con1.createStatement();
			Statement stmt2 = con2.createStatement();
			
			test1(stmt1,stmt2);
			con1.close();
			con2.close();
			
			con1 = DriverManager.getConnection(url + db);
			con2 = DriverManager.getConnection(url +db);
			Statement stmt1a = con1.createStatement();
			Statement stmt2a = con2.createStatement();
			
			test2(stmt2a, stmt1a);
			con1.close();
			con2.close();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}		
	}
	
	
	public static void test1(Statement stm1, Statement stm2) throws Exception
	{
		stm1.executeUpdate("SET TRANSACTION ISOLATION LEVEL READ COMMITTED");
		
		System.out.println("Creating table foo in the database");
		stm2.executeUpdate("Create table foo(a integer)");
		System.out.println("Inserting elements into the table");
		stm2.executeUpdate("Insert into foo(a) values (1), (2), (3), (4), (5)");
		System.out.println("Reading the values of foo");
		ResultSet rs = stm1.executeQuery("Select * from foo");
		while(rs.next()) { 
			System.out.println(rs.getInt(1));
		}
		System.out.println("Deleting values from foo");
		stm1.executeUpdate("Delete from foo where a=1");
		System.out.println("Reading the values of foo");
		ResultSet rs1 = stm1.executeQuery("Select * from foo");
		while(rs1.next()) { 
			System.out.println(rs1.getInt(1));
		}
		
	}
	
	
	public static void test2(Statement stm1, Statement stm2) throws Exception
	{
		stm1.executeUpdate("SET TRANSACTION ISOLATION LEVEL SERIALIZABLE");
		System.out.println("Creating table foo in the database");
		stm2.executeUpdate("Create table foo(a integer)");
		System.out.println("Inserting elements into the table");
		stm2.executeUpdate("Insert into foo(a) values (1), (2), (3), (4), (5)");
		System.out.println("Reading the values of foo");
		ResultSet rs = stm1.executeQuery("Select * from foo");
		while(rs.next()) { 
			System.out.println(rs.getInt(1));
		}
		System.out.println("Deleting values from foo");
		stm1.executeUpdate("Delete from foo where a=1");
		System.out.println("Reading the values of foo");
		ResultSet rs1 = stm1.executeQuery("Select * from foo");
		while(rs1.next()) { 
			System.out.println(rs1.getInt(1));
		}
	}

}
