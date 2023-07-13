package sdef.org;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lib.org.LibGlobal;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import page.org.LoginPage;
import page.org.RegistrationPage;

import java.util.List;

public class LoginStef extends LibGlobal {

    LoginPage le =new  LoginPage();

    public WebElement getClickogin;

    @Given("I am on the nopCommerce demo store login page")
    public void iAmOnTheNopCommerceDemoStoreLoginPage() {
        mouseOver(le.getAccountLogo());
        btnClick(le.getClickogin());
        String Title = pageTitle();
        System.out.println(Title);
        Assert.assertEquals("User entered the login page","Login - nopCommerce", Title);

    }



    @When("I enter my valid {string} and {string}")
    public void iEnterMyValidAnd(String firstName, String Password, io.cucumber.datatable.DataTable dataTable) {
        List<String> List = dataTable.asList();
        enterText(le.getUsername(), List.get(0));
        enterText(le.getPassword(), List.get(1));

    }

    @When("I click on the login button")
    public void iClickOnTheLoginButton() {
        btnClick(le.getSubmit());
        String Title = pageTitle();
        System.out.println(Title);

    }

    @Then("I should be redirected to the user account dashboard")
    public void iShouldBeRedirectedToTheUserAccountDashboard() {

    }

    @Then("I should see a welcome message with my username")
    public void iShouldSeeAWelcomeMessageWithMyUsername() {

    }




}
