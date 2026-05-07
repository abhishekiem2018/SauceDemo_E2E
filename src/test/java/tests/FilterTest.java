package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.ConfigReader;

public class FilterTest extends BaseTest {

    @Test
    public void testFilter_AToZ() {
        LoginPage login = new LoginPage(driver);
        InventoryPage inv = new InventoryPage(driver);

        login.login(ConfigReader.getProperty("standard_user"), ConfigReader.getProperty("password"));
        inv.applyFilter("Name (A to Z)");
        inv.validateFilter("Name (A to Z)");
    }

    @Test
    public void testFilter_ZToA() {
        LoginPage login = new LoginPage(driver);
        InventoryPage inv = new InventoryPage(driver);

        login.login(ConfigReader.getProperty("standard_user"), ConfigReader.getProperty("password"));
        inv.applyFilter("Name (Z to A)");
        inv.validateFilter("Name (Z to A)");
    }

    @Test
    public void testFilter_LowToHigh() {
        LoginPage login = new LoginPage(driver);
        InventoryPage inv = new InventoryPage(driver);

        login.login(ConfigReader.getProperty("standard_user"), ConfigReader.getProperty("password"));
        inv.applyFilter("Price (low to high)");
        inv.validateFilter("Price (low to high)");
    }

    @Test
    public void testFilter_HighToLow() {
        LoginPage login = new LoginPage(driver);
        InventoryPage inv = new InventoryPage(driver);

        login.login(ConfigReader.getProperty("standard_user"), ConfigReader.getProperty("password"));
        inv.applyFilter("Price (high to low)");
        inv.validateFilter("Price (high to low)");
    }
}

