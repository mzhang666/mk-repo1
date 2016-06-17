package page.factory;

import java.util.Set;
import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	WebDriver driver;
	
	@FindBy(name="emailInput")
	WebElement userName;
	
	@FindBy(name="passwordInput")
	WebElement password;
	
	@FindBy(linkText="Sign In")
	WebElement signInLable;
	
	@FindBy(xpath="//html/body/div[4]/div/div/div[2]/div/div/div[1]/div/div/form/div[6]/button")
	WebElement loginBtn;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;		
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	//Set user name in textbox
	public void setUserName(String strUserName){
		userName.sendKeys(strUserName);		
	}
	
	//Set password in password textbox
	public void setPassword(String strPassword){
		password.sendKeys(strPassword);
	}
	
	//Click on login button
	public void clickLogin(){
			loginBtn.click();
	}
	
	
	/**
	 * This POM method will be exposed in test case to login in the application
	 * @param strUserName
	 * @param strPasword
	 * @return
	 */
	public void loginTo(String strUserName,String strPasword){
		this.signInLable.click();
		
		Set <String> set = driver.getWindowHandles();
        Iterator<String> it = set.iterator();
        //String parentWindowId = it.next();
        String childWindowId = it.next();        
        driver.switchTo().window(childWindowId);
				
		//Fill user name
		this.setUserName(strUserName);
		//Fill password
		this.setPassword(strPasword);
		//Click Login button
		this.clickLogin();
								
	}
	
	
}
