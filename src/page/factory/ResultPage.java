package page.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage {
	WebDriver driver;
	
	//@FindBy(xpath="//*[@id=\"content\"]/div[4]/div/div/div[1]/div[1]/div[2]/div[1]/h1/span/span[1]/span[1]")
	@FindBy(className="street-address")
	WebElement address;
	
	public ResultPage(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}	
	
	public boolean verify(String inputAddress) {
		boolean result = false;
		String resultAddress = address.getAttribute("title").trim();
		
		boolean start = inputAddress.trim().startsWith(resultAddress);
		if (start)
			result = true;
		
		return result;
	}


}
