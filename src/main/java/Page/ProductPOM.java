package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class ProductPOM {
	WebDriver Driver;
	@FindBy (id = "add-to-cart-sauce-labs-backpack") private WebElement Product1;
	@FindBy (id = "add-to-cart-sauce-labs-bike-light") private WebElement Product2;
	@FindBy (id = "add-to-cart-sauce-labs-bolt-t-shirt") private WebElement Product3;
	@FindBy (id = "add-to-cart-sauce-labs-fleece-jacket") private WebElement Product4;
	@FindBy (id = "add-to-cart-sauce-labs-onesie") private WebElement Product5;
	@FindBy (className = "shopping_cart_badge") private WebElement CartIcon;
	@FindBy(id = "remove-sauce-labs-backpack") private WebElement RemoveProduct1;
	
	public ProductPOM(WebDriver Driver) {
        this.Driver = Driver;
        PageFactory.initElements(Driver, this);
    }
	public void Add1productToCart() {
		Product1.click();
		String CartValue = CartIcon.getText();
		int cartValueInt = Integer.parseInt(CartValue);
		System.out.println("The total no. of items added to cart is: " + cartValueInt);	
	}
	public void RemoveproductToCart() {
		RemoveProduct1.click();	
		System.out.println("Item Removed");
	}
	public void addMultiProductToCart() {
		Product1.click();
		Product2.click();
		Product3.click();
		Product4.click();
		Product5.click();
		String CartValue = CartIcon.getText();
		int cartValueInt = Integer.parseInt(CartValue);
		System.out.println("The total no. of items added to cart is: " + cartValueInt);	
	}
	

}
