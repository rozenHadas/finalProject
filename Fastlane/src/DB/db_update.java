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
import java.text.ParseException;
import java.util.Date;

import Tables.*;

public class db_update {

	//insert data to tables

	public void insertData(Connection con, String URL) throws  FileNotFoundException, SQLException, ParseException {
		
		Agency.insertAgency(con, URL);
		Routes.insertRoutes(con, URL);
		System.out.println("Starting insert to calendar....");
		Calendar.insertCalendar(con, URL);
		System.out.println("Starting insert to shape....");
		Shape.insertShape(con, URL);
		System.out.println("Starting insert to trips....");
		//System.out.println("Trips time: "+new Date());
		Trips.insertTrips(con, URL);
		//System.out.println("Finish trips:"+new Date());
		System.out.println("Starting insert to stop....");
		Stop.insertStops(con, URL);
		System.out.println("Starting insert to stop_times....");
		Stop_Times.insertStopTimes(con, URL);
		System.out.println("Finishing....");

	}

	

}
