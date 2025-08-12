package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Util.ConfigReader;

public class LoginPOM {
	
	WebDriver Driver;
	@FindBy(id = "user-name") private WebElement UserNameField;
	@FindBy(id = "password") private WebElement PasswordField;
	@FindBy(id = "login-button") private WebElement LoginButton;
	
	public LoginPOM(WebDriver Driver) {
        this.Driver = Driver;
        PageFactory.initElements(Driver, this);
    }
	
	public void login() {
		UserNameField.sendKeys(ConfigReader.getProperty("Username"));
		PasswordField.sendKeys(ConfigReader.getProperty("Password"));
		LoginButton.click();
	}
}
