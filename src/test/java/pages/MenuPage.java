package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage extends BasePage {

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    By menuBtn = By.xpath("//button[@id='react-burger-menu-btn']");
    By logoutBtn = By.xpath("//a[@id='logout_sidebar_link']");
    By loginBtn = By.id("login-button");

    public void logout() {

        click(menuBtn);
        click(logoutBtn);
    }

    public boolean isLoginButtonDisplayed() {
        return isVisible(loginBtn);
    }
}