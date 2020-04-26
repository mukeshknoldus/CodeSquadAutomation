package com.knoldus.automation.codesquad.Runner;

//import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
import cucumber.api.testng.*;
import com.cucumber.listener.ExtentCucumberFormatter;
import com.cucumber.listener.Reporter;

	//@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "src/test/java/Features"
			,glue= {"seleniumgluecode"}
			/*,plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, 
			        monochrome = true*/
			/*,plugin = {"pretty"}
			,monochrome = true*/
					
			/*,plugin = {"pretty","json:target/cucumber-reports/Cucumber.json"}
			,monochrome = true*/
			
			,plugin = { "pretty", "junit:target/cucumber-reports/Cucumberx.xml" },
					 monochrome = true
					
					
			)

	public class TestRunner extends AbstractTestNGCucumberTests{

	}

	

