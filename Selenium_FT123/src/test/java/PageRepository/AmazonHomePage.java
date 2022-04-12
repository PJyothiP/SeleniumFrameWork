package PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AmazonHomePage {
	
	@FindBy(xpath = "//span[@class = 'nav-line-2 ' and text() = 'Account & Lists']")WebElement account;
	@FindBy(xpath = "//span[@class='nav-action-inner' and text() = 'Sign in']")WebElement signIn;
	@FindBy(id = "ap_email")WebElement email;
	@FindBy(id = "continue")WebElement continueBtn;
	@FindBy(id = "ap_password")WebElement password;
	@FindBy(id = "signInSubmit")WebElement signInbtn;
	
	
	public void signIn(WebDriver driver,String phoneNumber,String pswd) {
		Actions a = new Actions(driver);
		a.moveToElement(account).build().perform();
		signIn.click();
		email.sendKeys(phoneNumber);
		continueBtn.click();
		password.sendKeys(pswd);
		signInbtn.click();
	}
}
