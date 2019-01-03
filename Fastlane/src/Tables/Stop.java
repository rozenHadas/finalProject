package Tables;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Stop {

	
	public static void insertStops(Connection con, String URL) throws SQLException {
		try {
			PreparedStatement ps = null;
			String stop_id = "";
			String stop_code = "";
			String stop_name = "";
			String stop_desc = "";
			Double stop_lat ;
			Double stop_lot ;
			String location_type = "";
			String parent_station = "";
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					 new FileInputStream(URL+"/stops.txt"), StandardCharsets.UTF_8));
			 String line = null;
		        while ((line = br.readLine() )!=null)
		        {
		        	//Make sure the line is not null, not empty, and contains 2 comma char
		        	if (line != null && !line.equals("") && line.matches(".*[,].*[,].*") && !line.contains("stop")) {
		            String tmp[] = line.split(",");
		            stop_id = tmp[0]; 
		            stop_code = tmp[1];
		            stop_name = tmp[2];
		            stop_desc = tmp[3];
		            stop_lat =  Double.parseDouble(tmp[4]);
		            stop_lot =  Double.parseDouble(tmp[5]);
		            location_type = tmp[6];
		            parent_station = tmp[7];
		            
		        
		        	String query = "INSERT INTO stop (stop_id,stop_code,stop_name,stop_desc,stop_lat,stop_lot"
		        			+ ",location_type, parent_station)"
		        			+ "VALUES (?, ?, ?,? ,?, ?, ?,?)"
		        					+ "ON CONFLICT DO NOTHING;" ;
		        	ps = con.prepareStatement(query);
		        	ps.setInt(1,Integer.parseInt(stop_id));
		        	ps.setInt(2, Integer.parseInt(stop_code));
		        	ps.setString(3, stop_name);
		        	ps.setString(4, stop_desc);
		        	ps.setDouble(5, stop_lat);
		        	ps.setDouble(6, stop_lot);
		        	ps.setInt(7, Integer.parseInt(location_type));
		        	if(parent_station.equals(""))
		        		ps.setNull(8, java.sql.Types.NULL);
		        	else {
		        		ps.setInt(8, Integer.parseInt(parent_station));
		        	}
		        	
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
