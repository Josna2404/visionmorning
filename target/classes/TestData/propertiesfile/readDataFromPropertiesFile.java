package propertiesfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Reporter;

public class readDataFromPropertiesFile {
	public static String readDataFromPropertiesFile(String key) throws IOException
	{
		Properties prop= new Properties();
		FileInputStream myFile= new FileInputStream(System.getProperty("user.dir")+"\\coverFox.properties");
		prop.load(myFile);
		String value = prop.getProperty(key);
		Reporter.log("reading "+key+ " from properties file", true);
		
		return value;
	}


}
