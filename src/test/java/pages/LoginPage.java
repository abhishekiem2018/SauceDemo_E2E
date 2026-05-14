package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By username = By.xpath("//input[@id='user-name']");
    private final By password = By.xpath("//input[@id='password']");
    private final By loginBtn = By.xpath("//input[@id='login-button']");
    private final By errorMessage = By.xpath("//button[@class='error-button']//parent::h3");

    public void login(String user, String pass) {
        type(username, user);      // ✅ from BasePage
        type(password, pass);
        click(loginBtn);
    }

    public String errorMsg() {
        return getText(errorMessage);   // ✅ better than direct findElement
    }
}