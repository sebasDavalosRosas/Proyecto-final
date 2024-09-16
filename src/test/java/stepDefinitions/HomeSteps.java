package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.And;
import org.junit.jupiter.api.Assertions;
import pages.HomePage;

public class HomeSteps {
    HomePage homePage = new HomePage(DriverManager.getDriver().driver);

    @And("The home page should be displayed")
    public void verifyHomePageIsDisplayed(){
        Assertions.assertTrue(homePage.sauceDemoTitleIsDisplayed());
    }

    @And("The product {string} should be displayed in the home page")
    public void verifyProductIsDisplayed(String productName){
        Assertions.assertTrue(homePage.isProductInHomePage(productName));
    }

    @And("I add to the cart the product {string}")
    public void addProductToCart(String productName) {
        homePage.addProductToCart(productName);
    }

    @And("The cart icon should display {string}")
    public void verifyCartIconNumber(String iconNumber){
        Assertions.assertTrue(homePage.verifyCartIconNumber(iconNumber));
    }

    @And("I remove the product {string} from the cart")
    public void removeProductFromCart(String productName){
        homePage.removeProductFromCart(productName);
    }

    @And("I click on the cart button")
    public void clickOnCartIcon(){
        homePage.clickOnCartButton();
    }

    @And("i click on {string}")
    public void clickOnProductName(String productName){ homePage.clickOnProductName(productName);}

    @And("I select high to low on the filter")
    public void clickOnFilter(){homePage.clickOnFilter();}

    @And("The products should be in order from high to low")
    public void verifyOrderOfProducts(){
        Assertions.assertTrue(homePage.verifyOrder());
    }
    @And("I select Z to A on the filter")
    public void clickOnFilterZtoA(){homePage.clickOnFilter();}

    @And("The products should be in order from Z to A")
    public void verifyOrderOfProductsZtoA(){
        Assertions.assertTrue(homePage.verifyOrder());
    }
}
