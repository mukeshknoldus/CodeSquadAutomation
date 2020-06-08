package gluecode;

import cucumber.api.java.Before;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;

public class Hooks {
	
	//WebDriver driver = null;
	public static WebDriver driver;
	
	@Before
	public void beforeScenario() 
	{
		System.out.println("*******I AM BEFORE SCENARIO******");
		System.setProperty("webdriver.gecko.driver", "/home/knoldus/Downloads/geckodriver/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	} 
	
	@After
	public void afterScenario() 
	{
		System.out.println("*********I AM AFTER SCENARIOS***********");
		driver.close();
		//HomePageTestSteps.driver.close();
	}

}
