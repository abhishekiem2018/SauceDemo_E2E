package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage extends BasePage {

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    private final By menuBtn = By.xpath("//button[@id='react-burger-menu-btn']");
    private final By logoutBtn = By.xpath("//a[@id='logout_sidebar_link']");
    private final By loginBtn = By.id("login-button");

    public void logout() {

        click(menuBtn);
        click(logoutBtn);
    }

    public boolean isLoginButtonDisplayed() {
        return isVisible(loginBtn);
    }
}