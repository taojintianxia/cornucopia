import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 
 * 
 * @author Kane.Sun
 * @version Aug 28, 2013 11:10:31 AM
 * 
 */
public class Test {

	public static void main(String... args) throws Exception {
		Connection conn = null;
		
		try {
		    conn =
		       DriverManager.getConnection("jdbc:mysql://localhost/rockblade?" +
		                                   "user=root&password=root");
		    // Do something with the Connection
		   
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}

		// assume that conn is an already created JDBC connection (see previous examples)
		Statement stmt = null;
		ResultSet rs = null;
		try {
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery("SELECT * FROM stockdetail");
		    // or alternatively, if you don't know ahead of time that
		    // the query will be a SELECT...
		    while(rs.next())
		    {
		    int result=rs.getInt("stockid");
		    System.out.println(result);
		    }
		}
		catch (SQLException ex){
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally {
		    // it is a good idea to release
		    // resources in a finally{} block
		    // in reverse-order of their creation
		    // if they are no-longer needed
		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException sqlEx) { } // ignore
		        rs = null;
		    }
		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException sqlEx) { } // ignore
		        stmt = null;
		    }
		}
	}

}
