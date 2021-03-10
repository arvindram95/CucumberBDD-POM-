package parallel;

import org.junit.Assert;

import Pages.LoginPage;
import Utilites.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	private static String title;
	private LoginPage loginpage=new LoginPage(DriverFactory.getDriver());
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    DriverFactory.getDriver()
	    .get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
	    // Write code here that turns the phrase above into concrete actions
		 title=loginpage.getLoginPageTitle();
	    System.out.println("Login page title is"+ title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedtitle) {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertTrue(title.contains(expectedtitle));
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(loginpage.isForgotPwdLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
	    // Write code here that turns the phrase above into concrete actions
		loginpage.enterUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
	    // Write code here that turns the phrase above into concrete actions
		loginpage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		loginpage.clickOnLogin();
	}

	


}
