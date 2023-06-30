package page.org;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lib.org.LibGlobal;

public class RegistrationPage extends LibGlobal {
	
	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}
	//@FindBy(xpath = "//img[@title='nopCommerce']")
	//private WebElement homeLogo;

	@FindBy(xpath = "//span[text()='My account ']")
	private WebElement accountLogo;

	@FindBy(xpath = "//span[text()='Register']")
	private WebElement registerButton;
	
	@FindBy(xpath = "//h1[text()='Register']")
	private WebElement registerTitle;
	
	@FindBy(id="FirstName")
	private WebElement fistName;
	
	@FindBy(id="LastName")
	private WebElement lastName;
	
	@FindBy(id="Email")
	private WebElement email;
	
	@FindBy(id="ConfirmEmail")
	private WebElement confirmEmail;
	

	@FindBy(id="Username")
	private WebElement username;
	
	@FindBy(id="check-availability-button")
	private WebElement availabilityButton;
	
	
	@FindBy(id="CountryId")
	private WebElement countryId;
	

	@FindBy(id="TimeZoneId")
	private WebElement timeZoneId;
	

	@FindBy(id="Newsletter")
	private WebElement Newsletter;
	

	@FindBy(id="Password")
	private WebElement password;
	

	@FindBy(id="ConfirmPassword")
	private WebElement confirmPassword;
	

	@FindBy(id="Details_CompanyIndustryId")
	private WebElement companyIndustryId;
	
	
	
	
	@FindBy(id="Details_CompanyRoleId")  
	private WebElement companyRoleId;
	

	@FindBy(id="Details_CompanySizeId") 
	private WebElement companySizeId;
	
	

	@FindBy(xpath="//select[@id='Details_CompanyWebsiteUrl']")
	private WebElement companyWebsiteUrl;
	
	

	@FindBy(id="register-button")
	private WebElement registerBtn;



	public WebElement getAccountLogo() {
		return accountLogo;
	}



	public WebElement getRegisterButton() {
		return registerButton;
	}



	public WebElement getRegisterTitle() {
		return registerTitle;
	}



	public WebElement getFistName() {
		return fistName;
	}



	public WebElement getLastName() {
		return lastName;
	}



	public WebElement getEmail() {
		return email;
	}



	public WebElement getConfirmEmail() {
		return confirmEmail;
	}



	public WebElement getUsername() {
		return username;
	}



	public WebElement getAvailabilityButton() {
		return availabilityButton;
	}



	public WebElement getCountryId() {
		return countryId;
	}



	public WebElement getTimeZoneId() {
		return timeZoneId;
	}



	public WebElement getNewsletter() {
		return Newsletter;
	}



	public WebElement getPassword() {
		return password;
	}



	public WebElement getConfirmPassword() {
		return confirmPassword;
	}



	public WebElement getCompanyIndustryId() {
		return companyIndustryId;
	}



	public WebElement getCompanyRoleId() {
		return companyRoleId;
	}



	public WebElement getCompanySizeId() {
		return companySizeId;
	}



	public WebElement getCompanyWebsiteUrl() {
		return companyWebsiteUrl;
	}



	public WebElement getRegisterBtn() {
		return registerBtn;
	}
	
	

	
	

}
