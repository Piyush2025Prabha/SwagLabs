package tests;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import Base.BaseTest;
import Page.CartPOM;
import Page.CheckoutPOM;
import Page.LoginPOM;
import Page.ProductPOM;
import Util.WebDriverFactory;
public class ApplicationTest extends BaseTest {
	static LoginPOM LoginPage;
	static ProductPOM ProductPage;
	static CartPOM CartPage;
	static CheckoutPOM COPage;
	String expectedUrl = "https://www.saucedemo.com/";
	String expectedtitle = "Swag Labs";
	public static ExtentTest Test;
	
	
  @Test(priority = 1)
  public void loginFunctionality() {
	  Test = Reports.createTest("Login functionality");
	  Test.info("Verifying the Page URL");
	  String Actualurl = Driver.getCurrentUrl();
	  Test.info("The page url is: " + Actualurl);
	  Assert.assertEquals(Actualurl, expectedUrl, "Test Fail: Url not matched");
	  Test.pass("Test Pass: Url is matched");
	  
	  Test.info("Verifying the Page Title");
	  String Actualtitle = Driver.getTitle(); 
	  Test.info("The title of the page is: " + Actualtitle);
	  Assert.assertEquals(Actualtitle, expectedtitle, "Test Fail: Title not matched");
	  Test.pass("Test Pass: Title is matched");
	  BaseTest.CaptureScreenshot("Login functionality");
	  
	  Test.info("Verifying user is able to login");
	  LoginPage.login();
	  String LoginUrl = Driver.getCurrentUrl(); 
	  Test.info("The title of the page after Login is: " + LoginUrl);
	  Assert.assertTrue(LoginUrl.contains("inventory"), "Test Fail: Login Page Url not matched");
	  Test.pass("Test Pass: User logged in successfully and navigated to Inventory Page");
	  BaseTest.CaptureScreenshot("Login");
	  
  }
  @Test(priority = 2)
  public void AddProduct() {
	  Test = Reports.createTest("Add to Cart Functionality");
	  Test.info("Verifying user is able to add single item to cart");
	  ProductPage.Add1productToCart();
	  BaseTest.CaptureScreenshot("AddSingleItem");
	  Test.pass("Test Pass: User is able to add single item to cart");
	  
	  Test.info("Verifying user is able to remove single item from cart");
	  ProductPage.RemoveproductToCart();
	  BaseTest.CaptureScreenshot("RemoveItem");
	  Test.pass("Test Pass: User is able to remove single item from cart");
	  
	  Test.info("Verifying user is able to add multiple items to cart");
	  ProductPage.addMultiProductToCart();
	  BaseTest.CaptureScreenshot("AddMultipleItem");
	  Test.pass("Test pass: User is able to add multiple items to the cart");
	}
  @Test(priority = 3)
  public void CartVerification() {
	  Test = Reports.createTest("Cart Verification");
	  Test.info("Verifying user is able to open cart");
	  CartPage.goToCart();
	  BaseTest.CaptureScreenshot("Cart");
	  Test.pass("Test Pass: User is able to navigate to the cart page");
	  
	  Test.info("Verifying user is able to verify the items on the cart");
	  CartPage.cartItemsVerification();
	  Test.pass("Test Pass: User is able to get the number of items in the cart");
	  
	  Test.info("Verifying user is able to click on checkout");
	  CartPage.ClickCheckout();
	  Test.pass("Test Pass: User is able to click on checkout button successfully");
  }
  @Test(priority = 4)
  public void Checkout() {
	  Test = Reports.createTest("Checkout Functionality");
	  Test.info("Verifying user is able complete the checkout process");
	  COPage.checkoutProcess();
	  BaseTest.CaptureScreenshot("Checkout");
	  Test.pass("Test Pass: User checks out successfully");
	  
	  Test.info("Verifying user is getting success message after check out");
	  COPage.successVerification();
	  BaseTest.CaptureScreenshot("SuccessMessage");
	  Test.pass("Test Pass: User gets the message successfully");
	  
	  Test.info("Verify User is able to navigate to Products page after successful checkout");
	  COPage.BackToProduct();
	  BaseTest.CaptureScreenshot("ReturnProductPage");
	  Test.pass("Test Pass: User navigates to product page successfully");
  }
  
  @Parameters({"bname"})
  @BeforeTest
  public void beforeTest(String browserName) throws MalformedURLException {
	  String ApplicationURL = Util.ConfigReader.getProperty("AppURL");
	  BaseTest.LaunchBrowser(browserName, ApplicationURL);
	  //Driver = WebDriverFactory.getWebDriver(browserName);
	  LoginPage = new LoginPOM(BaseTest.Driver);
	  ProductPage = new ProductPOM(BaseTest.Driver);
	  CartPage = new CartPOM(BaseTest.Driver);
	  COPage = new CheckoutPOM(BaseTest.Driver);
  }
  @AfterTest
  public void afterTest() {
	  BaseTest.CloseBrowser();  
  }
}
