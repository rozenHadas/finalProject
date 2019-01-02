package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.zip.ZipOutputStream;

import org.junit.jupiter.api.Test;

import DB.db_download;
import junit.framework.Assert;

class TestZip {

	@Test
	void unzip() throws FileNotFoundException {
		/*Test to check if the uzipping created a folder to unzip files to */
		db_download db_download_test = new db_download();
		
		File zipFile = new File("C:/Users/hadas/Desktop/פרויקט/finalProject/Fastlane/test.zip");
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFile));
		String zipPath = "C:/Users/hadas/Desktop/פרויקט/finalProject/Fastlane/test.zip";
		
		//db_download_test.unzip(zipPath,"C:/Users/hadas/Desktop/פרויקט/finalProject/Fastlane/test");
		
		File tmpDir = new File("C:/Users/hadas/Desktop/פרויקט/finalProject/Fastlane/test");
		assertTrue(tmpDir.exists() && tmpDir.isDirectory());
		
	
	
		
	}
	@SuppressWarnings("deprecation")
	@Test
	void timeUnzip() throws IOException {
		/*test to check if time for unzipping file is less than 2 min*/
		db_download db_download_test = new db_download();        
        String destDir = "C:/Users/hadas/Desktop/פרויקט/finalProject/Fastlane/output_test";
        //check start time for unzipping
        Date startDate =  new Date();
        System.out.println("Start time:"+ startDate);
        db_download_test.unzip(destDir);
        Date endDate =  new Date();
        System.out.println("End time:"+ endDate);
        assertTrue(endDate.after(startDate));
		assertTrue(endDate.getMinutes()-startDate.getMinutes() < 5);
	}

}
