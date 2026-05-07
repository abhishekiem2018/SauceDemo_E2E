package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventoryPage extends BasePage {

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    By addToCartBtn = By.xpath("//button[text()='Add to cart']");
    By cartIcon = By.xpath("//a[@class='shopping_cart_link']");
    By filterDropdown = By.xpath("//select[@class='product_sort_container']");
    By productsName = By.xpath("//div[@class='inventory_item_name ']");
    By productPrice = By.xpath("//div[@class='inventory_item_price']");
    By removeBtn = By.xpath("//button[text()='Remove']");
    By cartBadge = By.xpath("//span[@class='shopping_cart_badge']");


    public void addItemToCart() {
        click(addToCartBtn);
    }

    public void goToCart() {
        click(cartIcon);
    }

    public void applyFilter(String value) {
        selectByText(filterDropdown, value);   // ✅ reusable dropdown
    }

    public void validateFilter(String value){
        if(value.equalsIgnoreCase("Name (A to Z)")){
            List<WebElement> products = driver.findElements(productsName);

// Step 1: Get actual product names
            List<String> actualList = new ArrayList<>();

            for (WebElement product : products) {
                actualList.add(product.getText().trim());
            }

// Step 2: Create a sorted copy
            List<String> sortedList = new ArrayList<>(actualList);
            Collections.sort(sortedList);  // A → Z

// Step 3: Compare
            Assert.assertEquals(actualList, sortedList, "Products are NOT sorted A → Z");
        }
        else if(value.equalsIgnoreCase("Name (Z to A)")){
            List<WebElement> products = driver.findElements(productsName);

// Step 1: Get actual product names
            List<String> actualList = new ArrayList<>();

            for (WebElement product : products) {
                actualList.add(product.getText().trim());
            }

// Step 2: Create a sorted copy (Z → A)
            List<String> sortedList = new ArrayList<>(actualList);
            Collections.sort(sortedList, Collections.reverseOrder());

// Step 3: Compare
            Assert.assertEquals(actualList, sortedList, "Products are NOT sorted Z → A");
        }
        else if(value.equalsIgnoreCase("Price (low to high)")){
            List<WebElement> priceElements = driver.findElements(productPrice);
// Step 1: Get actual prices
            List<Double> actualPrices = new ArrayList<>();

            for (WebElement price : priceElements) {
                String priceText = price.getText().replace("$", "").trim(); // remove $
                actualPrices.add(Double.parseDouble(priceText));
            }

// Step 2: Sort (Low → High)
            List<Double> sortedPrices = new ArrayList<>(actualPrices);
            Collections.sort(sortedPrices);

// Step 3: Validate
            Assert.assertEquals(actualPrices, sortedPrices, "Prices are NOT sorted Low → High");
        }
        else if(value.equalsIgnoreCase("Price (high to low)")){
            List<WebElement> priceElements = driver.findElements(productPrice);

// Step 1: Extract prices
            List<Double> actualPrices = new ArrayList<>();

            for (WebElement price : priceElements) {
                String priceText = price.getText().replace("$", "").trim();
                actualPrices.add(Double.parseDouble(priceText));
            }

// Step 2: Sort (High → Low)
            List<Double> sortedPrices = new ArrayList<>(actualPrices);
            Collections.sort(sortedPrices, Collections.reverseOrder());

// Step 3: Validate
            Assert.assertEquals(actualPrices, sortedPrices, "Prices are NOT sorted High → Low");
        }
    }
    public boolean isRemoveButtonDisplayed() {
        return isVisible(removeBtn);
    }
    public String getCartCount() {
        return getText(cartBadge);
    }
    public void clearCartIfItemsExist() {

        List<WebElement> removeButtons =
                driver.findElements(removeBtn);

        while (removeButtons.size() > 0) {

            highlightWebElement(removeButtons.get(0));
            removeButtons.get(0).click();
            removeButtons = driver.findElements(removeBtn);
        }
    }

}