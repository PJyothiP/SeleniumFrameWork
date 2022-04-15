package Utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotCapture {
	public static String captureScreenshot(WebDriver driver) throws IOException {
		String path = "./Screenshot/AmazonSignIn"+System.currentTimeMillis()+".jpeg";
		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(f, new File(path));
		return path;
	}
}
