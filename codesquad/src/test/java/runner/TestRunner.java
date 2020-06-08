package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.*;

@CucumberOptions(
        features = "src/test/java/features",
        glue = {"gluecode"},
        tags = {"@smoke", "~@regression", "~@random"},
        //plugin = {"pretty", "junit:target/cucumber-reports/cucumber.xml"}
        //for creating HTML Extent report
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        monochrome = true

)

public class TestRunner extends AbstractTestNGCucumberTests {

}
