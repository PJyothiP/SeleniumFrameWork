package Utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	public static WebDriver driver;
	public BrowserFactory bf = new BrowserFactory();
	public LoadConfig lc;
	public ExtentReports report;
	public ExtentTest log;
	public ExcelOperations eo;
	
	@BeforeSuite(alwaysRun = true)
	public void readData() throws IOException {
		System.out.println("Inside Before Suite");
		lc = new LoadConfig();
		System.out.println("lc browser type "+lc.getBrowser());
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File("./Report/Amazon.html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public WebDriver driverSetup(String browserType) {
		driver = bf.startUP(driver, browserType, lc.getURL(),lc.getPageLoadWait(),lc.getimplicitWait(),lc.getexplicitWait());
		return driver;
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.FAILURE) {
			log.fail("The test case is failed",MediaEntityBuilder.createScreenCaptureFromPath("."+ScreenshotCapture.captureScreenshot(driver)).build());
		}else if(result.getStatus() == ITestResult.SUCCESS) {
			log.pass("The test case is passed");
		}
		bf.quitBrowser(driver);
		report.flush();
	}
	
	@DataProvider(name = "testData")
	public String[][] getData(Method met) throws IOException{
		eo= new ExcelOperations(lc.getConfig("testdataPath"));
		//String testSheet = "AmazonSignIn";
		String testSheet = met.getName();
		int rowCount = eo.getRowCount(testSheet);
		int columnCount = eo.getColumnCount(testSheet);
		String[][] cellData = new String[rowCount][columnCount];
		for(int i = 1;i<=rowCount;i++) {
			for(int j =0;j<columnCount;j++) {
				cellData[i-1][j] = eo.getData(i, j, testSheet);
			}
		}
		return cellData;
	}
}
