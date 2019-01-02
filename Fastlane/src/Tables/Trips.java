package Tables;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Trips {

/*	public static void insertTrips(Connection con, String URL) {
		try {
			PreparedStatement ps = null;
			String shape_id = "";
			Double shape_point1;
			Double shape_point2;
			String shape_seq = "";
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					 new FileInputStream(URL+"/trips.txt"), StandardCharsets.UTF_8));
			 String line = null;
			 int count=0;
		        while ((line = br.readLine() )!=null)
		        {
		        
				System.out.println("new line"+ count++);
		        	//Make sure the line is not null, not empty, and contains 2 comma char
		        	if (line != null && !line.equals("") && line.matches(".*[,].*[,].*") && !line.contains("trip_id")) {
		            String tmp[] = line.split(",");
		            shape_id = tmp[0]; 
		            shape_point1 = Double.parseDouble(tmp[1]);
		            shape_point2 = Double.parseDouble(tmp[2]);
		            shape_seq = tmp[3];
		         
		        
		        	String query = "INSERT INTO trips (trip_id,route_id,service_id,direction_id,shape_id)"
		        			+ "VALUES (?, ?, ? ,?)"
		        					+ "ON CONFLICT DO NOTHING;" ;
		        	ps = con.prepareStatement(query);
		        	ps.setInt(1,Integer.parseInt(shape_id));
		        	ps.setDouble(2, shape_point1);
		        	ps.setDouble(3, shape_point2);
		        	ps.setInt(4, Integer.parseInt(shape_seq));
		        	ps.executeUpdate();
		        	
		        	}
		        }
		        br.close();
		       if(ps!=null) ps.close();

			
		} catch(IOException e){
				e.printStackTrace();
		
		}
	}*/
	

}
