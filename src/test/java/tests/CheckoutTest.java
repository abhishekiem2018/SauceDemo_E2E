package tests;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.ConfigReader;

public class CheckoutTest extends BaseTest {

    @Test
    public void completeCheckoutTest() {
        LoginPage login = new LoginPage(driver);
        InventoryPage inventory = new InventoryPage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        login.login(ConfigReader.getProperty("standard_user"), ConfigReader.getProperty("password"));
        inventory.clearCartIfItemsExist();
        inventory.addItemToCart();
        inventory.goToCart();
        cart.clickCheckout();

        checkout.enterDetails(ConfigReader.getProperty("firstName"), ConfigReader.getProperty("lastName"), ConfigReader.getProperty("zip"));
        String orderStatus= checkout.completeOrder();

        Assert.assertEquals(orderStatus, "Thank you for your order!",
                "Order not completed");
    }

    @Test
    public void checkoutWithMissingDetailsTest() {
        LoginPage login = new LoginPage(driver);
        InventoryPage inventory = new InventoryPage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        login.login(ConfigReader.getProperty("standard_user"), ConfigReader.getProperty("password"));
        inventory.clearCartIfItemsExist();
        inventory.addItemToCart();
        inventory.goToCart();
        cart.clickCheckout();

// Validating Error: First Name is required
        checkout.enterDetails("", ConfigReader.getProperty("lastName"), ConfigReader.getProperty("zip"));
        checkout.clickContinue();
        Assert.assertEquals(checkout.errorMessage(), "Error: First Name is required",
                "Validation message not shown");

// Validating Error: Last Name is required
        checkout.enterDetails(ConfigReader.getProperty("firstName"),"", ConfigReader.getProperty("zip"));
        checkout.clickContinue();
        Assert.assertEquals(checkout.errorMessage(), "Error: Last Name is required",
                "Validation message not shown");

// Validating Error: Zip Name is required
        checkout.enterDetails(ConfigReader.getProperty("firstName"), ConfigReader.getProperty("lastName"), "");
        checkout.clickContinue();
        Assert.assertEquals(checkout.errorMessage(), "Error: Postal Code is required",
                "Validation message not shown");
    }
}