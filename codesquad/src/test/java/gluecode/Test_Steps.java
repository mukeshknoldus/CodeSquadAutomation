package gluecode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps {
	public static WebDriver driver;
	
	@Given("^User is having the codesquad home page URL$")
	public void user_is_launching_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Hi i am Given");
		System.setProperty("webdriver.gecko.driver", "/home/knoldus/Downloads/geckodriver/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@When("^User hit  the codeSquad homme page URL$")
	public void navigating_to_home_page() throws Throwable {
		System.out.println("I AM WHEN");
		driver.get("https://www.getcodesquad.com/");
	}
	
	@Then("^User should get the register and login button along with home page title as CodeSquad$")
	public void validating_various_elements() throws Throwable {
		System.out.println("I AM THEN");
	}

}
