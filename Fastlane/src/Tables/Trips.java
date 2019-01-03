package Tables;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Trips {

	public static void insertTrips(Connection con, String URL) throws SQLException {
		try {
			PreparedStatement ps = null;
			String route_id = "";
			String service_id = "";
			String trip_id = "";
			String direction_id = "";
			String shape_id = "";
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					 new FileInputStream(URL+"/trips.txt"), StandardCharsets.UTF_8));
			 String line = null;
		        while ((line = br.readLine() )!=null)
		        {
		        	//Make sure the line is not null, not empty, and contains 2 comma char
		        	if (line != null && !line.equals("") && line.matches(".*[,].*[,].*") && !line.contains("trip_id")) {
		            String tmp[] = line.split(",");
		            route_id = tmp[0]; 
		            service_id = tmp[1];
		            trip_id = tmp[2];
		            direction_id = tmp[4];
		            shape_id = tmp[5];
		         
		        
		        	String query = "INSERT INTO trips (route_id,service_id,trip_id,direction_id,shape_id)"
		        			+ "VALUES (?, ?, ?,'" + direction_id + "', ?)"
		        					+ "ON CONFLICT DO NOTHING;" ;
		        	ps = con.prepareStatement(query);
		        	ps.setInt(1,Integer.parseInt(route_id));
		        	ps.setInt(2, Integer.parseInt(service_id));
		        	ps.setString(3, trip_id);
		        	ps.setInt(4, Integer.parseInt(shape_id));
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
