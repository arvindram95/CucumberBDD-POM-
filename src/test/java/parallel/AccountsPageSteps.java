package parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import Pages.AccountsPage;
import Pages.LoginPage;
import Utilites.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {
	private LoginPage loginpage=new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {
	  List<Map<String,String>> credentialslist= dataTable.asMaps();
	  String username=credentialslist.get(0).get("username");
	  String password=credentialslist.get(0).get("password");
	  DriverFactory.getDriver()
	    .get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	  accountsPage=loginpage.doLogin(username, password);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		String title=accountsPage.getAccountsPageTitle();
		System.out.println("Accounts Page title is: " + title);
	}
	
	

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable dataTable) {
		
List<String> expAccountSectionsList = dataTable.asList();
		System.out.println("Expected accounts section list: " + expAccountSectionsList);
		List<String> actualAccountSectionsList = accountsPage.getAccountsSectionList();
		System.out.println("Actual accounts section list: " + actualAccountSectionsList);
		Assert.assertTrue(expAccountSectionsList.containsAll(actualAccountSectionsList));
		
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer ExpectedSectioncount) {
		 Assert.assertTrue(accountsPage.getAccountsSectionCount()==ExpectedSectioncount);
	}
	
}
