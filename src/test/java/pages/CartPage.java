package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    By checkoutBtn = By.xpath("//button[@id='checkout']");
    By removeBtn = By.xpath("//button[contains(@id,'remove-sauce-labs')]");
    By cartItem = By.xpath(("//div[@class='cart_quantity']"));
    By checkOutPage = By.xpath("//span[text()='Checkout: Your Information']");

    public void clickCheckout() {
        click(checkoutBtn);  // ✅ using BasePage method (with highlight)
    }
    public void removeItem() {
        click(removeBtn);
    }

    public boolean blankCart() {
        return isNotVisible(cartItem);
    }

    public boolean checkOutPagePresent() {
        return isVisible(checkOutPage);
    }
}