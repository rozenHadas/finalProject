package Tables;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;

public class Stop_Times {
	
	public static void insertStopTimes(Connection con, String URL)throws SQLException, ParseException {
	try {
		PreparedStatement ps = null;
		String trip_id = "";
		Time arrival_time;
		Time departure_time;
		int stop_id;
		int stop_sequence;
		int pickup_types;
		int drop_off_type;
		int shape_dist_traveled;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(
				 new FileInputStream(URL+"/stop_times.txt"), StandardCharsets.UTF_8));
		 String line = null;
	        while ((line = br.readLine() )!=null)
	        {
	        	//Make sure the line is not null, not empty, and contains 2 comma char
	        	if (line != null && !line.equals("") && line.matches(".*[,].*[,].*") && !line.contains("stop")) {
	            String tmp[] = line.split(",");
	            trip_id = tmp[0]; 
	            arrival_time = convertToTime(tmp[1]);
	            departure_time = convertToTime(tmp[2]);
	            stop_id = Integer.parseInt(tmp[3]);
	            stop_sequence = Integer.parseInt(tmp[4]);
	            pickup_types = Integer.parseInt(tmp[5]);
	            drop_off_type = Integer.parseInt(tmp[6]);
	            shape_dist_traveled = Integer.parseInt(tmp[7]);
	         
	        
	        	String query = "INSERT INTO stop_times (trip_id,arrival_time,departure_time,stop_id"
	        			+ ",stop_sequence,pickup_types,drop_off_type,shape_dist_traveled)"
	        			+ "VALUES (?, ?, ? ,?,?,?,?,?)"
	        					+ "ON CONFLICT DO NOTHING;" ;
	        	ps = con.prepareStatement(query);
	        	ps.setString(1,trip_id);
	        	ps.setTime(2, arrival_time);
	        	ps.setTime(3, departure_time);
	        	ps.setInt(4, stop_id);
	        	ps.setInt(5, stop_sequence);
	        	ps.setInt(6, pickup_types);
	        	ps.setInt(7, drop_off_type);
	        	ps.setInt(8, shape_dist_traveled);
	        	ps.executeUpdate();
	        	
	        	}
	        }
	        br.close();
	       if(ps!=null) ps.close();

		
		} catch(IOException e){
				e.printStackTrace();
		
		}
	}

	private static Time convertToTime(String string) {
		
	//	System.out.println("time:" +java.sql.Time.valueOf(string));
				return java.sql.Time.valueOf(string);
	}
}
