package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class db_connect {
	
	private static Connection con = null;
	private static Statement stmt  = null;
	private static ResultSet rs = null;
	
	//create connection
	public void createConnection() {
		
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "erutyhv5";
        try {
        	con = DriverManager.getConnection(url, user, password);
        /*	st = con.createStatement();
        	rs = st.executeQuery("SELECT VERSION()");
        	 if (rs.next()) {
                 System.out.println(rs.getString(1));
             }*/
            
        } catch (SQLException ex) {
        
            Logger lgr = Logger.getLogger(db_download.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        
	}
	
	public Statement getStatement() {
			try {
				return con.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
	public ResultSet getResult(String sql) {
		try {
			//maybe change to stmt.getResultSet();
			return stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return null;
	}
	
	public void disconnect() throws SQLException {
		con.close();
	}
	public void closeStmt() throws SQLException {
		stmt.close();
	}

	

}
