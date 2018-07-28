import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class RecordTester {

	public static void main(String[] args) {
		
		String dbms = args[0];
		String db = args[1];
		String tableName = args[2];
		String type = args[3];
		String sNumRows = args[4];
		String sNumColumns = args[5];
		int numRows = 0;
		int numColumns = 0; 
		
		
		try
		{
			numRows = Integer.parseInt(sNumRows);
			numColumns = Integer.parseInt(sNumColumns);
			
			if(dbms.equals("mysql"))
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
				
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8080/"+db, "root", "");
					System.out.println("yes");
					Statement st = con.createStatement();
				
					st.executeUpdate("CREATE TABLE " + tableName +" (1  "+ type+")");
				
					for(int i = 1; i < numColumns;i++)
					{
						st.executeUpdate("ALTER TABLE " + tableName +" ADD "+ i+" "+ type);
							
					}
				
					System.out.println("Success!!");
				}
				catch(Exception e)
				{
					System.out.println("Couldnt connect to the database1");
				}
			}
		
			
		
		if(dbms.equals("sqlite"))
		{
			try
			{
				Class.forName("org.sqlite.JDBC");
				System.out.println("1");
				String url = "jdbc:sqlite:C:/sqlite/db/test.sqlite";
				System.out.println("2");
				Connection con = DriverManager.getConnection(url);
				System.out.println("3");
				Statement st = con.createStatement();
			
				st.executeUpdate("CREATE TABLE " + tableName +" (1  "+ type+")");
				System.out.println("4");
				for(int i = 1; i < numColumns;i++)
				{
					st.executeUpdate("ALTER TABLE " + tableName +" ADD "+ i+ " "+type);
					System.out.println("5");				
				}
				
				
				
				for(int i = 0; i < numRows; i++)
				{
					
				}
			
			}
			catch(Exception e)
			{
				System.out.println("Couldnt connect to the database2");
			}
		}
		

		
		}
		
		catch(Exception e)
		{
			System.out.println("Couldnt Connect");
		}
	}
}
