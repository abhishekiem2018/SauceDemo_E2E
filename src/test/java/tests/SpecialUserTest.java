package tests;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;

public class SpecialUserTest extends BaseTest {

    @Test
    public void lockedUserTest() {
        LoginPage login = new LoginPage(driver);
        login.login(ConfigReader.getProperty("locked_out_user"), ConfigReader.getProperty("password"));
        Assert.assertEquals(login.errorMsg(),"Epic sadface: Sorry, this user has been locked out.");
    }
}
