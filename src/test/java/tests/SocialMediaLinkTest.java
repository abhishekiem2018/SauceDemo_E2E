package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.ConfigReader;

public class SocialMediaLinkTest extends BaseTest {

    @Test
    public void socialMediaLinksTest() {

        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        login.login(ConfigReader.getProperty("standard_user"), ConfigReader.getProperty("password"));
        home.verifySocialMediaLink("facebook", "facebook.com");
        home.verifySocialMediaLink("twitter", "x.com");
        home.verifySocialMediaLink("linkedin", "linkedin.com");
    }
}
