package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

public class ConfigSupport {
	
	static Properties properties = new Properties();
	String strFileName;
	String strValue;
	
	public ConfigSupport(String strFileName) {
		this.strFileName = strFileName;
	}

	// return environmental details
	public static String getHostName() throws UnknownHostException {
		InetAddress addr = InetAddress.getLocalHost();
		String hostname = addr.getHostName();

		return hostname;
	}
	
	public void clean()
	{
		properties.clear();
	}
	
	
	public String getProperty(String strKey) {
		try {
			File file = new File(strFileName);
			if(file.exists())
			{
				FileInputStream fis = new FileInputStream(file);
				properties.load(fis);
				strValue = properties.getProperty(strKey);
				fis.close();
			}else
				System.out.println("File not found...");
		} catch (Exception e) {
			System.out.println(e);
		}
		return strValue;
	}
	
	
	public void setProperty(String strKey, String strValue) {
		try {
			File file = new File(strFileName);
			if(file.exists())
			{
				FileInputStream fis = new FileInputStream(file);
				properties.load(fis);
				properties.setProperty(strKey, strValue);
				properties.store(new FileOutputStream(strFileName), null);
				fis.close();
			}else
				System.out.println("File not found...");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void removeProperty(String strKey) {
		try {
			File file = new File(strFileName);
			if(file.exists())
			{
				FileInputStream fis = new FileInputStream(file);
				properties.load(fis);
				properties.remove(strKey);
				properties.store(new FileOutputStream(strFileName), null);
				fis.close();
			}else
				System.out.println("File not found...");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
