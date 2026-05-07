package tests;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.ConfigReader;

public class E2ETest extends BaseTest {

    @Test
    public void completeFlow() {
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
        checkout.navigateBackToHome();
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));

    }
}