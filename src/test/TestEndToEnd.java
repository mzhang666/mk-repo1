package test;

//import junit.framework.Assert;
import org.testng.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.factory.LoginPage;
import page.factory.SearchPage;
import page.factory.ResultPage;



public class TestEndToEnd {
	
	WebDriver driver = null;
	
	LoginPage loginpage;
	SearchPage searchpage;
	ResultPage resultpage;	
	
	@Before
	public void setup()throws Exception {
		//driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver_win32/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		driver.get("https://www.redfin.com/");		
	}
	
	@Test
	public void test_end2end() throws Throwable {
		// test loginpage
		loginpage = new LoginPage(driver);		
		loginpage.loginTo("mikedmzhang@gmail.com", "IPE3V7ChUr");
		System.out.println("pass login");
		
		// test searchpage		
		searchpage = new SearchPage(driver);
		String address = "2667 Dietrich Dr, Tustin CA 92782";
		searchpage.search(address);
		System.out.println("pass search");
		
		// test resultpage
		resultpage = new ResultPage(driver);
		boolean result = resultpage.verify(address);
		Assert.assertTrue(result == true);
		System.out.println("pass result");
	}
	
	@After
	public void tearDown() throws Exception {
		driver.close();
	}

}
