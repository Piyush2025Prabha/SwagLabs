package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutPOM {
	WebDriver Driver;
	@FindBy (className = "title") private WebElement pagetitle;
	@FindBy (id = "first-name") private WebElement FirstNameField;
	@FindBy (id = "last-name") private WebElement LastNameField;
	@FindBy (id = "postal-code") private WebElement ZipField;
	@FindBy (id = "continue") private WebElement continueButton;
	@FindBy (className = "summary_total_label") private WebElement TotalPrice;
	@FindBy (id = "finish") private WebElement finishbutton;
	@FindBy (className = "title") private WebElement COStatus;
	@FindBy (className = "complete-header") private WebElement Message1;
	@FindBy (className = "complete-text") private WebElement Message2;
	@FindBy (id = "back-to-products") private WebElement ProductPage;
	
	public CheckoutPOM(WebDriver Driver) {
        this.Driver = Driver;
        PageFactory.initElements(Driver, this);
    }
	public void checkoutProcess() {
		String title = pagetitle.getText();
		Assert.assertTrue(title.contains("Information"), "Test Fail: Page is invalid");
		System.out.println("This is Checkout Page");
		FirstNameField.sendKeys("Piyush Prabha");
		LastNameField.sendKeys("Panda");
		ZipField.sendKeys("768004");
		continueButton.click();
		String Totalprice = TotalPrice.getText();
		Assert.assertNotNull(Totalprice, "The Value is null");
		finishbutton.click();
	}
	public void successVerification() {
		
		String checkoutStatus = COStatus.getText();
		Assert.assertTrue(checkoutStatus.contains("Complete"),"Test Fails");
		System.out.println("Checkout is successful");
		String Msg1 = Message1.getText();
		Assert.assertTrue(Msg1.contains("Thank you"), "Test Fails");
		System.out.println(Msg1);
		String Msg2 = Message2.getText();
		Assert.assertTrue(Msg2.contains("as fast as the pony"), "Test Fails");
		System.out.println(Msg2);
	}
	public void BackToProduct() {
		ProductPage.click();
	}

}
