package page.factory;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	
	@FindBy(name="searchInputBox")
	WebElement inputBox;
		
	@FindBy(css=".inline-block.SearchButton.clickable.float-right")
	WebElement searchBtn;
		
	@FindBy(css=".item-title.block")
	WebElement address;
	
	public SearchPage(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}	
	
	public void search(String content){		
		inputBox.sendKeys(content);
		searchBtn.click();
		
		Set <String> set = driver.getWindowHandles();
        Iterator<String> it = set.iterator();        
        String childWindowId = it.next();        
        driver.switchTo().window(childWindowId);
        address.click();
        
	}


}
