package DB;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class db_download {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String zipFilePath = "C:/Users/hadas/Desktop/פרויקט/FastLane/DB/raw_data/gtfs.zip";
        
        String destDir = "C:/Users/hadas/Desktop/פרויקט/finalProject/finalProject/Fastlane/output";
        System.out.println("Start Time:" + new Date());
        unzip(zipFilePath, destDir);
        System.out.println("End Time:" + new Date());//add comment
       
       // writeToPostgress(destDir);
        System.out.println("finishhhhh");
        System.out.println("End Time postgres:" + new Date());
        
    }

	private static void createSchema() {
		
	}
	
    private static void writeToPostgress(String destDir) {
        File dir = new File(destDir);
        File[] folder = dir.listFiles();
            for(File file : folder) {
                System.out.println("File name: "+ file.getName());
                String url = "jdbc:postgresql://localhost:5432/postgres";
                String user = "postgres";
                String password = "erutyhv5";

                try (Connection con = DriverManager.getConnection(url, user, password);
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT VERSION()")) {

                    if (rs.next()) {
                        System.out.println(rs.getString(1));
                    }

                } catch (SQLException ex) {
                
                    Logger lgr = Logger.getLogger(db_download.class.getName());
                    lgr.log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
      
    }
		

	private static void unzip(String zipFilePath, String destDir) {
        File dir = new File(destDir);
        // create output directory if it doesn't exist
        if(!dir.exists()) dir.mkdirs();
        FileInputStream fis;
        //buffer for read and write data to file
        byte[] buffer = new byte[1024];
        try {
            fis = new FileInputStream(zipFilePath);
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry ze = zis.getNextEntry();
            while(ze != null){
                String fileName = ze.getName();
                File newFile = new File(destDir + File.separator + fileName);
                System.out.println("Unzipping to "+newFile.getAbsolutePath());
                //create directories for sub directories in zip
                new File(newFile.getParent()).mkdirs();
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
                }
                fos.close();
                //close this ZipEntry
                zis.closeEntry();
                ze = zis.getNextEntry();
            }
            //close last ZipEntry
            zis.closeEntry();
            zis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }


}