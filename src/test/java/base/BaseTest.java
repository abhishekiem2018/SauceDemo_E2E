package base;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.MenuPage;
import utils.ConfigReader;
import utils.DriverFactory;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeMethod
    public void setup() {
        if (driver == null) {
            driver = DriverFactory.initDriver(ConfigReader.getProperty("browser"));
        }
            driver.manage().window().maximize();
            driver.get(ConfigReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        try {
            String methodName = result.getMethod().getMethodName();
            if (methodName.equals("empty_PasswordLogin")  //Logout not required for these tc
                    || methodName.equals("empty_UserNameLogin")
                    || methodName.equals("invalidLogin")
                    ||methodName.equals("lockedUserTest")) {
                System.out.println("Skipping AfterMethod for: " + methodName);
                return;
            }
            MenuPage menu = new MenuPage(driver);
            menu.logout();
            // ✅ Validate logout successful
            Assert.assertTrue(menu.isLoginButtonDisplayed());
            System.out.println("Successfully LoggedOut");

        } catch (Exception e) {

            System.out.println("Logout skipped or failed");
        }
//         🔥 If TC failed → close driver immediately
        if (result.getStatus() == ITestResult.FAILURE) {

            System.out.println("Test Failed - Closing Browser");

            if (driver != null) {

                driver.quit();
                driver = null;
            }
        }
    }

    @AfterSuite
    public void driverQuit() {
    driver.quit();
    driver = null;
    }
}