package sdef.org;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import lib.org.LibGlobal;

public class Hooks extends LibGlobal {
	@Before
	public void loadDriver() {
		
		WebDriver driver = launchBrowser("chrome");
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15,  TimeUnit.SECONDS);
		driver.get("https://www.nopcommerce.com/en");
		driver.manage().window().maximize();
		

	}
	
	@After
    public void captureScreenShots(Scenario s) {
		s.embed(takeScreenShots(), "img/png");
		driver.manage().deleteAllCookies();
		//driver.quit();
		
		
	}


}
