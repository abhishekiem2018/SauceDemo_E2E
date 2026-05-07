package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    private static WebDriver driver;
    public static WebDriver initDriver(String browser) {
//        WebDriverManager.chromedriver().setup();
//        return new ChromeDriver();
//        WebDriver driver = null;
        if ("Chrome".equalsIgnoreCase(browser)) {

            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless");
// Launch Chrome in Guest mode to avoid browser-level interruptions like:
// - "Change your password" popup
// - Password breach warnings - It was blocking my TC execution.
// - Saved password suggestions
// This ensures a clean browser session for automation execution.
            options.addArguments("--guest");   //
            options.addArguments("--window-size=1920,1200");
            options.addArguments("--disable-notifications");
            options.addArguments("--headless");
            Map<String, Object> prefs = new HashMap<>();
//            prefs.put("credentials_enable_service", false);
//            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);

            driver = new ChromeDriver(options);
        }

        else if ("Firefox".equalsIgnoreCase(browser)) {

            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            driver = new FirefoxDriver(options);
        }

        else if ("Edge".equalsIgnoreCase(browser)) {
            String projectRootPath = System.getProperty("user.dir");
            String driverPath = projectRootPath + File.separator
                    + "driver"
                    + File.separator
                    + "msedgedriver_142.exe";

            System.setProperty("webdriver.edge.driver", driverPath);

            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless");

            driver = new EdgeDriver(options);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        return driver;

    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver(){
        driver.quit();
        driver=null;
    }

}
