package gluecode;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageTestSteps {
	@Given("^User is having the codesquad login page URL$")
	public void user_is_launching_browser() throws Throwable{
		System.out.println("I AM GIVEN IN BACKGROUND LOGIN");
	}
	
	@When("^User hit  the codeSquad login page URL$")
	public void user_navigating_to_login_page() throws Throwable {
		System.out.println("I AM WHEN IN BACKGROUND LOGIN");
		Hooks.driver.get("https://www.getcodesquad.com/login");
	}
	
	@Then("^User should see login page along with login form and login button$")
	public void valalidating_login_page_elements() throws Throwable {
		System.out.println("I AM THEN IN BACKGROUND LOGIN");
		String title = Hooks.driver.getTitle();
		Boolean isLoginPresent = Hooks.driver.findElement(By.xpath("//h4[contains(.,'Login')]")).isDisplayed();
		
		SoftAssert soft = new SoftAssert();
		Assert.assertEquals(title, "CodeSquad");
		Assert.assertTrue(isLoginPresent);
	}
	
	@Given("^User is on login page$")
	public void user_is_on_login_page() throws Throwable{
		Hooks.driver.get("https://www.getcodesquad.com/login");
	}
	
	@When("^User enters wrong user ([^\"]*) and wrong password ([^\"]*)$")
	public void wrong_credential(String username, String password) throws Throwable{
		System.out.println(username+password);
		Hooks.driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
		Hooks.driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		Hooks.driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();
	}
	
	@Then("^User should get error message and should not login$")
	public void validating_error_message() throws Throwable{
		
		WebDriverWait wait = new WebDriverWait(Hooks.driver,30); 
		wait.until(ExpectedConditions.textToBe(By.xpath("//button[contains(.,'OK')]"), "OK"));
		
		String errorElement = Hooks.driver.findElement(By.xpath("//button[contains(.,'OK')]")).getTagName();
		String errorText = Hooks.driver.findElement(By.xpath("//button[contains(.,'OK')]")).getText();
		Hooks.driver.findElement(By.xpath("//button[contains(.,'OK')]")).click();
		
		System.out.println(errorElement+errorText);
		
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(errorElement, "button");
		softassert.assertEquals(errorText, "OK");
		softassert.assertAll();
	}
	
	@Given("^User is already on login page$")
	public void user_already_on_login_page() throws Throwable{
		Hooks.driver.get("https://www.getcodesquad.com/login");
	}

	@When("^User enters correct user ([^\"]*) and corret password ([^\"]*)$")
	public void user_enters_correct_credential(String user, String password) throws Throwable{
		System.out.println(user+password);
		Hooks.driver.findElement(By.xpath("//input[@type='text']")).sendKeys(user);
		Hooks.driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		Hooks.driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();
	}
	
	@Then("^User should navigate to the normal user dashboard page$")
	public void user_validateing_normal_user_dashboard() throws Throwable{
		String stringdashboard = Hooks.driver.findElement(By.xpath("//span[contains(.,'Dashboard')]")).getText();
		
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(stringdashboard, "Dashboard");
		softassert.assertAll();
	}
}
