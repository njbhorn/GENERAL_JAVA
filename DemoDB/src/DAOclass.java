import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOclass implements Serializable{
	private static final long serialVersionUID = 1L;
	public String getData( String ID )	{
		String holder = "Not found" ;
		try		{
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con = DriverManager.getConnection( 
						"jdbc:mysql://localhost:3306/demo" 
						, "root" 
						, "Pa$$w0rd" );
			Statement stat = con.createStatement();
			ResultSet res = stat.executeQuery( "select * from account" );
			if ( res.next() ) 
			{
				holder =  res.getString( "holder" ) ;
			}
			res.close() ;	// CLOSE THE OBJECTS IN THIS ORDER
			stat.close() ;
			con.close() ;
		}
		catch ( SQLException exception )		{
			System.out.println(exception.getMessage());
		}
		catch (ClassNotFoundException e) 		{
			e.printStackTrace();
		}	
		return holder ;
	}
}