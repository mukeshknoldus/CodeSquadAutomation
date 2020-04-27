package gluecode;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

public class Test_Steps {
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Hi i am Given");
	    throw new PendingException();
	}

}
