package gluecode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageTestSteps {
	//public static WebDriver driver;
	
	@Given("^User is having the codesquad home page URL$")
	public void user_is_launching_browser() throws Throwable {
		System.out.println("Hi i am Given");
		//System.setProperty("webdriver.gecko.driver", "/home/knoldus/Downloads/geckodriver/geckodriver");
		//driver = new FirefoxDriver();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@When("^User hit  the codeSquad homme page URL$")
	public void navigating_to_home_page() throws Throwable {
		System.out.println("I AM WHEN");
		Hooks.driver.get("https://www.getcodesquad.com/");
	}
	
	@Then("^User should see home page title as CodeSquad$")
	public void validating_various_elements() throws Throwable {
		System.out.println("I AM THEN");
		String title = Hooks.driver.getTitle();
		Boolean homeDisplayed = Hooks.driver.findElement(By.xpath("//a[contains(.,'Home')]")).isDisplayed();
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(title, "CodeSquad");
		//soft.assertEquals(homeDisplayed, "true");
		soft.assertTrue(homeDisplayed);
		soft.assertAll();
	}
	
	@Given("^User search for login button$")
	public void searching__login_button() throws Throwable{
		System.out.println("I AM GIVEN IN SEARCH FOR LOGIN BUTTON");
		Assert.assertTrue(Hooks.driver.findElement(By.xpath("//a[contains(.,'LOGIN')]")).isEnabled());
	}
	
	@When("^User click on login button$")
	public void clicking_login_button() throws Throwable{
		System.out.println("CLICKING ON LOGIN BUTTON");
		Hooks.driver.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();
	}
	
	@Then("^User should navigate to the login page$")
	public void validating_login_page() throws Throwable{
		System.out.println("VALIDATING LOGIN BUTTON CLICK EVENT");
		Assert.assertTrue(Hooks.driver.findElement(By.xpath("//h4[contains(.,'Login')]")).isDisplayed());
	}
	
	@Given("^User search for registration button$")
	public void searching__registration_button() throws Throwable{
		System.out.println("I AM GIVEN IN SEARCH FOR REGISTER BUTTON");
		Assert.assertTrue(Hooks.driver.findElement(By.xpath("//a[contains(.,'Register')]")).isDisplayed());
	}
	
	@When("^User click on registration button$")
	public void clicking_register_button() throws Throwable{
		System.out.println("CLICKING ON REGISTER BUTTON");
		Hooks.driver.findElement(By.xpath("//a[contains(.,'Register')]")).click();
	}
	
	@Then("^User should navigate to the registration page$")
	public void validating_registration_page() throws Throwable{
		System.out.println("VALIDATING REGISTRATION BUTTON CLICK EVENT");
		Assert.assertTrue(Hooks.driver.findElement(By.xpath("//h4[contains(.,'Sign Up')]")).isDisplayed());
	}
}
