package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    JavascriptExecutor js = (JavascriptExecutor)driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // 🔹 Click
    public void click(By locator) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//        wait.until(ExpectedConditions.elementToBeClickable(locator));
//        highlightElement(locator);
//        driver.findElement(locator).click();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        highlightElement(locator);
        try {
            Thread.sleep(300); // small pause after highlight
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        element.click();
    }
    public void highlightElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].style.border='3px solid yellow'", element);
        js.executeScript("arguments[0].style.backgroundColor='yellow'", element);

    }

    public void highlightWebElement(WebElement locator) {
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].style.border='3px solid yellow'", locator);
        js.executeScript("arguments[0].style.backgroundColor='yellow'", locator);

    }
    // 🔹 Send Keys
    public void type(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();

        // CTRL + A then DELETE (more reliable than clear())
        element.sendKeys(Keys.CONTROL, "a");
        element.sendKeys(Keys.DELETE);

        element.sendKeys(text);
    }

    // 🔹 Get Text
    public String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    // 🔹 Is Visible
    public boolean isVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }
    // 🔹 Is not Visible

    public boolean isNotVisible(By locator) {
        try {
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (Exception e) {
            return false;
        }
    }

    // 🔹 Dropdown by Visible Text
    public void selectByText(By locator, String value) {
        Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
        select.selectByVisibleText(value);
    }

    // 🔹 Dropdown by Value
    public void selectByValue(By locator, String value) {
        Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
        select.selectByValue(value);
    }

    // 🔹 Wait for URL
    public void waitForUrlContains(String text) {
        wait.until(ExpectedConditions.urlContains(text));
    }
}