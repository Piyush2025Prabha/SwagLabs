package Page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPOM {
	WebDriver Driver;
	@FindBy (className = "shopping_cart_link") private WebElement CartLink;
	@FindBy (css = ".cart_item") private List<WebElement> CartItems;
	@FindBy (id = "checkout") private WebElement Checkoutbtn;
	
	public CartPOM(WebDriver Driver) {
        this.Driver = Driver;
        PageFactory.initElements(Driver, this);
    }
	public void goToCart() {
		CartLink.click();	
	}
	public void cartItemsVerification() {
		int itemCount = CartItems.size();
	    System.out.println("Number of items in cart: " + itemCount);
	    int i=0;
		for(WebElement CartItem : CartItems) {
			System.out.println("Item " + (i+1) + " is: " + CartItem.getText());
			i++;
		}
	}
	public void ClickCheckout() {
		Checkoutbtn.click();
	}

}
