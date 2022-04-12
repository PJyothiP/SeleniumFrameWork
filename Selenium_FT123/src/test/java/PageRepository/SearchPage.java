package PageRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage {
	@FindBy(id = "twotabsearchtextbox")WebElement text;
	@FindBy(id = "nav-search-submit-button")WebElement searchBtn;
	
	public void  searchAction(String textTobeSearched) {
		text.sendKeys(textTobeSearched);
		searchBtn.click();
	}
}
