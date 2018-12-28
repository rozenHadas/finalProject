package DB;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class db_update {

	//insert data to tables

	public void insertData(Connection con) throws  FileNotFoundException, SQLException {
		
		insertAgency(con);
		insertRoutes(con);
		con.close();
	}

	private void insertRoutes(Connection con) throws SQLException {
		try {
			PreparedStatement ps = null;
			String route_id = "";
			String agency_id = "";
			String route_long_name = "";
			String route_desc = "";
			String route_type = "";
			String route_color = "";
			
			 BufferedReader br = new BufferedReader(new InputStreamReader(
					 new FileInputStream("C:/Users/hadas/Desktop/פרויקט/finalProject/Fastlane/output/routes.txt"), StandardCharsets.UTF_8));
			 String line = null;
		        while ((line = br.readLine() )!=null)
		        {
		        	//Make sure the line is not null, not empty, and contains 2 comma char
		        	if (line != null && !line.equals("") && line.matches(".*[,].*[,].*") && !line.contains("route")) {
		            String tmp[] = line.split(",");
		            route_id = tmp[5]; 
		            agency_id = tmp[4];
		            route_long_name = tmp[3];
		            route_desc = tmp[2];
		            route_type = tmp[1]; 
		            route_color = tmp[0];
		        
		        	String query = "INSERT INTO routes (route_id,agency_id,route_long_name,route_desc,route_type,route_color)"
		        			+ "VALUES (" + Integer.parseInt(route_id) + ",'" + agency_id 
		        			+"',' " + route_long_name + "','" + route_desc + "'," + Integer.parseInt(route_type)
		        			+"," + Integer.parseInt(route_color) + ");" ;
		        	ps = con.prepareStatement(query);
		        	ps.executeUpdate();
		        	
		        	}
		        }
		        br.close();
		       if(ps!=null) ps.close();
			
		} catch(IOException e){
				e.printStackTrace();
		
		}
	}

	private void insertAgency(Connection con) throws SQLException {
		try {
			PreparedStatement ps = null;
			String agency_id = "";
			String agency_name = "";
			String agency_url = "";
			 BufferedReader br = new BufferedReader(new InputStreamReader(
					 new FileInputStream("C:/Users/hadas/Desktop/פרויקט/finalProject/Fastlane/output/agency.txt"), StandardCharsets.UTF_8));
			 String line = null;
		        while ((line = br.readLine() )!=null)
		        {
		        	//Make sure the line is not null, not empty, and contains 2 comma char
		        	if (line != null && !line.equals("") && line.matches(".*[,].*[,].*") && !line.contains("agency")) {
		            String tmp[] = line.split(",");
		            agency_id = tmp[0]; 
		            agency_name = tmp[1];
		            //System.out.println(agency_name);
		            agency_url = tmp[2];
		        
		        	String query = "INSERT INTO agency (agency_id,agency_name,agency_url)"
		        			+ "VALUES (" + Integer.parseInt(agency_id) + ",' " + agency_name + "','" + agency_url + "');" ;
		        	ps = con.prepareStatement(query);
		        	ps.executeUpdate();
		        	
		        	}
		        }
		        br.close();
		       if(ps!=null) ps.close();

			
		} catch(IOException e){
				e.printStackTrace();
		
		}
	}

}
