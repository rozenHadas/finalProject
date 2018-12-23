package DB;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class db_update {

	//insert data to tables

	public void insertData(Connection con) throws  FileNotFoundException, SQLException {
		
		try {
			PreparedStatement ps = null;
			String agency_id = "";
			String agency_name = "";
			String agency_url = "";
			 BufferedReader br = new BufferedReader(new FileReader("C:/Users/hadas/Desktop/������/finalProject/finalProject/Fastlane/output/agency.txt"));
			 String line = null;
		        while ((line = br.readLine() )!=null)
		        {
		        	//Make sure the line is not null, not empty, and contains 2 comma char
		        	if (line != null && !line.equals("") && line.matches(".*[,].*[,].*") && !line.contains("agency")) {
		            String tmp[] = line.split(",");
		            agency_id = tmp[0]; 
		            agency_name = tmp[1];
		            agency_url = tmp[2];
		        
		        	String query = "INSERT INTO agency (agency_id,agency_name,agency_url)"
		        			+ "VALUES (" + Integer.parseInt(agency_id) + ",' " + agency_name + "','" + agency_url + "');" ;
		        	ps = con.prepareStatement(query);
		        	ps.executeUpdate();
		        	
		        	}
		        }
		        br.close();
	        	con.close();
		       if(ps!=null) ps.close();

			
		} catch(IOException e){
				e.printStackTrace();
		
		}
	}

}
