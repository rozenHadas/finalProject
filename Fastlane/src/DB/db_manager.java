package DB;

import java.util.Date;

public class db_manager {
	public static db_connect db_connect = new db_connect();
	public static db_download download_File = new db_download();
	
	public static void main(String[] args) {
		
		//connection to postgresDriver
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//unzip gtfs files location
        String zipFilePath = "C:/Users/hadas/Desktop/פרויקט/FastLane/DB/raw_data/gtfs.zip";        
        //unzip to output folder
        String destDir = "C:/Users/hadas/Desktop/פרויקט/finalProject/finalProject/Fastlane/output";
        //check start time for unzipping
        System.out.println("Start Time:" + new Date());
        download_File.unzip(zipFilePath, destDir);
        //check end time for unzipping
        System.out.println("End Time:" + new Date());
        // create connection once at db_connect class;
        db_connect.createConnection();
        
        download_File.writeToPostgress(destDir);
        System.out.println("finishhhhh");
        System.out.println("End Time postgres:" + new Date());
        
    }
	
}
