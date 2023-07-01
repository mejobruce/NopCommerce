package sdef.org;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lib.org.LibGlobal;
import page.org.RegistrationPage;

public class RegistrationPageStep extends LibGlobal {
    RegistrationPage re = new RegistrationPage();


    @Given("User on the registration page")
    public void userOnTheRegistrationPage() {
        mouseOver(re.getAccountLogo());
        btnClick(re.getRegisterButton());
        String Title = pageTitle();
        System.out.println(Title);
        Assert.assertEquals("use enter RegiterPage", "Register - nopCommerce", Title);

    }

    @When("User enter {string}  and  {string}")
    public void userEnterAnd(String firstName, String lastName) {
        enterText(re.getFistName(), firstName);
        enterText(re.getLastName(), lastName);

    }

    @When("user types in the {string} and {string}")
    public void userTypesInTheAnd(String email, String confirmEmail) {

        enterText(re.getEmail(), email);
        enterText(re.getConfirmEmail(), confirmEmail);

    }

    @When("user provides  {string}")
    public void userProvides(String userName) {
        enterText(re.getUsername(), userName);

    }

    @When("User click on available button")
    public void userClickOnAvailableButton() {

        btnClick(re.getAvailabilityButton());

    }

    @Then("User shoud see avilabe message")
    public void userShoudSeeAvilabeMessage() {
        screenDisplay("Username available");

    }

    @When("User select country")
    public void userSelectCountry() {

        chooseOption("text", re.getCountryId(), "India");

    }

    @When("User slect time")
    public void userSlectTime() {


        chooseOption("value", re.getTimeZoneId(), "India Standard Time");


    }

    @When("User click on NewsLetter checkbox")
    public void userClickOnNewsLetterCheckbox() {


        btnClick(re.getNewsletter());

    }

    @When("user inputs the {string}  and  {string}")
    public void userInputsTheAnd(String password, String confirmPassword) {

        enterText(re.getPassword(), password);
        enterText(re.getConfirmPassword(), confirmPassword);

    }

    @When("User select My company primarily")
    public void userSelectMyCompanyPrimarily() {

        chooseOption("value", re.getCompanyIndustryId(), "5");


    }

    @When("User  answer from plan to use nopCommerce")
    public void userAnswerFromPlanToUseNopCommerce() {
        screenDisplay("Automation Testing plan");

    }

    @When("User click on My main activity in the company")
    public void userClickOnMyMainActivityInTheCompany() {

        chooseOption("vaue", re.getCompanyRoleId(), "10");


    }

    @When("User answer from How many people work for your company")
    public void userAnswerFromHowManyPeopleWorkForYourCompany() {

        chooseOption("text", re.getCompanySizeId(), "I'm working alone");
    }

    @When("User enter company webside {string}")
    public void userEnterCompanyWebside(String string) {

        enterText(re.getCompanyWebsiteUrl(), "kdck technologies");
    }

    @When("User click on register button")
    public void userClickOnRegisterButton() {
        btnClick(re.getRegisterBtn());
    }

    @Then("User should see success message")
    public void userShouldSeeSuccessMessage() {

        WebElement success = locator("xpath", "//h2[text()='Almost done! To complete your nopCommerce registration, we just need to verify your email address. You have just been sent an email to confirm your email address. Open the email, and click the link to confirm your address.']");
        String ActualMsg = success.getText();
        System.out.println(ActualMsg);
        String expectMsg = "Almost done! To complete your nopCommerce registration, we just need to verify your email address. You have just been sent an email to confirm your email address. Open the email, and click the link to confirm your address.";
        Assert.assertEquals("done", expectMsg, ActualMsg);


    }

}

	
