package Tables;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Agency {

	public static void insertAgency(Connection con, String URL)throws SQLException {
		
			try {
				PreparedStatement ps = null;
				String agency_id = "";
				String agency_name = "";
				String agency_url = "";
				 BufferedReader br = new BufferedReader(new InputStreamReader(
						 new FileInputStream(URL+"/agency.txt"), StandardCharsets.UTF_8));
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
			        			+ "VALUES (" + Integer.parseInt(agency_id) + ",' " + agency_name + "','" + agency_url + "')"
			        					+ "ON CONFLICT DO NOTHING;" ;
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
