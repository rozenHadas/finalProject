package Tables;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

public class Calendar {
	public static void insertCalendar(Connection con, String URL)throws SQLException, ParseException {
		
		try {
			PreparedStatement ps = null;
			String service_id = "";
			String days_bytes = "";
			String start_date = ""; //YYYYMMDD
			String end_date = "";
			BufferedReader br = new BufferedReader(new InputStreamReader(
					 new FileInputStream(URL+"/calendar.txt"), StandardCharsets.UTF_8));
			 String line = null;
		        while ((line = br.readLine() )!=null)
		        {
		        	//Make sure the line is not null, not empty, and contains 2 comma char
		        	if (line != null && !line.equals("") && line.matches(".*[,].*[,].*") && !line.contains("service")) {
		            String tmp[] = line.split(",");
		            service_id = tmp[0]; 
		            days_bytes = mergeDayes(tmp[1],tmp[2],tmp[3],tmp[4],tmp[5],tmp[6],tmp[7]);
		            start_date = stringToDate(tmp[8]);
		            end_date = stringToDate(tmp[9]);
		        
		        	String query = "INSERT INTO calendar (service_id,date_bytes,start_date,end_date)"
		        			+ "VALUES (?,'" + days_bytes +"',?,?)"
		        					+ "ON CONFLICT DO NOTHING;" ;
		        	ps = con.prepareStatement(query);
		        	ps.setInt(1, Integer.parseInt(service_id));
		        	//ps.setBytes(2, days_bytes);
		        	ps.setDate(2, java.sql.Date.valueOf(start_date));
		        	ps.setDate(3, java.sql.Date.valueOf(end_date));
		        	ps.executeUpdate();
		        	
		        	}
		        }
		        br.close();
		       if(ps!=null) ps.close();

			
		} catch(IOException e){
				e.printStackTrace();
		
		}
	}

	public static String mergeDayes(String monday, String tuesday, String wednesday, String thursday, String friday,
			String saturday, String sunday) {
		String week = sunday+monday+tuesday+wednesday+thursday+friday+saturday;
		return week;
	}

	private static String stringToDate(String str) throws ParseException {
		String year = str.substring(0, 4);
		String month = str.substring(4,6);
		String day = str.substring(6,8);
		return year+"-"+month+"-"+day;
	}

}
