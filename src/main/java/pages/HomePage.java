package pages;

import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    WebDriver driver;
    @FindBy(className = "app_logo")
    WebElement sauceDemoTitle;

    @FindBy(className = "inventory_item_name")
    List<WebElement> productsTitle;

    @FindBy(className = "shopping_cart_badge")
    WebElement cartIcon;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean sauceDemoTitleIsDisplayed() {
        return sauceDemoTitle.isDisplayed();
    }

    public boolean isProductInHomePage(String productName){
        for(WebElement element : productsTitle){
            if(element.getText().equalsIgnoreCase(productName)){
                return true;
            }
        }
        return false;
    }

    public void addProductToCart(String productName){
        // add-to-cart-sauce-labs-bolt-t-shirt
        // sauce labs bolt t-shirt
        String productId = "add-to-cart-"+productName.replace(" ", "-").toLowerCase();
        WebElement productAddToCartButton = driver.findElement(By.id(productId));
        productAddToCartButton.click();
    }

    public boolean verifyCartIconNumber(String cartNumber){
        String actualCartNumber = cartIcon.getText();
        return actualCartNumber.equalsIgnoreCase(cartNumber);
    }

    public void removeProductFromCart(String productName){
        // remove-sauce-labs-bolt-t-shirt
        // sauce labs bolt t-shirt
        String productId = "remove-"+productName.replace(" ", "-").toLowerCase();
        WebElement removeProductButton = driver.findElement(By.id(productId));
        removeProductButton.click();
    }

    public void clickOnCartButton(){
        cartIcon.click();
    }

    public void clickOnProductName(String productName) {
        String productXpath = "//div[text()='"+productName+"']";
        WebElement productTitle = driver.findElement(By.xpath(productXpath));
        productTitle.click();
    }
    public void clickOnFilter(){
        Select sortDropdown = new Select(driver.findElement(By.className("product_sort_container")));
        sortDropdown.selectByValue("hilo");
    }
    public boolean verifyOrder(){
        List<WebElement> pricesElements = driver.findElements(By.className("inventory_item_price"));
        List<Double> prices = pricesElements.stream()
                .map(element -> Double.parseDouble(element.getText().replace("$", "")))
                .toList();

        boolean isSorted = true;
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) < prices.get(i + 1)) {
                isSorted = false;
                break;
            }
        }
        return isSorted;
    }
    public void clickOnFilterZtoA(){
        Select sortDropdown = new Select(driver.findElement(By.className("product_sort_container")));
        sortDropdown.selectByValue("za");
    }
    public boolean verifyOrderZtoA(){
        List<WebElement> productNames = driver.findElements(By.className("inventory_item_name"));

        List<String> actualProductsOrder = new ArrayList<>();

        for(WebElement element: productNames){
            actualProductsOrder.add(element.getText());
        }

        boolean isSorted = Ordering.natural().isOrdered(actualProductsOrder);
        return  isSorted;
    }

}
