package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    By firstName = By.xpath("//input[@id='first-name']");
    By lastName = By.xpath("//input[@id='last-name']");
    By zip = By.xpath("//input[@id='postal-code']");
    By continueBtn = By.xpath("//input[@id='continue']");
    By finishBtn = By.xpath("//button[@id='finish']");
    By orderComplete = By.xpath("//h2[@class='complete-header']");
    By backToHomeBtn = By.xpath("//button[@id='back-to-products']");
    By errorMsg = By.xpath("//button[@class='error-button']//parent::h3");

    public void enterDetails(String f, String l, String z) {
        type(firstName, f);   // ✅ BasePage method
        type(lastName, l);
        type(zip, z);
    }

    public String completeOrder() {
        click(continueBtn);
        click(finishBtn);
        return getText(orderComplete);
    }
    public void clickContinue() {
        click(continueBtn);
    }

    public String errorMessage(){
        return getText(errorMsg);
    }

    public void navigateBackToHome(){
        click(backToHomeBtn);
    }
}