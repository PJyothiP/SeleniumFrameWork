package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadConfig {
	public Properties prop = new Properties();
	public LoadConfig() throws IOException {
		FileInputStream f = new FileInputStream("./config/config.properties");
		System.out.println("inside loadconfig constructor");
		prop.load(f);
	}
	public String getBrowser() {
		return prop.getProperty("browser");
	}
	public String getURL() {
		return prop.getProperty("URL");
	}
	public int getimplicitWait() {
		return Integer.parseInt(prop.getProperty("implicitWait"));
	}
	public int getexplicitWait() {
		return Integer.parseInt(prop.getProperty("explictWait"));
	}
	public int getPageLoadWait() {
		return Integer.parseInt(prop.getProperty("pageLoadWait"));
	}
	public String getConfig(String key) {
		return prop.getProperty(key);
	}
}
