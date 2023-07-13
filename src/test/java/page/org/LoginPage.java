package page.org;

import lib.org.LibGlobal;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends LibGlobal {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(linkText = "Log in")
    private WebElement Clickogin;
    //Log in
    @FindBy(css = ".username")
    private WebElement Username;


    @FindBy(xpath = "//input[@class='password']")
    private WebElement Password;

    @FindBy(xpath = "(//input[@class='btn blue-button'])[1]")
    private WebElement Submit;

    @FindBy(xpath = "//span[text()='My account ']")
    private WebElement accountLogo;

    public WebElement getClickogin() {
        return Clickogin;
    }

    public WebElement getUsername() {
        return Username;
    }

    public WebElement getPassword() {
        return Password;
    }

    public WebElement getSubmit() {
        return Submit;
    }

    public WebElement getAccountLogo() {return accountLogo;}



}
