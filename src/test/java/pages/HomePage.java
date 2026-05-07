package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    By facebookIcon = By.xpath("//a[text()='Facebook']");
    By twitterIcon = By.xpath("//a[text()='Twitter']");
    By linkedinIcon = By.xpath("//a[text()='LinkedIn']");

    public void verifySocialMediaLink (String site, String expectedUrlPart) {
        if(site.equalsIgnoreCase("facebook")){
            driver.findElement(facebookIcon).click();
        } else if (site.equalsIgnoreCase("twitter")) {
            driver.findElement(twitterIcon).click();
        } else if (site.equalsIgnoreCase("linkedin")) {
            driver.findElement(linkedinIcon).click();
        }

        String parent = driver.getWindowHandle();

        for (String window : driver.getWindowHandles()) {
            if (!window.equals(parent)) {
                driver.switchTo().window(window);
                break;
            }
        }

        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrlPart));
        driver.close();
        driver.switchTo().window(parent);
    }
}
