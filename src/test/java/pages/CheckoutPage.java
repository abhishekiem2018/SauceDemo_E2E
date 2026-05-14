package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private final By firstName = By.xpath("//input[@id='first-name']");
    private final By lastName = By.xpath("//input[@id='last-name']");
    private final By zip = By.xpath("//input[@id='postal-code']");
    private final By continueBtn = By.xpath("//input[@id='continue']");
    private final By finishBtn = By.xpath("//button[@id='finish']");
    private final By orderComplete = By.xpath("//h2[@class='complete-header']");
    private final By backToHomeBtn = By.xpath("//button[@id='back-to-products']");
    private final By errorMsg = By.xpath("//button[@class='error-button']//parent::h3");

    public void enterDetails(String f, String l, String z) {
        type(firstName, f);
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