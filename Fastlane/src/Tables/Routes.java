package Tables;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Routes {

	public static void insertRoutes(Connection con, String URL) throws SQLException{
		try {
			PreparedStatement ps = null;
			String route_id = "";
			String agency_id = "";
			String route_long_name = "";
			String route_desc = "";
			String route_type = "";
			String route_color = "";
			
			 BufferedReader br = new BufferedReader(new InputStreamReader(
					 new FileInputStream(URL+ "/routes.txt"), StandardCharsets.UTF_8));
			 String line = null;
		        while ((line = br.readLine() )!=null)
		        {
		        	//Make sure the line is not null, not empty, and contains 2 comma char
		        	if (line != null && !line.equals("") && line.matches(".*[,].*[,].*") && !line.contains("route")) {
		            String tmp[] = line.split(",");
		            route_id = tmp[0]; 
		            agency_id = tmp[1];
		            route_long_name = tmp[2];
		            route_desc = tmp[3];
		            route_type = tmp[4]; 
		            route_color = tmp[5];
		         
		            
		        	String query = "INSERT INTO routes (route_id,agency_id,route_long_name,route_desc,route_type,route_color)"
		        			+ "VALUES (" + Integer.parseInt(route_id) + "," + Integer.parseInt(agency_id) 
		        			+",'" + route_long_name + "',?,'"+ route_type
		        			+"'," + Integer.parseInt(route_color) + ") ON CONFLICT DO NOTHING;" ;
		        	ps = con.prepareStatement(query);
		        	ps.setString(1, route_desc);
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
