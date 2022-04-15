package MainLibrary;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageRepository.AmazonHomePage;
import PageRepository.SearchPage;
import Utilities.BaseClass;
public class MainTestClass extends BaseClass{
	
	@Test(dataProvider = "testData",groups = "Regression")
	public void AmazonSignIn(String name,String password) throws InterruptedException {
		AmazonHomePage ahp = PageFactory.initElements(driver, AmazonHomePage.class);
		log = report.createTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		ahp.signIn(driver,name,password);
		log.info("Test started");
		Thread.sleep(5000);
		SoftAssert sa = new SoftAssert();
		log.info("Before Assertion");
		Assert.assertEquals(driver.getTitle(), "Amazon.com. Spend less. Smile more.");
		//sa.assertTrue(driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1' and contains(text(),'Hello,')]")).isDisplayed());
		System.out.println("After assertion");
		sa.assertAll();
	}
	
//	@Test(dataProvider = "testData",groups={"Regression","Sanity"})
//	public void searchScenario(String name) {
//		
//		SearchPage sp = PageFactory.initElements(driver, SearchPage.class);
//		log = report.createTest("Default Report");
//		sp.searchAction(name);
//		log.info("Test started");
//		//Assert.assertEquals(12, 13);
//	}
	
//	@Test(groups="Regression")
//	public void demo() {
//		System.out.println("This is demo test case");
//	}
//	
//	@Test(groups="Smoke")
//	public void dummy() {
//		System.out.println("This is dummy test case");
//	}
	
}

