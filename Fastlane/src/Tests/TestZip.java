package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.zip.ZipOutputStream;

import org.junit.jupiter.api.Test;

import DB.db_download;
import junit.framework.Assert;

class TestZip {

	@Test
	void unzip() throws FileNotFoundException {
		/*Test to see if the uzipping created a folder to unzip files to */
		db_download db_download_test = new db_download();
		
		File zipFile = new File("C:/Users/hadas/Desktop/פרויקט/finalProject/Fastlane/test.zip");
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFile));
		String zipPath = "C:/Users/hadas/Desktop/פרויקט/finalProject/Fastlane/test.zip";
	
		db_download_test.unzip(zipPath,"C:/Users/hadas/Desktop/פרויקט/finalProject/Fastlane/test");
		File tmpDir = new File("C:/Users/hadas/Desktop/פרויקט/finalProject/Fastlane/test");
		assertTrue(tmpDir.exists() && tmpDir.isDirectory());
		
	}

}
