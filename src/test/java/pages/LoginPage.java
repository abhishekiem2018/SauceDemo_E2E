package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By username = By.xpath("//input[@id='user-name']");
    By password = By.xpath("//input[@id='password']");
    By loginBtn = By.xpath("//input[@id='login-button']");
    By errorMessage = By.xpath("//button[@class='error-button']//parent::h3");

    public void login(String user, String pass) {
        type(username, user);      // ✅ from BasePage
        type(password, pass);
        click(loginBtn);
    }

    public String errorMsg() {
        return getText(errorMessage);   // ✅ better than direct findElement
    }
}