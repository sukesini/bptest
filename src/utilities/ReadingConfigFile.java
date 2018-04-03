package utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadingConfigFile {
	
	public static String DataReadFromConf(String key){
		String value = null;
		Properties prop = null;
		InputStream fis;
		try {
			fis = new FileInputStream("data/RetailDemo_ConfigFile.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(prop.containsKey(key))
			value=prop.getProperty(key);
		
		return value;
	}
}


