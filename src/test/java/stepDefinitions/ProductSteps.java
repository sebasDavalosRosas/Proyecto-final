package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.And;
import org.junit.jupiter.api.Assertions;
import pages.ProductPage;

public class ProductSteps {
    ProductPage productSteps = new ProductPage(DriverManager.getDriver().driver);
    @And("the product page of {string} should be displayed")
    public void verifyProductPage(String productName){
        Assertions.assertTrue( productSteps.produtNameIsDisplayed(productName));
    }

    @And("I click on add product button")
    public void clickOnAddProduct(){
        productSteps.ClickAddToCart();
    }

    @And("I return to home page")
    public void returnToHomePage(){
        productSteps.clickReturnToHomePage();
    }

    @And("I click on remove product button")
    public void clickOnRemoveButton() {
        productSteps.clickOnRemoveButton();
    }
}
