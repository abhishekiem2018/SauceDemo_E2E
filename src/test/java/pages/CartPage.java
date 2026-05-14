package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final By checkoutBtn = By.xpath("//button[@id='checkout']");
    private final By removeBtn = By.xpath("//button[contains(@id,'remove-sauce-labs')]");
    private final By cartItem = By.xpath(("//div[@class='cart_quantity']"));
    private final By checkOutPage = By.xpath("//span[text()='Checkout: Your Information']");

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