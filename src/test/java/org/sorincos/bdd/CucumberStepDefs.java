package org.sorincos.bdd;

import org.junit.runner.RunWith;
import org.sorincos.bdd.pageobj.BasicPage;
import org.sorincos.bdd.pageobj.ContactPage;
import org.sorincos.bdd.pageobj.LandingPage;
import org.sorincos.bdd.pageobj.LoginPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestApplication.class)
@SpringBootTest
public class CucumberStepDefs {

	@Autowired
	private LandingPage landingPage;
	@Autowired
	private LoginPage loginPage;
	@Autowired
	private BasicPage basicPage;
	@Autowired
	private ContactPage contactPage;

	@Given("^I use the test user \"([^\"]*)\" with password \"([^\"]*)\" to login$")
	public void loginToApplication(final String user, final String password) throws Throwable {
		landingPage.goToLogin().doLogin(user, password);
	}

	@Given("^I try to create a contact named \"([^\"]*)\"$")
	public void editByFullname(final String name) throws Throwable {
		basicPage.createContact().editContact(name);
	}

	@Then("^I will delete it$")
	public void testEditAnswer() throws Throwable {
		contactPage.deleteCurrent();
	}

	@Then("^I can logout, mission accomplished$")
	public void logout() throws Throwable {
		basicPage.logout();
	}

	@After
	public void cleanupWindows() throws Throwable {
		loginPage.quit();
	}
}