package pages;

import org.jsoup.select.Evaluator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductPage {
    WebDriver driver;
    @FindBy(xpath = "//div[@data-test = 'inventory-item-name']")
    WebElement itemName;
    @FindBy(id = "add-to-cart")
    WebElement addToCartButton;
    @FindBy(id = "back-to-products")
    WebElement backToProductsButton;
    @FindBy(id = "remove")
    WebElement removeButton;
    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean produtNameIsDisplayed(String productName){
        String productTittle = itemName.getText();
        return productTittle.equals(productName);
    }
    public void ClickAddToCart(){ addToCartButton.click();}
    public void clickReturnToHomePage()
    {
        backToProductsButton.click();
    }
    public void clickOnRemoveButton(){removeButton.click();}
}
