package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.ConfigReader;


public class CartTest extends BaseTest {

    @Test(priority = 1)
    public void addToCartTest() {

        LoginPage login = new LoginPage(driver);
        InventoryPage inventory = new InventoryPage(driver);

        login.login(ConfigReader.getProperty("standard_user"), ConfigReader.getProperty("password"));
        inventory.clearCartIfItemsExist();
        inventory.addItemToCart();

        // ✅ Validate cart count
        Assert.assertEquals(inventory.getCartCount(), "1");

        // ✅ Validate Remove button displayed
        Assert.assertTrue(inventory.isRemoveButtonDisplayed(), "After AddTo cart Remove button didn't displayed for that item");
    }

    @Test(priority = 2)
    public void viewCartTest() {

        LoginPage login = new LoginPage(driver);
        InventoryPage inventory = new InventoryPage(driver);
        login.login(ConfigReader.getProperty("standard_user"), ConfigReader.getProperty("password"));

        inventory.goToCart();
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"));
    }

    @Test(priority = 3)
    public void removeItemTest() {

        LoginPage login = new LoginPage(driver);
        InventoryPage inventory = new InventoryPage(driver);
        CartPage cart = new CartPage(driver);

        login.login(ConfigReader.getProperty("standard_user"), ConfigReader.getProperty("password"));
        inventory.clearCartIfItemsExist();
        inventory.addItemToCart();
        inventory.goToCart();

        cart.removeItem();

        // Item should disappear after removal
        Assert.assertTrue(cart.blankCart(), "Validation Failed: Item was not removed from cart");
    }

    @Test(priority = 4)
    public void checkoutWithoutItemTest() {

        LoginPage login = new LoginPage(driver);
        InventoryPage inventory = new InventoryPage(driver);
        CartPage cart = new CartPage(driver);

        login.login(ConfigReader.getProperty("standard_user"), ConfigReader.getProperty("password"));
        inventory.clearCartIfItemsExist();
        inventory.goToCart();
        cart.clickCheckout();

        // ❌ Defect Validation

        Assert.assertFalse(cart.checkOutPagePresent(), "BUG: User able to checkout without cart item");
    }
}