package tests;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {


    @Test
    public void validLogin() {
        LoginPage login = new LoginPage(driver);
        login.login(ConfigReader.getProperty("standard_user"), ConfigReader.getProperty("password"));

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test
    public void invalidLogin() {
        LoginPage login = new LoginPage(driver);
        login.login("wrong", "wrong");
        Assert.assertEquals(login.errorMsg(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void empty_UserNameLogin() {
        LoginPage login = new LoginPage(driver);
        login.login("", ConfigReader.getProperty("password"));
        Assert.assertEquals(login.errorMsg(), "Epic sadface: Username is required");
    }
    @Test
    public void empty_PasswordLogin() {
        LoginPage login = new LoginPage(driver);
        login.login(ConfigReader.getProperty("standard_user"), "");
        Assert.assertEquals(login.errorMsg(), "Epic sadface: Password is required");
    }
}