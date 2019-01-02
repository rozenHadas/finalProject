package DB;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
public class db_manager {
	public static db_connect db_connect = new db_connect();
	public static db_download download_File = new db_download();
	public static db_update update_File = new db_update();
	
	public static void main(String[] args) throws SQLException, IOException, ParseException {
		
		//connection to postgresDriver
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//unzip gtfs files location
       // String zipFilePath = "ftp://gtfs.mot.gov.il/israel-public-transportation.zip";        
        //unzip to output folder
        String destDir = "C:/Users/hadas/Desktop/פרויקט/finalProject/Fastlane/output";
        //download_File.connectServer();
        download_File.unzip(destDir);
        // create connection once at db_connect class;
        db_connect.createConnection();
        //insert data files to DB
        update_File.insertData(db_connect.getConnection(),destDir);
        db_connect.disconnect();
        
        
    }
	
}
