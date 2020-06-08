package gluecode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class RandomPageTest {

	@Given("^that search Fortune 500 company in google-TC1$")
	public void TC_01() {
		Hooks.driver.get("https://www.google.com/");
		Hooks.driver.findElement(By.xpath("//input[contains(@type,'text')]")).sendKeys("Fortune 500 company");
		Hooks.driver.findElement(By.xpath("//input[contains(@type,'text')]")).submit();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

	@Then("^Search Appear, click on official website-TC1$")
	public void TC_02() {
		List<WebElement> allLinks= Hooks.driver.findElements(By.tagName("a"));
		String fortuneURL= "";
		for(WebElement link:allLinks){
			 System.out.println(link.getText() + " - " + link.getAttribute("href"));
			 //if(link.getAttribute("title").contains("fortune500")) {
			 //if(link.getAttribute("href").contains("fortune")) {
			 if(link.getText().contains("fortune")) { 
				 
				 //link.click();
				 System.out.println("HI, I AM FOUND");
				 fortuneURL = link.getAttribute("href");
				 System.out.println("its here: -  "+fortuneURL);
				 
				 Hooks.driver.get(fortuneURL);
			 }
			 else {
				 System.out.println("NOT FOUND");
			 }
		}
		System.out.println(fortuneURL);
	}	
}
